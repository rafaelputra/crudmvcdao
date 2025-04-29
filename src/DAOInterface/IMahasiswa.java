/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOInterface;

/**
 *
 * @author rafaelputra
 */

import java.util.List;
import Model.Mahasiswa;

public interface IMahasiswa
    {
        public void insert(Mahasiswa b);
        public void delete(int id);
        public List<Mahasiswa> getAll();
    }
