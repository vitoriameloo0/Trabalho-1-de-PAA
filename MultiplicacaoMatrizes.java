import java.util.InputMismatchException;
import java.util.Scanner;

// Classe de multiplicacao de matrizes
public class MultiplicacaoMatrizes {
	//Função que faz a multiplicação de duas matrizes
	// Entrada: As matrizes que serao multiplicadas (A e B), a matriz que vai receber o valor da multiplicação e o tamanho das matrizes
	// Saida: Nenhuma
	// Pre-requisito: Matrizes ter sido lidas
	// Pos-requisito: Multiplicacao feita com sucesso
	public static void multiplicacaoMatrizes(int[][] A, int[][] B, int[][] C, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				C[i][j] = 0;
				for (int k = 0; k < n; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
	}
	
	// Função que imprime os elementos de uma matriz
	// Entrada: A matriz que vai ser impressa e o seu tamanho
	// Saida: Nenhuma
	// Pre-requisito: Matriz ter sido lida
	// Pos-requisito: Matriz printada
	public static void printMatriz(int[][] matriz, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.println();
		}
	}	

	// Função Menu para a Multiplicação de Matrizes
	// Entrada: Nenhuma
	// Saida:  Nenhuma
	// Pre-requisito: Usuario escolher multiplicar matriz
	// Pos-requisito: Matriz lida, multiplicada e impressa na tela do usuario
	public static void multiMatriz() {
		System.out.println("\nEscolha uma das opções abaixo para Multiplicação de Matrizes: ");
		System.out.println("1 - Entrar com arquivo");
		System.out.println("2 - Voltar para o Menu Principal\n");

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
				Matrizes matrizes = Matrizes.lerArquivo();

				int[][] A1 = matrizes.getA1();
				int[][] B1 = matrizes.getB1();
				int[][] A2 = matrizes.getA2();
				int[][] B2 = matrizes.getB2();
				int[][] A3 = matrizes.getA3();
				int[][] B3 = matrizes.getB3();

				int n1 = A1.length;
				int n2 = A2.length;
				int n3 = A3.length;

				int[][] C1 = new int[n1][n1];
				int[][] C2 = new int[n2][n2];
				int[][] C3 = new int[n3][n3];
				
				long iniTime1 = System.currentTimeMillis();
				multiplicacaoMatrizes(A1, B1, C1, n1);
				long fimTime1 = System.currentTimeMillis();
				System.out.println("\nMatriz Resultante C1:");
				printMatriz(C1, n1);
				
				
				long iniTime2 = System.currentTimeMillis();
				multiplicacaoMatrizes(A2, B2, C2, n2);
				long fimTime2 = System.currentTimeMillis();
				System.out.println("\nMatriz Resultante C2:");
				printMatriz(C2, n2);
				
				
				long iniTime3 = System.currentTimeMillis();
				multiplicacaoMatrizes(A3, B3, C3, n3);
				long fimTime3 = System.currentTimeMillis();
				System.out.println("\nMatriz Resultante C3:");
				printMatriz(C3, n3);
				
				System.out.println("\nTempo de Execução M1: " + (fimTime1 - iniTime1) + " milisegundos");
				System.out.println("\nTempo de Execução M2: " + (fimTime2 - iniTime2) + " milisegundos");
				System.out.println("\nTempo de Execução M3: " + (fimTime3 - iniTime3) + " milisegundos");
				System.out.println("\nTempo de Execução Final: " + ((fimTime1 - iniTime1)+ (fimTime2 - iniTime2)+ (fimTime3 - iniTime3)) + " milisegundos");
				break;
			
			case 2:
				Menu.menu();
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.\n");
				multiMatriz();
			}
		}
	}
}
