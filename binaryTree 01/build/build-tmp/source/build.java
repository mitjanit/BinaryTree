import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class build extends PApplet {


int value=10;
Tree tree;

public void setup(){
	createBinaryTree(30);
	tree.traverse();
	searchBinaryTree(value);

}


public void createBinaryTree(int num){
	tree = new Tree();
	for(int i=0; i<num; i++){
		tree.addValue((int)random(100));
	}
}

public void searchBinaryTree(int val){
	Node result = tree.search(val);
	if (result == null) {
	  println(val+" not found.");
	} else {
	  println(result.value+" found.");
	}
}


public void draw(){
}

public void mousePressed(){
	createBinaryTree(30);
	tree.traverse();
	searchBinaryTree(value);
}

class Node {

	int value;
	Node left;
	Node right;

	Node(int val){
		this.value = val;
		this.left = null;
		this.right = null;
	}

	public Node search(int val){
		if(this.value==val){
			return this;
		}
		else if (val < this.value && this.left != null) {
		  return this.left.search(val);
		} else if (val > this.value && this.right != null) {
		  return this.right.search(val);
		}
		return null;
	}

	public void visit() {
	  // Recursively go left
	  if (this.left != null) {
	    this.left.visit();
	  }
	  // Print out value
	  print(this.value+" ");
	  // Recursively go right
	  if (this.right != null) {
	    this.right.visit();
	  }
	}

	public void addNode(Node n) {
	  if (n.value < this.value) {
	    if (this.left == null) {
	      this.left = n;
	    } else {
	      this.left.addNode(n);
	    }
	  } else if (n.value > this.value) {
	    if (this.right == null) {
	      this.right = n;
	    } else {
	      this.right.addNode(n);
	    }
	  }
	}

}

class Tree {

	Node root;
	
	Tree(){
		root = null;
	}

	public void traverse(){
		root.visit();
		println();
	}

	public Node search(int val){
		return root.search(val);
	}

	public void addValue(int val){
		Node n = new Node(val);
		if(root == null){
			root = n;
		}
		else {
			root.addNode(new Node(val));
		}
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
