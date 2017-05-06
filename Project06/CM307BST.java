import java.io.*;
import java.util.*;

public class CM307BST<E extends Comparable<E>> {
    public static void main(String[] args) throws IOException {
        
        Map<String, Integer> proj6Tree = new TreeMap<String, Integer>();
        
        Scanner scanFile = new Scanner(new File("animals.txt"));
        while(scanFile.hasNext()) {
            String entry = scanFile.nextLine();
            Integer count = proj6Tree.get(entry);
            count = (count == null ? 1 : count + 1);
            proj6Tree.put(entry, count);
        }
        scanFile.close();
    
List<String> keys = new ArrayList<String>(proj6Tree.keySet());
Collections.sort( keys );

PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\lashn\\Desktop\\Project6Output.txt"));
for(String key : keys)
    out.println(key + " : " + proj6Tree.get(key));
out.close();
    }
}