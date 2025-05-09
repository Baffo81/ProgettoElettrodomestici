package org.brunasso_elettrodomestici;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AdminController implements Initializable {

    @FXML
    public TextField productCode,
    productName,
    productDescription,
    productPrice,
    productMarca,
    productCategoria,
    productQuantity,
    productSale,
    productFornitore;

    @FXML
    public Text addProductError;

    @FXML
    public Button VisualizzaAggiungi,
            VisualizzaScorteRicambiPercentualeVendita,
            addProductButton,
           backToAdminMenuButton;

    private final AdminModel model;                      // reference to Model
    public AdminController() { // constructor
        model = AdminModel.getInstance(); // initializes the model
    }

    @FXML
    private void VisualizzaMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("amministratore_menu.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = (Stage) VisualizzaAggiungi.getScene().getWindow();
        stage.setScene(scene);
        stage.setMaximized(true); // sets fullscreen
        stage.show(); // shows the interface
    }

    @FXML
    private void VisualizzaAggiungiRicambio() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("inserimento_prodotto.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = (Stage) VisualizzaAggiungi.getScene().getWindow();
        stage.setScene(scene);
        stage.setMaximized(true); // sets fullscreen
        stage.show(); // shows the interface
    }

    @FXML
    private void showMenuAdministrator() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("amministratore_menu.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = (Stage) productName.getScene().getWindow();
        stage.setScene(scene);
        stage.setMaximized(true); // sets fullscreen
        stage.show(); // shows the interface
    }

    @FXML
    private void VisualizzaPrezzi() {

    }

    @FXML
    private void initializeLoginInterfaceElements(Scene scene) { // initializes LoginInterface's elements
        VisualizzaAggiungi = (Button) scene.lookup("#VisualizzaAggiungi");
        VisualizzaScorteRicambiPercentualeVendita = (Button) scene.lookup("#viewSparePartsButton");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void addProductHandler() {
        int codice = Integer.parseInt(productCode.getText());
        String nome = productName.getText();
        String descrizione = productDescription.getText();
        String prezzo = productPrice.getText();
        String marca = productMarca.getText();
        String categoria = productCategoria.getText();
        String quantita = productQuantity.getText();
        int sconto = Integer.parseInt(productSale.getText());
        String fornitore = productFornitore.getText();
        if (nome.isEmpty() || descrizione.isEmpty() || prezzo.isEmpty() || marca.isEmpty() || categoria.isEmpty() || quantita.isEmpty() || fornitore.isEmpty() || productCode.getText().isEmpty() || productSale.getText().isEmpty()) {
            addProductError.setText("Alcuni campi sono mancanti");
            addProductError.setEffect(new DropShadow());
        } else {
            model.addProduct(codice, nome, descrizione, prezzo, marca, categoria, quantita, sconto, fornitore);
            productCode.setText("");
            productName.setText("");
            productDescription.setText("");
            productPrice.setText("");
            productMarca.setText("");
            productCategoria.setText("");
            productQuantity.setText("");
            productSale.setText("");
            productFornitore.setText("");
        }
    }
}
