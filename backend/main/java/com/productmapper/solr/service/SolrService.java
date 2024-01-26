package com.productmapper.solr.service;

import com.productmapper.entities.BaseProduct;
import com.productmapper.entities.LocalProduct;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

public interface SolrService {

    void indexProduct(LocalProduct product) throws SolrServerException, IOException;

    void indexBaseProduct(BaseProduct product) throws SolrServerException, IOException;
}
