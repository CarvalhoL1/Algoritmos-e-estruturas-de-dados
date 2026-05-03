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

public class lista_ordenada {
    static int buscarIndice(ListaOrdenada lista, int x){
        int indice = -1;
        int n = lista.ultimo;
        int i = 0;
        while (i <= n){
            if(lista.dados[i] != null && lista.dados[i].chave == x){
                indice = i;
                i = n + 1; //força saida do laço
            }
            else{
                i = i + 1;
            }
        }
        return indice;
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

    static ListaOrdenada inserir(ListaOrdenada lista, NoSeq novoNo){
        if(busca(lista, novoNo.chave) == null) {

            if (lista.ultimo < lista.tamanho - 1) {
                if (lista.ultimo < 0) {
                    lista.dados[0] = novoNo;
                    lista.ultimo++;
                } else {
                    int i = lista.ultimo;
                    while (i >= 0 && novoNo.chave < lista.dados[i].chave) {
                        lista.dados[i + 1] = lista.dados[i];
                        i--;
                    }
                    lista.dados[i + 1] = novoNo;
                    lista.ultimo++;
                }

            } else {
                int novoTam = lista.tamanho * 2;
                int novoUltimo = lista.ultimo + 1;
                ListaOrdenada novaLista = new ListaOrdenada(novoTam);
                for (int i = 0; i <= lista.ultimo; i++) {
                    novaLista.dados[i] = lista.dados[i];
                }
                int j = lista.ultimo;
                while (j >= 0 && novoNo.chave < novaLista.dados[j].chave) {
                    novaLista.dados[j + 1] = novaLista.dados[j];
                    j--;
                }
                novaLista.ultimo = novoUltimo;
                novaLista.dados[j + 1] = novoNo;
                lista = novaLista;
                System.out.println("Tamanho duplicado!");
                imprimir(lista);
            }
            System.out.println("Adicionado com sucesso");
        }
        else{
            System.out.println("Erro: Chave "+ novoNo.chave +" já existe!");
        }
        return lista;
    }
    static NoSeq remover(ListaOrdenada lista, int x){
        int indice = buscarIndice(lista, x);
        NoSeq removido = null;
        if(indice >= 0){
            removido = lista.dados[indice];
            for(int i = indice; i < lista.ultimo; i++){
                lista.dados[i] = lista.dados[i+1];
            }
            lista.ultimo--;
        }
        return removido;
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



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        int novaChave;
        int indice;
        System.out.println("Digite o tamanho da lista a ser criada: ");
        int tam = sc.nextInt();
        ListaOrdenada lista = new ListaOrdenada(tam);
        do{
            System.out.println("Digite 1 para inserir");
            System.out.println("Digite 2 para remover");
            System.out.println("Digite 3 para buscar");
            System.out.println("Digite 4 para imprimir a lista");

            opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Digite a chave do Nó sequencial a ser inserido: ");
                    novaChave = sc.nextInt();
                    NoSeq novoNo = new NoSeq();
                    novoNo.chave = novaChave;
                    lista = inserir(lista, novoNo);
                    break;
                case 2:
                    System.out.println("Digite a chave do Nó sequencial a ser removido: ");
                    novaChave = sc.nextInt();
                    NoSeq removido = remover(lista, novaChave);
                    if(removido != null){
                        System.out.println("Removido com sucesso");
                    }
                    else{
                        System.out.println("Erro: Elemento " + novaChave + " não encontrado");
                    }
                    break;
                case 3:
                    System.out.println("Digite a chave do Nó sequencial a ser buscada: ");
                    novaChave = sc.nextInt();
                    indice = buscarIndice(lista, novaChave);
                    if(indice >= 0){
                        System.out.println("Nó de chave " + novaChave + " encontrado no indice " + indice);
                    }
                    else {
                        System.out.println("Nó de chave " + novaChave + " não foi encontrado");
                    }
                    break;
                case 4:
                    imprimir(lista);
                    break;
                default:
                    System.out.println("Comando inválido.");
                    break;
            }
        }while(true);
    }    
}
