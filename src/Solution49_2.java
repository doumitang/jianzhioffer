public class Solution49_2 {
    /**
     * 将正数、负数的越界判断合并起来
     * 运行时间：14ms
     * 占用内存：9168k
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        int len = str.length(), limit = -Integer.MAX_VALUE, radix = 10;
        int i = 0, ans = 0;
        boolean isNegative = false;
        char firstChar = str.charAt(0);
        if (firstChar < '0' || firstChar > '9') {
            if (firstChar == '-') {
                isNegative = true;
                limit = Integer.MIN_VALUE;
            } else if (firstChar != '+') {
                return 0;
            }
            i++;
        }
        while (i < len) {
            char ch = str.charAt(i++);
            if (ch < '0' || ch > '9') return 0;
            ans *= radix;
            if (ans < limit + (ch - '0')) return 0;
            ans -= (ch - '0');
        }
        return isNegative ? ans : -ans;
    }
}
