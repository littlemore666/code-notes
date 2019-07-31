package design_pattern;

import java.io.Serializable;

/**
 * 双重检验实现懒汉单例
 * 该种方式不能防御反射攻击，序列化和反序列化也会创建多个对象
 * @author mochenghui
 * @date 2019/7/26 11:19
 */
public class Singleton implements Serializable {

    private volatile static Singleton instance;//必须加volatile修饰，这样可以进制指令重排序，防止出现地址赋值出现在对象初始化之前

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private Singleton() {
    }

    /**
     * double check
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
