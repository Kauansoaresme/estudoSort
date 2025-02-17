import java.util.Scanner;

public class BubbleSort {
	/**
	 * Nesse método, os elementos da lista são movidos para as posições
	 * adequadas de forma contínua. Se um elemento está inicialmente em uma posição i e, para que a lista fique
	 * ordenada, ele deve ocupar a posição j, então ele terá que passar por todas as posições entre i e j. 
	 * 
	 * Em cada iteração do método, percorremos a lista a partir de seu início comparando cada elemento com seu
	 * sucessor, trocando-se de posição se houver necessidade.
	 * 
	 * Desempenho:
	 * Melhor caso: O(n) (array já ordenado)
	 * Pior caso: O(n²) (array ordenado inversamente)
	 * Médio caso: O(n²)
	 */

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("QUANTIDADE DE NÚMEROS NO ARRAY: ");
		int num = entrada.nextInt(); //A variavel "num" recebe a quantidade de números (elementos) que o array deve ter.
		int[] lista = new int[num]; //Cria um array de tamanho "num"

		System.out.println("DIGITE OS NÚMEROS DO ARRAY:"); //Usuário escreve os números dos elementos do array
		for (int c = 0; c < num; c++) { //percorre o array
			System.out.print("Número " + (c + 1) + ": "); //Mostra para o usuário cada número escolhido
			lista[c] = entrada.nextInt(); // atribui o número digitado ao seu indice no array
		}

		// Exibe o array antes da ordenação
		System.out.println("\nArray antes da ordenação:");
		mostrarArray(lista);

		// Ordena o array usando Bubble Sort
		bubbleSort(lista);

		// Exibe o array após a ordenação
		System.out.println("\nArray após a ordenação:");
		mostrarArray(lista);

		entrada.close();

	}

	public static void bubbleSort(int[] lista) {
		int n = lista.length;
		//controla o número de passagens pelo array
		for (int i = 0; i < n - 1; i++) {
			//compara pares de elementos
			for (int j = 0; j < n - 1 - i; j++) {
				//compara dois elementos adjacentes
				if (lista[j] > lista[j + 1]) {
					//se o elemento da esquerda for maior que o elemento da direita, eles são trocados
					int aux = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = aux;
				}

			}
		}
	}

	public static void mostrarArray(int[] lista) {
		for (int value : lista) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

}
