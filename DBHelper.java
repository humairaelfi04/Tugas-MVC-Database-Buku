/*
 NAMA: HUMAIRA ELFI PUTRI
NIM: 2301093015
KELAS: MI 1C
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Humaira Elfi Putri
 */
public class DBHelper {
    private String url = "jdbc:mysql://localhost/dbmahasiswa";
    private String username = "root";
    private String password = "";
    private Connection con;
    
    public Connection getKoneksi() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url,username,password);
        return con;
    }
    
    public static void main(String[]args){
        DBHelper db = new DBHelper();
        try {
            db.getKoneksi();
            JOptionPane.showMessageDialog(null, "Koneksi OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "koneksi gagal "+ex.getMessage());
        }
    }
}
