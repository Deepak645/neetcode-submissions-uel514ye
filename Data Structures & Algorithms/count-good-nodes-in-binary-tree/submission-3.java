class Solution {
    int count = 0;
    Deque<Integer> stack = new ArrayDeque<>();

    public int goodNodes(TreeNode root) {
        helper(root);
        return count;
    }

    public void helper(TreeNode root) {
        if (root == null)
            return;

        if (stack.isEmpty()) {
            stack.offerLast(root.val);
            count++;
        } else {
            if (stack.peekLast() <= root.val) {
                count++;
                stack.offerLast(root.val);
            }
        }
        helper(root.left);
        helper(root.right);

        if (stack.peekLast() == root.val)
            stack.pollLast();

        return;
    }
}