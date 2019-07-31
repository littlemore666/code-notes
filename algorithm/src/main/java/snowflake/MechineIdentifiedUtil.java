package snowflake;

import java.net.NetworkInterface;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 占卜项目中运用到的多机器环境下生成唯一id的方案
 * (时间戳（13）+机器码（[1,4]）+随机数（[5,8]）) 保持长度为22位
 *
 */
public class MechineIdentifiedUtil {
	private static final int LOW_ORDER_THREE_BYTES = 0x0000fff;

	private static final AtomicInteger NEXT_COUNTER = new AtomicInteger(new SecureRandom().nextInt(9999));

	/**
	 * 生成机器码
	 * 只能保证生成的机器码长度[1,4]
	 * 
	 * @return
	 */
	public static int createMachineIdentifier() {
		// build a 2-byte machine piece based on NICs info
		int machinePiece = 0;
		try {
			StringBuilder sb = new StringBuilder();
			Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
			while (e.hasMoreElements()) {
				NetworkInterface ni = e.nextElement();
				sb.append(ni.toString());
				byte[] mac = ni.getHardwareAddress();
				if (mac != null) {
					ByteBuffer bb = ByteBuffer.wrap(mac);
					try {
						sb.append(bb.getChar());
						sb.append(bb.getChar());
						sb.append(bb.getChar());
					} catch (BufferUnderflowException shortHardwareAddressException) { // NOPMD
						// mac with less than 6 bytes. continue
					}
				}
			}
			machinePiece = sb.toString().hashCode();
		} catch (Throwable t) {
			machinePiece = new SecureRandom().nextInt();
		}

		//取低12bit
		machinePiece = machinePiece & LOW_ORDER_THREE_BYTES;
		return machinePiece;
	}

	/**
	 * 创建随机数
	 * 
	 * @param strlength
	 * @return
	 */
	public static String createRadomIdentifier(int strlength) {
		int radomIdentify = NEXT_COUNTER.getAndIncrement();
		String identifyStr = String.valueOf(radomIdentify);
		int lack = strlength - identifyStr.length();
		lack = lack < 0 ? 0 : lack;
		for (int i = 0; i < lack; i++) {
			identifyStr = "0" + identifyStr;
		}
		return identifyStr;
	}

}
