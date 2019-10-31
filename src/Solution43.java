public class Solution43 {
    /**
     * subString有额外的空间复杂度
     * python可以采用 YX = (XT YT)T来节省额外空间
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) return str;
        int len = str.length();
        n = n % len;
        return str.substring(n) + str.substring(0, n);
    }

    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        solution43.LeftRotateString("abcdefg",2);
    }
}
