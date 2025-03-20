/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listadetarefas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author emanu
 */

public class TarefaDAO {
    private Connection connection;

    public TarefaDAO() {
        this.connection = ConexaoSQLite.conectar();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        String sql = "INSERT INTO tarefas (titulo, descricao, dataVencimento) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getDataVencimento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar tarefa: " + e.getMessage());
        }
    }
}

    

