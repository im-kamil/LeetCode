class Solution {
    public boolean makesquare(int[] matchsticks) {
       Long sum=0l;
        for(int i:matchsticks) sum=sum+i;
        
        if(sum%4!=0 || matchsticks.length<4) return false;
        
        long target = sum/4;
        Arrays.sort(matchsticks);
        long sum1=0,sum2=0,sum3=0,sum4=0;
        return helper(matchsticks,matchsticks.length-1,sum1,sum2,sum3,sum4,target);
    }
    public boolean helper(int[] a,int i,long sum1, long sum2, long sum3, long sum4, long target)
    {
        if(sum1>target || sum2>target || sum3>target || sum4>target) return false;
        if(i==-1)
        {
            if(sum1==target && sum2==target && sum3==target && sum4==target) return true;
            else return false;
        }
        
        return helper(a, i-1, sum1+a[i], sum2,sum3, sum4,target) ||
        helper(a, i-1, sum1, sum2+a[i],sum3, sum4,target)     ||
            helper(a, i-1, sum1, sum2,sum3+a[i], sum4,target)||
            helper(a, i-1, sum1, sum2,sum3, sum4+a[i],target);
    
    }
}