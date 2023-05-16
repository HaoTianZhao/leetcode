package 剑指offer第二版.medium;

import java.util.HashMap;

/*
输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

示例 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
示例 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]

限制：
0 <= 节点个数 <= 5000

 */
public class _007重建二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int index = 0;
    HashMap<Integer, Integer> value2IndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        // 构建inorder值到下标的map, 递归时不用循环查找
        for (int idx = 0; idx < inorder.length; idx++) {
            value2IndexMap.put(inorder[idx], idx);
        }

        int val = preorder[index];
        TreeNode tree = new TreeNode(val);
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) {
                index++;
                // index是preorder的游标. 此时[0-i)是树的左侧, [i,end)是树的右侧, 进行递归
                tree.left = buildTree(preorder, inorder, 0, i);
                tree.right = buildTree(preorder, inorder, i + 1, inorder.length);
                return tree;
            }
        }
        return tree;
    }

    TreeNode buildTree(int[] preorder, int[] inorder, int left, int right) {
        if (left > preorder.length || index > preorder.length - 1) {
            return null;
        }
        int val = preorder[index];
        Integer i = value2IndexMap.get(val);
        if (i == null || i < left || i >= right) {
            return null;
        }
        index++;
        TreeNode node = new TreeNode(val);
        node.left = buildTree(preorder, inorder, left, i);
        node.right = buildTree(preorder, inorder, i + 1, right);
        return node;
    }
}
