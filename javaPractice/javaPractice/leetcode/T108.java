package leetcode;

import java.text.DateFormatSymbols;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.runners.model.FrameworkField;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class nID{
	int left;
	int right;
	TreeNode fatherNode;
	public nID(int left,int right,TreeNode fatherNode) {
		this.left=left;
		this.right=right;
		this.fatherNode=fatherNode;
	}
}


public class T108{
	

	public static void main(String[] args) {
		int[] nums = new int[] {-10,-3,0,5,9};
		
		TreeNode ans,tmpNode;
		nID tmpId;
		int mid;
		Queue<nID> q=new LinkedList<nID>();
		
		mid = nums.length/2;
		ans = new TreeNode(nums[mid]);
		if(nums.length == 1)
			return;
		
		
		q.add(new nID(0, mid-1,ans));
		q.add(new nID(mid+1,nums.length-1,ans));
		
		
		

		while(!q.isEmpty()) {
			tmpId = q.poll();
			
			if(tmpId.left>tmpId.right)
				continue;

			mid = (tmpId.left+tmpId.right+1)/2;
			tmpNode = new TreeNode(nums[mid]);
			
			if(nums[mid]>=tmpId.fatherNode.val && null==tmpId.fatherNode.right) {
	
				tmpId.fatherNode.right=tmpNode;
			}
			else {
				tmpId.fatherNode.left=tmpNode;
			}
				
			if(mid-tmpId.left<=1) {
				tmpNode.left=mid-tmpId.left==0?null:new TreeNode(nums[tmpId.left]);
			}
			else {
				q.add(new nID(tmpId.left, mid-1, tmpNode));
			}
			
			
			if(tmpId.right-mid<=1) {
				tmpNode.right=tmpId.right-mid==0?null:new TreeNode(nums[tmpId.right]);
			}
			else {
				q.add(new nID(mid+1, tmpId.right, tmpNode));
			}
			
			
			
		}
		
		

		
		
		
		
		
		return;

	}
	
	
}