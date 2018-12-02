

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Calculator extends Application {

    private TextField textField = new TextField();
    private boolean oneOp = false;

    /**
     * starts application and sets up the stage
     * @param primaryStage Stage that encapsulates scene
     */
    @Override
    public void start(Stage primaryStage) {

        String[] buttons = new String[]{"1", "2", "3", " + ",
                "4", "5", "6", " - ", "7", "8", "9", " * ",
                "Enter", "0", "Clear", " // "};
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setHgap(6);
        pane.setVgap(6);
        pane.setMinWidth(400);
        pane.setPrefWidth(400);
        pane.setMaxWidth(420);
        Scene scene = new Scene(pane);
        textField.setEditable(false);
        textField.setAlignment(Pos.CENTER);
        textField.setMinSize(350, 40);
        // Rezultat.textProperty().bind(Bindings.format("%.0f", value));
        pane.getChildren().add(textField);

        for (String button : buttons) {
            Button b = new Button(button);
            b.setMinSize(80, 80);
            pane.getChildren().add(b);
            b.setOnAction((e) -> onButtonClicked(b.getText()));
        }
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * on Enter, calculates value in textField
     */
    public void calculate(){
        String s = textField.getText();
        if (s == null){

        }
        String[]args = s.split(" ");
        textField.clear();
        if (args[1].equals("+")){
            textField.appendText(String.valueOf(Integer.parseInt(args[0]) + Integer.parseInt(args[2])));
        }else if (args[1].equals("-")){
            textField.appendText(String.valueOf(Integer.parseInt(args[0]) - Integer.parseInt(args[2])));
        }else if (args[1].equals("*")){
            textField.appendText(String.valueOf(Integer.parseInt(args[0]) * Integer.parseInt(args[2])));
        }else
            textField.appendText(String.valueOf(Integer.parseInt(args[0]) / Integer.parseInt(args[2])));
        oneOp = false;
    }

    /**
     * responds to different button clicking events
     * @param text String from the button that was pressed
     */
    private void onButtonClicked(String text) {

        if (text.equalsIgnoreCase("Enter")) {
            calculate();
        }else if (text.equalsIgnoreCase("Clear")) {
            textField.clear();
        }
        else if ((text.equals(" + ")) || (text.equals(" - ")) ||
                (text.equals(" * ")) || (text.equals(" // "))){
            if (oneOp == false){
                oneOp = true;
                textField.appendText(text);
            }

        }else{
            textField.appendText(text);
        }
    }

    /**
     * main method launches the application
     * @param args unused
     */
    public static void main(String[] args) {
        Application.launch(args);

    }
}
