// FRACTIONAL KNAPSACK PROBLEM USING THE GREEDY METHOD

import java.util.Arrays;
import java.util.Comparator;

class knapsack {
    float maxProfit(item arr[], int capacity) {

        // sorting the objects of item class based on pw ratio

        Arrays.sort(arr, new Comparator<item>() { // to sort on the basis of pw ratio we have to create our own logic
                                                  // using the comparator
            // comparator is the interface so we have to implement it using anonymous class
            @Override
            public int compare(item a1, item a2) { // in comparator interface , we have to overide abstract compare
                                                   // method which takes two arguments
                // if we return 1 then compare method will swap the values and if we return -1
                // then it will not swap the values

                float pw1 = (float) a1.profit / (float) a1.weight; // calculating the pw ratio
                float pw2 = (float) a2.profit / (float) a2.weight;

                if (pw1 < pw2) { // this will sort the objects of item class on basis of pw in descending order
                    return 1;
                } else
                    return -1;
            }
        });

        float maxP = 0;
        for (item i : arr) {

            int currP = (int) i.profit; // current profit and wieght
            int currW = (int) i.weight;

            if (capacity - currW >= 0) { // if there is enough space left for complete item weight
                maxP += currP; // adding the profit
                capacity = capacity - currW; // updating the remaining capacity

            } else { // if enough space for one item is not available then we will add the fraction
                     // of item in the conatianer
                float fraction = (float) capacity / currW; // calculating the fraction 
                maxP += fraction * (float) currP;
                capacity -= fraction * (float) currW;
                break;
            }
            System.out.println("remaining capacity = "+capacity);
        }

        return maxP;
    }
}

class item {
    int profit, weight;

    item(int x, int y) {
        profit = x;
        weight = y;
    }

}

public class a3_knapsack {
    public static void main(String[] args) {

        int capacity = 20; // let say the capacity of the contianer is 20

        item[] items = {
                new item(25, 18),
                new item(24, 15),
                new item(15, 10)
        };

        knapsack k = new knapsack();
        float ans = k.maxProfit(items, capacity);
        System.out.println(" maximum profit is = "+ans);

    }
}