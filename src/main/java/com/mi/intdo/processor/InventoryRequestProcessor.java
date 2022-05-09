package com.mi.intdo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.http.common.HttpMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "inventoryRequestProcessor")
public class InventoryRequestProcessor {

	private final static Logger log = LoggerFactory.getLogger(InventoryUriProcessor.class);

	public void process(Exchange ex) throws Exception {
		log.debug("inventoryRequestProcessor");
		ex.getIn().setBody("empty");
		ex.getIn().setHeader(Exchange.HTTP_METHOD, HttpMethods.GET);
	}

}