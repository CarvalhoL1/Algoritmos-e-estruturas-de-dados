public class arvoreDeBuscaBinaria {
    static class No {
        int chave;
        No pai;
        No esquerda;
        No direita;
    }

    static class Arvore {
        No raiz;
    }

    static No busca (int x, No pt){
        if(pt == null || pt.chave == x){
            return pt;
        }
        else if (x < pt.chave){
            return busca(x, pt.esquerda);
        }
        else{
            return busca(x, pt.direita);
        }
    }

    static void inserir (No x, Arvore arv){
        No pai = null;
        No pt = arv.raiz;
        while (pt != null){
            pai = pt;
            if (x.chave <= pt.chave){
                pt = pt.esquerda;
            }
            else{
                pt = pt.direita;
            }
        }
        x.pai = pai;
        if (pai == null){
            arv.raiz = x;
        }
        else if (x.chave <= pai.chave){
            pai.esquerda = x;
        }
        else{
            pai.direita = x;
        }
    }

    static No sucessor(No pt){
        if (pt.direita != null){
            pt = pt.direita;
            while (pt.esquerda != null){
                pt = pt.esquerda;
            }
            return pt;
        } else {
            No pai = pt.pai;
            while (pai != null && pt == pai.direita){
                pt = pai;
                pai = pai.pai;
            }
            return pai;
        }
    }

    static No remover(int x, Arvore arv){
        No pt = busca(x, arv.raiz);
        if(pt == null){
            System.out.println("Nó de chave " + x + "não encontrado");
        }
        else{
            if(pt.esquerda == null && pt.direita == null){
                No pai = pt.pai;
                if(pai != null){
                    if(pai.chave >= pt.chave) {
                        pai.esquerda = null;
                    }
                    else{
                        pai.direita = null;
                    }
                }
                else{
                    arv.raiz = null;
                }
            }
            else if(pt.esquerda != null && pt.direita != null){
                No sucessor = sucessor(pt);
                sucessor = remover(sucessor.chave, arv);
                sucessor.pai = pt.pai;
                pt.pai = null;
                sucessor.esquerda = pt.esquerda;
                pt.esquerda = null;
                sucessor.direita = pt.direita;
                pt.direita = null;
                No pai = sucessor.pai;
                if(pai != null){
                    if(pai.chave >= sucessor.chave){
                        pai.esquerda = sucessor;
                    }
                    else{
                        pai.direita = sucessor;
                    }
                }
                else{
                    arv.raiz = sucessor;
                }
                sucessor.esquerda.pai = sucessor;
                if(sucessor.direita != null){
                    sucessor.direita.pai = sucessor;
                }
            }
            else{
                No pai = pt.pai;
                No filho = null;
                if(pt.esquerda != null){
                    filho = pt.esquerda;
                    pt.esquerda = null;
                }
                else{
                    filho = pt.direita;
                    pt.direita = null;
                }
                if(pai != null){
                    filho.pai = pai;
                    if(filho.chave <= pai.chave){
                        pai.esquerda = filho;
                    }
                    else {
                        pai.direita = filho;
                    }
                }
                else{
                    arv.raiz = filho;
                }
                pt.pai = null;
            }
        }
        return pt;
    }

    public static void emOrdem(No pt){
        if(pt != null){
            emOrdem(pt.esquerda);
            System.out.print(pt.chave + " ");
            emOrdem(pt.direita);
        }
    }

    public static void main(String[] args){

        Arvore arv = new Arvore();

        int[] valores = {50, 30, 70, 20, 40, 60, 80};

        // inserção
        for(int v : valores){
            No novo = new No();
            novo.chave = v;
            inserir(novo, arv);
        }

        System.out.println("Árvore inicial:");
        emOrdem(arv.raiz);

        // remover folha
        System.out.println("\n\nRemovendo 20:");
        remover(20, arv);
        emOrdem(arv.raiz);

        // remover nó com 1 filho
        System.out.println("\n\nRemovendo 30:");
        remover(30, arv);
        emOrdem(arv.raiz);

        // remover nó com 2 filhos
        System.out.println("\n\nRemovendo 50:");
        remover(50, arv);
        emOrdem(arv.raiz);

        // busca
        System.out.println("\n\nBuscando 60:");
        No encontrado = busca(60, arv.raiz);

        if(encontrado != null){
            System.out.println("Encontrado: " + encontrado.chave);
        }
        else{
            System.out.println("Não encontrado");
        }
    }
}