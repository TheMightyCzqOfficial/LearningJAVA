package first;

public class 嵌套练习 {
    public static void main(String []args){
        for (int hour=0;hour<25;hour++){
            for (int minute=0;minute<60;minute++){
                for (int second=0; second<60; second++){
                    System.out.println("现在时间是"+hour+"："+minute+"："+second);
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException ex){
                        System.out.println(ex);
                    }
                }

            }
        }
    }
}
