import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Functions {

    Box box = new Box();
    List<Box> boxes = new ArrayList(); // o List que vai as boxes
    String primeiraLinha;
    public void readFile(String nameFile) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(nameFile));

            String line;
            int lineNumber = 0;
            int id = 0;
            primeiraLinha = reader.readLine(); //lê a primeira linha que contém o número de caixas
            //System.out.println("N° de caixas: " + primeiraLinha);
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split(" ");
                int x = Integer.parseInt(numbers[0]);
                int y = Integer.parseInt(numbers[1]);
                int z = Integer.parseInt(numbers[2]);
                Box box = new Box(id, x, y, z);
                boxes.add(box);
                id++;
                lineNumber++;
            }
            for(Box box : boxes) {
                //System.out.println(box.getId() + " " +box.getX() + " " + box.getY() + " " + box.getZ());
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o leitor: " + e.getMessage());
                }
            }
        }
    }

    public List<Box> getBoxes() {
        return boxes;
    }


    public Digrafo construirDigrafo() {
        Digrafo digrafo = new Digrafo(boxes.size());
        ordenarPeloX();
        for (int i = 0; i < boxes.size(); i++) {
            Box a = boxes.get(i);
            for (int j = 0; j < boxes.size(); j++) {
                if (i != j) {
                    Box b = boxes.get(j);
                    if (a.canContain(b)) {
                        digrafo.adicionarAresta(a, b);
                    }
                }
            }
        }
        return digrafo;
    }






    public void printDigrafo(Digrafo digrafo) {
        System.out.println("Lista de adjacências do Digrafo:");
        System.out.println("--------------------------------");

        for (int i = 0; i < digrafo.getNumVertices(); i++) {
            List<Box> adjacentes = digrafo.adjacentes(boxes.get(i));
            if (!adjacentes.isEmpty()) {
                System.out.println("Caixa " + boxes.get(i).getId() + " contém:");
                for (Box adjacente : adjacentes) {
                    System.out.println("- Caixa " + adjacente.getId());
                }
                System.out.println();
            }
        }
    }

    public void ordenarPeloX() {
        Collections.sort(boxes, Comparator.comparingInt(Box :: getX));
    }
}