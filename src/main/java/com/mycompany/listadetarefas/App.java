/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listadetarefas;

import com.mycompany.listadetarefas.model.CriarTabelas;
import java.sql.Connection;

/**
 *
 * @author emanu
 */
public class App {

    public static void main(String[] args) {
        ConexaoSQLite connSQLite = new ConexaoSQLite();
        Connection conexao = connSQLite.conectar();
        
        CriarTabelas.criarUsuarios(conexao);
        CriarTabelas.criarTarefas(conexao);
    }
}
