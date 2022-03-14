class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashSet set = new HashSet<>();
List l1 = new ArrayList();
int n=nums.length;
for(int i=0;i<n;i++){
if(set.contains(nums[i])){
l1.add(nums[i]);
}
set.add(nums[i]);
}
return l1;
    }
}