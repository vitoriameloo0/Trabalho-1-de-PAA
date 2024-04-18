import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// Classe de manipulacao dos dados da machila
public class Mochila {
	int[] peso;
	int[] valores;
	int capacidade;
	
	
	// Função Construtora da classe mochila
	// Entrada: Os dados de peso, valores e capacidade da mochila
	// Saida: Nenhuma
	// Pre-requisito: Nenhuma
	// Pos-requisito: Manipulação dos dados das matrizes feitas
	public Mochila(int[] peso, int[] valores, int capacidade) {
		this.peso = peso;
		this.valores = valores;
		this.capacidade = capacidade;
	}
	
	// Função que retorna o peso
	// Entrada: Nenhuma
	// Saida: O peso
	// Pre-requisito: Nenhuma
	// Pos-requisito: Peso retornados
	public int [] getPeso() {
		return peso;
	}
	
	// Função que retorna os valores
	// Entrada: Nenhuma
	// Saida: Os valores
	// Pre-requisito: Nenhuma
	// Pos-requisito: Valores retornados
	public int [] getValores() {
		return valores;
	}
	
	// Função que retorna a capacidade da mochila
	// Entrada: Nenhuma
	// Saida: A capacidade
	// Pre-requisito: Nenhuma
	// Pos-requisito: Capacidade retornada
	public int getCapacidade() {
		return capacidade;
	}

	// Função para fazer a leitura de um arquivo
	// Entrada: Nenhuma
	// Saida:  Retorna os valores dos pesos, valores e capacidade, e null caso o contrario
	// Pre-requisito: Nenhuma
	// Pos-requisito: Arquivo lido
	public static Mochila lerArquivo() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Digite o nome do arquivo texto: ");
			String nomeArquivo = scanner.nextLine();

			try (BufferedReader arquivo = new BufferedReader(new FileReader(nomeArquivo))) {
				// Leitura da capacidade da mochila
				int capacidade = capacidade(arquivo);

				// Leitura dos pesos e valores dos objetos
				String[] pesosString = arquivo.readLine().split(" ");
				String[] valoresString = arquivo.readLine().split(" ");

				int[] pesos = new int[pesosString.length];     // Pega quantos pesos tem
				int[] valores = new int[valoresString.length]; // Pega quantos valores tem

				for (int i = 0; i < pesosString.length; i++) {
					pesos[i] = Integer.parseInt(pesosString[i]);     // Transforma os pesos em inteiros
					valores[i] = Integer.parseInt(valoresString[i]); // Transforma os valores em inteiros
				}

				return new Mochila(pesos, valores, capacidade); 
			} catch (IOException e) { // Caso haja erro na leitura do arquivo
				e.printStackTrace();
				return null;
			}
		} catch (NumberFormatException e) { // Caso haja erro na leitura no nome do arquivo
			e.printStackTrace();
			return null;
		}
	}

	// Função para fazer a leitura da capacidade
	// Entrada: Arquivo com os dados
	// Saida: Inteiro referente a capacidade
	// Pre-requisito: Arquivo lido
	// Pos-requisito: A capacidade da mochila ter sido atribuido 
	private static int capacidade(BufferedReader arquivo) throws IOException {

		String linha;
		do {
			linha = arquivo.readLine();
		} while (linha != null && linha.trim().isEmpty());

		return Integer.parseInt(linha.split(":")[1].trim());

	}

}
