public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs) {
            sb.append(s.replace("/", "//")).append("/:");
        }

        return sb.toString();
        
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decodedStrings = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        int i = 0;
        while(i < s.length()) {
            if(i+1 < s.length() && s.charAt(i) == '/' && s.charAt(i+1) == ':') {
                decodedStrings.add(currentString.toString());
                currentString = new StringBuilder();
                i += 2;
            } else if(i+1 < s.length() && s.charAt(i) == '/' && s.charAt(i+1) == '/') {
                currentString.append('/');
                i += 2;
            } else {
                currentString.append(s.charAt(i));
                i++;
            }
        }
        return decodedStrings;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));