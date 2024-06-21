public class Main {
    public static void main(String[] args) {
        Functions functions = new Functions();
        functions.readFile("src/casosdeteste/caixas_10.txt");
        functions.calculateBoxVolume();
    }
}