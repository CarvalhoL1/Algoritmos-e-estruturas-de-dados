#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <stdbool.h>

#define MAX_VERTICES 100


// Definição da estrutura do Grafo
typedef struct No {
    int vertice;        
    int peso;         
    struct No* prox;  
} No;

// Estrutura do Grafo
typedef struct Grafo {
    int numVertices;
    No** listasAdj;     // Vetor de ponteiros (onde cada posição é a cabeça de uma lista)
} Grafo;

void inicializarGrafo(Grafo *g, int vertices) {
    g->numVertices = vertices;

    // Aloca o vetor de ponteiros para as listas de adjacência
    g->listasAdj = (No**) malloc(vertices * sizeof(No*));

    // Inicializa todas as listas como vazias (NULL)
    for (int i = 0; i < vertices; i++) {
        g->listasAdj[i] = NULL;
    }
}

// Adiciona uma aresta direcionada com peso
void adicionarAresta(Grafo* grafo, int origem, int destino, int peso) {
    // Cria o novo nó
    No* novoNo = (No*) malloc(sizeof(No));
    novoNo->vertice = destino;
    novoNo->peso = peso;
    
    novoNo->prox = grafo->listasAdj[origem];
    grafo->listasAdj[origem] = novoNo;
}

void iniciarFonteUnica(Grafo *g, int s, int d[], int pai[]) {
    int tam = g->numVertices;
    for(int i = 0; i < tam; i++){
        d[i] = INT_MAX;
        pai[i] = -1;
    }
    d[s] = 0; //distancia do vertice foco até ele mesmo é 0
}
void relaxarNo(int u, No* vizinho, int d[], int pai[]){
    int v = vizinho ->vertice;
    int peso_u_v = vizinho->peso;
    if(d[u] != INT_MAX && d[v] > d[u] + peso_u_v) {
        d[v] = d[u] + peso_u_v;
        pai[v] = u;
    }
}
int extrairMinimo(int d[], bool visitado[], int numVertices) {
    int min = INT_MAX;
    int indiceMinimo = -1;

    for (int v = 0; v < numVertices; v++) {
        // Se o vértice ainda não foi visitado e tem a menor distância até agora
        if (visitado[v] == false && d[v] <= min) {
            min = d[v];
            indiceMinimo = v;
        }
    }

    return indiceMinimo; // Retorna o vértice mais "barato"
}
void Dijkstra(Grafo *g, int numVertices, int verticeOrigem){
    int d[numVertices];
    bool visitado[numVertices];
    int pai[numVertices];
    for(int i = 0; i < numVertices; i++){
        visitado[i] = false;
    }
    iniciarFonteUnica(g, verticeOrigem, d, pai);
    for (int i = 0; i < numVertices; i++){
        int u = extrairMinimo(d, visitado, numVertices);
        if (u == -1) break; 
        
        // Marca o vértice u como visitado (retirado da "fila")
        visitado[u] = true;

        // Apontamos para o primeiro vizinho na lista de adjacência de 'u'
        No* atual = g->listasAdj[u];
        while (atual != NULL) {
            int v = atual->vertice; // 'v' é o vértice vizinho
          
            if (!visitado[v]) {
                relaxarNo(u, atual, d, pai);
            }
            atual = atual->prox;
        }
    }
    printf("Resultados do Dijkstra (Origem: %d):\n", verticeOrigem);
    for (int i = 0; i < numVertices; i++) {
        printf("Ate o vertice %d -> Menor Distancia: ", i);
        if(d[i] != INT_MAX){
            printf("%d, Pai: ", d[i]);
        }
        else{
            printf("INFINITO, Pai: ");
        }
        if(pai[i] != -1){
            printf("%d\n", pai[i]);
        }
        else{
            printf("nulo\n");
        }
    }
}
int main() {
    Grafo g;
    int numVertices = 5;

    inicializarGrafo(&g, numVertices);

    // Criando as conexões (Origem, Destino, Peso)
    adicionarAresta(&g, 0, 1, 4); // Aresta de 0 para 1 com peso 4
    adicionarAresta(&g, 0, 2, 2); // Aresta de 0 para 2 com peso 2
    adicionarAresta(&g, 1, 2, 3); // Aresta de 1 para 2 com peso 3
    adicionarAresta(&g, 2, 3, 2); // Aresta de 2 para 3 com peso 2
    adicionarAresta(&g, 3, 4, 6); // Aresta de 3 para 4 com peso 6
    adicionarAresta(&g, 1, 0, 4); // Aresta de 1 para 0 com peso 4
    adicionarAresta(&g, 1, 3, 7); // Aresta de 1 para 3 com peso 7
    adicionarAresta(&g, 4, 3, 2); // Aresta de 4 para 3 com peso 7
    Dijkstra(&g, numVertices, 0);
    
    return 0;
}