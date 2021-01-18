package br.com.ayty.fintech;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/*
 * Classe de configuração ao acesso ao banco de dados local
 */
@Configuration
@Profile("dev")
public class DataConfiguration {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:file:~/fintech");
		datasource.setUsername("sa");
		datasource.setPassword("");
		return datasource;
	}
	
	/*
	 * Configuração do JPA de tratamento do banco de dados, reforça a compatibilidade com o banco
	 */
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.H2);
		vendorAdapter.setShowSql(true);
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
		vendorAdapter.setPrepareConnection(true);
		return vendorAdapter;
	}
}
