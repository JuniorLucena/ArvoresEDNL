package br.com.ifrn.arvorebinaria;

public class BTree {

	private BTNode root;

	// inserção
	public void inserirBTNode(int k) {
		root = inserirBTNode(root, k);

	}

	public BTNode inserirBTNode(BTNode t, int k) {
		if (t == null) {
			return new BTNode(k, null, null);
		} else {
			if (k <= t.val) {
				t.esq = inserirBTNode(t.esq, k);
			} else {
				t.dir = inserirBTNode(t.dir, k);
			}
		}
		return t;
	}

	// printInordem
	public void printInorder() {
		inorder(root);
	}

	private void inorder(BTNode node) {
		if (node != null) {
			inorder(node.esq);
			System.out.println(" " + node.val);
			inorder(node.dir);
		}
	}

	// printPreOrdem
	public void printPreOrder() {
		preOrder(root);
	}

	private void preOrder(BTNode node) {
		if (node != null) {
			System.out.println(node.val);
			preOrder(node.esq);
			preOrder(node.dir);
		}
	}

	// printPosOrdem
	public void printPosOrder() {
		posOrder(root);
	}

	private void posOrder(BTNode node) {
		if (node != null) {
			// System.out.println(node.val);
			posOrder(node.esq);

			posOrder(node.dir);
			System.out.println(node.val);
		}
	}

	// profundidade
	public void profundidade() {
		System.out.println(maxProfundidade(root)-1);
		// verificar como é contabilizado o a profundidade da arvore
	}
	
	public int maxProfundidade(BTNode node) {
		if (node == null)
			return 0;
		int left = maxProfundidade(node.esq);
		int right = maxProfundidade(node.dir);

		int x = left > right ? left + 1 : right + 1;
		return x;
	}
	
	

	// busca
	public boolean contains(int x) {
		return contains(root, x);
	}

	private boolean contains(BTNode t, int x) {
		if (t == null) {
			return false;
		} else if (x == t.val) {
			return true;
		} else if (x < t.val) {
			return contains(t.esq, x);
		} else {
			return contains(t.dir, x);
		}
	}

	// remoção
	public void removeBTNode(int x) {
		root = removeBTNode(root, x);
	}

	private BTNode removeBTNode(BTNode t, int x) {
		if (t != null) {
			if (x < t.val) {
				t.esq = removeBTNode(t.esq, x);
			} else if (x > t.val) {
				t.dir = removeBTNode(t.dir, x);
			} else if (t.esq == null) {
				t = t.dir;
			} else if (t.dir == null) {
				t = t.esq;
			} else {
				t.dir = removeMinBTNode(t, t.dir);
			}
		}
		return t;
	}

	private BTNode removeMinBTNode(BTNode d, BTNode t) {
		if (t.esq == null) {
			d.val = t.val;
			return t.dir;
		} else {
			t.esq = removeMinBTNode(d, t.esq);

		}
		return t;
	}
	
	//estritamente binaria
	public void arvoreCheia(){
		arvoreCheia(root);
	}
	private void arvoreCheia(BTNode n){
		if (n.dir != null) {
			arvoreCheia(n.dir);
		}else{
			System.out.println(n.val);
		}
	}

}
