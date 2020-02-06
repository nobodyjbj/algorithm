package org.mission.four;

public class CircularArrayRotation {
    public int[] solve(int[] inputArray, int rotateCount, int[] indexArray) {
        int resultSize = indexArray.length;
        int[] result = new int[resultSize];
        int inputArraySize = inputArray.length;

        /*for ( int idx = 0; idx <= rotateCount; idx++ ) {
            int index = indexArray.length;
            if (rotateCount > inputArraySize) {
                rotateCount = rotateCount % inputArraySize;
            }

            result[idx] = inputArray[Math.abs(inputArraySize - rotateCount + index) % inputArraySize];
        }*/

        for ( int idx = 0; idx <= rotateCount; idx++ ) {
            result = doRightShift(inputArray);
        }

        return result;
    }

    private int[] doRightShift(int[] inputArray) {
        int[] result = {};
        int temp = 0;
        temp = inputArray[inputArray.length - 1];

        for ( int idx = inputArray.length - 1; idx > 0 ; idx-- ) {
            int test = inputArray[idx];
            if ( idx > 0 ) {
                inputArray[idx] = inputArray[idx - 1];
            }
        }
        inputArray[0] = temp;

        return result;
    }
}
