package GUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Main extends JDialog {
	private JPanel contentPane;
	private JButton randomCanDuplicateButton;
	private JButton randomNotDuplicateButton;
	private JTextField textField2;
	private JTextField textField1;

	public Main() {
		setContentPane(contentPane);
		setModal(true);

		randomCanDuplicateButton.setEnabled(false);
		randomNotDuplicateButton.setEnabled(false);

		textField1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				warn();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				warn();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				warn();
			}
		});

		textField2.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				warn();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				warn();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				warn();
			}
		});

		randomCanDuplicateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RandomPage page = new RandomPage();
				page.run();
			}
		});

		randomNotDuplicateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RandomPage page = new RandomPage();
				page.run();
			}
		});
	}

	private void warn() {
		if (checkNumberIn(textField1.getText()) && checkNumberIn(textField2.getText())) {
			randomCanDuplicateButton.setEnabled(true);
			randomNotDuplicateButton.setEnabled(true);
		} else {
			randomCanDuplicateButton.setEnabled(false);
			randomNotDuplicateButton.setEnabled(false);
		}
	}

	private int randomWith(int first, int second) {
		int rand = (int) Math.ceil(Math.random() * second);
		while (rand < first) {
			rand = (int) Math.ceil(Math.random() * second);
		}
		return rand;
	}

	private double randomWith(double first, double second) {
		double rand = Math.random() * second;
		while (rand < first) {
			rand = Math.random() * second;
		}
		return rand;
	}

	private void randomNotSameWith(double number) {
		ArrayList<Double> listRandoms = new ArrayList<>();
	}

	private Boolean checkNumberIn(String input) {
		// if input is emply String
		if (input.length() == 0) return false;

		int[] numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		for (int i = 0; i < input.length(); i++) {
			char aChar = input.charAt(i);
			Boolean checkNumber = false;

			for (int j = 0; j < numbers.length; j++) {
				if (Character.getNumericValue(aChar) == numbers[j]) {
					checkNumber = true;
				}
			}
			if (!checkNumber) return false;
		}
		return true;
	}

	public void run() {
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		Main dialog = new Main();
		dialog.run();
		System.exit(0);
	}
}
