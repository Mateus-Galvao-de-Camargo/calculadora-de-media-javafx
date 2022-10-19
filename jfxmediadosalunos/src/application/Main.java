package application;
	
import com.mateus.tds.controller.MediaController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Calculo de m�dia!");
			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			
			// Carregando arquivo da tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mateus/tds/view/MediaView.fxml"));
			Parent arquivoXML = loader.load();
			
			// Atribuindo um arquivo XML para uma cena e atribuindo a janela (stage)
			Scene MediaScene = new Scene(arquivoXML);	
			primaryStage.setScene(MediaScene);
			
			// Carregando o controller da cena
			MediaController mediaController = loader.getController();
			
			primaryStage.setOnCloseRequest(e->{

                if (mediaController.onCloseQuery()) {
                    System.exit(0);
                } else {
                    e.consume();
                }
            });
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
