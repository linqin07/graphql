package com.resolver;

import com.bean.User;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description:
 * @author: LinQin
 * @date: 2021/06/25
 */
@Slf4j
@Component
public class MutationResolver implements GraphQLMutationResolver {
    public User create(String id, String mail, String nickname) {
        log.info("id:{}, mail:{}, nickname:{}", id, mail, nickname);
        // do something
        return  new User("111", "tes2t", "22ddt@163.com", new Date());

    }
}
