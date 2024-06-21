import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Functions {
    List<List<Integer>> boxes = new ArrayList(); //Cria um List que dentro vai outro List
    public void readFile(String nameFile) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(nameFile));

            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                List<Integer> dimensions = new ArrayList<>();  //cria o list com as dimensões
                String[] numbers = line.split(" ");

                for (int i = 0; i < 3; ++i) {
                    String number = numbers[i];
                    int value = Integer.parseInt(number);
                    dimensions.add(value);
                }

                boxes.add(dimensions);
                ++lineNumber;
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
    public void calculateBoxVolume(){
        long cubic = 0;
        for (int i = 0; i < boxes.size(); ++i) { //pega as três dimensões de cada caixa e calcula seu volume
            cubic = boxes.get(i).get(0) * boxes.get(i).get(1) * boxes.get(i).get(2); // V = w * h * l
            System.out.println("Caixa: " + i + " " +cubic);
        }
    }

}