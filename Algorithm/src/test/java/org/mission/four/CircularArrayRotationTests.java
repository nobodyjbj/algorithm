package org.mission.four;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CircularArrayRotationTests {
    final static Logger log = (Logger) LoggerFactory.getLogger(CircularArrayRotationTests.class);
    CircularArrayRotation circularArrayRotation;

    @Before
    public void init() {
        circularArrayRotation = new CircularArrayRotation();
    }

    @Test
    public void circularArrayRotationTests () {
        int[] inputArray = {1, 2, 3}; // 정수배열
        int[] indexArray = {0, 1, 2}; // 배열로 인덱스를 선언
        int rotateCount = 2;

        int[] expected = {2, 3, 1};

        int result[] = circularArrayRotation.solve(inputArray, rotateCount, indexArray);

        /* assertThat(result, is(expected)); */
    }
}
