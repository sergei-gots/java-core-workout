package pro.sky.java.playground;

import static pro.sky.java.util.ColorService.*;


import java.util.*;
import java.util.List;

public class L_2_5_CollectionsAndMaps {
    public static void main(String[] args) {
        tip();
        lists();
        arraysAndArrayLists();
        maps();
        sets();
    }

    private static void lists() {
        printTitleInColor("Lists: ");
        printClassNameInColor("LinkedList<E>\n");

        List<String> list = new LinkedList(List.of("1", "2", "3"));
        System.out.println("list = " + list);
        System.out.println("list.remove(new String(\"2\")) = " + list.remove(new String("2")));
        System.out.println("list = " + list);

        System.out.println();
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


    private static void sets() {
        printInterfaceNameInColor("Set\n");
        printInterfaceNameInColor("Set<E> ");
        print("is a ");
        printInterfaceNameInColor("Collection ");
        print("that includes only ");
        printTermInColor("UNIQUE ");
        print("items.\n\n");

        printServiceWordsInColor("public class ");
        printClassNameInColor("HashSet<E> ");
        printServiceWordsInColor("extends ");
        printClassNameInColor("AbstractSet<E> ");
        printServiceWordsInColor("\n\t\timplements ");
        printInterfaceNameInColor("Set<E>, Cloneable, java.io.Serializable\n\n");


        printServiceWordsInColor("\t\tpublic abstract class ");
        printClassNameInColor("AbstractSet<E> ");
        printServiceWordsInColor("extends ");
        printClassNameInColor("AbstractCollection<E> ");
        printServiceWordsInColor("\n\t\t\t\timplements ");
        printInterfaceNameInColor("Set<E> ");
        printServiceWordsInColor("{\n\tprivate transient ");
        printClassNameInColor("HashMap<E,Object> ");
        printTermInColor(" map = ");
        printServiceWordsInColor("new ");
        printClassNameInColor("HashMap();");
        printServiceWordsInColor("\n}\n\n");

        print("So that ");
        printClassNameInColor("HashSet<E> ");
        print("just has field ");
        printTermInColor("map ");
        print("of ");
        printClassNameInColor("HashMap(<E>, Object) ");
        print("(or ");
        printClassNameInColor("LinkedHashMap(<E>, Object)");
        print(") and in this hashmap as value each time will be used DUMMY ");
        printTermInColor("final static Object PRESENT = new Object();\n\n");

        Set<Integer> integers = new HashSet<>();
        System.out.println("integers.add(1) = " + integers.add(1));
        System.out.println("integers.contains(1) = " + integers.contains(1));
        System.out.println("integers.contains(2) = " + integers.contains(2));
        System.out.println("integers.add(1) = " + integers.add(1));
        System.out.println();
        
        Set<Integer> integersSet = new HashSet<>(List.of(1,2,3));
        System.out.println("Set<Integer> integersSet = new HashSet<>(List.of(1,2,3));");
        System.out.println("integersSet.add(4) = " + integersSet.add(4));
        System.out.println("integersSet = " + integersSet);
    }
    private static void maps() {
        printInterfaceNameInColor("Map\n");

        printInterfaceNameInColor("Map<K,V>");
            print(" is the ");
            printInterfaceNameInColor("Map<K,V> ");
            print(" and ");
            printWarningnInColor("not a ");
            printInterfaceNameInColor("Collection<E>\n");
            print("and so that we use method ");
            printTermInColor("put(key, value)");
            print(" instead of ");
            printTermInColor("add(value)\n\n");

        printTermInColor("<Key>");
        print("-class should be better represented with immutable one - like  ");
        printClassNameInColor("String, Integer");
        print(", ... etc.\n\n");


        print("public class ");
            printClassNameInColor("HashMap<K,V>");
            print(" extends ");
            printClassNameInColor("AbstractMap<K,V>\n");
            print("\t\t\t implements ");
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
        printClassNameInColor("HashMap ");
        System.out.print(" is sometimes called as ");
        printTermInColor("an associative array");
        System.out.print(".\n\n");


        Map<String, Integer> immutableNumbersMap = Map.of("zero", 0, "one", 1,
                "two", 2, "three", 3, "four", 4,
                "five", 5, "six", 6, "seven", 7,
                "eight", 8, "nine", 9);
        try {
            print("Let's try to ");
            printTermInColor("put ");
            print("a new item to our ");
            printTermInColor("created as immutable with (Map.of(...)) Map:\n");
            print("immutableNumbersMap.put(\"ten\", 10)\n");
            immutableNumbersMap.put("ten", 10);
        } catch (UnsupportedOperationException e) {
            printWarningnInColor("we got an Exception e = " + e);
            print("\n\n");
        }

        Map<String, Integer> mutableNumbersMap = new HashMap<>(immutableNumbersMap);
        System.out.println("mutableNumbersMap.put(\"ten\", 10) = " + mutableNumbersMap.put("ten", 10));
        System.out.println("mutableNumbersMap = " + mutableNumbersMap);
        printTitleInColor("When we put a new value with the already existed key, the value in map under this key will be changed to a new one.\n");
        printTitleInColor("Note that method put will return previous existing value.\n");
        System.out.println("mutableNumbersMap.put(\"ten\", 11) = " + mutableNumbersMap.put("ten", 11));
        System.out.println("mutableNumbersMap = " + mutableNumbersMap);
        print("\n\n");
        
        Map <String, String> phoneBook = new HashMap<>(Map.of("Office", "2-10-85", "Buddy", "2-14-39", "Boss", "2-16-33"));
        System.out.println("phoneBook = " + phoneBook);
        System.out.println("phoneBook.put(\"Office\", \"3-28-01\") = " + phoneBook.put("Office", "3-28-01"));
        printTermInColor("//i.e. here previously existed value for this key was returned.\n");
        System.out.println("phoneBook = " + phoneBook);
        System.out.println("phoneBook.get(\"Office\") = " + phoneBook.get("Office"));
        System.out.println("phoneBook.get(\"Shop\") = " + phoneBook.get("Shop"));
        System.out.println("phoneBook.remove(\"Shop\") = " + phoneBook.remove("Shop"));
        System.out.println("phoneBook.remove(\"Boss\") = " + phoneBook.remove("Boss"));
        System.out.println("phoneBook.containsKey(\"Boss\") = " + phoneBook.containsKey("Boss"));
        printTermInColor("Implementation of the method ");
        printInterfaceNameInColor("Map.containsValue(Object key) ");
        printTermInColor("traditionally uses iteration over all the values\n");
        printTermInColor("=> has linear complexity \n ");
        printTermInColor("=> It is not recommended for regular use:\n");
        System.out.println("phoneBook.containsValue(\"3-28-01\") = " + phoneBook.containsValue("3-28-01"));
        System.out.println("phoneBook = " + phoneBook);

        printTermInColor("\nTo iterate though map we should reduce our ");
        printInterfaceNameInColor("Map ");
        printTermInColor("to some ");
        printInterfaceNameInColor("Iterable :\n");
        System.out.println("phoneBook.entrySet() = " + phoneBook.entrySet());

        System.out.println("for(Map.Entry<String, String> entry : phoneBook.entrySet())");
        for(Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println("\tContact: entry.getKey(), entry.getValue() : " +
                    entry.getKey() + ", " + entry.getValue());
        }

        print("\n");

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new TreeMap<>();
        Map<String, Integer> map3 = new LinkedHashMap<>();

        print("Method which returns ");
        printInterfaceNameInColor("Collection <V> ");
        print("is ");
        printTermInColor("values()\n");

        print("Method which returns ");
        printInterfaceNameInColor("Set<Entry<K,V> ");
        print("is ");
        printTermInColor("entrySet()\n\n");

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
