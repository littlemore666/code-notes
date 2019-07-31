package design_pattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * @author mochenghui
 * @date 2019/7/26 11:34
 */
public class SingletonTest {

    public static void main(String[] args) throws Exception {
//        doublecheckTest();
//        enumTest();
//        serializationTestForEnum();
    serializationTestForDoubleCheck();
    }


    public static void doublecheckTest() throws Exception {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        //反射可创建对象
        Constructor<Singleton> declaredConstructor = Singleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton singleton = declaredConstructor.newInstance();

        System.out.println(instance == singleton);//false
        System.out.println(instance == instance1);//true
    }

    public static void enumTest() throws Exception {
        SingletonEnum instance = SingletonEnum.INSTANCE;
        SingletonEnum instance1 = SingletonEnum.INSTANCE;
        System.out.println(instance == instance1);//true
//        Constructor<SingletonEnum> declaredConstructor = SingletonEnum.class.getDeclaredConstructor();//nosuchmethod exception
        Constructor<SingletonEnum> declaredConstructor = SingletonEnum.class.getDeclaredConstructor(String.class, int.class);//父类构造器 illegalA..exception
        declaredConstructor.setAccessible(true);
        SingletonEnum singletonEnum = declaredConstructor.newInstance();
        System.out.println(singletonEnum == instance);
    }

    public static void serializationTestForEnum() throws Exception {
        SingletonEnum instance = SingletonEnum.INSTANCE;
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("EnumSingleton.obj"));
        oos.writeObject(instance);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("EnumSingleton.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        SingletonEnum s1 = (SingletonEnum)ois.readObject();
        ois.close();
        System.out.println(instance==s1);//true
    }

    public static void serializationTestForDoubleCheck() throws Exception {
        Singleton instance = Singleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DobbleCheckSingleton.obj"));
        oos.writeObject(instance);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("DobbleCheckSingleton.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Singleton s1 = (Singleton)ois.readObject();
        ois.close();
        System.out.println(instance==s1);//false
    }

}
