package GUI;

import Code.Random;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kamontat on 20/4/59.
 */
public class RandomPage extends JDialog {

	private JPanel contentPane;
	private JList<String> list1;
	private JButton againButton;
	private JButton exitButton;
	private Random random;

	public RandomPage(double st, double nd) {
		setContentPane(contentPane);
		setModal(true);

		random = new Random(st, nd);
		random.randomNotSame();
		updateJList();

		list1.setAutoscrolls(true);

		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		againButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				random.randomNotSame();
				updateJList();
			}
		});
	}

	public void run() {
		pack();
		setVisible(true);
	}

	private void updateJList() {
		list1.setListData(random.getHistoryList());
	}
}
