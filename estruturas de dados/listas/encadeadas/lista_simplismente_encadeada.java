package encadeadas;
class NoListaSimplesEnc{
    int chave;
    NoListaSimplesEnc proximo;
}
class ListaSimplesEnc{
    NoListaSimplesEnc cabeca;
}
class ResultBusca{
    NoListaSimplesEnc ant; //anterior
    NoListaSimplesEnc pt;
    ResultBusca(NoListaSimplesEnc pt, NoListaSimplesEnc ant) {
        this.pt = pt;
        this.ant = ant;
    }
}
public class lista_simplismente_encadeada {

    static ResultBusca busca(int x, ListaSimplesEnc lista) {
        NoListaSimplesEnc pt = lista.cabeca;
        NoListaSimplesEnc ant = null;
        if (pt != null) {
            while (pt != null && pt.chave != x) {
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
        if (pt == null) {
            if (ant == null) {
                lista.cabeca = x;
            } else {
                ant.proximo = x;
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
        ListaSimplesEnc lista = new ListaSimplesEnc();
        NoListaSimplesEnc teste = new NoListaSimplesEnc();
        teste.chave = 4;
        NoListaSimplesEnc teste2 = new NoListaSimplesEnc();
        teste2.chave = 6;
        inserir(teste, lista);
        imprimir(lista);
        inserir(teste2, lista);
        imprimir(lista);
        remover(4, lista);
        imprimir(lista);
    }
}
