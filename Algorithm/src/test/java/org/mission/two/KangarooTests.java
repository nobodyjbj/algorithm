package org.mission.two;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class KangarooTests {
    final static Logger log = (Logger) LoggerFactory.getLogger(KangarooTests.class);
    private static final String YES = "YES";
    private static final String NO = "NO";
    Kangaroo kangaroo;

    @Before
    public void init() {
        kangaroo = new Kangaroo();
    }

    @Test
    public void kangarooTest() {
        String[] testValue = {"0", "3", "4", "2"};
        String result = "";
        int x1 = Integer.parseInt(testValue[0]);
        int v1 = Integer.parseInt(testValue[1]);
        int x2 = Integer.parseInt(testValue[2]);
        int v2 = Integer.parseInt(testValue[3]);

        while (x1 <= x2) {
            log.info("x1 : {} ,   x2 : {} ", x1, x2);

            if (x1 == x2) {
                result = "YES";
                break;
            }

            x1 += v1;
            x2 += v2;
        }

        assertThat("YES", is(result) );
    }

    @Test
    public void solve() {
        String matchers = kangaroo.moveOfTwoKangaroos(0, 3, 4, 2);

        assertThat(YES, is(matchers));
        //assertThat(NO, is(matchers));
    }
}
