package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Prog {
    private static Prog instance = new Prog();
    static Pattern nrPat = Pattern.compile("\\d+");

    Prog() {

        System.out.println("Valid pw aoeustn : "+pwValidator("aoeustn"));
        System.out.println("Valid pw aoeustnh : "+pwValidator("aoeustnh"));
        System.out.println("Valid pw Aoeu1234 : "+pwValidator("Aoeu1234"));
        System.out.println("Valid pw aoeu1234# : "+pwValidator("aoeu1234#"));
        System.out.println("Valid pw Aoeu1234# : "+pwValidator("Aoeu1234#"));
        System.out.println("Valid pw Aoeu1\\t234# : "+pwValidator("Aoeu1\t234#"));
        System.out.println("Valid pw 12345678 : "+pwValidator("12345678"));
        System.out.println("Valid pw 1234567åttanio : "+pwValidator("1234567åttanio"));
        System.out.println("Valid pw 1234567åttanio? : "+pwValidator("1234567åttanio?"));
        System.out.println("Valid pw 1234567åttaNIO? : "+pwValidator("12345678åttaNIO?"));
        System.out.println("Valid pw 1tVå! : "+pwValidator("1tVå!"));

        System.out.println();
        System.out.println("Valid personnummer 1918-09-22 2345 : " + personnummerValidator("1918-09-22 2345"));
        System.out.println("Valid personnummer 9008211234 : " + personnummerValidator("9008211234"));
        System.out.println("Valid personnummer 900821-1234 : " + personnummerValidator("900821-1234"));
        System.out.println("Valid personnummer 1918-09-22 2345 : " + personnummerValidator("1918-09-22 2345"));
        System.out.println("Valid personnummer 180922+2345 : " + personnummerValidator("180922+2345"));
        System.out.println("Valid personnummer 180923två+2345 : " + personnummerValidator("180923två+2345"));
        System.out.println("Valid personnummer ------------ : " + personnummerValidator("------------"));
        System.out.println();
        System.out.println("Valid phoneNr 0298-99 : " + phoneNrValidator("0298- 99"));
        System.out.println("Valid phoneNr 0298oeu : " + phoneNrValidator("0298oeu"));
        System.out.println("Valid phoneNr %%3987197329 : " + phoneNrValidator("%%3987197329"));
        System.out.println("Valid phoneNr +13 12313123 : " + phoneNrValidator("+13 12313123"));
        System.out.println("Valid phoneNr 081-32828-23 : " + phoneNrValidator("081-32828-23"));
        System.out.println();
        System.out.println("Valid email aaonuo.aha : " + emailValidator("aaonuo.aha"));
        System.out.println("Valid email aao@@nuo.aha : " + emailValidator("aao@@nuo.aha"));
        System.out.println("Valid email aoe@onuo : " + emailValidator("aoe@onuo"));
        System.out.println("Valid email aa@onuo.c3 : " + emailValidator("aa@onuo.c3"));
        System.out.println("Valid email aoe@onu.a : " + emailValidator("aoe@onu.a"));
        System.out.println("Valid email aa@o.cac : " + emailValidator("aa@o.cac"));
        System.out.println("Valid email a@on.ca : " + emailValidator("a@on.ca"));
        System.out.println("Valid email aa@onuo. : " + emailValidator("aa@onuo."));
        System.out.println("Valid email #(#¤@hou#¤).eeeh : " + emailValidator("#(#¤@hou#¤).eeeh"));
        System.out.println("Valid email en@bra.mail : " + emailValidator("en@bra.mail"));
        System.out.println("Valid email 0x0@0k.ja : " + emailValidator("oxo@0k.ja"));
        System.out.println();
        String s1 = "hej\n" +
                "hejsan1\n" +
                "\n" +
                "hall100å\n" +
                "what's up";
        String s2 = "hej      på  dig\n" +
                "   hejsan\n" +
                " hej      \n" +
                "     hej    hej";
        System.out.println("\n1 before:\n" + s1 + "\n\n1 after:\n" + replacement(s1));
        System.out.println("\n2 before:\n" + s2 + "\n\n2 after:\n" + replacement(s2));


    }

    boolean pwValidator(String s) {

        //^(?=[A-Z]+)(?=[.*a-z]+)(?=[.*\d]+)(?=[.*\D\W]+).{8,}$
        Matcher matcher = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[§½ !\"#¤%&\\/\\\\()=?´€@£${\\[\\]}*^Åå\\-_'<>])(?!.*[\\s]).{8,}$").matcher(s);
        return matcher.matches();
    }

    boolean personnummerValidator(String s) {
        //Matcher matcher = Pattern.compile("\\b[\\- \\+0-9]{10,15}").matcher(s);
        s = s.replaceAll("[- +]","");

        return s.matches("[\\d]{10,12}");
    }

    boolean emailValidator(String s) {
        Matcher matcher = Pattern.compile("[A-Za-z0-9]{2,}@[A-Za-z0-9]{2,}\\.[a-zA-Z]{2,}").matcher(s);
        return matcher.matches();
    }

    boolean phoneNrValidator(String nr) {
        nr = nr.replaceAll("[ \\-+]", "");

        return nr.matches("[\\d]{7,12}");
    }

    String replacement(String s) {
        s = s.replaceAll(" +", " ").replaceAll("\\n ", "\n").replaceAll("\\n\\n","\n").trim();
        s = s.replaceAll("\\d", "");

        return s;
    }

    public static Prog getInstance() {
        return instance;
    }
}
