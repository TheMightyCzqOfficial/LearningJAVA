package 斗地主;

import java.util.*;

public class PokerDemoSort {
    public static void main(String[] args) {
        ArrayList<String> cardBox = new ArrayList<>();
        String[] colors = {"♦", "♣", "♥", "♠"};
        String[] numbers = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A","2"};
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < 54; i++) {
            index.add(i);
        }
//        System.out.println(index);
        for (String n : numbers) {
            for (String c : colors) {
                cardBox.add(c + n);
            }
        }
        cardBox.add("小王");
        cardBox.add("大王");
        System.out.println(cardBox);

        HashMap<Integer, String> cards = new HashMap<>();
        for (Integer i : index) {
            cards.put(i, cardBox.get(i));
        }
        Set<Integer> keySet = cards.keySet();
        for (Integer i : keySet) {
            String s = cards.get(i);
            System.out.println(i + "," + s);
        }

        Collections.shuffle(index);
        /*for (Integer i:index){
            String s = cards.get(i);
            System.out.println(i+","+s);
        }*/
        TreeSet<Integer> p1 = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                return 0;
                int num = o2 - o1;
                return num;
            }
        });
        TreeSet<Integer> dipai = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                return 0;
                int num = o2 - o1;
                return num;
            }
        });
        TreeSet<Integer> p2 = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                return 0;
                int num = o2 - o1;
                return num;
            }
        });
        TreeSet<Integer> p3 = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                return 0;
                int num = o2 - o1;
                return num;
            }
        });
        int j = 0;
        for (Integer i : index) {
            if (i < 17) {
                p1.add(index.get(i));
            } else if (i >= 17 && i < 34) {
                p2.add(index.get(i));
            } else if (i >= 34 && i < 51) {
                p3.add(index.get(i));
            } else {
                dipai.add(index.get(i));
            }
            j += 1;
        }
        System.out.println("玩家一的牌是: ");
        for (Integer i : p1) {
            System.out.print(cards.get(i) + " ");
        }
        System.out.println("\n玩家二的牌是: ");
        for (Integer i : p2) {
            System.out.print(cards.get(i) + " ");
        }
        System.out.println("\n玩家三的牌是: ");
        for (Integer i : p3) {
            System.out.print(cards.get(i) + " ");
        }
        System.out.println("\n底牌是: ");
        for (Integer i : dipai) {
            System.out.print(cards.get(i) + " ");
        }
        //叫地主
        Scanner sc = new Scanner(System.in);
        System.out.println("\n是否叫地主？ 输入 yes/no\n");
        String jiaodizhu = sc.nextLine();
        if (jiaodizhu.equals("yes")) {
            for (Integer i : dipai) {
                p1.add(i);
            }
        }
        else {
            for (Integer i : dipai) {
                p2.add(i);
            }
        }
        //checkCombo(p2,cards);
        show(p1, cards);

        chupai(p1,p2, cards);
    }

    public static void show(TreeSet<Integer> t, HashMap arr) {
        System.out.println("你的手牌是: ");
        int j = 1;
        for (Integer i : t) {
            System.out.print(arr.get(i) + "(" + j + ") ");
            j++;
        }
        System.out.println("共 " + t.size() + " 张牌");
    }

    public static void showcard(TreeSet<Integer> t, HashMap arr) {
        for (Integer i : t) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println("");
    }

    public static TreeSet chupai(TreeSet<Integer> tr,TreeSet<Integer> r1, HashMap hm) {
        /*
        索引存在TreeSet 根据索引去牌盒HashMap找牌
        出牌索引转换为牌盒索引
        利用新建的HashMap
        */
        show(tr, hm);
        ArrayList<Integer> arr = new ArrayList<>();
        TreeSet<Integer> t = new TreeSet<>();
        HashMap<Integer, Integer> ha = new HashMap<>();
        int j = 1;
        for (Integer i : tr) {
            ha.put(j, i);
            j++;
        }
        Scanner sc = new Scanner(System.in);
        int input;
        System.out.println("选择你要输入的牌 一个数字一回车 输入0结束 请勿输入非整数！");
        for (; ; ) {
            input = sc.nextInt();
            if (input < 0 || input > tr.size()) {
                System.out.println("输入有误，请重新输入！");
                continue;
            } else if (input == 0) {
                break;
            } else {
                arr.add(input);
            }

        }
        for (Integer i : arr) {
            int chu = ha.get(i);
            t.add(chu);
        }
        Iterator<Integer> it = t.iterator();


        //出牌规则
        if (rulesOfChupai(t) == "false") {
            System.out.println("你出的牌: ");
            showcard(t, hm);
            System.out.println("不符合牌型,请重新出牌！");
            t.clear();
            chupai(tr,r1, hm);
        } else {
            System.out.println("出牌成功，你出的牌是: ");
            String type = rulesOfChupai(t);

            arr.clear();//比较牌力
            for (Integer i:t){
                int chu = it.next();
                arr.add(chu);
            }
            Collections.sort(arr);
            TreeSet<Integer> check=new TreeSet<>();
            if (type=="三条"||type=="三带一"){
                for (int i=0;i<arr.size()-2;i++){
                    if (arr.get(i)/4==arr.get(i+2)/4){
                        check.add(arr.get(i));
                        check.add(arr.get(i+1));
                        check.add(arr.get(i+2));
                        //int sumOfsantiao= arr.get(i)+arr.get(i+1)+arr.get(i+2);
                    }
                }
            }

            Integer power = checkPower(check);
            checkCombo(r1,hm,type,power);
            check.clear();
            showcard(t, hm);
            System.out.println(rulesOfChupai(t));
            removeCard(t, tr);
            show(tr, hm);
            chupai(tr,r1, hm);
        }

        return t;
    }

    public static void removeCard(TreeSet<Integer> t, TreeSet<Integer> tr) {
        for (Integer i : t) {
            tr.remove(i);
        }
    }
    public static Integer checkPower(TreeSet<Integer> t){
        int power=0;
        for (Integer i:t){
            power+=i;
        }
        return power;
    }
    public static String rulesOfChupai(TreeSet<Integer> t) {
        //转为ArrayList

        ArrayList<Integer> arr = new ArrayList<>();
        for (Integer i : t) {
            arr.add(i);
        }
        Collections.sort(arr);
//        int cha0=0,yu0=0;
//        cha0=arr.get(1)-arr.get(0);
//        yu0=arr.get(1)%4-arr.get(0)%4;
        int num = arr.size();
        //单张

        if (num==1){
            return "单张";
        }
        else if (num == 2) {     //炸弹
            int cha = 0, cha1 = 0;
            cha = arr.get(1);
            cha1 = arr.get(0);
            if (arr.get(0) + arr.get(1) == 105) {
                return "王炸";
            } else if ((cha / 4) != (cha1 / 4)) { //对子
                //System.out.println("牌型有误,请重新出牌！");
                return "false";
            } else {

                return "对子";
            }
        }


        //三带一,二
        else if (num == 4 || num == 5 || num == 3) {
            int c3 = 0, c4 = 0, c2 = 0, c1 = 0, c0 = 0;
            //三在前
            c2 = arr.get(2) / 4;

            c1 = arr.get(1) / 4;

            c0 = arr.get(0) / 4;

            if (num == 3) {
                if (c2 == c1 && c1 == c0 && c2 == c0) {
                    return "三条";
                }
            } else if (num == 4) {
                c3 = arr.get(3) / 4;


                if (c3 == c0) {
                    return "炸弹";
                }//炸弹
                else if (c3 == c1 || c0 == c2) {
                    return "三带一";
                } else {
                    return "false";
                }


            } else if (num == 5) {
                c3 = arr.get(3) / 4;
                c4 = arr.get(4) / 4;

                if (c4 == 13 && c3 == 13) {
                    return "false";
                } else if (c4 == c2 && c0 == c1) {

                    return "三带二";
                } else if (c0 == c2 && c3 == c4) {

                    return "三带二";
                } else if (arr.get(0) >= 0 && arr.get(num - 1) < 47) {

                    for (int j = 0; j < arr.size() - 1; j++) {
                        if (arr.get(j + 1) / 4 - arr.get(j) == 1) {
                            continue;
                        } else {
                            //System.out.println("牌型有误,请重新出牌！");
                            return "false";
                        }

                    }
                    return "顺子";
                } else {
                    return "false";
                }

            } else {
                return "false";
            }

        } else if (num > 5) {   //顺子

            if (num == 6 || num == 8) {//四带二 四带两对
                int c3 = 0, c4 = 0, c2 = 0, c1 = 0, c0 = 0, c5 = 0, c6 = 0, c7 = 0;
                int model = 0;
                c0 = arr.get(0) / 4;
                c1 = arr.get(1) / 4;
                c2 = arr.get(2) / 4;
                c3 = arr.get(3) / 4;
                c4 = arr.get(4) / 4;
                c5 = arr.get(4) / 4;
                if (num == 6) {
                    if (c2 == c3 && c2 == c0 && (c4 + c5 != 26)) {
                        return "四带二";
                    } else if (c2 == c3 && c2 == c5) {
                        return "四带二";
                    } else if (c1 == c4) {
                        return "四带二";
                    }

                } else {
                    int boom = 0, bd = 0;
                    for (int j = 0; j < num - 1; j++) {
                        if (arr.get(j) / 4 == arr.get(j + 1) / 4) {
                            bd++;
                        }
                    }
                    for (int i = 0; i < num - 3; i++) {
                        if ((arr.get(i) / 4 == arr.get(i + 3) / 4)) {
                            boom++;
                        }
                    }
                    if ((bd - boom * 3) * 2 + boom * 4 == num) {
                        return "四带两对";
                    }
                }
            }
            if (arr.get(0) >=0 && arr.get(num - 1) < 47) {
                if (arr.get(0) / 4 == arr.get(1) / 4 - 1) {

                    for (int j = 0; j < arr.size() - 1; j++) {
                        if (arr.get(j + 1) / 4 - arr.get(j) / 4 != 1) {
                            return "false";
                        }
                    }
                    return "顺子";
                } else if (arr.get(1) / 4 == arr.get(2) / 4 - 1) {

                    for (int i = 0; i < arr.size() / 2 - 1; i++) {
                        int check = (arr.get(i + 2) / 4) - (arr.get(i + 1) / 4);
                        if (check == 1) {
                            return "连对";

                        } else {
                            return "false";
                        }
                    }
                }


            } else if (arr.get(0) + arr.get(2) > 96 && (arr.get(num - 1) + arr.get(num - 2)) != 105) {//2与大小王不参与做飞机
                int couple = 0, duizi = 0;
                for (int j = 0; j < num - 1; j++) {
                    if (arr.get(j) / 4 == arr.get(j + 1) / 4 - 1) {
                        duizi++;
                    }
                }
                for (int i = 0; i < num - 3; i++) {
                    if ((arr.get(i) / 4 == arr.get(i + 3) / 4 - 1) && (arr.get(i) / 4 == arr.get(i + 2) / 4)) {
                        couple++;
                    }
                }
                if (num == couple * 3) {
                    return "无带牌飞机";
                } else if (num == couple * 3 + couple) {
                    return "单带飞机";
                } else if (num == (duizi - couple * 2) * 2 + couple * 3) {
                    return "双带飞机";
                } else {
                    return "false";
                }
            }
            else {
                return "false";

             }


        //飞机



    }return "出牌完毕";
    }

    public static void checkCombo(TreeSet<Integer> tr,HashMap hm,String pai,Integer power){
        System.out.println("人机一手牌为：");
        for (int i:tr){
            System.out.print(hm.get(i)+" ");
        }
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer,Integer> booms=new HashMap<>();
        HashMap<Integer,Integer> duizi=new HashMap<>();
        HashMap<Integer,Integer> santiao=new HashMap<>();
        ArrayList<Integer> feiji=new ArrayList<>();
        ArrayList<Integer> shunzi=new ArrayList<>();
        TreeSet<Integer> t=new TreeSet<>();
        TreeSet<Integer> now=tr;
        ArrayList<Integer> re=new ArrayList<>();
        for (Integer i : tr) {
            arr.add(i);
        }
        Collections.sort(arr);


        for (int z=0;z< arr.size()-3;z++){
            if (arr.get(z)/4==arr.get(z+3)/4) {//炸弹
//                t.add(arr.get(i));
//                t.add(arr.get(i+1));
//                t.add(arr.get(z));
//                t.add(arr.get(z+1));
//                t.add(arr.get(z+2));
                re.add(arr.get(z));
                re.add(arr.get(z+1));
                re.add(arr.get(z+2));
                re.add(arr.get(z+3));
                int sum = arr.get(z) + arr.get(z + 1)+ arr.get(z + 2)+ arr.get(z + 3);
                booms.put(sum, arr.get(z));
//                System.out.println(rulesOfChupai(t));
//
//                t.clear();
            }
        }
        System.out.println("\ncheck over");
        System.out.println(re);
        System.out.println(arr.size()+"ge");
        arr.removeAll(re);
        System.out.println("4--------");
        for (int i:arr){
            System.out.println(i);
        }
        System.out.println("---------");
        System.out.println(arr.size()+"ge");
        re.clear();
        int fsum=0;
        for (int i=0;i< arr.size()-5;i++){//feiji
            if (arr.get(i)/4==arr.get(i+5)/4-1) {
//                t.add(arr.get(i));
//                t.add(arr.get(i+1));
//                t.add(arr.get(i+2));
                re.add(arr.get(i));
                re.add(arr.get(i+1));
                re.add(arr.get(i+2));
                re.add(arr.get(i+3));
                re.add(arr.get(i+4));
                re.add(arr.get(i+5));
                fsum = arr.get(i) + arr.get(i + 1)+ arr.get(i + 2)+arr.get(i+3)+arr.get(i+4)+arr.get(i+5);
                feiji.add(arr.get(i));
                feiji.add(arr.get(i+1));
                feiji.add(arr.get(i+2));
                feiji.add(arr.get(i+3));
                feiji.add(arr.get(i+4));
                feiji.add(arr.get(i+5));
//                System.out.println(rulesOfChupai(t));
//                t.clear();
            }
        }

        for (int i=0;i< arr.size()-2;i++){
            if (arr.get(i)/4==arr.get(i+2)/4) {//santiao
//                t.add(arr.get(i));
//                t.add(arr.get(i+1));
//                t.add(arr.get(i+2));
                re.add(arr.get(i));
                re.add(arr.get(i+1));
                re.add(arr.get(i+2));
                int sum = arr.get(i) + arr.get(i + 1)+ arr.get(i + 2);
                santiao.put(sum, arr.get(i));
//                System.out.println(rulesOfChupai(t));
//                t.clear();
            }
        }
        System.out.println("check over");
        System.out.println(re);
        arr.removeAll(re);
        System.out.println("3---------");
        for (int i:arr){

            System.out.println(i);
        }
        System.out.println("---------");
        System.out.println(arr.size()+"ge");
        re.clear();

        for (int ii=0;ii<arr.size()-1;ii++){//对子or王炸
            if (arr.get(ii)/4==arr.get(ii+1)/4){
//                t.add(arr.get(i));
//                t.add(arr.get(i+1));
//                t.add(arr.get(ii));
//                t.add(arr.get(ii+1));

                re.add(arr.get(ii));
                re.add(arr.get(ii+1));
                int sum=arr.get(ii)+arr.get(ii+1);
                duizi.put(sum,arr.get(ii));
//                System.out.println(rulesOfChupai(t));
//
//                t.clear();

            }
        }
        System.out.println("check over");
        //arr.removeAll(re);
        re.clear();

        for (int ii=0;ii<arr.size()-1;ii++){//5shunzi
            if (arr.get(ii)/4==arr.get(ii+1)/4+1){
//                t.add(arr.get(i));
//                t.add(arr.get(i+1));
//                t.add(arr.get(ii));
//                t.add(arr.get(ii+1));

                re.add(arr.get(ii));
                re.add(arr.get(ii+1));
                int sum=arr.get(ii)+arr.get(ii+1);
                shunzi.add( arr.get(ii));
//                System.out.println(rulesOfChupai(t));
//
//                t.clear();

            }
        }

        System.out.println("-----------");
        Set<Integer> boomkey = booms.keySet();
        Set<Integer> duizikey = duizi.keySet();
        Set<Integer> santiaokey = santiao.keySet();
        System.out.println("人机一手牌为：");
        for (int i:tr){
            System.out.print(hm.get(i)+" ");
        }
        System.out.println("\n");
        for (Integer j:boomkey){
            int b1=(j-6)/4;
            System.out.println("牌力: "+j+" : "+hm.get(b1)+hm.get(b1+1)+hm.get(b1+2)+hm.get(b1+3));
        }
        System.out.println("飞机牌力："+fsum);
        for (int i :feiji){
            System.out.print(hm.get(i));
        }
        System.out.println("\n");
        int san=0;
        for (Integer j:santiaokey){
            int b1=0;
            b1=santiao.get(j);
            if ((j-santiao.get(j))%4==0){
                //System.out.println("1");
                System.out.println("牌力: "+j+" : "+hm.get(b1)+hm.get(b1+1)+hm.get(b1+2));
                san=j;
            }
            else if ((j-santiao.get(j))%4==3){
                //System.out.println("2");
                san=j;
                System.out.println("牌力: "+j+" : "+hm.get(b1)+hm.get(b1+1)+hm.get(b1+2));
            }
            else if ((j-santiao.get(j))%4==1&&(j-2)%4!=0){
                //System.out.println("3");
                san=j;
                System.out.println("牌力: "+j+" : "+hm.get(b1)+hm.get(b1+2)+hm.get(b1+3));
            }
            else if ((j-2)%4==0){
                san=j;
                //System.out.println("4");
                System.out.println("牌力: "+j+" : "+hm.get(b1)+hm.get(b1+1)+hm.get(b1+2));
            }



        }
        for (Integer i:duizikey){//duizi
            Integer d1 = i-duizi.get(i);
            Integer d2= duizi.get(i);
            System.out.println("牌力: "+i+" : "+hm.get(d1)+hm.get(d2));
            }
        for (Integer i:shunzi){//顺子
            System.out.print("牌力: "+i+" : "+hm.get(i)+" ");
        }
        for (Integer i:arr){//单张
            System.out.println("牌力: "+i+" : "+hm.get(i));
        }
        if (pai=="三条"||pai=="三带一"){
            if (san>power){
                System.out.println("有大牌");
            }
        }


    }

        }



