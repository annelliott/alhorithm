package bt;
// 计算完全二叉树的节点数。
public class countNum {
	//计算左子树最左节点的层数  
	public static int mostLeftLevel(Node root)  
	{  
	    if(root == null)  
	        return 0;  
	    return mostLeftLevel(root.left)+1;  
	}  
	//递归计算完全二叉树节点个数  
	public static int countNodes(Node root)  
	{  
	    if(root == null)  
	        return 0;  
	    int left=mostLeftLevel(root.left);  
	    int right=mostLeftLevel(root.right);  
	    if(left == right)//左子树是满的  
	        return (1<<left)+countNodes(root.right);  
	    else //right < left 右子树是满的，且层数少一层  
	        return (1<<right)+countNodes(root.left);  
	} 
	public static void main(String[] args) {
		Node head = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		head.left = n1;
		head.right = n2;
		n1.left = n3;
		System.out.println(countNodes(head));
	}

}
