import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class MainClass {

    /**
     * Doing homework number 2:
     * 1. Create an array of large size.
     * 2. Write methods for removing, adding, searching for an element of an array.
     * 3. Fill the array with random numbers.
     * 4. Write methods that implement the considered types of sorts, and check the speed of each.
     */

    private static final int ARRAY_CAPACITY = 10000;

    public static final int MAX_VALUE = 10000;

    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {

        Supplier<Array> constructor = ArrayImpl::new;

        Array arr1 = createArray(constructor);
        Array arr2 = createArray(constructor);
        Array arr3 = createArray(constructor);

        randomInitialize(arr1,arr2,arr3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        /**
         * That's don't work on JDK 1.8.2, just on JDK 9 and upper.
         */
//         List<Runnable> tasks = List.of(
//            measureTime(arr1::sortBubble,"Sort Bubble"),
//            measureTime(arr2::sortSelect,"Sort Select"),
//            measureTime(arr3::sortInsert,"Sort Insert")
//        );

        System.out.println("Original Arr1: " + arr1);
        System.out.println("Original Arr2: " + arr2);
        System.out.println("Original Arr3: " + arr3 + "\n");

         List tasks = new ArrayList<Runnable>();
         tasks.add(measureTime(arr1::sortBubble,"Sort Bubble"));
         tasks.add(measureTime(arr2::sortSelect,"Sort Select"));
         tasks.add(measureTime(arr3::sortInsert,"Sort Insert"));

        for(Object task : tasks){
            executorService.execute((Runnable) task);
        }

        executorService.shutdown();
        executorService.awaitTermination(1,TimeUnit.MINUTES);

        System.out.println("\nFinished Arr1: " + arr1);
        System.out.println("Finished Arr2: " + arr2);
        System.out.println("Finished Arr3: " + arr3);

    }

    private static void randomInitialize(Array... arrays) {
        Random random = new Random();

        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            int value = random.nextInt(MAX_VALUE);
            for(Array array : arrays){
                array.add(value);
            }

        }
    }

    private static Runnable measureTime(Runnable action, String actionName){
        return () -> {
            long startTime = System.nanoTime();
            action.run();
            long finishTime = System.nanoTime();
            long duration = finishTime - startTime;

            System.out.println(String.format("%s took time: %d ms.",
                    actionName,
                    TimeUnit.NANOSECONDS.toMillis(duration)));
        };
    }

    private static Array createArray(Supplier<Array> factory) {
        return  factory.get();
    }

}