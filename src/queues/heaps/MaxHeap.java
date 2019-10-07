package queues.heaps;

import java.util.Arrays;

public class MaxHeap {
    int[] heap;
    int size;

    public MaxHeap(int[] heap) {
        this.size = heap.length;
        this.heap = Arrays.copyOf(heap, size);
    }

    public void maxHeapify(int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < size && heap[l] > heap[largest])
            largest = l;

        if (r < size && heap[r] > heap[largest])
            largest = r;

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    public void buildMaxHeap(){
        for (int i = size/2-1; i >=0 ; i--) {
            maxHeapify(i);
        }
    }
    public void insert(int x){
        heap = Arrays.copyOf(heap,size+1);
        int i = size;
        int parentIndex = (int) Math.floor((i-1)/2);

        while(i>0 && x > heap[parentIndex]){
            heap[i] = heap[parentIndex];
            i = parentIndex;
            parentIndex = (int) Math.floor((i-1)/2);
        }
        heap[i] = x;
        size++;
    }

    public int findMax(){
        if(size == 0)
            return -1;
        else
            return heap[0];
    }

    public int extractMax(){
        if(size == 0)
            return -1;
        int max = heap[0];
        heap[0] = heap[size-1];
        size--;
        maxHeapify(0);
        return max;
    }

    public int getSize(){
        return size;
    }

    public void printHeap(){
        if(heap == null)
            System.out.println("null");
        int iMax = size - 1;
        if(iMax == -1)
            System.out.println("[]");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');

        int i;
        for( i =0;i<iMax;i++){
            stringBuilder.append(heap[i]);
            stringBuilder.append(",");
        }
        System.out.println(stringBuilder.append(heap[i]).append(']').toString());
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,7,8};
        MaxHeap maxHeap = new MaxHeap(arr);
        maxHeap.printHeap();

        maxHeap.buildMaxHeap();
        maxHeap.printHeap();

        int max = maxHeap.extractMax();
        System.out.println("max = " + max);
        maxHeap.printHeap();

        maxHeap.insert(5);
        maxHeap.printHeap();

    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
