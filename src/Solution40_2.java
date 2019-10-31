//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution40_2 {
    /**
     * 先全体异或，然后按照异或结果的一个1位进行分组
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int xor = 0;
        for (int i = 0; i < array.length; i++) {
            xor ^= array[i];
        }
        int val = 1;
        while ((val & xor) == 0) {
            val <<= 1;
        }
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < array.length; i++) {
            if ((val & array[i]) == 0) ans1 ^= array[i];
            else ans2 ^= array[i];
        }
        num1[0] = ans1;
        num2[0] = ans2;
    }
}
