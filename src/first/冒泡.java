package first;

public class 冒泡 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        int[] arr = {90, 30, 50, 80, 10, 70,600,50};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                System.out.println("第"+i+"次比较"+" "+arr[i]+" 与 "+arr[j]);
                System.out.println(arr.length+" "+i);
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                System.out.println("第"+i+"次比较结束"+" "+arr[i]+" 与 "+arr[j]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            sb.append(arr[i]+" ");
        }
        System.out.println(sb);

    }
}
