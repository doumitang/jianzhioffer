import java.util.HashMap;
import java.util.Map;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution40 {
    /**
     * 建立hash提高访问效率，但是有空间复杂度
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer count = hash.get(array[i]);
            if (count == null) hash.put(array[i], 1);
            else hash.put(array[i], count + 1);
        }
        int num = 0;
        for (Map.Entry<Integer, Integer> entry:hash.entrySet()) {
            if (entry.getValue() == 1) {
                if (num == 0) {
                    num1[0] = entry.getKey();
                    num++;
                } else {
                    num2[0] = entry.getKey();
                }
            }
        }
    }
}
