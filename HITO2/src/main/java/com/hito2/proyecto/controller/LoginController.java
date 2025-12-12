package com.hito2.proyecto.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Controller
public class LoginController {
		
	@FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    // Valores cargados desde application.properties
    @Value("${user.admin}")
    private String adminUser;

    @Value("${user.admin.pass}")
    private String adminPass;

    @Value("${user.prof}")
    private String profUser;

    @Value("${user.prof.pass}")
    private String profPass;

    @FXML
    public void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Validación admin
        if (username.equals(adminUser) && password.equals(adminPass)) {
            errorLabel.setText("Login correcto (ADMIN)");
            return;
        }

        // Validación profesor
        if (username.equals(profUser) && password.equals(profPass)) {
            errorLabel.setText("Login correcto (PROFESOR)");
            return;
        }

        // Si no coincide
        errorLabel.setText("Usuario o contraseña incorrectos");
    }
}

