import java.util.*;

class Solution {

    // Next Smaller Element ka index nikalne ke liye
    private int[] findNSE(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        return ans;
    }

    // Previous Smaller or Equal Element ka index
    private int[] findPSEE(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        return ans;
    }

    public int sumSubarrayMins(int[] arr) {

        int mod = (int) 1e9 + 7;

        int[] nse = findNSE(arr);

        int[] psee = findPSEE(arr);

        long total = 0;

        for (int i = 0; i < arr.length; i++) {

            int left = i - psee[i];
            int right = nse[i] - i;
            // right * left * arr[i]
            // int overflow ho sakta hai.

            long contribution = (1L * left * right * arr[i]) % mod;

            total = (total + contribution) % mod;
        }

        return (int) total;
    }
}