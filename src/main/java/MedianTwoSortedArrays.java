public class MedianTwoSortedArrays {
    /**
     * https://www.geeksforgeeks.org/median-two-sorted-arrays-different-sizes-ologminn-m/
     * https://medium.com/@hazemu/finding-the-median-of-2-sorted-arrays-in-logarithmic-time-1d3f2ecbeb46 for better explanation
     *
     * @param a sorted array. a is the short array
     * @param b sorted array
     * @return the median of both arrays
     */
    public static double median(int[] a, int[] b) {
        if (a.length > b.length) {
            return median(b, a);
        }

        int aMinCount = 0;
        int aMaxCount = (a.length + b.length + 1) / 2;
        int leftHalfCount = (a.length + b.length + 1) / 2;

        int median = 0;

        int i  = 0;
        int j = 0;
        while (aMinCount <= aMaxCount) {
            i = (aMinCount + aMaxCount) / 2;
            j = leftHalfCount - i;

            if (i > 0 && j < b.length && a[i - 1] > b[j]) {
                aMaxCount = i - 1;
            } else if (j > 0 && i < a.length && b[j - 1] > a[i]) {
                aMinCount = i + 1;
            } else {
                if (j == 0) {
                    median = a[i - 1];
                } else if (i == 0) {
                    median = b[j - 1];
                } else {
                    median = Math.max(a[i - 1], b[j - 1]);
                }
                break;
            }
        }

        if ((a.length + b.length) % 2 == 1) {
            return median;
        }

        if (i == a.length) {
            return (median + b[j]) / 2.0;
        }
        if (j == b.length) {
            return (median + a[i]) / 2.0;
        }

        return (median + Math.min(a[i], b[j])) / 2.;
    }
}

