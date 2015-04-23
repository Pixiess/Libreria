/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Veymar Montaño Colqu
 */
public class ConexionPostgresql {
    private static Connection conexion;
    private static Statement sentencia;

    public static final String DRIVER = "org.postgresql.Driver";
    public static final String DBURL = "jdbc:postgresql://localhost:5432/LibroVenta";
    public static final String USER = "postgres";
    public static final String PASSWORD = "postgres";

    public static Connection createConnection() {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager
                    .getConnection(DBURL, USER, PASSWORD);

            if (conexion != null) {
                System.out.println("Conexion exitosa!");
            } else {
                System.out.println("Conexion fallida!");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            JOptionPane.showMessageDialog(new Frame(),
                    "Error con la Base de Datos", "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return conexion;
    }

    /**
     * Executes the given SQL statement, which may be an INSERT, UPDATE, or
     * DELETE statement or an SQL statement that returns nothing, such as an SQL
     * DDL statement.
     *
     * @param sql
     * @return True if everything went well
     */
    public static boolean updateDB(String sql) {
        try {
            sentencia = createConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Executes the given SQL statement, which is a Select statement
     *
     * @param sql
     * @return
     */
    public static ResultSet consultar(String sql) {
        ResultSet resultado = null;
        try {
            sentencia = createConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La consulta fallo");
            return null;
        }
        System.out.println("La consulta Fue Exitosa");
        return resultado;
    }

    public Connection getConexion() {
        return conexion;
    }
}
