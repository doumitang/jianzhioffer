public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                str.deleteCharAt(i);
                str.insert(i, "%20");
            }
        }
        return str.toString();
    }
}
