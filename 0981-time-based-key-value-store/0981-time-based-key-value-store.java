class TimeMap {

    private HashMap<String,List<Pair>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String output = "";
        List<Pair> values = timeMap.getOrDefault(key, new ArrayList<>());
        int l = 0, r = values.size() - 1;

        while(l <= r) {
            int m = l + (r - l) / 2;
            if(values.get(m).getTimestamp() <= timestamp){
                output = values.get(m).getValue();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return output;
    }

    private static class Pair {
        String value;
        int timestamp;

        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }

        public String getValue(){
            return value;
        }

        public int getTimestamp(){
            return timestamp;
        }
    }
}



/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */