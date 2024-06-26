import java.util.List;

public class Main {
    public static void main(String[] args) {
        Functions functions = new Functions();
        functions.readFile("src/casosdeteste_2/caixas_15.txt");
        List<Box> boxes = functions.getBoxes();

        // Construir e imprimir o digrafo
        Digrafo digrafo = functions.construirDigrafo();
        functions.printDigrafo(digrafo);

    }
}