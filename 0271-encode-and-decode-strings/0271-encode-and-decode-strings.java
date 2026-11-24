public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs) {
            sb.append(s);
            sb.append("π");
        }

        return sb.toString();
        
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] decodedStrings = s.split("π", -1);
        return new ArrayList<>(Arrays.asList(decodedStrings).subList(0, decodedStrings.length - 1));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));