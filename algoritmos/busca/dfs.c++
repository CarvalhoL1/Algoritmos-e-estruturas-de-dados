#include <iostream>
#include <vector>
#include <stack>
using namespace std;

void dfs(vector<vector<int>>& grafo, int tam, int no_inicial){
    vector<bool> visitado(tam, false);
    stack<int> pilha;
    pilha.push(no_inicial);
    cout << "ordem de visitação: ";
    while(!pilha.empty()){
        int no = pilha.top();
        pilha.pop();
        if(!visitado[no]){
            cout << no << " ";
            visitado[no] = true;
            for(int vizinho:grafo[no]){
                if(!visitado[vizinho]){
                    pilha.push(vizinho);
                }
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
    dfs(grafo, 4, 0);

    return 0;
}