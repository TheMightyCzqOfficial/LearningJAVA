package first;

public class zhushu {
    public static void main(String[] args) {
        int a,b;

        for (a=300;a<=2000;a++){
            boolean c=true;
            for (b=2;b<a;b++){
                if ((a%b)==0){
                    c=false;
                    break;
                }
            }
            if (c==true){
                System.out.println(a);
            }
        }
    }
}
