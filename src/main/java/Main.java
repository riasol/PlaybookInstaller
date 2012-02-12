import java.awt.EventQueue;

import eu.riasol.pi.app.PlaybookInstaller;


public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlaybookInstaller frame = new PlaybookInstaller();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
