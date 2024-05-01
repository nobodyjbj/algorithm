package me.nobody.mission.array;

// mission : 문자열을 거꾸로 뒤집어라.
public class Mission2 {
    public static void main(String[] args) {
        Mission2 mission2 = new Mission2();

        System.out.println(mission2.solution1("hello".toCharArray()));
        System.out.println(mission2.solution2("hello".toCharArray()));
        System.out.println(mission2.solution3("hello".toCharArray()));
    }

    private char[] solution1(char[] message) {
        char[] output = new char[message.length];

        for (int i = 0; i < message.length; i++) {
            output[message.length - i - 1] = message[i];
        }

        return output;
    }

    private char[] solution2(char[] message) {
        for (int i = 0; i < message.length / 2; i++) {
            char temp = message[i];
            message[i] = message[message.length - i - 1];
            message[message.length - i - 1] = temp;
        }

        return message;
    }

    private char[] solution3(char[] message) {
        String input = new String(message);
        return new StringBuilder(input).reverse().toString().toCharArray();
    }
}
