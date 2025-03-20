/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listadetarefas.controller;


import com.mycompany.listadetarefas.model.Usuario;
import com.mycompany.listadetarefas.model.UsuarioDAO;

/**
 *
 * @author emanu
 */
public class UsuarioController {
        private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    
    }
    
       public String adicionarUsuario(String nome, String email, String senha) {
        try {
            usuarioDAO.adicionarUsuario(new Usuario(nome, email, senha));
            return "Usuario adicionado com sucesso";
        } catch (NumberFormatException e) {
            return "Erro" + e.getMessage();
        }
    }
}
