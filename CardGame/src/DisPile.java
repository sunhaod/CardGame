import java.awt.*;
import java.util.ArrayList;

public class DisPile extends Pile{

    final int space = 20;

    public DisPile(){
        setCardSize(3);
    }

    public void delAllCard(){
        getCardList().clear();
        setLength(0);
        setFirstReversedIndex(-1);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Image image;
        if(getLength() == 0)
            return;
        for (int i = Math.max(0,getLength()-2); i < getLength();i ++){
            image = getCardList().get(i).getImage();
            graphics.drawImage(image,i*space,0,this);
        }
    }

    @Override
    public boolean checkCard(Pile pile) {
        return false;
    }

    @Override
    public void delCards(int n) {
        getCardList().remove(getLength()-1);
        setLength(getLength()-1);
    }

    @Override
    public ArrayList<Card> getSelected(int x, int y) {
        ArrayList<Card> temList = new ArrayList<>(1);
        if(getLength() == 0)
            return null;
        else if(getLength() == 1 && x < 80)
            temList.add(getCardList().get(getLength()-1));
        else if (getLength() == 2 && x > space && x < space + 80)
            temList.add(getCardList().get(getLength()-1));
        else if(getLength() >= 3 && x > 2 * space)
            temList.add(getCardList().get(getLength()-1));

        return temList;
    }

    @Override
    public void setPileSize(int x, int y) {
        setBounds(x,y,2 * space + 80,120);
    }
}
