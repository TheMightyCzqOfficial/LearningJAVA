import domain.StockInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StockInfoService;

import java.util.List;

public class test {
    @Test
    public void findAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StockInfoService service = (StockInfoService) context.getBean("stockInfoServiceImpl");



    }
}
