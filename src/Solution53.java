public class Solution53 {

    private int index = 0;

    /**
     * offer书第20题，表示数值的字符串遵循模式A.B e|E c或者.B e|E C
     * A是整数部分，B是小数部分，C是指数部分
     * 注意：逻辑运算的顺序
     *
     * 运行时间：18ms
     * 占用内存：9192k
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) return false;
        boolean ans = scanInteger(str);
        if (index < str.length && str[index] == '.') {
            index++;
            ans = scanUnsignedInteger(str) || ans; // 小数点前后的A部分和B部分只需要存在其中一个
        }
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            ans = ans && scanInteger(str); // e|E前后的B部分和C部分需要同时存在
        }
        return ans && index == str.length;
    }

    // 返回是否存在一个整数
    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) index++;
        return scanUnsignedInteger(str);
    }

    // 返回是否存在一个无符号整数
    private boolean scanUnsignedInteger(char[] str) {
        int pre = index;
        // 找到第一个非法的字符
        while (index < str.length && str[index] >= '0' && str[index] <= '9') index++;
        return index > pre;
    }

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.isNumeric("12e".toCharArray()));
    }
}
