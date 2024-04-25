package org.example.mission.five;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Encryption {
    final static Logger log = (Logger) LoggerFactory.getLogger(Encryption.class);

    public String solve(String s) {
        String replaceStr = s.replace(" ", "");
        int length = replaceStr.length();
        int sqrtNum = (int) Math.round(Math.sqrt(length));
        int columns = 0;
        int rows = 0;
        String outPutOne = "";

        columns = this.getColumns(sqrtNum, length);
        rows = sqrtNum;
        outPutOne = getOutPutOne(rows, columns, replaceStr);

        String result = "";
        result = getResult(columns, outPutOne);

        return result;
    }

    private int getColumns ( int sqrtNum, int length ) {
        int columns = 0;

        if ( Math.pow(sqrtNum, 2) >= length ) {
            columns = sqrtNum;
        } else {
            columns = sqrtNum + 1;
        }

        return columns;
    }

    private String getOutPutOne(int rows, int columns, String str) {
        String result = "";

        for ( int i = 0;  i < rows; i++ ) {
            int start = i * columns;
            int end = (i + 1) * columns;
            if ( str.length() < end ) {end = str.length();}
            result += str.substring(start, end) + " ";
        }

        return result;
    }

    private String getResult ( int columns, String outPutOne) {
        String result = "";

        String[] splitResult = new String[columns];
        splitResult = outPutOne.split(" ");

        for ( int j = 0; j < columns; j++ ) {
            for ( int i = 0; i < splitResult.length; i++ ) {
                String str = splitResult[i];
                if ( j < str.length()) {
                    result += str.charAt(j);
                }
            }

            if ( j < columns - 1 ) {
                result += " ";
            }
        }

        return result;
    }
}
