package springboot04redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springboot04redis.mappers.UserMapper;
import springboot04redis.pojo.User;

/**
 * @author: wuhui
 * @time: 2019/6/26 22:12
 * @desc:
 */
@Service
public class UserService {
    @Autowired
    UserMapper mapper;

    @Cacheable(value = "user",key = "#id")
    public User findById(int id){
        return mapper.selectByPrimaryKey(id);
    }
}
