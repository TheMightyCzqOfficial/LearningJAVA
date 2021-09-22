package first;

import java.util.Scanner;

public class 用户登录 {
    public static void main(String[] args) {
        String user, pwd, y;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名 以回车结束");
            user = sc.nextLine();
            System.out.println("请输入密码 以回车结束");
            pwd = sc.nextLine();
            if (user.equals("czq") && pwd.equals("123456")) {
                System.out.println("登录成功");
                break;
            } else {
                System.out.println("用户名密码有误,请重新输入 剩余 " + (2 - i) + "次机会");
                count++;
            }
        }
        if (count == 3) {
            System.out.println("用户名密码次数超过上限！");
        } else {
            System.out.println("欢迎！");
        }

        System.out.println("是否退出？ 退出请输入 Y");
        do {
            y = sc.nextLine();
        } while (!y.equals("Y"));
        System.out.println("退出成功！");
        System.exit(0);



    }
}
