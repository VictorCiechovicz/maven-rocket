import java.util.ArrayList;
import java.util.List;

public class SistemaCadastro {

    public static void main(String[] args) {
        FabricaConexao.conectar();

        CadastroRepository cadastroRepository = new CadastroRepository();
        Cadastro cadastro = new Cadastro();

        // Incluir
       /* cadastro.setNome("Victor Ciechovicz");
        cadastro.setIdade(30);
        cadastroRepository.incluir(cadastro);
        */

        // Atualizar
       /* cadastro.setId(1);
        cadastro.setNome("Victor Ciechovicz");
        cadastro.setIdade(30);
        cadastroRepository.alterar(cadastro);
*/

        // Excluir
        // cadastroRepository.excluir(1);

        //Listar todos
       /* List<Cadastro> lista = cadastroRepository.listarCadastros();
        for (Cadastro c : lista) {
            System.out.println("ID:" + c.getId() + " Nome:" + c.getNome());
        }
*/
        //Listar por id
        Cadastro resp = cadastroRepository.buscar(3);
        System.out.println("ID:" + resp.getId() + " Nome:" + resp.getNome());


    }
}
