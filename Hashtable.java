import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class Hashtable {
    protected HashObject[] table;
    protected int size;
    protected int capacity;
    protected double loadFactor;

    public Hashtable(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.table = new HashObject[capacity];
        this.loadFactor = loadFactor;
        this.size = 0;
    }

    public abstract int h(Object key, int probe);

    protected void instert(Object key) {
        HashObject object = new HashObject(key);
        int i = 0;
        int j = 0;

        while (i < capacity) {
            j = h(key, 0);
            if (table[j] == null) {
                // Empty slot
                table[j] = object;
                size++;
                table[j].incrementProbeCount();
                return;
            } else if (table[j].equals(key)) {
                // Duplicate value
                table[j].incrementFrequencyCount();
                return;
            } else {
                // Not empty and no dupe
                object.incrementProbeCount();
                i++;
            }
        }
        System.out.println("Error: Hash table overflow");
    }

    protected int search(Object key) {
        int i = 0;
        int j = 0;

        while (i < capacity) {
            j = h(key, j);
            if (table[j].equals(key)) {
                // Key found
                return j;
            } else {
                i++;
            }
        }

        return -1;
    }

    protected int positiveMod(int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0)
            quotient += divisor;
        return quotient;
    }

    public void dumpToFile(String fileName) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileName);
    
        // loop through the hash table
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                // print non-null entries using toString() method in the HashObject class
                out.println("table[" + i + "]: " + table[i].toString());
            }
        }
        
        out.close();
    }



}
