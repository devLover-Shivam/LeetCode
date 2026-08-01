class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxA = 0;
       Stack<Integer> st = new Stack<>();
       for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                int element = st.peek();
                st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1:st.peek();
                maxA = Math.max(maxA,(heights[element]*(nse-pse-1)));
            }
            st.push(i);
       } 
        while(!st.isEmpty()){
                int nse = n;
                int element = st.peek();
                st.pop();
                int pse = st.isEmpty() ? -1: st.peek();
                maxA = Math.max(maxA,(heights[element]*(nse-pse-1)));
        }
       return maxA;
    }
}