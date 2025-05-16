import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        SubtypePoly ldkfjhgb = new SubtypePoly(new PgDao("https:skdjbkdfjgd.com:5432"));


        String s1 = "Hello";
        String s2 = "goodbye";

        String s3 = s1+s2;
        String s4 = s1.concat(s2);

        String bigString = "";
        for(int i = 65; i < 75; i++) {
            bigString += (char)i;
        }
        StringBuffer sb = new StringBuffer("hello");
        sb.append(", world!");


        System.out.println(sb);


        //System.out.println(bigString);

        char[] myString = new char[]{'h','e','l','l','o'};
        char[] myCharArray = s1.toCharArray();

        String splitMe = "H|I|T|H|E|R|E";
        String[] tokens = splitMe.split("\\|");

        for(String s : tokens) {
           // System.out.println(s);
        }




        String newStringAgain = "";
        newStringAgain = newStringAgain.indent(4);
        System.out.println(newStringAgain);




//        MyFunctionalInterface multMe = (int a, int b)->{return a*b;};
//        MyFunctionalInterface subtractMe = (int a, int b)->{return a-b;};
//        MyFunctionalInterface addMe = Main::addMe;
//        int multVal = multMe.doMath(2, 3);
//        int subtractVal = subtractMe.doMath(5,1);
//        int addVal = addMe.doMath(2, 2);
//        System.out.println(multVal + " " + subtractVal + " " + addVal);

    }

    public static int addMe(int a, int b) {
        return a + b;
    }



}
