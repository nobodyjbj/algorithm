package me.nobody.mission.array;

import java.util.Arrays;

// 1부터 100까지의 숫자 중에서 50개의 랜덤한 숫자가 들어있는 배열이 있다. 이 배열을 O(n) 시간 복잡도로 정렬하라.
// 시간복잡도가 O(n) 이라는 뜻은 loop 를 한 번만 돌려서 해결하라는 말과 같다.
public class Mission4 {
    public static void main(String[] args) {
        Mission4 mission4 = new Mission4();
        System.out.println(Arrays.toString(mission4.solution(new int[]{2, 4, 1, 5, 6, 9})));
    }

    private int[] solution(int[] numbers) {
        boolean[] booleans = new boolean[100];

        for (int number : numbers) {
            booleans[number] = true;
        }

        int index = 0;
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                // i의 순서를 다시 number 에 넣어주니까 순서대로 출력된다. 인덱스를 활용한 정렬 기법이다.
                numbers[index++] = i;
            }
        }

        return numbers;
    }
}
