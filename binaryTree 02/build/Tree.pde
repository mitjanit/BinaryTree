
class Tree {

	Node root;
	
	Tree(){
		root = null;
	}

	void traverse(){
		root.visit(this.root);
		println();
	}

	Node search(int val){
		return root.search(val);
	}

	void addValue(int val){
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


	boolean contains(int val){
		return root.contains(val);
	}

	int findMinim() {
    	return (root.left == null) ? root.value : root.left.findMinim();
	}

	int findMaxim() {
    	return (root.right == null) ? root.value : root.right.findMaxim();
	}
}