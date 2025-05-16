import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubtypePoly {
    List<Integer> myList;
    Dao dao;

    public void method(Dao theDao) {
        dao = theDao;

        myList = new LinkedList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);

        for(Integer i : myList) {
            System.out.println(i);
        }
    }


    public static void main(String[] args) {

    }

}
