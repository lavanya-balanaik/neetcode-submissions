class LRUCache {
    Map<Integer, Integer> lru;

    public LRUCache(int capacity) {
         lru = new LinkedHashMap<Integer, Integer>(capacity, 0.5f, true) {
            @Override
            protected boolean removeEldestEntry(
                    Map.Entry<Integer, Integer> eldest) {

                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return lru.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        lru.put(key, value);
    }
}
