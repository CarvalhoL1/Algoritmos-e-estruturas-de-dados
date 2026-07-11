# A ideia é implementar duas pilhas dividindo um unico vetor, cada uma começando em uma extremidade

class noSeq:
    chave: int
    def __init__(self, chave):
        self.chave = chave

class pilha:
    topo1: int # topo 1 começa na extremidade esquerda
    topo2: int # topo 2 começa na extremidade direita
    tam: int
    def __init__(self, tam):
        self.tam = tam
        self.topo1 = -1
        self.topo2 = tam
        self.dados = [None] * tam

def push_esquerda(P: pilha, x: noSeq):
    if P.topo1 + 1 == P.topo2:
        print("Overflow!")
        return
    else:
        P.topo1 += 1
        P.dados[P.topo1] = x

def push_direita(P: pilha, x: noSeq):
    if P.topo1 + 1 == P.topo2:
        print("Overflow!")
        return
    P.topo2 -= 1
    P.dados[P.topo2] = x

def pop_esquerda(P: pilha):
    if P.topo1 == -1:
        print("Underflow!")
        return
    P.topo1 -= 1

def pop_direita(P: pilha):
    if P.topo2 == P.tam:
        print("Underflow!")
        return
    P.topo2 += 1

def imprimir(P: pilha):
    for i in range(P.topo1 + 1):
        print("[" + str(P.dados[i].chave) + "] ", end="")
    for i in range(P.topo1 + 1, P.topo2):
        print(" [NULL] ", end="")
    for i in range(P.topo2, P.tam):
        print("[" + str(P.dados[i].chave) + "] ", end="")
    print()

p = pilha(6)
push_esquerda(p, noSeq(3))
push_esquerda(p, noSeq(7))
push_direita(p, noSeq(4))
push_direita(p, noSeq(5))
push_direita(p, noSeq(2))
imprimir(p)

push_direita(p, noSeq(1))
push_esquerda(p, noSeq(4))
imprimir(p)

pop_direita(p)
imprimir(p)