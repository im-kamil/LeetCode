class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start == end)
			return 1;
		Set<String> visited = new HashSet<>();
		Set<String> bankSet = new HashSet<>();
		for(String b : bank) {
			bankSet.add(b);
		}
		Queue<GeneHop> queue = new LinkedList<>();
		visited.add(start);
		queue.add(new GeneHop(start , 1));
		while(! queue.isEmpty()) {
			GeneHop next = queue.poll();
			if(next.mutation.equals(end)) {
				return next.step - 1;
			}
			for(int i = 0 ; i < 8 ; i++) {
				for(char c : new char[] {'A', 'C', 'G', 'T'}) {
					String temp = next.mutation.substring(0, i) + c + next.mutation.substring(i + 1);
					if(bankSet.contains(temp) && !visited.contains(temp)) {
						visited.add(temp);
						queue.add(new GeneHop(temp , next.step + 1));
					}
				}
			}
		}
        return -1;
    }
}

public class GeneHop {
	String mutation;
	int step;
	GeneHop(String mutation , int step) {
		this.mutation = mutation;
		this.step = step;
    }
}