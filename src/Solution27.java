import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution27 {
    private ArrayList<String> ans = new ArrayList<>();
    /*
    保证元素添加的顺序：LinkedHashSet
    保证元素自然的顺序：TreeSet
     */
    private Set<String> paths = new LinkedHashSet<>();
    private StringBuilder path = new StringBuilder();
    private boolean[] visit;
    /**
     * 递归回溯法，visit数组
     *
     * 运行时间：178ms
     * 占用内存：11868k
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) return ans;
        char[] array = str.toCharArray();
        visit = new boolean[array.length];
        backTrack(array, 0);
        ans.addAll(paths);
//        System.out.println(ans);
        return ans;
    }

    private void backTrack(char[] array, int index) {
        if (index == array.length) {
//            System.out.println(path.toString());
            paths.add(path.toString());
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (visit[i]) continue;
            path.append(array[i]);
            visit[i] = true;
            backTrack(array, index + 1);
            // 回溯完成，状态重置
            path.deleteCharAt(path.length() - 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        solution27.Permutation("aab");
    }
}
