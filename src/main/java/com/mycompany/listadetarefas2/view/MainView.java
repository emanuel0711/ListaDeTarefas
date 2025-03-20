package com.mycompany.listadetarefas2.view;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainView extends javax.swing.JFrame {

    public MainView() {
        initComponents();
        setLocationRelativeTo(null); // Centraliza a janela
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTarefas = new javax.swing.JList<>();
        botaoAdicionar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaTarefas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaTarefas);

        botaoAdicionar.setText("Adicionar");

        botaoEditar.setText("Editar");

        botaoExcluir.setText("Excluir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoAdicionar)
                        .addGap(12, 12, 12)
                        .addComponent(botaoEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoExcluir)
                        .addGap(0, 140, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAdicionar)
                    .addComponent(botaoEditar)
                    .addComponent(botaoExcluir))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void botaoAdicionarActionPerformed(ActionEvent evt) {
        // Abre a tela de formulário para adicionar uma nova tarefa
        new TarefaForm().setVisible(true);
    }

    // Método para o botão Editar
    private void botaoEditarActionPerformed(ActionEvent evt) {
        // Verifica se uma tarefa foi selecionada
        if (listaTarefas.getSelectedIndex() != -1) {
            // Abre a tela de formulário para editar a tarefa selecionada
            new TarefaForm().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para editar!");
        }
    }

    // Método para o botão Excluir
    private void botaoExcluirActionPerformed(ActionEvent evt) {
        // Verifica se uma tarefa foi selecionada
        if (listaTarefas.getSelectedIndex() != -1) {
            // Remove a tarefa selecionada da lista
            DefaultListModel<String> model = (DefaultListModel<String>) listaTarefas.getModel();
            model.remove(listaTarefas.getSelectedIndex());
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para excluir!");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaTarefas;
    // End of variables declaration//GEN-END:variables
}
