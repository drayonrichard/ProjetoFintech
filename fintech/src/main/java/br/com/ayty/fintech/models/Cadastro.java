package br.com.ayty.fintech.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cadastro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@NotEmpty
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long codigo;
	
	@NotNull (message = "Campo não estar vazio")
	@Size(min=2, max=100, message="Tem de ter pelo menos 2 letras") 
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
