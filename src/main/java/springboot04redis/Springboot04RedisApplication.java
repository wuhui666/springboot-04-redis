package springboot04redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan(basePackages = "springboot04redis.mappers")
@SpringBootApplication
@EnableCaching
public class Springboot04RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04RedisApplication.class, args);
    }

}
