import java.util.ArrayList;
import java.util.List;

public class Digrafo {
    private List<Box>[] listaAdjacencias;
    private int numVertices;
    private int numArestas;

    public Digrafo(int numVertices) {
        this.numVertices = numVertices;
        this.numArestas = 0;
        listaAdjacencias = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            listaAdjacencias[i] = new ArrayList<>();
        }
    }

    public void adicionarAresta(Box a, Box b) {
            listaAdjacencias[b.getId()].add(a);
            numArestas++;
    }
    public List<Box> adjacentes(Box box) {
        return listaAdjacencias[box.getId()];
    }

    public int getNumVertices() {
        return numVertices;
    }
    public void imprimirDigrafo() {
        System.out.println("Lista de adjacências do Digrafo:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Caixa " + i + " -> ");
            for (Box b : listaAdjacencias[i]) {
                System.out.print(b.getId() + " ");
            }
            System.out.println();
        }
    }
}
