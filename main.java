import java.util.Scanner;
import java.util.ArrayList;

public class main{
	public static void main(String[] args){
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the initial sequence of values:");
		
		String input = "3 6 4 7 0 2 8";//reader.nextLine();
		String[] vals = input.split(" ");
		
		Integer[] values = new Integer[vals.length];
		
		for (int i = 0; i < vals.length; i++){
			values[i] = Integer.parseInt(vals[i]);
		}
		
		BinaryTree tree = new BinaryTree(values);
		System.out.print("Pre-order: ");
		tree.preorder();
		System.out.println();
		
		System.out.print("In-order: ");
		tree.inorder();
		System.out.println();
		
		System.out.print("Post-order: ");
		tree.postorder();
		System.out.println();
		
		help();
		boolean done = false;
		while (!done){
			System.out.println();
			System.out.println("Command? ");
			String s = reader.nextLine();
			String[] in = s.split(" ");
			if(!in[0].toLowerCase().equals("h") && !in[0].toLowerCase().equals("e") && in.length != 2){
				System.out.println("Invalid input!");
			}
			else if (in[0].toLowerCase().equals("i")){
				tree.addNode(Integer.parseInt(in[1]));
				tree.inorder();
			}
			else if (in[0].toLowerCase().equals("d")){
				//tree.delete(Integer.parseInt(in[1]));
				tree.inorder();
			}
			else if (in[0].toLowerCase().equals("p")){
				tree.predecessor(Integer.parseInt(in[1]));
			}
			else if (in[0].toLowerCase().equals("s")){
				tree.successor(Integer.parseInt(in[1]));
			}
			else if (in[0].toLowerCase().equals("e")){
				done = true;
			}
			else if (in[0].toLowerCase().equals("h")){
				help();
			}
			else{
				System.out.println("Invalid input!");
			}
		}
	}
	
	public static void help(){
		System.out.println("I  Insert a value");
		System.out.println("D  Delete a value");
		System.out.println("P  Find predecessor");
		System.out.println("S  Find successor");
		System.out.println("E  Exit the program");
		System.out.println("H  Display this message");
	}
	
}
