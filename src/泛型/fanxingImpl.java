package 泛型;

public  class  fanxingImpl<T> implements fanxing<T>{
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
