import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    final int width = 1200;
    final int height = 650;
    JFrame mainFrame;
    MainPanel mainPanel;

    Card cards[];
    ArrayList<Card> curCardList;
    ArrayList<Card> temCardListForRandom;
    Pile curPile = null;
    boolean dragFlag = false;
    boolean releaseFlag  = false;
    int mouseX;
    int mouseY;


    AnsPile ansPile[];
    NorPile norPile[];
    DisPile disPile;
    UUdPile uUdPile;
    TemPile temPile;

    public class MainPanel extends JPanel{

        @Override
        protected void paintComponent(Graphics graphics){
            graphics.drawImage(new ImageIcon("image/backgound.png").getImage(),0,0,this);
        }
    }

    private Card getARandomCard(){
        Random random = new Random();
    }

    private void init(){

        temCardListForRandom = new ArrayList<>();

        //红桃1，方片2，黑桃3，梅花4
        cards = new Card[52];

        for(int i = 0; i < 13; i ++) {
            cards[i] = new Card(i,1,false,new ImageIcon("image/1_"+(i+1)+".png").getImage());
            temCardListForRandom.add(cards[i]);
            cards[i+13] = new Card(i,2,false,new ImageIcon("image/2_"+(i+1)+".png").getImage());
            temCardListForRandom.add(cards[i+13]);
            cards[i+26] = new Card(i,3,false,new ImageIcon("image/3_"+(i+1)+".png").getImage());
            temCardListForRandom.add(cards[i+26]);
            cards[i+39] = new Card(i,4,false,new ImageIcon("image/4_"+(i+1)+".png").getImage());
            temCardListForRandom.add(cards[i+39]);
        }

        //随机生成卡片位置
        ArrayList<Card> temList = new ArrayList<>();
    }

    private void createFrame(){

        mainFrame = new JFrame("CardGame");
        mainPanel = new MainPanel();

        ansPile = new AnsPile[4];
        norPile = new NorPile[7];
        uUdPile = new UUdPile();
        disPile = new DisPile();
        temPile = new TemPile();
        for(int i = 0; i < 4; i ++)
            ansPile[i] = new AnsPile();
        for(int i = 0; i < 7; i ++)
            norPile[i] = new NorPile();

        mainPanel.setLayout(null);
        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setBounds(30,10,width,height);
        mainPanel.add(uUdPile);
        mainPanel.add(disPile);
        mainPanel.add(temPile);
        for(int i = 0; i < 4; i ++)
            mainPanel.add(ansPile[i]);
        for(int i = 0; i < 7; i ++)
            mainPanel.add(norPile[i]);

        init();








    }

    public void work() {

    }

    public static void main(String[] args){
        new Main().createFrame();
    }

}
