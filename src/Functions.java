import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Functions {
    ArrayList<Integer> larguras = new ArrayList();
    ArrayList<Integer> alturas = new ArrayList();
    ArrayList<Integer> comprimentos = new ArrayList();

    public void lerArquivo(String nomeArquivo) {
        List<List<Integer>> caixas = new ArrayList();
        BufferedReader leitor = null;

        try {
            leitor = new BufferedReader(new FileReader(nomeArquivo));

            String linha;
            int altura = 0;
            int largura = 0;
            int comprimento = 0;

            while ((linha = leitor.readLine()) != null){
                List<Integer> dimensions = new ArrayList();
                String[] numeros = linha.split(" ");

                for(int i = 0; i < 3; ++i) {
                    String numero = numeros[i];
                    int valor = Integer.parseInt(numero);
                    if (i == 0) {
                        largura = valor;
                        larguras.add(valor);
                    } else if (i == 1) {
                        altura = valor;
                        alturas.add(valor);
                    } else {
                        comprimento = valor;
                        comprimentos.add(valor);
                    }

                    dimensions.add(valor);
                }

                System.out.println(largura + " " + altura + " " + comprimento);
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
        calculaCaixa();
    }

    public void calculaCaixa(){

    }


    public void contagemDeCaixas() {

    }

}