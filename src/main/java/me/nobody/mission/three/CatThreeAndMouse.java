package me.nobody.mission.three;

public class CatThreeAndMouse {
    public String solve(int x, int y, int r, int z) { // 방향추가 좌표추가 (x,y)
        String result2 = "";

        if ( Math.abs(x - z) < Math.abs(y - z) && Math.abs(x - z) < Math.abs(r - z) ) {
            result2 = "Cat A";
        } else if ( Math.abs(y - z) < Math.abs(x - z) && Math.abs(y - z) < Math.abs(r - z) ) {
            result2 = "Cat B";
        } else if ( Math.abs(r - z) < Math.abs(y - z) && Math.abs(r - z) < Math.abs(x - z) ) {
                result2 = "Cat R";
        } else {
            result2 = "Mouse C";
        }

        return result2;
    }
}