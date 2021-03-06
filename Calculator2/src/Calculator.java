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

public class Calculator {

	protected Shell shell;
	private Text numberInput;

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
		shell.setSize(844, 460);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		numberInput = new Text(shell, SWT.BORDER);
		numberInput.setBounds(12, 13, 798, 47);
		
		Button degreesCircle = new Button(shell, SWT.RADIO);
		degreesCircle.setBounds(12, 73, 87, 43);
		degreesCircle.setText("Degrees");
		
		Button radiansCircle = new Button(shell, SWT.RADIO);
		radiansCircle.setBounds(157, 71, 78, 47);
		radiansCircle.setText("Radians");
		
		Button gradsCircle = new Button(shell, SWT.RADIO);
		gradsCircle.setBounds(306, 75, 78, 39);
		gradsCircle.setText("Grads");
		
		Button memoryMinus = new Button(shell, SWT.NONE);
		memoryMinus.setBounds(741, 73, 69, 43);
		memoryMinus.setText("M-");
		
		Button memoryPlus = new Button(shell, SWT.NONE);
		memoryPlus.setBounds(660, 73, 69, 43);
		memoryPlus.setText("M+");
		
		Button memoryRecall = new Button(shell, SWT.NONE);
		memoryRecall.setBounds(498, 73, 69, 43);
		memoryRecall.setText("MR");
		
		Button memoryClear = new Button(shell, SWT.NONE);
		memoryClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		memoryClear.setBounds(417, 73, 69, 43);
		memoryClear.setText("MC");
		
		Button memoryStore = new Button(shell, SWT.NONE);
		memoryStore.setBounds(579, 73, 69, 43);
		memoryStore.setText("MS");
		
		Button secondRoot = new Button(shell, SWT.NONE);
		secondRoot.setBounds(741, 129, 69, 43);
		secondRoot.setText("\u221A");
		
		Button plusMinus = new Button(shell, SWT.NONE);
		plusMinus.setBounds(660, 129, 69, 43);
		plusMinus.setText("\u00B1");
		
		Button clear = new Button(shell, SWT.NONE);
		clear.setBounds(579, 129, 69, 43);
		clear.setText("C");
		
		Button backspace = new Button(shell, SWT.NONE);
		backspace.setBounds(417, 129, 69, 43);
		backspace.setText("\u2190 ");
		
		Button clearEntry = new Button(shell, SWT.NONE);
		clearEntry.setBounds(498, 129, 69, 43);
		clearEntry.setText("CE");
		
		Button rightPar = new Button(shell, SWT.NONE);
		rightPar.setBounds(336, 128, 69, 43);
		rightPar.setText(")");
		
		Button leftPar = new Button(shell, SWT.NONE);
		leftPar.setBounds(255, 128, 69, 43);
		leftPar.setText("(");
		
		Button eTwo = new Button(shell, SWT.NONE);
		eTwo.setBounds(174, 129, 69, 43);
		eTwo.setText("e\u00B2");
		
		Button eOne = new Button(shell, SWT.NONE);
		eOne.setBounds(93, 129, 69, 43);
		eOne.setText("e");
		
		Button naturalLog = new Button(shell, SWT.NONE);
		naturalLog.setBounds(12, 129, 69, 43);
		naturalLog.setText("ln");
		
		Button Int = new Button(shell, SWT.NONE);
		Int.setBounds(12, 185, 69, 43);
		Int.setText("Int");
		
		Button sine = new Button(shell, SWT.NONE);
		sine.setBounds(93, 185, 69, 43);
		sine.setText("sine");
		
		Button sineInverse = new Button(shell, SWT.NONE);
		sineInverse.setBounds(174, 186, 69, 43);
		sineInverse.setText("sin\u207B\u00B9");
		
		Button xSecond = new Button(shell, SWT.NONE);
		xSecond.setBounds(255, 186, 69, 43);
		xSecond.setText("\u00D7\u00B2");
		
		Button xFactorial = new Button(shell, SWT.NONE);
		xFactorial.setBounds(336, 185, 69, 43);
		xFactorial.setText("x!");
		
		Button seven = new Button(shell, SWT.NONE);
		seven.setBounds(417, 185, 69, 43);
		seven.setText("7");
		
		Button eight = new Button(shell, SWT.NONE);
		eight.setBounds(498, 185, 69, 43);
		eight.setText("8");
		
		Button nine = new Button(shell, SWT.NONE);
		nine.setBounds(579, 185, 69, 43);
		nine.setText("9");
		
