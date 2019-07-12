package Lesson5.homework;

import java.util.ArrayList;
import java.util.List;

public class Main {
public static void main(String[] args) {
        // backpack
        List<Item> list = new ArrayList<>();
        list.add(new Item("Book",   1, 600));
//        list.add(new Item("Book2",   1, 600));
        list.add(new Item("Binoculars", 2, 5000));
        list.add(new Item("First AID kit", 4, 1500));
        list.add(new Item("Notepad", 2, 40000));
        list.add(new Item("Bowler", 1, 500));


        Backpack backpack = new Backpack(25);
        backpack.calcBestSet(list);

        list = backpack.getBestSet();


        for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i).name + " " + list.get(i).price);
        }

        System.out.println("Total best price is " + backpack.getBestPrice());
        System.out.println("Count:" + backpack.count);
        }

        }
