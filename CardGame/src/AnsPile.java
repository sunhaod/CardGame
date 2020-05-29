import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AnsPile extends Pile {

    private int thisType;

    public AnsPile() {
        setCardSize(13);
    }

    public int getThisType(){
        return thisType;
    }

    public void setThisType(int thisType) {
        this.thisType = thisType;
    }

    @Override
    protected void paintComponent(Graphics graphics){
        Image image;
        if(getLength() == 0)
            image = new ImageIcon("image/no_card.png").getImage();
        else
            image = getCardList().get(getLength()-1).getImage();
        graphics.drawImage(image,0,0,this);
    }

    @Override
    public boolean checkCard(Pile pile) {
        int n = pile.getLength();
        if(n != 1)
            return false;
        Card card = pile.getCardList().get(0);
        if(getLength() == 0) {
            if(card.getNum() == 1)
                return true;
            return false;
        }else{
            Card curPileLastCard = getCardList().get(getLength()-1);
            if (curPileLastCard.getNum() - card.getNum() == -1 && getThisType() == card.getType())
                    return true;
            return false;
        }
    }

    @Override
    public void delCards(int n){
        if(getLength() != 0) {
            getCardList().remove(getLength()-1);
            setLength(getLength()-1);
            if(getLength() == 0)
                setFirstReversedIndex(-1);
        }
    }

    @Override
    public ArrayList<Card> getSelected(int x, int y) {
        if(getLength() == 0)
            return null;
        ArrayList<Card> temList = new ArrayList<>();
        temList.add(getCardList().get(getLength()-1));
        return temList;
    }

    @Override
    public void setPileSize(int x, int y) {
        setBounds(x,y,80,120);
    }
}
