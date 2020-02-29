public class MinEnergyCrossing {

    public static int minEnergy(int[] checkpoints) {
        int minEnergy = 0;

        int currentEnergy = 0;
        for (int checkpoint : checkpoints) {
            currentEnergy += checkpoint;

            if (currentEnergy < 0) {
                minEnergy += Math.abs(currentEnergy) + 1;
                currentEnergy = 1;
            }
        }
        return Math.max(minEnergy, 1);
    }
}
