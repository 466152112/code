// Round 2 is awesome! from Augest 21st, 2015
// Round 3, what if valid BST from preorder traverse?
int pos;
public boolean isPreOrderBST(int[] array) {
    if (array == null || array.length == 0) {
        return false;
    }
    pos = 0;
    findPreOrder(array, array[0],Integer.MIN_VALUE, Integer.MAX_VALUE);
    return pos == array.length;
}
private void findPreOrder(int[] array, int key, int min, int max) {
    if (pos == array.length) {
        return;
    }
    if (key > min && key < max) {
        pos++;
        if (pos < array.length) {
            findPreOrder(array, array[pos], min, key);
            findPreOrder(array, array[pos], key, max);
        }
    }
}

// Round 2, 少年，这题简单的狠，看我one pass一下
public boolean isValidBST(TreeNode root) {
    if (root == null || root.left == null && root.right == null)
        return true;
    TreeNode node = root;
    // check max value of left subtree
    if (node.left != null) {
        node = node.left;
        while (node.right != null)
            node = node.right;
        if (root.val <= node.val)
            return false;
    }
    // check min value of right subtree
    node = root;
    if (node.right != null) {
        node = node.right;
        while (node.left != null)
            node = node.left;
        if (root.val >= node.val)
            return false;
    }
    // recursive
    if (!isValidBST(root.left) || !isValidBST(root.right))
        return false;
    return true;
}

// ai, yao yong dao in-order traversal a
// 今天真他妈不爽啊，一题都没思路！又被老板push 批评，ciao啊。好不容易看到一个简单的题，尼玛还大意地想错了，用神马DP递归，这题哪能用DP啊
public class Solution {
  private int lastValue = Integer.MIN_VALUE;
  private boolean first = false; // fix bug, the first number is Integer.MIN_VALUE
  public boolean isValidBST(TreeNode root) {
      if (root == null)
          return true;
      // left first
      if (!isValidBST(root.left))
          return false;
      // check root, ture then set new lastValue, no need add to result
        if (first && lastValue >= root.val)
            return false;
        lastValue = root.val;
        if (first == false)
            first = true;
      // finally go right
      if (!isValidBST(root.right))
          return false;
      return true;
  }
}
