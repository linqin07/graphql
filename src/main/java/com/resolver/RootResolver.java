package com.resolver;

import com.bean.ListCondition;
import com.bean.User;
import com.bean.UserCondition;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @author: LinQin
 * @date: 2021/06/24
 */
@Slf4j
@Validated
@Component
public class RootResolver implements GraphQLQueryResolver {

    public User user(String nickname, @NonNull Long id, Date dateTime) {
        log.info("nicename:{}, id:{}, data:{}", nickname, id, dateTime);
        User user = new User("1", "test", "linqin@163.com", new Date());
        return user;
    }



    public List<User> userList(List<UserCondition> paramList) {
        User user1 = new User("1", "test", "linqin@163.com", new Date());
        ArrayList<User> userArrayList = Lists.newArrayList(user1);
        Gson gson = new Gson();
        return userArrayList;
    }


}
