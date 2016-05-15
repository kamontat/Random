package com.kamontat.gui;

import com.kamontat.code.Random;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kamontat on 20/4/59.
 */
public class RandomPage extends JDialog {
	private JPanel contentPane;
	private JList<String> list;
	private JButton againButton;
	private JButton exitButton;
	private JLabel lastNumber;
	private JLabel count;
	private Random random;

	public RandomPage(String text, double st, double nd) {
		setTitle(text);
		setContentPane(contentPane);
		setModal(true);

		random = new Random(st, nd);

		if (text.equals("Random(Can Duplicate)")) random.randomNotSame();
		else if (text.equals("Random(Can't Duplicate)")) random.randomNotSame();

		updatePage();

		exitButton.addActionListener(e -> setVisible(false));

		againButton.addActionListener(e -> {
			if (text.equals("Random(Can Duplicate)")) random.randomSame();
			else if (text.equals("Random(Can't Duplicate)")) random.randomNotSame();
			updatePage();
			pack();
		});
	}

	public void run(Point point) {
		pack();
		setLocation(point);
		setVisible(true);
	}

	private void updatePage() {
		count.setText("(" + random.getHistoryList().length + ")");
		lastNumber.setText(String.valueOf(random.getRand()));
		list.setListData(random.getHistoryList());
	}
}
