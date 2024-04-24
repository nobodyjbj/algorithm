package org.mission.three;

public class MissionFactory2 {
    public static Mission getInstance(MissionAbstractFactory missionAbstacFactory) {
        return missionAbstacFactory.getInstance();
    }
}