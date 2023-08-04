package com.example.login_cyberPost_jeffer;

import javafx.application.Application;       // Clase base para aplicaciones JavaFX
import javafx.geometry.Insets;              // Para establecer márgenes internos en nodos
import javafx.geometry.Pos;                 // Para alinear nodos dentro de contenedores
import javafx.scene.Scene;                  // Para representar una escena en JavaFX
import javafx.scene.control.Button;         // Para crear botones interactivos
import javafx.scene.control.PasswordField;  // Para crear campos de contraseña
import javafx.scene.control.TextField;       // Para crear campos de texto
import javafx.scene.layout.Background;      // Para establecer el fondo de un nodo
import javafx.scene.layout.BackgroundFill;  // Para especificar un relleno de fondo
import javafx.scene.layout.GridPane;        // Para organizar nodos en una cuadrícula
import javafx.scene.paint.Color;            // Para representar colores en JavaFX
import javafx.scene.text.Text;              // Para mostrar texto en la interfaz
import javafx.stage.Stage;                  // Para representar una ventana (Stage) en JavaFX


public class LoginApplication extends Application {

    // Datos de usuario para autenticar
    private final String[][] users = {
            {"jefferson@cyberPost.com", "jefferson123", "A\n  ****cyberPost****\n\njefferson Francisco Abac lemus\n\nEs un gusto tenerte de vuelta!!!"},
            {"mary@CyberPost.com", "mary456", "Mary perez"}
    };

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Page");

        // Label para el encabezado del formulario
        Text lbl3 = new Text("iniciar sesion en cyberPost");

        // Creando label para el campo de email
        Text lbl1 = new Text("Email");

        // Creando label para el campo de contraseña
        Text lbl2 = new Text("Password");

        // Creando campo de texto para el email
        TextField txt1 = new TextField();

        // Creando campo de texto para la contraseña
        PasswordField txt2 = new PasswordField();

        // Creando botones
        Button button1 = new Button("Login");
        Button button2 = new Button("Clear");

        // Creando el contenedor GridPane
        GridPane gridPane = new GridPane();

        // Estableciendo el tamaño del GridPane
        gridPane.setMinSize(400, 200);

        // Estableciendo el padding del GridPane
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        // Estableciendo el espacio vertical y horizontal entre las columnas
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        // Estableciendo la alineación del GridPane
        gridPane.setAlignment(Pos.CENTER);

        // Añadiendo los nodos al GridPane
        gridPane.add(lbl3, 0, 0, 2, 1);
        gridPane.add(lbl1, 0, 1);
        gridPane.add(txt1, 1, 1);
        gridPane.add(lbl2, 0, 2);
        gridPane.add(txt2, 1, 2);
        gridPane.add(button1, 0, 3);
        gridPane.add(button2, 1, 3);

        // Aplicando estilos a los nodos
        button1.setStyle("-fx-background-color: lavender; -fx-text-fill: black;");
        button2.setStyle("-fx-background-color: beige; -fx-text-fill: black;");

        txt1.setStyle("-fx-font: normal bold 20px 'serif' ");
        txt2.setStyle("-fx-font: normal bold 20px 'serif' ");
        lbl3.setStyle("-fx-font: normal bold 24px 'serif'");

        // Creando el objeto Scene
        Scene scene = new Scene(gridPane, 400, 200);

        // Estableciendo el color de fondo negro para el GridPane
        BackgroundFill backgroundFill = new BackgroundFill(Color.DARKGRAY, null, null);
        Background background = new Background(backgroundFill);
        gridPane.setBackground(background);

        // Estableciendo el color de fondo negro para la escena
        scene.setFill(Color.BLACK);

        // Añadiendo la escena al escenario (Stage)
        primaryStage.setScene(scene);

        // Mostrando el contenido del escenario
        primaryStage.show();

        // Acción del botón "Clear"
        button2.setOnAction(e -> {
            txt1.clear();
            txt2.clear();
        });

        // Acción del botón "Login"
        button1.setOnAction(e -> {
            String email = txt1.getText();
            String password = txt2.getText();

            if (authenticateUser(email, password)) {
                showWelcomePage(primaryStage, email);
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        });
    }

    // Método para autenticar al usuario basado en el email y contraseña proporcionados
    private boolean authenticateUser(String email, String password) {
        for (String[] user : users) {
            if (user[0].equals(email) && user[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Método para mostrar la página de bienvenida con el nombre completo del usuario
    private void showWelcomePage(Stage primaryStage, String email) {
        String fullName = "User"; // Valor predeterminado si el usuario no se encuentra
        for (String[] user : users) {
            if (user[0].equals(email)) {
                fullName = user[2];
                break;
            }
        }

        // Creaar la escena de la página de bienvenida
        GridPane welcomePane = new GridPane();
        welcomePane.setAlignment(Pos.CENTER);
        welcomePane.setPadding(new Insets(10));
        welcomePane.setVgap(5);

        Text welcomeText = new Text("bienvenido! " + fullName + "!");
        welcomeText.setStyle("-fx-font: normal bold 24px 'serif'");
        welcomePane.getChildren().add(welcomeText);

        Scene welcomeScene = new Scene(welcomePane, 400, 200);

        // Mostrar la página de bienvenida
        primaryStage.setScene(welcomeScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
