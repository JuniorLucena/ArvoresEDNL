package br.ifrn.generic.tree.composite;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArvoreGenerica<T> implements CompositeArvoreGenerica {

	public int valor;
	private ArrayList<No<T>> arvore = new ArrayList<No<T>>();
	
	public ArvoreGenerica() {
		arvore = new ArrayList();
	}
	public No buscarNo(int valor){		
		for (int i = 0; i < arvore.size(); i++) {
			if (arvore.get(i).getDado() == valor) {
				return arvore.get(i);
			}
		}
		
		return null;
	}

	public void add(CompositeArvoreGenerica composite) {
		arvore.add((No<T>) composite);
	}

	public void source(int data) {
		
	}

	public void remover(CompositeArvoreGenerica composite) {
		List <No<T>> list = getArvore();
		list.remove(composite);
		removerNo(composite);
	}

	private void removerNo(CompositeArvoreGenerica composite) {
		No no = (No) composite;
		CompositeArvoreGenerica noPai = no.getPai();
		noPai.remover(composite);
		
	}

	public void print() {
		Iterator<No<T>> itr= arvore.iterator();

        while(itr.hasNext()){
            System.out.print(itr.next().getDado()+ "  ");

        }
		
		System.out.println("\nTamanho da Arvore: " + arvore.size());
	}
	
	public ArrayList<No<T>> getArvore() {
		return arvore;
	}

	public void setArvore(ArrayList arvore) {
		this.arvore = arvore;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
}

