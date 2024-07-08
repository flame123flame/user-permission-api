package structure.java22.api.core.utils;

public class TimeUtil {

	public static void setTimeoutSync(Runnable runnable, int delay) {
		try {
			Thread.sleep(delay);
			runnable.run();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
