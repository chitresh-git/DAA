

public class demo  {

    public static boolean isSubsetSum(int[] set, int n, int sum) {
        return isSubsetSum(set, n, sum, 0);
    }

    private static boolean isSubsetSum(int[] set, int n, int sum, int currentIndex) {
        if (sum == 0) {
            return true;
        }

        if (currentIndex == n) {
            return false;
        }

        // Include the current element in the subset
        if (set[currentIndex] <= sum && isSubsetSum(set, n, sum - set[currentIndex], currentIndex + 1)) {
            System.out.println(currentIndex);
            return true;
        }

        // Exclude the current element from the subset
        return isSubsetSum(set, n, sum, currentIndex + 1);
    }

    public static void main(String[] args) {
        int[] set = {4, 6, 1, 5, 6, 2};
        int sum = 9;
        int n = set.length;

        if (isSubsetSum(set, n, sum)) {
            System.out.println("Subset with the given sum exists.");
        } else {
            System.out.println("No subset with the given sum exists.");
        }
    }
}

