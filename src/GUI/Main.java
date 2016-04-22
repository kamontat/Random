package GUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
				runRandomPage();
			}
		});

		randomNotDuplicateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				runRandomPage();
			}
		});
	}

	public void run() {
		pack();
		setVisible(true);
	}

	private void warn() {
		if (isAllNumberIn(textField1.getText()) && isAllNumberIn(textField2.getText())) {
			if (Double.parseDouble(textField1.getText()) <= Double.parseDouble(textField2.getText())) {
				randomCanDuplicateButton.setEnabled(true);
				randomNotDuplicateButton.setEnabled(true);
			} else {
				randomCanDuplicateButton.setEnabled(false);
				randomNotDuplicateButton.setEnabled(false);
			}
		} else {
			randomCanDuplicateButton.setEnabled(false);
			randomNotDuplicateButton.setEnabled(false);
		}
	}

	private void runRandomPage() {
		RandomPage page = new RandomPage(Double.parseDouble(textField1.getText()), Double.parseDouble(textField2.getText()));
		page.run();
	}

	private Boolean isAllNumberIn(String input) {
		// if input is emply String
		if (input.length() == 0) return false;
		Boolean checkDot = false;
		Character[] except = new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'};
		// check every char in input String
		for (int i = 0; i < input.length(); i++) {
			char aChar = input.charAt(i);
			Boolean checkNumber = false;
			if (aChar == '.' && !checkDot) checkDot = true;
			else if (aChar == '.') return false;
			for (Character exceptChar : except) {
				if (aChar == exceptChar) {
					checkNumber = true;
				}
			}
			// if have alphabel at least 1 program will return false
			if (!checkNumber) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Main dialog = new Main();
		dialog.run();
		System.exit(0);
	}
}
