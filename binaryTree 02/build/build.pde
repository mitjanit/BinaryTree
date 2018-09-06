
int value=10;
Tree tree;

void setup(){
	createBinaryTree(30);
	tree.traverse();
	searchBinaryTree(value);

}


void createBinaryTree(int num){
	tree = new Tree();
	for(int i=0; i<num; i++){
		tree.addValue((int)random(100));
	}
}

void searchBinaryTree(int val){
	Node result = tree.search(val);
	if (result == null) {
	  println(val+" not found.");
	} else {
	  println(result.value+" found.");
	}
}


void draw(){
}

void mousePressed(){
	createBinaryTree(30);
	tree.traverse();
	searchBinaryTree(value);
}