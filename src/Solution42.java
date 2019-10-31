import java.util.ArrayList;

public class Solution42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> ans = new ArrayList<>();
        int left = 0, right = array.length - 1;
        int product = Integer.MAX_VALUE;
        while (left < right) {
            int tempSum = array[left] + array[right];
            int tempProd = array[left] * array[right];
            if (tempSum == sum && tempProd < product) {
                ans.clear();
                ans.add(array[left]);
                ans.add(array[right]);
                product = tempProd;
            } else if (tempSum < sum) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
