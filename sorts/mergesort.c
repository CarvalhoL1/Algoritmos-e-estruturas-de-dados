#include <stdio.h>
#include <math.h>
#include <limits.h>
void mergesort(int V[], int p, int r);
void merge(int V[], int p, int q, int r);

int main (){
    
  int V[] = {27, 19, 87, 3, 45, 16, 48, 60};
  

  for(int i = 0; i < 8; i++){
    printf("[%i]", V[i]);
  }
  printf("\n");
  mergesort(V, 0, 7);

  for(int i = 0; i < 8; i++){
    printf("[%i]", V[i]);
  }
  return 0;
}

//p -> posição mais a esquerda, r direita
void mergesort(int V[], int p, int r){
    if(p < r){
        int q = floor((p+r)/2);
        mergesort(V, p, q); //lado esquerdo
        mergesort(V, q+1, r); //lado direito
        merge(V, p, q, r);
    }
}

void merge(int V[], int p, int q, int r){
    int n1 = q - p + 1;
    int n2 = r - q;
    int L[n1 + 1];
    int R[n2 + 1];
    for(int i = 0; i < n1; i++){
        L[i] = V[p + i];
    }
    for(int i = 0; i < n2; i++){
        R[i] = V[q + 1 + i];
    }
    L[n1] = INT_MAX;
    R[n2] = INT_MAX;
    int i = 0, j = 0;
    for(int k = p; k <= r; k++){
        if(L[i] <= R[j]){
            V[k] = L[i];
            i++;
        }
        else{
            V[k] = R[j];
            j++;
        }
    }
}
