/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listadetarefas.model;

import com.mycompany.listadetarefas2.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author emanu
 */
public class UsuarioDAO {
    private Connection connection;



public boolean createUsuario(String nome, String senha) throws Exception {
        String sql = "INSERT INTO users (nome, senha) VALUES (?, ?)";

        try ( PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, senha);

            pstmt.executeUpdate();

            System.out.println("Usuário Inserido com sucesso");
        } catch (Exception e) {
            throw new Exception("Erro ao inserir usuário" + e.getMessage());
        }
        return true;
    }	
    public Usuario getUsuario(String name) throws Exception {
        String sql = "SELECT * FROM users WHERE name = ?";

        Usuario user = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) { // Verifica se há resultados antes de acessar os valores
                user = new Usuario(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("hashedPassword")
                );
            } else {
                throw new Exception("Usuário não foi encontrado");
            }
        } catch (Exception e) {
            throw new Exception("Erro ao obter usuário " + name + ": " + e.getMessage());
        }

        return user;
    }
}
