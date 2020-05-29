import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class NorPile extends Pile {

    final int spaceDown = 10;
    final int spaceUp = 25;

    public NorPile() {
        setCardSize(20);//最大7+13张
    }

    //判断是否可以将点击的牌堆放入新牌堆中
    @Override
    public boolean checkCard(Pile pile) {
        Card card = pile.getCardList().get(0);
        if(getLength() == 0) {
            if(card.getNum() == 13)
                return true;
            return false;
        }else{
            Card curPileLastCard = getCardList().get(getLength()-1);
            if (curPileLastCard.getNum() - card.getNum() == 1){
                if(card.getType() + curPileLastCard.getType() > 3 && card.getType() + curPileLastCard.getType() < 7)
                    return true;
                return false;
            }
            return false;
        }
    }

    //删除牌堆最外面的n张牌
    @Override
    public void delCards(int n) {
        for (int i = 1; i <= n; i ++) {
            getCardList().remove(getLength()-1);
            setLength(getLength()-1);
        }
        if(getLength() == getFirstReversedIndex()){
            setFirstReversedIndex(-1);
        }
    }

    //画出牌
    @Override
    protected void paintComponent(Graphics graphics) {
        Image temImage;
        if(getLength() == 0) {
            temImage = new ImageIcon("image/no_card.png").getImage();
            graphics.drawImage(temImage,0,0, this);
        }else{
            temImage = new ImageIcon("image/card_back.png").getImage();
            for(int i = 0; i < getFirstReversedIndex(); i ++) {
                graphics.drawImage(temImage,0,i*spaceDown,this);
            }
            int temSpace;
            for(int i = getFirstReversedIndex(); i < getLength(); i ++) {
                temSpace = getFirstReversedIndex()*spaceDown + (i-getFirstReversedIndex())*spaceUp;
                graphics.drawImage(getCardList().get(i).getImage(),0,temSpace, this);
            }
        }
    }

    //选出点击中的牌
    @Override
    public ArrayList<Card> getSelected(int x, int y){
        if(getLength() == 0) {
            return null;
        }

        if(y < (getFirstReversedIndex())*spaceDown)
            return null;

        int n = (y-(getFirstReversedIndex())*spaceDown)/spaceUp + 1;

        if(n >= 1  && n <= 13 && getFirstReversedIndex() >= 0) {
            ArrayList<Card> temList = new ArrayList<>();
            for(int i = n + getFirstReversedIndex() - 1; i < getLength();i ++) {
                temList.add(getCardList().get(i));
            }
            return temList;
        }
        return null;
    }

    @Override
    public void setPileSize(int x, int y) {
        if(getLength() == 0)
            setBounds(x,y,80,120);
        else
            setBounds(x,y,80,spaceDown*(getFirstReversedIndex())+spaceUp*(getLength()-getFirstReversedIndex()) + 120);
    }
}
