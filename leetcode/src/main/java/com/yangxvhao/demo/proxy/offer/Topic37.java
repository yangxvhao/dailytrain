package com.yangxvhao.demo.proxy.offer;

import java.util.LinkedList;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2022-12-31 16:48.
 */
public class Topic37 {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int _val) {
            val = _val;
        }

        public TreeNode(int _val, TreeNode _left, TreeNode _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.pop();
            if (node != null) {
                stringBuilder.append(node.val).append(",");
                linkedList.add(node.left);
                linkedList.add(node.right);
            } else {
                stringBuilder.append("null").append(",");
            }
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).append("]").toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] split = data.substring(1, data.length() - 1).split(",");
        if (split.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (!split[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(split[i]));
                queue.add(node.left);
            }
            i += 1;
            if (!split[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(split[i]));
                queue.add(node.right);
            }
            i += 1;
        }
        return root;
    }

    public static void main(String[] args) {
        Topic37 topic37 = new Topic37();
        TreeNode root = new TreeNode(1,
                new TreeNode(2), new TreeNode(3,
                new TreeNode(4), new TreeNode(5)));
        String serialize = topic37.serialize(root);
        System.out.println(serialize);
        TreeNode treeNode = topic37.deserialize("");
        System.out.println(treeNode.val);
    }
}
