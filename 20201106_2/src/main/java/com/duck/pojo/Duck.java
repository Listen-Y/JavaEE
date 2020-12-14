package com.duck.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-06
 * Time: 11:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Duck {

    private String id;
    private String name;
    private Timestamp birthday;
    private BigDecimal height;
    private BigDecimal weight;
    private BigDecimal food;
}
