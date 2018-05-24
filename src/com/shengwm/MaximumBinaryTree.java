package com.shengwm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 654 最大二叉树
 *
 * @author shengwm
 * @create 2018-05-24 15:25
 **/
public class MaximumBinaryTree {


    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        int max = getMaxNumber(nums);
        TreeNode root = new TreeNode(max);
        System.out.println(root.val);
        root.left = constructMaximumBinaryTree(getArrayLeftPart(max, nums));
        root.right = constructMaximumBinaryTree(getArrayRightPart(max, nums));
        return root;
    }


    public static int getMaxNumber(int[] nums) {
        int[] tempArray = nums.clone();
        Arrays.sort(tempArray);
        return tempArray[tempArray.length - 1];
    }


    public static int[] getArrayLeftPart(int spilt, int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == spilt) {
                break;
            }
            list.add(nums[i]);
        }
        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }
        return result;
    }


    public static int[] getArrayRightPart(int spilt, int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == spilt) {
                break;
            }
            list.add(nums[i]);
        }
        int[] result = new int[list.size()];
        for (int k = list.size() - 1; k >= 0; k--) {
            result[list.size() - k - 1] = list.get(k);
        }
        return result;
    }



    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        return constructMax(nums,0,nums.length);
    }
    private TreeNode constructMax(int[] nums, int i, int length) {
        if(i == length) {
            return null;
        }

        int rootIndex = findMaxRoot(nums,i,length);
        TreeNode node = new TreeNode(nums[rootIndex]);
        System.out.println(node.val);
        node.left = constructMax(nums,i,rootIndex);
        node.right = constructMax(nums,rootIndex+1,length);
        return node;
    }

    private int findMaxRoot(int[] nums, int s, int e) {
        int index = s;
        for(int i = s; i<e; i++) {
            if(nums[index] < nums[i]) {
                index = i;
            }
        }
        return index;
    }




    public static void main(String[] args){
        int[] nums = {3,2,1,6,0,5};
        TreeNode treeNode = constructMaximumBinaryTree(nums);

        MaximumBinaryTree tree = new MaximumBinaryTree();
        TreeNode treeNode1 = tree.constructMaximumBinaryTree1(nums);
    }
}
