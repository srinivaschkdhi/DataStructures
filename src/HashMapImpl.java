import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class HashMapImpl<K, V> {

    public class hmnodes {
        K key;
        V value;
    }

    private int size = 0;
    private LinkedList<hmnodes> buckets[];

    public HashMapImpl() {
        this.buckets = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int bi = bucketIndex(key);
        int foundAt = find(bi, key);
        if (foundAt == -1) {
            hmnodes temp = new hmnodes();
            temp.key = key;
            temp.value = value;
            buckets[bi].addLast(temp);
            this.size++;
        } else buckets[bi].get(foundAt).value = value;


        double lamda = (this.size * 1.0) / this.buckets.length;

        if (lamda > 2.0) {
            rehash();
        }

        return;
    }

    public V get(K key) {
        int bi = bucketIndex(key);
        int foundAt = find(bi, key);
        if (foundAt == -1) {
            return null;
        } else {
            return buckets[bi].get(foundAt).value;
        }
    }

    public V remove(K key) {
        int bi = bucketIndex(key);
        int foundAt = find(bi, key);
        if (foundAt == -1) return null;
        else {
            this.size--;
            return buckets[bi].get(foundAt).value;
        }
    }

    public boolean containsKey(K key) {
        int bi = bucketIndex(key);
        int foundAt = find(bi, key);
        if (foundAt == -1) return false;
        else return true;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public ArrayList<K> keyset() {
        ArrayList<K> arrayList = new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arrayList.add(buckets[i].get(j).key);
            }
        }
        return arrayList;
    }

    public ArrayList<V> valueset() {
        ArrayList<V> arrayList = new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arrayList.add(buckets[i].get(j).value);
            }
        }
        return arrayList;
    }

    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("bucket = " + i);
            for (int j = 0; j < buckets[i].size(); i++) {
                hmnodes temp = buckets[i].get(j);
                System.out.print("[" + temp.key + "->" + temp.value + "]");
            }
            System.out.println();
        }

    }

    /*
    checking if a bucket contains the key
     */
    public int find(int bi, K key) {
        for (int i = 0; i < buckets[bi].size(); i++) {//iterating through linkedlist in a bucket
            if (key.equals(buckets[i].get(i).key)) {//checking all nodes have the key in linkedlist
                return i;
            }
        }
        return -1;
    }


    public int bucketIndex(K key) {
        int bi = key.hashCode();
        return Math.abs(bi % buckets.length);
    }

    private void rehash() {
        LinkedList<hmnodes>[] ob = this.buckets;
        buckets = new LinkedList[ob.length * 2];
        for (int i = 0; i < ob.length * 2; i++) {
            buckets[i] = new LinkedList<>();
        }

        size = 0;
        for (int i = 0; i < ob.length; i++) {
            for (int j = 0; j < ob[i].size(); j++) {
                put(ob[i].get(j).key, ob[i].get(j).value);

            }

        }
    }

    public static void main(String[] args) {
        System.out.println("Haspmap implementation in java");
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Value 1");
        hashMap.put(2, "Value 2");
        hashMap.put(3, "Value 3");
        hashMap.put(4, "Value 4");
        hashMap.put(5, "Value 5");
        hashMap.put(6, "Value 6");

        System.out.println("Contains Key 1 : " + hashMap.containsKey(1));
        System.out.println("Contains Key 5 : " + hashMap.containsKey(5));


        System.out.println(hashMap.get(1));
    }
}
