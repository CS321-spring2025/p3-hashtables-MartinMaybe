public class DoubleHashing extends Hashtable {
    
    public DoubleHashing(int capacity, double loadFactor) {
        super(capacity, loadFactor);
    }

    public int h(Object key, int probe) {
        int hashCode = key.hashCode();

        // (h1(k) + i * h2(k)) % m 
        int h1 = positiveMod(hashCode, capacity);
        int h2 = 1 + positiveMod(hashCode, capacity - 2);

        return positiveMod(h1 + (probe * h2), capacity);
    }
}
