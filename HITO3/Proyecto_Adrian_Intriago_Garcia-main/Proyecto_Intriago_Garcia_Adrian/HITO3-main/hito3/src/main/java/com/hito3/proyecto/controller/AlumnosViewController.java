package com.hito3.proyecto.controller;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.hito3.proyecto.config.StageManager;
import com.hito3.proyecto.model.Alumno;
import com.hito3.proyecto.service.AlumnoService;
import com.hito3.proyecto.view.FxmlView;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

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

    private final AlumnoService alumnoService;
    private final StageManager stageManager;

    public AlumnosViewController(AlumnoService alumnoService, StageManager stageManager) {
        this.alumnoService = alumnoService;
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
   
    
    @FXML
    private void nuevoAlumno() {
        AlumnoFormController.setAlumnoActual(null);
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
    @FXML
    private void exportarCSV() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar archivo CSV");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Archivo CSV", "*.csv")
        );

        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            alumnoService.exportarAlumnosCSV(file.getAbsolutePath());
        }
    }
    
}