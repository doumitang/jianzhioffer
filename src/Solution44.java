public class Solution44 {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0 || str.trim().length() == 0) return str;
        String[] array = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            builder.append(array[i]);
            if (i != 0) builder.append(" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();
        System.out.println(solution44.ReverseSentence(" "));
    }
}
