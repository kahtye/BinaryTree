
public class Node {
	Integer data;
	Node leftNode;
	boolean left;
	Node rightNode;
	boolean right;

	Node parent;
	
	public Node(){
		
	}
	
	public Node(Integer data){
		this.data = data;
	}
	
	public Node(Integer data, Node parent){
		this.data = data;
		this.parent = parent;
	}
	
	public Integer getData(){
		return data;
	}
	
	public Node getLeftNode(){
		return leftNode;
	}
	
	public Node getRightNode(){
		return rightNode;
	}
	
	public Node getParent(){
		return parent;
	}
	
	public void setLeftNode(Integer d, Node parent){
		this.parent = parent;
		leftNode = new Node(d);
		left = true;
	}
	
	public void setLeftNode(Node n){
		leftNode = n;
		left = true;
	}
	
	
	public void setRightNode(Integer d, Node parent){
		this.parent = parent;
		rightNode = new Node(d);
		right = true;
	}
	
	public void setRightNode(Node n){
		rightNode = n;
		right = true;
	}
	
	public void removeLeftNode(){
		leftNode = null;
		left = false;
	}
	
	public void removeRightNode(){
		rightNode = null;
		right = false;
	}
	
	public boolean hasLeftNode(){
		return left;
	}
	
	public boolean hasRightNode(){
		return right;
	}
	
}
