package com.composite.safe.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-10
 * Time: 10:53
 */
public class Branches extends Basics {

    private List<Basics> subordinate;


    public Branches(String name) {
        super(name);
        this.subordinate = new ArrayList<>();
    }

    @Override
    String getName() {
        return this.name;
    }

    public void add(Basics basics) {
        this.subordinate.add(basics);
    }

    public void remove(Basics basics) {
        this.subordinate.remove(basics);
    }

    public void displaySubordinate(int depth) {
        System.out.println("****" + this.name + "的下属部门:" + "****");
        for (Basics basics : subordinate
             ) {
            for (int i = 0; i < depth * 2; i++) {
                System.out.print("-");
            }
            System.out.println(basics.name);
        }
        System.out.println();

        //展示下属的下属
        for (Basics basics : subordinate
             ) {
            if (basics.getClass().getName().contains("Branches")) {
                Branches branches = (Branches) basics;
                branches.displaySubordinate(depth + 1);
            }
        }
    }
}
