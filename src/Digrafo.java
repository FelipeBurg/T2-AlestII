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
        if (a.canContain(b)){
            listaAdjacencias[a.getId()].add(b);
            numArestas++;
        }
    }

    public List<Box> adjacentes(Box box) {
        return listaAdjacencias[box.getId()];
    }

    public int getNumVertices() {
        return numVertices;
    }
}
