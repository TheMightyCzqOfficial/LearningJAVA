package first;

public class shuixianhua {
    public static int shuixianhua(int n){
        int g,s,b,sum;
        g=(n%10)*(n%10)*(n%10);
        s=(n%100/10)*(n%100/10)*(n%100/10);
        b=(n/100)*(n/100)*(n/100);
        sum=g+s+b;
        return sum;
    }
    public static void main(String []args){
        //Scanner sc=new Scanner(System.in);
        int num;


        for(int i=100;i<1000;i++){
            num=shuixianhua(i);
            if(num==i){
                System.out.println(i);
            }
        }

   }
}
