class Solution {
    public int search(int[] nums, int target) {
        return recurse(nums, 0, nums.length-1, target);

    }

    public int recurse(int[] nums, int begin, int end, int target) {
        int midpoint = begin + ((end - begin)/2);

        //Base case - found it
        if(nums[midpoint] == target) {
            return midpoint;
        }

        //Base case - didn't find it
        if(end <= begin) {
            return -1;
        }

        //Recurse until we find it
        if(target < nums[midpoint]) {
            return recurse(nums, begin, midpoint-1, target);
        } else {
            return recurse(nums, midpoint+1, end, target);
        }
    }
}
