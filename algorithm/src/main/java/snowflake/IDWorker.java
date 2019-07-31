package snowflake;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author mochenghui
 * @date 2019/7/3 15:43
 * 前缀+时间+机器码+随机数
 */
public class IDWorker {
    private static final int LOW_ORDER_THREE_BYTES = 0x0000fff;

    public static String nextID() {
        return "";
    }

    private static long getMachineCode() {
        return -1L;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }


    public static void main(String[] args) throws SocketException {
//        List<String> allMac = getAllMac();
//        StringBuilder sb = new StringBuilder();
//        allMac.forEach(mac -> {
//            sb.append(mac);
//            System.out.println(mac);
//            System.out.println(mac.hashCode() & LOW_ORDER_THREE_BYTES);
//        });
//        System.out.println(sb.hashCode() & LOW_ORDER_THREE_BYTES);
//        System.out.println(System.currentTimeMillis());
        System.out.println(SnowflakeIdWorker.generateId());//7887698971320320
    }

    //获取所有网卡的MAC地址       
    public static List<String> getAllMac() {
        List<String> list = new ArrayList<String>();
        try {
            Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();// 返回所有网络接口的一个枚举实例
            while (e.hasMoreElements()) {
                NetworkInterface network = e.nextElement();// 获得当前网络接口
                if (network != null) {
                    if (network.getHardwareAddress() != null) {
                        // 获得MAC地址
                        //结果是一个byte数组，每项是一个byte，我们需要通过parseByte方法转换成常见的十六进制表示
                        byte[] addres = network.getHardwareAddress();
                        StringBuffer sb = new StringBuffer();
                        if (addres != null && addres.length > 1) {
                            sb.append(parseByte(addres[0])).append(":").append(
                                    parseByte(addres[1])).append(":").append(
                                    parseByte(addres[2])).append(":").append(
                                    parseByte(addres[3])).append(":").append(
                                    parseByte(addres[4])).append(":").append(
                                    parseByte(addres[5]));
                            list.add(sb.toString());
                        }
                    }
                } else {
                    System.out.println("获取MAC地址发生异常");
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return list;
    }

    //格式化二进制
    private static String parseByte(byte b) {
        int intValue = 0;
        if (b >= 0) {
            intValue = b;
        } else {
            intValue = 256 + b;
        }
        return Integer.toHexString(intValue);
    }


}
