package extendTest;

public class zi extends fu{
    public int s=20;
    public void  son(){
        int s=10;
        System.out.println("子类方法被调用");
        System.out.println("super："+super.f+"from inside:"+s+"from outside:"+this.s);
    }
    public zi(){
        System.out.println("子类方法被调用");
    }
}
