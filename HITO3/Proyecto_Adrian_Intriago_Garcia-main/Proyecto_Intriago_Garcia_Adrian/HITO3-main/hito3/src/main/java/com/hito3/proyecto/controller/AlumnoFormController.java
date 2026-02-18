package com.hito3.proyecto.controller;

import org.springframework.stereotype.Controller;

import com.hito3.proyecto.model.Alumno;
import com.hito3.proyecto.service.AlumnoService;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@Controller
public class AlumnoFormController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtEmail;
    @FXML private TextField txtCiclo;
    @FXML private TextField txtCurso;

    private static Alumno alumnoActual;

    private final AlumnoService alumnoService;

    public AlumnoFormController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    
    public static void setAlumnoActual(Alumno alumno) {
        alumnoActual = alumno;
    }

    @FXML
    public void initialize() {
        if (alumnoActual != null) {
            txtNombre.setText(alumnoActual.getNombre());
            txtEmail.setText(alumnoActual.getEmail());
            txtCiclo.setText(alumnoActual.getCiclo());
            txtCurso.setText(String.valueOf(alumnoActual.getCurso()));
        }
    }

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

    @FXML
    private void cancelar() {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) txtNombre.getScene().getWindow();
        stage.close();
        alumnoActual = null;     }
}

