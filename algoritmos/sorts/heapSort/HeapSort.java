package heapSort;

public class HeapSort {
    public static void heapsort(int A[], int tamanhoA){
        int tamanhoHeap = tamanhoA;
        costruirMaxHeap(A, tamanhoHeap);
        for(int i = tamanhoA; i > 0; i--){
            trocar(A, 0, i);
            tamanhoHeap--;
            maxHeapfy(A, 0, tamanhoHeap);
        }
    }
    public static void costruirMaxHeap(int A[], int tamanhoHeap){
        for(int i = tamanhoHeap/2; i > 0; i--){
            maxHeapfy(A, i, tamanhoHeap);
        }
    }
    public static void maxHeapfy(int A[], int i, int tamanhoHeap){
        int l = retornarIndiceFilhoEsquerda(i);
        int r = retornarIndiceFilhoDireita(i);
        int maior;
        if(l <= tamanhoHeap && A[l] > A[i]){
            maior = l;
        }
        else{
            maior = i;
        }
        if(r <= tamanhoHeap && A[r] > A[maior]){
            maior = r;
        }
        if(maior != i){
            trocar(A, i, maior);
            maxHeapfy(A, maior, tamanhoHeap);
        }
    }
    public static int retornarIndiceFilhoEsquerda(int i){
        return i * 2 + 1;
    }
    public static int retornarIndiceFilhoDireita(int i){
        return i * 2 + 2;
    }
    private static void trocar(int A[], int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public static void main (String[] args){
        int[] V = {43, 1, 34, 32, 5, 2};
        for (int i = 0; i < V.length; i++){
            System.out.print("["+V[i]+"] ");
        }
        System.out.println();
        heapsort(V, V.length-1);
        for (int i = 0; i < V.length; i++){
            System.out.print("["+V[i]+"] ");
        }
    }
}