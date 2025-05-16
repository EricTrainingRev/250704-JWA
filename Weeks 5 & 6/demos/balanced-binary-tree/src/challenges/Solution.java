package challenges;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isBalanced(TreeNode root) {
        //DFS depth first search
        //work your way down counting how many levels you get
        //make sure you work your way down all branches
        //compare all of the depths you gathered to make sure for any two |x-y| <= 1


        /**
         * This solution solves the problem as I understood it, but apparently my understanding was flawed.
         * This solution fails on the test case [1,2,3,4,5,6,null,8], returning false. I had thought this was correct.
         * I must have misunderstood the problem.
         */

        TreeNode node = root;

        System.out.println("Node: " + node.val);
        if(node.left != null) System.out.println("Left child: " + node.left.val);
        if(node.right != null) System.out.println("Left child: " + node.right.val);



        if(root == null) return true;

        // pass-by-value - each time we call a method/function we copy the parameters passed to the function
        // pass-be-reference - when we call a method/function we pass the reference to the variable
        Set<Integer> depthSet = new HashSet<>();
        depthSearch(depthSet, root, 0);

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(Integer depth : depthSet) {
            if(depth < min) min = depth;
            if(depth > max) max = depth;
        }
        return max - min <= 1;
    }

    void depthSearch(Set<Integer> depthSet, TreeNode node, int depth) {
        if(node.left == null && node.right == null) {
            depthSet.add(depth);
        }

        if(node.left != null) {
            depthSearch(depthSet, node.left, depth + 1);
        }

        if(node.right != null) {
            depthSearch(depthSet, node.right, depth + 1);
        }
    }
}

