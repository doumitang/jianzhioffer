public class Solution11 {
    public int NumberOf1(int n) {
        int ans = 0;
        while (n != 0) {
            ans += n & 1;
            n >>>= 1; // 无符号右移
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.NumberOf1(-1));
    }
}
