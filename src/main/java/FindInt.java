public class FindInt {
    public static boolean find(int[] data, int target) {
        for (final int datum : data) {
            if (datum == target) {
                return true;
            }
        }
        return false;
    }
}
