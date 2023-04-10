package pro.sky.java.playground;

import static pro.sky.java.util.ColorService.*;


import java.util.*;
import java.util.List;

public class L_2_5_CollectionsAndSets {
    public static void main(String[] args) {
        tip();
        arraysAndArrayLists();
        maps();
    }

    private static void tip() {
        System.out.print("Symbols ");
        printTermInColor("< >");
        System.out.print(" are called ");
        printTermInColor("ANGLE BRACKETS");
        System.out.print(" or ");
        printTermInColor("SHEVRONES");
        System.out.println("\n");
    }

    private static void maps() {
        printHeaderInColor("Map\n");

        Map<String, Integer> numbersMap = new HashMap<>();

        printTermInColor("Map<K,V>");
        System.out.print(" in the ");
        printInterfaceNameInColor("Map<K,V>");
        System.out.print(" and not a ");
        printInterfaceNameInColor("Colllection<E>\n");
        System.out.print("and so that we use method ");
        printTermInColor("put(key, value)");
        System.out.print(" instead of ");
        printTermInColor("add(value)");
        numbersMap.put("one", 1);
    }

    private static void arraysAndArrayLists() {
        printInColor("Array and ArrayList impl List\n", ANSI_YELLOW);
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
        printInterfaceNameInColor("Collection<E>");
        System.out.println("\n\t\tabstract class AbstractCollection<E>");
        System.out.println("\t\tinterface List<E>");
        System.out.println("\t\t\tabstract class AbstractList<E>");
        System.out.println("\t\t\tinterface List<E>");
        System.out.println("\t\t\tinterface RandomAccess");
        System.out.println("\t\t\tinterface Clonable");
        System.out.println("\t\t\tinterface io.Clonable");
        System.out.print("\t\t\t\t class ");
        printClassNameInColor("ArrayList <E>\n\n");

     }
}
