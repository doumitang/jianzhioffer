public class Solution32 {
    /**
     * 关键在于排序的规则，方法是冒泡排序
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        StringBuilder ans = new StringBuilder();
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int cat1 = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int cat2 = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (cat1 > cat2) swap(numbers, i, j);
            }
        }
        for (int i = 0; i < len; i++) {
            ans.append(numbers[i]);
        }
        return ans.toString();
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
