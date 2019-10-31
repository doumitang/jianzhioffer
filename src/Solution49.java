public class Solution49 {
    /**
     * 运行时间：15ms
     * 占用内存：9228k
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        int len = str.length(), max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        int i = 0, ans = 0;
        boolean isNegative = false;
        char firstChar = str.charAt(0);
        if (firstChar == '+') i = 1;
        if (firstChar == '-') {
            i = 1;
            isNegative = true;
        }
        for (; i < len; i++) {
            char ch = str.charAt(i);
            if (ch < '0' || ch > '9') return 0;
            if (isNegative) {
                if (ans < min / 10 || ans == min / 10 && (ch - '0') > 8) return 0;
                ans = ans * 10 - (ch - '0');
            } else {
                if (ans > max / 10 || ans == max / 10 && (ch - '0') > 7) return 0;
                ans = ans * 10 + (ch - '0');
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        solution49.StrToInt("123");
    }
}
