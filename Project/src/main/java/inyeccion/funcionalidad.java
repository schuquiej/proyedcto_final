/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inyeccion;

import java.io.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;


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

    
    
    
    
    

    public boolean actualizarDb(String nombredb) {
        boolean estado = false;
        String carpetaProyecto = "db";
        String nombreArchivo = nombredb + ".txt";

        File carpeta = new File(carpetaProyecto);
        File archivo = new File(carpeta , nombreArchivo);

        try {
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            FileWriter fileWriter = new FileWriter(archivo);
          
            estado = true;

        } catch (IOException e) {
            System.out.println("inyeccion.funcionalidad.escribirDb()" + e);
        }
        return estado;
    }

    public boolean escribirDb(String nombredb , String contenido) {
        boolean estado = false;
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
            estado = true;

        } catch (IOException e) {
            System.out.println("inyeccion.funcionalidad.escribirDb()" + e);
        }
        return estado;
    }

    
    
        public  String generarCodigoAleatorio(int longitud) {
            
            
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  
        SecureRandom random = new SecureRandom();
        StringBuilder codigo = new StringBuilder(longitud);

        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(indice));
        }

        return codigo.toString();
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
            System.out.println(e.toString() );
        }


        return list;
    }

    
    
    public ArrayList<ArrayList<String>> calcularStock() {
        
        
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        
        
        
          funcionalidad funcionalidad = new funcionalidad();

        ArrayList<ArrayList<String>> ordenes = funcionalidad.leerDb("ordenes");
        ArrayList<ArrayList<String>> productos = funcionalidad.leerDb("productos");
                ArrayList<ArrayList<String>> movimientos = funcionalidad.leerDb("movimientos");
        ArrayList<ArrayList<String>> listadoLimpio = new ArrayList<>();

        float ingresos=0;
        float salidas = 0;
        
      
        for (ArrayList<String> row : productos) {
          
            ingresos =0;
            salidas = 0;
            
            

            for (ArrayList<String> movi : movimientos) {
                
                System.out.println("mivimientos "+movi);
                System.out.println(movi.get(3));
                if (movi.get(3).trim().equalsIgnoreCase("INGRESO") ) {
                    
                    System.out.println("ingresos");
                      for (ArrayList<String> orde : ordenes) {
                      
                          if((movi.get(1).trim().equalsIgnoreCase(orde.get(0)) && (row.get(0).trim().equalsIgnoreCase(orde.get(1).trim()))))
                          {
                              System.out.println("ingreso porque encontro un producot nnta");
                              // aca si encuentro la orden *****+++
                              ingresos = ingresos +Float.parseFloat( orde.get(2));
                          }
                          
                          
                      }
                    
                }
                               
                if (movi.get(3).trim().equalsIgnoreCase("SALIDA") && (movi.get(1)).trim().equalsIgnoreCase(row.get(0).trim())) {
                    
                     salidas = salidas +Float.parseFloat( movi.get(4));
                    
                }

      

            }
            ArrayList<String> nuevoListado = new ArrayList<>();
            nuevoListado.add(row.get(0));
            nuevoListado.add(row.get(1));
            nuevoListado.add(""+ingresos);
            nuevoListado.add(""+salidas);
           
            listadoLimpio.add(nuevoListado);
        }

       
        
        
        
        
        return listadoLimpio;
    }

    
    

}
