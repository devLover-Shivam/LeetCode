class Solution {
    static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
          while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))return false;
          }
          return true;
    }
    static void getAllParts(String s,List<String> partitions,List<List<String>> ans ){
        if(s.length() == 0){
            ans.add(new ArrayList<>(partitions));
            return;
        }
        for(int i = 0 ;i<s.length();i++){
            String part = s.substring(0,i+1);
            if(isPalindrome(part)){
                partitions.add(part);
                getAllParts(s.substring(i+1),partitions,ans);
                partitions.remove(partitions.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        List<String> partitions = new ArrayList<>();

        getAllParts(s,partitions,ans);

        return ans;

    }
}