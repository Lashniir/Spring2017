
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Project05 {
    
    public static void main(String[] args) throws FileNotFoundException, InterruptedException{
        
        ArrayList<String> sort = new ArrayList<String>();
        ArrayBlockingQueue<String>[] queue = new ArrayBlockingQueue[10];
        for(int i=0;i<queue.length;i++){
            queue[i] = new ArrayBlockingQueue(30);
        }
        Scanner in = new Scanner(new File("C:\\Users\\lashn\\Documents\\NetBeansProjects\\Project05\\src\\radixSortData.txt"));
        while(in.hasNext()){
            sort.add(in.nextLine());
        }
        for(int i=0;i<sort.size();i++){
            int temp = Integer.parseInt(sort.get(i))%10;
            queue[temp].add(sort.get(i));
        }
        sort.clear();
        for(int i=0;i<queue.length;i++){
            while(queue[i].size()>0){
                sort.add(queue[i].take());
            }
        }
        for(int i=0;i<sort.size();i++){
            int temp = Integer.parseInt(sort.get(i))%100/10;
            queue[temp].add(sort.get(i));
        }
        sort.clear();
        for(int i=0;i<queue.length;i++){
            while(queue[i].size()>0){
                sort.add(queue[i].take());
            }
        }
        for(int i=0;i<sort.size();i++){
            int temp = Integer.parseInt(sort.get(i))/100;
            queue[temp].add(sort.get(i));
        }
        sort.clear();
        for(int i=0;i<queue.length;i++){
            while(queue[i].size()>0){
                sort.add(queue[i].take());
            }
        }
        for(int i=0;i<sort.size();i++){
            System.out.println(sort.get(i));
        }
    }
}
