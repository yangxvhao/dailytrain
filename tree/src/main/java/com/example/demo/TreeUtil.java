package com.example.demo;

import java.util.LinkedList;

/**
 * @author yangxvhao
 * @date 18-4-24.
 */
public class TreeUtil {

  public static void inOrderShow(TreeNode root) {
    if (root == null) {
      return;
    }
    inOrderShow(root.left);
    System.out.print(root.val + ",");
    inOrderShow(root.right);
  }

  public static void preOrderShow(TreeNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.val + ",");
    preOrderShow(root.left);
    preOrderShow(root.right);
  }

  public static void postOrderShow(TreeNode root) {
    if (root == null) {
      return;
    }
    postOrderShow(root.left);
    postOrderShow(root.right);
    System.out.print(root.val + ",");
  }

  public static int showByLevel(TreeNode root) {
    LinkedList<TreeNode> treeNodes = new LinkedList<>();
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      System.out.print(root.val);
      return 1;
    }
    treeNodes.add(root);
    int level = 0, length = 0;
    while (!treeNodes.isEmpty()) {
      length = treeNodes.size();
      while (length > 0) {
        TreeNode tempNode = treeNodes.poll();
        length--;
        if (tempNode != null) {
          System.out.print(tempNode.val + ",");
          if (tempNode.left != null) {
            treeNodes.add(tempNode.left);
          }
          if (tempNode.right != null) {
            treeNodes.add(tempNode.right);
          }
        } else {
          return 0;
        }
      }
      level++;
    }
    return level;
  }

  public static void main(String[] args) {
    TreeNode root = buildTree();
    System.out.print("中序遍历：");inOrderShow(root);System.out.println();
    System.out.print("前序遍历：");preOrderShow(root);System.out.println();
    System.out.print("后序遍历：");postOrderShow(root);System.out.println();
    System.out.print("广度遍历：");
    System.out.println("深度：" + showByLevel(root));
  }

  /**
   *       0
   *    1       2
   *  3   4   5   6
   * 7 8 9
   *
   * @return
   */
  public static TreeNode buildTree() {
    TreeNode root = new TreeNode();
    TreeNode left = new TreeNode(1);
    TreeNode right = new TreeNode(2);
    TreeNode left1 = new TreeNode(3);
    TreeNode right1 = new TreeNode(4);
    TreeNode left2 = new TreeNode(5);
    TreeNode right2 = new TreeNode(6);
    TreeNode left3 = new TreeNode(7);
    TreeNode right3 = new TreeNode(8);
    TreeNode left4 = new TreeNode(9);

    root.setLeft(left);
    root.setRight(right);

    left.setLeft(left1);
    left.setRight(right1);
    right.setLeft(left2);
    right.setRight(right2);

    left1.setLeft(left3);
    left1.setRight(right3);
    right1.setLeft(left4);

    return root;
  }
}
