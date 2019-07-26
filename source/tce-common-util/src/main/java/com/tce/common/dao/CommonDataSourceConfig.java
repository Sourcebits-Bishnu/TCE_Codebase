package com.tce.common.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAspectJAutoProxy
@Import({ReadOnlyRouteInterceptor.class})
@EnableTransactionManagement
public class CommonDataSourceConfig {
	
	protected DataSource dataSource(String rwPool,String rdPool) {
		final RoutingDataSource routingDataSource = new RoutingDataSource();

		final DataSource primaryDataSource = buildDataSource(rwPool);
		final DataSource replicaDataSource = buildDataSource(rdPool);

		final Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(RoutingDataSource.Route.PRIMARY, primaryDataSource);
		targetDataSources.put(RoutingDataSource.Route.REPLICA, replicaDataSource);

		routingDataSource.setTargetDataSources(targetDataSources);
		routingDataSource.setDefaultTargetDataSource(primaryDataSource);

		return routingDataSource;
	}
	
	private DataSource buildDataSource(String poolName) {
		try {
			return (DataSource) new JndiTemplate().lookup("java:comp/env/"+poolName);
		} catch (NamingException ne) {
			ne.printStackTrace();
			throw new RuntimeException(ne.getMessage());
		}
	}
	
	protected LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,String packagesTOScan) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);	      
		em.setPackagesToScan(packagesTOScan);

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		Properties additionalProps = new Properties();
		//this will fail as hibernate only retrieves current schema tables
		//	      additionalProps.setProperty("hibernate.hbm2ddl.auto","validate");
		additionalProps.setProperty("hibernate.show_sql","false");
		additionalProps.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLInnoDBDialect");
		em.setJpaProperties(additionalProps);
//		em.getJpaPropertyMap().put(Environment.MULTI_TENANT, MultiTenancyStrategy.SCHEMA);
//		em.getJpaPropertyMap().put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, new MultiTenantConnectionProviderImpl(dataSource,defaultschema));
//		em.getJpaPropertyMap().put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, new TenantHolder(coredbschema));
		return em;
	}

}
