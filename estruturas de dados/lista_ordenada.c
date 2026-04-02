#include <stdio.h>

typedef struct noSeq{
    int chave;
}noSeq;
typedef struct lista_ordenada{
    int tamanho;
    int ultimo;
    noSeq dados[];
}lista_ordenada;

int buscarIndice(int x, lista_ordenada lista){
    int indice = 0;
    int n = lista.ultimo;
    int i = 0;
    while (i <= n){
        if(lista.dados[i].chave == x){
            indice = i;
            i = n + 1; //força saida do laço
        }
        else{
            i = i + 1;
        }
    }
    return indice;
}

//Por ser C, tive que adaptar para retornar o ponteiro
noSeq* busca(int x, lista_ordenada lista){
    int indice = buscarIndice(x, lista);
    if(indice >= 0){
        return &lista.dados[indice];
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
            while (i > 0 && x < lista->dados[i].chave) {
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
    noSeq removido;
    if(indice > 0){
        removido = lista->dados[indice];
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

int main(){
    return 0;
}