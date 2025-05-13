package challenges;

public class Main {
    public static void main(String[] args) {
        int x = 5;

        Thing thing = new Thing();
        thing.num = 5;

        incrementPrimitive(x);
        incrementObject(thing);

        System.out.println("x = " + x);
        System.out.println("thing.num = " + thing.num);



    }

    public static void incrementPrimitive(int x) {
        x++;
    }

    public static void incrementObject(Thing thing) {//0x555FFEE
        thing.num++;
    }


}
