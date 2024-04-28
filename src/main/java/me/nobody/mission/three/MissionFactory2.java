package me.nobody.mission.three;

import me.nobody.mission.three.Mission;

public class MissionFactory2 {
    public static Mission getInstance(MissionAbstractFactory missionAbstacFactory) {
        return missionAbstacFactory.getInstance();
    }
}