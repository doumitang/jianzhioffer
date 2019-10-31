public class Temp {
    private static int sum, val;

    public Temp() {
        val++;
        sum += val;
    }

    public static void reset() {
        sum = 0;
        val = 0;
    }

    public static int getSum() {
        return sum;
    }
}
