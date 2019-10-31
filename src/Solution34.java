public class Solution34 {
    /**
     * 自建hash
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        int[] count = new int[256];
        int len = str.length();
        for (int i = 0; i < len; i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < len; i++) {
            if (count[str.charAt(i)] == 1) return i;
        }
        return -1;
    }
}
