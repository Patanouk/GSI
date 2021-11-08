package leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai)
 * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0)
 * Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int maxCapacity = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int capacityIJ = Math.min(height[i], height[j]) * (j - i);
                maxCapacity = Math.max(capacityIJ, maxCapacity);
            }
        }

        return maxCapacity;
    }

    public static int maxAreaTwoPointers(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;

        while (left < right) {
            int currentCapacity = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(result, currentCapacity);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxAreaTwoPointers(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
