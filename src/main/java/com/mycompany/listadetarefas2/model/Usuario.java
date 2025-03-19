/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listadetarefas2.model;

/**
 *
 * @author emanu
 */
public class Usuario {
	private int id;
	private String nome;
	private String password;

	public Usuario(int id, String nome, String password) {
		this.id = id;
		this.nome = nome;
		this.password = password;
	}
	public Usuario(String nome, String password) {
		this.nome = nome;
		this.password = password;	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
