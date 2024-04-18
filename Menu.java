import java.util.InputMismatchException;
import java.util.Scanner;

// Classe menu que tem como objetivo fazer a apresentação do programa e suas funcionalidade
public class Menu {
	public static void main(String[] args) {
		boasVindas();
		menu();
	}

	// Função de Boas Vindas
	// Entrada: Nenhuma
	// Saida: Nenhuma
	// Pre-requisito: Nenhuma
	// Pos-requisito: Nenhuma
	public static void boasVindas() {
		System.out.println("Projeto e Ánalise de Algoritmos\n" + 
						   "       Trabalho 1\n");

		System.out.println("Desenvolvido por:\n" + 
						   "Vitória Conceição Melo\n" + 
						   "Matheus Prokopowiski\n");
	}

	// Função chamando o Menu Principal
	// Entrada: Nenhuma
	// Saida: Nenhuma
	// Pre-requisito: Nenhuma
	// Pos-requisito: Usuario escolher alguma das opções 
	public static void menu() {
		System.out.println("Escolha qual dos Algoritmos abaixo voce quer executar:");
		System.out.println("1 - Multiplicação de Matrizes");
		System.out.println("2 - Algoritmo de Strassen");
		System.out.println("3 - Algoritmo da Mochila");
		System.out.println("4 - Sair\n");

		try (Scanner scanner = new Scanner(System.in)) {
			int opcao = 0;

			while (true) { //Parte da funçao necessaria para caso o usuario entre com algum caracter diferente de digito
				try {
					opcao = scanner.nextInt();
					break; // Sai do loop se a entrada for válida
				} catch (InputMismatchException e) {
					System.out.println("Entrada inválida. Digite um número inteiro.");
					scanner.nextLine(); // Limpa o buffer do scanner
				}
			}

			switch (opcao) {
			case 1:
				MultiplicacaoMatrizes.multiMatriz();  
				break;
			case 2:
				StrassenAlgoritmo.strassen();
				break;
			case 3:
				ProblemaMochila.problemaMochila(); 
				break;
			case 4:
				System.exit(0); // O menu acaba
			default:
				System.out.println("Opção inválida. Tente novamente.\n");
				menu();
			}
		}
	}
}
