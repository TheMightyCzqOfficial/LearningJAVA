package studentDemo反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class 反射 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> c=Class.forName("studentDemo反射.Student");
        Constructor<?>[] cons=c.getDeclaredConstructors();//获取无参构造方法
        for (Constructor con:cons){
            System.out.println(con);
        }
        System.out.println("--------------------");

        Constructor<?> con=c.getConstructor(String.class,int.class);//获取带参数构造方法
        Object obj=con.newInstance("sb",100);
        System.out.println(obj);

        System.out.println("----------------");

        Field names = c.getDeclaredField("name");
        names.setAccessible(true);//取消访问检查 调用private
        names.set(obj,"aaaaaaa");
        System.out.println(obj);

        System.out.println("------------------");

        Method[] methods = c.getDeclaredMethods();
        for(Method m:methods){
            System.out.println(m);
        }
        Method study = c.getDeclaredMethod("study1",int.class);//调用私有方法 带参数
        study.setAccessible(true);
        study.invoke(obj,1);

        Method caishu = c.getMethod("caishu", String.class, int.class, double.class);
        Object ss = caishu.invoke(obj, "aaaaaaaddddddd", 50, 15.51);
        System.out.println(ss);

    }
}
