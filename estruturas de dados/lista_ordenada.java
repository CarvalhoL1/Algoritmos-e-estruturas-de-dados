
class NoSeq{
    int chave;
};
class ListaOrdenada{
    int tamanho;
    int ultimo;
    NoSeq[] dados;
    ListaOrdenada(int tamanho){
        this.tamanho = tamanho;
        this.ultimo = -1;
        this.dados = new NoSeq[tamanho];
        for(int i = 0; i < tamanho; i++){
            this.dados[i] = new NoSeq();
    }
}

int buscarIndice(int x){
    int indice = 0;
    int n = ultimo;
    int i = 0;
    while (i <= n){
        if(dados[i].chave == x){
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

NoSeq busca(int x){
    int indice = buscarIndice(x);
    if(indice >= 0){
        return dados[indice];
    }
    else{
        return null;
    }
}
void inserir(int x){
    if(ultimo < tamanho - 1){
        if(ultimo < 0){
            dados[0].chave = x;
            ultimo++;
        }
        else{
            int i = ultimo;
            while (i >= 0 && x < dados[i].chave) {
                dados[i + 1].chave = dados[i].chave;
                i--;
            }
            dados[i+1].chave = x;
            ultimo++;
        }
        
    }
    else{
        System.out.println("Lista cheia!");
    }
}
void remover(int x){
    if(ultimo == -1){
        System.out.println("Underflow");
        return;
    }
    int indice = buscarIndice(x);
    if(indice >= 0){
        for(int i = indice; i < ultimo; i++){
            dados[i].chave = dados[i+1].chave;
        }
        ultimo--;
    }
    else{
        System.out.println("Indice não encontrado");
        return;
    }
}
void imprimir(){
    System.out.println("Lista: ");
    for(int i = 0; i <= ultimo; i++){
        System.out.print("[" + dados[i].chave + "]");
    }
    System.out.println("\n");
}
};

public class lista_ordenada {
    public static void main(String[] args)
    {   
        ListaOrdenada lista = new ListaOrdenada(20);
        lista.inserir(10);
        lista.imprimir();

        lista.inserir(4);
        lista.imprimir();

        lista.inserir(20);
        lista.imprimir();

        lista.remover(10);
        lista.imprimir();

        lista.inserir(2);
        lista.inserir(200);
        lista.inserir(50);
        lista.imprimir();

        lista.remover(4);
        lista.imprimir();

        NoSeq teste = lista.busca(50);
        if (teste != null) {
            System.out.println(teste.chave + " no indice " + lista.buscarIndice(teste.chave) + " contando a partir do 0");
        } else {
            System.out.println("Elemento nao encontrado");
        }
        }
}