package payment.microservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "zuul-api-server")
@RibbonClient(name= "orders-service")
public interface OrderProxy {

	
	@RequestMapping(value = "/orders-service/orders/retrieveOrderId",method=RequestMethod.GET)
	public int retrieveOrderID();
}
