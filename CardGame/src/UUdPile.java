import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UUdPile extends Pile {

    private int leftCard;

    public UUdPile(){
        setCardSize(24);
    }

    public int getLeftCard(){
        return leftCard;
    }

    public void setLeftCard(int leftCard){
        this.leftCard = leftCard;
    }

    public void clickCard(DisPile disPile){
        if(leftCard == 0) {
            return;
        }
        if(getLength() == 0) {
            setLength(leftCard);
            disPile.delAllCard();
        }else {
            disPile.addACard(getCardList().get(getLength()-1));
            setLength(getLength() - 1);
        }
    }


    @Override
    protected void paintComponent(Graphics graphics){
        Image image;
        if(getLength() == 0)
            image = new ImageIcon("image/no_card.png").getImage();
        else
            image = new ImageIcon("image/card_back.png").getImage();
        graphics.drawImage(image,0,0,this);
    }

    @Override
    public boolean checkCard(Pile pile) {
        return false;
    }

    @Override
    public void delCards(int n){
        getCardList().remove(getLength());
        leftCard --;
    }

    @Override
    public ArrayList<Card> getSelected(int x, int y) {
        return null;
    }

    @Override
    public void setPileSize(int x, int y) {
        setBounds(x,y,80,120);
    }
}
