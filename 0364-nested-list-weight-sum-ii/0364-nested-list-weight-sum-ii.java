/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 class WeightedSumTriplet {
    int maxDepth;
    int sumOfElements;
    int sumOfProducts;

    public WeightedSumTriplet(int maxDepth, int sumOfElements, int sumOfProducts) {
        this.maxDepth = maxDepth;
        this.sumOfElements = sumOfElements;
        this.sumOfProducts = sumOfProducts;
    }
 }
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        // int maxDepth = 1;
        // for(NestedInteger ni: nestedList) {
        //     maxDepth = Math.max(maxDepth(ni,1),maxDepth);
        // }
        // int total = 0;
        // for(NestedInteger ni: nestedList) {
        //     total += sum(ni, 1, maxDepth);
        // }
        // return total;

        //int maxDepth = maxDepth(nestedList);
        //return sum(nestedList, 1, maxDepth);

        WeightedSumTriplet weighetSumTripet = getWeightedSumTriplet(nestedList, 1);
        int maxDepth = weighetSumTripet.maxDepth;
        int sumOfElements = weighetSumTripet.sumOfElements;
        int sumOfProducts = weighetSumTripet.sumOfProducts;

        return (maxDepth + 1) * sumOfElements - sumOfProducts;
    }

    private WeightedSumTriplet getWeightedSumTriplet(List<NestedInteger> nestedList, int depth) {
        int sumOfProducts = 0;
        int sumOfElements = 0;
        int maxDepth = 0;

        for(NestedInteger nested : nestedList) {
            if(nested.isInteger()) {
                sumOfProducts += nested.getInteger() * depth;
                sumOfElements += nested.getInteger();
                maxDepth = Math.max(depth, maxDepth);
            } else {
                WeightedSumTriplet result = getWeightedSumTriplet(
                    nested.getList(),
                    depth+1
                );
                sumOfProducts += result.sumOfProducts;
                sumOfElements += result.sumOfElements;
                maxDepth = Math.max(maxDepth, result.maxDepth);
            }
        }
        return new WeightedSumTriplet(maxDepth, sumOfElements, sumOfProducts);
    }

    private int maxDepth(List<NestedInteger> nestedList) {
        int maxDepth = 1;

        for(NestedInteger nested : nestedList) {
            if(!nested.isInteger() && nested.getList().size() > 0 ) {
                maxDepth = Math.max(maxDepth, 1+maxDepth(nested.getList()));
            }
        }
        return maxDepth;
    }

    private int sum(List<NestedInteger> nestedList, int depth, int maxDepth) {
        int sum = 0;

        for(NestedInteger nested: nestedList) {
            if(nested.isInteger()) {
                sum += (maxDepth - depth + 1) * nested.getInteger();
            } else {
                sum += sum(nested.getList(), depth+1, maxDepth);
            }
        }
        return sum;
    }


    // private int sum(NestedInteger ni, int depth, int maxDepth) {
        // if(ni.isInteger()) {
        //     return (maxDepth - depth + 1) * ni.getInteger();
        // }
        // depth += 1;
        // int total = 0;
        // for(NestedInteger element : ni.getList()) {
        //     total += sum(element, depth, maxDepth);
        // }
        // return total;
    // }

    // private int maxDepth(NestedInteger ni, int depth) {
        // if(ni.isInteger()) {
        //     return depth;
        // }
        // depth += 1;
        // int maxDepth = 1;
        // for(NestedInteger element : ni.getList()) {
        //    maxDepth = Math.max(maxDepth, maxDepth(element, depth));
        // }
        // return maxDepth;
    // }
}