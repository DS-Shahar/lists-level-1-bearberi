import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperations {

    public static List<Integer> arrayToList(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void printListReverse(List<Integer> list) {
        printListReverseHelper(list, list.size() - 1);
    }

    private static void printListReverseHelper(List<Integer> list, int index) {
        if (index >= 0) {
            System.out.println(list.get(index));
            printListReverseHelper(list, index - 1);
        }
    }

    public static List<Integer> getInputList() {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true) {
            num = scanner.nextInt();
            if (num == -1) break;
            list.add(num);
        }
        return list;
    }

    public static void printEvenNumbers(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                System.out.println(list.get(i));
            }
        }
    }

    public static boolean containsNumber(List<Integer> list, int num) {
        return list.contains(num);
    }

    public static List<Integer> removeFirstOccurrence(List<Integer> list, int num) {
        list.remove(Integer.valueOf(num));
        return list;
    }

    public static List<Integer> removeAtIndex(List<Integer> list, int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        }
        return list;
    }

    public static boolean containsAll(List<Integer> L1, List<Integer> L2) {
        return containsAllHelper(L1, L2, 0);
    }

    private static boolean containsAllHelper(List<Integer> L1, List<Integer> L2, int index) {
        if (index == L1.size()) {
            return true;
        }
        if (!L2.contains(L1.get(index))) {
            return false;
        }
        return containsAllHelper(L1, L2, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> list = arrayToList(arr);

        printList(list);
        printListReverse(list);

        List<Integer> inputList = getInputList();
        printList(inputList);

        printEvenNumbers(list);

        System.out.println(containsNumber(list, 3));

        List<Integer> newList = removeFirstOccurrence(list, 3);
        printList(newList);

        newList = removeAtIndex(list, 2);
        printList(newList);

        List<Integer> L1 = new ArrayList<>();
        L1.add(1);
        L1.add(2);
        L1.add(3);

        List<Integer> L2 = new ArrayList<>();
        L2.add(1);
        L2.add(2);
        L2.add(3);
        L2.add(4);
        L2.add(5);

        System.out.println(containsAll(L1, L2));
    }
}
