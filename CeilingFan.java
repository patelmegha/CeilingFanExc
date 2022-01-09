import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * 
 * @author Megha Patel
 *
 */

class CeilingFan {

	private static int currentSpeedSetting;
	private static DIRECTION currentDirectionSetting;

	public static enum DIRECTION {
		CLOCK_WISE("clock wise"), ANTI_CLOCK_WISE("Anti clock wise");

		public String label;

		private DIRECTION(String label) {
			this.label = label;
		}
	};

	public CeilingFan() {
		currentSpeedSetting = 0;
		currentDirectionSetting = DIRECTION.CLOCK_WISE;
	}

	public static void main(String args[]) throws IOException {
		CeilingFan ceilingFan = new CeilingFan();
		System.out.println("Current Direction of a fan is " + currentDirectionSetting.label + " with speed "
				+ currentSpeedSetting);
		// This will read value entered by user from console and call pullCords() accordingly
		while (true) {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String settingChain = in.readLine();
			if (settingChain.equals("speed")) {
				ceilingFan.pullCords(true);
			} else if (settingChain.equals("direction")) {
				ceilingFan.pullCords(false);
			} else {
				System.out.println("invalid input");
			}
		}
	}

	/**
	 * This method contains logic about managing speed and direction of a ceiling fan
	 * 
	 * @param isSpeedCordPulled
	 */
	private void pullCords(boolean isSpeedCordPulled) {
		// if speed cord pulled it will increase speed by 1
		if (isSpeedCordPulled) {
			currentSpeedSetting = currentSpeedSetting == 3 ?  0 : ++currentSpeedSetting;
			System.out.println("Current Direction of a fan is " + currentDirectionSetting.label + " with speed "
					+ currentSpeedSetting);
		} 
		// if direction cord pulled. It reverses the direction of a Fan
		else {
			currentDirectionSetting = currentDirectionSetting.equals(DIRECTION.CLOCK_WISE) ? DIRECTION.ANTI_CLOCK_WISE : DIRECTION.CLOCK_WISE;
				System.out.println("Current Direction of a fan is " + currentDirectionSetting.label + " with speed "
						+ currentSpeedSetting);
			
		}
	}
}
