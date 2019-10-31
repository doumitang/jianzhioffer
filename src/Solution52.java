public class Solution52 {
    /**
     * offer书第19题，关键在于遇到'*'的处理，可用非确定有限状态机表示
     * 注意：本题没有涉及括号
     *
     * 运行时间：18ms
     * 占用内存：9200k
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        return matchCore(str, pattern, 0, 0);
    }

    private boolean matchCore(char[] str, char[] pattern, int indexStr, int indexPatten) {
        int lenStr = str.length, lenPattern = pattern.length;
        if (indexPatten == lenPattern && indexStr == lenStr) return true;
        if (indexPatten == lenPattern && indexStr < lenStr) return false;
        if (indexPatten + 1 < lenPattern && pattern[indexPatten + 1] == '*') {
            // 如果成功匹配一个字符
            if (indexStr < lenStr && (str[indexStr] == pattern[indexPatten] || pattern[indexPatten] == '.')) {
                // 认为'*'代表前一个字符出现0次，1次或者多次
                return matchCore(str, pattern, indexStr, indexPatten + 2) ||
                        matchCore(str, pattern, indexStr + 1, indexPatten + 2) ||
                        matchCore(str, pattern, indexStr + 1, indexPatten);
            } else {
                return matchCore(str, pattern, indexStr, indexPatten + 2); // 相当于认为'*'代表前一个字符出现0次
            }
        }
        // 如果成功匹配一个字符
        if (indexStr < lenStr && (str[indexStr] == pattern[indexPatten] || pattern[indexPatten] == '.')) {
            return matchCore(str, pattern, indexStr + 1, indexPatten + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution52 solution52 = new Solution52();
        char[] str = {};
        char[] pattern = {'.', '*'};
        System.out.println(solution52.match(str, pattern));
    }
}
