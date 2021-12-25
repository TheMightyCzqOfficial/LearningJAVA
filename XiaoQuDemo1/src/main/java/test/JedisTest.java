package test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {
    @Test
    public void test(){
        Jedis jedis=new Jedis("localhost",6379);
        jedis.set("username","hbk");
        String username = jedis.get("username");
        System.out.println(username);
        jedis.close();
    }
}
