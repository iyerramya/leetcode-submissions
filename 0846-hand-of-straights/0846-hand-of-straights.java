class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
        }
        Arrays.sort(hand);
        for(int card: hand) {
            if(map.containsKey(card) && map.get(card) > 0) {
                for(int j=0; j<=groupSize-1; j++) {
                    if(map.containsKey(card+j) && map.get(card+j)>0) {
                        map.put(card+j, map.get(card+j)-1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;

    }
}