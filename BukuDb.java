/*
NAMA: HUMAIRA ELFI PUTRI
NIM: 2301093015
KELAS: MI 1C
 */
package Dao;

import IRA30052024.model.Buku;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Humaira Elfi Putri
 */
public class BukuDb {
    public void insert (Buku buku) throws Exception {
        DBHelper db = new DBHelper();
        String query = "insert into buku values (?,?,?,?,?)";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        ps.setString(1, buku.getKodeBuku());
        ps.setString(2, buku.getJudul());
        ps.setString(3, buku.getPengarang());
        ps.setString(4, buku.getPenerbit());
        ps.setString(5, buku.getTahun());
        ps.executeUpdate();
    }
    
    public void update (Buku buku) throws Exception {
        DBHelper db = new DBHelper();
        String query = "update buku set tahun =?, pengarang=? "
                + "penerbit=?, tahun=? where kodebuku=?";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        ps.setString(1, buku.getKodeBuku());
        ps.setString(2, buku.getJudul());
        ps.setString(3, buku.getPengarang());
        ps.setString(4, buku.getPenerbit());
        ps.setString(5, buku.getTahun());
        ps.executeUpdate();
    }
    
    public void delete(String kodebuku) throws Exception {
        DBHelper db = new DBHelper();
        String query = "delete from buku where kodebuku = ?";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        ps.setString(1, kodebuku);
        ps.executeUpdate();
    }
    
    public Buku getBuku (String kodebuku) throws Exception {
        DBHelper db = new DBHelper();
        String query = "select * from buku where kodebuku=?";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        ps.setString(1, kodebuku);
        Buku buku = null;
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            buku = new Buku();
            buku.setKodeBuku(rs.getString(1));
            buku.setJudul(rs.getString(2));
            buku.setPengarang(rs.getString(3));
            buku.setPenerbit(rs.getString(4));
            buku.setTahun(rs.getString(5));
        }
        return buku;
    }
    
    public List<Buku> getAllBuku() throws Exception{
        DBHelper db = new DBHelper();
        String query = "select * from buku";
        PreparedStatement ps = db.getKoneksi().prepareStatement(query);
        List<Buku> list = new ArrayList();
        Buku buku = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            buku = new Buku();
            buku.setKodeBuku(rs.getString(1));
            buku.setJudul(rs.getString(2));
            buku.setPengarang(rs.getString(3));
            buku.setPenerbit(rs.getString(4));
            buku.setTahun(rs.getString(5));
            list.add(buku);
        }
        return list;
    }
}
