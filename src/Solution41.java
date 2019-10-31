import java.util.ArrayList;

public class Solution41 {
    /**
     * 滑动窗口双指针法
     * 我的想法是中位数指针，跟我的想法本质上一致，但是双指针法的思路更清晰
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (sum <= 0) return ans;
        ArrayList<Integer> temp = null;
        int low = 1, high = 2;
        while (low < high) {
            int tempSum = (low + high) * (high - low + 1) / 2;
            if (tempSum == sum) {
                temp = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    temp.add(i);
                }
                ans.add(temp);
                low++;
            } else if (tempSum < sum) {
                high++;
            } else {
                low++;
            }
        }
        return ans;
    }
}
