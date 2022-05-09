package com.mi.intdo.processor;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "deliveryUriProcessor")
public class DeliveryUriProcessor {

	private final static Logger log = LoggerFactory.getLogger(DeliveryUriProcessor.class);

	@Value("${service.delivery.url}")
	private String url;

	public void process(Exchange ex) throws Exception {
		log.debug("deliveryUriProcessor");
		ex.getIn().setHeader(Exchange.HTTP_URI, url);
	}

}