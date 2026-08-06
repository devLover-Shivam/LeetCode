class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = piles[0];
        for(int i =1;i<piles.length;i++){
            high = Math.max(high,piles[i]);
        }

        int ans = Integer.MAX_VALUE;

        while(low<=high){
            int mid = low+(high-low)/2;
            long totalHours = func(piles,mid);
            if(totalHours <= h){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }

    private long func(int piles[],int hourly){
        long totalHrs = 0;
        for(int i = 0;i<piles.length;i++){
            totalHrs += (long)Math.ceil((double)piles[i]/hourly);
        }
        return totalHrs;
    }
}