package quickSort;

public class quickSort {
    public static void QuickSort(int A[], int p, int r){
        if(p < r){
            int q = particionar(A, p, r);
            QuickSort(A, p, q-1);
            QuickSort(A, q+1, r);
        }
    }
    private static int particionar(int A[],int p,int r){
        int x = A[r];
        int i = p - 1;
        for(int j = p; j < r; j++){
            if(A[j] <= x){
                i++;
                trocar(A, i, j);
            }
        }
        trocar(A, i+1, r);
        return i + 1;
    }
    private static void trocar(int A[], int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public static void main(String[] args){
        int V[] = {239, 120, 54, 4, 87, 8};
        for (int i = 0; i < V.length; i++){
            System.out.print(V[i]+" ");
        }
        System.out.println();
        QuickSort(V, 0, V.length-1);

        for (int i = 0; i < V.length; i++){
            System.out.print(V[i]+" ");
        }

    }
}
