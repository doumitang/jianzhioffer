public class Solution48 {
    /**
     * offer书第65题
     * 1.先不考虑进位相加：异或
     * 2.再求进位：相与左移一位
     * 3.重复前两步直至进位为0
     *
     * 运行时间：16ms
     * 占用内存：9456k
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        int sum = 0, carry = 0;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            System.out.println(sum + ", " + carry);
            num1 = sum;
            num2 = carry;
        } while (carry != 0);
        return sum;
    }

    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        System.out.println(solution48.Add(-1, 2));
    }
}
