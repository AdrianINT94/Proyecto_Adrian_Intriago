package com.hito2.proyecto.config;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.hito2.proyecto.view.FxmlView;

	@Lazy
	@Component
	public class StageManager {

	    private Stage primaryStage;
	    private final SpringFXMLLoader springFXMLLoader;

	    public StageManager(SpringFXMLLoader springFXMLLoader) {
	        this.springFXMLLoader = springFXMLLoader;
	    }

	    // ✅ SE LLAMA DESDE LA APPLICATION
	    public void setPrimaryStage(Stage primaryStage) {
	        this.primaryStage = primaryStage;
	    }

	    public void switchScene(FxmlView view) {
	        Parent rootNode = springFXMLLoader.load(view.getFxmlFile());
	        Scene scene = new Scene(rootNode);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle(view.getTitle());
	        primaryStage.show();
	    }
	}
