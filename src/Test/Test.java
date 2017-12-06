package Test;

import java.util.ArrayList;

public class Test {


    public static void main(String[] args) {


        ArrayList<Integer> list = new ArrayList<>();

        while (list.size() < 4) {
            int ran = (int) (Math.random() * 4);
            if (!list.contains(ran + 1))
                list.add(ran + 1);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }













    }


}
