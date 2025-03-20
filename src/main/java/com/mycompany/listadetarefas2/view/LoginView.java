package com.mycompany.listadetarefas2.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class LoginView extends javax.swing.JFrame {

    private static List<String[]> usuariosRegistrados = new ArrayList<>();

    public LoginView() {
        initComponents();
        setLocationRelativeTo(null); // Centraliza a janela
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botaoLogin = new javax.swing.JButton();
        campoSenha = new javax.swing.JPasswordField();
        botaoRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Usuário");

        jLabel2.setText("Senha");

        botaoLogin.setText("Login");

        campoSenha.setText("jPasswordField1");

        botaoRegistrar.setText("Registrer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoUsuario)
                    .addComponent(botaoLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(botaoRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(botaoLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoRegistrar)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
                    
     private void botaoLoginActionPerformed(ActionEvent evt) {
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());

        // Verifica se o usuário e senha correspondem a um usuário registrado
        boolean loginValido = false;
        for (String[] user : usuariosRegistrados) {
            if (user[0].equals(usuario) && user[1].equals(senha)) {
                loginValido = true;
                break;
            }
        }

        if (loginValido) {
            new MainView().setVisible(true);
            this.dispose(); // Fecha a tela de login
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!");
        }
    }

    private void botaoRegistrarActionPerformed(ActionEvent evt) {
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());

        // Verifica se o usuário já está registrado
        boolean usuarioExistente = false;
        for (String[] user : usuariosRegistrados) {
            if (user[0].equals(usuario)) {
                usuarioExistente = true;
                break;
            }
        }

        if (usuarioExistente) {
            JOptionPane.showMessageDialog(this, "Usuário já registrado!");
        } else if (usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Usuário e senha não podem estar vazios!");
        } else {
            // Adiciona o novo usuário à lista
            usuariosRegistrados.add(new String[]{usuario, senha});
            JOptionPane.showMessageDialog(this, "Usuário registrado com sucesso!");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLogin;
    private javax.swing.JButton botaoRegistrar;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
