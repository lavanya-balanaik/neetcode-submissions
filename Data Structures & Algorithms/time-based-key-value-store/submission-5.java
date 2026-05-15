class TimeMap {

    Map<String, List<Pair>> timeMap;

    public TimeMap() {
        this.timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
       timeMap.computeIfAbsent(key, k -> new ArrayList())
       .add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> pairs = timeMap.get(key);

        if(pairs == null) return "";

        String result = "";
        int left = 0;
        int right = pairs.size() -1;

        while(left <= right) {
            int mid = left + (right - left) /2;
            Pair pair = pairs.get(mid);
            if(pair.getTimestamp() <= timestamp) {
                result = pair.getMood();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

}

class Pair {
    String mood;
    int timestamp;

    Pair(String mood, int timestamp) {
        this.mood = mood;
        this.timestamp = timestamp;
    }

    public int getTimestamp() {
        return this.timestamp;
    }

    public String getMood() {
        return this.mood;
    }
}
