import java.util.ArrayList;
import java.util.List;

public class Box {
    private int id; //cada caixa vai conter um id para saber qual é
    private int x;
    private int y;
    private int z;
    List<Box> containedBoxes;

    public Box(int id, int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.id = id;
        this.containedBoxes = new ArrayList<>();
    }
    public Box(){}

    public int getX() {return x;}
    public int getY() {return y;}
    public int getZ() {return z;}
    public int getId() {return id;}

    public boolean canContain(Box b) { //deve ter forma mais fácil de verificar, mas tô burro já
        if ((this.x > b.x && this.x > b.y && this.x > b.z) && //x > x e x > y e x > z
                (this.y > b.x && this.y > b.y && this.y > b.z)&&
                (this.z > b.x && this.z > b.y && this.z > b.z)){
            return true; //se todos forem maiores, retorna o true
        }
        return false; // algum deu errado, vai o false
    }
}
//Classe box pra criar um objeto box e suas dimensões, como ta aleatória as dimensões, usei x,y,x