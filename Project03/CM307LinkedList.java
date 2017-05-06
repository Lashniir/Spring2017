public class CM307LinkedList<E> implements CM307List<E>{

    private Node<E> head=null;
    private int size=0;
    
    private class Node<E>{
        private E data = null;
        private Node<E> next=null;
    }
    
    public CM307LinkedList(){}
    
    public void add(E e) {
        Node<E> curr=head;
        Node<E> newNode=new Node<E>();
        newNode.data=e;
        if(head==null){
            head=newNode;
        }
        else{
            for(int i=0;i<size-1;i++){
                curr=curr.next;
            }
            curr.next=newNode;
        }
        size++;
    }

    public boolean insert(int n, E e) {
        if(n<0||n>size){return false;}
        Node<E> newNode=new Node<E>();
        newNode.data=e;
        if(n==0){
            newNode.next=head;
            head=newNode;
        }
        else{
            Node<E> curr=head;
            for(int i=0;i<n-1;i++){
                curr=curr.next;
            }
            newNode.next=curr.next;
            curr.next=newNode;
        }
        size++;
        return true;
    }

    public E get(int n) {
        Node<E> curr=head;
        if(n<0||n>=size)return null; //or throw error
        for(int i=0;i<n;i++){
            curr=curr.next;
        }
        return curr.data;
    }

    public E remove(int n) {
        Node<E> curr=head;
        Node<E> temp;
        if(n<0||n>=size||size==0)return null; //or throw error
        if(n==0){
            temp=head;
            head=head.next;
            size--;
            return temp.data;
        }
        for(int i=0;i<n-1;i++){
            curr=curr.next;
        }
        temp=curr.next;
        if(n==size-1){
            curr=curr.next;
            size--;
            return temp.data;
        }
        curr.next=curr.next.next;
        size--;
        return temp.data;
    }

    public boolean isEmpty() {
        if(size==0) return true;
        return false;
    }

    public int size() {
        return size;
    }
    
    public String toString(){
        String sb;
        sb=("Size of list is "+size+"\n[");
        Node<E> curr = head;
        for(int i=0;i<size;i++){
            sb+=String.format("%s",curr.data.toString());
            if(i<size-1){
                sb=sb+(",");
            }
            curr=curr.next;
        }
        sb=sb+("]");
        return sb;
    }
}