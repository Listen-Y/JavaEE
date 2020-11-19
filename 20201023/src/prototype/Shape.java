package prototype;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-22
 * Time: 22:58
 */
public abstract class Shape implements Cloneable {

    private int Id;
    protected String type;

    public abstract void draw();

    public int getId() {
        return Id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object clone = null;
        clone = super.clone();
        return clone;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "Id=" + Id +
                ", type='" + type + '\'' +
                '}';
    }
}
