public class LinearProbing extends Hashtable {

    /**
     * Initialize LinearProbing object.
     * @param capacity - max size of the list
     * @param loadFactor - measures elements / table capacity
     */
    public LinearProbing(int capacity, double loadFactor) {
        super(capacity, loadFactor);
    }

    /**
     * Calculates hash value for linear probing using 
     * h(k, i) = h(k, i) = (h′(k) + i) % m function.
     * @param key - Object whose hash is being calculated
     * @param probe - current probe number
     * @return - the hash value calculated
     */
    public int h(Object key, int probe) {

        int hashCode = key.hashCode();
        // (h'(k) + i) % m 
        return positiveMod(positiveMod(hashCode, capacity) + probe, capacity);
    }
    
}
