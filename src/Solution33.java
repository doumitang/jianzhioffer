public class Solution33 {
    public int GetUglyNumber_Solution(int index) {
        if (index < 1) return 0;
        int p2 = 0, p3 = 0, p5 = 0;
        int[] ans = new int[index];
        ans[0] = 1;
        for (int i = 1; i < index; i++) {
            ans[i] = Math.min(ans[p2] * 2, Math.min(ans[p3] * 3, ans[p5] * 5));
            if (ans[i] == ans[p2] * 2) p2++;
            if (ans[i] == ans[p3] * 3) p3++;
            if (ans[i] == ans[p5] * 5) p5++;
        }
        return ans[index - 1];
    }
}
