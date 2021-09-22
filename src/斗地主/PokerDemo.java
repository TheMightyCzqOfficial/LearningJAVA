package 斗地主;

import java.util.ArrayList;
import java.util.Collections;

public class PokerDemo {
    public static void main(String[] args) {
        ArrayList<String> cardBox=new ArrayList<>();
        String[] colors={"♦","♣","♥","♠"};
        String[] numbers={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        for (String c:colors){
            for (String n:numbers){
                cardBox.add(c+n);
            }
        }
        cardBox.add("小王");
        cardBox.add("大王");
        System.out.println(cardBox);

        Collections.shuffle(cardBox);//洗牌

        System.out.println(cardBox);

        //发牌
        ArrayList<String> player1=new ArrayList<>();
        ArrayList<String> player2=new ArrayList<>();
        ArrayList<String> player3=new ArrayList<>();
        ArrayList<String> dizhu=new ArrayList<>();
        dizhu.add(cardBox.get(51));
        dizhu.add(cardBox.get(52));
        dizhu.add(cardBox.get(53));
        for (int i=0;i<cardBox.size();i++){
            if(i<17){
                player1.add(cardBox.get(i));
            }
            else if (i>=17&&i<34){
                player2.add(cardBox.get(i));
            }
            else if (i>=34&&i<51){
                player3.add(cardBox.get(i));
            }
        }
        System.out.println("玩家一手牌: "+player1);
        System.out.println("玩家一手牌: "+player2);
        System.out.println("玩家一手牌: "+player3);
        System.out.println("地主牌："+dizhu);

    }
}
