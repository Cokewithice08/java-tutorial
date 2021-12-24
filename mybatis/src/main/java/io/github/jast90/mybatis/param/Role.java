package io.github.jast90.mybatis.param;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/12/20 14:58
 */
public class Role {
    private Long id;
    private String name;
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
