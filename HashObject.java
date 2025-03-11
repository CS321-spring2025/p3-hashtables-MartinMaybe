public class HashObject {
    private Object key;
    private int frequencyCount, probeCount;

    public HashObject(Object key) {
        this.key = key;
        this.frequencyCount = 1;
        this.probeCount = 0;
    }

    @Override
    public boolean equals(Object object) {
        return this.getKey().equals(object);
    }

    @Override
    public String toString() {
        return key + " " + frequencyCount + " " + probeCount;
    }
    
    public Object getKey() {
        return key;
    }
}
