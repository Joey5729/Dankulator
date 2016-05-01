import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class Calculator {
	private int count = 0, change = 0;
	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Calculator window = new Calculator();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(844, 543);
		shell.setText("Scientific Calculator");
		shell.setLayout(null);
		
		Label numberInput = new Label(shell, SWT.NONE);
		numberInput.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		numberInput.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		numberInput.setAlignment(SWT.RIGHT);
		numberInput.setBounds(12, 83, 798, 47);
		
		Label layOver = new Label(shell, SWT.NONE);
		layOver.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		layOver.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		layOver.setAlignment(SWT.RIGHT);
		layOver.setBounds(12, 36, 798, 47);
		
		Label memoryStatus = new Label(shell, SWT.NONE);
		memoryStatus.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		memoryStatus.setAlignment(SWT.CENTER);
		memoryStatus.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		memoryStatus.setBounds(12, 104, 43, 26);
		
		Button degreesCircle = new Button(shell, SWT.RADIO);
		degreesCircle.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				change = 1;
			}
		});
		degreesCircle.setBounds(141, 163, 87, 43);
		degreesCircle.setText("Degrees");
		
		Button radiansCircle = new Button(shell, SWT.RADIO);
		radiansCircle.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				change = 0;
			}
		});
		radiansCircle.setBounds(23, 161, 78, 47);
		radiansCircle.setText("Radians");
		radiansCircle.setSelection(true);
		
		Button memorySubtract = new Button(shell, SWT.NONE);
		memorySubtract.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				memoryStatus.setText("M");
				CalculatorFunctions.memorySubtract(Double.parseDouble(numberInput.getText()));
			}
		});
		memorySubtract.setBounds(741, 163, 69, 43);
		memorySubtract.setText("M-");
		
		Button memoryAdd = new Button(shell, SWT.NONE);
		memoryAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				memoryStatus.setText("M");
				CalculatorFunctions.memoryAdd(Double.parseDouble(numberInput.getText()));
			}
		});
		memoryAdd.setBounds(660, 163, 69, 43);
		memoryAdd.setText("M+");
		
		Button memoryRecall = new Button(shell, SWT.NONE);
		memoryRecall.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.getMemory()));
			}
		});
		memoryRecall.setBounds(498, 163, 69, 43);
		memoryRecall.setText("MR");
		
		Button memoryClear = new Button(shell, SWT.NONE);
		memoryClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CalculatorFunctions.setMemory(0);
			}
		});
		memoryClear.setBounds(417, 163, 69, 43);
		memoryClear.setText("MC");
		
		Button memoryStore = new Button(shell, SWT.NONE);
		memoryStore.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.getMemory()));
			}
		});
		memoryStore.setBounds(579, 163, 69, 43);
		memoryStore.setText("MS");
		
		Button secondRoot = new Button(shell, SWT.NONE);
		secondRoot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.secondRoot(Double.parseDouble(numberInput.getText()))));
			}
		});
		secondRoot.setBounds(741, 219, 69, 43);
		secondRoot.setText("\u221A");
		
		Button plusMinus = new Button(shell, SWT.NONE);
		plusMinus.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.plusMinus(Double.parseDouble(numberInput.getText()))));
			}
		});
		plusMinus.setBounds(660, 219, 69, 43);
		plusMinus.setText("\u00B1");
		
		Button clear = new Button(shell, SWT.NONE);
		clear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CalculatorFunctions.setOperation("");
				layOver.setText("");
				numberInput.setText("");
			}
		});
		clear.setBounds(579, 219, 69, 43);
		clear.setText("C");
		
		Button backspace = new Button(shell, SWT.NONE);
		backspace.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(numberInput.getText().substring(0,numberInput.getText().length()-1));
			}
		});
		backspace.setBounds(417, 219, 69, 43);
		backspace.setText("\u2190 ");
		
		Button clearEntry = new Button(shell, SWT.NONE);
		clearEntry.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText("");
			}
		});
		clearEntry.setBounds(498, 219, 69, 43);
		clearEntry.setText("CE");
		
		Button eFour = new Button(shell, SWT.NONE);
		eFour.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.ePower(4)));
			}
		});
		eFour.setBounds(336, 218, 69, 43);
		eFour.setText("e\u2074");
		
		Button eThree = new Button(shell, SWT.NONE);
		eThree.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.ePower(3)));
			}
		});
		eThree.setBounds(255, 218, 69, 43);
		eThree.setText("e\u00B3");
		
		Button eTwo = new Button(shell, SWT.NONE);
		eTwo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.ePower(2)));
			}
		});
		eTwo.setBounds(174, 219, 69, 43);
		eTwo.setText("e\u00B2");
		
		Button eOne = new Button(shell, SWT.NONE);
		eOne.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.ePower(1)));
			}
		});
		eOne.setBounds(93, 219, 69, 43);
		eOne.setText("e");
		
		Button naturalLog = new Button(shell, SWT.NONE);
		naturalLog.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.naturalLog(Double.parseDouble(numberInput.getText()))));
			}
		});
		naturalLog.setBounds(12, 219, 69, 43);
		naturalLog.setText("ln");
		
		Button binary = new Button(shell, SWT.NONE);
		binary.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(CalculatorFunctions.binary(Integer.parseInt(numberInput.getText())));
			}
		});
		binary.setBounds(12, 275, 69, 43);
		binary.setText("Bin");
		
		Button sine = new Button(shell, SWT.NONE);
		sine.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(change == 1)
					numberInput.setText(String.valueOf(CalculatorFunctions.sine(Double.parseDouble(numberInput.getText()),1)));
				else
					numberInput.setText(String.valueOf(CalculatorFunctions.sine(Double.parseDouble(numberInput.getText()),0)));
			}
		});
		sine.setBounds(93, 275, 69, 43);
		sine.setText("sin");
		
		Button sineInverse = new Button(shell, SWT.NONE);
		sineInverse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(change == 1)
					numberInput.setText(String.valueOf(CalculatorFunctions.sineInverse(Double.parseDouble(numberInput.getText()),1)));
				else
					numberInput.setText(String.valueOf(CalculatorFunctions.sineInverse(Double.parseDouble(numberInput.getText()),0)));
			}
		});
		sineInverse.setBounds(174, 276, 69, 43);
		sineInverse.setText("sin\u207B\u00B9");
		
		Button xSecond = new Button(shell, SWT.NONE);
		xSecond.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.xPower(Double.parseDouble(numberInput.getText()),2)));
			}
		});
		xSecond.setBounds(255, 276, 69, 43);
		xSecond.setText("\u00D7\u00B2");
		
		Button xFactorial = new Button(shell, SWT.NONE);
		xFactorial.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.xFactorial(Double.parseDouble(numberInput.getText()))));
			}
		});
		xFactorial.setBounds(336, 275, 69, 43);
		xFactorial.setText("x!");
		
		Button seven = new Button(shell, SWT.NONE);
		seven.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(numberInput.getText() + "7");
			}
		});
		seven.setBounds(417, 275, 69, 43);
		seven.setText("7");
		
		Button eight = new Button(shell, SWT.NONE);
		eight.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(numberInput.getText() + "8");
			}
		});
		eight.setBounds(498, 275, 69, 43);
		eight.setText("8");
		
		Button nine = new Button(shell, SWT.NONE);
		nine.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(numberInput.getText() + "9");
			}
		});
		nine.setBounds(579, 275, 69, 43);
		nine.setText("9");
		
		Button divide = new Button(shell, SWT.NONE);
		divide.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CalculatorFunctions.setOperation("divide");
				layOver.setText(numberInput.getText() + "/");
				numberInput.setText("");
			}
		});
		divide.setBounds(660, 275, 69, 43);
		divide.setText("/");
		
		Button percent = new Button(shell, SWT.NONE);
		percent.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CalculatorFunctions.setOperation("percent");
				layOver.setText(numberInput.getText() + "%");
				numberInput.setText("");
			}
		});
		percent.setBounds(741, 275, 69, 43);
		percent.setText("%");
		
		Button hexadecimal = new Button(shell, SWT.NONE);
		hexadecimal.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(CalculatorFunctions.hexadecimal(Integer.parseInt(numberInput.getText())));
			}
		});
		hexadecimal.setBounds(12, 331, 69, 43);
		hexadecimal.setText("Hex");
		
		Button cosine = new Button(shell, SWT.NONE);
		cosine.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(change == 1)
					numberInput.setText(String.valueOf(CalculatorFunctions.cosine(Double.parseDouble(numberInput.getText()),1)));
				else
					numberInput.setText(String.valueOf(CalculatorFunctions.cosine(Double.parseDouble(numberInput.getText()),0)));
			}
		});
		cosine.setBounds(93, 331, 69, 43);
		cosine.setText("cos");
		
		Button cosineInverse = new Button(shell, SWT.NONE);
		cosineInverse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(change == 1)
					numberInput.setText(String.valueOf(CalculatorFunctions.cosineInverse(Double.parseDouble(numberInput.getText()),1)));
				else
					numberInput.setText(String.valueOf(CalculatorFunctions.cosineInverse(Double.parseDouble(numberInput.getText()),0)));
			}
		});
		cosineInverse.setBounds(174, 331, 69, 43);
		cosineInverse.setText("cos\u207B\u00B9");
		
		Button xThird = new Button(shell, SWT.NONE);
		xThird.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.xPower(Double.parseDouble(numberInput.getText()),3)));
			}
		});
		xThird.setBounds(255, 331, 69, 43);
		xThird.setText("\u00D7\u00B3");
		
		Button thirdRoot = new Button(shell, SWT.NONE);
		thirdRoot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.thirdRoot(Double.parseDouble(numberInput.getText()))));
			}
		});
		thirdRoot.setBounds(336, 331, 69, 43);
		thirdRoot.setText("\u221B");
		
		Button random = new Button(shell, SWT.NONE);
		random.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.random()));
			}
		});
		random.setBounds(336, 387, 69, 43);
		random.setText("rand");
		
		Button xFourth = new Button(shell, SWT.NONE);
		xFourth.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.xPower(Double.parseDouble(numberInput.getText()),4)));
			}
		});
		xFourth.setBounds(255, 387, 69, 43);
		xFourth.setText("x\u2074");
		
		Button four = new Button(shell, SWT.NONE);
		four.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(numberInput.getText() + "4");
			}
		});
		four.setBounds(417, 331, 69, 43);
		four.setText("4");
		
		Button five = new Button(shell, SWT.NONE);
		five.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(numberInput.getText() + "5");
			}
		});
		five.setBounds(498, 331, 69, 43);
		five.setText("5");
		
		Button six = new Button(shell, SWT.NONE);
		six.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(numberInput.getText() + "6");
			}
		});
		six.setBounds(579, 331, 69, 43);
		six.setText("6");
		
		Button one = new Button(shell, SWT.NONE);
		one.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(numberInput.getText() + "1");
			}
		});
		one.setBounds(417, 387, 69, 43);
		one.setText("1");
		
		Button two = new Button(shell, SWT.NONE);
		two.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(numberInput.getText() + "2");
			}
		});
		two.setBounds(498, 387, 69, 43);
		two.setText("2");
		
		Button three = new Button(shell, SWT.NONE);
		three.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(numberInput.getText() + "3");
			}
		});
		three.setBounds(579, 387, 69, 43);
		three.setText("3");
		
		Button multiply = new Button(shell, SWT.NONE);
		multiply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CalculatorFunctions.setOperation("times");
				layOver.setText(numberInput.getText() + "*");
				numberInput.setText("");
			}
		});
		multiply.setBounds(660, 331, 69, 43);
		multiply.setText("*");
		
		Button oneOverX = new Button(shell, SWT.NONE);
		oneOverX.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.oneOverX(Double.parseDouble(numberInput.getText()))));
			}
		});
		oneOverX.setBounds(741, 331, 69, 43);
		oneOverX.setText("1/x");
		
		Button subtract = new Button(shell, SWT.NONE);
		subtract.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CalculatorFunctions.setOperation("minus");
				layOver.setText(numberInput.getText() + "-");
				numberInput.setText("");
			}
		});
		subtract.setBounds(660, 387, 69, 43);
		subtract.setText("-");
		
		Button add = new Button(shell, SWT.NONE);
		add.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CalculatorFunctions.setOperation("plus");
				layOver.setText(numberInput.getText() + "+");
				numberInput.setText("");
			}
		});
		add.setBounds(660, 443, 69, 43);
		add.setText("+");
		
		Button decimalPoint = new Button(shell, SWT.NONE);
		decimalPoint.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(numberInput.getText()+".");
			}
		});
		decimalPoint.setBounds(579, 443, 69, 43);
		decimalPoint.setText(".");
		
		Button equals = new Button(shell, SWT.NONE);
		equals.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				double result = 0;
				if(count == 1)
					result = CalculatorFunctions.computation(layOver.getText().substring(0,layOver.getText().length()-3),numberInput.getText());
				else
					result = CalculatorFunctions.computation(layOver.getText().substring(0,layOver.getText().length()-1),numberInput.getText());
				
				CalculatorFunctions.setOperation("");
				layOver.setText("");
				numberInput.setText(String.valueOf(result));
				count = 0;
				
			}
		});
		equals.setBounds(741, 387, 69, 99);
		equals.setText("=");
		
		Button octal = new Button(shell, SWT.NONE);
		octal.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(CalculatorFunctions.octal(Integer.parseInt(numberInput.getText())));
			}
		});
		octal.setBounds(12, 387, 69, 43);
		octal.setText("Oct");
		
		Button pi = new Button(shell, SWT.NONE);
		pi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.pi()));
			}
		});
		pi.setBounds(12, 443, 69, 43);
		pi.setText("\u03C0");
		
		Button tangentInverse = new Button(shell, SWT.NONE);
		tangentInverse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(change == 1)
					numberInput.setText(String.valueOf(CalculatorFunctions.tangentInverse(Double.parseDouble(numberInput.getText()),1)));
				else
					numberInput.setText(String.valueOf(CalculatorFunctions.tangentInverse(Double.parseDouble(numberInput.getText()),0)));
			}
		});
		tangentInverse.setBounds(174, 387, 69, 43);
		tangentInverse.setText("tan\u207B\u00B9");
		
		Button tangent = new Button(shell, SWT.NONE);
		tangent.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(change == 1)
					numberInput.setText(String.valueOf(CalculatorFunctions.tangent(Double.parseDouble(numberInput.getText()),1)));
				else
					numberInput.setText(String.valueOf(CalculatorFunctions.tangent(Double.parseDouble(numberInput.getText()),0)));
			}
		});
		tangent.setBounds(93, 387, 69, 43);
		tangent.setText("tan");
		
		Button tau = new Button(shell, SWT.NONE);
		tau.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.tau()));
			}
		});
		tau.setBounds(93, 443, 69, 43);
		tau.setText("\u03C4");
		
		Button modulus = new Button(shell, SWT.NONE);
		modulus.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				count = 1;
				CalculatorFunctions.setOperation("modulus");
				layOver.setText(numberInput.getText() + "mod");
				numberInput.setText("");
			}
		});
		modulus.setBounds(174, 443, 69, 43);
		modulus.setText("Mod");
		
		Button log = new Button(shell, SWT.NONE);
		log.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.log(Double.parseDouble(numberInput.getText()))));
			}
		});
		log.setBounds(255, 443, 69, 43);
		log.setText("log");
		
		Button tenToTheX = new Button(shell, SWT.NONE);
		tenToTheX.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(String.valueOf(CalculatorFunctions.tenToTheX(Double.parseDouble(numberInput.getText()))));
			}
		});
		tenToTheX.setBounds(336, 443, 69, 43);
		tenToTheX.setText("10^x");
		
		Button zero = new Button(shell, SWT.NONE);
		zero.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				numberInput.setText(numberInput.getText() + "0");
			}
		});
		zero.setBounds(417, 443, 150, 43);
		zero.setText("0");
	}
}
