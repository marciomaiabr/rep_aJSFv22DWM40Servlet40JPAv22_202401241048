package pkgs.exes.tsts;

public class ExeTst01 {

	public static void main(String[] args) {
		System.out.println("ExeTst01.main()");
		runAppMM();
	}

	private static void runAppMM() {
		System.out.println("ExeTst01.runAppMM()");
		ExeTst01 exeTst01 = new ExeTst01();
		exeTst01.startAppMM();
		System.out.println("[exeTst01=" + (exeTst01) + "]");
	}

	private void startAppMM() {
		System.out.println("ExeTst01.startAppMM()");
		mTst01();
	}

	private void mTst01() {
		System.out.println("ExeTst01.mTst01()");
	}

}
