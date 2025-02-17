import java.util.Scanner;

public class HeapSort {
	/**
	 * Esse algoritmo utiliza uma estrutura de dados chamada heap, para ordenar os
	 * elementos à medida que os insere na estrutura. Assim, ao final das inserções,
	 * os elementos podem ser sucessivamente removidos da raiz da heap, na ordem
	 * desejada.
	 * 
	 * Essa estrutura pode ser representada como uma árvore ou como um vetor.
	 * Inicialmente, insere-se os elementos da lista em um heap. Em seguida, fazemos
	 * sucessivas remoções do menor elemento do heap, colocando os elementos
	 * removidos do heap de volta na lista – a lista estará então em ordem
	 * crescente. O heapsort é um algoritmo de ordenação em que a sua estrutura
	 * auxiliar de armazenamento fora do arranjo de entrada é constante durante toda
	 * a sua execução.
	 * 
	 * Desempenho:
	 * Melhor caso: O(n log n)
	 * Pior caso: O(n log n)
	 * Médio caso: O(n log n)
	 */

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("QUANTIDADE DE NÚMEROS NO ARRAY: ");
		int num = entrada.nextInt(); // A variavel "num" recebe a quantidade de números (elementos) que o array deve
										// ter.
		int[] lista = new int[num]; // Cria um array de tamanho "num"

		System.out.println("DIGITE OS NÚMEROS DO ARRAY:"); // Usuário escreve os números dos elementos do array
		for (int c = 0; c < num; c++) { // percorre o array
			System.out.print("Número " + (c + 1) + ": "); // Mostra para o usuário cada número escolhido
			lista[c] = entrada.nextInt(); // atribui o número digitado ao seu indice no array
		}

		// Exibe o array antes da ordenação
		System.out.println("\nArray antes da ordenação:");
		mostrarArray(lista);

		// Ordena o array usando Heap Sort
		heapSort(lista);

		// Exibe o array após a ordenação
		System.out.println("\nArray após a ordenação:");
		mostrarArray(lista);

		entrada.close();

	}

	public static void heapSort(int lista[]) {
		int n = lista.length;

		// Construir o heap (rearranjar o array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(lista, n, i);

		// Extrair um elemento do heap de cada vez
		for (int i = n - 1; i > 0; i--) {
			// Mover a raiz atual para o final
			int temp = lista[0];
			lista[0] = lista[i];
			lista[i] = temp;

			heapify(lista, i, 0);
		}
	}

	public static void heapify(int lista[], int n, int i) {
		int maior = i; // Inicializar maior como a raiz
		int esquerda = 2 * i + 1;
		int direita = 2 * i + 2;

		// Se o filho esquerdo é maior que a raiz
		if (esquerda < n && lista[esquerda] > lista[maior])
			maior = esquerda;

		// Se o filho direito é maior que o maior
		if (direita < n && lista[direita] > lista[maior])
			maior = direita;

		// Se o maior não é a raiz
		if (maior != i) {
			int troca = lista[i];
			lista[i] = lista[maior];
			lista[maior] = troca;

			// heapificar a subárvore recursivamente
			heapify(lista, n, maior);
		}
	}

	public static void mostrarArray(int[] lista) {
		for (int value : lista) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

}
