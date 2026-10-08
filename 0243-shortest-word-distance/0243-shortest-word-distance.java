class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int shortestDistance = Integer.MAX_VALUE;
        int prevIndex = -1;
        for(int i=0; i<wordsDict.length; i++) {
            if(wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
                if(prevIndex != -1 && (!wordsDict[prevIndex].equals(wordsDict[i]))) {
                    shortestDistance = Math.min(shortestDistance, i-prevIndex);
                }
                prevIndex = i;
            }
        }
        return shortestDistance;
        
    } 
}

// class Solution {
//     public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
//         int shortestDistance = Integer.MAX_VALUE;
//         int prevIndex = -1;
//         for(int i=0; i<wordsDict.length; i++) {
//             if(wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
//                 if(prevIndex != -1 && (!wordsDict[prevIndex].equals(wordsDict[i]) || word1.equals(word2))) {
//                     shortestDistance = Math.min(shortestDistance, i-prevIndex);
//                 }
//                 prevIndex = i;
//             }
//         }
//         return shortestDistance;
//     }
// }