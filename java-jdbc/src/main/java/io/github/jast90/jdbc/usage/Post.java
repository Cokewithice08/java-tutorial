package io.github.jast90.jdbc.usage;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/12/9 15:07
 */
public class Post {
    private int id;
    private String title;
    private String decs;

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

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", decs='" + decs + '\'' +
                '}';
    }
}
