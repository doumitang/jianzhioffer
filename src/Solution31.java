public class Solution31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int ans = 0, temp = n, base = 1;
        int chu = 0, extra = 0;
        while (temp > 0) {
            extra = temp % 10;
            temp /= 10;
            ans += temp * base;
            if (extra == 1) {
                ans += n % base + 1;
            } else if (extra > 1) {
                ans += base;
            }
            base *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        solution31.NumberOf1Between1AndN_Solution(1);
    }
}
