//这是一个餐馆类
class Restaurant {

    //包含俩个属性
    private String restaurant_name;
    private String cuisine_type;

    //设置俩个属性
    public void init(String restaurant_name, String cuisine_type) {
        this.restaurant_name = restaurant_name;
        this.cuisine_type = cuisine_type;
    }

    //打印信息
    public void describe_restaurant() {
        System.out.println(this.restaurant_name + this.cuisine_type);
    }

    //打印正在营业
    public void open_restaurant() {
        System.out.println("正在营业");
    }
}

//测试类
public class RestaurantTest {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();
        restaurant.init("肯德基", "cook");
        restaurant.describe_restaurant();
        restaurant.open_restaurant();

        Restaurant restaurant1 = new Restaurant();
        restaurant1.init("麦当劳", "Deep fried");
        restaurant1.describe_restaurant();
        restaurant1.open_restaurant();

    }
}
