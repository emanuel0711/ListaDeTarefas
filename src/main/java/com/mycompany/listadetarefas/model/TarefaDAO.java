package com.mycompany.listadetarefas.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {
    private final Connection connection;

    public TarefaDAO(Connection connection) {
        this.connection = connection;
    }

    public void criarTarefa(Tarefa tarefa, Integer usuarioId) throws Exception {
        String sql = "INSERT INTO tarefas (titulo, descricao, data_vencimento, status, usuario_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getDataVencimento());
            stmt.setString(4, tarefa.getStatus());
            if (usuarioId != null) {
                stmt.setInt(5, usuarioId);
            } else {
                stmt.setNull(5, Types.INTEGER);
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("ERRO AO CRIAR TAREFA: " + e.getMessage());
        }
    }

    public List<Tarefa> listarTarefasDoUsuario(int usuario_id) throws Exception {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM tarefas WHERE usuario_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, usuario_id);
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Tarefa tarefa = new Tarefa(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("descricao"),
                            rs.getString("status"),
                            rs.getString("data_vencimento")
                    );
                    tarefas.add(tarefa);
                }
            }
        } catch (SQLException e) {
            throw new Exception("ERRO AO LISTAR TAREFAS: " + e.getMessage());
        }
        return tarefas;
    }

    public void atualizarTarefa(Tarefa tarefa) throws Exception {
        String sql = "UPDATE tarefas SET titulo = ?, descricao = ?, data_vencimento = ?, status = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getDataVencimento());
            stmt.setString(4, tarefa.getStatus());
            stmt.setInt(5, tarefa.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("ERRO AO ATUALIZAR TAREFA: " + e.getMessage());
        }
    }

    public void atualizarStatusTarefa(String status, int id) throws Exception {
        String sql = "UPDATE tarefas SET status = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("ERRO AO ATUALIZAR TAREFA: " + e.getMessage());
        }
    }



    public void excluirTarefa(int id) throws Exception {
        String sql = "DELETE FROM tarefas WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("ERRO AO EXCLUIR TAREFA: " + e.getMessage());
        }
    }

    public Tarefa obterTarefaPeloID(int id) throws Exception {
        String sql = "SELECT * FROM usuarios WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Tarefa(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("descricao"),
                            rs.getString("status"),
                            rs.getString("data_vencimento")
                    );
                }
            }
        } catch (SQLException e) {
            throw new Exception("ERRO AO OBTER TAREFA PELO ID: " + e.getMessage());
        }
        return null;
    }
}
