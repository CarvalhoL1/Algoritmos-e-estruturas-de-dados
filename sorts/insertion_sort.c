#include <stdio.h>

void insertion_sort(int V[], int n){
    for (int i = 1; i < n; i++){
        int chave = V[i];
        int j = i - 1;
        while (j >= 0 && V[j] > chave){
            V[j+1] = V[j];
            j--;
        }
        V[j + 1] = chave;
    }
}

int main(){
    int V[] = {5, 2, 4, 8, 1, 11};
    int n = sizeof(V)/sizeof(V[0]);
    for (int i = 0; i < n; i++){
        printf("%i  ", V[i]);
    }
    printf("\n");
    insertion_sort(V, n);
    for (int i = 0; i < n; i++){
        printf("%i  ", V[i]);
    }
    
    return 0;
}