package org.mission.three;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatsAndMouseTests {
    final static Logger log = (Logger) LoggerFactory.getLogger(CatsAndMouseTests.class);
    CatTowAndMouse catsAndMouse;

    @Before
    public void init() {
        catsAndMouse = new CatTowAndMouse();
    }

    @Test
    public void catsAndMouseTests () {
        String result = "";
        String[] testValue1 = {"1", "2", "3"};
        int x1 = Integer.parseInt(testValue1[0]);
        int y1 = Integer.parseInt(testValue1[1]);
        int z1 = Integer.parseInt(testValue1[2]);

        String[] testValue2 = {"1", "3", "2"};
        int x2 = Integer.parseInt(testValue1[0]);
        int y2 = Integer.parseInt(testValue1[1]);
        int z2 = Integer.parseInt(testValue1[2]);

        catsAndMouse.solve(x1, y1, z1);
    }

    // 팩토리 메소드 패턴
    @Test
    public void catsTwoMouseTest () {
        String result = "";
        String[] testValue1 = {"1", "2", "3"};
        int x1 = Integer.parseInt(testValue1[0]);
        int y1 = Integer.parseInt(testValue1[1]);
        int z1 = Integer.parseInt(testValue1[2]);

        TypeMissionFactory typeMissionFactory = new TypeMissionFactory();
        typeMissionFactory.getInstance().solve(x1, y1, z1);
    }

    // 추상 팩토리 패턴
    @Test
    public void catsTwoMouseTest2 () {
        String result = "";
        String[] testValue1 = {"1", "2", "3"};
        int x1 = Integer.parseInt(testValue1[0]);
        int y1 = Integer.parseInt(testValue1[1]);
        int z1 = Integer.parseInt(testValue1[2]);

        MissionFactory2.getInstance(new MissionAbstractFactoryImpl()).solve(x1, y1, z1);
    }
}
