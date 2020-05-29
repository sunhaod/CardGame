import java.awt.*;
import java.util.ArrayList;

public class TemPile extends Pile {

    final int space = 25;

    public TemPile(){
        setCardSize(13);
        setPileSize(0,0);
    }


    @Override
    protected void paintComponent(Graphics graphics){
        Image image;

        if(getLength() == 0)
            return;
        for(int i = 0; i < getLength(); i ++){
            image = getCardList().get(i).getImage();
            graphics.drawImage(image,0,(i)*space,this);
        }
    }

    @Override
    public boolean checkCard(Pile pile) {
        return false;
    }

    @Override
    public void delCards(int n) {
        getCardList().clear();
        setLength(0);
        setFirstReversedIndex(-1);
    }

    @Override
    public ArrayList<Card> getSelected(int x, int y) {
        return getCardList();
    }

    @Override
    public void setPileSize(int x, int y) {
        if(getLength() == 0)
            setBounds(x,y,0,0);
        else
            setBounds(x,y,80,space*(getLength()-1)+120);
    }
}
