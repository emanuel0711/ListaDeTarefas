/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listadetarefas.model;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author emanu
 */
public class CriarTabelas {
    public static void criarUsuarios(Connection connection) {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT UNIQUE NOT NULL,"+
                "senha TEXT NOT NULL)";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso");
        } catch(Exception e) {
            System.out.println("Erro ao criar tabela" + e.getMessage());
        }
    }
    
    public static void criarTarefas(Connection connection) {
        String sql = "CREATE TABLE tarefas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo TEXT NOT NULL," +
                " descricao TEXT," +
                " data_vencimento TEXT," +
                " status DEFAULT 'pendente'," +
                " usuario_id INTEGER," +
                " FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE);";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso");
        } catch(Exception e) {
            System.out.println("Erro ao criar tabela" + e.getMessage());
        }
    }
}
