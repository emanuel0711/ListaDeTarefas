package com.mycompany.listadetarefas.view;

import com.mycompany.listadetarefas.controller.TarefaController;
import com.mycompany.listadetarefas.model.Tarefa;
import com.mycompany.listadetarefas.model.Usuario;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class MainView extends javax.swing.JFrame {
    private Usuario usuario;
    private TarefaController tarefaController;
    public MainView(Usuario usuario) {
        this.tarefaController = new TarefaController();
        this.usuario = usuario;
        initComponents();
        setLocationRelativeTo(null); // Centraliza a janela
        attTableLivros();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botaoAdicionar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTarefas = new javax.swing.JTable();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(647, 373));

        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        botaoEditar.setText("Editar");
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        tableTarefas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Titulo", "Descrição", "Status", "Data de Vencimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableTarefas);

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAdicionar)
                    .addComponent(botaoEditar)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoVoltar))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    public void attTableLivros() {
		// Recupera os dados dos usuários do banco de dados
        try {
            ArrayList<Tarefa> listaTarefas = (ArrayList<Tarefa>) tarefaController.listarTarefasPorUsuario(usuario.getId());

	// Obtém o modelo da tabela
            DefaultTableModel model = (DefaultTableModel) tableTarefas.getModel();

	// Limpa a tabela
            model.setRowCount(0);

	// Adiciona os novos dados à tabela
            for (Tarefa tarefa : listaTarefas) {
		// Cria um array de objetos com os dados do usuário
		Object[] rowData = {tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getStatus(), tarefa.getDataVencimento()};
		// Adiciona a linha ao modelo da tabela
		model.addRow(rowData);
            }
        } catch (Exception e) {
            showErrorMessage(e.getMessage());
        }
    }
    
    
    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
         new TarefaForm(usuario).setVisible(true);
         this.dispose();
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        int selectedRow = tableTarefas.getSelectedRow();
        
        if (selectedRow != -1) {
            // Abre a tela de formulário para editar a tarefa selecionada
            int idTarefa = (int) tableTarefas.getValueAt(selectedRow, 0);
            String titulo = (String) tableTarefas.getValueAt(selectedRow, 1);
            String descricao = (String) tableTarefas.getValueAt(selectedRow, 2);
            String dataVencimento = (String) tableTarefas.getValueAt(selectedRow, 4);
            String status = (String) tableTarefas.getValueAt(selectedRow, 3);
            Tarefa tarefa = new Tarefa(idTarefa, titulo, descricao, status, dataVencimento);
            
            new TarefaForm(usuario, tarefa).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para editar!");
        }
        
        
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        int selectedRow = tableTarefas.getSelectedRow();
			
	if (selectedRow != -1) {
            int idTarefa = (int) tableTarefas.getValueAt(selectedRow, 0); //Pego o valor da celula que corresponde a linha tal x coluna tal

            try {
                tarefaController.removerTarefa(idTarefa);
            } catch (Exception e) {
                showErrorMessage(e.getMessage());
            }
	}
        
        attTableLivros();
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        new LoginView().setVisible(true);
	this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableTarefas;
    // End of variables declaration//GEN-END:variables
}
