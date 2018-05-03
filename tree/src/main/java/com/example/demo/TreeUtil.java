package com.example.demo;

import java.util.LinkedList;

/**
 * @author yangxvhao
 * @date 18-4-24.
 */
public class TreeUtil {
    public static void show(TreeNode root){
        if(root == null)
            return;
        show(root.left);
        System.out.print(root.val + ",");

        show(root.right);
    }

    public static int showByLevel(TreeNode root){
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        treeNodes.add(root);
        int level = 0, length = 0;
        while (!treeNodes.isEmpty()){
            length = treeNodes.size();
            while (length > 0){
                TreeNode tempNode = treeNodes.poll();
                length--;
                if(tempNode != null) {
                    if(tempNode.left != null) {
                        treeNodes.add(tempNode.left);
                    }
                    if(tempNode.right != null) {
                        treeNodes.add(tempNode.right);
                    }
                    if(tempNode.right == null && tempNode.left == null){
                        return level;
                    }
                }else {
                    return 0;
                }
            }
            level++;
        }
        return level;
    } 
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left1 = new TreeNode(3);
        TreeNode left2 = new TreeNode(4);

        root.setLeft(left);
//        root.setRight(right);
        left.setLeft(left1);
//        right.setLeft(left2);
        
//        show(root);
        System.out.println(showByLevel(root));
    }
}
