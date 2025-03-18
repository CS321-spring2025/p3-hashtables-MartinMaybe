public class HashObject {
    private Object key;
    private int frequencyCount, probeCount;

    /**
     * Initialize HashObject.
     * @param key - key value 
     */
    public HashObject(Object key) {
        this.key = key;
        this.frequencyCount = 1;
        this.probeCount = 0;
    }

    @Override
    public boolean equals(Object object) {
        return this.getKey().equals(object);
    }

    /**
     * Returns key from HashObject
     * @return - key
     */
    public Object getKey() {
        return key;
    }

    /**
     * Returns probe count.
     * @return - probeCount
     */
    public int getProbeCount() {
        return probeCount;
    }

    /**
     * Increments probe count.
     * @return - probeCount
     */
    public void incrementProbeCount() {
        probeCount++;
    }

    /**
     * Increments frequency count.
     * @return - frequencyCount
     */
    public void incrementFrequencyCount() {
        frequencyCount++;
    }
    
    @Override
    public String toString() {
        return key + " " + frequencyCount + " " + probeCount;
    }
    
    
}
