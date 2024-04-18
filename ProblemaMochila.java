import java.util.InputMismatchException;
import java.util.Scanner;

// Classe com funcoes que fazem operações com os dados da mochila
public class ProblemaMochila {

	// Função para resolver o Problema da Mochila usando Programação Dinâmica
	// Entrada:
	// Saida:
	// Pre-requisito:
	// Pos-requisito:
	public static int mochilaProgramacaoDinamica(int[] pesos, int[] valores, int capacidade) {
		int n = pesos.length;
		int[][] dp = new int[n + 1][capacidade + 1];

		for (int i = 1; i <= n; i++) {
			for (int w = 1; w <= capacidade; w++) {
				if (pesos[i - 1] <= w) {
					dp[i][w] = Math.max(valores[i - 1] + dp[i - 1][w - pesos[i - 1]], dp[i - 1][w]);
				} else {
					dp[i][w] = dp[i - 1][w];
				}
			}
		}

		return dp[n][capacidade];
	}
	
	//
	// Entrada:
	// Saida:
	// Pre-requisito:
	// Pos-requisito:
	public static void printVet(int[] aux) {
		for (int i = 0; i < aux.length; i++) {
			System.out.print(aux[i] + " ");
		}
		System.out.print("\n");
	}
	
	//
	// Entrada:
	// Saida:
	// Pre-requisito:
	// Pos-requisito:
	public static void problemaMochila() {
		System.out.println("Escolha uma das opções abaixo para Problema da Mochila: ");
		System.out.println("1 - Entrar com arquivo");
		System.out.println("2 - Voltar para o Menu Principal");

		try (Scanner scanner = new Scanner(System.in)) {
			int opcao = 0;

			while (true) { // Parte da funçao necessaria para caso o usuario entre com algum caracter
							// diferente de digito
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
				Mochila mochila = Mochila.lerArquivo();

				int capacidade = mochila.getCapacidade();
				int[] pesos = mochila.getPeso();
				int[] valores = mochila.getValores();

				System.out.println("Capacidade: " + capacidade);
				System.out.print("Pesos: ");
				printVet(pesos);
				System.out.print("Valores: ");
				printVet(valores);

				int resultado = mochilaProgramacaoDinamica(pesos, valores, capacidade);
				System.out.println("Valor máximo na mochila: " + resultado);

				break;

			case 2:
				Menu.menu();
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.\n");
				problemaMochila();
			}
		}
	}
}
