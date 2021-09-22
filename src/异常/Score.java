package 异常;

import java.util.Scanner;

public class Score {
    public static void main(String[] args)  {
        Scanner sc =new Scanner(System.in);
        int score = sc.nextInt();
        Teacher t=new Teacher();


        try {
            t.checkScore(score);
        } catch (ScoreException e) {
            e.printStackTrace();
        }


    }
}
