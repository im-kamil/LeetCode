class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
         List<List<String>> results = new ArrayList<>();

    if(products == null || products.length == 0) return results;

	// sort the products lexicographically
    Arrays.sort(products);

    for(int i = 1; i <= searchWord.length(); i++) {
        List<String> temp = new ArrayList<>();
        int count = 0;
        for(String product : products) {
            if(product.length() >= i && product.substring(0, i).equals(searchWord.substring(0, i))) {
                temp.add(product);
                count++;
                if(count >= 3) {
                    break;
                }
            }
        }
        results.add(temp);
    }

    return results;
    }
}