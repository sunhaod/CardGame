import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Pile extends JPanel {
    private ArrayList<Card> cardList;
    private int length = 0;
    private int firstReversedIndex = -1;//第一个是正面的牌的位置

    public int getLength() {
        return length;
    }

    public int getFirstReversedIndex(){
        return firstReversedIndex;
    }

    public ArrayList<Card> getCardList(){
        return cardList;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setFirstReversedIndex(int firstReversedIndex) {
        this.firstReversedIndex = firstReversedIndex;
    }

    public void setCardSize(int n) {
        cardList = new ArrayList<Card>(n);
    }

    //将一张牌放到该牌堆上
    public void addACard(Card card){
        cardList.add(card);
        length ++;
    }


    //将一个牌堆加到另一个牌堆上
    public void addCards(ArrayList<Card> list) {
        int n = list.size();
        for(int i = 0; i < n; i ++){
            cardList.add(list.get(i));
        }
        if(firstReversedIndex == -1){
            setFirstReversedIndex(getLength());
        }
        length = length + list.size();
    }

    //将牌顶最上面的牌转正
    public void reverseCard() {
        if(firstReversedIndex == -1) {
            cardList.get(length - 1).setIsUp(true);
            firstReversedIndex = length - 1;
        }
    }

    public abstract boolean checkCard(Pile pile);

    public abstract void delCards(int n);

    public abstract ArrayList<Card> getSelected(int x, int y);

    public abstract void setPileSize(int x,int y);
}
