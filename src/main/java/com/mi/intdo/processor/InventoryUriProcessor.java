package com.mi.intdo.processor;

import com.mi.intdo.model.DeliveryOrderApplication;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "inventoryUriProcessor")
public class InventoryUriProcessor {

	private final static Logger log = LoggerFactory.getLogger(InventoryUriProcessor.class);

	@Value("${service.inventory.url}")
	private String url;

	public void process(Exchange ex) throws Exception {
		log.debug("inventoryUriProcessor");
		DeliveryOrderApplication deliveryOrderApplication = ex.getIn().getBody(DeliveryOrderApplication.class);
		ex.getIn().setHeader(Exchange.HTTP_URI, url + "/" + deliveryOrderApplication.getProduct());
	}

}