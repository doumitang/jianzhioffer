import java.util.ArrayList;
import java.util.Collections;

public class Solution27_3 {
    private ArrayList<String> ans = new ArrayList<>();

    /**
     * offer书第38题，分解子问题，基于交换，之后记得换回来
     *
     * 运行时间：157ms
     * 占用内存：12120k
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) return ans;
        PermutationCore(str.toCharArray(), 0);
        // 还需要一个排序操作
        Collections.sort(ans);
        return ans;
    }

    private void PermutationCore(char[] str, int begin) {
        if (begin == str.length) {
            ans.add(String.valueOf(str));
            return;
        }
        for (int i = begin; i < str.length; i++) {
            if (i != begin && str[i] == str[begin]) continue;
            swap(str, begin, i);
            PermutationCore(str, begin + 1);
            swap(str, begin, i);
        }
    }

    private void swap(char[] str, int begin, int i) {
        char temp = str[begin];
        str[begin] = str[i];
        str[i] = temp;
    }

    public static void main(String[] args) {
        Solution27_3 solution27_3 = new Solution27_3();
        System.out.println(solution27_3.Permutation("a"));
    }
}
