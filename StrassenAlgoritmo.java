import java.util.InputMismatchException;
import java.util.Scanner;

//
public class StrassenAlgoritmo {

	public static int[][] strassenMultiply(int[][] A, int[][] B) {
        int n = A.length;

        // Caso base: matrizes 1x1
        if (n == 1) {
            int[][] C = new int[1][1];
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }
 
        // Dividindo as matrizes em quatro submatrizes
        int newSize = n / 2;
        int[][] A11 = new int[newSize][newSize];
        int[][] A12 = new int[newSize][newSize];
        int[][] A21 = new int[newSize][newSize];
        int[][] A22 = new int[newSize][newSize];

        int[][] B11 = new int[newSize][newSize];
        int[][] B12 = new int[newSize][newSize];
        int[][] B21 = new int[newSize][newSize];
        int[][] B22 = new int[newSize][newSize];

        // Preenchendo as submatrizes
        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                A11[i][j] = A[i][j];
                A12[i][j] = A[i][j + newSize];
                A21[i][j] = A[i + newSize][j];
                A22[i][j] = A[i + newSize][j + newSize];

                B11[i][j] = B[i][j];
                B12[i][j] = B[i][j + newSize];
                B21[i][j] = B[i + newSize][j];
                B22[i][j] = B[i + newSize][j + newSize];
            }
        }

        // Calculando sete produtos de Strassen recursivamente
        int[][] P1 = strassenMultiply(A11, subtractMatrices(B12, B22));
        int[][] P2 = strassenMultiply(addMatrices(A11, A12), B22);
        int[][] P3 = strassenMultiply(addMatrices(A21, A22), B11);
        int[][] P4 = strassenMultiply(A22, subtractMatrices(B21, B11));
        int[][] P5 = strassenMultiply(addMatrices(A11, A22), addMatrices(B11, B22));
        int[][] P6 = strassenMultiply(subtractMatrices(A12, A22), addMatrices(B21, B22));
        int[][] P7 = strassenMultiply(subtractMatrices(A11, A21), addMatrices(B11, B12));

        // Calculando as submatrizes de C
        int[][] C11 = addMatrices(subtractMatrices(addMatrices(P5, P4), P2), P6);
        int[][] C12 = addMatrices(P1, P2);
        int[][] C21 = addMatrices(P3, P4);
        int[][] C22 = subtractMatrices(subtractMatrices(addMatrices(P5, P1), P3), P7);

        // Combinando as submatrizes para formar a matriz C
        int[][] C = new int[n][n];
        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                C[i][j] = C11[i][j];
                C[i][j + newSize] = C12[i][j];
                C[i + newSize][j] = C21[i][j];
                C[i + newSize][j + newSize] = C22[i][j];
            }
        }

        return C;
    }
	
	//
	//
	//
	//
	//
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }
    
    //
    //
    //
    //
    //
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }
    
    //
    //
    //
    //
    //
    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //
    //
    //
    //
    //   
    public static void strassen() {
		System.out.println("\nEscolha uma das opções abaixo para Algoritmo de Strassen: ");
		System.out.println("1 - Entrar com arquivo");
		System.out.println("2 - Voltar para o Menu Principal\n");

		try (Scanner scanner = new Scanner(System.in)) {
			int opcao = 0;
			while (true) {
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
				
				long iniTime1 = System.currentTimeMillis();
				int[][] C1 = StrassenAlgoritmo.strassenMultiply(A1, B1);
				long fimTime1 = System.currentTimeMillis();
				System.out.println("\nMatriz resultante C1:");
				StrassenAlgoritmo.printMatrix(C1);
				System.out.println("\nTempo de Execução: " + (fimTime1 - iniTime1) + " milisegundos");
				
				long iniTime2 = System.currentTimeMillis();
				int[][] C2 = StrassenAlgoritmo.strassenMultiply(A2, B2);
				long fimTime2 = System.currentTimeMillis();
				System.out.println("\nMatriz resultante C2:");
				StrassenAlgoritmo.printMatrix(C2);
				System.out.println("\nTempo de Execução: " + (fimTime2 - iniTime2) + " milisegundos");
				
				long iniTime3 = System.currentTimeMillis();
				int[][] C3 = StrassenAlgoritmo.strassenMultiply(A3, B3);
				long fimTime3 = System.currentTimeMillis();
				System.out.println("\nMatriz resultante C3:");
				StrassenAlgoritmo.printMatrix(C3);
				System.out.println("\nTempo de Execução: " + (fimTime3 - iniTime3) + " milisegundos");
				System.out.println("\nTempo de Execução Final: " + ((fimTime1 - iniTime1)+ (fimTime2 - iniTime2)+ (fimTime3 - iniTime3)) + " milisegundos");
				break;

			case 2:
				Menu.menu();
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.\n");
				strassen();
			}
		}
	}
}
