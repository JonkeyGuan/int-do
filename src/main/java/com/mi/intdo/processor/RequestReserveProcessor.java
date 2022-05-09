package com.mi.intdo.processor;

import com.mi.intdo.model.DeliveryOrderApplication;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "requestReserveProcessor")
public class RequestReserveProcessor {

	private final static Logger log = LoggerFactory.getLogger(RequestReserveProcessor.class);

	public void process(Exchange ex) throws Exception {
		log.debug("requestReserveProcessor");
		DeliveryOrderApplication deliveryOrderApplication = ex.getIn().getBody(DeliveryOrderApplication.class);
		ex.setProperty("deliveryOrderApplication", deliveryOrderApplication);
	}

}