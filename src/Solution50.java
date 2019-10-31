import java.util.HashSet;
import java.util.Set;

public class Solution50 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    /**
     * 哈希表方法
     * 运行时间：19ms
     * 占用内存：9680k
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length == 0) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (set.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }
            set.add(numbers[i]);
        }
        return false;
    }
}
