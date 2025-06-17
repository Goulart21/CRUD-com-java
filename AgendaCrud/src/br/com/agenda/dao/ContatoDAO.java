package br.com.agenda.dao;

import br.com.agenda.factory.Conexao;
import br.com.agenda.model.Contato;

import java.sql.*;

/**
 *
 */

public class ContatoDAO {

    public void save(Contato contato) throws SQLException {

        String sql = "INSERT INTO contatos (nome,idade,dataCadastro) VALUES (?,?,?)";

        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.conectar();
            pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setString(1, contato.getNome());
            pstm.setInt(2,contato.getIdade());
            pstm.setDate(3,contato.getDataCadastro());
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(Contato contato){

        String sql = "DELETE FROM contatos WHERE id = ?";

        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.conectar();
            pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setInt(1,contato.getId());
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void update(Contato contato){
        String sql = "UPDATE contatos set nome = ? , idade = ?, dataCadastro = ? WHERE id = ?";

        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.conectar();
            pstm = (PreparedStatement) con.prepareStatement(sql);

            pstm.setString(1, contato.getNome());
            pstm.setInt(2,contato.getIdade());
            pstm.setDate(3,contato.getDataCadastro());
            pstm.setInt(4,contato.getId());
            pstm.execute();
            System.out.println("Alteração feita com sucesso");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void read() {
        String sql = "SELECT * FROM contatos";

        try (Connection con = Conexao.conectar();
             PreparedStatement pstm = con.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                Date date = rs.getDate("dataCadastro");
                System.out.println("ID: " + id + ", Nome: " + nome + ", Data de cadastro: " + date);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
