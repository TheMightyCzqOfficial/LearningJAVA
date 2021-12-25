package web.servlet.JSON;


import com.fasterxml.jackson.databind.ObjectMapper;
import domain.User;
import org.junit.Test;

import java.io.File;
import java.io.IOException;


public class test {
    @Test
    public  void test() throws IOException {
        User user=new User();
        user.setName("hbk");
        user.setSex("男");

        ObjectMapper mapper=new ObjectMapper();

        String s = mapper.writeValueAsString(user);
        System.out.println(s);

        mapper.writeValue(new File("C:\\Users\\CZQ\\Desktop\\hbkhs.txt"),user);
    }


}
