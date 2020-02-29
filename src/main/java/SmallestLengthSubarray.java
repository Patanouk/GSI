import java.util.Arrays;

/*
https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 */
public class SmallestLengthSubarray {

    public static int[] getSmallestSubarrayQuadratic(int[] input, int maxValue) {
        int startingIndex = 0;
        int minLengthSoFar = Integer.MAX_VALUE;

        int currentTotal;
        int currentSubArrayLength;

        for (int i = 0; i < input.length; i++) {
            currentTotal = 0;
            currentSubArrayLength = 0;
            for (int j = i; j < input.length; j++) {
                currentTotal += input[j];
                currentSubArrayLength++;

                if (currentTotal > maxValue && currentSubArrayLength < minLengthSoFar) {
                    startingIndex = i;
                    minLengthSoFar = currentSubArrayLength;
                    break;
                }
            }
        }

        if (minLengthSoFar == Integer.MAX_VALUE) {
            return new int[]{};
        }

        return Arrays.copyOfRange(input, startingIndex, startingIndex + minLengthSoFar);
    }

    public static int[] getSmallestSubarrayLinear(int[] input, int maxValue) {
        int minLengthSoFar = Integer.MAX_VALUE;
        int startIndexSoFar = 0;
        int currentSum = 0;
        int startIndex = 0;

        for (int i = 0; i < input.length; i++) {
            currentSum += input[i];

            while (currentSum > maxValue) {
                if ((i - startIndex) < minLengthSoFar) {
                    minLengthSoFar = i - startIndex;
                    startIndexSoFar = startIndex;
                }
                currentSum -= input[startIndex];
                startIndex++;
            }
        }

        if (minLengthSoFar == Integer.MAX_VALUE) {
            return new int[]{};
        }
        return Arrays.copyOfRange(input, startIndexSoFar, startIndexSoFar + minLengthSoFar + 1);
    }
}
