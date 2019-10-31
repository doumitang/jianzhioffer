import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution27_2 {
    /**
     * 最优子结构，a + f(bc)
     *
     * 运行时间：196ms
     * 占用内存：13000k
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> ans = new ArrayList<>();
        if (str == null || str.length() == 0) return ans;
        ans.addAll(recursion(str));
//        System.out.println(ans);
        return ans;
    }

    private Set<String> recursion(String str) {
        Set<String> ans = new LinkedHashSet<>();
        if (str.length() == 1) {
            ans.add(str);
            return ans;
        }
        for (int i = 0; i < str.length(); i++) {
            for (String sub:recursion(str.substring(0, i) + str.substring(i+ 1))) {
                ans.add(str.charAt(i) + sub);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution27_2 solution27_2 = new Solution27_2();
        solution27_2.Permutation("aab");
    }
}
