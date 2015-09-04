package br.com.tads.avl;

import java.util.Scanner;

public class AVlMain {

	public static void menu() {
		System.out.println("\n-----------------------------------");
		System.out.println("      Arvore Binaria                 ");
		System.out.println("-------------------------------------");
		System.out.println("   1. Iserir um No                   ");
		System.out.println("   2. Buscar um No                   ");
		System.out.println("   3. Remover um No                  ");
		System.out.println("   4. Imprimir Arvore                ");
		System.out.println("   5. Altura                         ");
		System.out.println("   6. Soma de todos os nos           ");
		System.out.println("   7. Numero de nos da Arvore        ");
		System.out.println("   8. Profundidade                   ");
		System.out.println("   9. Estritamente Arvore            ");
		System.out.println("   0. Fim                            ");
		System.out.println("-------------------------------------");
		System.out.println("\nOpcao:");
	}

	public static void menuPrint() {
		System.out.println("\n-----------------------------");
		System.out.println("      Imprimir Arvore          ");
		System.out.println("-------------------------------");
		System.out.println("   1. Pre-ordem                ");
		System.out.println("   2. Inordem                  ");
		System.out.println("   3. Pos-ordem                ");
		System.out.println("-----------------------------  ");
		System.out.println("\nOpcao:");
	}


	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Scanner entrada2 = new Scanner(System.in);

		ArvoreAvl arvore = new ArvoreAvl();

		int valorNos = 0;
		int qntdNos = 0;

		int opc1,opc2,valor;
		menu();
		opc1 = entrada.nextInt();

		while(opc1 != 0) {
			switch(opc1){
			case 1:
				System.out.println("\nVoce entrou no metodo inserir NO!");
				System.out.print("Digite o valor do Nó:");
				valor = entrada2.nextInt();
				arvore.inserir(valor);
				valorNos = valorNos + valor;
				qntdNos++;
				break;
			case 2:
				System.out.println("\nVoce entrou no metodo buscar NO!");
				System.out.print("Digite o valor do NO:");
				valor = entrada2.nextInt();
				arvore.buscar(valor);
				if (arvore.buscar(valor)) {
					System.out.println("O NO "+valor+ " foi encontrado na Arvore!");
				}else{
					System.out.println("O NO "+valor+ " Nao foi encontrado na Arvore!");
				}
				break;
			case 3:
				System.out.println("\nVoce entrou no metodo remover NO!");
				System.out.print("Digite o valor do NO:");
				valor = entrada2.nextInt();
				arvore.remover(valor);
				System.out.print("O NO "+ valor + " foi removido");
				valorNos = valorNos - valor;
				qntdNos--;
				break;
			case 4:
				menuPrint();
				opc2 = entrada.nextInt();
				switch(opc2){
				case 1:
					System.out.println("\nVoce entrou no metodo IMPRIMIR PRE-ORDEM!");
					System.out.println("\nOrdem da Arvore: ");
					arvore.printPreOrder();
					break;
				case 2:
					System.out.println("\nVoce entrou no metododo INORDEM!");
					System.out.println("\nOrdem da Arvore: ");
					arvore.printInorder();
					break;
				case 3:
					System.out.println("\nVoce entrou no metododo POS-ORDEM");
					System.out.println("\nOrdem da Arvore: ");
					arvore.printPosOrder();
					break;
				default:
					System.out.println("Opcao Invalida!");
				}
				break;
			case 5:
				System.out.println("\nVoce entrou no metodo ALTURA da Arvore!");
				System.out.println("A Altura da Arvore: "+arvore.alturaA());
				break;
			case 6:
				System.out.println("Voce entrou no método SOMA DOS NOS!");
				System.out.println("O valor da soma de todos os nos da Arvore sao: "+ valorNos);
				break;
			case 7:
				System.out.println("Voce entrou no método QUANTIDADE DE NO!");
				System.out.println("A quantidade de NOS na arvore eh "+ qntdNos);
				break;
			case 8:
				System.out.println("Voce entrou no método Profundidade!");
				System.out.println("Produndidade da Arvore: "+arvore.profundidade());
				break;
			case 9:
				System.out.println("Voce entrou no método TIPO DE ARVORE!");
				break;	
			default:
				System.out.println("Opcao Inválida!");
			}
			menu();
			opc1 = entrada.nextInt();
		}	
	}

}

