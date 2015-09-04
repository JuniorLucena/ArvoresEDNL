package br.ifrn.generic.tree.composite;

import java.util.Scanner;

public class Main {

	public static void menu() {
		System.out.println("\n-----------------------------");
		System.out.println("      Árvore Generica          ");
		System.out.println("-------------------------------");
		System.out.println("   1. Iserir um novo Nó        ");
		System.out.println("   2. Remover um Nó            ");
		System.out.println("   3. Buscar um Nó             ");
		System.out.println("   4. Mostrar Árvore           ");
		System.out.println("   5. Mostrar Filhos de um Nó  ");
		System.out.println("   0. Fim                      ");
		System.out.println("-----------------------------  ");
		System.out.println("Opcao:");
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int valorPai = -1;

		System.out.println("\nInsira a RAIZ da Árvore: ");
		int raiz = entrada.nextInt();

		CompositeArvoreGenerica ag = new ArvoreGenerica<No>();
		CompositeArvoreGenerica noC = new No(raiz, null);
		ag.add(noC);

		int opc;
		do {
			menu();
			opc = entrada.nextInt();

			switch (opc) {
			case 1:
				System.out.println("\nVocê entrou no métododo INSERIR um Nó!");
				int valor = -1;
				do{
					System.out.println("\nInsira o valor de um novo No: ");
					valor = entrada.nextInt();
					if (ag.buscarNo(valor) != null) {
						System.out.println("O no informado já existe na árvore! Por favor Digite outro Nó!");
					}
				}while(ag.buscarNo(valor) != null);
				
				do {
					System.out.println("Insira o PAI do No: ");
					valorPai = entrada.nextInt();
					if (ag.buscarNo(valorPai) == null) {
						System.out
								.println("\nO nó informado para ser o PAI não existe!");
					}
				} while (ag.buscarNo(valorPai) == null);

				CompositeArvoreGenerica pai = ag.buscarNo(valorPai);
				CompositeArvoreGenerica no3 = new No(valor, pai);

				ag.add(no3);
				pai.add(no3);

				if (ag.buscarNo(valor) != null) {
					System.out.println("No inserido com sucesso!");
				} else {
					System.out.println("O nó não foi inserido!");
				}
				break;

			case 2:
				System.out.println("\nVocê entrou no métododo REMOVER um Nó");
				System.out.println("\nDigite um NÓ para ser removido: ");
				int noRemove = entrada.nextInt();
				if (ag.buscarNo(noRemove) != null) {
					CompositeArvoreGenerica no = ag.buscarNo(noRemove);
					System.out.println("NO: "
							+ ag.buscarNo(noRemove).getDado());
					ag.remover(no);
				}
				break;

			case 3:
				System.out.println("\nVocê entrou no métododo BUSCAR um Nó!");
				System.out.print("\nInforme o nó a ser buscado: ");
				int noBusca = entrada.nextInt();
				if (ag.buscarNo(noBusca) == null) {
					System.out.println("O no informado nao existe na árvore!");
				} else {
					System.out.println("o Nó "+ag.buscarNo(noBusca).getDado()+ " existe na arvore!");
				}
				break;

			case 4:
				System.out.println("\nVocê entrou no métododo MOSTRAR ÁRVORE!");
				System.out.print("\nARVORE: ");
				ag.print();
				break;

			case 5:
				System.out
						.println("\nVocê entrou no métododo Mostrar filhos de um Nó!");
				System.out.println("\nDigite o no para mostrar os filhos: ");
				int paiNo = entrada.nextInt();
				if (ag.buscarNo(paiNo) == null) {
					System.out.println("O no informado nao existe na árvore!");
				} else {
					No noListaFilhos = ag.buscarNo(paiNo);
					System.out.print("\nFilhos: ");
					noListaFilhos.print();
				}
				break;

			default:
				System.out.println("Opção inválida!");
			}
		} while (opc != 0);

	}

}
