package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-15
 * Time: 12:48
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private String password;
}
