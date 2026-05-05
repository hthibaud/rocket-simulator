package com.rocketsim.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.rocketsim.core.Builder;
import com.rocketsim.core.Launch;
import com.rocketsim.core.Rocket;
import com.rocketsim.models.mission.Mission;
import com.rocketsim.utils.Catalog;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
public class SimulatorController {

    private Stage primaryStage;
    private Scene mainScene;
    private MediaPlayer backgroundMusic;
    private Catalog catalog = new Catalog();
    private Builder builder = new Builder();
    private Rocket currentRocket;
    private List<String> launchHistory = new ArrayList<>();
    private boolean hasDisappeared = false;

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    public void setMainScene(Scene scene) {
        this.mainScene = scene;
    }

    public void applyEarthBackground(Region region) {
        try {
            Image backgroundImage = new Image("file:/home/22rakoon/Documents/YNOV/All-Prog/PROJETS/FUSEE-SIMU-JAVA (+UITest)/Earth-from-space.jpg");

            BackgroundImage bgImage = new BackgroundImage(
                    backgroundImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
            );
            region.setBackground(new Background(bgImage));
        } catch (Exception e) {
            region.setStyle("-fx-background-color: #1a1a1a;");
        }
    }

    public void showMissions() {

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));

        applyEarthBackground(layout);

        Label titleLabel = new Label("AVAILABLE MISSIONS");
        titleLabel.setStyle("-fx-font-size: 25; -fx-font-weight: bold; -fx-text-fill: #ffffff;");
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.setAlignment(Pos.CENTER);

        TextArea contentArea = new TextArea(
                "Orbit - Useful information of this mission: " + catalog.getOrbit().toString() + "\n\n"
                + "ISS - Useful information of this mission: " + catalog.getISS().toString() + "\n\n"
                + "Moon - Useful information of this mission: " + catalog.getMoon().toString() + "\n\n"
                + "Mars - Useful information of this mission: " + catalog.getMars().toString() + "\n\n"
                + "Secret mission - Useful information of this mission: " + catalog.getSecretMission().toString());

        contentArea.setPrefHeight(500);
        contentArea.setPrefWidth(500);
        contentArea.setMaxWidth(500);
        contentArea.setEditable(false);
        contentArea.setStyle("-fx-font-size: 15; -fx-control-inner-background: rgba(21, 21, 21, 0.68); -fx-text-fill: white;");

        Button backButton = createBackButton("Back to Menu");
        backButton.setOnAction(e -> primaryStage.setScene(mainScene));

        layout.getChildren().addAll(titleLabel, contentArea, backButton);

        primaryStage.setScene(new Scene(layout, 900, 600));

    }

    public void showComponents() {

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));

        Label titleLabel = new Label("AVAILABLE COMPONENTS");
        titleLabel.setStyle("-fx-font-size: 25; -fx-font-weight: bold; -fx-text-fill: #ffffff;");
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.setAlignment(Pos.CENTER);

        applyEarthBackground(layout);

        TextArea contentArea = new TextArea(
                "LAUNCHERS:\n"
                + catalog.getFalcon9().toString() + "\n"
                + catalog.getArianeV().toString() + "\n"
                + catalog.getSaturneV().toString() + "\n"
                + catalog.getSLS().toString() + "\n\n"
                + "CAPSULES:\n"
                + catalog.getCargoDragon().toString() + "\n"
                + catalog.getCrewDragon().toString() + "\n"
                + catalog.getApollo().toString() + "\n"
                + catalog.getOrion().toString() + "\n\n"
                + "BOOSTERS:\n"
                + catalog.getBE3().toString() + "\n"
                + catalog.getEAP().toString() + "\n"
                + catalog.getSRB().toString());

        contentArea.setPrefHeight(500);
        contentArea.setPrefWidth(500);
        contentArea.setMaxWidth(500);
        contentArea.setEditable(false);
        contentArea.setStyle("-fx-font-size: 15; -fx-control-inner-background: rgba(18, 18, 18, 0.6); -fx-text-fill: white;");

        Button backButton = createBackButton("Back to Menu");
        backButton.setOnAction(e -> primaryStage.setScene(mainScene));

        backButton.setOnAction(e -> primaryStage.setScene(mainScene));

        layout.getChildren().addAll(titleLabel, contentArea, backButton);

        primaryStage.setScene(new Scene(layout, 900, 600));

    }

    public void buildRocket() {

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(40));

        Label titleLabel = new Label("BUILD  YOUR ROCKET");
        titleLabel.setStyle("-fx-font-size: 40; -fx-font-weight: bold; -fx-text-fill: #ffffff;");
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.setAlignment(Pos.CENTER);

        applyEarthBackground(layout);

        VBox componentsBox = new VBox(20);
        componentsBox.setPadding(new Insets(10));
        componentsBox.setStyle("-fx-border-color: #2f342f; -fx-border-radius: 5; -fx-background-color: rgba(0,0,0,0.5);");

        //CHOOSE LAUNCHER
        Label launcherLabel = new Label("Select Launcher:");
        launcherLabel.setStyle("-fx-font-size: 15; -fx-text-fill: white; -fx-font-weight: bold;");

        ComboBox<String> launcherCombo = new ComboBox<>();
        launcherCombo.setStyle(
                "-fx-background-color: #333333; "
                + "-fx-mark-color: #ffffff; "
                + "-fx-text-fill: #ffffff; "
                + "-fx-font-weight: bold; "
                + "-fx-border-color: #555555; "
                + "-fx-border-radius: 5; "
                + "-fx-background-radius: 5;"
        );

        launcherCombo.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(launcherCombo.getPromptText());
                    setStyle("-fx-text-fill: #aaaaaa;");
                } else {
                    setText(item);
                    setStyle("-fx-text-fill: #ffffff;");
                }
            }
        });
        launcherCombo.getItems().addAll("Falcon 9", "Ariane V", "Saturne V", "SLS");
        launcherCombo.setPrefWidth(300);
        launcherCombo.setMaxWidth(300);
        launcherCombo.setPromptText("Choose a launcher...");
        launcherCombo.setOnAction(e -> {
            String selected = launcherCombo.getValue();
            if (selected.equals("Falcon 9")) {
                builder.addLauncherToRocket(catalog.getFalcon9());
            }
            if (selected.equals("Ariane V")) {
                builder.addLauncherToRocket(catalog.getArianeV());
            }
            if (selected.equals("Saturne V")) {
                builder.addLauncherToRocket(catalog.getSaturneV());
            }
            if (selected.equals("SLS")) {
                builder.addLauncherToRocket(catalog.getSLS());
            }

        });
        // CHOOSE CAPSULE
        Label capsuleLabel = new Label("Select Capsule:");
        capsuleLabel.setStyle("-fx-font-size: 15; -fx-text-fill: white; -fx-font-weight: bold;");

        ComboBox<String> capsuleCombo = new ComboBox<>();
        capsuleCombo.setStyle(
                "-fx-background-color: #333333; "
                + "-fx-mark-color: #ffffff; "
                + "-fx-text-fill: #ffffff; "
                + "-fx-font-weight: bold; "
                + "-fx-border-color: #555555; "
                + "-fx-border-radius: 5; "
                + "-fx-background-radius: 5;"
        );
        capsuleCombo.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(launcherCombo.getPromptText());
                    setStyle("-fx-text-fill: #aaaaaa;");
                } else {
                    setText(item);
                    setStyle("-fx-text-fill: #ffffff;");
                }
            }
        });
        capsuleCombo.getItems().addAll("Cargo Dragon", "Crew Dragon", "Apollo", "Orion");
        capsuleCombo.setPromptText("Choose a capsule...");
        capsuleCombo.setPrefWidth(300);
        capsuleCombo.setMaxWidth(300);
        capsuleCombo.setOnAction(e -> {
            String selected = capsuleCombo.getValue();
            if (selected.equals("Cargo Dragon")) {
                builder.addCapsuleToRocket(catalog.getCargoDragon());
            }
            if (selected.equals("Crew Dragon")) {
                builder.addCapsuleToRocket(catalog.getCrewDragon());
            }
            if (selected.equals("Apollo")) {
                builder.addCapsuleToRocket(catalog.getApollo());
            }
            if (selected.equals("Orion")) {
                builder.addCapsuleToRocket(catalog.getOrion());
            }
        });

        // CHOOSE BOOSTERS
        Label boosterLabel = new Label("Add Boosters:");
        boosterLabel.setStyle("-fx-font-size: 15; -fx-text-fill: white; -fx-font-weight: bold;");

        HBox boosterSection = new HBox(10);
        ComboBox<String> boosterCombo = new ComboBox<>();
        boosterCombo.setStyle(
                "-fx-background-color: #333333; "
                + "-fx-mark-color: #ffffff; "
                + "-fx-text-fill: #ffffff; "
                + "-fx-font-weight: bold; "
                + "-fx-border-color: #555555; "
                + "-fx-border-radius: 5; "
                + "-fx-background-radius: 5;"
        );

        boosterCombo.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(launcherCombo.getPromptText());
                    setStyle("-fx-text-fill: #aaaaaa;");
                } else {
                    setText(item);
                    setStyle("-fx-text-fill: #ffffff;");
                }
            }
        });

        boosterCombo.setPrefWidth(300);
        boosterCombo.setMaxWidth(300);

        boosterCombo.getItems().addAll("BE-3", "EAP", "SRB");
        boosterCombo.setPromptText("Select booster type...");

        Button addBoosterBtn = new Button(" Add ");
        addBoosterBtn.setStyle("-fx-background-color: #24282e; -fx-text-fill: white;");
        addBoosterBtn.setOnAction(e -> {
            String selected = boosterCombo.getValue();
            if (selected != null) {
                switch (selected) {
                    case "BE-3" ->
                        builder.addBoosterToRocket(catalog.getBE3());
                    case "EAP" ->
                        builder.addBoosterToRocket(catalog.getEAP());
                    case "SRB" ->
                        builder.addBoosterToRocket(catalog.getSRB());
                }

                int boosterCount = builder.getSelectedBoosters().size();
                addBoosterBtn.setText(" Add more (current number: " + boosterCount + ") ");
            }
        });
        boosterSection.getChildren().addAll(boosterCombo, addBoosterBtn);

        var nameChoice = new TextField();
        nameChoice.setPromptText("Enter your rocket's name...");
        nameChoice.setMaxWidth(400);

        componentsBox.getChildren().addAll(
                launcherLabel, launcherCombo,
                capsuleLabel, capsuleCombo,
                boosterLabel, boosterSection, nameChoice
        );
        Button finishButton = new Button("Finish Building");
        finishButton.setPrefWidth(200);
        finishButton.setPrefHeight(50);
        finishButton.setStyle(
                "-fx-font-size: 14; -fx-background-color: #06e806; -fx-text-fill: #000000; -fx-font-weight: bold;");
        finishButton.setOnMouseEntered(e -> finishButton.setStyle("-fx-font-size: 14; -fx-background-color: #04ab04; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 15 30; -fx-cursor: hand;"));
        finishButton.setOnMouseExited(e -> finishButton.setStyle("-fx-font-size: 14; -fx-background-color: #06c606; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 15 30;"));
        finishButton.setOnAction(e -> {

            playClickSound();

            String userRocketName = nameChoice.getText();

            if (userRocketName == null || userRocketName.isBlank()) {
                userRocketName = "Unnamed Rocket";
            }
            builder.setName(userRocketName);

            currentRocket = builder.build();
            if (currentRocket != null) {
                showBuildSuccess(currentRocket.toString());
            } else {
                showBuildError();
            }
        });

        Button backButton = createBackButton("Back to Menu");
        backButton.setOnAction(e -> primaryStage.setScene(mainScene));

        layout.getChildren().addAll(titleLabel, componentsBox, finishButton, backButton);

        primaryStage.setScene(new Scene(layout, 900, 600));

    }

    public void launchRocket() {
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.CENTER);
        applyEarthBackground(layout);

        if (currentRocket == null) {

            Label title = new Label("NOPE");
            title.setStyle("-fx-font-size: 40; -fx-font-weight: bold; -fx-text-fill: #ff0000;");

            TextArea details = new TextArea("Build a rocket first.");
            details.setEditable(false);
            details.setPrefHeight(200);
            details.setStyle("-fx-font-size: 20; -fx-control-inner-background: rgba(19, 19, 19, 0.8); -fx-text-fill: white; -fx-font-family: 'Courier New';");

            Button backButton = createBackButton("Back to Menu");
            backButton.setOnAction(e -> primaryStage.setScene(mainScene));
            layout.getChildren().addAll(title, details, backButton);

        } else {
            Label title = new Label("Select Your Mission");
            title.setStyle("-fx-font-size: 40; -fx-font-weight: bold; -fx-text-fill: #ffffff;");

            VBox missionsBox = new VBox(8);
            missionsBox.setAlignment(Pos.CENTER);
            missionsBox.setPadding(new Insets(10));

            Button orbitBtn = createMissionButton("Orbit Mission", catalog.getOrbit());
            Button issBtn = createMissionButton("ISS Mission", catalog.getISS());
            Button moonBtn = createMissionButton("Moon Mission", catalog.getMoon());
            Button marsBtn = createMissionButton("Mars Mission", catalog.getMars());
            Button secretBtn = createSecretButton("Secret Mission", catalog.getSecretMission());

            missionsBox.getChildren().addAll(orbitBtn, issBtn, moonBtn, marsBtn, secretBtn);

            Button backButton = createBackButton("Back to Menu");
            backButton.setOnAction(e -> primaryStage.setScene(mainScene));

            layout.getChildren().addAll(title, missionsBox, backButton);
        }
        primaryStage.setScene(new Scene(layout, 900, 600));
    }

    private Button createMissionButton(String text, Mission mission) {
        Button button = new Button(text);
        button.setPrefWidth(300);
        button.setPrefHeight(60);
        button.setStyle(
                    "-fx-font-size: 16; "
                    + "-fx-font-weight: bold; "
                    + "-fx-text-fill: #ffffff; "
                    + "-fx-background-color: #000000a8; "
                    + "-fx-border-radius: 3; "
                    + "-fx-background-radius: 3; "
                    + "-fx-padding: 10; "
                    + "-fx-cursor: hand;"
            );
            button.setOnMouseEntered(e -> button.setStyle(button.getStyle() + "-fx-background-color: #000529af;"));
            button.setOnMouseExited(e -> button.setStyle(
                    "-fx-font-size: 16; "
                    + "-fx-font-weight: bold; "
                    + "-fx-text-fill: #ffffff; "
                    + "-fx-background-color: #000000a8; "
                    + "-fx-border-radius: 3; "
                    + "-fx-background-radius: 3; "
                    + "-fx-padding: 10;"
            ));
        button.addEventHandler(ActionEvent.ACTION, e -> playLaunchSound());
        button.setOnAction(e -> executeLaunch(mission));
        return button;
    }

    private Button createSecretButton(String text, Mission mission) {
        Button button = new Button(text);
        button.setPrefWidth(300);
        button.setPrefHeight(60);
        button.setStyle(
                    "-fx-font-size: 16; "
                    + "-fx-font-weight: bold; "
                    + "-fx-text-fill: #ffffff; "
                    + "-fx-background-color: #000000a8; "
                    + "-fx-border-radius: 3; "
                    + "-fx-background-radius: 3; "
                    + "-fx-padding: 10; "
                    + "-fx-cursor: hand;"
            );
            button.setOnMouseEntered(e -> button.setStyle(button.getStyle() + "-fx-background-color: #000529af;"));
            button.setOnMouseExited(e -> button.setStyle(
                    "-fx-font-size: 16; "
                    + "-fx-font-weight: bold; "
                    + "-fx-text-fill: #ffffff; "
                    + "-fx-background-color: #000000a8; "
                    + "-fx-border-radius: 3; "
                    + "-fx-background-radius: 3; "
                    + "-fx-padding: 10;"
            ));
        button.addEventHandler(ActionEvent.ACTION, e -> playLaunchSound());
        button.setOnAction(e -> executeSecretLaunch());
        return button;
    }

    public void executeSecretLaunch() {

        String videoPath = "/home/22rakoon/Documents/YNOV/All-Prog/PROJETS/FUSEE-SIMU-JAVA (+UITest)/launch.GIF";
        File videoFile = new File(videoPath);

        if (!videoFile.exists()) {
            showLaunchResult("Secret launch video not found.");
            return;
        }

        Image image = new Image(videoFile.toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1080);
        imageView.setFitHeight(1920);

        imageView.setPreserveRatio(true);

        VBox videoLayout = new VBox(20, imageView);
        videoLayout.setAlignment(Pos.CENTER);
        applyEarthBackground(videoLayout);

        Button skipButton = new Button("");
                
        skipButton.setOnAction(e -> showLaunchResult(getSecretVerdict()));
        videoLayout.getChildren().add(skipButton);
        primaryStage.setScene(new Scene(videoLayout, 900, 600));
    }

    private void executeLaunch(Mission mission) {
        if (hasDisappeared) {
            String verdict = "You can't go on missions once you discovered the secret. Remember? You never came back.";
            launchHistory.add(verdict);
            showLaunchResult(verdict);
        } else if ("Secret mission".equals(mission.getName())) {
            hasDisappeared = true;
            String verdict = "Report of the " + java.time.LocalDate.now().toString() + ": You never came back.";
            launchHistory.add(verdict);
            showLaunchResult(verdict);
        } else {
            Launch launch = new Launch(currentRocket, mission);
            String verdict = launch.isMissionSuccessful(currentRocket, mission);
            launchHistory.add(verdict);
            showLaunchResult(verdict);
        }
    }

    private void showLaunchResult(String verdict) {
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.TOP_CENTER);

        applyEarthBackground(layout);

        Label title = new Label("LAUNCH RESULT");
        title.setStyle("-fx-font-size: 40; -fx-font-weight: bold; -fx-text-fill: #ffffff;");

        TextArea resultArea = new TextArea(verdict);
        resultArea.setWrapText(true);
        resultArea.setEditable(false);
        resultArea.setPrefRowCount(20);
        resultArea.setStyle("-fx-control-inner-background: rgba(26, 26, 26, 0.8); -fx-text-fill: #FFFFFF; -fx-font-family: 'Courier New'; -fx-font-size: 20;");

        ScrollPane scrollPane = new ScrollPane(resultArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(400);

        HBox buttonBox = new HBox(20);
        buttonBox.setPadding(new Insets(20));
        buttonBox.setAlignment(Pos.CENTER);

        Button backToMissionsBtn = new Button("Launch Another Mission");
        backToMissionsBtn.setStyle("-fx-font-size: 14; -fx-background-color: #06c606; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 10 20;");
        backToMissionsBtn.setOnMouseEntered(e -> backToMissionsBtn.setStyle("-fx-font-size: 14; -fx-background-color: #04ab04; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 10 20; -fx-cursor: hand;"));
        backToMissionsBtn.setOnMouseExited(e -> backToMissionsBtn.setStyle("-fx-font-size: 14; -fx-background-color: #06c606; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 10 20;"));
        backToMissionsBtn.setOnAction(e -> launchRocket());

        Button backToMenuBtn = createBackButton("Back to Main Menu");
        
        backToMenuBtn.setOnAction(e -> primaryStage.setScene(mainScene));

        buttonBox.getChildren().addAll(backToMissionsBtn, backToMenuBtn);
        layout.getChildren().addAll(title, scrollPane, buttonBox);

        primaryStage.setScene(new Scene(layout, 900, 600));
    }

    public String getSecretVerdict(){
        playImpactSound();
        if (hasDisappeared) {
            return "Report of the " + java.time.LocalDate.now().toString() + ": You can't go on missions once you discovered the secret. Remember? You never came back.";
        } else {
            hasDisappeared = true;
            return "Report of the " + java.time.LocalDate.now().toString() + ": You never came back.";
        }
    }

    public void showHistory() {
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        applyEarthBackground(layout);

        Label titleLabel = new Label("LAUNCH HISTORY");
        titleLabel.setStyle("-fx-font-size: 25; -fx-font-weight: bold; -fx-text-fill: #ffffff;");
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.setAlignment(Pos.CENTER);

        TextArea contentArea;
        if (launchHistory.isEmpty()) {
            contentArea = new TextArea("No launches yet!");
        } else {
            StringBuilder history = new StringBuilder("\n\n");
            for (int i = 0; i < launchHistory.size(); i++) {
                history.append((i + 1)).append(". ").append(launchHistory.get(i)).append("\n\n");
            }
            contentArea = new TextArea(history.toString());
        }

        contentArea.setPrefHeight(500);
        contentArea.setPrefWidth(300);
        contentArea.setEditable(false);
        contentArea.setStyle("-fx-font-size: 18; -fx-control-inner-background: rgba(26, 26, 26, 0.72); -fx-text-fill: white;");

        Button backButton = createBackButton("Back to Menu");
        backButton.setOnAction(e -> primaryStage.setScene(mainScene));

        layout.getChildren().addAll(titleLabel, contentArea, backButton);
        primaryStage.setScene(new Scene(layout, 900, 600));
    }

    public void showBuildSuccess(String rocketData) {

        playSuccessSound();

        playBuildSound();

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.CENTER);
        applyEarthBackground(layout);

        Label title = new Label("SUCCESS: ROCKET ASSEMBLED");
        title.setStyle("-fx-font-size: 26; -fx-font-weight: bold; -fx-text-fill: #00FF00;");

        TextArea details = new TextArea(rocketData);
        details.setEditable(false);
        details.setPrefHeight(350);
        details.setStyle("-fx-control-inner-background: rgba(26, 26, 26, 0.8); -fx-text-fill: white; -fx-font-family: 'Courier New';");

        HBox endButtons = new HBox(20);
        endButtons.setPadding(new Insets(30));
        endButtons.setAlignment(Pos.CENTER);
        Button nextButton = new Button("Go to Missions");
        nextButton.setStyle("-fx-background-color: #06c606; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 15 30;");
        nextButton.setOnMouseEntered(e -> nextButton.setStyle("-fx-background-color: #04ab04; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 15 30; -fx-cursor: hand;"));
        nextButton.setOnMouseExited(e -> nextButton.setStyle("-fx-background-color: #06c606; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 15 30;"));

        nextButton.setOnAction(e -> launchRocket());
        Button backButton = createBackButton("Go to main menu");

        backButton.setOnAction(e -> primaryStage.setScene(mainScene));
        layout.setAlignment(Pos.CENTER);

        endButtons.getChildren().addAll(nextButton, backButton);
        layout.getChildren().addAll(title, details, endButtons);
        primaryStage.setScene(new Scene(layout, 900, 600));
    }

    public void showBuildError() {

        playFailSound();

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.CENTER);
        applyEarthBackground(layout);

        Label title = new Label("BUILD FAILED");
        title.setStyle("-fx-font-size: 40; -fx-font-weight: bold; -fx-text-fill: #FF3333;");

        TextArea details = new TextArea("Build failed! Make sure you selected at least a launcher and a capsule.");
        details.setEditable(false);
        details.setPrefHeight(350);
        details.setStyle("-fx-font-size: 18; -fx-control-inner-background: rgba(26, 26, 26, 0.8); -fx-text-fill: white; -fx-font-family: 'Courier New';");

        HBox endButtons = new HBox(20);
        endButtons.setPadding(new Insets(30));
        endButtons.setAlignment(Pos.CENTER);
        Button retryButton = new Button("Retry Building");
        retryButton.setStyle("-fx-background-color: #FF3333; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 15 30;");
        retryButton.setOnMouseEntered(e -> retryButton.setStyle("-fx-background-color: #d32323; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 15 30; -fx-cursor: hand;"));
        retryButton.setOnMouseExited(e -> retryButton.setStyle("-fx-background-color: #FF3333; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 15 30;"));
        retryButton.setOnAction(e -> playClickSound());
        retryButton.setOnAction(e -> buildRocket());
        Button backButton = createBackButton("Go to main menu");

        backButton.setOnAction(e -> primaryStage.setScene(mainScene));
        layout.setAlignment(Pos.CENTER);

        endButtons.getChildren().addAll(retryButton, backButton);
        layout.getChildren().addAll(title, details, endButtons);
        primaryStage.setScene(new Scene(layout, 900, 600));
    }

    private Button createBackButton(String message){

        Button backBtn = new Button(message);
        backBtn.setStyle(
                "-fx-font-size: 14; "
                + "-fx-font-weight: bold; "
                + "-fx-text-fill: #ffffff; "
                + "-fx-background-color: #000000; "
                + "-fx-border-radius: 3; "
                + "-fx-background-radius: 3; "
                + "-fx-padding: 10;"
        );
        backBtn.setOnMouseEntered(e -> backBtn.setStyle(backBtn.getStyle() + "-fx-background-color: #000529;"));
        backBtn.setOnMouseExited(e -> backBtn.setStyle(
                "-fx-font-size: 14; "
                + "-fx-font-weight: bold; "
                + "-fx-text-fill: #ffffff; "
                + "-fx-background-color: #000000; "
                + "-fx-border-radius: 3; "
                + "-fx-background-radius: 3; "
                + "-fx-padding: 10;"
        ));
        backBtn.addEventHandler(ActionEvent.ACTION, e -> playClickSound());
        return backBtn;
    }
    
    public void playClickSound() {
    AudioClip sound = new AudioClip(new File("src/main/resources/sounds/clickSFX.wav").toURI().toString());
    sound.setVolume(0.6); 
    sound.play();
    }

    public void playBuildSound() {
    AudioClip sound = new AudioClip(new File("src/main/resources/sounds/buildSFX.wav").toURI().toString());
    sound.setVolume(0.3); 
    sound.play();
    }

    public void playSuccessSound() {
    AudioClip sound = new AudioClip(new File("src/main/resources/sounds/successSFX.wav").toURI().toString());
    sound.setVolume(0.3); 
    sound.play();
    }  

    public void playFailSound() {
    AudioClip sound = new AudioClip(new File("src/main/resources/sounds/failSFX.wav").toURI().toString());
    sound.play();
    }

    public void playImpactSound() {
    AudioClip sound = new AudioClip(new File("src/main/resources/sounds/impactSFX.wav").toURI().toString());
    sound.play();
    }

    public void playLaunchSound() {
    AudioClip sound = new AudioClip(new File("src/main/resources/sounds/rocketLaunchSFX.wav").toURI().toString());
    sound.play();
    }  
    
public void playBackgroundMusic() {
    try {
        String path = getClass().getResource("/sounds/FairyTherapy-This_is_space.wav").toExternalForm();
        Media media = new Media(path);
        
        this.backgroundMusic = new MediaPlayer(media);
        
        this.backgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);
        this.backgroundMusic.setVolume(1); 
        
        this.backgroundMusic.play();
                
    } catch (Exception e) {
        System.err.println("Error during loading music : " + e.getMessage());
        e.printStackTrace();
    }
}
    
}
