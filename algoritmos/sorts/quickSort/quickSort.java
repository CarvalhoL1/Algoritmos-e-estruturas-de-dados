package quickSort;

public class quickSort {
    static int vezesTrocar = 0;
    public static void QuickSort(int A[], int p, int r){
        System.out.println("quicksort "+ p + " " + r + " empilhado.");
        if(p < r){
            int q = particionar(A, p, r);
            QuickSort(A, p, q-1);
            QuickSort(A, q+1, r);
        }
        System.out.println("quicksort "+ p + " " + r + " desempilhado.");

    }
    private static int particionar(int A[],int p,int r){
        System.out.println("particionar "+ p + " " + r + " empilhado.");
        int x = A[r];
        int i = p - 1;
        for(int j = p; j < r; j++){
            if(A[j] <= x){
                i++;
                trocar(A, i, j);
            }
        }
        trocar(A, i+1, r);
        for (int t = 0; t < A.length; t++){
            System.out.print("["+A[t]+"] ");
        }
        System.out.println();
        System.out.println("particionar "+ p + " " + r + " desempilhado.");
        return i + 1;
    }
    private static void trocar(int A[], int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        vezesTrocar++;
    }
    public static void main(String[] args){

        int V[] = {239, 120, 54, 4, 87, 8};
        System.out.println("Vetor original: ");
        for (int i = 0; i < V.length; i++){
            System.out.print("["+V[i]+"] ");
        }
        System.out.println();
        QuickSort(V, 0, V.length-1);

        for (int i = 0; i < V.length; i++){
            System.out.print("["+V[i]+"] ");
        }
        System.out.println();
        System.out.println("Vezes que o procedimento trocar foi utilizado: "+ vezesTrocar);
    }
}
