package com.kamontat.gui;

import com.kamontat.code.Random;

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

	public RandomPage(String text, double st, double nd) {
		setTitle(text);
		setContentPane(contentPane);
		setModal(true);

		random = new Random(st, nd);

		if (text.equals("Random(Can Duplicate)")) random.randomNotSame();
		else if (text.equals("Random(Can't Duplicate)")) random.randomNotSame();

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
				if (text.equals("Random(Can Duplicate)")) random.randomSame();
				else if (text.equals("Random(Can't Duplicate)")) random.randomNotSame();

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
