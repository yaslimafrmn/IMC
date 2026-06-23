package org.example.monitoramento;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtAltura;

    @FXML
    private TableView<Usuario> tabela;

    @FXML
    private TableColumn<Usuario, String> colNome;

    @FXML
    private TableColumn<Usuario, String> colEmail;

    @FXML
    private TableColumn<Usuario, Double> colImc;

    private final ObservableList<Usuario> lista =
            FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));

        colEmail.setCellValueFactory(
                new PropertyValueFactory<>("email"));

        colImc.setCellValueFactory(
                new PropertyValueFactory<>("imc"));

        tabela.setItems(lista);
    }

    @FXML
    public void calcularAdicionar(ActionEvent event) {

        try {

            String nome = txtNome.getText();
            String email = txtEmail.getText();

            double peso =
                    Double.parseDouble(txtPeso.getText());

            double altura =
                    Double.parseDouble(txtAltura.getText());

            double imc = peso / (altura * altura);

            imc = Math.round(imc * 10) / 10.0;

            Usuario usuario =
                    new Usuario(nome, email, imc);

            lista.add(usuario);

            txtNome.clear();
            txtEmail.clear();
            txtPeso.clear();
            txtAltura.clear();

        } catch (Exception e) {
            System.out.println("Erro ao calcular IMC.");
        }
    }
}