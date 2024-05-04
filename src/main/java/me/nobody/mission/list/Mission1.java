package me.nobody.mission.list;

// 단일 연결 리스트를 뒤집는 함수를 구현하라.

// 연결 리스트 데이터 구로란?
// 재귀와 순회에 대한 이해도 파악
public class Mission1 {
    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        Mission1 mission1 = new Mission1();
        mission1.add(new LinkedNode(1));
        mission1.add(new LinkedNode(2));
        mission1.add(new LinkedNode(3));

        mission1.print();
        mission1.reverse1();
        mission1.print();
        mission1.reverse2();
        mission1.print();
    }

    private void print() {
        LinkedNode current = this.head;
        while (current != null) {
            System.out.println(current.number);
            current = current.next;
        }
    }

    private void add(LinkedNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else if (tail != null) {
            tail.next = node;
            tail = tail.next;
        }
    }

    // 순회적인 방법
    private void reverse1() {
        LinkedNode current = this.head;
        LinkedNode previous = null;
        LinkedNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        this.tail = this.head;
        this.head = previous;
    }

    // 재귀적인 방법
    private void reverse2() {
        LinkedNode current = this.head;

        this.head = reverseRecursive(current);
        this.tail = this.head;
    }

    private LinkedNode reverseRecursive(LinkedNode current) {
        if (current == null || current.next == null) {
            return current;
        }

        LinkedNode newCurrent = reverseRecursive(current.next);
        current.next.next = current;
        current.next = null;

        return newCurrent;
    }
}
