public class SparseVector {

	private Node head;
	private int length;

	public SparseVector(int len){
		head = null;
		length = len;
	}

	// Prints out a sparse vector (including zeros)
	public String toString(){

		String result = "";
		Node currNode = head;
		int currIndex = 0;
		while( currNode != null ){
			int idx = currNode.getIndex();

			// Pad the space between nodes with zero
			while( currIndex < idx ){
				result += "0, ";
				currIndex++;
			}
			result += currNode;
			currNode = currNode.getNext();
			currIndex++;

			// Only add a comma if this isn't the last element
			if( currNode != null ){ result += ", "; }
		}
		return result;
	}

	// TODO: Implement me for milestone 2
	public void addElement(int index, double value){
		Node ptr;


		if (index > length){
		}

		else {
			if (head == null) {
				head = new Node(index, value);
				return;
			}
			ptr = head;

			while (ptr.getNext() != null) {
				 ptr = ptr.getNext();

			}
			ptr.setNext(new Node(index,value));


		}

	}

	// TODO: Implement me for milestone 4
	public static double dot( SparseVector x, SparseVector y ){
		if(x.length != y.length){
			return 0.0;
		}
		//while(ptrx.getIndex() != ptry.getIndex()) {...}; result += ...;

		Node ptrx = x.head;
		Node ptry = y.head;
		double result = 0.0;
//		while (ptrx.getNext() != null && ptry.getNext() != null) {
			while (ptrx != null && ptry != null) {
				if (ptrx.getIndex() > ptry.getIndex()) {
					ptry = ptry.getNext();
				}
				else if (ptrx.getIndex() < ptry.getIndex()) {
					ptrx = ptrx.getNext();
				}

				else {
					result += ptrx.getValue() * ptry.getValue();
					ptrx = ptrx.getNext();
					ptry = ptry.getNext();
				}


			}



//		}





		/*while(ptrx.getIndex() > ptry.getIndex()){
				ptry = ptry.getNext();
			}
		while(ptrx.getIndex() < ptry.getIndex()){
			ptrx = ptrx.getNext();
		}*/

		return result;
	}


	// TODO: Test out your code here!
	public static void main(String[] args) {
		/*SparseVector vec = new SparseVector(6);
		vec.addElement(0, 10.0);
		vec.addElement(3, -1.1);
		vec.addElement(5, 32.0);
		System.out.println(vec);*/

		SparseVector x = new SparseVector(100000000);
		x.addElement(0, 1.0);
		x.addElement(10000000, 3.0);
		x.addElement(10000001, -2.0);
		SparseVector y = new SparseVector(100000000);
		y.addElement(0, 2.0);
		y.addElement(10000001, -4.0);
		double result = dot(x, y);
		System.out.println(result);
	}
}


