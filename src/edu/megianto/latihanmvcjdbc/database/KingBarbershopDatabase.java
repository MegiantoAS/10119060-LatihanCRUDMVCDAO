/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.megianto.latihanmvcjdbc.database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.megianto.latihanmvcjdbc.impl.PelangganDaoImpl;
import edu.megianto.latihanmvcjdbc.service.PelangganDao;
import java.sql.SQLException;

/**
 *
@author Megianto Adi saputra
 * Nama         : Megianto Adi Saputra
 * Kelas        : IF-2
 * NIM          : 10119060
 * membuat Koneksi
 */
public class KingBarbershopDatabase {
    private static Connection connection;
    private static PelangganDao pelangganDao;
    
    public static Connection getConnection() throws SQLException{
        if (connection==null){
            
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/kingsbarbershop");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = (Connection) dataSource.getConnection();
            
            
        }
       return connection; 
    }
  public static PelangganDao getpelangganDao() throws SQLException{
      if (pelangganDao==null){
          pelangganDao = new PelangganDaoImpl(getConnection());
          
      }
      return pelangganDao;
  }
}
