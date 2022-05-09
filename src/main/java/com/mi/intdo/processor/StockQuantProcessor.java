package com.mi.intdo.processor;

import com.mi.intdo.model.Inventory;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "stockQuantProcessor")
public class StockQuantProcessor {

	private final static Logger log = LoggerFactory.getLogger(StockQuantProcessor.class);

	public void process(Exchange ex) throws Exception {
		log.debug("stockQuantProcessor");
		Inventory inventory = ex.getIn().getBody(Inventory.class);
		ex.setProperty("stockQuant", inventory.getQuant());
		log.info("Stock quant: {}", inventory.getQuant());
	}

}