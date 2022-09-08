class RangeModule {
 TreeSet<int[]> ts; 
    public RangeModule() {
        this.ts = new TreeSet<>((a,b) -> a[1] - b[1]);
    }
    
    public void addRange(int left, int right) {
        Iterator<int[]> iter = ts.tailSet(new int[]{0, left}, true).iterator();
        while (iter.hasNext()) {
            int[] temp = iter.next();
            if (temp[0] > right) break;
            
            left = Math.min(left, temp[0]);
            right = Math.max(right, temp[1]);
            iter.remove();
        }
        
        ts.add(new int[]{left, right});       
    }
    
    public boolean queryRange(int left, int right) {
        int[] ceiling = ts.ceiling(new int[]{0, right});  
        return ceiling != null && ceiling[0] <= left;
    }
    
    public void removeRange(int left, int right) {
        Iterator<int[]> iter = ts.tailSet(new int[]{0, left}, false).iterator();
        
        int[] front = null;
        int[] back = null;
        
        while (iter.hasNext()) {
            int[] temp = iter.next();
            if (temp[0] >= right) break;
            
            if (temp[0] < left) front = new int[]{temp[0], left};
            if (right < temp[1]) back = new int[]{right, temp[1]};
            iter.remove();
        }
        
        if (front != null) ts.add(front);
        if (back != null) ts.add(back);
        
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */