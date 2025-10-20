import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroRepository {

    private Connection conexao;

    public CadastroRepository() {
        conexao = FabricaConexao.getConexao();
    }

    public void incluir(Cadastro cadastro) {
        try {
            String sql = "INSERT INTO public.tab_cadastro(nome, idade) VALUES(?,?)";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());
            pst.execute();
            System.out.println("Cadastro realizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ;

    public void alterar(Cadastro cadastro) {
        try {
            String sql = "UPDATE tab_cadastro SET nome = ?, idade = ? WHERE id = ?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());
            pst.setInt(3, cadastro.getId());
            pst.execute();
            System.out.println("Cadastro atualizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ;

    public void excluir(Integer id) {
        try {
            String sql = "DELETE FROM public.tab_cadastro WHERE id=?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            System.out.println("Cadastro excluído com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ;

    public List<Cadastro> listarCadastros() {
        List<Cadastro> lista = new ArrayList<>();

        try {
            String sql = "SELECT nome, idade, id FROM public.tab_cadastro";
            PreparedStatement pst = conexao.prepareStatement(sql);

            ResultSet results = pst.executeQuery();

            while (results.next()) {
                Integer id = results.getInt("id");
                String nome = results.getString("nome");
                Integer idade = results.getInt("idade");

                Cadastro cadastro = new Cadastro();
                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);

                lista.add(cadastro);

                System.out.println("Cadastro listado com sucesso!");


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }


}
