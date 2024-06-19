import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Functions {

    public void lerArquivo(String nomeArquivo) {
        List<List<Integer>> caixas = new ArrayList();
        BufferedReader leitor = null;

        try {
            leitor = new BufferedReader(new FileReader(nomeArquivo));

            String linha;
            for(int numeroLinha = 0; (linha = leitor.readLine()) != null; ++numeroLinha) {
                List<Integer> dimensions = new ArrayList();
                String[] numeros = linha.split(" ");

                for(int i = 0; i < 3; ++i) {
                    String numero = numeros[i];
                    int valor = Integer.parseInt(numero);
                    dimensions.add(valor);
                }

                caixas.add(dimensions);
            }

            Iterator var22 = caixas.iterator();

            while(var22.hasNext()) {
                List<Integer> caixa = (List)var22.next();
                System.out.println(caixa);
            }
        } catch (IOException var19) {
            IOException e = var19;
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            if (leitor != null) {
                try {
                    leitor.close();
                } catch (IOException var18) {
                    IOException e = var18;
                    System.out.println("Erro ao fechar o leitor: " + e.getMessage());
                }
            }

        }

    }

    public void contagemDeCaixas() {
    }
}