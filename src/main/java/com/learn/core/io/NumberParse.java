package com.learn.core.io;

public class NumberParse {

    public static int parse(String input, int radix) {
        if (input == null || input.length() == 0) {
            throw new NumberFormatException("input must be not empty value");
        }
        boolean negative = false;
        char firstChar = input.charAt(0);
        int i = 0;
        if (firstChar < '0') {
            if (firstChar == '-') {
                negative = true;
            } else if (firstChar != '+') {
                throw new NumberFormatException("input must be not empty value");
            }

            if (input.length() == 1) {
                throw new NumberFormatException("input must be not empty value");
            }
            i++;
        }

        int res = 0;
        int digit = 0;
        for (; i < input.length(); i++) {
            res *= radix;
            digit = Character.digit(input.charAt(i), radix);
            res += digit;
        }
        return negative ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println("12=" + NumberParse.parse("12", 10));
        System.out.println("1222=" + NumberParse.parse("1222", 10));
        System.out.println("3331222=" + NumberParse.parse("3331222", 10));
        System.out.println("-3331222=" + NumberParse.parse("-3331222", 10));
        System.out.println("10=" + NumberParse.parse("10", 2));
        System.out.println("111=" + NumberParse.parse("111", 2));
        System.out.println("-111=" + NumberParse.parse("-111", 2));
        System.out.println("FF=" + NumberParse.parse("FF", 16));
        System.out.println("F=" + NumberParse.parse("F", 16));
    }
}
