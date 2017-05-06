import java.util.*;

public class CM307Heap<E extends Comparable<E>> {
    private E[] heap;
    private int size;
    private int capacity;
    private final int INITIAL_CAPACITY = 20;
    
    public CM307Heap() {
        size = 0;
        capacity = INITIAL_CAPACITY;
        heap = (E[]) new Comparable[10];
    }
    
    public void enqueue(E data) {
        if (size == heap.length) reallocate();
        heap[size] = data;
        size++;
        reheapUp(size - 1);
    }

    private void reheapUp(int n) {
        if(n == 0) return;
        int parent = ((n - 1)/2);
        if (heap[n].compareTo(heap[parent])<0) {
            E temp = heap[n];
            heap[n] = heap[parent];
            heap[parent] = temp;
            reheapUp(parent);
        }
    }

    public E dequeue() {
        if(size == 0) throw new NoSuchElementException();
        E temp = heap[0];
            heap[0] = heap[size - 1];
            size--;
            reheapDown(0);
            return temp;
        }
    

    private void reheapDown(int n) {
        int left = 2 * n + 1;
        int right = 2 * n + 2;
        if (left >= size) {
            return;
        }
        if (right>=size) {
            if(heap[n].compareTo(heap[left])>0) {
            E temp = heap[n];
            heap[n] = heap[left];
            heap[left] = temp;
            reheapDown(left);
            }
        }
        if(heap[n].compareTo(heap[left])>0 || heap[n].compareTo(heap[right])>0) {
            if(heap[left].compareTo(heap[right])>0) {
                E temp = heap[n];
                heap[n] = heap[right];
                heap[right] = temp;
                reheapDown(right);
            }
            else {
                E temp = heap[n];
                heap[n] = heap[left];
                heap[left] = temp;
                reheapDown(left);
            }
        }
    }

    public void reallocate() {
        capacity = 2*capacity;
        E[] newHeap = (E[]) new Object[capacity];
        System.arraycopy(heap, 0, newHeap, 0, size);
        heap = newHeap;
    }

    private static class NoSuchElementExistsException {

        public NoSuchElementExistsException() {
        }
    }
}
