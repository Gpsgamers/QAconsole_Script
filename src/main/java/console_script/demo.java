package console_script;

import org.testng.Assert;

public class demo {

	public static void main(String[] args) {
		System.out.println(ext("1113.666daiuwhdi"));
	}
	
	public static float ext(String num) {
		if (num.contains(".")) {
			int index = num.indexOf(".");
			float total = Float.parseFloat(num.substring(0, index));
			String s = num.substring(++index);
			float decimal = 0.0f;
			int i = 0;
			while (true) {
					try {
						float f = Float.parseFloat(s.substring(i,++i));
						decimal = (decimal * 10) + f;
					} catch (Exception e) {
						decimal = (float) (decimal/Math.pow(10, --i));
						break;
					}
			}
			return total + decimal;
		}else {
			return Float.parseFloat(num); 
		}
	}
}
