package me.nobody.mission.array;

import java.util.ArrayList;
import java.util.List;

// number라는 int형 배열이 있다. 해당 배열에 들어있는 숫자들은 오직 한 숫자를 제외하고는 모두 두번씩 들어있다. 오직 한 번만 등장하는 숫자를 찾는 코드를 작성하라.
public class Mission5 {
    public static void main(String[] args) {
        Mission5 mission5 = new Mission5();
        int result = mission5.solution(new int[]{1, 2, 2, 3, 3, 4, 4});
        System.out.println(result);
    }

    private int solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for (Integer number : numbers) {
            if (list.contains(number)) {
                list.remove(number);
            } else {
                list.add(number);
            }
        }

        return list.getFirst();
    }
}
