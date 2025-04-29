/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crudmvcdao;

import Helper.KoneksiDB;
import View.FormMahasiswa;
import javax.swing.SwingUtilities;

/**
 *
 * @author rafaelputra
 */
public class CRUDMVCDAO
    {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        KoneksiDB.getConnection();
        SwingUtilities.invokeLater(() -> {
            FormMahasiswa form = new FormMahasiswa();
            form.setVisible(true);
            form.setLocationRelativeTo(null);
        });
    }
}
