package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import java.text.DecimalFormat;

public class HelloController {

    @FXML
    private Label display;
    private double num1 = 0;
    private String operador = "";
    private boolean start = true;

    @FXML
    private void handleButtonAction(javafx.event.ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if ("0123456789".contains(value)) {
            if (start) {
                display.setText(value);
                start = false;
            } else {
                display.setText(display.getText() + value);
            }
        } else {
            if (!operador.isEmpty()) return;

            operador = value;
            num1 = Double.parseDouble(display.getText());
            display.setText("");
        }
    }
    @FXML

    private void raizQuadrada() {
        try {
            double value = Double.parseDouble(display.getText());
            if (value >= 0) {
                double result = Math.sqrt(value);
                display.setText(String.valueOf(result));
            } else {
                display.setText("Erro");
            }
        } catch (NumberFormatException e) {
            display.setText("Erro");
        }
    }

    @FXML
    private void igual() {
        if (operador.isEmpty()) return;

        double num2 = Double.parseDouble(display.getText());
        double result = switch (operador) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num2 != 0 ? num1 / num2 : 0;
            default -> 0;
        };
        display.setText(String.valueOf(result));
        operador = "";
        start = true;
    }

    @FXML
    private void limpar() {
        display.setText("0");
        operador = "";
        start = true;
    }

    public void onHelloButtonClick(ActionEvent actionEvent) {

    }
    @FXML
    private void apagar(ActionEvent event) {
        String currentText = display.getText();
        if (currentText.length() > 1) {
            display.setText(currentText.substring(0, currentText.length() - 1));
        } else {
            display.setText("0");
        }
    }
    @FXML
    private void exponenciacao() {
        num1 = Double.parseDouble(display.getText());
        double result = Math.pow(num1, 2);
        display.setText(String.valueOf(result));
        start = true;

        DecimalFormat df = new DecimalFormat("#.##");
        display.setText(df.format(result));
        start = true;

    }

    }



