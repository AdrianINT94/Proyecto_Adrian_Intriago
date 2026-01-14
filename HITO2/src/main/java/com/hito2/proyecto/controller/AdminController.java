package com.hito2.proyecto.controller;

import org.springframework.stereotype.Controller;

import com.hito2.proyecto.config.StageManager;
import com.hito2.proyecto.view.FxmlView;

import javafx.fxml.FXML;

@Controller
public class AdminController {

    private final StageManager stageManager;

    public AdminController(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    @FXML
    private void irAlumnos() {
        stageManager.switchScene(FxmlView.ALUMNOS);
    }

    @FXML
    private void salir() {
        System.exit(0);
    }
}