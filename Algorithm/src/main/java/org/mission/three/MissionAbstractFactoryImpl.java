package org.mission.three;

public class MissionAbstractFactoryImpl implements MissionAbstractFactory {

    @Override
    public Mission getInstance() {
        return new CatTowAndMouse();
    }
}
