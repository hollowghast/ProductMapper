package com.productmapper.solr.service.impl;

import com.productmapper.solr.service.SolrService;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class DefaultSolrService implements SolrService {

    @Autowired
    private SolrClient solrClient;

}
