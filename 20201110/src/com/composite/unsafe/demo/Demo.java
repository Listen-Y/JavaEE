package com.composite.unsafe.demo;

import com.composite.unsafe.model.Basics;
import com.composite.unsafe.model.Branches;
import com.composite.unsafe.model.Leaf;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-10
 * Time: 11:05
 */
public class Demo {

    public static void main(String[] args) {
        Basics sust = new Branches("陕科大");
        Basics sustTeach = new Branches("陕科大教务组");
        sust.add(sustTeach);
        Basics sust2 = new Branches("陕科大镐京学院");
        sust.add(sust2);
        sust.add(new Leaf("陕科大人力资源部"));
        sust.add(new Leaf("陕科大财务部"));

        sustTeach.add(new Leaf("陕科大教师组"));
        sustTeach.add(new Leaf("陕科大电智学院"));
        sustTeach.add(new Leaf("陕科大电气学院"));


        Basics sust2Teach = new Branches("陕科大镐京学院教务组");
        sust2Teach.add(new Leaf("陕科大镐京学院教师组"));
        sust2Teach.add(new Leaf("陕科大镐京学院电信学院"));
        sust2Teach.add(new Leaf("陕科大镐京学院设艺学院"));

        sust2.add(sust2Teach);
        sust2.add(new Leaf("陕科大镐京学院人力资源部"));
        sust2.add(new Leaf("陕科大镐京学院财务部"));

        //展示
        sust.displaySubordinate(1);

    }
}
