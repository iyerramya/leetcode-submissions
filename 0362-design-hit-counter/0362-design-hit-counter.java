class HitCounter {

    private int total;
    private Deque<Pair<Integer, Integer>> hits;

    public HitCounter() {
        this.total = 0;
        this.hits = new LinkedList<Pair<Integer, Integer>>();
    }
    
    public void hit(int timestamp) {
        if(this.hits.isEmpty() || this.hits.getLast().getKey()!=timestamp) {
            this.hits.add(new Pair<Integer, Integer>(timestamp,1));
        } else {
            int prevCount = this.hits.getLast().getValue();
            this.hits.removeLast();
            this.hits.add(new Pair<Integer, Integer>(timestamp,prevCount+1));
        }
        this.total++;       
    }
    
    public int getHits(int timestamp) {
        while(!this.hits.isEmpty()) {
            int diff = timestamp-this.hits.getFirst().getKey();
            if(diff>=300) {
                this.total -= this.hits.getFirst().getValue();
                this.hits.removeFirst();
            }
            else break;
        }
        return this.total; 
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */