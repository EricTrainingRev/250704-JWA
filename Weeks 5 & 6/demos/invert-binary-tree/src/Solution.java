public class Solution {
    public TreeNode invertTree(TreeNode root) {
        //Recursive DFS
        //Base case
        if(root == null) return root;

        //do the swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //re-call method on both children
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
