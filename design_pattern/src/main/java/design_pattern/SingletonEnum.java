package design_pattern;

import java.io.Serializable;

/**
 * 枚举实现单列，是单例的最佳实现
 * 可以避免反射攻击，序列化和反序列化页不会创建多个对象
 */
public enum SingletonEnum implements Serializable {

    INSTANCE;

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SingletonEnum getInstance(){
        return INSTANCE;
    }

}
