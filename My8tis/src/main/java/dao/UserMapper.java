package My8tis.src.main.java.com.stock.dao;

import My8tis.src.main.java.domin.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    public List<User> findAll() throws IOException;
}
