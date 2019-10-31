import java.util.Arrays;

public class Solution54 {

    private int[] hash;
    private int index;

    /**
     * hash法，第34题的变种
     * 运行时间：17ms
     * 占用内存：9332k
     */
    public Solution54() {
        hash = new int[256];
        Arrays.fill(hash, -1);
    }

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (hash[ch] == -1) hash[ch] = index;
        else if (hash[ch] >= 0) hash[ch] = -2;
        index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int minIndex = Integer.MAX_VALUE;
        char ans = '#';
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] >= 0 && hash[i] < minIndex) {
                minIndex = hash[i];
                ans = (char) i;
            }
        }
        return ans;
    }
}
