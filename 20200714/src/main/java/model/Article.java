package model;

public class Article {

    private int id;
    private String title;
    private String data;
    private int userId;

    public Article(int id, String title, String data, int userId) {
        this.id = id;
        this.title = title;
        this.data = data;
        this.userId = userId;
    }

    public Article() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", data='" + data + '\'' +
                ", userId=" + userId +
                '}';
    }
}
