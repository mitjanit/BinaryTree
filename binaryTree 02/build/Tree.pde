
class Tree {

	Node root;
	
	Tree(){
		root = null;
	}

	void traverse(){
		root.visit();
		println();
	}

	Node search(int val){
		return root.search(val);
	}

	void addValue(int val){
		Node n = new Node(val);
		if(root == null){
			root = n;
		}
		else {
			root.addNode(new Node(val));
		}
	}
}