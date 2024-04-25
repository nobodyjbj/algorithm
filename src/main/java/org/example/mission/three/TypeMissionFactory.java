package org.example.mission.three;

public class TypeMissionFactory extends MissionFactory {
    Mission mission = null;

    @Override
    public CatTowAndMouse getInstance() {
        mission = new CatTowAndMouse();
        return (CatTowAndMouse) mission;
    }
}