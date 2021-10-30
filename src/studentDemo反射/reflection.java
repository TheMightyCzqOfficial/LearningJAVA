package studentDemo反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class reflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        Class<? extends ArrayList> c=arr.getClass();
        Method m = c.getMethod("add", Object.class);
        m.invoke(arr,"hello");
        m.invoke(arr,true);
        m.invoke(arr,15.5);
        m.invoke(arr,10);

        System.out.println(arr);
    }
}
