public class Solution47 {

    /**
     * offer书第64题
     * 围绕循环或者递归做文章
     * 循环关键在于循环次数，递归关键在于递归结束条件
     *
     * 注意：
     * java声明对象数组时，不会自动填充对象
     * java中的int和boolean类型不互通
     *
     * 利用逻辑与的短路求值特性，终止递归
     *
     * 运行时间：15ms
     * 占用内存：9316k
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (n != 0 && (sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        Solution47 solution472 = new Solution47();
        System.out.println(solution472.Sum_Solution(10));
    }
}
