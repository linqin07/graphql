package com.resolver;

import com.bean.ListCondition;
import com.bean.User;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @author: LinQin
 * @date: 2021/06/25
 */
@Slf4j
@Component
public class QueryResolver implements GraphQLQueryResolver {


    public List<User> users(ListCondition paramList) {
        User user1 = new User("1", "test", "linqin@163.com", new Date());
        ArrayList<User> userArrayList = Lists.newArrayList(user1);
        Gson gson = new Gson();
        return userArrayList;
    }

}
