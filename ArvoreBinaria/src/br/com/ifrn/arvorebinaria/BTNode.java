package br.com.ifrn.arvorebinaria;

public class BTNode {
	int val;
	BTNode esq;
	BTNode dir;
	
	public BTNode() {
	}
	
	public BTNode(int v, BTNode e, BTNode d) {
		this.val = v;
		this.esq = e;
		this.dir = d;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public BTNode getEsq() {
		return esq;
	}

	public void setEsq(BTNode esq) {
		this.esq = esq;
	}

	public BTNode getDir() {
		return dir;
	}

	public void setDir(BTNode dir) {
		this.dir = dir;
	}
	
}
