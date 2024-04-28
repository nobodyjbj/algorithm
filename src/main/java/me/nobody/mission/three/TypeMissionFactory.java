package me.nobody.mission.three;

import me.nobody.mission.three.CatTowAndMouse;
import me.nobody.mission.three.Mission;
import me.nobody.mission.three.MissionFactory;

public class TypeMissionFactory extends MissionFactory {
    Mission mission = null;

    @Override
    public me.nobody.mission.three.CatTowAndMouse getInstance() {
        mission = new me.nobody.mission.three.CatTowAndMouse();
        return (CatTowAndMouse) mission;
    }
}