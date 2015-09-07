package br.com.tads.avl;
import java.util.ArrayList;

public class ArvoreAvl {

  protected No raiz;

	public void inserir(int k) {
		No n = new No(k);
		inserirAVL(this.raiz, n);
	}

	public void inserirAVL(No aComparar, No aInserir) {

		if (aComparar == null) {
			this.raiz = aInserir;

		} else {

			if (aInserir.getChave() < aComparar.getChave()) {

				if (aComparar.getEsquerda() == null) {
					aComparar.setEsquerda(aInserir);
					aInserir.setPai(aComparar);
					verificarBalanceamento(aComparar);

				} else {
					inserirAVL(aComparar.getEsquerda(), aInserir);
				}

			} else if (aInserir.getChave() > aComparar.getChave()) {

				if (aComparar.getDireita() == null) {
					aComparar.setDireita(aInserir);
					aInserir.setPai(aComparar);
					verificarBalanceamento(aComparar);

				} else {
					inserirAVL(aComparar.getDireita(), aInserir);
				}

			} else {
				// O n� j� existe
			}
		}
	}

	public void verificarBalanceamento(No atual) {
		setBalanceamento(atual);
		int balanceamento = atual.getBalanceamento();

		if (balanceamento == -2) {

			if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
				atual = rotacaoDireita(atual);

			} else {
				atual = duplaRotacaoEsquerdaDireita(atual);
			}

		} else if (balanceamento == 2) {

			if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
				atual = rotacaoEsquerda(atual);

			} else {
				atual = duplaRotacaoDireitaEsquerda(atual);
			}
		}

		if (atual.getPai() != null) {
			verificarBalanceamento(atual.getPai());
		} else {
			this.raiz = atual;
		}
	}

	public void remover(int k) {
		removerAVL(this.raiz, k);
	}
	
	public boolean buscar(int n) {
		 return buscaAVL(this.raiz,n);

	}

	private boolean buscaAVL(No atual, int n) {	
		if (atual == null){
			return false;
		}else if (atual.getChave() == n) {
			return true;
		} else if (atual.getChave() < n) {
			return buscaAVL(atual.getDireita(), n);
		} else {
			return buscaAVL(atual.getEsquerda(), n);
		}
	}


	public void removerAVL(No atual, int k) {
		if (atual == null) {
			return;

		} else {

			if (atual.getChave() > k) {
				removerAVL(atual.getEsquerda(), k);

			} else if (atual.getChave() < k) {
				removerAVL(atual.getDireita(), k);

			} else if (atual.getChave() == k) {
				removerNoEncontrado(atual);
			}
		}
	}

	public void removerNoEncontrado(No aRemover) {
		No r;

		if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {

			if (aRemover.getPai() == null) {
				this.raiz = null;
				aRemover = null;
				return;
			}
			r = aRemover;

		} else {
			r = sucessor(aRemover);
			aRemover.setChave(r.getChave());
		}

		No p;
		if (r.getEsquerda() != null) {
			p = r.getEsquerda();
		} else {
			p = r.getDireita();
		}

		if (p != null) {
			p.setPai(r.getPai());
		}

		if (r.getPai() == null) {
			this.raiz = p;
		} else {
			if (r == r.getPai().getEsquerda()) {
				r.getPai().setEsquerda(p);
			} else {
				r.getPai().setDireita(p);
			}
			verificarBalanceamento(r.getPai());
		}
		r = null;
	}

	public No rotacaoEsquerda(No inicial) {

		No direita = inicial.getDireita();
		direita.setPai(inicial.getPai());

		inicial.setDireita(direita.getEsquerda());

		if (inicial.getDireita() != null) {
			inicial.getDireita().setPai(inicial);
		}

		direita.setEsquerda(inicial);
		inicial.setPai(direita);

		if (direita.getPai() != null) {

			if (direita.getPai().getDireita() == inicial) {
				direita.getPai().setDireita(direita);
			
			} else if (direita.getPai().getEsquerda() == inicial) {
				direita.getPai().setEsquerda(direita);
			}
		}

		setBalanceamento(inicial);
		setBalanceamento(direita);

		return direita;
	}

	public No rotacaoDireita(No inicial) {

		No esquerda = inicial.getEsquerda();
		esquerda.setPai(inicial.getPai());

		inicial.setEsquerda(esquerda.getDireita());

		if (inicial.getEsquerda() != null) {
			inicial.getEsquerda().setPai(inicial);
		}

		esquerda.setDireita(inicial);
		inicial.setPai(esquerda);

		if (esquerda.getPai() != null) {

			if (esquerda.getPai().getDireita() == inicial) {
				esquerda.getPai().setDireita(esquerda);
			
			} else if (esquerda.getPai().getEsquerda() == inicial) {
				esquerda.getPai().setEsquerda(esquerda);
			}
		}

		setBalanceamento(inicial);
		setBalanceamento(esquerda);

		return esquerda;
	}

	public No duplaRotacaoEsquerdaDireita(No inicial) {
		inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
		return rotacaoDireita(inicial);
	}

	public No duplaRotacaoDireitaEsquerda(No inicial) {
		inicial.setDireita(rotacaoDireita(inicial.getDireita()));
		return rotacaoEsquerda(inicial);
	}

	public No sucessor(No q) {
		if (q.getDireita() != null) {
			No r = q.getDireita();
			while (r.getEsquerda() != null) {
				r = r.getEsquerda();
			}
			return r;
		} else {
			No p = q.getPai();
			while (p != null && q == p.getDireita()) {
				q = p;
				p = q.getPai();
			}
			return p;
		}
	}
	
	public int alturaA() {
		return altura(raiz);
	}

	public int altura(No atual) {
		if (atual == null) {
			return -1;
		}
		if (atual.getEsquerda() == null && atual.getDireita() == null) {
			return 0;
		} else if (atual.getEsquerda() == null) {
			return 1 + altura(atual.getDireita());
		} else if (atual.getDireita() == null) {
			return 1 + altura(atual.getEsquerda());
		} else {
			return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
		}
	}
	
		public int profundidade() {
			return maxProfundidade(raiz);
		}
		
		public int maxProfundidade(No no) {
			if (no == null)
				return 0;
			int left = maxProfundidade(no.getEsquerda());
			int right = maxProfundidade(no.getDireita());

			int x = left > right ? left + 1 : right + 1;
			return x;
		}

	private void setBalanceamento(No no) {
		no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
	}

	
	
	// printInordem
		public void printInorder() {
			inorder(raiz);
		}

		private void inorder(No node) {
			if (node != null) {
				inorder(node.getEsquerda());
				System.out.println(" " + node.getChave());
				inorder(node.getDireita());
			}
		}

		// printPreOrdem
		public void printPreOrder() {
			preOrder(raiz);
		}

		private void preOrder(No node) {
			if (node != null) {
				System.out.print(" " +node.getChave());
				preOrder(node.getEsquerda());
				preOrder(node.getDireita());
			}
		}

		// printPosOrdem
		public void printPosOrder() {
			posOrder(raiz);
		}

		private void posOrder(No node) {
			if (node != null) {
				posOrder(node.getEsquerda());

				posOrder(node.getDireita());
				System.out.print(" " +node.getChave());
			}
		}
		boolean validarEstritamenteBinaria = true;
		public boolean estritamenteBinaria() {
			return estritamenteBinaria(raiz);
		}

		private boolean estritamenteBinaria(No node) {
			if (node != null) {
				if (node.getEsquerda() == null && node.getDireita() != null) {
					validarEstritamenteBinaria = false;
				}else if (node.getEsquerda() != null && node.getDireita() == null) {
					validarEstritamenteBinaria = false;
				}
				estritamenteBinaria(node.getEsquerda());
				estritamenteBinaria(node.getDireita());
			}
			return validarEstritamenteBinaria;
		}
		
		boolean validarQuaseCompleta = false;
		public boolean quaseCompleta() {
			return quaseCompleta(raiz);
		}

		private boolean quaseCompleta(No node) {
			System.out.println(validarQuaseCompleta);
			if (node != null) {
				if (node.getEsquerda() == null && node.getDireita() != null) {
					validarQuaseCompleta = true;
				}else if (node.getEsquerda() != null && node.getDireita() == null) {
					validarQuaseCompleta = true;
				}
				quaseCompleta(node.getEsquerda());
				quaseCompleta(node.getDireita());
			}
			return validarQuaseCompleta;
		}

}