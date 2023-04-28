package pro.sky.course_2_core;

import pro.sky.util.Homework;

import java.util.*;


public class hw_2_5_CollectionsAndMaps implements Homework {

    public final String tongueTwister =
            "Peter Piper picked a peck of pickled peppers " +
                    "A peck of pickled peppers Peter Piper picked " +
                    "If Peter Piper picked a peck of pickled peppers " +
                    "Where’s the peck of pickled peppers Peter Piper picked";

    public static void main(String[] args) {
        Homework hw = new hw_2_5_CollectionsAndMaps();
        hw.homework();
    }

    @Override
    public void homework() {
        printTitle("Homework 2.5 \"Collections and Maps\"");

        List<Integer> numbers = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        printOddNumbers(numbers);

        numbers = new ArrayList<>(List.of(2, 1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        printUniqueEvenNumbersSortedAscending(numbers);

        printUniqueWordsFromSequence(tongueTwister);

        List<String> strings = new ArrayList<>(List.of("один", "один", "два", "два", "два", "три", "три", "три"));
        printWordsCountsForSequence(strings);

        System.out.println();
    }

    private void printOddNumbers(List<Integer> numbers) {
        printTaskHeader("Task #1: print to console all the odd numbers from a given sequence of numbers: ");
        System.out.println("numbers = " + numbers);
        System.out.print("All the odd numbers = [");
        boolean found = false;
        for (int k : numbers) {
            if (k % 2 != 0) {
                System.out.print(k);
                System.out.print(", ");
                found = true;
            }
        }
        if (found) {
            System.out.print("\b\b");
        }
        System.out.print("]\n");
    }

    private void printUniqueEvenNumbersSortedAscending(List<Integer> numbers) {
        printTaskHeader("Task #2: print to console only unique even numbers sorted ascending from a given sequence of numbers: ");
        System.out.println("numbers = " + numbers);
        TreeSet<Integer> set = new TreeSet<>(numbers);
        System.out.println("sorted and unique numbers (converted in a form of class TreeSet<Integer> = " + set);
        System.out.print("even numbers out there are: [");
        boolean found = false;
        for (int k : set) {
            if (k % 2 == 0) {
                System.out.print(k);
                System.out.print(", ");
                found = true;
            }
        }
        if (found) {
            System.out.print("\b\b");
        }
        System.out.print("]\n");
    }

    private void printUniqueWordsFromSequence(String text) {
        printTaskHeader("Task #3: print to console unique words extracted from a given text sequence: ");
        System.out.println("Text is:\n\"" + text + '"');
        String[] words = text.split("\\W+");
        Set<String> set = new HashSet<>(List.of(words));
        System.out.println("The words set  = " + set);
    }

    private void printWordsCountsForSequence(List<String> strings) {
        printTaskHeader("Task #4: output to the console entries counters for each word from the sequence dictionary:");
        System.out.println("Words sequence is " + strings + '.');
        Set<String> set = new HashSet<>(strings);
        System.out.println("Words frequencies are:");
        for (String s : set) {
            System.out.println(s + ":\t\t" + Collections.frequency(strings, s));
        }
    }

}
