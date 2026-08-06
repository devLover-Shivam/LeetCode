class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m*k > n) return -1;
        //Lowest number of days required for a single flower to bloom atleast.
        int low = bloomDay[0];
        for(int i = 0;i<n;i++){
            low = Math.min(low,bloomDay[i]);
        }
        //Highest number of days required for every flower to get bloomed.
        int high = bloomDay[n-1];
        for(int i = 0;i<n;i++){
            high = Math.max(high,bloomDay[i]);
        }
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(possible(bloomDay,mid,m,k)){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }

    private boolean possible(int bloomDay[], int day, int m , int k){
        int count = 0;
        int noOfB = 0;
        for(int i = 0; i < bloomDay.length;i++){
            if(bloomDay[i]<= day){
                count ++;
            }
            else{
                noOfB += count/k;
                count = 0;
            }
           
        }
        noOfB += count/k;
        if(noOfB>=m) return true;
        else return false;
    }
}