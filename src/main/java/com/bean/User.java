package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description:
 * @author: LinQin
 * @date: 2021/06/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String nickname;
    private String mail;
    private Date dateTime;

}

