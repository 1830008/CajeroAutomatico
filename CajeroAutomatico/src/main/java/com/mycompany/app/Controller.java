package com.mycompany.app;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.stage.Stage;


import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Controller {



    static List<Tarjeta> ListaVal=new ArrayList<>();

    static int pos;
    public Button btnTerminar = new Button();
    static int i=0;

    @FXML
    public void initialize(){
        if(i==0) {
            ListaVal = Cuenta.CargarCuenta();
        i++;
        }
    }

    public void Volver(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/Menu.fxml"));
        stage.show();
        stage = (Stage) btnVolver.getScene().getWindow();
        stage.close();
    }
    //Retirar
        public TextField txt_Saldo;
        public Button btnRetirar;
        public Button btn100;
        public Button btn200;
        public Button btn500;
        public Button btn1000;
        public TextField txt_MontoRetirar;
        public Button btnContinuar;
        public Button btnBorrar;
        public Button btnVolver;
        public Label lbl_saldo;

    public void Retirar100(ActionEvent actionEvent) throws IOException {
       if(100<ListaVal.get(pos).saldo){
           ListaVal.get(pos).saldo-=100;
           System.out.println(ListaVal.get(pos).saldo);
           JOptionPane.showMessageDialog(null, "Se ha realizado el retiro");
           Stage stage = FXMLLoader.load(getClass().getResource("/Consulta.fxml"));
           stage.show();
           stage = (Stage) btn100.getScene().getWindow();
           stage.close();
       }else{
           JOptionPane.showMessageDialog(null, "No tiene suficiente dinero");
       }

    }

    public void Retirar200(ActionEvent actionEvent) throws IOException {
        if(200<ListaVal.get(pos).saldo){
        ListaVal.get(pos).saldo-=200;
        JOptionPane.showMessageDialog(null, "Se ha realizado el retiro");
        Stage stage = FXMLLoader.load(getClass().getResource("/Consulta.fxml"));
        stage.show();
        stage = (Stage) btn200.getScene().getWindow();
        stage.close();
        }else{
            JOptionPane.showMessageDialog(null, "No tiene suficiente dinero");
        }
    }

    public void Retirar500(ActionEvent actionEvent) throws IOException {
        if(500<ListaVal.get(pos).saldo){
        ListaVal.get(pos).saldo-=500;
        JOptionPane.showMessageDialog(null, "Se ha realizado el retiro");
        Stage stage = FXMLLoader.load(getClass().getResource("/Consulta.fxml"));
        stage.show();
        stage = (Stage) btn500.getScene().getWindow();
        stage.close();
        }else{
            JOptionPane.showMessageDialog(null, "No tiene suficiente dinero");
        }
    }

    public void Retirar1000(ActionEvent actionEvent) throws IOException {
        if (1000<ListaVal.get(pos).saldo){
        ListaVal.get(pos).saldo-=1000;
        JOptionPane.showMessageDialog(null, "Se ha realizado el retiro");
        Stage stage = FXMLLoader.load(getClass().getResource("/Consulta.fxml"));
        stage.show();
        stage = (Stage) btn1000.getScene().getWindow();
        stage.close();
        }else{
            JOptionPane.showMessageDialog(null, "No tiene suficiente dinero");
        }
    }

    public void OtroMonto(ActionEvent actionEvent) {
        txt_MontoRetirar.setEditable(true);
    }
    
    public void Continuar(ActionEvent actionEvent) throws IOException {
        float sal= Float.parseFloat(txt_MontoRetirar.getText());
        if(sal<ListaVal.get(pos).saldo){
        ListaVal.get(pos).saldo-=sal;
        JOptionPane.showMessageDialog(null, "Se ha realizado el retiro");
        Stage stage = FXMLLoader.load(getClass().getResource("/Consulta.fxml"));
        stage.show();
        stage = (Stage) btnContinuar.getScene().getWindow();
        stage.close();
        }else{
            JOptionPane.showMessageDialog(null, "No tiene suficiente dinero");
        }
    }

    public void Borrartxt(ActionEvent actionEvent) {
    }

    //Consulta
    public Button btnGuardar;
    public TextField txt_MontoTransferir;
    public TextField txt_NumCuentaT;
    public Button btnContinuarT;



    public  void GuardarV(){
        float saldo= ListaVal.get(pos).saldo;
        lbl_saldo.setText(String.valueOf(saldo));

    }
    public void SaldoDisponible(ActionEvent actionEvent) {


    }

    public void Retirar(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/Retirar.fxml"));
        stage.show();
        stage = (Stage) btnRetirar.getScene().getWindow();
        stage.close();
    }

    public void Terminar(ActionEvent actionEvent) throws IOException {
        JOptionPane.showMessageDialog(null, "Gracias por confiar en nosotros");
        Stage stage = FXMLLoader.load(getClass().getResource("/Inicio.fxml"));
        stage.show();
        stage = (Stage) btnTerminar.getScene().getWindow();
        stage.close();
    }



    //CambiarNIP
    public PasswordField txt_NIPActual;
    public PasswordField txt_NuevoNIP;
    public PasswordField txt_ConfirmacionNIP;



    public void Guardar(ActionEvent actionEvent) throws IOException {

        String ANIP= (txt_NIPActual.getText());
        String NNIP= (txt_NuevoNIP.getText());
        String CNIP= (txt_ConfirmacionNIP.getText());

        if (ANIP.equals(ListaVal.get(pos).NIP)) {
            if (CNIP.equals(NNIP)) {
                ListaVal.get(pos).NIP = NNIP;
                JOptionPane.showMessageDialog(null, "Se ha guardado su nuevo NIP");
                Cuenta.GuardarTxt(ListaVal);
            } else {
                JOptionPane.showMessageDialog(null, "Los NIP no coinciden");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Su NIP no coincide");
        }
    }



    //Transferencias
    public void ContinuarT(ActionEvent actionEvent) throws IOException {
        String TCuenta= (txt_NumCuentaT.getText());
        float Monto= Float.parseFloat(txt_MontoTransferir.getText());
        int x=ListaVal.size();
        for (int j=0; j<x;j++){
            if(TCuenta.equals(ListaVal.get(j).No_Cuenta)){
                ListaVal.get(j).saldo+=Monto;
                ListaVal.get(pos).saldo-=Monto;
                Cuenta.GuardarTxt(ListaVal);
                JOptionPane.showMessageDialog(null, "Se ha realizado la transferencia");

            }

        }

    }


    //PagoServicios
    public void pagarAgua(ActionEvent actionEvent) {
    }

    public void pagarLuz(ActionEvent actionEvent) {
    }

    public void pagoSaldo(ActionEvent actionEvent) {
    }





    //Ingresar ventanas
    public Button btnConsulta;
    public Button btnTransferencia;
    public Button btnCambiarNIP;
    public Button btnPago;
    public PasswordField pass_NIP;
    public Button btn_Entrar;
    public TextField txt_NumeroCuenta;
    public PasswordField txt_NIP;


    Cuenta Y = new Cuenta();

    @FXML
    public void Ingresar() throws IOException {
        pos =  Y.validarCuenta(txt_NumeroCuenta.getText(), txt_NIP.getText());

        Stage stage = (Stage) btn_Entrar.getScene().getWindow();
            stage.close();
        }



    public void ARetirar(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/Retirar.fxml"));
        stage.show();
        stage = (Stage) btnRetirar.getScene().getWindow();
        stage.close();
    }

    public void Consulta(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/Consulta.fxml"));
        stage.show();
        stage = (Stage) btnConsulta.getScene().getWindow();
        stage.close();


    }

    public void Transferencia(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/Transferencia.fxml"));
        stage.show();
        stage = (Stage) btnTransferencia.getScene().getWindow();
        stage.close();
    }

    public void CambiarNIP(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/CambioNIP.fxml"));
        stage.show();
        stage = (Stage) btnCambiarNIP.getScene().getWindow();
        stage.close();
    }

    public void Pago(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/PagoServicios.fxml"));
        stage.show();
        stage = (Stage) btnPago.getScene().getWindow();
        stage.close();
    }


    public void MostrarSaldo(ActionEvent actionEvent) throws IOException {
        GuardarV();
        Cuenta.GuardarTxt(ListaVal);
    }

    public void PAgua(ActionEvent actionEvent) {

    }
    public Button btn_AAgua;
    public void AAgua(ActionEvent actionEvent) throws IOException {
        Stage stage = FXMLLoader.load(getClass().getResource("/Agua.fxml"));
        stage.show();
        stage = (Stage) btn_AAgua.getScene().getWindow();
        stage.close();
    }
}
