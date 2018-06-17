package com.roonv;

/**
 * @author nishanthd
 * @date 18-06-2018
 */
public class ConsoleProgressor {

	private static final int WIDTH = 50;
	private String ELLIPSIS = "=";

	public void showProgress(int percentage) {
		System.out.print("\r" + generateProgressString(percentage));
	}

	public String generateEllipsis(int limit) {
		limit = findActualLimit(limit);
		String result = "";
		if (limit > 0) {
			for (int i = 0; i < limit; i++) {
				result += ELLIPSIS;
			}
		}
		return result;
	}

	public String generateSpaces(int limit) {
		String result = "";
		if (limit > 0) {
			for (int i = limit; i < WIDTH; i++) {
				result += " ";
			}
		}
		return result;
	}

	private int findActualLimit(int limit) {
		return limit / 2;
	}

	public void setEllipsis(String string) {
		this.ELLIPSIS = string;
	}

	/**
	 * Considering 2 ellipsis per percentage , generates 50 ellipsis for 100%;
	 * 
	 * @param progress
	 * @return
	 */
	public String generateProgressString(int progress) {
		String progressString = "";
		String ellipsis = generateEllipsis(progress);
		if (!"".equals(ellipsis)) {
			progressString = String.format("[%s>%s]", ellipsis, generateSpaces(ellipsis.length()));
		}
		return progressString;
	}

	public static void main(String[] args) {
		int i = 1;

		ConsoleProgressor progress = new ConsoleProgressor();
		while (i <= 100) {
			progress.showProgress(i);
			i++;
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
