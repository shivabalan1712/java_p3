class Solution {
    public static int reverse(int x) {
        int r = 0;
        while(x!=0) {
            int d = x%10;
            x = x/10;
            r = (d*10)+r;
            
        }
        return r;
    }
    public static void main(String[] args) {
    	int m = 123;
    	System.out.println(reverse(m));
    }
}
