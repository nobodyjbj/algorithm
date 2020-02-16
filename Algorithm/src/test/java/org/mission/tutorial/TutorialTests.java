package org.mission.tutorial;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TutorialTests {
    final static Logger log = (Logger) LoggerFactory.getLogger(org.mission.tutorial.TutorialTests.class);

    @Test
    public void compareTheTripletsTest () {
        List<Integer> a = new ArrayList<>();
        a.add(17);
        a.add(28);
        a.add(30);

        List<Integer> b = new ArrayList<>();
        b.add(99);
        b.add(16);
        b.add(8);

        List<Integer> result = new ArrayList<>();
        int alice = 0;
        int bob = 0;

        for ( int i = 0; i < 3; i++ ) {
            if ( a.get(i) > b.get(i) ) {
                alice = alice + 1;
            }

            if ( a.get(i) < b.get(i) ) {
                bob = bob + 1;
            }
        }

        result.add(alice);
        result.add(bob);

        List<Integer> expected = new ArrayList<>();
        expected.add(0, 2);
        expected.add(1, 1);

        assertThat(result, is(expected));
    }

    @Test
    public void aVeryBigSumTest () {
        String[] arItems = {"1000000001", "1000000002", "1000000003", "1000000004", "1000000005"};
        long result = 0;

        for (String arItem : arItems) {
            result += Long.parseLong(arItem);
        }

        String num = "5000000015";
        long expected = Long.parseLong(num);
        assertThat(result, is(expected));
    }

    @Test
    public void diagonalDifferenceTest () {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(11);
        list1.add(2);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        List<Integer> list3 = new ArrayList<>();
        list3.add(10);
        list3.add(8);
        list3.add(-12);
        arr.add(0, list1);
        arr.add(1, list2);
        arr.add(2, list3);

        log.info("" + arr);
        int size = arr.size();
        int a = 0;
        int b = 0;

        for ( int i = 0; i < size; i++ ) {
            a += arr.get(i).get(i);
            b += arr.get(i).get((size-1) - i);
        }

        int result = Math.abs(a - b);
        int expected = 15;
        assertThat(result, is(expected));
    }

    @Test
    public void plusMinusTest() {
        int[] arr = {-4, 3, -9, 0, 4, 1};
        double positive = 0;
        double negative = 0;
        double zero = 0;
        double length = arr.length;

        for ( int i = 0; i < length; i++ ) {
            if ( arr[i] > 0 ) {
                positive++;
            } else if ( arr[i] < 0 ) {
                negative++;
            } else {
                zero++;
            }
        }

        System.out.println((double) (positive / length));
        System.out.println((double) (negative / length));
        System.out.println((double) (zero / length));
    }

    @Test
    public void staircaseTest() {
        int n = 6;
        String shap = "#";
        String space = " ";
        String result1 = "";
        String result2 = "";

        for ( int i = 0; i < n; i++ ) {
            result2 = "";
            for ( int j = 1; j < n - i; j++ ) {
                result2 += space;
            }
            result1 += shap;
            System.out.println(result2 + result1);
        }
    }

    @Test
    public void MiniMaxSumTest() {
        int[] arr = {1, 2, 3, 4, 5};
        long maxSum = 0;
        long minSum = 0;
        long totalSum = 0;

        for ( int i = 0; i < arr.length; i++ ) {
            totalSum += arr[i];
        }

        minSum = totalSum;
        for ( int i = 0; i < arr.length; i++ ) {
            if ( maxSum < totalSum - arr[i] ) {
                maxSum = totalSum - arr[i];
            }

            if ( minSum > totalSum - arr[i] ) {
                minSum = totalSum - arr[i];
            }
        }

        System.out.println(minSum + " " + maxSum);
    }

    @Test
    public void  timeConversionTest () {
        String result = "";
        String input = "12:45:54PM";
        int hh = Integer.parseInt(input.substring(0, 2));
        String pmam = input.substring(input.length() - 2, input.length());
        String time = input.substring(2, input.length() - 2);

        if ( hh < 12 ) {
            if ( "AM".equals(pmam) ) {

                if (Math.abs(hh - 12) < 10) {
                    result = "0" + hh + time;
                } else {
                    result = hh + time;
                }
            } else {
                result = (hh + 12) + time;
            }
        } else {
            if ( "AM".equals(pmam) ) {
                if (Math.abs(hh - 12) < 10) {
                    result = "0" + Math.abs(hh - 12) + time;
                    log.info("check ::  "  + result);
                } else {
                    result = Math.abs(hh - 12) + time;
                }
            } else {
                result = hh + time;
            }
        }


        String expected = "12:45:54";
        assertThat(result, is(expected));
    }
}
