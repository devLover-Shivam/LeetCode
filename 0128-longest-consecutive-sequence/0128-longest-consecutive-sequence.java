class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if(n==0) return 0;

        Set<Integer> st = new HashSet<>();

        int longest = 1;
        for(int i = 0;i<n;i++){
            st.add(nums[i]);
        }

        for(int it:st){
            int x = it;
            int cnt = 1;

            if(!st.contains(x-1)){
                while(st.contains(x+1)){
                    x = x+1;
                    cnt +=1;
                }
            }

            longest = Math.max(longest,cnt);
        }
        return longest;
    }
}