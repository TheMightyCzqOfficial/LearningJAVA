package 集合.Map集合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ArrayList嵌套Hashmap {
    public static void main(String[] args) {
        ArrayList<HashMap<String,String>> arr=new ArrayList<>();
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("1","czq1");
        hashMap.put("2","czq2");
        hashMap.put("3","czq3");
        arr.add(hashMap);

        HashMap<String,String> hashMap1=new HashMap<>();
        hashMap1.put("11","czq11");
        hashMap1.put("12","czq12");
        hashMap1.put("13","czq13");
        arr.add(hashMap1);

        HashMap<String,String> hashMap2=new HashMap<>();
        hashMap2.put("21","czq21");
        hashMap2.put("22","czq22");
        hashMap2.put("23","czq23");
        arr.add(hashMap2);

        for (HashMap<String,String> hm:arr){
            Set<String> keySet = hm.keySet();
            for (String key:keySet){
                String value = hm.get(key);
                System.out.println(key+","+value);
            }
        }
    }
}
