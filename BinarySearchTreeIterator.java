/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<Integer> s = new Stack<Integer>();

    public BSTIterator(TreeNode root) {
        helper(root);
    }
    public void helper(TreeNode root) {
        if(root == null)
            return;
        helper(root.right);
        s.push(root.val);
        helper(root.left);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if(!s.isEmpty())
            return s.pop();
        else
            return -1;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
