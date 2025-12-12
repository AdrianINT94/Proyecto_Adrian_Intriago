package com.hito2.proyecto;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EntityScan("com.hito2.proyecto.model")
@EnableJpaRepositories("com.hito2.proyecto.repository")
@ComponentScan("com.hito2.proyecto")

public class GestionFeApplication extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        try {
            context = new SpringApplicationBuilder(GestionFeApplication.class)
                    .headless(false)
                    .run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Gestión de FE");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        try {
            if (context != null) {
                context.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}