
class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();

        // Calculate factorial and store numbers from 1 to n-1
        for(int i = 1;i<n;i++){
            fact = fact*i;
            numbers.add(i);
        }

        // Add n as the last number
        numbers.add(n);

        String ans = "";

        // Convert 1-based k into 0-based index
        k = k-1;

        while(true){

            // Find which number's block contains the kth permutation
            ans = ans + numbers.get(k/fact);

            // Remove the selected number so it cannot repeat
            numbers.remove(k/fact);

            // If no numbers remain, permutation is complete
            if(numbers.size() == 0) break;

            // Find the remaining position inside the selected block
            k=k%fact;

            // Update factorial for the remaining numbers
            fact = fact/numbers.size();
        }

        return ans;
    }
}
