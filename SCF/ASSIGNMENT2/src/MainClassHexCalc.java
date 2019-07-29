
public class MainClassHexCalc {
	public static void main(String args[]) {
		try {
			HexCalc ob = new HexCalc();
			System.out.println(ob.convertToDecimal("7De", 16));
			System.out.println(ob.convertToDecimal("201G", 16));
			System.out.println(ob.convertFromDecimal(2014, 16));
			// 1E is 30 and 35 is 53
			String aString = "1E", bString = "35";
			System.out.println("addition:" + ob.add(aString, bString));
			System.out.println("substraction:" + ob.subtract(aString, bString));
			System.out.println("multiplication:" + ob.multiply(aString, bString));

			System.out.println("division:" + ob.divide(bString, aString));
			System.out.println("equal" + ob.equalTo(aString, bString));
			System.out.println("greater:" + ob.greaterThan(aString, bString));
			System.out.println("less:" + ob.LessThan(aString, bString));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
