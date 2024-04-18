import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// Classe Matrizes que tem como objetivo manipular os dados das matrizes 
public class Matrizes {
	private int [][] A1;
	private int [][] B1;
	private int [][] A2;
	private int [][] B2;
	private int [][] A3;
	private int [][] B3;
	
	// Função Construtora da classe matrizes
	// Entrada: Os dados das matrizes a1, a2, a3, b1, b2, b3
	// Saida: Nenhuma
	// Pre-requisito: Nenhuma
	// Pos-requisito: Manipulação dos dados das matrizes feitas
	public Matrizes(int[][] A1, int [][] B1, int[][] A2, int [][] B2, int[][] A3, int [][] B3) {
		this.A1 = A1;
		this.B1 = B1;
		this.A2 = A2;
		this.B2 = B2;
		this.A3 = A3;
		this.B3 = B3;
		
	}
	
	// Função que retorna a matriz a1
	// Entrada: Nenhuma
	// Saida: matriz a1
	// Pre-requisito: Ler os dados da matriz a1
	// Pos-requisito: Matriz a1 retornada
	public int [][] getA1(){
		return A1;
	}
	
	// Função que retorna a matriz b1
	// Entrada: Nenhuma
	// Saida: matriz b1
	// Pre-requisito: Ler os dados da matriz b1
	// Pos-requisito: Matriz b1 retornada
	public int [][] getB1(){
		return B1;
	}
	
	// Função que retorna a matriz a2
	// Entrada: Nenhuma
	// Saida: matriz a2
	// Pre-requisito: Ler os dados da matriz a2
	// Pos-requisito: Matriz a2 retornada
	public int [][] getA2(){
		return A2;
	}
	
	// Função que retorna a matriz b2
	// Entrada: Nenhuma
	// Saida: matriz b2
	// Pre-requisito: Ler os dados da matriz b2
	// Pos-requisito: Matriz b2 retornada
	public int [][] getB2(){
		return B2;
	}
	
	// Função que retorna a matriz a3
	// Entrada: Nenhuma
	// Saida: matriz a3
	// Pre-requisito: Ler os dados da matriz a3
	// Pos-requisito: Matriz a3 retornada
	public int [][] getA3(){
		return A3;
	}
	
	// Função que retorna a matriz b3
	// Entrada: Nenhuma
	// Saida: matriz b3
	// Pre-requisito: Ler os dados da matriz b3
	// Pos-requisito: Matriz b3 retornada
	public int [][] getB3(){
		return B3;
	}
	
	// Função para fazer a leitura de um arquivo
	// Entrada: Nenhuma
	// Saida:  As matrizes lidas caso o arquivo tenha sido aberto corretamente, e NULL caso contrario
	// Pre-requisito:
	// Pos-requisito:
	public static Matrizes lerArquivo() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Digite o nome do arquivo texto: ");
			String nomeArquivo = scanner.nextLine();

			try (BufferedReader arquivo = new BufferedReader(new FileReader(nomeArquivo))) {			
				// MATRIZ 1
				int n1 = tamanhoMatriz(arquivo);	 // pega o tamanho da primeira matriz		
				int[][] A1 = lerMatriz(arquivo, n1); // ler a matriz a1
				int[][] B1 = lerMatriz(arquivo, n1); // ler a matriz b1

				// MATRIZ 2
				int n2 = tamanhoMatriz(arquivo);     // pega o tamanho da segunda matriz
				int[][] A2 = lerMatriz(arquivo, n2); // ler a matriz a2 
				int[][] B2 = lerMatriz(arquivo, n2); // ler a matriz b2

				// MATRIZ 3
				int n3 = tamanhoMatriz(arquivo);	 // pega o tamanho da terceira matriz
				int[][] A3 = lerMatriz(arquivo, n3); // ler a matriz a3
				int[][] B3 = lerMatriz(arquivo, n3); // ler a matriz b3

				return new Matrizes(A1, B1, A2, B2, A3, B3);

			} catch (IOException e) { // Caso ocorra erro na leitura do arquivo
				e.printStackTrace();
				return null;
			}
		} catch (NumberFormatException e) { // Caso ocorra erro na leitura do nome do arquivo
			e.printStackTrace();
			return null;
		}
	}
	
	// Funcao para pegar o tamanho matriz
	// Entrada: Arquivo com a matriz
	// Saida: O valor do tamanho da matriz
	// Pre-requisito: Arquivo ter sido lido
	// Pos-requisito: O tamanho da matriz ter sido atribuido 
	private static int tamanhoMatriz(BufferedReader arquivo) throws IOException {
		
		String linha;
		do {
			linha = arquivo.readLine();
		} while (linha != null && linha.trim().isEmpty());

		return Integer.parseInt(linha.split(":")[1].trim()); // retorna um inteiro
		
	}
	
	// Funcao para ler os valores da matriz 
	// Entrada: O arquivo com os dados da matriz e o tamanho da matriz
	// Saida: Matriz retornada
	// Pre-requisito: Arquivo ter sido lido
	// Pos-requisito: Matriz lida
	private static int[][] lerMatriz(BufferedReader arquivo, int tamanho) throws IOException {
		int[][] matriz = new int[tamanho][tamanho];
		
		arquivo.readLine(); // Descarta a linha que o nome da Matriz. ex: "Matriz A"
		
		for (int i = 0; i < tamanho; i++) { 
			String[] elementos = arquivo.readLine().split(" "); // Vai lendo todos os elementos
			for (int j = 0; j < tamanho; j++) {
				matriz[i][j] = Integer.parseInt(elementos[j]);  // Salvando os valores como inteiro
			}
		}
		return matriz; // Retorna a matriz que foi lida
	}
}