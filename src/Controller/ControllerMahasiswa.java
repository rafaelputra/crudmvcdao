/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author rafaelputra
 */

import DAO.DAOMahasiswa;
import DAOInterface.IMahasiswa;
import Model.Mahasiswa;
import Model.TabelModelMahasiswa;
import View.FormMahasiswa;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerMahasiswa
    {
        FormMahasiswa frame;
        IMahasiswa implMahasiswa;
        List<Mahasiswa> lb;
        
        public ControllerMahasiswa(FormMahasiswa frame){
            this.frame = frame;
            implMahasiswa = new DAOMahasiswa();
            lb = implMahasiswa.getAll();
        }
        
        public void reset(){
            frame.getTxtID().setText("");
            frame.getTxtNim().setText("");
            frame.getTxtNama().setText("");
            frame.getTxtJk().setSelectedItem("");
            frame.getTxtAlamat().setText("");
        }
        
        public void isiTable(){
            lb = implMahasiswa.getAll();
            TabelModelMahasiswa tmb = new TabelModelMahasiswa(lb);
            frame.getTabelData().setModel(tmb);
        }
        
        public void isiField(int row){
            frame.getTxtID().setText(lb.get(row).getId().toString());
            frame.getTxtNim().setText(lb.get(row).getNim());
            frame.getTxtNama().setText(lb.get(row).getNama());
            frame.getTxtJk().setSelectedItem(lb.get(row).getJk());
            frame.getTxtAlamat().setText(lb.get(row).getAlamat());
        }
        
        public void insert(){
            if (!frame.getTxtNim().getText().trim().isEmpty() & !frame.getTxtNama().getText().trim().isEmpty()){
                Mahasiswa b = new Mahasiswa();
                b.setId(Integer.parseInt(frame.getTxtID().getText()));
                b.setNim(frame.getTxtNim().getText());
                b.setNama(frame.getTxtNama().getText());
                b.setJk(frame.getTxtJk().getSelectedItem().toString());
                b.setAlamat(frame.getTxtAlamat().getText());
                implMahasiswa.insert(b);
                JOptionPane.showMessageDialog(null, "Simpan Data sukses");  
            } else {
                JOptionPane.showMessageDialog(frame, "Data Tidak Boleh Kosong");
            }
        }
        public void delete(){
            if (!frame.getTxtID().getText().trim().isEmpty()){
                int id = Integer.parseInt(frame.getTxtID().getText());
                implMahasiswa.delete(id);
                JOptionPane.showMessageDialog(null, "Hapus data sukses");
            } else {
                JOptionPane.showMessageDialog(frame, "Pilih data yang akan dihapus");
            }
        }
        
        public void update(){
            if (!frame.getTxtID().getText().trim().isEmpty()){
                Mahasiswa b = new Mahasiswa();
                b.setNim(frame.getTxtNim().getText());
                b.setNama(frame.getTxtNama().getText());
                b.setJk(frame.getTxtJk().getSelectedItem().toString());
                b.setAlamat(frame.getTxtAlamat().getText());
                b.setId(Integer.parseInt(frame.getTxtID().getText()));
                implMahasiswa.update(b);
                JOptionPane.showMessageDialog(null, "Update Data sukses");  
            } else {
                JOptionPane.showMessageDialog(frame, "Pilih data yang akan di ubah");
            }
        }
        
        public void isiTableCariNama(){
            lb = implMahasiswa.getCariNama(frame.getTxtCariNama().getText());
            TabelModelMahasiswa tmb = new TabelModelMahasiswa(lb);
            frame.getTabelData().setModel(tmb);
        }
        
        public void carinama(){
            if (!frame.getTxtCariNama().getText().trim().isEmpty()){
                implMahasiswa.getCariNama(frame.getTxtCariNama().getText());
                isiTableCariNama();
            } else {          
                JOptionPane.showMessageDialog(frame, "SILAHKAN PILIH DATA");
            }
        }
    }
