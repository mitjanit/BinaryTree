
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
}