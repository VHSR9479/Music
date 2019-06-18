/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.GregorianCalendar;
import bddMusic.conector;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author victorhugo
 */
public class Encriptacion {

    String contraseña = "c2e0d9b2d35353fdc17be6be0e82897d";
    String encriptado;
    conector conec;

    public Encriptacion(conector c) throws InterruptedException {
        conec = c;

        tiempoEspera();
    }

    public void tiempoEspera() throws InterruptedException {
        int minuto, hora;
        verificarContraseña();
        verDia();
        do {
            Calendar calendar = new GregorianCalendar();
            minuto = calendar.get(Calendar.MINUTE);
            hora = calendar.get(Calendar.HOUR);

            if (hora == 3 && minuto == 01) {
//                encriptado = DigestUtils.md2Hex(contraseña);
                contraseña = encriptado;
                conec.StartQuery("update contra set contraFinal='" + contraseña + "'  where cod_contra=1");
                System.out.println("mensaje: " + contraseña + "\nencriptado: " + encriptado);

            }
            System.err.println("multiplo" + (minuto % 2) + " hora: " + hora + " minuto: " + minuto + "\n " + contraseña);
            Thread.sleep(100000);
        } while (true);

    }

    public void verDia() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            SimpleDateFormat sdfa = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaActual = new Date();
            String fechaConFormato = sdf.format(fechaActual);
            conec.StartQuery("select fechaInicial from contra where cod_contra=1");
            String[] fech = conec.SacarQuery("fechaInicial", 1);

            String dia = fech[0].substring(5, 7);
            String mes = fech[0].substring(8, 10);
            String año = fech[0].substring(0, 4);
            System.out.println("esta fecha: " + fech[0] + "\n " + dia + "-" + mes + "-" + año);

            Date nuevaFecha = sdf.parse(mes + "-" + dia + "-" + año);

            System.out.println("nueva fecha:" + nuevaFecha.toString() + "\n Fecha Hoy:" + fechaActual);
            contarFecha(nuevaFecha, fechaActual);
        } catch (ParseException pe) {
        }
    }

    public void contarFecha(Date fechaInicio, Date fechaFinal) {

        Calendar FechaIni = Calendar.getInstance();
        FechaIni = new GregorianCalendar();
        FechaIni.setTime(fechaInicio);
        Calendar FechaFin = Calendar.getInstance();
        FechaFin = new GregorianCalendar();
        FechaFin.setTime(fechaFinal);
        int i = 0;

        while (FechaIni.before(FechaFin) || FechaIni.equals(FechaFin)) {

            System.out.println("fecha Fin " + FechaFin.getTime() + " fecha ini" + FechaIni.getTime());
            System.out.println(i++);

            FechaIni.add(Calendar.DATE, 1);
        }
        i=i-1;
JOptionPane.showMessageDialog(null, " fecha ini " + fechaInicio.toString()+"\nfecha Fin  " + fechaFinal.toString()
                                       +"\ncontraseña final "+contraseña+"\n cantidad de dias "+i);
conec.StartQuery("update contra set diascontra="+i+" where cod_contra=1");
    }

    public void verificarContraseña() {
        conec.StartQuery("select contrainicial from contra");
        String[] resultado = conec.SacarQuery("contrainicial", 1);
        JOptionPane.showMessageDialog(null, resultado[0]);

    }

    public static void main(String[] args) throws InterruptedException, SQLException {
        conector c;
        c = new conector();

        new Encriptacion(c);
    }
}
