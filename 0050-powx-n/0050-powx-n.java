class Solution {
    public double myPow(double x, int n) {
        long power = n;
        if(power < 0){
            power = -power;
        }
        double ans = 1.0;
        while(power>0){
            if(power%2 == 1){
                ans = ans *x;
                power--;
            }else{
                power = power/2;
                x = x*x;
            }
        }

        if(n<0){
            ans = 1.0/ans;
        }
        return ans;
    }
}