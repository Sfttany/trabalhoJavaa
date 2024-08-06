import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Funcionarios {

    public void createTable() {
        try (Statement statement = BancoDeDados.connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Funcinário ( Nome VARCHAR, telefone INTEGER, cadastro INTEGER )");


        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }


        public void inserirFuncionario(List<String[]> lista) {
            try (PreparedStatement insertStatement = BancoDeDados.connection.prepareStatement("INSERT INTO Funcionarios(Nome, telefone, contratacao) VALUES(?, ?, ?) ")) {
                for (String[] s : lista) {
                    insertStatement.setString(1, s[0]);
                    insertStatement.setString(2, s[1]);
                    insertStatement.setString(3, s[2]);
                    insertStatement.executeUpdate();
                }
                BancoDeDados.connection.commit();
                System.out.println("Funcionário inserido.");
            } catch (SQLException e) {
                System.out.println("Erro ao inserir funcionário: " + e.getMessage());
            }
        }

        public void lerFuncionario(String nomeQuery) {
            try (PreparedStatement selectStatement = BancoDeDados.connection.prepareStatement("SELECT * FROM Funcionario WHERE nome , telefone , contratacao  ")) {
                selectStatement.setString(1, nomeQuery);
                ResultSet resultSet = selectStatement.executeQuery();
                System.out.println("Funcionario");
                String formacao = resultSet.getString("Nome");
                String nome = resultSet.getString("Telefone");
                String aula = resultSet.getString("Contratação");
                System.out.println("Nome: " + nome + ", Telefone: "+ "telefone "+ " , Contratação: "+ "contratacao");
            } catch (SQLException e) {
                System.out.println("Erro ao ler Funcionário: " + e.getMessage());
            }
        }

        public void deleteFuncionario(String nome) {
            try (PreparedStatement deleteStatement = BancoDeDados.connection.prepareStatement("DELETE FROM Professor WHERE Nome = ?")) {
                deleteStatement.setString(1,nome);
                deleteStatement.executeUpdate();
                BancoDeDados.connection.commit();
                System.out.println("Funcionário deletado.");
            } catch (SQLException e) {
                System.out.println("Erro ao deletar funcionário: " + e.getMessage());
            }
        }
    }




