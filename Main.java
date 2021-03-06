package com.company;

import java.util.*;

public class Main {
    static void error() {
        System.out.println("Неверный ввод!");
    }

    static boolean IntCheck(char x) {
        return (Character.isDigit(x));
    }

    static int RomanToNum(char letter) {
        switch (letter) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            default:
                return -1;
        }

    }

    static String NumToRoman(int N) {
        String roman = "";
        while (N >= 100) {
            // Move 100 from N to roman.
            roman += "C";
            N -= 100;
        }
        while (N >= 90) {
            // Move 90 from N to roman.
            roman += "XC";
            N -= 90;
        }
        while (N >= 50) {
            // Move 50 from N to roman.
            roman += "L";
            N -= 50;
        }
        while (N >= 40) {
            // Move 40 from N to roman.
            roman += "XL";
            N -= 40;
        }
        while (N >= 10) {
            // Move 10 from N to roman.
            roman += "X";
            N -= 10;
        }
        while (N >= 9) {
            // Move 9 from N to roman.
            roman += "IX";
            N -= 9;
        }
        while (N >= 5) {
            // Move 5 from N to roman.
            roman += "V";
            N -= 5;
        }
        while (N >= 4) {
            // Move 4 from N to roman.
            roman += "IV";
            N -= 4;
        }
        while (N >= 1) {
            // Move 1 from N to roman.
            roman += "I";
            N -= 1;
        }
        return roman;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите операцию: ");
        String s = in.nextLine();
        in.close();

        String str = s.replaceAll("\\s+", "");
        str = str.toUpperCase();

        int c = 0, v1 = 0, v2 = 0, t = 0;
        c = Math.max(str.indexOf('+'), Math.max(str.indexOf('-'), Math.max(str.indexOf('*'), str.indexOf('/'))));
        if (c < 1 || c > 4) {
            error();
            return;
        }
        if (IntCheck(str.charAt(0))) {
            v1 = Character.getNumericValue(str.charAt(0));
            if (str.charAt(c) != str.charAt(1)) {
                if (v1 == 1 && str.charAt(1) == '0')
                    v1 = 10;
                else {
                    error();
                    return;
                }
            }


            if (IntCheck(str.charAt(c + 1))) {
                v2 = Character.getNumericValue(str.charAt(c + 1));
                if (str.charAt(c + 1) != str.charAt(str.length() - 1)) {
                    if (v2 == 1 && str.charAt(c + 2) == '0')
                        v2 = 10;
                    else {
                        error();
                        return;
                    }
                }
            }

            switch (str.charAt(c)) {
                case '+' -> System.out.println("Ответ = " + (v1 + v2));
                case '-' -> System.out.println("Ответ = " + (v1 - v2));
                case '*' -> System.out.println("Ответ = " + (v1 * v2));
                case '/' -> System.out.println("Ответ = " + (v1 / v2));
                default -> System.out.print("Ошибка");
            }
        }

            int num = RomanToNum(str.charAt(0));
            int st = 0;
            if (num > 0 && num <= 10) {
                v1 = num;
                t = num;
                if(num==1)
                    st++;
            }
            else {
                error();
                return;
            }

            for (int i = 1; i <c; i++) {
                num = RomanToNum(str.charAt(i));
                if(num==1)
                    st++;
                    if (num > 0 && num <= 10 && v1 < 10) {
                        if ((num==5 || num==10) && st<=1)
                            v1 = v1 + num - t - t;
                        else if ((num==5|| num==10) && st>1)
                        {
                            error();
                            return;
                        }
                        else
                            v1=v1+num;
                        t = num;
                    }
                    else {
                        error();
                        return;
                    }


            }

        num = RomanToNum(str.charAt(c+1));
        st = 0;
        if (num > 0 && num <= 10) {
            v2 = num;
            t = num;
            if(num==1)
                st++;
        }
        else {
            error();
            return;
        }

        for (int i = c+2; i <str.length(); i++) {
            num = RomanToNum(str.charAt(i));
            if(num==1)
                st++;
            if (num > 0 && num <= 10 && v1 < 10) {
                if ((num==5 || num==10) && st<=1)
                    v2 = v2 + num - t - t;
                else if ((num==5|| num==10) && st>1)
                {
                    error();
                    return;
                }
                else
                    v2=v2+num;
                t = num;
            }
            else {
                error();
                return;
            }


        }

                switch (str.charAt(c)) {
                    case '+' -> System.out.println("Ответ = " + NumToRoman(v1 + v2));
                    case '-' -> System.out.println("Ответ = " + NumToRoman(v1 - v2));
                    case '*' -> System.out.println("Ответ = " + NumToRoman(v1 * v2));
                    case '/' -> System.out.println("Ответ = " + NumToRoman(v1 / v2));
                    default -> System.out.print("Ошибка");
                }


    }
}


