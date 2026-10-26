
class Solution {
    public long sumDigitDifferences(int[] nums) {
        int n = nums.length;
        int digits = String.valueOf(nums[0]).length();

        long ans = 0;

        for (int pos = 0; pos < digits; pos++) {
            int[] count = new int[10];
            int divisor = (int) Math.pow(10, pos);

            for (int num : nums) {
                int digit = (num / divisor) % 10;
                count[digit]++;
            }

            for (int d = 0; d < 10; d++) {
                ans += (long) count[d] * (n - count[d]);
            }
        }

        return ans / 2;
    }
}
