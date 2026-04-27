package dinamica;
import java.util.Scanner;
class NoSeq{
    int chave;
};
class ListaOrdenada {
    int tamanho;
    int ultimo;
    NoSeq[] dados;
    ListaOrdenada(int M){
        tamanho = M;
        ultimo = -1;
        dados = new NoSeq[tamanho];
        for(int i = 0; i < tamanho; i++){
            dados[i] = new NoSeq();
        }
    }
};

class OperacoesLista{
    static int buscarIndice(ListaOrdenada lista, int x){
        int indice = 0;
        int n = lista.ultimo;
        int i = 0;
        while (i <= n){
            if(lista.dados[i] != null && lista.dados[i].chave == x){
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

    static NoSeq busca(ListaOrdenada lista, int x){
        int indice = buscarIndice(lista, x);
        if(indice >= 0){
            return lista.dados[indice];
        }
        else{
            return null;
        }
    }

    static ListaOrdenada inserir(ListaOrdenada lista, int x){
        if(lista.ultimo < lista.tamanho - 1){
            if(lista.ultimo < 0){
                lista.dados[0].chave = x;
                lista.ultimo++;
            }
            else{
                int i = lista.ultimo;
                while (i >= 0 && x < lista.dados[i].chave) {
                    lista.dados[i + 1].chave = lista.dados[i].chave;
                    i--;
                }
                lista.dados[i+1].chave = x;
                lista.ultimo++;
            }

        }
        else{
            int novoTam = lista.tamanho * 2;
            int novoUltimo = lista.ultimo + 1;
            ListaOrdenada novaLista = new ListaOrdenada(novoTam);
            novaLista.ultimo = lista.ultimo + 1;
            for(int i = 0; i < novoUltimo; i++){
                novaLista.dados[i].chave = lista.dados[i].chave;
            }
            int i = lista.ultimo;
            while (i >= 0 && x < novaLista.dados[i].chave) {
                novaLista.dados[i + 1].chave = novaLista.dados[i].chave;
                i--;
            }
            novaLista.dados[i+1].chave = x;
            lista = novaLista;
            System.out.println("Tamanho duplicado!");
            OperacoesLista.imprimir(lista);
        }
        return lista;
    }
    static void remover(ListaOrdenada lista, int x){
        if(lista.ultimo == -1){
            System.out.println("Underflow");
            return;
        }
        int indice = buscarIndice(lista, x);
        if(indice >= 0){
            for(int i = indice; i < lista.ultimo; i++){
                lista.dados[i].chave = lista.dados[i+1].chave;
            }
            lista.ultimo--;
            System.out.println("Removido com sucesso");
        }
        else{
            System.out.println("Indice não encontrado");
            return;
        }
    }

    static void imprimir(ListaOrdenada lista){
        for(int i = 0; i <= lista.ultimo; i++){
            System.out.print(" [" + lista.dados[i].chave + "] ");
        }
        for(int j = lista.ultimo + 1; j < lista.tamanho; j++){
            System.out.print(" NIL ");
        }
        System.out.println("\n");
    }
}
public class lista_ordenada_dinamica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        int novaChave;
        System.out.println("Digite o tamanho da lista a ser criada: ");
        int tam = sc.nextInt();
        ListaOrdenada lista = new ListaOrdenada(tam);
        do{
            System.out.println("Digite 1 para inserir");
            System.out.println("Digite 2 para remover");
            System.out.println("Digite 3 para imprimir a lista");
            opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Digite a chave do Nó sequencial a ser inserido: ");
                    novaChave = sc.nextInt();
                    lista = OperacoesLista.inserir(lista, novaChave);
                    break;
                case 2:
                    System.out.println("Digite a chave do Nó sequencial a ser removido: ");
                    novaChave = sc.nextInt();
                    OperacoesLista.remover(lista, novaChave);
                    break;
                case 3:
                    OperacoesLista.imprimir(lista);
            }
        }while(true);
    }    
}
