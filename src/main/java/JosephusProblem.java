//TODO Solve more complex version : https://www.geeksforgeeks.org/goldman-sachs-interview-experience-for-1-5-years-experienced/
public class JosephusProblem {

    /**
     * @param prisonerNumbers
     * @return
     */
    public static int josephus(int[] prisonerNumbers, int initialPosition) {
        if (prisonerNumbers.length == 0) {
            return -1;
        }

        if (prisonerNumbers.length == 1) {
            return prisonerNumbers[0];
        }

        return prisonerNumbers[josephus(prisonerNumbers.length, initialPosition)];
    }

    private static int josephus(int remainingPrisoners, int currentIndex) {
        if (remainingPrisoners == 0) {
            return 0;
        }
        int result = (josephus(remainingPrisoners - 1, currentIndex) + currentIndex) % remainingPrisoners;
        return result;
    }
}
