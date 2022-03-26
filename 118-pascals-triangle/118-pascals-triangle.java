class Solution {
    public List<List<Integer>> generate(int numRows) {
        
       List<List<Integer>> arr = new ArrayList<List<Integer>>();
    for(int i=0 ; i<numRows ; i++){
        ArrayList<Integer> num  = new ArrayList<>(i+1);
       for(int k=0;  k<(i+1); k++){
            if(k==0){
                num.add(1);
            }else{
                if(k!=i)
                   num.add(arr.get(i-1).get(k-1)+arr.get(i-1).get(k));  
                else
                    num.add(1);
            }
            
          }
        arr.add(num);
    }
    return arr;
    }
}