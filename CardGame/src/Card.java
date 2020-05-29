import java.awt.*;

public class Card {
    private Image image;
    private int num;
    private int type;
    private boolean isUp;

    public Card(int num, int tpye, boolean isUp, Image image){
        this.num = num;
        this.type = tpye;
        this.isUp = isUp;
        this.image = image;
    }
    public int getNum(){
        return num;
    }

    public int getType(){
        return type;
    }

    public boolean isUp() {
        return isUp;
    }

    public Image getImage(){
        return image;
    }

    public void setIsUp(boolean isUp){
        this.isUp = isUp;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
