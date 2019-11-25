package desafio.boot.config;

import java.util.Locale;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableJpaRepositories
@PropertySource(value  = "classpath:/data_source.properties")
public class DesafioConfig {
	@Autowired
	private Environment env;

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver registarViewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/vistas/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean(name = "localeResolver")
	public SessionLocaleResolver registrarLocaleResolver() {
		System.out.println("Cargando locale PT_BR");
		SessionLocaleResolver localeResolver=new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("pt_BR"));
		
		return localeResolver;
	}
	
	@Bean(name = "messageSource")
	public ResourceBundleMessageSource registrarMessageSource() {
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		
		return messageSource;
	}
	
	@Bean
	public DriverManagerDataSource registrarDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("db.driverClassName"));
		ds.setUrl(env.getProperty("db.url"));
		ds.setUsername(env.getProperty("db.userName"));
		ds.setPassword(env.getProperty("db.password"));
		return ds;
	}
	
	@Bean(name = "entityManagerFactory")
	@Autowired
	public LocalContainerEntityManagerFactoryBean registrarEntityManagerFactory(DataSource ds) {
		LocalContainerEntityManagerFactoryBean lemf=new LocalContainerEntityManagerFactoryBean();
		lemf.setDataSource(ds);
		lemf.setPackagesToScan("desafio.boot.entidades");
		lemf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties prop=new Properties();
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		lemf.setJpaProperties(prop);
		return lemf;
	}
	
	@Bean(name = "transactionManager")
	@Autowired
	public PlatformTransactionManager registrarTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transManager=new JpaTransactionManager();
		transManager.setEntityManagerFactory(emf);
		return transManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor registrarExceptionTranslation() {
		PersistenceExceptionTranslationPostProcessor exceptionTranslation=new PersistenceExceptionTranslationPostProcessor();
		return exceptionTranslation;
	}
	
}
