package com.rocketsim.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RocketSimulatorApp extends Application {

    private SimulatorController controller;

    @Override
    public void start(Stage primaryStage) {
        controller = new SimulatorController();
        controller.setPrimaryStage(primaryStage);
        controller.setMainScene(createMainScene());

        controller.playBackgroundMusic();

        primaryStage.setTitle("Rocket Simulator");
        primaryStage.setScene(createMainScene());
        primaryStage.setWidth(1000);
        primaryStage.setHeight(700);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private Scene createMainScene() {
        BorderPane rootscene = new BorderPane();
        // Add background image
        try {
            Image backgroundImage = new Image("file:/home/22rakoon/Documents/YNOV/All-Prog/PROJETS/FUSEE-SIMU-JAVA (+UITest)/Earth-from-space.jpg");
            BackgroundImage bgImage = new BackgroundImage(
                    backgroundImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
            );
            rootscene.setBackground(new Background(bgImage));
        } catch (Exception e) {
            rootscene.setStyle("-fx-background-color: #1a1a1a;");
        }

        // Header
        Label titleLabel = new Label("ROCKET SIMULATOR");
        titleLabel.setStyle("-fx-font-size: 60; -fx-font-weight: bold; -fx-text-fill: #ffffff;");
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.setAlignment(Pos.CENTER);
        VBox headerBox = new VBox(titleLabel);
        headerBox.setPadding(new Insets(50, 10, 50, 10));
        headerBox.setStyle("-fx-background-color: #00000050;");
        headerBox.setPrefHeight(20);
        rootscene.setTop(headerBox);

        // Main Button Layout
        VBox mainBox = new VBox(10);
        mainBox.setPadding(new Insets(20));
        mainBox.setStyle("-fx-background-color: #00000050;");

        // Buttons
        Button btnMissions = createStyledButton("Browse Missions");
        btnMissions.setOnAction(e -> controller.showMissions());

        Button btnComponents = createStyledButton("View Components");
        btnComponents.setOnAction(e -> controller.showComponents());

        Button btnBuildRocket = createStyledButton("Build Rocket");
        btnBuildRocket.setOnAction(e -> controller.buildRocket());

        Button btnLaunchRocket = createStyledButton("Launch Rocket!");
        btnLaunchRocket.setOnAction(e -> controller.launchRocket());

        Button btnHistory = createStyledButton("Launch History");
        btnHistory.setOnAction(e -> controller.showHistory());

        Button btnQuit = createStyledButton("Quit");
        btnQuit.setOnAction(e -> System.exit(0));

        mainBox.getChildren().addAll(btnMissions, btnComponents, btnBuildRocket, btnLaunchRocket, btnHistory, btnQuit);
        mainBox.setAlignment(Pos.TOP_CENTER);

        rootscene.setCenter(mainBox);

        return new Scene(rootscene);
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(300);
        button.setPrefHeight(50);
        button.setStyle(
                "-fx-font-size: 20; "
                + "-fx-text-fill: #ffffff; "
                + "-fx-background-color: #000000a6; "
                + "-fx-border-radius: 5; "
                + "-fx-background-radius: 3; "
                + "-fx-padding: 10; "
                + "-fx-cursor: hand;"
        );
        button.setOnMouseEntered(e -> button.setStyle(button.getStyle() + "-fx-background-color: #000529b9;"));
        button.setOnMouseExited(e -> button.setStyle(
                "-fx-font-size: 20; "
                + "-fx-text-fill: #ffffff; "
                + "-fx-background-color: #000000a6; "
                + "-fx-border-radius: 5; "
                + "-fx-background-radius: 3; "
                + "-fx-padding: 10;"
        ));

        button.addEventHandler(ActionEvent.ACTION, e -> controller.playClickSound());
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
