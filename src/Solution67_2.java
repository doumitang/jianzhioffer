public class Solution67_2 {
    /**
     * offer书第14题
     * 贪心算法，基于规则，太秀了学不来
     * 时间和空间都是O(1)
     *
     * 运行时间：14ms
     * 占用内存：9560k
     * @param target
     * @return
     */
    public int cutRope(int target) {
        if (target <= 2) return 1;
        if (target == 3) return 2;
        int timesOf3 = target / 3;
        if (target - timesOf3 * 3 == 1) timesOf3--; // 差1，使剩下的长度为4，因为2*2>1*3
        int timesOf2 = (target - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}
