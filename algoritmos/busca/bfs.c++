#include <iostream>
#include <vector>
#include <queue>
using namespace std;

void bfs(vector<vector<int>>& grafo, int tam, int no_inicio){
    queue<int> fila;
    vector<bool> visitado(tam, false);
    visitado[no_inicio] = true;
    fila.push(no_inicio);
    cout << "ordem de visitação: ";
    while(!fila.empty()){
        int no = fila.front();
        fila.pop();
        cout << no << " ";
        for(int vizinho:grafo[no]){
            if(!visitado[vizinho]){
                visitado[vizinho] = true;
                fila.push(vizinho);
            }
        }
    }
}

int main(){
    vector<vector<int>> grafo(4); //grafo com 4 nós, representado por lista de adjacencia
    grafo[0] = {1, 3};
    grafo[1] = {0};
    grafo[2] = {2, 1};
    grafo[3] = {2};
    bfs(grafo, 4, 0);

    return 0;
}