		Button backSlash = new Button(shell, SWT.NONE);
		backSlash.setBounds(660, 185, 69, 43);
		backSlash.setText("/");
		
		Button percent = new Button(shell, SWT.NONE);
		percent.setBounds(741, 185, 69, 43);
		percent.setText("%");
		
		Button binary = new Button(shell, SWT.NONE);
		binary.setBounds(12, 241, 69, 43);
		binary.setText("Bin");
		
		Button cosine = new Button(shell, SWT.NONE);
		cosine.setBounds(93, 241, 69, 43);
		cosine.setText("cos");
		
		Button cosineInverse = new Button(shell, SWT.NONE);
		cosineInverse.setBounds(174, 241, 69, 43);
		cosineInverse.setText("cos\u207B\u00B9");
		
		Button xThird = new Button(shell, SWT.NONE);
		xThird.setBounds(255, 241, 69, 43);
		xThird.setText("\u00D7\u00B3");
		
		Button thirdRoot = new Button(shell, SWT.NONE);
		thirdRoot.setBounds(336, 241, 69, 43);
		thirdRoot.setText("\u221B");
		
		Button fourthRoot = new Button(shell, SWT.NONE);
		fourthRoot.setBounds(336, 297, 69, 43);
		fourthRoot.setText("\u221C");
		
		Button xFourth = new Button(shell, SWT.NONE);
		xFourth.setBounds(255, 297, 69, 43);
		xFourth.setText("x\u2074");
		
		Button four = new Button(shell, SWT.NONE);
		four.setBounds(417, 241, 69, 43);
		four.setText("4");
		
		Button five = new Button(shell, SWT.NONE);
		five.setBounds(498, 241, 69, 43);
		five.setText("5");
		
		Button six = new Button(shell, SWT.NONE);
		six.setBounds(579, 241, 69, 43);
		six.setText("6");
		
		Button one = new Button(shell, SWT.NONE);
		one.setBounds(417, 297, 69, 43);
		one.setText("1");
		
		Button two = new Button(shell, SWT.NONE);
		two.setBounds(498, 297, 69, 43);
		two.setText("2");
		
		Button three = new Button(shell, SWT.NONE);
		three.setBounds(579, 297, 69, 43);
		three.setText("3");
		
		Button multiply = new Button(shell, SWT.NONE);
		multiply.setBounds(660, 241, 69, 43);
		multiply.setText("*");
		
		Button oneOverX = new Button(shell, SWT.NONE);
		oneOverX.setBounds(741, 241, 69, 43);
		oneOverX.setText("1/x");
		
		Button minus = new Button(shell, SWT.NONE);
		minus.setBounds(660, 297, 69, 43);
		minus.setText("-");
		
		Button plus = new Button(shell, SWT.NONE);
		plus.setBounds(660, 353, 69, 43);
		plus.setText("+");
		
		Button decimalPoint = new Button(shell, SWT.NONE);
		decimalPoint.setBounds(579, 353, 69, 43);
		decimalPoint.setText(".");
		
		Button equals = new Button(shell, SWT.NONE);
		equals.setBounds(741, 297, 69, 99);
		equals.setText("=");
		
		Button dms = new Button(shell, SWT.NONE);
		dms.setBounds(12, 297, 69, 43);
		dms.setText("dms");
		
		Button pi = new Button(shell, SWT.NONE);
		pi.setBounds(12, 353, 69, 43);
		pi.setText("\u03C0");
		
		Button tangentInverse = new Button(shell, SWT.NONE);
		tangentInverse.setBounds(174, 297, 69, 43);
		tangentInverse.setText("tan\u207B\u00B9");
		
		Button tangent = new Button(shell, SWT.NONE);
		tangent.setBounds(93, 297, 69, 43);
		tangent.setText("tan");
		
		Button tau = new Button(shell, SWT.NONE);
		tau.setBounds(93, 353, 69, 43);
		tau.setText("\u03C4");
		
		Button mod = new Button(shell, SWT.NONE);
		mod.setBounds(174, 353, 69, 43);
		mod.setText("Mod");
		
		Button log = new Button(shell, SWT.NONE);
		log.setBounds(255, 353, 69, 43);
		log.setText("log");
		
		Button tenToTheX = new Button(shell, SWT.NONE);
		tenToTheX.setBounds(336, 353, 69, 43);
		tenToTheX.setText("10^x");
		
		Button zero = new Button(shell, SWT.NONE);
		zero.setBounds(417, 353, 150, 43);
		zero.setText("0");
		

	}
}
