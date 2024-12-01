import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ListOperations {
    public static List<Integer> arrayToList(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int num : arr) {
            result.add(num);
        }
        return result;
    }
    public static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.println(num);
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
        for (int num : list) {
            if (num % 2 == 0) {
                System.out.println(num);
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
    }
}
