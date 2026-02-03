package com.hito2.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hito2.proyecto.config.StageManager;
import com.hito2.proyecto.model.Alumno;
import com.hito2.proyecto.service.AlumnoService;
import com.hito2.proyecto.view.FxmlView;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

@Controller
public class AlumnosViewController {

    @FXML
    private TableView<Alumno> tablaAlumnos;
    @FXML
    private TableColumn<Alumno, String> colNombre;
    @FXML
    private TableColumn<Alumno, String> colEmail;
    @FXML
    private TableColumn<Alumno, String> colCiclo;
    @FXML
    private TableColumn<Alumno, Integer> colCurso;

    @Autowired
    private AlumnoService alumnoService;

    private final StageManager stageManager;

    public AlumnosViewController(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colCiclo.setCellValueFactory(new PropertyValueFactory<>("ciclo"));
        colCurso.setCellValueFactory(new PropertyValueFactory<>("curso"));
        cargarAlumnos();
    }

    private void cargarAlumnos() {
        List<Alumno> alumnos = alumnoService.findAll();
        tablaAlumnos.setItems(FXCollections.observableArrayList(alumnos));
    }

    // CRUD
    @FXML
    private void nuevoAlumno() {
        AlumnoFormController.setAlumnoActual(null); // ALTA
        stageManager.switchScene(FxmlView.ALUMNO_FORM);
    }

    @FXML
    private void editarAlumno() {
        Alumno seleccionado = tablaAlumnos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            AlumnoFormController.setAlumnoActual(seleccionado); 
            stageManager.switchScene(FxmlView.ALUMNO_FORM);
        }
    }

    @FXML
    private void eliminarAlumno() {
        Alumno seleccionado = tablaAlumnos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            alumnoService.delete(seleccionado.getId());
            cargarAlumnos();
        }
    }

    @FXML
    private void volver() {
        stageManager.switchScene(FxmlView.ADMIN);
    }
}