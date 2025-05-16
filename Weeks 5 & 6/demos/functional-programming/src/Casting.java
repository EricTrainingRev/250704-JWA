public class Casting {
    public static void main(String[] args) {
        int i = 65;
        char a = (char)i;//cast is temporary AND convert is permanent
        System.out.println(a);


        char b = 'b';
        int j = b;
        System.out.println(j);


        String s = "hello";
        char[] myC = s.toCharArray();




    }
}
