package com.akash.maharana.wsdlFirst;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.feature.Features;

import com.maharana.akash.trainings.DeleteOrdersRequest;
import com.maharana.akash.trainings.UpdateOrdersRequest;
import com.maharana.akash.trainings.UpdateOrdersResponse;
import com.maharana.akash.trainings.CreateOrdersRequest;
import com.maharana.akash.trainings.CreateOrdersResponse;
import com.maharana.akash.trainings.CustomerOrdersPortType;
import com.maharana.akash.trainings.DeleteOrdersResponse;
import com.maharana.akash.trainings.GetOrdersRequest;
import com.maharana.akash.trainings.GetOrdersResponse;
import com.maharana.akash.trainings.Order;
import com.maharana.akash.trainings.Product;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersWsImpl implements CustomerOrdersPortType{
	
	Map<BigInteger,List<Order>> customerOrders=new HashMap<>();
	int currentId;
	
	public CustomerOrdersWsImpl() {
		init();
	}
	
	private void init() {
		List<Order> orders=new ArrayList<>();
		Order order=new Order();
		order.setId(BigInteger.valueOf(1));
		
		Product product=new Product();
		product.setDescription("IPhone");
		product.setId("1");
		product.setQuantity(BigInteger.valueOf(3));
		order.getProduct().add(product);
		orders.add(order);
		customerOrders.put(BigInteger.valueOf(++currentId), orders);
	}

	@Override
	public GetOrdersResponse getOrders(GetOrdersRequest request) {
		BigInteger customerId=request.getCustomerId();
		List<Order> orders=customerOrders.get(customerId);
		GetOrdersResponse response=new GetOrdersResponse();
		response.getOrder().addAll(orders);
		return response;
	}

	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
		BigInteger customerId=request.getCustomerId();
		Order order=request.getOrder();
		List<Order> orders=customerOrders.get(customerId);
		orders.add(order);
		CreateOrdersResponse response=new CreateOrdersResponse();
		response.setResult(true);
		return response;
	}
	
	@Override
	public UpdateOrdersResponse updateOrders(UpdateOrdersRequest request) {
		BigInteger customerId=request.getCustomerId();
		Order order=request.getOrder();
		List<Order> orders=customerOrders.get(customerId);
		for(Order o : orders) {
			if(o.getId() == request.getOrder().getId()) {
				o = request.getOrder();
				break;
			}
		}
		UpdateOrdersResponse response=new UpdateOrdersResponse();
		response.setResult(true);
		return response;
	}
	
	@Override
	public DeleteOrdersResponse deleteOrders(DeleteOrdersRequest request) {
		BigInteger customerId=request.getCustomerId();
		Order order=request.getOrder();
		List<Order> orders=customerOrders.get(customerId);
		
		orders.remove(order);

		DeleteOrdersResponse response=new DeleteOrdersResponse();
		response.setResult(true);
 		return response;
	}

}
