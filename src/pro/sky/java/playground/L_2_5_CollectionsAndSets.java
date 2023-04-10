package pro.sky.java.playground;

import static pro.sky.java.util.ColorService.*;


import java.io.Serializable;
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
        printTermInColor("СHEVRON");
        System.out.println("\n");
    }

    private static void maps() {
        printTitleInColor("Map\n");

        printInterfaceNameInColor("Map<K,V>");
        System.out.print(" is the ");
        printInterfaceNameInColor("Map<K,V>");
        System.out.print(" and ");
        printWarningnInColor("not a ");
        printInterfaceNameInColor("Collection<E>\n");
        System.out.print("and so that we use method ");
        printTermInColor("put(key, value)");
        System.out.print(" instead of ");
        printTermInColor("add(value)\n\n");

        System.out.print("public class ");
        printClassNameInColor("HashMap<K,V>");
        System.out.print(" extends ");
        printClassNameInColor("AbstractMap<K,V>\n");
        System.out.print("\t\t\t implements ");
        printInterfaceNameInColor("Map<K,V>, Cloneable, Serializable\n\n");

        Map<String, Integer> numbersMap = new HashMap<>();

        numbersMap.put("one", 1);
        numbersMap.put("two", 2);
        numbersMap.put("three", 3);

        System.out.println("numbersMap = " + numbersMap);
        System.out.println("numbersMap.get(\"two\") = " + numbersMap.get("two"));
        System.out.println("numbersMap.size() = " + numbersMap.size());

        printTermInColor("\nOnce again:) ");
        printInterfaceNameInColor("Map ");
        System.out.print("is a ");
        printInterfaceNameInColor("Map ");
        System.out.print("and ");
        printWarningnInColor("not a ");
        printInterfaceNameInColor("Collection");
        System.out.print(".\n\n");
        printInterfaceNameInColor("Map ");
        System.out.print("doesn't have any begin and any end. It's like a cloud. It's... just a ");
        printInterfaceNameInColor("Map");
        System.out.print(":-)\n\n");


        Map<String, Integer> immutableNumbersMap = Map.of("zero", 0, "one", 1,
                "two", 2, "three", 3, "four", 4,
                "five", 5, "six", 6, "seven", 7,
                "eight", 8, "nine", 9);
        try {
            System.out.println("immutableNumbersMap.put(\"ten\", 10) = " + immutableNumbersMap.put("ten", 10));
        } catch (UnsupportedOperationException e) {
            System.out.println("e = " + e);
            e.printStackTrace();
        }

        Map<String, Integer> mutableNumbersMap = new HashMap<>(immutableNumbersMap);
        System.out.println("mutableNumbersMap.put(\"ten\", 10) = " + mutableNumbersMap.put("ten", 10));
        System.out.println("mutableNumbersMap = " + mutableNumbersMap);
        printTitleInColor("When we put a new value with the already existed key, the value in map under this key will be changed to a new one.\n");
        printTitleInColor("Note that method put will return previous existing value.\n");
        System.out.println("mutableNumbersMap.put(\"ten\", 11) = " + mutableNumbersMap.put("ten", 11));
        System.out.println("mutableNumbersMap = " + mutableNumbersMap);
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
