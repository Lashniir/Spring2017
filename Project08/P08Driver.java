import java.io.*;
import java.util.*;

public class P08Driver<E extends Comparable<E>> {
    public static void main(String[] args) throws IOException {
        
        CM307HashMap hashMap = new CM307HashMap();
        
        Scanner in = new Scanner(new File("C:\\Users\\lashn\\Desktop\\Proj06\\animals.txt"));
        while(in.hasNext()){
            String key = in.nextLine();
            Integer count = (Integer) hashMap.get(key);
            if(count == null){
                hashMap.put(key, 1);
            }
            else{
                hashMap.put(key, (count+1));
            }
        }
        hashMap.printObjects();
    }
}
