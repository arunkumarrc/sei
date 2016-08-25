import java.util.*;
import java.util.logging.Logger;

/**
 * Created by Arunkumar Rangasamy on 8/24/2016.
 */
public class RemoveDuplicates {

    //private final static Logger logger = Logger.getLogger(RemoveDuplicates.class);

    public static void main(String args[]) {

        int[] randomIntegers = {1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18, 4, 9, 3,
                20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11};
        // int[] randomIntegers = {};
        try {
            System.out.println("Using LinkedHashSet : " + removeDuplicate(randomIntegers));
            System.out.println("Using HashSet  : " + removeDuplicateHashSet(randomIntegers));
            System.out.println("Using Brute Force  : " + compareAndRemoveDuplicate(randomIntegers));
            System.out.println("Using QuickSort : " + sortAndRemoveDuplicates(randomIntegers));

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    // Overall Complexity of the function is O(n) where n is the number of array elements. O(n) + O(n) is O(n)
    private static List<Integer> removeDuplicate(int[] randomInteger) {
        List<Integer> output = new ArrayList();
        if (randomInteger.length == 0)
            return output;
        Set<Integer> set = new LinkedHashSet();
        for (int i = 0; i < randomInteger.length; i++) { // Iterating over all the elements is O(n)
            set.add(randomInteger[i]); //Inserting into set is O(1) average case.
        }
        // Adding the Set elements to the ArrayList
        //Instead of iterating, we can also use the inbuilt method which does the same thing.
        // List<Integer> output = new ArrayList(set);
        for (Integer num : set) { // Complexity is O(n)
            output.add(num); // ArrayList will preseve the order.
        }
        return output;
    }

    // Complexity of the function is O(n log n) . Quick Sort takes O(n log n ) in average case. no Extra space except for the output
    // list which is common since we are returning a new list which doesn't have duplicate elements.
    private static List<Integer> sortAndRemoveDuplicates(int[] randomInteger) {
        List<Integer> output = new ArrayList();
        if (randomInteger.length == 0)
            return output;
        Arrays.sort(randomInteger); // In java it uses dual pivot quick sort which is O(n log n ) in almost all the cases.
        //Worst case is O(n^2). QuickSort doesnt require extra space to sort. QuickSort is an inPlace algorithm.
        output.add(randomInteger[0]);
        // Code to remove duplicate in the sorted array. Complexity O(n).
        // O(n) for removing duplicates + O(n log n) for Sorting = O(n log n) overall complexity of the function.
        int i = 0;
        int j = 1;
        while (j < randomInteger.length) {
            if (randomInteger[i] != randomInteger[j]) {
                output.add(randomInteger[j++]);
                i++;
            } else {
                j++;
                i++;
            }
        }
        return output;
    }

    // Overall Complexity of the function is O(n) where n is the number of array elements. O(n) + O(n) is O(n)
    private static List<Integer> removeDuplicateHashSet(int[] randomInteger) {
        List<Integer> output = new ArrayList();
        Set<Integer> set = new HashSet();
        for (int i = 0; i < randomInteger.length; i++) { // Iterating over all the elements is O(n)
            set.add(randomInteger[i]); //Inserting into set is O(1) average case.
        }
        // Adding the Set elements to the ArrayList
        //Instead of iterating, we can also use the inbuilt method which does the same thing.
        // List<Integer> output = new ArrayList(set);
        for (Integer num : set) { // Complexity is O(n)
            output.add(num); // ArrayList will preseve the order.
        }
        return output;
    }

    // brute force algorithm. We compare each element with other elements. run time complexity is O(n^2). Order is preserved.
    // No extra space.
    private static List<Integer> compareAndRemoveDuplicate(int[] randomIntegers) {
        List<Integer> output = new ArrayList();
        for (int i = 0; i < randomIntegers.length; i++) {
            boolean seen = false;
            for (int j = i - 1; j >= 0; j--) {
                if (randomIntegers[i] == randomIntegers[j]) {
                    seen = true;
                    break;
                }
            }
            if (!seen)
                output.add(randomIntegers[i]);
        }
        return output;
    }
}