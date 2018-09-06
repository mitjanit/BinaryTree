
int value=10;
int num = 30;
Tree tree;

void setup(){
	size(1400,800);
	background(0);

	createBinaryTree(num);
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

	String message= (tree.contains(val)) ? "Tree contains "+val+"." : "Tree doesn't contain "+val;

	textAlign(LEFT);
	text(message, 50, height-100);
	text("Minim Value: "+tree.findMinim(), 50, height-80);
	text("Maxim Value: "+tree.findMaxim(), 50, height -60);
}




void draw(){
}

void mousePressed(){
	background(0);
	createBinaryTree(num);
	tree.traverse();
	searchBinaryTree(value);
}