package springboot04redis.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import springboot04redis.pojo.User;
import springboot04redis.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * @author: wuhui
 * @time: 2019/6/26 16:58
 * @desc:
 */
@RestController
public class MyController {

    @Autowired
    StringRedisTemplate template;

    @Autowired
    UserService service;

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Integer id){
        return JSON.toJSONString(service.findById(id));
    }

    @PostMapping("/login")
    public String try_login(String name, String password,HttpSession session){
        if (name!=null&&password!=null){
            session.setAttribute("user", name);
            template.opsForValue().set(session.getId(), JSON.toJSONString(session));
        }
        JSONObject jsonObject = null;
        String s = template.opsForValue().get(session.getId());
        if (s!=null){
            jsonObject=JSON.parseObject(s);
        }
        return jsonObject==null?"null":JSON.toJSONString(jsonObject);
    }
}
