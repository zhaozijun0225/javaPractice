package leetcode;

public class T19 {
	public static ListNode test(ListNode head, int n) {
		ListNode tmp=head,ans=new ListNode(9,head),tmp2=null;
		
		for (int i = 0; i < n; i++) {
			if(tmp==null)
				return head;
			tmp=tmp.next;
			
		}
		
		
		tmp2=ans;
		while(tmp!=null) {
			tmp2=tmp2.next;
			tmp=tmp.next;
			head=head.next;
		}
		tmp2.next=head.next;
		
		return ans.next;
		
	}

	public static void main(String[] args) {
		int n = 0;
		ListNode head = null;
		T19.test(head, n = 10);
		return;

	}
}
