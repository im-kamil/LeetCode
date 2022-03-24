class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> ans = new ArrayList<>();
    generateTotalWays(candidates,0,target,new ArrayList<Integer>(),ans);
    return ans;
    
}
public void generateTotalWays(int[] candidates,int currentIndex,int target,List<Integer>currentAns,List<List<Integer>> ans)
{
    if(target==0)
    {
        ans.add(new ArrayList<Integer>(currentAns));
        return;
    }
    if(currentIndex>=candidates.length)
        return;
    int currentVal=candidates[currentIndex];
    if(target>=currentVal)
    {
        currentAns.add(currentVal);
        generateTotalWays(candidates,currentIndex,target-currentVal,currentAns,ans);
        currentAns.remove(currentAns.size()-1);
    }
    
    generateTotalWays(candidates,currentIndex+1,target,currentAns,ans);
}
}
