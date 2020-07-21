//这是一个动物类
class Animal {

    //俩个属性
    public String color;
    public String name;

    public Animal(String color, String name) {
        this.color = color;
        this.name = name;
    }

    //方法吃饭
    public void eat() {
        System.out.println( this.name + " 吃东西");
    }
}

interface Swimming {
    void swim();
}

interface Flying {
    void fly();
}

//这是一个鱼类
class Fish extends Animal implements Swimming {

    public Fish(String color, String name) {
        super(color, name);
    }

    //鱼可以游泳
    @Override
    public void swim() {
        System.out.println(this.name + " swimming");
    }

}

//这是一个鸟类
class Bird extends Animal implements Flying{


    public Bird(String color, String name) {
        super(color, name);
    }

    //鸟可以飞
    @Override
    public void fly() {
        System.out.println(this.name + " flying");
    }
}

//这是一个飞鸟类
class FlyBrid extends Animal implements Swimming, Flying {

    public FlyBrid(String color, String name) {
        super(color, name);
    }

    //飞鸟可以游泳
    @Override
    public void swim() {
        System.out.println(this.name + " swimming");
    }

    //飞鸟可以飞
    @Override
    public void fly() {
        System.out.println(this.name + " flying");
    }
}

//这是一个测试类
public class AnimalTest {

    public static void main(String[] args) {

        Animal animal = new Animal("red", "狗");
        animal.eat();

        Fish fish = new Fish("write", "鱼");
        fish.eat();
        fish.swim();

        Bird bird = new Bird("blue", "鸟");
        bird.eat();
        bird.fly();

        FlyBrid flyBrid = new FlyBrid("black", "飞鸟");
        flyBrid.eat();
        flyBrid.swim();
        flyBrid.fly();
    }
}
