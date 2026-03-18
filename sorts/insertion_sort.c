#include <stdio.h>

//insertion sort "padrão"
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

//insertion sort com adição de prints e adaptações desnecessarias para o funcionamento, mas uteis para entendimento do codigo
void insertion_sort_explicado(int V[], int n){
    for (int i = 1; i < n; i++){
        int chave = V[i];
        int original = V[i];
        int j = i - 1;
        printf("Comparando %i na posicao %i com %i na posicao %i\n", V[i], i, V[j], j);
        while (j >= 0 && V[j] > chave){
            printf("Movendo %i para a direita\n", V[j]);
            V[j+1] = V[j];
            j--;
            
        }
        V[j + 1] = chave;
     
        for (int t = 0; t < n; t++){
                printf("%i  ", V[t]);
                }
            printf("\n");
    }
}

int main(){
    int V[] = {5, 2, 4, 8, 1, 11, 2};
    int n = sizeof(V)/sizeof(V[0]);
    for (int i = 0; i < n; i++){
        printf("%i  ", V[i]);
    }
    printf("\n");
    insertion_sort_explicado(V, n);
    return 0;
}