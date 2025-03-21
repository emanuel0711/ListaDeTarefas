/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listadetarefas.controller;


import com.mycompany.listadetarefas.model.ConexaoDatabase;
import com.mycompany.listadetarefas.model.Usuario;
import com.mycompany.listadetarefas.model.UsuarioDAO;


public class UsuarioController {
    private final UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO(ConexaoDatabase.getConnection());
    }

    public void criarUsuario(String nome, String senha) throws Exception {
        if (nome.isEmpty() || senha.isEmpty()) {
            throw new IllegalArgumentException("Nome, email e senha não podem estar vazios");
        }
        Usuario usuario = new Usuario(nome, senha);
        usuarioDAO.criarUsuario(usuario);
    }

    public Usuario obterUsuarioPeloNome(String nome) throws Exception {
        return usuarioDAO.obterUsuarioPeloNome(nome);
    }
    
    public Usuario login(String username, String password) throws Exception {
            Usuario usuario = usuarioDAO.obterUsuarioPeloNome(username);
            if (usuario== null) {
                throw new Exception("Esse usuário não existe");
            }
            if (!usuario.getSenha().equals(password)) {
                throw new Exception("Senha incorreta");
            }
            
            return usuario;
    }
}
