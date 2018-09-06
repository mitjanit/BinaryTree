
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

		this.distance = 2.5;
		this.pos = new PVector(0,0);
	}

	Node(int val, float x, float y){
		this.value = val;
		this.left = null;
		this.right = null;

		this.pos = new PVector(x, y);
	}

	Node search(int val){
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

	void visit(Node parent) {
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

	void addNode(Node n) {
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