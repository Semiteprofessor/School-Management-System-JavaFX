

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Bursary;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;


/**
 * FXML Controller class
 *
 * @author tybobobo
 */
public class calculatorController implements Initializable
{
	@FXML
	TextArea textOutput;

	// Stores values
	private ArrayList values = new ArrayList();

	// Reset
	private boolean reset = true;

	// Operator state
	private boolean hasOperator = false;
	@FXML
	private Font FONT;
	@FXML
	private Button back;
	@FXML
	private Button percent;
	@FXML
	private Button divided;
	@FXML
	private Button seven;
	@FXML
	private Button eight;
	@FXML
	private Button nine;
	@FXML
	private Button times;
	@FXML
	private Button four;
	@FXML
	private Button five;
	@FXML
	private Button six;
	@FXML
	private Button minus;
	@FXML
	private Button one;
	@FXML
	private Button two;
	@FXML
	private Button three;
	@FXML
	private Button plus;
	@FXML
	private Button comma;
	@FXML
	private Button equals;
	@FXML
	private Button zero;
	@FXML
	private Button buttonDelete;
	@FXML
	private Button change;
	private TextArea display;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		// Nothing here.
	}

	// On key press
	@FXML
	private void onKeyReleased(KeyEvent event)
	{
		switch(event.getCode())
		{
			// Calculate
			case ENTER:
				finalCalculation();
				break;
			case DIGIT0:
			case NUMPAD0:
				pressKey("0");
				break;
			case DIGIT1:
			case NUMPAD1:
				pressKey("1");
				break;
			case DIGIT2:
			case NUMPAD2:
				pressKey("2");
				break;
			case DIGIT3:
			case NUMPAD3:
				pressKey("3");
				break;
			case DIGIT4:
			case NUMPAD4:
				pressKey("4");
				break;
			case DIGIT5:
			case NUMPAD5:
				pressKey("5");
				break;
			case DIGIT6:
			case NUMPAD6:
				pressKey("6");
				break;
			case DIGIT7:
			case NUMPAD7:
				pressKey("7");
				break;
			case DIGIT8:
			case NUMPAD8:
				pressKey("8");
				break;
			case DIGIT9:
			case NUMPAD9:
				pressKey("9");
				break;
			case PLUS:
			case ADD:
				pressOperator("+");
				break;
			case MINUS:
			case SUBTRACT:
				pressOperator("-");
				break;
			case MULTIPLY:
				pressOperator("x");
				break;
			case DIVIDE:
				pressOperator("÷");
				break;
			default:
				break;
		}
	}


	// When Numberic buttons have been pressed
	@FXML
	private void keypadAction(ActionEvent event)
	{
		// Get Button text
		Button button = (Button)event.getSource();
		String buttonText = button.getText();

		pressKey(buttonText);

	}


	// When operators have been pressed
	@FXML
	private void operatorAction(ActionEvent event)
	{
		// Get Button
		Button button = (Button)event.getSource();

		// Get Text
		String operatorText = button.getText();

		// Press operator
		pressOperator(operatorText);

	}


	// Press operator
	private void pressOperator(String operator)
	{
		// If we did not press equal; Add operator to operator variable
		if(!"=".equals(operator))
		{
			// If an operator has previously been assigned, ignore key press
			if(values.size() == 0 || isOperator(values.get(values.size()-1).toString()) )
			{
				return;
			}

			// Store operator in values
			values.add(operator);

			hasOperator = true;

			// Display in output
			addToOutput(operator);
		}
		// Calculate and display result to output
		else
		{
			finalCalculation();
		}
	}


	// Press Key
	private void pressKey(String key)
	{
		// If we are resetting, clear everything
		if(reset)
		{
			textOutput.setText("");
			values.clear();
			reset = false;
			hasOperator = false;
		}

		// Store value
		values.add(key);

		// Draw to output
		addToOutput(key);
	}


	// Do the final calculations
	private void finalCalculation()
	{
		// Variables for computational tasks during this part alone
		double result = 0;
		String stringOperator = "";
		String stringValue1 = "";
		String stringValue2 = "";

		try
		{
			// If an operator has previously been assigned, ignore key press
			if(values.size() == 0 || isOperator(values.get(values.size()-1).toString()) || !hasOperator)
			{
				return;
			}


			// Calculate the total value
			for(Iterator<String> i = values.iterator(); i.hasNext();)
			{
				// Get text
				String item = i.next();

				// If it is an operator
				if(isOperator(item))
				{
					// Calculate previous values and add to value1 - then set latest operator
					if(!"".equals(stringOperator))
					{
						// Calculate previously stored
						result = calculate(Double.parseDouble(stringValue1), Double.parseDouble(stringValue2), stringOperator);
						stringValue1 = result + ""; // Add calculated value as first result
						stringValue2 = "";
					}
					stringOperator = item;
				}
				else
				{
					// If no operator has previously been assigned, just append values to first value
					if("".equals(stringOperator))
					{
						// Append values on eachother
						stringValue1 = stringValue1 + item;
					}
					else
					{
						// Operator have been assigned, which means we already have a value1 - add to string value 2 instead
						stringValue2 = stringValue2 + item;
					}
				}

				// If this is our last loop, calculate total and add into result
				if(!i.hasNext())
				{
					result = calculate(Double.parseDouble(stringValue1), Double.parseDouble(stringValue2), stringOperator);
				}
			}

			// Output results
			textOutput.setText(result + "");

			// Clear stored values
			values.clear();

			// Reset
			reset = true;
			hasOperator = false;

		}
		catch(Exception ex)
		{
			// Output results
			textOutput.setText(0 + "");

			// Clear stored values
			values.clear();

			// Reset
			reset = true;
			hasOperator = false;
		}
	}



	private String actualText;


	public void handleClick(Event event){
		actualText = display.getText();
		if (display.getText().equals("0") || display.getText() == "0"){
			buttonDelete.setText("C");
			display.setText("");
			System.out.println("actualText: "+actualText);
			actualText = "";
		}
		Button btn = (Button) event.getSource();
		switch(btn.getId()) {
			case "zero" :
				display.appendText("0");
				break;
			case "one" :
				display.appendText("1");
				break;
			case "two" :
				display.appendText("2");
				break;
			case "three" :
				display.appendText("3");
				break;
			case "four" :
				display.appendText("4");
				break;
			case "five" :
				display.appendText("5");
				break;
			case "six" :
				display.appendText("6");
				break;
			case "seven" :
				display.appendText("7");
				break;
			case "eight" :
				display.appendText("8");
				break;
			case "nine" :
				display.appendText("9");
				break;
			case "comma" :
				display.appendText(".");
				break;
		}
	}


	double[] temporary = {0, 0};

	private Boolean[] operator = new Boolean[4];
	private int operatorCount = 0;


	public void delete(Event event) {
		buttonDelete.setText("AC");
		display.setText("0");
		for(int i = 0; i < 2; i++) {
			temporary[i] = 0;
		}
		for(int i = 0; i<4; i++) {
			operator[i] = false;
		}
	}


	public void changeSign() {
		double number = Double.parseDouble(display.getText());
		try {
			if (number != 0){
				number = number * (-1);
				display.setText(Double.toString(number));
				System.out.println(number);
			} else {
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}


	@FXML public void operation(Event event) {

		operatorCount ++;
		System.out.println("operatorCount: "+operatorCount);
		if (display.getText() != ""){
			actualText = display.getText();
		}
		Button btn = (Button) event.getSource();
		String operation = btn.getId();
		switch(operation) {
			case "plus":
				operator[1] = true;
				temporary[0] = Double.parseDouble(display.getText());
				break;
			case "minus":
				operator[2] = true;
				temporary[0] = Double.parseDouble(display.getText());
				break;
			case "times":
				operator[3] = true;
				temporary[0] = Double.parseDouble(display.getText());
				break;
			case "divided":
				operator[4] = true;
				temporary[0] = Double.parseDouble(display.getText());
				break;
		}
		display.setText("");
	}



	@FXML public void result(Event event) {
		double result = 0;
		temporary[1] = Double.parseDouble(display.getText());
		String temp0 = Double.toString(temporary[0]);
		String temp1 = Double.toString(temporary[1]);
		if (operator[1]){
			result = temporary[0] + temporary[1];
		} else if (operator[2]){
			result = temporary[0] - temporary[1];
		} else if (operator[3]){
			result = temporary[0] * temporary[1];
		} else if (operator[4]){
			result = temporary[0] / temporary[1];
		}
		System.out.println("result: "+result);
		display.setText(Double.toString(result));
	}



	// Calculate two numbers and return the result
	public double calculate(double num1, double num2, String operator)
	{
		switch(operator)
		{
			case "+":
				return num1 + num2;
			case "-":
				return num1 - num2;
			case "x":
				return num1 * num2;
			case "÷":
				// This if statement prevents the creation of black holes. You are welcome, earth.
				if(num2 == 0)
				{
					return 0;
				}
				return num1 / num2;
			case "%":
				return num1 % num2;
			default:
				// Error
				System.out.println("Undefined operator pressed: " + operator);
				return 0;
		}
	}


	// Returns true if the string is an operator
	private boolean isOperator(String operator)
	{
		switch(operator)
		{
			case "+":
			case "-":
			case "x":
			case "÷":
			case "%":
				return true;
			default:
				return false;
		}
	}


	// Adds text to output
	private void addToOutput(String text)
	{
		// If we only have a 0 in output, clear it
		if("0".equals(textOutput.getText()) )
		{
			textOutput.setText("");
		}
		textOutput.setText(textOutput.getText() + text);
	}


	private void menuQuit(ActionEvent event)
	{
		Platform.exit();
		System.exit(0);
	}

	@FXML
	private void btnBack(ActionEvent event) throws IOException {
		Parent home = FXMLLoader.load(getClass().getResource("/View/Bursary/bursary.fxml"));
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.setScene(new Scene (home));

	}


}