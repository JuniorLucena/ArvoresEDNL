package br.com.ifrn.arvorebinaria;

import java.util.Scanner;

public class BTreeMain {
	
	public static void menu() {
		System.out.println("\n-----------------------------");
		System.out.println("      Arvore Binaria           ");
		System.out.println("-------------------------------");
		System.out.println("   1. Iserir um NO             ");
		System.out.println("   2. Buscar um No             ");
		System.out.println("   3. Remover um NO            ");
		System.out.println("   4. Imprimir Arvore          ");
		System.out.println("   5. Profundidade da Arvore   ");
		System.out.println("   6. Soma de todos os NOS     ");
		System.out.println("   7. Numero de NOS na Arvore  ");
		System.out.println("   8. Tipo de Arvore           ");
		System.out.println("   0. Fim                      ");
		System.out.println("-----------------------------  ");
		System.out.println("Opcao:");
	}
	
	public static void menuPrint() {
		System.out.println("\n-----------------------------");
		System.out.println("      Imprimir Arvore          ");
		System.out.println("-------------------------------");
		System.out.println("   1. Pre-ordem                ");
		System.out.println("   2. Inordem                  ");
		System.out.println("   3. Pos-ordem                ");
		System.out.println("-----------------------------  ");
		System.out.println("Opcao:");
	}
	
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Scanner entrada2 = new Scanner(System.in);
		BTree arvore = new BTree();
		int valorNos = 0;
		int qntdNos = 0;
		
		int opc1,opc2,valor;
		menu();
		opc1 = entrada.nextInt();
		
		while(opc1 != 0) {
			switch(opc1){
			case 1:
				System.out.println("\nVoce entrou no metododo INSERIR um NO");
				System.out.print("Digite o valor do NO: ");
				valor = entrada2.nextInt();
				arvore.inserirBTNode(valor);
				valorNos = valorNos + valor;
				qntdNos++;
				break;
			case 2:
				System.out.println("\nVoce entrou no metodo Buscar um NO!");
				System.out.print("Digite o valor do NO: ");
				valor = entrada2.nextInt();
				arvore.contains(valor);
				if (arvore.contains(valor)) {
					System.out.println("O NO "+valor+ " foi encontrado na Arvore!");
				}else{
					System.out.println("O NO "+valor+ " nao foi encontrado na Arvore!");
				}
				break;
			case 3:
				System.out.println("\nVoce entrou no metodo REMOVER um NO!");
				System.out.print("Digite o valor do NO:");
				valor = entrada2.nextInt();
				arvore.removeBTNode(valor);
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
					arvore.printPreOrder();
					break;
				case 2:
					System.out.println("\nVoce entrou no metododo INORDEM!");
					arvore.printInorder();
					break;
				case 3:
					System.out.println("\nVoce entrou no metododo POS-ORDEM");
					arvore.printPosOrder();
					break;
				default:
					System.out.println("Opcao Invalida!");
				}
				break;
			case 5:
				System.out.println("\nVoce entrou no metodo PROFUNDIDADE da Arvore!");
				System.out.println("Profundidade da árvore: "+ arvore.profundidade());
				break;
			case 6:
				System.out.println("O valor da soma de todos os NOS da Arvore eh: "+ valorNos);
				break;
			case 7:
				System.out.println("A quantidade de NOS na Arvore eh: "+ qntdNos);
				break;
			case 8:
				System.out.println("Voce entrou no método TIPO DE ARVORE!");
				int altura = arvore.alturaA();
				double aux = Math.pow(2, altura+1);
				int completa = (int)Math.pow(2, arvore.profundidade());
				int aux2 = (int)aux;
				if (qntdNos == aux2-1) {
					System.out.println("Arvore cheia!");
				}
				if (arvore.estritamenteBinaria()) {
					System.out.println("Estritamente binária!");
				}
				if(arvore.quaseCompleta()){
					System.out.println("Arvore quase completa!");
				}
				if (qntdNos == completa+1) {
					System.out.println("Arvore Completa!");
				}
				break;	
			default:
				System.out.println("Opcao Invalida!");
			}
			menu();
			opc1 = entrada.nextInt();
		}	
	}

}
