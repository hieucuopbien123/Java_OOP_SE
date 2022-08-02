package NewFeature;

// Interface

class Square {
    private int canh;

    public Square(int canh) {
        this.canh = canh;
    }
    public int getCanh() {
        return canh;
    }
    public void setCanh(int canh) {
        this.canh = canh;
    }
}

interface ShapeInterface{
    //default method của interface k cần khai báo ở class implement interface cx đc
    default void squareInfo(Square square){
        System.out.println("Hình vuông có cạnh: "+ square.getCanh());
    }
    void show(String name);//in ra tên hình
    float area(Square square);//tinh dien tich
}
class SquareImpl implements ShapeInterface{
    @Override
    public void show(String name) {
        System.out.println("Tên hình: "+name);
    }
    @Override
    public float area(Square square) {
        return square.getCanh() * square.getCanh();
    }
}
public class DefaultMethods {
    public static void main(String[] args) {
        Square square = new Square(5);
        ShapeInterface shapeInterface = new SquareImpl();
        shapeInterface.squareInfo(square);
        shapeInterface.show("Hình vuông");
    }
}