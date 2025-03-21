/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listadetarefas;

import com.mycompany.listadetarefas.model.ConexaoDatabase;
import com.mycompany.listadetarefas.model.CriarTabelas;
import com.mycompany.listadetarefas.view.LoginView;
import java.sql.Connection;

/**
 *
 * @author emanu
 */
public class App {

    public static void main(String[] args) {
        Connection conexao = ConexaoDatabase.getConnection();
        
        CriarTabelas.criarUsuarios(conexao);
        CriarTabelas.criarTarefas(conexao);
        
        new LoginView().setVisible(true);
    }
}
