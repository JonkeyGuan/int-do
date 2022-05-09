package com.mi.intdo.processor;

import com.mi.intdo.model.Delivery;
import com.mi.intdo.model.DeliveryOrder;
import com.mi.intdo.model.DeliveryOrderApplication;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "stockEnoughProcessor")
public class StockEnoughProcessor {

	private final static Logger log = LoggerFactory.getLogger(StockEnoughProcessor.class);

	public void process(Exchange ex) throws Exception {
		log.debug("stockEnoughProcessor");
		Delivery delivery = ex.getIn().getBody(Delivery.class);
		DeliveryOrderApplication deliveryOrderApplication = ex.getProperty("deliveryOrderApplication", DeliveryOrderApplication.class);
		DeliveryOrder deliveryOrder = DeliveryOrder.builder()
				.factory(deliveryOrderApplication.getFactory())
				.product(deliveryOrderApplication.getProduct())
				.quant(deliveryOrderApplication.getQuant())
				.id(delivery.getId())
				.comment("库存充足")
				.build();

		ex.getIn().setBody(deliveryOrder);
	}

}