class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[?!.', :]", "");

        if(s.length() < 2) {
            return true;
        }

        int left = 0;
        int right = s.length()-1;

        while(right >= left) {
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            right--;
            left++;
        }

        return true;
    }
}
