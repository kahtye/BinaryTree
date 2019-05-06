import java.util.ArrayList;

//This class represents a Binary search tree
public class BinaryTree<T>{
	
	/**
	 * This field represents an Integer array of all the values
	 * in the Binary search tree 
	 */
	Integer[] values;
	
	
	/**
	 * This field represents an Integer array of all the values
	 * in the Binary search tree sorted in in-order 
	 */
	ArrayList<Integer> inorderVals = new ArrayList<Integer>();
	
	/**
	 * This field represents the root of the Binary search tree
	 */
	Node root; 
	
	
	/**
	 * This field represents a node in the binary tree that is
	 * used for adding more nodes
	 */
	Node currentNode;
	public BinaryTree(Integer[] values){
		this.values = values;
		root = new Node(values[0]);
		createTree();
	}
	
	/**
	 * This method uses a for loop to add each value
	 * from the values array into the binary tree
	 */
	public void createTree(){
		for (int i = 1; i < values.length; i++){
			addNode(values[i], root);
		}
	}
	
	/**
	 * This method adds a node into the binary tree
	 * @param newNode
	 */
	public void addNode(Integer newNode){
		if (findNode(newNode))
			return;
		int size = values.length;
		Integer vals[] = new Integer[size+1];
		for (int i = 0; i < size; i++){
			vals[i] = values[i];
		}
		vals[size++] = newNode;
		values = vals;
		
		addNode(newNode, root);
	}
	
	/**
	 * This method adds a node into the BST when also
	 * given a currentNode
	 * @param newNode
	 * @param currentNode
	 */
	public void addNode(Integer newNode, Node currentNode){
		if (newNode < currentNode.getData()){
			if (currentNode.hasLeftNode()){
				addNode(newNode, currentNode.getLeftNode());
			}
			else{
				currentNode.setLeftNode(newNode,currentNode);
				return;
			}
		}
		else{
			if (currentNode.hasRightNode()){
				addNode(newNode, currentNode.getRightNode());
			}
			else{
				currentNode.setRightNode(newNode,currentNode);
				return;
			}
		}
	}
	
	public void delete(Integer num){
		delete(num, root);
	}
	/**
	 * This method checks whether or not the desired value
	 * is in the left subtree or the right subtree
	 * @param num
	 * @param n
	 */
	public void delete(Integer num, Node n){
		if (n != null){
			if (num == n.getData()){
				removeFromRoot(n);
			}
			else if (num < n.getData()){
				delete(num, n.getLeftNode());
			}
			else{
				delete(num, n.getRightNode());
			}
		}
	}
	
	/**
	 * This method uses the three cases to determine
	 * which node should replace the node given as a
	 * parameter
	 * @param n
	 */
	public void removeFromRoot(Node n){
		Node p = n.getParent();
		boolean isRightNode = false;
		
		if (p.getRightNode().getData() == n.getData()){
			isRightNode = true;
		}
		if (n.getLeftNode() == null && n.getRightNode() == null){ //no children{
			if (p.getLeftNode().getData() == n.getData()){
				p.removeLeftNode();
			}
			p.removeRightNode();
		}
		
		else if (n.getLeftNode() == null || n.getRightNode() == null){ //has 1 child
			if (isRightNode){
				if (n.getRightNode() == null)
					p.setRightNode(n.getLeftNode());
			}
			else{
				if (n.getLeftNode() == null)
					p.setLeftNode(n.getRightNode());
			}
		}
		
		else{
			Node leftMost = findLeftMost(n.getRightNode());
			if (isRightNode)
				p.setRightNode(leftMost);
			else
				p.setLeftNode(leftMost);
		}
		
	}
	
	/**
	 * This method finds the leftmost node 
	 * given the root
	 * @param n
	 * @return
	 */
	public Node findLeftMost(Node n){
		if (n.getLeftNode() == null){
			return n;
		}
		findLeftMost(n.getLeftNode());
		return null;
	}
	
	
	public void preorder(){
		preorder(root);
	}
	
	public void preorder(Node n){
		if (n == null){
			return;
		}
		System.out.print(n.getData() + " ");
		preorder(n.getLeftNode());
		preorder(n.getRightNode());
	}
	
	public void inorder(){
		inorder(root);
	}
	
	public void inorder(Node n){
		if (n == null){
			return;
		}
		inorder(n.getLeftNode());
		System.out.print(n.getData() + " ");
		inorder(n.getRightNode());
	}
	
	
	public void postorder(){
		postorder(root);
	}
	
	public void postorder(Node n){
		if (n == null){
			return;
		}
		postorder(n.getLeftNode());
		postorder(n.getRightNode());
		System.out.print(n.getData() + " ");
		
	} 
	
	public boolean findNode(Integer n){
		for (int i = 0; i < values.length; i++){
			if (values[i] == n){
				return true;
			}
		}
		return false;
	}
	

	

	public void predecessor(Integer num){
		if (!findNode(num))
			System.out.println(num + " is an invalid value!");
		createInorderArray(root);
		int index = 0;
		for (int i = 0; i < inorderVals.size(); i++){
			if (inorderVals.get(i) == num){
				index = i;
			}
		}
		if (index > 0)
			System.out.println(inorderVals.get(index-1));
		else
			System.out.println("There is no predececssor :(");
		inorderVals.clear();
	}
	

	public void successor(Integer num){
		if (!findNode(num))
			System.out.println(num + " is an invalid value!");
		createInorderArray(root);
		int index = 0;
		for (int i = 0; i < inorderVals.size(); i++){
			if (inorderVals.get(i) == num){
				index = i;
			}
		}
		if (index < inorderVals.size()-1)
			System.out.println(inorderVals.get(index+1));
		else
			System.out.println("There is no predececssor :(");
		inorderVals.clear();
	}
	
	public void createInorderArray(Node n){
		if (n == null){
			return;
		}
		createInorderArray(n.getLeftNode());
		inorderVals.add(n.getData());
		createInorderArray(n.getRightNode());
	}
	
	
}
