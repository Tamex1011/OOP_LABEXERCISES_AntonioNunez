import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ArithmeticGame extends JFrame {

	private JLabel num1Label, num2Label, operatorLabel;
	private JTextField answerField;
	private JButton submitButton, nextButton;
	private JLabel correctLabel, incorrectLabel;
	private JRadioButton addBtn, subBtn, mulBtn, divBtn, mixBtn;
	private ButtonGroup opGroup;
	private final Random rand = new Random();
	private int currentAnswer = 0; // TODO: use for checking answers later
	private int correctCount = 0;
	private int incorrectCount = 0;

	public ArithmeticGame() {
		setTitle("Arithmetic Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 250);
		setLayout(new BorderLayout(10, 10));

		JLabel title = new JLabel("Arithmetic Game", SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 22));
		add(title, BorderLayout.NORTH);

		JPanel questionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));

		num1Label = new JLabel("0");
		num1Label.setFont(new Font("Arial", Font.BOLD, 26));
		operatorLabel = new JLabel("+");
		operatorLabel.setFont(new Font("Arial", Font.BOLD, 26));
		num2Label = new JLabel("0");
		num2Label.setFont(new Font("Arial", Font.BOLD, 26));

		JLabel equalsLabel = new JLabel("=");
		equalsLabel.setFont(new Font("Arial", Font.BOLD, 26));

		answerField = new JTextField(6);
		answerField.setFont(new Font("Arial", Font.PLAIN, 20));

		submitButton = new JButton("Submit");
		nextButton = new JButton("Next");

		questionPanel.add(num1Label);
		questionPanel.add(operatorLabel);
		questionPanel.add(num2Label);
		questionPanel.add(equalsLabel);
		questionPanel.add(answerField);
		questionPanel.add(submitButton);
		questionPanel.add(nextButton);

		add(questionPanel, BorderLayout.CENTER);

		// ---- Bottom: Operation choices + Score (bottom-right) ----
		JPanel bottomPanel = new JPanel(new BorderLayout());

		JPanel opsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
		opsPanel.setBorder(BorderFactory.createTitledBorder("Operation"));
		addBtn = new JRadioButton("Addition");
		subBtn = new JRadioButton("Subtraction");
		mulBtn = new JRadioButton("Multiplication");
		divBtn = new JRadioButton("Division");
		mixBtn = new JRadioButton("Mixed");
		opGroup = new ButtonGroup();
		opGroup.add(addBtn);
		opGroup.add(subBtn);
		opGroup.add(mulBtn);
		opGroup.add(divBtn);
		opGroup.add(mixBtn);
		mixBtn.setSelected(true);
		opsPanel.add(addBtn);
		opsPanel.add(subBtn);
		opsPanel.add(mulBtn);
		opsPanel.add(divBtn);
		opsPanel.add(mixBtn);
		bottomPanel.add(opsPanel, BorderLayout.CENTER);

		JPanel scorePanel = new JPanel(new GridLayout(2, 2, 5, 5));
		scorePanel.setBorder(BorderFactory.createTitledBorder("Score"));
		scorePanel.add(new JLabel("Correct:"));
		correctLabel = new JLabel("0");
		scorePanel.add(correctLabel);
		scorePanel.add(new JLabel("Incorrect:"));
		incorrectLabel = new JLabel("0");
		scorePanel.add(incorrectLabel);
		bottomPanel.add(scorePanel, BorderLayout.EAST);

		add(bottomPanel, BorderLayout.SOUTH);

		// Submit answer: show indicator and update score
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = answerField.getText().trim();
				if (text.isEmpty()) {
					Toolkit.getDefaultToolkit().beep();
					return;
				}
				try {
					int user = Integer.parseInt(text);
					if (user == currentAnswer) {
						correctCount++;
						correctLabel.setText(String.valueOf(correctCount));
						JOptionPane.showMessageDialog(ArithmeticGame.this, "Correct!", "Result", JOptionPane.INFORMATION_MESSAGE);
					} else {
						incorrectCount++;
						incorrectLabel.setText(String.valueOf(incorrectCount));
						JOptionPane.showMessageDialog(ArithmeticGame.this, "Wrong. Answer: " + currentAnswer, "Result", JOptionPane.WARNING_MESSAGE);
					}
					generateQuestion();
				} catch (NumberFormatException ex) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		answerField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { submitButton.doClick(); }
		});
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { generateQuestion(); }
		});

		generateQuestion();
	}

	private void generateQuestion() {
		int n1, n2;
		char op;
		if (mixBtn != null && mixBtn.isSelected()) {
			char[] ops = new char[] {'+', '-', '*', '/'};
			op = ops[rand.nextInt(ops.length)];
		} else if (addBtn != null && addBtn.isSelected()) {
			op = '+';
		} else if (subBtn != null && subBtn.isSelected()) {
			op = '-';
		} else if (mulBtn != null && mulBtn.isSelected()) {
			op = '*';
		} else if (divBtn != null && divBtn.isSelected()) {
			op = '/';
		} else {
			op = '+';
		}

		// Base range 1..10 for simplicity
		switch (op) {
			case '+':
				n1 = rand.nextInt(10) + 1;
				n2 = rand.nextInt(10) + 1;
				currentAnswer = n1 + n2;
				break;
			case '-':
				n1 = rand.nextInt(10) + 1;
				n2 = rand.nextInt(10) + 1;
				if (n2 > n1) { int t = n1; n1 = n2; n2 = t; }
				currentAnswer = n1 - n2;
				break;
			case '*':
				n1 = rand.nextInt(10) + 1;
				n2 = rand.nextInt(10) + 1;
				currentAnswer = n1 * n2;
				break;
			case '/':
				// Build divisible pair within 1..10
				n2 = rand.nextInt(9) + 1; // 1..9 (avoid zero)
				int quotient = rand.nextInt(10) + 1; // 1..10
				n1 = n2 * quotient;
				currentAnswer = quotient;
				break;
			default:
				n1 = rand.nextInt(10) + 1;
				n2 = rand.nextInt(10) + 1;
				currentAnswer = n1 + n2;
		}

		num1Label.setText(String.valueOf(n1));
		num2Label.setText(String.valueOf(n2));
		operatorLabel.setText(String.valueOf(op));
		answerField.setText("");
		answerField.requestFocusInWindow();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ArithmeticGame ui = new ArithmeticGame();
				ui.setLocationRelativeTo(null);
				ui.setVisible(true);
			}
		});
	}
}

