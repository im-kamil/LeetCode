class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		   int max = -1;
		   for (int i = 0; i < candies.length; i++) {
		   max = Math.max(candies[i], max);
		   }
		   List<Boolean> b = new ArrayList<>();
		   for (int i = 0; i < candies.length; i++) {
		   b.add(candies[i] + extraCandies >= max);
		   }
		   return b;
        // int max =-1;
        // for(int i:candies) {
        //     if(i>max) max = i;
        //     List<Boolean> res = new Arraylist<>();
        //     for(int i:candies){
        //         if(i+extraCandies>=max) res.add(true);
        //         else res.add(false);
        //     }
        // }
        // return res;
    }
}