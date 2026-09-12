
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // ans = final answer store karega, jisme saari valid combinations hongi

        findCombinations(0,candidates,target,ans,new ArrayList<>());
        // Recursion start: index 0 se start kar rahe hain
        // new ArrayList<>() = current combination (ds) initially empty hai

        return ans;
        // Saari valid combinations milne ke baad final answer return
    }

    private void findCombinations(int ind,int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        // ind   = abhi array ke kis element par khade hain
        // arr   = candidates array
        // target = abhi kitna sum banana baaki hai
        // ans   = final combinations
        // ds    = current combination jo hum bana rahe hain

        if(ind == arr.length){
            // Base case: array ke saare elements check ho chuke hain

            if(target==0){
                // Agar target exactly 0 ho gaya → valid combination mil gayi
                ans.add(new ArrayList<>(ds));
                // ds ki COPY ans mein daal rahe hain
                // COPY isliye, kyunki original ds recursion mein change hota rahega
            }

            return;
            // Is path ki recursion yahin khatam
        }

        if(arr[ind]<= target){
            // Agar current element target se chhota/equal hai
            // toh is element ko combination mein le sakte hain

            ds.add(arr[ind]);
            // Current element ko combination mein ADD kar diya

            findCombinations(ind, arr,target-arr[ind],ans,ds);
            // Element LIYA → target se uski value minus
            // ind same rakha hai → SAME element dobara bhi le sakte hain
            // Example: 2 liya toh next call mein bhi 2 available rahega

            ds.remove(ds.size()-1);
            // BACKTRACKING:
            // Jo element add kiya tha use hata do
            // taaki ab next possibility try kar sakein
        }

        findCombinations(ind+1, arr, target, ans, ds);
        // Element NAHI LIYA → next index par chale jao
        // target same rahega kyunki current element use nahi kiya
    }
}

