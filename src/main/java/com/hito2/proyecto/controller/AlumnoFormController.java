package com.hito2.proyecto.controller;

import org.springframework.stereotype.Controller;

import com.hito2.proyecto.model.Alumno;
import com.hito2.proyecto.service.AlumnoService;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@Controller
public class AlumnoFormController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtCiclo;

    @FXML
    private TextField txtCurso;

    // Alumno que se edita o se crea
    private static Alumno alumnoActual;

    private final AlumnoService alumnoService;

    public AlumnoFormController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }


    public static void setAlumnoActual(Alumno alumno) {
        alumnoActual = alumno;
    }

    // SE EJECUTA AL CARGAR EL FXML 

    @FXML
    public void initialize() {
        if (alumnoActual != null) {
            txtNombre.setText(alumnoActual.getNombre());
            txtEmail.setText(alumnoActual.getEmail());
            txtCiclo.setText(alumnoActual.getCiclo());
            txtCurso.setText(String.valueOf(alumnoActual.getCurso()));
        }
    }

    // BOTÓN GUARDAR 

    @FXML
    private void guardar() {

        if (alumnoActual == null) {
            alumnoActual = new Alumno();
        }

        alumnoActual.setNombre(txtNombre.getText());
        alumnoActual.setEmail(txtEmail.getText());
        alumnoActual.setCiclo(txtCiclo.getText());
        alumnoActual.setCurso(Integer.parseInt(txtCurso.getText()));

        alumnoService.save(alumnoActual);
        cerrarVentana();
    }

    //BOTÓN CANCELAR

    @FXML
    private void cancelar() {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) txtNombre.getScene().getWindow();
        stage.close();
    }
}