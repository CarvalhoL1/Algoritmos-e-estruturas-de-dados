package encadeadas.ordenadas;

import java.util.Scanner;

class NoListaSimplesEnc{
    int chave;
    NoListaSimplesEnc proximo;
}
class ListaSimplesEnc{
    NoListaSimplesEnc cabeca;
    ListaSimplesEnc(){
        cabeca = null;
    }
}
class ResultBusca{
    NoListaSimplesEnc ant; //anterior
    NoListaSimplesEnc pt;
    ResultBusca(NoListaSimplesEnc pt, NoListaSimplesEnc ant) {
        this.pt = pt;
        this.ant = ant;
    }
}
public class lista_simplismente_encadeada_ordenada {

    static ResultBusca busca(int x, ListaSimplesEnc lista) {
        NoListaSimplesEnc pt = lista.cabeca;
        NoListaSimplesEnc ant = null;
        if (pt != null) {
            while (pt != null && pt.chave < x) {
                ant = pt;
                pt = pt.proximo;
            }
        } else {
            System.out.println("Lista vazia!");
        }
        return new ResultBusca(pt, ant);
    }

    static void inserir(NoListaSimplesEnc x, ListaSimplesEnc lista) {
        NoListaSimplesEnc ant = null;
        ResultBusca res = busca(x.chave, lista);
        NoListaSimplesEnc pt = res.pt;
        ant = res.ant;
        if (pt == null  || pt.chave != x.chave) {
            if (ant == null) {
                x.proximo = lista.cabeca;
                lista.cabeca = x;
            } else {
                ant.proximo = x;
                x.proximo = pt;
            }
        } else {
            System.out.println("Nó " + x.chave + " já existe");
        }
    }

    static NoListaSimplesEnc remover(int x, ListaSimplesEnc lista) {
        ResultBusca res = busca(x, lista);
        NoListaSimplesEnc pt = res.pt;
        NoListaSimplesEnc ant = res.ant;
        if (pt != null) {
            if (ant == null) {
                lista.cabeca = pt.proximo;
            } else {
                ant.proximo = pt.proximo;
            }
            pt.proximo = null;
        }
        return pt;
    }

    static void imprimir(ListaSimplesEnc lista) {
        NoListaSimplesEnc pt = lista.cabeca;
        while (pt != null) {
            System.out.print("[" + pt.chave + "] ");
            pt = pt.proximo;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        int novaChave;
        ResultBusca res;

        ListaSimplesEnc lista = new ListaSimplesEnc();
        do{
            System.out.println("Digite 1 para inserir");
            System.out.println("Digite 2 para remover");
            System.out.println("Digite 3 para imprimir a lista");

            opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Digite a chave do Nó sequencial a ser inserido: ");
                    novaChave = sc.nextInt();
                    NoListaSimplesEnc novoNo = new NoListaSimplesEnc();
                    novoNo.chave = novaChave;
                    inserir(novoNo, lista);
                    break;
                case 2:
                    System.out.println("Digite a chave do Nó sequencial a ser removido: ");
                    novaChave = sc.nextInt();
                    NoListaSimplesEnc removido = remover(novaChave, lista);
                    if(removido != null){
                        System.out.println("Removido com sucesso");
                    }
                    else{
                        System.out.println("Erro: Elemento " + novaChave + " não encontrado");
                    }
                    break;
                case 3:
                    imprimir(lista);
                    break;
                default:
                    System.out.println("Comando inválido.");
                    break;
            }
        }while(true);
    }
}
