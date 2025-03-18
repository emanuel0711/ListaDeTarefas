/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listadetarefas2;

import com.mycompany.listadetarefas.model.ConexaoSQLite;
import com.mycompany.listadetarefas.model.CriarTabelas;
import java.sql.Connection;

/**
 *
 * @author emanu
 */
public class ListaDeTarefas2 {

    public static void main(String[] args) {
        ConexaoSQLite connSQLite = new ConexaoSQLite();
        Connection conexao = connSQLite.conectar();
        
        CriarTabelas.criarUsuarios(conexao);
        CriarTabelas.criarTarefas(conexao);
    }
}
