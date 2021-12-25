package service.impl;

import com.github.pagehelper.PageHelper;
import dao.StockInfoMapper;
import domain.Data;
import domain.StockInfo;
import org.springframework.stereotype.Service;
import service.StockInfoService;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("StockInfoService")
public class StockInfoServiceImpl implements StockInfoService {

    private StockInfoMapper stockInfoMapper;

    public void setStockInfoMapper(StockInfoMapper stockInfoMapper) {
        this.stockInfoMapper = stockInfoMapper;
    }

    @Override
    public List<StockInfo> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return stockInfoMapper.findAll();
    }

    @Override
    public List<Data> findByCode(String code) {
        return stockInfoMapper.findByCode(code);
    }

    @Override
    public StockInfo findInfoByCode(String code) {
        return stockInfoMapper.findInfoByCode(code);
    }

    @Override
    public String getDataByCode(String code, String start, String end) {
        System.out.println("开始执行python ");
        Process proc;
        try {
            String[] args1 = new String[] { "C:\\Users\\CZQ\\PycharmProjects\\PythonDemo\\venv\\Scripts\\python.exe",
                    "C:\\Users\\CZQ\\PycharmProjects\\PythonDemo\\7\\stockDemo1\\main.py",
                    code,start,end};//python.exe处为你系统中python的安装位置；python.py为想要执行的python文件位置；test为想要传的参数
            //proc = Runtime.getRuntime().exec("python.exe python.py ");// 执行py文件 不传参数
            proc=Runtime.getRuntime().exec(args1);
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), "GBK"));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
            System.out.println("添加完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "查询成功！";
    }

    @Override
    public void addStock(String code) {
        System.out.println("开始执行python ");
        Process proc;
        try {
            String[] args1 = new String[] { "C:\\Users\\CZQ\\PycharmProjects\\PythonDemo\\venv\\Scripts\\python.exe",
                    "C:\\Users\\CZQ\\PycharmProjects\\PythonDemo\\7\\stockDemo1\\addStock.py",
                    code};//python.exe处为你系统中python的安装位置；python.py为想要执行的python文件位置；test为想要传的参数
            //proc = Runtime.getRuntime().exec("python.exe python.py ");// 执行py文件 不传参数
            proc=Runtime.getRuntime().exec(args1);
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), "GBK"));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
            System.out.println("添加完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<StockInfo> searchStock(String info,int code,int page,int size) {
        PageHelper.startPage(page,size);
        HashMap<String,Object> map=new HashMap<>();
        if (info!=null){
            map.put("name",info);
        }else if (code!=0){
            map.put("code",code);
        }
        return stockInfoMapper.searchStock(map);
    }


}
