package first;

import java.util.Random;
import java.util.Scanner;

public class guessNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r =new Random();
        int guess,max=100,min=0;
        int num=r.nextInt(100);
        System.out.println("Please input a number from 0 to 100");
        do {
            guess=sc.nextInt();
            if (guess<num) {
                System.out.println("too small please input a number from " + guess + " to " +max );
                min=guess;

            }
            else if(guess>num){
                System.out.println("too big please input a number from " + min + " to " +guess );
                max=guess;

            }
            else {
                System.out.println("congratulation! the number is : "+num);
            }
        }while(guess!=num);

    }
}
