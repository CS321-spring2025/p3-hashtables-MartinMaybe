public class LinearProbing extends Hashtable {

    public LinearProbing(int capacity, double loadFactor) {
        super(capacity, loadFactor);
    }

    public int h(Object key, int probe) {

        int hashCode = key.hashCode();
        // (h'(k) + i) % m 
        return positiveMod(positiveMod(hashCode, capacity) + probe, capacity);
    }
    
}
