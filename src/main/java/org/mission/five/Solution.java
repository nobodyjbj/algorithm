package org.mission.five;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Encryption encryption = new Encryption();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = scanner.nextLine();
        String result = encryption.solve(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
