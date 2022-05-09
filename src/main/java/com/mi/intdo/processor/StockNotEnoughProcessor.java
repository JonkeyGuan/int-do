package com.mi.intdo.processor;

import com.mi.intdo.model.DeliveryOrder;
import com.mi.intdo.model.DeliveryOrderApplication;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "stockNotEnoughProcessor")
public class StockNotEnoughProcessor {

	private final static Logger log = LoggerFactory.getLogger(StockNotEnoughProcessor.class);

	public void process(Exchange ex) throws Exception {
		log.debug("stockNotEnoughProcessor");
		DeliveryOrderApplication deliveryOrderApplication = ex.getProperty("deliveryOrderApplication", DeliveryOrderApplication.class);
		DeliveryOrder deliveryOrder = DeliveryOrder.builder()
				.factory(deliveryOrderApplication.getFactory())
				.product(deliveryOrderApplication.getProduct())
				.quant(deliveryOrderApplication.getQuant())
				.id("")
				.comment("库存不足")
				.build();

		ex.getIn().setBody(deliveryOrder);
	}

}