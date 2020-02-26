package com.mycompany.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cuenta {

    static String rutaCuenta= ("/home/jonathan/Documentos/Trabajos/CajeroAutomatico/src/main/resources/cuentas.txt");
    public static List<Tarjeta> textoCuenta;
   static public int i=0,cont=0;

   public static List<Tarjeta> CargarCuenta(){
        List<Tarjeta> Lista = new ArrayList<>();
        FileReader fr = null;
        try {
            fr = new FileReader  (rutaCuenta);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            String[] campos;
            while((linea=br.readLine())!=null){
                campos = linea.split(",");
                Lista.add(new Tarjeta(campos[0],campos[1],campos[2]));
                System.out.println(Arrays.toString(campos));
                cont++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error al abrir archivo");
        }finally{
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return Lista;
    }
    public static void GuardarTxt(List<Tarjeta> L) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(rutaCuenta));
        bw.write("");
        bw.close();
        FileWriter fw = new FileWriter(rutaCuenta,true);
        bw = new BufferedWriter(fw);
        String Fila;
        int lim=L.size();
        for (int i=0;i<lim;i++) {
            Fila = (L.get(i).No_Cuenta + ","+ L.get(i).NIP+","+L.get(i).saldo+"\n");
            bw.write(Fila);
        }
        bw.close();
    }

    public int validarCuenta(String Usuario,String Pass){
        textoCuenta = CargarCuenta();
        for(i=0;i<cont;i++) {
            if (Usuario.equals(textoCuenta.get(i).No_Cuenta) && Pass.equals(textoCuenta.get(i).NIP)) {
                try {
                    Stage op = FXMLLoader.load(getClass().getResource("/Menu.fxml"));
                    op.show();
                    return i;
                } catch (IOException e) {

                }
            }else{

            }
        }
        return -1;
    }
}

