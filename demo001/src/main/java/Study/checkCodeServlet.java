package Study;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "checkCodeServlet", value = "/checkCodeServlet")
public class checkCodeServlet extends HttpServlet {
    int width=100,height=50;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);//创建图片对象，加载对象到内存中

        //美化图片
        Graphics g=image.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0,0,width,height);

        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);

        //生成字符
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random ran=new Random();
        for (int i = 1; i <=4; i++) {
            int index = ran.nextInt(str.length());
            char c = str.charAt(index);
            g.drawString(String.valueOf(c),width/5*i,height/2);
        }
        //画干扰线
        g.setColor(Color.green);
        for (int i = 0; i < 20; i++) {
            g.drawLine(ran.nextInt(width), ran.nextInt(height),ran.nextInt(width), ran.nextInt(height));
        }


        ImageIO.write(image, "jpg",response.getOutputStream());//输出图片到页面

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
