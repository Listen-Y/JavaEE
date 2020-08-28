package Model;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-31
 * Time: 18:21
 */
public class Mv {

    private int id;
    private String message;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Mv{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
