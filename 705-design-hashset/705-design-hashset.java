class MyHashSet {

 Integer[] internal = new Integer[100];

    public MyHashSet() {
        for (int i = 0; i < internal.length; i++){
            internal[i] = null;
        }
    }
    
    public void add(int key) {
        if (key >= internal.length){
            internal = Arrays.copyOf(internal, key+1);
        }
        if (internal[key] == null){
            internal[key] = key;
        }
    }
    
    public void remove(int key) {
        if (key >= internal.length){
            return;
        }
        internal[key] = null;
    }
    
    public boolean contains(int key) {
        return key < internal.length && internal[key] != null;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */