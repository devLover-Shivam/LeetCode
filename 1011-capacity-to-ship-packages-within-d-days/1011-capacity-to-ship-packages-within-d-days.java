class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //Lowest capacity of the ship of the ship should be the max value of weights then only all the packages will be shipped.
        int low =weights[0];
        for(int i =1;i<weights.length;i++){
            low = Math.max(low,weights[i]);
        }
        //(Minimum)Highest capacity of the ship should be the sum of all weights together so that they can be shipped in one go.
        int high = 0;
        for(int i =0;i<weights.length;i++){
            high += weights[i];
        }

        int ans  = 0;

        while(low<=high){
            int mid = low+(high-low)/2;
            int totalDays = func(weights,mid);
            if(totalDays<=days){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    //Helper function to calculate the total number of days that a certain wt capacity of ship will take to ship the packages.
    private int func(int weights[], int capacity){
        int currWt =0;
        int days = 1;
        for(int i=0;i<weights.length;i++){
            if(currWt + weights[i]> capacity){
                days++;
                currWt = weights[i];
            }
            else{
                currWt += weights[i];
            }
        }
        return days;
    }
}