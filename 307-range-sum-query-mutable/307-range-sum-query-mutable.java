class NumArray {

   int a[];
    int total=0;
    public NumArray(int[] nums) {
        int i,l=nums.length;
        a=new int[l];
        
        for(i=0;i<l;i++)
        {
            a[i]=nums[i];
            total+=a[i];
        }
        
        
    }
    
    public void update(int index, int val) {
       
        total=total+val-a[index];
             a[index]=val;
    }
    
    public int sumRange(int left, int right) {
        int sum=total;
        int i;
        int start=left;
        int end=right;
        for(i=0;i<left;i++)
        {
            sum-=a[i];
        }
        for(i=right+1;i<a.length;i++)
            sum-=a[i];
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */