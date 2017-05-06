import java.util.*;

public class P07Driver {

    public static void main(String[] args) {
        CM307Heap sHeap = new CM307Heap();
        String s1 = "Leela";
        String s2 = "Bender";
        String s3 = "Fry";
        String s4 = "Amy";
        String s5 = "Hermes";
        String s6 = "Nibbler";
        String s7 = "Zoidberg";
        String s8 = "Zapp";
        String s9 = "Kif";
        String s10 = "RobotDevil";
        /*Integer s1 = 1;
        Integer s2 = 2;
        Integer s3 = 3;
        Integer s4 = 4;
        Integer s5 = 5;
        Integer s6 = 6;
        Integer s7 = 7;
        Integer s8 = 8;
        Integer s9 = 9;
        Integer s10 = 10;*/
        sHeap.enqueue(s1);
        sHeap.enqueue(s2);
        sHeap.enqueue(s3);
        sHeap.enqueue(s4);
        sHeap.enqueue(s5);
        sHeap.enqueue(s6);
        sHeap.enqueue(s7);
        sHeap.enqueue(s8);
        sHeap.enqueue(s9);
        sHeap.enqueue(s10);

        for(int i=0; i<11; i++)
        {
            String temp = (String) sHeap.dequeue();
            System.out.println(temp);
        }
    }
}