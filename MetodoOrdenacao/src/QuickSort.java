import java.util.Scanner;
public class QuickSort {

	/**
     * Esse algoritmo divide um conjunto de itens em conjuntos menores, que são ordenados de forma
     * independente, e depois os resultados são combinados para produzir a solução de ordenação do conjunto
     * maior. Trata-se, portanto, de um algoritmo do tipo Divisão-e-Conquista, repartindo os dados em
     * subgrupos, dependendo de um elemento chamado pivô.
     * Neste método, a lista é dividida em parte esquerda e parte direita, sendo que os elementos da parte
     * esquerda são todos menores que os elementos da parte direita. Essa fase do processo é chamada de
     * partição. Em seguida, as duas partes são ordenadas recursivamente.
     * 
     * Desempenho:
     * Melhor caso: O(n log n)
     * Pior caso: O(n²)
     * Médio caso: O(n log n)
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

		// Ordena o array usando Quick Sort
		quickSort(lista, 0, num-1);

		// Exibe o array após a ordenação
		System.out.println("\nArray após a ordenação:");
		mostrarArray(lista);

		entrada.close();

	}
	
	public static void quickSort(int lista[], int menor, int maior) {
		//verifica se a sublista tem mais de um elemento
		if (menor < maior) {
            int pi = particao(lista, menor, maior); //chama a função de partição

         // ordena recursivamente as sublistas
            quickSort(lista, menor, pi - 1);
            quickSort(lista, pi + 1, maior);
        }
	}
	
	
	private static int particao(int[] lista, int menor, int maior) {
		//seleciona o menor elemento do array como pivo
        int pivo = lista[menor]; 
        int i = menor + 1; 
        int j = maior; 

     // dividir o array em duas partes
        while (i <= j) {
        	// encontra o próximo elemento maior que o pivo
            while (i <= j && lista[i] <= pivo) {
                i++;
            }
         // encontra o próximo elemento menor que o pivo
            while (i <= j && lista[j] > pivo) {
                j--;
            }
            if (i < j) { // se i for menor que j
                // troca os elementos lista[i] e lista[j]
                int temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
            }
        }

        // coloca o pivo na posição correta
        int temp = lista[menor];
        lista[menor] = lista[j];
        lista[j] = temp;

        return j;// retorna o indice do pivo
    }
	
	public static void mostrarArray(int[] lista) {
		for (int value : lista) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

}
