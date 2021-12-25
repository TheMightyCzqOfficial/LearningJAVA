package controller;

import com.github.pagehelper.PageInfo;
import domain.Data;
import domain.StockInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.StockInfoService;

import java.util.List;


@Controller
public class stockInfoController {

    @Autowired
    @Qualifier("stockInfoServiceImpl")
    private StockInfoService service;
    private ModelAndView modelAndView=new ModelAndView();
    @RequestMapping("/stockList")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,
                                @RequestParam(name = "size",required = true,defaultValue = "10") int size){
        List<StockInfo> stockInfos = service.findAll(page,size);
        PageInfo pageInfo = new PageInfo(stockInfos);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("main");

        return modelAndView;
    }
    @RequestMapping("/stockData")
    public ModelAndView findByCode(String code){
        List<Data> data = service.findByCode(code);
        StockInfo info = service.findInfoByCode(code);
        modelAndView.addObject("data",data);
        modelAndView.addObject("info",info);
        modelAndView.setViewName("data");
        return modelAndView;
    }
    @RequestMapping("/login")
    public ModelAndView login(){
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/getData",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getData(String code,String start,String end){
        System.out.println(code+start+end);
        String substring = code.substring(0, 6);
//        System.out.println(substring);
        service.getDataByCode(substring,start,end);
        System.out.println("over!");
        return "更新成功!";
    }
    @RequestMapping(value = "/search",produces="text/html;charset=UTF-8")
    public ModelAndView search(String name,@RequestParam(name = "page",required = true,defaultValue = "1") int page,
                               @RequestParam(name = "size",required = true,defaultValue = "10") int size){
//        System.out.println(substring);
        int code=0;
        try {
            code=Integer.parseInt(name);
            name=null;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        List<StockInfo> list = service.searchStock(name,code,page,size);
        PageInfo pageInfo = new PageInfo(list);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("search");
        return modelAndView;
    }


    }

