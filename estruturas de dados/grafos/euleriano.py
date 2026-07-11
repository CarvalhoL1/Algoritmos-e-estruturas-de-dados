# Usando a matriz de adjacencia para representar o grafo

# Para ser circuito euleriano cada vertice deve possuir grau par, ou seja, se conecte a uma quantidade par de vertices
# O grafo tambem deve ser conexo


def conexo(G):
    visitado = [False] * len(G)
    inicio = -1
    for u in range(len(G)):
        for v in range(len(G[0])):
            if G[u][v] > 0:
                inicio = G[u][v]
                visitado[u] = True
                break
    if inicio == -1:
        if len(G) < 1:
            return True
        return False
    pilha = [inicio]
    while pilha:
        u = pilha.pop()
        for v in range(len(G)):
            if G[u][v] > 0 and not visitado[v]:
                pilha.append[v]
                visitado[v] = True
    return all(visitado)

def circuito_euleriano(G):
    if not conexo(G):
        print("Não é circuito euleriano")
        return
    for u in range(len(G)):
        soma = 0
        for v in range(len(G[0])):
            if G[u][v] != 0:
                soma += 1
        if soma % 2 != 0:
            print("Não é circuito euleriano")
            return
    print("É circuito euleriano")
    return
            
        
g1 = [
    [0, 1, 1, 0],
    [1, 0, 0, 1],
    [1, 0, 0, 1],
    [0, 1, 1, 0]
]

circuito_euleriano(g1)

print()

g2 = [
    [0,1,0,0],
    [1,0,0,0],
    [0,0,0,1],
    [0,0,1,0]
]

circuito_euleriano(g2)