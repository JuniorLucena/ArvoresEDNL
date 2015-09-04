package br.ifrn.generic.tree.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class No<T> implements CompositeArvoreGenerica {

	private int dado;
	private No<T> pai;
	private ArrayList<No<T>> filhos;

	public No() {

	}

	public No(int dado, CompositeArvoreGenerica pai) {
		this.dado = dado;
		this.pai = (No<T>) pai;
		this.filhos = new ArrayList();
	}

	public No(int dado, No<T> pai) {
		this.dado = dado;
		this.pai = pai;
		this.filhos = new ArrayList();
	}

	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public List<No<T>> getFilho() {
		return filhos;
	}

	public void setFilho(ArrayList filho) {
		this.filhos = filho;
	}

	public No<T> getPai() {
		return pai;
	}

	public void setPai(No<T> pai) {
		this.pai = pai;
	}

	public void add(CompositeArvoreGenerica composite) {
		this.filhos.add((No<T>) composite);
	}

	public CompositeArvoreGenerica getFilho(int x) {
		return (CompositeArvoreGenerica) filhos.get(x);
	}

	public void source(int data) {
		// TODO Auto-generated method stub

	}

	public void remover(CompositeArvoreGenerica composite) {
		this.filhos.remove(composite);
	}

	public void print() {
		
		
		Iterator<No<T>> itr= filhos.iterator();

        while(itr.hasNext()){
            System.out.print(itr.next().getDado()+ "  ");

        }

	}

	public No buscarNo(int valorPai) {
		No no = new No();

		for (int i = 0; i < filhos.size(); i++) {
			if (filhos.get(i).getDado() == valorPai) {
				return filhos.get(i);
			}
		}

		return null;
	}

}
