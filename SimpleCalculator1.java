import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator1 extends JFrame implements ActionListener 
{
private JTextField textField;
private String operator;
private double num1, num2, result;
@SuppressWarnings("unused")
private boolean isResultDisplayed = false;
public SimpleCalculator1( ) 
{
setTitle("simple Calculator");
setSize(350, 450);

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout( ) );

textField = new JTextField( );
textField.setEditable(false);
add(textField,BorderLayout.NORTH);

JPanel panel = new JPanel( );
panel.setLayout(new GridLayout(5,4));

String[ ] buttons = {
  "7", "8", "9", "+",
  "4", "5", "6", "-",
  "1", "2", "3", "*",
  ".", "0",  "=", "/",
  "C", "%", " ←", " "
};
for (String text : buttons) 
{
JButton button = new JButton(text);
button.addActionListener(this);
panel.add(button);
}
add(panel,BorderLayout.CENTER);
setVisible(true);
}
public void actionPerformed(ActionEvent e) {
String command = e.getActionCommand( );
if ("0123456789".contains(command)) {
textField.setText(textField.getText( ) + command);
}
else if (command.equals(".")) 
{
if( ! textField.getText( ).contains("."))
{
textField.setText(textField.getText( ) + ".");
}
}
else if ("+-*/%".contains(command))
{
if (! textField.getText().isEmpty( )) 
{
num1 = Double.parseDouble(textField.getText( ));
operator = command;
textField.setText(" ");
}
}
else if (command.equals("="))
{
if (! textField.getText( ).isEmpty( ))
{
num2 = Double.parseDouble(textField.getText( ));
switch (operator) 
{
case "+": result = num1 + num2;
break;
case "-": result = num1 - num2;
break;
case "*": result = num1 * num2;
break;
case "/": result = ( num2 == 0 ) ? Double.NaN : num1 / num2;
break;
case "%": result = num1 % num2;
break;
}
textField.setText(Double.isNaN(result) ? "Error" : String.valueOf(result));
num1 = result;
}
}
else if  ( command.equals("C")) 
{
textField.setText(" ");
num1 = num2 =result = 0;
operator = null;
}
else if (command.equals("←") )
{
String currentText = textField.getText( );
if(!currentText.isEmpty( ) ) 
{
textField.setText(currentText.substring(0,currentText.length( ) - 1) );
}
}
}
public static void main (String[ ] args )
{
new SimpleCalculator1( );
}
}
