import java.util.Arrays;

public class LargestDecreasingSubarray {

    /*
    https://www.geeksforgeeks.org/goldman-sachs-interview-experience-for-1-5-years-experienced/
     */
    public static int[] largestDecreasingSubarray(int[] initialArray) {
        if (initialArray == null || initialArray.length == 0) {
            return new int[0];
        }

        int maxLength = 1;
        int startPosition = 0;

        for (int i = 0; i < initialArray.length - 1; i++) {
            for (int j = i; j < initialArray.length - 1; j++) {
                if (initialArray[j] < initialArray[j + 1]) {
                    i = j;
                    break;
                }

                if (maxLength < j - i + 2) {
                    maxLength = j - i + 2;
                    startPosition = i;
                }
            }
        }

        return Arrays.copyOfRange(initialArray, startPosition, startPosition + maxLength);
    }

    //TODO
    public static int[] largestCircularDecreasingSubarray(int[] initialArray) {
        if (initialArray == null || initialArray.length == 0) {
            return new int[0];
        }

        int maxLength = 1;
        int startPosition = 0;

        for (int i = 0; i < initialArray.length - 1; i++) {
            for (int j = i; j < initialArray.length - 1; j++) {
                if (initialArray[j] < initialArray[j + 1]) {
                    i = j;
                    break;
                }

                if (maxLength < j - i + 2) {
                    maxLength = j - i + 2;
                    startPosition = i;
                }
            }
        }

        return Arrays.copyOfRange(initialArray, startPosition, startPosition + maxLength);
    }
}
