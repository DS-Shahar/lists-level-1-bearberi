import java.util.Scanner;

public class NodeOperations {

    public static Node<Integer> convertArrayToList(int[] arr) {
        Node<Integer> head = null;
        Node<Integer> current = null;
        for (int i = 0; i < arr.length; i++) {
            Node<Integer> newNode = new Node<>(arr[i]);
            if (head == null) {
                head = newNode;
                current = head;
            } else {
                current.setNext(newNode);
                current = newNode;
            }
        }
        return head;
    }

    public static void printList(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public static void printListInReverse(Node<Integer> head) {
        printListInReverseHelper(head);
    }

    private static void printListInReverseHelper(Node<Integer> node) {
        if (node != null) {
            printListInReverseHelper(node.getNext());
            System.out.println(node.getValue());
        }
    }

    public static Node<Integer> getNumbersFromUser() {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> head = null;
        Node<Integer> current = null;
        int num;
        while ((num = scanner.nextInt()) != -1) {
            Node<Integer> newNode = new Node<>(num);
            if (head == null) {
                head = newNode;
                current = head;
            } else {
                current.setNext(newNode);
                current = newNode;
            }
        }
        return head;
    }

    public static void printEvenNumbers(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            if (current.getValue() % 2 == 0) {
                System.out.println(current.getValue());
            }
            current = current.getNext();
        }
    }

    public static boolean isNumberInList(Node<Integer> head, int num) {
        Node<Integer> current = head;
        while (current != null) {
            if (current.getValue() == num) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public static Node<Integer> removeFirstOccurrence(Node<Integer> head, int num) {
        if (head == null) return null;
        if (head.getValue() == num) {
            return head.getNext();
        }

        Node<Integer> current = head;
        while (current.getNext() != null && current.getNext().getValue() != num) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
        return head;
    }

    public static Node<Integer> removeAtIndex(Node<Integer> head, int index) {
        if (head == null || index < 0) return head;
        if (index == 0) return head.getNext();

        Node<Integer> current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) return head;
            current = current.getNext();
        }

        if (current != null && current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
        return head;
    }

    public static boolean areAllElementsInList(Node<Integer> L1, Node<Integer> L2) {
        Node<Integer> current1 = L1;
        while (current1 != null) {
            if (!isNumberInList(L2, current1.getValue())) {
                return false;
            }
            current1 = current1.getNext();
        }
        return true;
    }

    public static void printCommonElements(Node<Integer> L1, Node<Integer> L2) {
        Node<Integer> current1 = L1;
        while (current1 != null) {
            if (isNumberInList(L2, current1.getValue())) {
                System.out.println(current1.getValue());
            }
            current1 = current1.getNext();
        }
    }

    public static Node<Integer> getCommonElements(Node<Integer> L1, Node<Integer> L2) {
        Node<Integer> commonListHead = null;
        Node<Integer> commonListCurrent = null;

        Node<Integer> current1 = L1;
        while (current1 != null) {
            if (isNumberInList(L2, current1.getValue())) {
                Node<Integer> newNode = new Node<>(current1.getValue());
                if (commonListHead == null) {
                    commonListHead = newNode;
                    commonListCurrent = commonListHead;
                } else {
                    commonListCurrent.setNext(newNode);
                    commonListCurrent = newNode;
                }
            }
            current1 = current1.getNext();
        }

        return commonListHead;
    }

    public static Node<Integer> removeElementsInL1ThatExistInL2(Node<Integer> L1, Node<Integer> L2) {
        Node<Integer> current = L1;
        Node<Integer> prev = null;

        while (current != null) {
            if (isNumberInList(L2, current.getValue())) {
                if (prev == null) {
                    L1 = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
            } else {
                prev = current;
            }
            current = current.getNext();
        }
        return L1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node<Integer> list = convertArrayToList(arr);

        printList(list);
        printListInReverse(list);

        Node<Integer> inputList = getNumbersFromUser();
        printList(inputList);

        printEvenNumbers(list);

        System.out.println(isNumberInList(list, 3));

        list = removeFirstOccurrence(list, 3);
        printList(list);

        list = removeAtIndex(list, 2);
        printList(list);

        Node<Integer> L1 = new Node<>(1, new Node<>(2, new Node<>(3, new Node<>(4, new Node<>(5, null)))));

        Node<Integer> L2 = new Node<>(1, new Node<>(3, new Node<>(5, null)));

        System.out.println("L1 before removal: ");
        printList(L1);
        L1 = removeElementsInL1ThatExistInL2(L1, L2);
        System.out.println("L1 after removal: ");
        printList(L1);

        System.out.println(areAllElementsInList(L1, L2));

        printCommonElements(L1, L2);

        Node<Integer> commonValues = getCommonElements(L1, L2);
        printList(commonValues);
    }
}
