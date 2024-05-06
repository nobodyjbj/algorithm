package me.nobody.mission.list;

// 끝에서 n 번째 노드 찾기

import java.util.LinkedHashMap;
import java.util.Map;

// 링크드 리스트 특징을 이해했는가?
// 최적화를 시도하는가?
public class Mission2 {
    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        Mission2 mission2 = new Mission2();
        mission2.add(new LinkedNode(1));
        mission2.add(new LinkedNode(4));
        mission2.add(new LinkedNode(2));
        mission2.add(new LinkedNode(3));

        System.out.println(mission2.solution1(2).number);
        System.out.println(mission2.solution2(3).number);
        System.out.println(mission2.solution3(4).number);
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

    // 전체를 순회하면서 Map에 값을 저장 후 Index로 찾아오는 방법
    // 시간복잡도: O(n), 공간복잡도: O(n)
    private LinkedNode solution1(int n) {
        Map<Integer,LinkedNode> nodeMap = new LinkedHashMap<>();
        LinkedNode current = head;
        int i = 0;
        while (current != null) {
            nodeMap.put(i++, current);
            current = current.next;
        }

        return nodeMap.get(nodeMap.size() - n);
    }

    // 전체를 순회하면서 길이를 먼저 구하는 방법
    // 시간복잡도: O(n), 공간복잡도: O(1)
    private LinkedNode solution2(int n) {
        LinkedNode current = head;
        int length = 0;

        while (current != null) {
            length++;
            current = current.next;
        }

        int targetIndex = length - n;
        LinkedNode target = this.head;
        while (targetIndex > 0) {
            targetIndex--;
            target = target.next;
        }

        return target;
    }

    // 한번의 순회로 해결하는 방법
    // 시간복잡도: O(n), 공간복잡도: O(1)
    private LinkedNode solution3(int n) {
        LinkedNode left = this.head;
        LinkedNode right = this.head;
        int count = 0;

        while (right.next != null) {
            if (count == n - 1) {
                left = left.next;
                right = right.next;
            } else if (count < n) {
                count++;
                right = right.next;
            }
        }

        return left;
    }
}
