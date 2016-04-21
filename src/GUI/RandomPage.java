package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kamontat on 20/4/59.
 */
public class RandomPage extends JDialog {

	private JPanel contentPane;
	private JList list1;
	private JButton againButton;
	private JButton exitButton;

	public RandomPage() {
		setContentPane(contentPane);
		setModal(true);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}

	public void run() {
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		RandomPage page = new RandomPage();
		page.run();
		System.exit(0);
	}
}
