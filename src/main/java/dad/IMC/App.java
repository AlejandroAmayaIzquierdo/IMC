package dad.IMC;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;

public class App extends Application {
	
	private VBox root;
	private HBox pesoRoot,alturaRoot;
	
	TextField pesoTextField,alturaTextField;
	
	Label peso,kg;
	Label altura,cm;
	Label imc;
	Label resultado;
	
	
	DoubleProperty imcValue;
	DoubleProperty pesoValue;
	DoubleProperty alturaValue;
	
	
	NumberStringConverter nsc = new  NumberStringConverter() {
		@Override
		public Number fromString(String value) {
			try {
				return super.fromString(value);
			} catch (Exception e) {
				return 0;
			}
		}
	};
	
	

	@Override
	public void start(Stage stage) throws Exception {
		
		initUI();
		
		binding();
		
		Scene scene = new Scene(root,400,200);
		
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
	}
	public void initUI() {
		peso = new Label("Peso:");
		kg = new Label("Kg");
		
		pesoTextField = new TextField();
		pesoTextField.setPromptText("Introduce tu peso");
		
		
		pesoRoot = new HBox();
		pesoRoot.getChildren().addAll(peso,pesoTextField,kg);
		pesoRoot.setAlignment(Pos.CENTER);
		pesoRoot.setSpacing(5);
		
		altura = new Label("Altura:");
		cm = new Label("cm");
		
		alturaTextField = new TextField();
		alturaTextField.setPromptText("Introduce tu Altura");
		
		alturaRoot = new HBox();
		alturaRoot.getChildren().addAll(altura,alturaTextField,cm);
		alturaRoot.setAlignment(Pos.CENTER);
		alturaRoot.setSpacing(5);
		
		imc = new Label("IMC: ");
		resultado = new Label("");
		
		
		root = new VBox();
		root.getChildren().addAll(pesoRoot,alturaRoot,imc,resultado);
		root.setFillWidth(false);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(5);
	}
	
	public void binding() {
		pesoValue = new SimpleDoubleProperty();
		alturaValue = new SimpleDoubleProperty();
		imcValue = new SimpleDoubleProperty();
		pesoTextField.textProperty().bindBidirectional(pesoValue,nsc);	
		alturaTextField.textProperty().bindBidirectional(alturaValue,nsc);
		
		DoubleExpression alturaMetros = alturaValue.divide(100);
		
		imcValue.bind(pesoValue.divide(alturaMetros.multiply(alturaMetros)));
		
		imcValue.addListener((o,ov,nv) -> {
			if(nv.doubleValue() != Double.POSITIVE_INFINITY) {
				String newValue = String.format("%.2f", nv.doubleValue());
				imc.setText("IMC: " + newValue);
				resultado.setText(IMC.getIMC(nv.doubleValue()).toString());
			}
		});
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	

}
