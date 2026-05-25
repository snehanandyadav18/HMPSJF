package com.Snehanand;

import com.Snehanand.model.Patient;
import com.Snehanand.service.PatientService;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class App extends Application {

    private ConfigurableApplicationContext context;

    private PatientService patientService;

    @Override
    public void init() {

        context = new SpringApplicationBuilder(SpringBootJavaFxApplication.class).run();
        patientService = context.getBean(PatientService.class);
    }

    @Override
    public void start(Stage stage) {

        // Name

        TextField nameField = new TextField();

        nameField.setPromptText("Enter Name");

        // Age

        TextField ageField = new TextField();

        ageField.setPromptText("Enter Age");

        // Disease

        TextField diseaseField = new TextField();

        diseaseField.setPromptText("Enter Disease");

        // Button

        Button addButton = new Button("Add Patient");

        // Button Click

        addButton.setOnAction(e -> {

            try {

                String name = nameField.getText();

                int age = Integer.parseInt(ageField.getText());

                String disease = diseaseField.getText();

                Patient patient = new Patient(name, age, disease);

                patientService.addPatient(patient);

                System.out.println("Patient Added");

                // Clear

                nameField.clear();
                ageField.clear();
                diseaseField.clear();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Layout

        VBox root = new VBox(10);

        root.setPadding(new Insets(20));

        root.getChildren().addAll(nameField, ageField, diseaseField, addButton);

        // Scene

        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("Spring + JavaFX");

        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void stop() {
        context.close();
    }

    public static void main(String[] args) {
        launch();
    }
}