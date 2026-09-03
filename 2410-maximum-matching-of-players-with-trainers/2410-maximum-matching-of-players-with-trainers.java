class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int l = 0;//left ptr at players
        int r = 0;//right ptr at trainers
        int match = 0; //number of matchings
        while( l< players.length && r<trainers.length){
            if(players[l]<=trainers[r]){
                l++;
                match++;
            }
            r++;
        }
        return match;
    }
}