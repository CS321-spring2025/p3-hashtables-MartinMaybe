public class DoubleHashing extends Hashtable {
    
    /**
     * Initialize DoubleHashing object.
     * @param capacity - max size of the list
     * @param loadFactor - measures elements / table capacity
     */
    public DoubleHashing(int capacity, double loadFactor) {
        super(capacity, loadFactor);
    }

    /**
     * Calculates hash value for double hashing using 
     * h(k, i) = (h1(k) + ih2(k)) % m function.
     * @param key - Object whose hash is being calculated
     * @param probe - current probe number
     * @return - the hash value calculated
     */
    public int h(Object key, int probe) {
        int hashCode = key.hashCode();

        // (h1(k) + i * h2(k)) % m 
        int h1 = positiveMod(hashCode, capacity);
        int h2 = 1 + positiveMod(hashCode, capacity - 2);

        return positiveMod(h1 + (probe * h2), capacity);
    }
}
