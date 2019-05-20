public class MainClass {

    /**
     * Doing homework number 2
     */

    public static long startTime;
    public static long getTime;

    public static void main(String[] args) {

        Array<Integer> array = new ArrayImpl<>();


        //Create an array of large size (a million items).
        for (int i = 0; i < 1000000; i++) {
            int a;

            do {
                a = (int) (Math.random()*100);
            }while (a == 5 || a == 15);

            array.add(a);
        }

        System.out.println("Original: " + array);

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
        System.out.println("Sort Insert: " + array);
        getTime(startTime);

        startTime();
        array.sortSelect();
        System.out.println("Sort Select: " + array);
        getTime(startTime);
    }

    public static void startTime(){
        startTime = System.currentTimeMillis();
    }

    public static void getTime(long startTime){
        getTime = System.currentTimeMillis() - startTime;
        System.out.println("Lead time: " + getTime);
    }
}
