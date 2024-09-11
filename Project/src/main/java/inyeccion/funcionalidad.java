/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inyeccion;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author sergi
 */
public class funcionalidad {


    public boolean validarUsuario(String contra , String usuario) {

        boolean autorizado = false;
        if ("sergio".equals(contra) && "sergio".equals(usuario)) {
            autorizado = true;
        }
        return autorizado;

    }


    public void crearDb() {
        String carpetaProyecto = "db";
        String nombreArchivo = "db_const.txt";
        File archivo = new File(carpetaProyecto , nombreArchivo);
        File carpeta = new File(carpetaProyecto);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {

                if (!carpeta.exists()) {
                    carpeta.mkdirs();
                }

                archivo = new File(carpetaProyecto , linea + ".txt");
                if (archivo.createNewFile()) {
                    System.out.println("Archivo creado exitosamente: " + archivo.getAbsolutePath());
                } else {
                    System.out.println("El archivo ya existe.");
                }
            }

        } catch (IOException e) {
        }
    }


    public void escribirDb(String nombredb , String contenido) {
        String carpetaProyecto = "db";
        String nombreArchivo = nombredb + ".txt";

        File carpeta = new File(carpetaProyecto);
        File archivo = new File(carpeta , nombreArchivo);

        try {
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            FileWriter fileWriter = new FileWriter(archivo , true);
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(contenido);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
        }
    }


    public ArrayList<ArrayList<String>> leerDb(String nombredb) {
        String carpetaProyecto = "db";
        String nombreArchivo = nombredb + ".txt";

        File carpeta = new File(carpetaProyecto);
        File archivo = new File(carpeta , nombreArchivo);

        ArrayList<ArrayList<String>> list = new ArrayList<>();


        try (FileInputStream fis = new FileInputStream(archivo); InputStreamReader isr = new InputStreamReader(fis); BufferedReader br = new BufferedReader(isr)) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] dataArray = new String[0];
                dataArray = line.split(",");
                ArrayList<String> row1 = new ArrayList<>(Arrays.asList(dataArray));
                list.add(row1);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return list;
    }


}
