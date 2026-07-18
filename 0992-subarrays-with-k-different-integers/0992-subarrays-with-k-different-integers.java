class Solution {

    public int atMostKDistinct(int[] nums, int k){
        int left = 0;
        int right = 0;
        int count = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        while(right<nums.length){
            //including current element
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            //shrink window until distinct elements <=k
            while(map.size()>k){
                map.put(nums[left], map.get(nums[left])- 1);

                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }

                left++;
            }


            //all subarrays ending at 'right' are valid
            count += (right-left+1);

            right++;
        }

        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums,k) - atMostKDistinct(nums,k-1);
    }
}