package br.com.agenda.factory;


import br.com.agenda.model.Contato;
import br.com.agenda.dao.ContatoDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao  {

    private static String nome = "root";
    private static String senha = "5555";
    private static String url = "jdbc:mysql://localhost:3306/agenda";




    public static Connection conectar() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");



        Connection con = DriverManager.getConnection(url,nome,senha);
        return con;

    }

    public static void main(String[] args) throws Exception {
        Connection con =  null;

        try {
            con = conectar();
            if(con!= null){
                System.out.println("Conexão feita");
            }
        }catch (Exception ex){
            System.out.println("Erro");
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("Conexão fechada");
            con.close();
        }



    }


}
