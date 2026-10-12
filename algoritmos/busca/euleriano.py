# Usando a matriz de adjacencia para representar o grafo


# O grafo deve ser conexo para ser circuito ou caminho euleriano

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

# Para ser circuito euleriano cada vertice deve possuir grau par, ou seja, se conecte a uma quantidade par de vertices

def circuito_euleriano(G):
    if not conexo(G):
        print("Não é circuito euleriano")
        return
    for u in range(len(G)):
        grau = 0
        for v in range(len(G[0])):
            if G[u][v] != 0:
                grau += 1
        if grau % 2 != 0:
            print("Não é circuito euleriano")
            return
    print("É circuito euleriano")
    
# Para ser caminho euleriano, exatamente dois vertices devem possuir grau impar 
def caminho_euleriano(G):
    if not conexo(G):
        print("Não é caminho euleriano")
        return
    grau = [0] * len(G[0])
    for u in range(len(G)):
        for v in range(len(G[0])):
            if G[u][v] != 0:
                grau[u] += 1
    qtdImpar = 0
    for i in grau:
        if i % 2 != 0:
            qtdImpar += 1
    if qtdImpar == 2:
        print("É caminho euleriano")
        return
    print("Não é caminho euleriano")
            
        
g1 = [
    [0,1,1,0],
    [1,0,0,1],
    [1,0,0,1],
    [0,1,1,0]
]

circuito_euleriano(g1)
caminho_euleriano(g1)

print()

g2 = [
    [0,1,0,0],
    [1,0,0,0],
    [0,0,0,1],
    [0,0,1,0]
]

circuito_euleriano(g2)
caminho_euleriano(g2)

print()

g3 = [
    [1,1,0,0],
    [1,0,1,1],
    [1,0,0,1],
    [1,1,1,0]
]

circuito_euleriano(g3)
caminho_euleriano(g3)
