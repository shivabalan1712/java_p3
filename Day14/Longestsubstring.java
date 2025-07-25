class Longestsubstring {
   public int lengthOfLongestSubstring(String s)   {
       int start =0,end = 0,result=0;
       List<Character> list = new ArrayList<Character>();
       while(end<s.length()) {
           if(!list.contains(s.charAt(end))) {
               list.add(s.charAt(end));
               end++;
               result = Math.max(result,list.size());
           }
           else {
               list.remove(Character.valueOf(s.charAt(start)));
               start++;
           }
       }
       return result;                      
   }
}

