package 泛型;

/*public class Generic <T>{
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}*/
public class Generic{
    public <T> void show(T t){//泛型方法
        System.out.println(t);
    }
}
