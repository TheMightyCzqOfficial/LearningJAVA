package 集合.Map集合;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();//<K,V>k为键，v为内容
        map.put("001","czq");
        map.put("0011","czq");
        map.put("00111","czq");

        System.out.println(map);

        map.remove("001");
        System.out.println(map);//{001=czq, 001111=czq, 0011=czq, 00111111=czq, 00111=czq, 0011111=czq} hashmap重写了toString方法

        map.clear();
        System.out.println(map.isEmpty());
        map.put("001","czq001");
        map.put("001","czq002");
        map.put("001","czq003");
        map.put("0011","czq0011");
        map.put("00111","czq00111");
        System.out.println(map.containsKey("001")+"   "+map.containsValue("czq"));
        System.out.println(map.get("0011"));
        //遍历map集合方法一
        Set<String> k = map.keySet();//ctrl alt v
        for (String s:k){
            System.out.println(s+"="+map.get(s));//使用keyset获取键，使用增强for获取值
        }

        /*Collection<String> values = map.values();
        for (String value:values){
            System.out.println(value);
        }
*/
        System.out.println("-----------------");
        //遍历map集合方法二
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String,String> me:entrySet){
            String key= me.getKey();
            String value=me.getValue();
            System.out.println(key+"="+value);
        }

    }
}
