package com.hito2.proyecto;



import javafx.application.Application;
import javafx.stage.Stage;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hito2.proyecto.config.StageManager;
import com.hito2.proyecto.view.FxmlView;

@SpringBootApplication
@EntityScan("com.hito2.proyecto.model")
@EnableJpaRepositories("com.hito2.proyecto.repository")
@ComponentScan("com.hito2.proyecto")
public class GestionFeApplication extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        context = new SpringApplicationBuilder(GestionFeApplication.class)
                .web(WebApplicationType.NONE) // 👈 CLAVE
                .run();
    }

    @Override
    public void start(Stage primaryStage) {

        // obtenemos stagemanager
        StageManager stageManager = context.getBean(StageManager.class);
        
        // pasamos el stage aqui 
        stageManager.setPrimaryStage(primaryStage);

        // mostramos la primera pantalla
        stageManager.switchScene(FxmlView.LOGIN);
    }

    @Override
    public void stop() {
        context.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}