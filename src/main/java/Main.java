import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperations {

    public static List<Integer> convertArrayToList(int[] arr) {
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

    public static void printListInReverse(List<Integer> list) {
        printListInReverseHelper(list, list.size() - 1);
    }

    private static void printListInReverseHelper(List<Integer> list, int index) {
        if (index >= 0) {
            System.out.println(list.get(index));
            printListInReverseHelper(list, index - 1);
        }
    }

    public static List<Integer> getNumbersFromUser() {
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

    public static boolean isNumberInList(List<Integer> list, int num) {
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

    public static boolean areAllElementsInList(List<Integer> L1, List<Integer> L2) {
        return areAllElementsInListHelper(L1, L2, 0);
    }

    private static boolean areAllElementsInListHelper(List<Integer> L1, List<Integer> L2, int index) {
        if (index == L1.size()) {
            return true;
        }
        if (!L2.contains(L1.get(index))) {
            return false;
        }
        return areAllElementsInListHelper(L1, L2, index + 1);
    }

    public static void printCommonElements(List<Integer> L1, List<Integer> L2) {
        for (int i = 0; i < L1.size(); i++) {
            if (L2.contains(L1.get(i))) {
                System.out.println(L1.get(i));
            }
        }
    }

    public static List<Integer> getCommonElements(List<Integer> L1, List<Integer> L2) {
        List<Integer> commonList = new ArrayList<>();
        for (int i = 0; i < L1.size(); i++) {
            if (L2.contains(L1.get(i))) {
                commonList.add(L1.get(i));
            }
        }
        return commonList;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> list = convertArrayToList(arr);

        printList(list);
        printListInReverse(list);

        List<Integer> inputList = getNumbersFromUser();
        printList(inputList);

        printEvenNumbers(list);

        System.out.println(isNumberInList(list, 3));

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

        System.out.println(areAllElementsInList(L1, L2));

        printCommonElements(L1, L2);

        List<Integer> commonValues = getCommonElements(L1, L2);
        printList(commonValues);
    }
}
