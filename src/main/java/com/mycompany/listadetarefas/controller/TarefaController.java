/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listadetarefas.controller;

import com.mycompany.listadetarefas.model.ConexaoDatabase;
import com.mycompany.listadetarefas.model.Tarefa;
import com.mycompany.listadetarefas.model.TarefaDAO;

/**
 *
 * @author emanu
 */
public class TarefaController {


    private final TarefaDAO tarefaDAO;

    public TarefaController() {
        this.tarefaDAO = new TarefaDAO(ConexaoDatabase.getConnection());
    }

    public void criarTarefa(String titulo, String descricao, String dataVencimento, int usuarioId) throws Exception {
        if (titulo.isEmpty()) {
            throw new Exception("O título da tarefa não pode estar vazio");
        }
        Tarefa tarefa = new Tarefa(titulo, descricao, dataVencimento);
        tarefaDAO.criarTarefa(tarefa, usuarioId);
    }

    public void atualizarStatusTarefa(int id, String novoStatus) throws Exception {
        if (!novoStatus.equals("pendente") && !novoStatus.equals("concluido")) {
            throw new Exception("Status inválido. Use 'pendente' ou 'concluido'");
        }
        tarefaDAO.atualizarStatusTarefa(novoStatus, id);
    }
}
