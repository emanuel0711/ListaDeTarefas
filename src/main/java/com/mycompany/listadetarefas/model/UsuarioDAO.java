package com.mycompany.listadetarefas.model;

import java.sql.*;

public class UsuarioDAO {
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void criarUsuario(Usuario usuario) throws Exception {
        String sql = "INSERT INTO usuarios (nome, senha) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("ERRO AO CRIAR USUÁRIO PELO ID: " + e.getMessage());
        }
    }

    public Usuario obterUsuarioPeloNome(String nome) throws Exception {
        String sql = "SELECT * FROM usuarios WHERE nome = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("senha")
                    );
                }
            }
        } catch (SQLException e) {
            throw new Exception("ERRO AO OBTER USUÁRIO PELO ID: " + e.getMessage());
        }
        return null;
    }
}
