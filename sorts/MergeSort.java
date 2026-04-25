public class MergeSort {
    //p -> posição mais a esquerda, r direita
    public static void mergesort ( int V[], int p, int r){
        if (p < r) {
            int q = ((p + r) / 2);
            mergesort(V, p, q); //lado esquerdo
            mergesort(V, q + 1, r); //lado direito
            merge(V, p, q, r);
        }
    }

    public static void merge ( int V[], int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            L[i] = V[p + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = V[q + 1 + i];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                V[k] = L[i];
                i++;
            } else {
                V[k] = R[j];
                j++;
            }
        }
    }
    public static void main(String[] args){
        int V[] = {23, 54, 87, 300, 45, 16, 48, 60};


        for(int i = 0; i < 8; i++){
            System.out.print(" [" + V[i] + "] ");
        }
        System.out.println();
        mergesort(V, 0, 7);

        for(int i = 0; i < 8; i++){
            System.out.print("[" + V[i] + "] ");
        }
    }
}

