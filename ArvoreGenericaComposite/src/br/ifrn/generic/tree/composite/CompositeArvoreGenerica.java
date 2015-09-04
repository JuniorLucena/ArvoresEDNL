package br.ifrn.generic.tree.composite;

public interface CompositeArvoreGenerica {

	public void add(CompositeArvoreGenerica composite);

	public void source(int data);

	public void remover(CompositeArvoreGenerica composite);
	
	public void print();

	public No buscarNo(int valorPai);
	

}
