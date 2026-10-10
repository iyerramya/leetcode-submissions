class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while(n!=1 && !visited.contains(n)) { 
            visited.add(n);
            n = getNext(n);
        }
        return n==1;
    }

    private int getNext(int n) {
        int sum = 0;
            while( n > 0) {
                int div = n%10;
                n = n/10;
                sum += (div*div);
            }
        return sum;
    }
}