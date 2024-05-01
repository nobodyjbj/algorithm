package me.nobody.mission.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// mission : 숫자로 구성된 배열에 중복된 숫자가 있는지 확인하는 함수를 작성해라. 중복된 숫자가 있다면 true 아니면 false
public class Mission1 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9};

        Mission1 mission1 = new Mission1();
        System.out.println(mission1.solution1(numbers));
        System.out.println(mission1.solution2(numbers));
        System.out.println(mission1.solution3(numbers));
    }

    private boolean solution1(int [] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean solution2(int [] numbers) {
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return true;
            }
        }

        return false;
    }

    private boolean solution3(int [] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int number : numbers) {
            if (set.contains(number)) {
                return true;
            } else {
                set.add(number);
            }
        }

        return false;
    }
}
