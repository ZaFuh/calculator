import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalculatorFrame extends JFrame implements ActionListener{
	
	JPanel buttonsPanel = new JPanel();
	JPanel bottomPanel;
	JTextField textField;
	JButton[] numbers = new JButton[10] ;
	JButton[] functions;
	JButton addButton, subButton, divButton, multButton, equButton, delButton, clrButton, decButton, negButton;
	
	double num1=0, num2=0, result=0;
	char operator;

	CalculatorFrame(){
		this.setTitle("Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(20, 25, 250, 50);
		textField.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		divButton = new JButton("/");
		multButton= new JButton("*");
		equButton = new JButton("="); 
		delButton = new JButton("del");
		decButton = new JButton(".");
		clrButton = new JButton("clr");
		negButton = new JButton("n");
		
		functions = new JButton[] {addButton, subButton, divButton, multButton, equButton, decButton, delButton, clrButton, negButton} ;
		
		
		for(int i = 0; i<functions.length; i++) {
			functions[i].addActionListener(this);
			functions[i].setFocusable(false);
			
		}
		
		for(int i = 0; i<10; i++) {
			numbers[i] = new JButton(String.valueOf(i));
			numbers[i].addActionListener(this);
			numbers[i].setFocusable(false);
		}
		
		buttonsPanel.setLayout(new GridLayout(4,4, 10, 10));
		buttonsPanel.setBounds(18,100,250,200);
		
		buttonsPanel.add(numbers[1]);
		buttonsPanel.add(numbers[2]);
		buttonsPanel.add(numbers[3]);
		buttonsPanel.add(addButton);
		buttonsPanel.add(numbers[4]);
		buttonsPanel.add(numbers[5]);
		buttonsPanel.add(numbers[6]);
		buttonsPanel.add(subButton);
		buttonsPanel.add(numbers[7]);
		buttonsPanel.add(numbers[8]);
		buttonsPanel.add(numbers[9]);
		buttonsPanel.add(multButton);
		buttonsPanel.add(decButton);
		buttonsPanel.add(numbers[0]);
		buttonsPanel.add(equButton);
		buttonsPanel.add(divButton);
	
		negButton.setBounds(45, 320, 60, 30);
		delButton.setBounds(112, 320,60, 30);
		clrButton.setBounds(180,320,60, 30);
		
		this.add(negButton);
		this.add(delButton);
		this.add(clrButton);
		this.add(buttonsPanel);
		this.add(textField);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<10; i++) {
			if(e.getSource() == numbers[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton) {
			textField.setText(textField.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		if(e.getSource() == multButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textField.getText());
			
			switch(operator) {
		
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
				}
			textField.setText(String.valueOf(result));
			num1 = result;
			}
		if(e.getSource() == negButton) {
			Double temp = Double.parseDouble(textField.getText());
			temp*=-1;
			textField.setText(String.valueOf(temp));
					}
		
		if(e.getSource() == clrButton) {
			textField.setText("");	
			}
		if(e.getSource()== delButton) {
		String string = textField.getText();
		textField.setText("");
		for(int i = 0; i<(string.length())-1; i++ ) {
			textField.setText(textField.getText()+string.charAt(i));
		}
		}
		
		
	}
	
}
