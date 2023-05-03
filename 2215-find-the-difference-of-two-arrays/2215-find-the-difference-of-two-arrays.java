class Solution {
    public List<List<Integer>> findDifference(int[] a1, int[] a2) {
        Set<Integer> s1 = Arrays.stream(a1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(a2).filter(n -> !s1.contains(n)).boxed().collect(Collectors.toSet());
        Arrays.stream(a2).forEach(s1::remove);
        return Arrays.asList(new ArrayList<>(s1), new ArrayList<>(s2));
    }
}