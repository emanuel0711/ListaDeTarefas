/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listadetarefas.controller;

import com.mycompany.listadetarefas.model.Tarefa;
import com.mycompany.listadetarefas.model.TarefaDAO;

/**
 *
 * @author emanu
 */
public class TarefaController {
        private TarefaDAO tarefaDAO;
    int idTarefa = 0;

    public TarefaController() {
        this.tarefaDAO = new TarefaDAO();
    
    }
    
       public String adicionarTarefa(String titulo, String descricao, String dataVencimento) {
        try {
            tarefaDAO.adicionarTarefa(new Tarefa(titulo, descricao, dataVencimento));
            return "Tarefa adicionada com sucesso";
        } catch (NumberFormatException e) {
            return "Erro" + e.getMessage();
        }
    }
}
