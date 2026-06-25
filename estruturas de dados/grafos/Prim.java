package grafos;
import java.io.*;

public class Prim {
    static class Grafo {
        int numVertices;
        int[][] matrizAdj;

        Grafo(int numVertices) {
            this.numVertices = numVertices;
            this.matrizAdj = new int[numVertices][numVertices];
        }
    }
    static class Heap {
        int[] vertices;
        int[] pos;
        int tamanho;
        Heap(int n){
            vertices = new int[n];
            pos = new int[n];
            tamanho = n;
        }
    }
    static void trocar(Heap h, int i, int j){
        int aux = h.vertices[i];
        h.vertices[i] = h.vertices[j];
        h.vertices[j] = aux;

        h.pos[h.vertices[i]] = i;
        h.pos[h.vertices[j]] = j;
    }
    static void heapify(Heap h, int[] chave, int i){
        int menor = i;

        int esq = 2 * i + 1;
        int dir = 2 * i + 2;

        if(esq < h.tamanho &&
                chave[h.vertices[esq]] < chave[h.vertices[menor]]){
            menor = esq;
        }

        if(dir < h.tamanho &&
                chave[h.vertices[dir]] < chave[h.vertices[menor]]){
            menor = dir;
        }

        if(menor != i){
            trocar(h, i, menor);
            heapify(h, chave, menor);
        }
    }
    static void atualizarPrioridade(Heap h, int[] chave, int vertice){
        int i = h.pos[vertice];

        while(i > 0){
            int pai = (i - 1) / 2;

            if(chave[h.vertices[pai]] <= chave[h.vertices[i]]){
                break;
            }

            trocar(h, i, pai);
            i = pai;
        }
    }
    static int extrairMin(Heap h, int[] chave){

        if(h.tamanho == 0){
            return -1;
        }

        int minimo = h.vertices[0];

        h.vertices[0] = h.vertices[h.tamanho - 1];
        h.pos[h.vertices[0]] = 0;
        h.pos[minimo] = h.tamanho - 1;
        h.tamanho--;

        heapify(h, chave, 0);

        return minimo;
    }
    static boolean estaNoHeap(Heap h, int v){
        return h.pos[v] < h.tamanho;
    }

    static void prim(Grafo g, int verticeOrigem){
        int n = g.numVertices;
        int[] chave = new int[n];
        int[] pai   = new int[n];
        for(int i = 0; i < g.numVertices; i++){
            chave[i] = Integer.MAX_VALUE;
            pai[i] = -1;
        }
        Heap heap = new Heap(n);

        for(int i = 0; i < n; i++){
            heap.vertices[i] = i;
            heap.pos[i] = i;
        }

        chave[verticeOrigem] = 0;
        atualizarPrioridade(heap, chave, verticeOrigem);

        while (heap.tamanho > 0) {
            int u = extrairMin(heap, chave);
            for (int v = 0; v < n; v++) {
                int peso = g.matrizAdj[u][v];
                if (peso > 0) {
                    if (estaNoHeap(heap, v) && peso < chave[v]) {
                        chave[v] = peso;
                        pai[v] = u;
                        atualizarPrioridade(heap, chave, v);
                    }
                }
            }
        }
        int custoTotal = 0;
        for (int v = 0; v < n; v++) {
            if (v == verticeOrigem) continue;
            if (chave[v] == Integer.MAX_VALUE) {
                System.out.println("Vertice " + v + ": inalcancavel");
            } else {
                System.out.println("Aresta " + pai[v] + " - " + v + ": " + chave[v]);
                custoTotal += chave[v];
            }
        }
        System.out.println("Custo total: " + custoTotal);
    }

    public static void main(String[] args) throws IOException {
        int n = 5;
        Grafo g = new Grafo(n);
        g.matrizAdj[0][1] = 2; g.matrizAdj[1][0] = 2;
        g.matrizAdj[0][3] = 6; g.matrizAdj[3][0] = 6;
        g.matrizAdj[1][2] = 3; g.matrizAdj[2][1] = 3;
        g.matrizAdj[1][3] = 8; g.matrizAdj[3][1] = 8;
        g.matrizAdj[1][4] = 5; g.matrizAdj[4][1] = 5;
        g.matrizAdj[2][4] = 7; g.matrizAdj[4][2] = 7;
        g.matrizAdj[3][4] = 9; g.matrizAdj[4][3] = 9;
        prim(g, 0);
    }
}