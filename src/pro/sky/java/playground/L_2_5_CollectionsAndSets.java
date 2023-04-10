package pro.sky.java.playground;

import pro.sky.java.util.BasicService;
import pro.sky.java.util.ColorService;

import java.awt.*;
import java.util.*;
import java.util.List;

public class L_2_5_CollectionsAndSets {
    public static void main(String[] args) {
        arraysAndArrayLists();
    }

    private static void arraysAndArrayLists() {
        Integer[] numbersArray = { 1, 2, 3 };
        List<Integer> numbersList = new ArrayList<> (Arrays.asList(9, 3, 2));

        final Integer num1 = numbersArray[0];
        final Integer num2 = numbersList.get(0);

        numbersArray[0] = 4;
        numbersList.set(0, 10);

        final int arrayLength = numbersArray.length;
        final int listLength = numbersList.size();

        String arrayAsString = Arrays.toString(numbersArray);
        String listAsString = numbersList.toString();
        System.out.println("Arrays.toString(numbersArray) = " + arrayAsString);
        System.out.println("numbersList.toString() = " + listAsString);
        System.out.println();

        try {
            numbersArray[4] = 4;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage()+ '\n');
        }
        numbersList.add(4);

        System.out.println("array: " + arrayAsString);
        System.out.println("list:" + numbersList);

        System.out.println("\ninterface Iterable<T>");
        System.out.print("\tinterface ");
        ColorService.printInColor("Collection<E>", ColorService.ANSI_GREEN);
        System.out.println("\n\t\tabstract class AbstractCollection<E>");
        System.out.println("\t\tinterface List<E>");
        System.out.println("\t\t\tabstract class AbstractList<E>");
        System.out.println("\t\t\tinterface List<E>");
        System.out.println("\t\t\tinterface RandomAccess");
        System.out.println("\t\t\tinterface Clonable");
        System.out.println("\t\t\tinterface io.Clonable");
        System.out.print("\t\t\t\t class ");
        ColorService.printInColor("ArrayList <E>\n", ColorService.ANSI_CYAN);

     }
}
