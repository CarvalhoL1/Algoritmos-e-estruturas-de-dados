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
    if(indice > 0){
        return &lista.dados[indice];
    }
    else{
        return NULL;
    }
}



int main(){
    return 0;
}