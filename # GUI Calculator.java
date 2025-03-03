# GUI Calculator 

// Main class
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");
        GridPane grid = new GridPane();
        TextField display = new TextField();
        grid.add(display, 0, 0, 4, 1);
        
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };
        
        int row = 1, col = 0;
        for (String text : buttons) {
            Button button = new Button(text);
            button.setMinSize(50, 50);
            grid.add(button, col, row);
            col++;
            if (col > 3) {
                col = 0;
                row++;
            }
            button.setOnAction(e -> handleButtonClick(text, display));
        }
        
        Scene scene = new Scene(grid, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonClick(String text, TextField display) {
        // Logic for button click handling
    }
}

// CalculatorLogic class
class CalculatorLogic {
    public double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                throw new UnsupportedOperationException("Invalid operator");
        }
    }
}

// CalculatorController class
class CalculatorController {
    private CalculatorLogic logic = new CalculatorLogic();
    private double firstNumber;
    private String operator;

    public void setFirstNumber(double number) {
        this.firstNumber = number;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double calculate(double secondNumber) {
        return logic.calculate(firstNumber, secondNumber, operator);
    }
}
