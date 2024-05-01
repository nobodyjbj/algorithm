package me.nobody.mission.array;

// 숫자로 구성된 배열 numbers와 target 숫자 하나가 주어졌을 때 numbers 배열에 들어있는 두 수를 더해 target 숫자를 만들 수 있는
// 인덱스 두개를 찾는 함수를 작성하다.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 예) numbers = [2,3,5,7], target = 8 -> 8을 만들 수 있는 3과 5의 인덱스인 1, 2 를 리턴해야 한다.
// 예) numbers = [2,3,5,7], target = 9 -> 9를 만들 수 있는 3과 5의 인덱스인 1, 4 를 리턴해야 한다.
public class Mission3 {
    public static void main(String[] args) {
        Mission3 mission3 = new Mission3();
        int [] result1 = mission3.solution1(new int[]{2, 3, 5, 7}, 8);
        System.out.println(Arrays.toString(result1));

        int [] result2 = mission3.solution2(new int[]{2, 3, 5, 7}, 8);
        System.out.println(Arrays.toString(result2));

        int [] result3 = mission3.solution3(new int[]{2, 3, 5, 7, 9, 11, 13}, 24);
        System.out.println(Arrays.toString(result3));
    }

    private int[] solution1(int [] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    private int[] solution2(int [] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int numberToFind = target - numbers[i];
            if (map.containsKey(numberToFind) && map.get(numberToFind) != i) {
                return new int[] {i, map.get(numberToFind)};
            }
        }

        return new int[]{};
    }

    // 세 수의 합을 구해보자
    private int[] solution3(int [] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    if (numbers[i] + numbers[j] + + numbers[k] == target) {
                        return new int[]{i, j, k};
                    }
                }
            }
        }

        return new int[]{};
    }
}
