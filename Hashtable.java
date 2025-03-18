import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class Hashtable {
    protected HashObject[] table;
    protected int size;
    protected int capacity;
    protected double loadFactor;
    protected int totalInserts, totalProbes;

    /**
     * Initializes Hashtable.
     * @param capacity - max size 
     * @param loadFactor - measures elements / table capacity
     */
    public Hashtable(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.table = new HashObject[capacity];
        this.loadFactor = loadFactor;
        this.size = 0;
    }

    /**
     * Computes the hash value for a given key with a specified probe number.
     * @param key - Object being hashed
     * @param probe - current probe number, increases with every collision
     * @return - The index in the array where key is inserted at.
     */
    protected abstract int h(Object key, int probe);

    /**
     * Inserts a new HashObject with the key into the array.
     * @param key - HashObject's key value
     */
    protected void insert(Object key) {
        HashObject object = new HashObject(key);
        int i = 0; // probes
        int slotIndex = 0; 

        while (i < capacity) {
            slotIndex = h(key, object.getProbeCount());
            if (table[slotIndex] == null) {
                // Empty slot
                table[slotIndex] = object;
                size++;
                table[slotIndex].incrementProbeCount();
                totalInserts++;
                totalProbes += (i + 1);
                return;
            } else if (table[slotIndex].equals(key)) {
                // Duplicate value
                table[slotIndex].incrementFrequencyCount();
                return;
            } else {
                // Collision
                object.incrementProbeCount();
                i++;
            }
        }
        System.out.println("Error: Unable to insert");
    }

    /**
     * Searches the array for a HashObject matching the given key.
     * @param key - key we are searching for
     * @return - index of HashObject if found, or -1 if not
     */
    protected int search(Object key) {
        int i = 0; // probes
        int index = 0;

        while (i < capacity) {
            index = h(key, index);
            if (table[index].getKey().equals(key)) {
                // Key found
                return index;
            } else {
                i++;
            }
        }

        return -1;
    }

    /**
     * Ensures positive mod operation.
     * @param dividend - dividend
     * @param divisor - divisor
     * @return - positive modulus 
     */
    protected int positiveMod(int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0)
            quotient += divisor;
        return quotient;
    }

    /**
     * Loops through the hash table, and prints non-null entries
     * to a dump file using toString() method in the HashObject class.
     * @param fileName - file to write to
     * @throws FileNotFoundException
     */
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

    /**
     * Returns table size
     * @return - size
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns average probe count
     * @return - average = totalProbes / totalInserts
     */
    public double avgProbes() {
        double average = (double) totalProbes / totalInserts;
        return average;
    }



}
