package br.com.ayty.fintech.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Criar uma entidade chamada cadastro
 */
@Entity
public class Cadastro implements Serializable {

	/*
	 * Gera um número de serial
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Passa para váriavel código os atributos de id e o serial.
	 */
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long codigo;
	

	/*
	 * Cria as váriaveis relacionadas ao cadastro e dá o get e set delas.
	 */
	private String nome;
	private String password;
	private String cpf;
	private String email;
	private String phone;
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
