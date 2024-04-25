package org.example.mission.three;

public class CatTowAndMouse extends Mission {
    @Override
    public String solve(int x, int y, int z) {
        String result = "";

        if ( Math.abs(x - z) < Math.abs(y - z) ) {
            result = "Cat A";
        } else if ( Math.abs(x - z) > Math.abs(y - z) ) {
            result = "Cat B";
        } else {
            result = "Mouse C";
        }

        return result;
    }
}