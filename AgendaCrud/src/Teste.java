import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

import java.sql.Date;
import java.sql.SQLException;

public class Teste {
    public static void main(String[] args)  {
        Contato gabi = new Contato(1,"MA",18, Date.valueOf("2007-02-13"));

        ContatoDAO dao = new ContatoDAO();


        try {
            dao.read();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }


    }
}
