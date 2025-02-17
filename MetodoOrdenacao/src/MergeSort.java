import java.util.Scanner;

public class MergeSort {
	/**
	 * Esse algoritmo é baseado na estratégia de resolução de problemas conhecida como divisão-e-conquista.
	 * Essa técnica consiste basicamente em decompor a instância a ser resolvida em instâncias menores. 
	 * Divide o array em metades, ordena cada metade recursivamente e então mescla as metades ordenadas.
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

		// Ordena o array usando Merge Sort
		mergeSort(lista, 0, num - 1);

		// Exibe o array após a ordenação
		System.out.println("\nArray após a ordenação:");
		mostrarArray(lista);

		entrada.close();

	}
	
	public static void mergeSort(int[] lista, int inicio, int fim) {
	    if (inicio < fim) {
	        int meio = (inicio + fim) / 2;
	        mergeSort(lista, inicio, meio);
	        mergeSort(lista, meio + 1, fim);
	        merge(lista, inicio, meio, fim);
	    }
	}
	
	public static void merge(int[] lista, int inicio, int meio, int fim) {
	    int n1 = meio - inicio + 1;
	    int n2 = fim - meio;

	    // Cria arrays temporarios
	    int L[] = new int[n1];
	    int R[] = new int[n2];

	    // Copia dados para os arrays temporarios L[] e R[] 
	    for (int i = 0; i < n1; ++i)
	        L[i] = lista[inicio + i];
	    for (int j = 0; j < n2; ++j)
	        R[j] = lista[meio + 1 + j];

	    /* Mescla os arrays temporarios de volta para lista*/
	    int i = 0, j = 0;
	    int k = inicio;
	    while (i < n1 && j < n2) {
	        if (L[i] <= R[j]) {
	            lista[k] = L[i];
	            i++;
	        } else {
	            lista[k] = R[j];
	            j++;
	        }
	        k++;
	    }

	    // Copia os elementos restantes de L[]
	    while (i < n1) {
	        lista[k] = L[i];
	        i++;
	        k++;
	    }

	    // Copia os elementos restantes de R[]
	    while (j < n2) {
	        lista[k] = R[j];
	        j++;
	        k++;
	    }
	}

	
	public static void mostrarArray(int[] lista) {
		for (int value : lista) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

}
