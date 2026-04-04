#include <stdio.h>
#define MAX 20
typedef struct noSeq{
    int chave;
}noSeq;
typedef struct lista_ordenada{
    int tamanho;
    int ultimo;
    noSeq dados[MAX];
}lista_ordenada;

int buscarIndice(int x, lista_ordenada lista){
    int indice = 0;
    int n = lista.ultimo;
    int i = 0;
    while (i <= n){
        if(lista.dados[i].chave == x){
            indice = i;
            i = n + 1; //força saida do laço
            return indice;
        }
        else{
            i = i + 1;
        }
    }
    return -1;
}

//Por ser C, tive que adaptar para retornar o ponteiro
noSeq* busca(int x, lista_ordenada *lista){
    int indice = buscarIndice(x, *lista);
    if(indice >= 0){
        return &lista->dados[indice];
    }
    else{
        return NULL;
    }
}
void inserir(int x, lista_ordenada *lista){
    if(lista->ultimo < lista->tamanho - 1){
        if(lista->ultimo < 0){
            lista->dados[0].chave = x;
            lista->ultimo++;
        }
        else{
            int i = lista->ultimo;
            while (i >= 0 && x < lista->dados[i].chave) {
                lista->dados[i + 1] = lista->dados[i];
                i--;
            }
            lista->dados[i+1].chave = x;
            lista->ultimo++;
        }
        
    }
    else{
        printf("Lista cheia!");
    }
}
void remover(int x, lista_ordenada *lista){
    if(lista->ultimo == -1){
        printf("Underflow");
        return;
    }
    int indice = buscarIndice(x, *lista);
    if(indice >= 0){
        for(int i = indice; i < lista->ultimo; i++){
            lista->dados[i] = lista->dados[i+1];
        }
        lista->ultimo--;
    }
    else{
        printf("Indice não encontrado");
        return;
    }
}
void imprimir(lista_ordenada lista){
    printf("Lista: ");
    for(int i = 0; i <= lista.ultimo; i++){
        printf("[%i]", lista.dados[i].chave);
    }
    printf("\n");
}

int main(){
    lista_ordenada lista;
    lista.ultimo = -1;
    lista.tamanho = MAX;
    inserir(10, &lista);
    imprimir(lista);

    inserir(4, &lista);
    imprimir(lista);

    inserir(20, &lista);
    imprimir(lista);
  
    remover(10, &lista);
    imprimir(lista);

    inserir(2, &lista);
    inserir(200, &lista);
    inserir(50, &lista);
    imprimir(lista);

    remover(4, &lista);
    imprimir(lista);
    noSeq* teste = busca(50, &lista);
    noSeq* indiceTeste = buscarIndice(50, lista);
    if(teste != NULL){
        printf("%d esta no indice %i (contando a partir do 0)\n", teste->chave, indiceTeste);
    }
    else{
        printf("Elemento nao encontrado\n");
    }
    return 0;
}