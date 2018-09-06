
class Node {

	int value;
	Node left;
	Node right;

	Node(int val){
		this.value = val;
		this.left = null;
		this.right = null;
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

	void visit() {
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

	void addNode(Node n) {
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