import java.util.concurrent.TimeUnit;

public class MainClass {

    /**
     * Doing homework number 2
     */

    public static long startTime;
    public static long getTime;

    public static void main(String[] args) {

        Array<Integer> array = new ArrayImpl<>();
        Array<Integer> arraySecond;
        Array<Integer> arrayThird;


        //Create an array of large size
        for (int i = 0; i < 10000; i++) {
            int a;

            do {
                a = (int) (Math.random() * 100);
            } while (a == 5 || a == 15);

            array.add(a);
        }

        arraySecond = array;
        arrayThird = array;

        System.out.println("Original: " + array);
        System.out.println("Second: " + arraySecond);
        System.out.println("Third: " + arrayThird);

        //Write methods for removing, adding, searching for an element of an array.

        array.add(5);
        array.add(15);
        System.out.println("Add 5 & 15: " + array);

        array.remove(5);
        System.out.println("Search & remove 5: " + array);


        //Write methods that implement the considered types of sorts, and check the speed of each.

        startTime();
        array.sortBubble();
        System.out.println("Sort Bubble: " + array);
        getTime(startTime);

        startTime();
        array.sortInsert();
        System.out.println("Sort Insert: " + arraySecond);
        getTime(startTime);

        startTime();
        array.sortSelect();
        System.out.println("Sort Select: " + arrayThird);
        getTime(startTime);
    }

    public static void startTime(){
        startTime = System.nanoTime();
        TimeUnit.NANOSECONDS.toMillis(startTime);
    }

    public static void getTime(long startTime){
        getTime = System.nanoTime();
        TimeUnit.NANOSECONDS.toMillis(getTime);
        getTime = getTime - startTime;
        System.out.println("Lead time: " + getTime);
    }
}
