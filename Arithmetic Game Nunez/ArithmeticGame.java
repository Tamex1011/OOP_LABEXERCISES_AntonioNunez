import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class ArithmeticGame extends JFrame {

	private JLabel num1Label, num2Label, operatorLabel;
	private JTextField answerField;
	private JButton submitButton;
	private JLabel correctLabel, incorrectLabel;
	private JRadioButton addBtn, subBtn, mulBtn, divBtn, modBtn, mixBtn;
	private ButtonGroup opGroup;
	private final Random rand = new Random();
	private int currentAnswer = 0;
	private int correctCount = 0;
	private int incorrectCount = 0;

	public ArithmeticGame() {
		setTitle("Arithmetic Game - Practice Your Math Skills!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 350);
		setLayout(new BorderLayout(15, 15));
		setResizable(false);

		// Title Panel
		JPanel titlePanel = new JPanel(new BorderLayout());
		JLabel title = new JLabel("Arithmetic Game", SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 28));
		title.setForeground(new Color(0, 102, 204));
		titlePanel.add(title, BorderLayout.CENTER);
		add(titlePanel, BorderLayout.NORTH);

		// Question Panel
		JPanel questionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 25));
		questionPanel.setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createEtchedBorder(), "Question", 0, 0, 
			new Font("Arial", Font.BOLD, 14)));

		num1Label = new JLabel("0");
		num1Label.setFont(new Font("Arial", Font.BOLD, 32));
		num1Label.setForeground(new Color(51, 51, 51));
		
		operatorLabel = new JLabel("+");
		operatorLabel.setFont(new Font("Arial", Font.BOLD, 32));
		operatorLabel.setForeground(new Color(204, 0, 0));
		
		num2Label = new JLabel("0");
		num2Label.setFont(new Font("Arial", Font.BOLD, 32));
		num2Label.setForeground(new Color(51, 51, 51));

		JLabel equalsLabel = new JLabel("=");
		equalsLabel.setFont(new Font("Arial", Font.BOLD, 32));
		equalsLabel.setForeground(new Color(51, 51, 51));

		answerField = new JTextField(8);
		answerField.setFont(new Font("Arial", Font.PLAIN, 24));
		answerField.setHorizontalAlignment(JTextField.CENTER);
		answerField.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(new Color(100, 100, 100), 2),
			BorderFactory.createEmptyBorder(5, 10, 5, 10)));

		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Arial", Font.BOLD, 14));
		submitButton.setPreferredSize(new Dimension(100, 35));
		submitButton.setBackground(new Color(0, 153, 76));
		submitButton.setForeground(Color.BLACK);
		submitButton.setFocusPainted(false);
		submitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		questionPanel.add(num1Label);
		questionPanel.add(operatorLabel);
		questionPanel.add(num2Label);
		questionPanel.add(equalsLabel);
		questionPanel.add(answerField);
		questionPanel.add(submitButton);

		add(questionPanel, BorderLayout.CENTER);

		// Bottom Panel: Operation choices + Score + Reset
		JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));

		// Operations Panel
		JPanel opsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 12));
		opsPanel.setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createEtchedBorder(), "Select Operation", 0, 0,
			new Font("Arial", Font.BOLD, 13)));
		
		addBtn = new JRadioButton("Addition (+)");
		subBtn = new JRadioButton("Subtraction (-)");
		mulBtn = new JRadioButton("Multiplication (×)");
		divBtn = new JRadioButton("Division (÷)");
		modBtn = new JRadioButton("Modulo (%)");
		mixBtn = new JRadioButton("Mixed (All)");
		
		opGroup = new ButtonGroup();
		opGroup.add(addBtn);
		opGroup.add(subBtn);
		opGroup.add(mulBtn);
		opGroup.add(divBtn);
		opGroup.add(modBtn);
		opGroup.add(mixBtn);
		mixBtn.setSelected(true);
		
		opsPanel.add(addBtn);
		opsPanel.add(subBtn);
		opsPanel.add(mulBtn);
		opsPanel.add(divBtn);
		opsPanel.add(modBtn);
		opsPanel.add(mixBtn);
		
		bottomPanel.add(opsPanel, BorderLayout.CENTER);

		// Score Panel
		JPanel scorePanel = new JPanel(new GridLayout(2, 2, 8, 5));
		scorePanel.setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createEtchedBorder(), "Statistics", 0, 0,
			new Font("Arial", Font.BOLD, 13)));
		
		JLabel correctTextLabel = new JLabel("Correct:");
		correctTextLabel.setFont(new Font("Arial", Font.BOLD, 12));
		correctLabel = new JLabel("0");
		correctLabel.setFont(new Font("Arial", Font.BOLD, 14));
		correctLabel.setForeground(new Color(0, 153, 76));
		
		JLabel incorrectTextLabel = new JLabel("Incorrect:");
		incorrectTextLabel.setFont(new Font("Arial", Font.BOLD, 12));
		incorrectLabel = new JLabel("0");
		incorrectLabel.setFont(new Font("Arial", Font.BOLD, 14));
		incorrectLabel.setForeground(new Color(204, 0, 0));
		
		scorePanel.add(correctTextLabel);
		scorePanel.add(correctLabel);
		scorePanel.add(incorrectTextLabel);
		scorePanel.add(incorrectLabel);
		
		bottomPanel.add(scorePanel, BorderLayout.EAST);

		add(bottomPanel, BorderLayout.SOUTH);

		// Submit answer: show indicator and update score
		submitButton.addActionListener(e -> {
			String text = answerField.getText().trim();
			if (text.isEmpty()) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(this, "Please enter an answer!", 
					"Input Required", JOptionPane.WARNING_MESSAGE);
				return;
			}
			try {
				int user = Integer.parseInt(text);
				if (user == currentAnswer) {
					correctCount++;
					updateScore();
					JOptionPane.showMessageDialog(this, 
						"✓ Correct! Great job!", "Result", 
						JOptionPane.INFORMATION_MESSAGE);
				} else {
					incorrectCount++;
					updateScore();
					JOptionPane.showMessageDialog(this, 
						"✗ Wrong. The correct answer is: " + currentAnswer, 
						"Result", JOptionPane.WARNING_MESSAGE);
				}
				generateQuestion();
			} catch (NumberFormatException ex) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(this, 
					"Please enter a valid number!", "Invalid Input", 
					JOptionPane.ERROR_MESSAGE);
				answerField.setText("");
				answerField.requestFocusInWindow();
			}
		});
		
		answerField.addActionListener(_ -> submitButton.doClick());

		generateQuestion();
	}
	
	private void updateScore() {
		correctLabel.setText(String.valueOf(correctCount));
		incorrectLabel.setText(String.valueOf(incorrectCount));
	}

	private void generateQuestion() {
		int n1, n2;
		char op;
		String opSymbol;
		
		if (mixBtn != null && mixBtn.isSelected()) {
			char[] ops = new char[] {'+', '-', '*', '/', '%'};
			op = ops[rand.nextInt(ops.length)];
		} else if (addBtn != null && addBtn.isSelected()) {
			op = '+';
		} else if (subBtn != null && subBtn.isSelected()) {
			op = '-';
		} else if (mulBtn != null && mulBtn.isSelected()) {
			op = '*';
		} else if (divBtn != null && divBtn.isSelected()) {
			op = '/';
		} else if (modBtn != null && modBtn.isSelected()) {
			op = '%';
		} else {
			op = '+';
		}

		// Generate numbers based on operation
		switch (op) {
			case '+' -> {
				n1 = rand.nextInt(20) + 1;  // 1-20
				n2 = rand.nextInt(20) + 1;  // 1-20
				currentAnswer = n1 + n2;
				opSymbol = "+";
			}
			case '-' -> {
				n1 = rand.nextInt(20) + 10;  // 10-29
				n2 = rand.nextInt(n1) + 1;   // 1 to n1
				currentAnswer = n1 - n2;
				opSymbol = "-";
			}
			case '*' -> {
				n1 = rand.nextInt(12) + 1;  // 1-12
				n2 = rand.nextInt(12) + 1;  // 1-12
				currentAnswer = n1 * n2;
				opSymbol = "×";
			}
			case '/' -> {
				// Build divisible pair: ensure clean division
				n2 = rand.nextInt(12) + 1;  // 1-12 (divisor)
				int quotient = rand.nextInt(12) + 1;  // 1-12
				n1 = n2 * quotient;
				currentAnswer = quotient;
				opSymbol = "÷";
			}
			case '%' -> {
				// Modulo: n1 % n2
				n1 = rand.nextInt(50) + 10;  // 10-59
				n2 = rand.nextInt(12) + 2;   // 2-13 (avoid 0 and 1)
				currentAnswer = n1 % n2;
				opSymbol = "%";
			}
			default -> {
				n1 = rand.nextInt(20) + 1;
				n2 = rand.nextInt(20) + 1;
				currentAnswer = n1 + n2;
				opSymbol = "+";
			}
		}

		num1Label.setText(String.valueOf(n1));
		num2Label.setText(String.valueOf(n2));
		operatorLabel.setText(opSymbol);
		answerField.setText("");
		answerField.requestFocusInWindow();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | 
			         IllegalAccessException | UnsupportedLookAndFeelException e) {
				// Use default look and feel if system L&F fails
			}
			ArithmeticGame game = new ArithmeticGame();
			game.setLocationRelativeTo(null);
			game.setVisible(true);
		});
	}
}

