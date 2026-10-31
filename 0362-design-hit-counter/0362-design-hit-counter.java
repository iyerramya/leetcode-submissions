class HitCounter {
    List<Integer> list;

    public HitCounter() {
        list = new ArrayList<>();
    }
    
    public void hit(int timestamp) {
        list.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        int end = timestamp;
        int start = timestamp - (5*60) + 1;
        int startIndex = getLowerBound(start);
        int endIndex = getUpperBound(end);
        return endIndex-startIndex;        
    }

    private int getLowerBound(int timestamp) {
        int l = 0;
        int r = list.size();

        while(l < r) {
            int mid = l + ((r-l)/2);
            if(list.get(mid) < timestamp) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int getUpperBound(int timestamp) {
        int l = 0;
        int r = list.size();

        while(l < r) {
            int mid = l + ((r-l)/2);
            if(list.get(mid) <= timestamp) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */