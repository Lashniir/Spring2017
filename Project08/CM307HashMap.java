
public class CM307HashMap {

    private String[] keys;
    private Object[] objects;

    public CM307HashMap() {
        keys = new String[100];
        objects = new Object[100];
    }

    public void put(String key, Object object) {
        int index = Math.abs(key.hashCode())%keys.length;
        while (true) {
            if (keys[index] == null) {
                keys[index] = key;
                objects[index] = object;
                return;
            }
            if (keys[index].equals(key)) {
                objects[index] = object;
                return;
            }
            index = (index+1)%100;
        }
    }

    public Object get(String key) {
        int index = Math.abs(key.hashCode())%keys.length;
        while(keys[index]!=null && keys[index].compareTo(key)!=0){
            index++;
            if(index>=keys.length){
                index = 0;
            }
            if(keys[index]==null)return null;
            if(keys[index].compareTo(key)==0){
                return objects[index];
            }
        }
        return objects[index];
    }
    
    public void printObjects(){
        for(int i=0;i<keys.length;i++){
            if(keys[i]==null){
                System.out.println("null");
            }
            else{
                System.out.println(keys[i]+"    "+(int)objects[i]);
            }
        }
    }
}
