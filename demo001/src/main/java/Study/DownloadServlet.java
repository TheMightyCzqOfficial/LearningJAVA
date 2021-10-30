package Study;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "DownloadServlet", value = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        ServletContext servletContext = this.getServletContext();//找到文件服务器路径
        String realPath = servletContext.getRealPath("/downloadFile/" + fileName);

        FileInputStream fis=new FileInputStream(realPath);//创建字节流
        String mimeType = servletContext.getMimeType(fileName);//获取文件的MIME类型
        response.setHeader("content-type",mimeType);//设置响应头类型
        response.setHeader("content-disposition","attachment;filename="+fileName);//设置响应头打开方式
        ServletOutputStream sos=response.getOutputStream();

        byte[] buff=new byte[1024*8];//设置缓冲区
        int len=0;
        while((len=fis.read(buff))!=-1){//判断缓冲区是否读到最后一个字节
            sos.write(buff,0,len);

        }
        fis.close();




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
