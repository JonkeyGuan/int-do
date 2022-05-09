package com.mi.intdo.processor;

import com.mi.intdo.model.DeliveryOrderApplication;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "requestQuantProcessor")
public class RequestQuantProcessor {

	private final static Logger log = LoggerFactory.getLogger(RequestQuantProcessor.class);

	public void process(Exchange ex) throws Exception {
		log.debug("requestQuantProcessor");
		DeliveryOrderApplication deliveryOrderApplication = ex.getIn().getBody(DeliveryOrderApplication.class);
		ex.setProperty("requestQuant", deliveryOrderApplication.getQuant());
		log.info("Request quant: {}", deliveryOrderApplication.getQuant());
	}

}