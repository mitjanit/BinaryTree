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
	
	background(0);

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
	background(0);
	createBinaryTree(30);
	tree.traverse();
	searchBinaryTree(value);
}

class Node {

	int value;
	Node left;
	Node right;

	float distance;
	PVector pos;

	Node(int val){
		this.value = val;
		this.left = null;
		this.right = null;

		this.distance = 2.5f;
		this.pos = new PVector(0,0);
	}

	Node(int val, float x, float y){
		this.value = val;
		this.left = null;
		this.right = null;

		this.pos = new PVector(x, y);
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

	public void visit(Node parent) {
	  // Recursively go left
	  if (this.left != null) {
	    this.left.visit(this);
	  }
	  // Display
	  stroke(100);
	  line(parent.pos.x, parent.pos.y, this.pos.x, this.pos.y);
	  
	  stroke(255); fill(0);
	  ellipse(this.pos.x, this.pos.y, 24, 24);
	   
	  noStroke();fill(255);
	  textAlign(CENTER); textSize(12);
	  text(this.value, this.pos.x, this.pos.y + 4);

	  // Recursively go right
	  if (this.right != null) {
	    this.right.visit(this);
	  }
	}

	public void addNode(Node n) {
	  if (n.value < this.value) {
	    if (this.left == null) {
	      this.left = n;
	      this.left.pos.x = this.pos.x - 5 - ((width-30) / pow(n.distance,2));
      	  this.left.pos.y = this.pos.y + (height / 12);
	    } else {
	    	n.distance++;
	      	this.left.addNode(n);
	    }
	  } else if (n.value > this.value) {
	    if (this.right == null) {
	      this.right = n;
	      this.right.pos.x = this.pos.x + 5 + ((width-30) / pow(n.distance, 2));
	      println((width / pow(2, n.distance)));
      	  this.right.pos.y = this.pos.y + (height / 12);
	    } else {
	    	n.distance++;
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
		root.visit(this.root);
		println();
	}

	public Node search(int val){
		return root.search(val);
	}

	public void addValue(int val){
		Node n = new Node(val);
		if(root == null){
			root = n;
			root.pos.x = width / 2;
    		root.pos.y = 50;
		}
		else {
			root.addNode(n);
		}
	}
}
  public void settings() { 	size(800,800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
