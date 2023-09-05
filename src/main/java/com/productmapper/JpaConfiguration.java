package com.productmapper;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableJpaRepositories(basePackages = "com.productmapper.repositories")
@EntityScan(basePackages = "com.productmapper.entities")
@EnableTransactionManagement
public class JpaConfiguration {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public SolrClient getSolrClient() {
        return new Http2SolrClient.Builder("http://localhost:8983/solr/products")
                .withConnectionTimeout(5000L, TimeUnit.MILLISECONDS)
                .withResponseParser(new XMLResponseParser())
                .build();
    }
}
