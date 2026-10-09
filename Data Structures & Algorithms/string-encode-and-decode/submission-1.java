class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        // length#string
        for(String s : strs) {
            result.append(s.length()).append('#').append(s);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            // get the size of string
            int j = i;
            while (str.charAt(j)!='#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));

            i = j+1;
            j = i+length;
            result.add(str.substring(i, j));
            i = j;
        }
        return result;
    }
}
