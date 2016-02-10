/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compania_telefonica;

/**
 *
 * @author dpeces
 */

import java.io.*;


public class Compania_telefonica {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException {
        
        String dir = "/Users/dpeces/Desktop/ComTelf/";
        
        FileWriter insertarClientes = new FileWriter(dir+"clientes.txt");
        FileWriter insertarConsumo = new FileWriter(dir+"consumo.txt");
        FileWriter insertarFacturas = new FileWriter(dir+"facturas.txt");
        FileWriter insertarLineas = new FileWriter(dir+"lineas.txt");
        FileWriter insertarMensajes = new FileWriter(dir+"mensajes.txt");
        FileWriter insertarPlanes = new FileWriter(dir+"planes.txt");
        FileWriter insertarVoz = new FileWriter(dir+"voz.txt");
       
        PrintWriter pwi;
        PrintWriter pwi2;
        
        String cadena;
        String cadena2;
        
        //---------- Tabla Clientes ----------
        
        try{
            pwi = new PrintWriter(insertarClientes);
            
            for (int i = 1; i <= 500000; i++) {
                cadena = i+";'nom"+i+"';'ape"+i+"';'dir"+i+"';"+i+"X';'pro"+i+"'";
                pwi.println(cadena);
            }
            
        }catch(Exception e) {
            System.out.println("Error al crear Clientes");
        } finally {
            try {
                    insertarClientes.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar fichero Clientes");
            }
        }
        System.out.println("----- Creada Tabla Clientes -----");
        
        //---------- Consumo ----------
        
        try{
            pwi = new PrintWriter(insertarConsumo);
            int num_lin = 1;
            for (int i = 1; i <= 12000000; i++) {
                cadena = i+";91385656;"+num_lin;
                pwi.println(cadena);
                if(i%24 == 0) num_lin++; 
            }
            
        }catch(Exception e) {
            System.out.println("Error al crear Consumo");
        } finally {
            try {
                    insertarConsumo.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar fichero Consumo");
            }
        }
        System.out.println("----- Creada Tabla Consumo -----");
        
        //---------- Facturas ----------
        
        try{
            pwi = new PrintWriter(insertarFacturas);

            int pvp, iva, total;
            int num_lin = 1;
            int mes=1;
            for (int i = 1; i <= 6000000; i++) {
                
                    pvp = (new Double(Math.random() * 10).intValue()+1)*50;
                    iva = (pvp)-(((pvp)*21)/100);
                    total = pvp+iva;
                    if (mes < 10) {
                            cadena = i+";'lugar"+i+"';"
                            + "'2014-0"+mes+"-28';"
                            + "'2014-0"+mes+"-01';"
                            + "'2014-0"+mes+"-28';"
                            +pvp+";"+iva+";"+total+";"+num_lin;
                    }else
                    {
                            cadena = i+";'lugar"+i+"';"
                            + "'2014-"+mes+"-28';"
                            + "'2014-"+mes+"-01';"
                            + "'2014-"+mes+"-28';"
                            +pvp+";"+iva+";"+total+";"+num_lin;
                    }
                    
                    pwi.println(cadena);
                    mes++;
                    if(mes > 12) {
                        mes = 1; 
                        num_lin++;
                    }
            }
        }catch(Exception e) {
            System.err.println("Error al crear Facturas");
        } finally {
            try {
                    insertarFacturas.close();
            } catch (Exception e) {
                System.err.println("Error al cerrar fichero Facturas");
            }
        }
        System.out.println("----- Creada Tabla Facturas -----");
        
        //---------- Lineas ----------
        
        try{
            pwi = new PrintWriter(insertarLineas);
            
            int plan = 1;
            
            for (int i = 1; i <= 500000; i++) {
                if (plan > 100) plan = 1;
                cadena = i+";"+i+";"+plan+";'2014-01-01'";
                pwi.println(cadena);
                plan ++;
            }
            
        }catch(Exception e) {
            System.out.println("Error al crear Lineas");
        } finally {
            try {
                    insertarLineas.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar fichero Lineas");
            }
        }
        System.out.println("----- Creada Tabla Lineas -----");
        
        
        //---------- Planes_Pecio ----------
        
        try{
            pwi = new PrintWriter(insertarPlanes);
            int cuota = 20;
            for (int i = 1; i <= 100; i++) {
                if (cuota > 100) cuota = 20;
                cadena = i+";'La del_"+cuota+"_"+i+"';"+cuota+";0.18;0;0.15;0.25";
                pwi.println(cadena);
                cuota++;
            }
            
        }catch(Exception e) {
            System.out.println("Error al crear Planes");
        } finally {
            try {
                    insertarPlanes.close();
            } catch (Exception e) {
                System.err.println("Error al cerrar fichero Planes");
            }
        }
        System.out.println("----- Creada Tabla Planes -----");
        
        //---------- Voz y Mensajes ----------
        
        try{
    
            
            pwi = new PrintWriter(insertarVoz);
            pwi2 = new PrintWriter(insertarMensajes);
            int mes=1;
            for (int i = 1; i <= 12000000; i+=2) {
                
                
                if (mes < 10) {
                cadena = i+";'2014-0"+mes+"-01';'2014-0"+mes+"-01';5";
                cadena2 = (i+1)+";'2014-0"+mes+"-01';'SMS';3";
                }else{
                cadena = i+";'2014-"+mes+"-01';'2014-"+mes+"-01';5";
                cadena2 = (i+1)+";'2014-"+mes+"-01';'SMS';3";
                }
                mes++;
                if(mes > 12){ mes = 1;}
                pwi.println(cadena);
                pwi2.println(cadena2);
                
            
            }
            
        }catch(Exception e) {
            System.err.println("Error al crear Voz y Mensajes");
        } finally {
            try {
                    insertarVoz.close();
            } catch (Exception e) {
                System.err.println("Error al cerrar fichero Voz y Mensajes");
            }
        }
        System.out.println("----- Creada Tabla Voz y Mensajes -----");
        
        
    }
    
}
