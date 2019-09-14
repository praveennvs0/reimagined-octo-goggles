public class RotateStringDemo {
	public static void main(String args[]) {
		String test = "abcdefg";
		String rotated = "defgabc";
		boolean isRotated = isRotated(test, rotated);
		System.out.printf("Is '%s' is rotation of '%s' : %b %n", rotated, test, isRotated);
	}

	
	/**
	 * * Return true if rotated is rotation of input String * * @param input
	 * * @param rotated * @return true if one String is rotation of other
	 */
	public static boolean isRotated(String input, String rotated) {
		if (input == null || rotated == null) {
			return false;
		} else if (input.length() != rotated.length()) {
			return false;
		}
		int index = rotated.indexOf(input.charAt(0));
		if (index > -1) {
			if (input.equalsIgnoreCase(rotated)) {
				return true;
			}
			int finalPos = rotated.length() - index;
			return rotated.charAt(0) == input.charAt(finalPos)
					&& input.substring(finalPos).equals(rotated.substring(0, index));
		}
		return false;
	}
}
