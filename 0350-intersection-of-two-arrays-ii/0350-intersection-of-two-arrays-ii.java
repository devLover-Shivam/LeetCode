class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        //we need to sort the arrays first
        Arrays.sort(nums1);
        Arrays.sort(nums2);
       
        ArrayList <Integer> ans = new ArrayList <>();

        int i =0;
        int j =0;

        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums2[j]<nums1[i]){
                j++;
            }
            else{
                ans.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[ans.size()];

        for(int k = 0; k < ans.size(); k++){
            result[k] = ans.get(k);
        }

        return result;

    }
}