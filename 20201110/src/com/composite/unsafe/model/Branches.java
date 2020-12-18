package com.composite.unsafe.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-10
 * Time: 10:53
 */
public class Branches extends Basics{

    private List<Basics> subordinate;


    public Branches(String name) {
        super(name);
        this.subordinate = new ArrayList<>();
    }

    @Override
    String getName() {
        return this.name;
    }

    @Override
    public void add(Basics basics) {
        this.subordinate.add(basics);
    }

    @Override
    public void remove(Basics basics) {
        this.subordinate.remove(basics);
    }

    @Override
    public void displaySubordinate(int depth) {
        System.out.println("***" + this.name + "的下属部门:" + "***");
        for (Basics basics : subordinate) {
            for (int i = 0; i < depth * 2; i++) {
                System.out.print("-");
            }
            System.out.println(basics.name);
        }
        System.out.println();

        for (Basics basics : subordinate
             ) {
            //下属再去展示他的下属
            try {
                basics.displaySubordinate(depth + 1);
            } catch (UnsupportedOperationException ignored) {
                //如果下属是一个叶子部门就忽略异常不进行展示
            }
        }
    }
}
