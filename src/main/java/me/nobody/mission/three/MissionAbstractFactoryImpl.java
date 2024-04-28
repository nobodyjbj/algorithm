package me.nobody.mission.three;

import me.nobody.mission.three.CatTowAndMouse;
import me.nobody.mission.three.Mission;
import me.nobody.mission.three.MissionAbstractFactory;

public class MissionAbstractFactoryImpl implements MissionAbstractFactory {

    @Override
    public Mission getInstance() {
        return new CatTowAndMouse();
    }
}
