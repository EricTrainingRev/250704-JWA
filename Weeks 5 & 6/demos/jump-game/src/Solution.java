class Solution {
    public boolean canJump(int[] nums) {
        //identify the goal, nums.length-1
        //start looping from the end of nums toward the beginning, starting at nums.length-2
        //if the element can reach the goal, continue backward through the array considering this space as the new goal.
        //      knowing that from this space we can reach the goal because we've already solved that.
        //continue looping until we either reach the beginning of the array, returning true, or until we run
        //      out of moves, returning false.



        int goal = nums.length-1;
        for(int i = nums.length-2; i >= 0; i--) {
            if(i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}
