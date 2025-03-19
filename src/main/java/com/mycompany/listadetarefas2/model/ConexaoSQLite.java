/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listadetarefas2.model;

/**
 *
 * @author emanu
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQLite {
    public Connection conectar() {
        // Declara uma variável para armazenar a conexão
        Connection connection = null;
        // Define o caminho do banco de dados SQLite
        String url = "jdbc:sqlite:gerenciadorDeTarefas.db";

        try {
            // Tenta estabelecer a conexão com o banco de dados usando a URL fornecida
            connection = DriverManager.getConnection(url);
            System.out.println("Conexão com SQLite estabelecida!"); // Mensagem de sucesso
        } catch (SQLException e) {
            // Caso ocorra um erro, ele será capturado e exibido
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }

        return connection; // Retorna a conexão estabelecida (ou null se falhou)
    }

    public void desconectar(Connection connection) {
        try {
            // Verifica se a conexão não é nula (ou seja, se está aberta)
            if (connection != null) {
                connection.close(); // Fecha a conexão
                System.out.println("Conexão fechada."); // Mensagem de sucesso
            }
        } catch (SQLException e) {
            // Captura e exibe qualquer erro ao tentar fechar a conexão
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}
