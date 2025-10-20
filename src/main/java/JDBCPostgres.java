import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class JDBCPostgres {
    public static void main(String[] args) {

        try {
            String url = "jdbc:postgresql://localhost:5432/rocket_db";
            Properties props = new Properties();
            props.setProperty("user", "victorciechovicz");
            props.setProperty("password", "postgres");
            //props.setProperty("ssl", "true");
            Connection conn = DriverManager.getConnection(url, props);


            String sql = "INSERT INTO public.tab_cadastro(nome, idade) VALUES(?,?)";
            String nome = "Victor Avila";
            Integer idade = 23;

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2, idade);
            pst.execute();

            System.out.println("Cadastro realizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}


