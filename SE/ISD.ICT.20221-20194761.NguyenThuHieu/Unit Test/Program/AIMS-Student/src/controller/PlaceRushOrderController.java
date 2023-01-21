package controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import entity.media.Media;
import entity.order.Order;
import entity.order.OrderMedia;

public class PlaceRushOrderController {

	private Media media;
	private int plusMoney = 0;
	private int total = 0;
	public int changeFormualaShippingFees(OrderMedia orderMedia) {
		if(orderMedia == null) return 0;
		plusMoney = 10 * orderMedia.getQuantity();
		return plusMoney;
	}

	public int placeRushOrder(Order order, String address) {
		List<OrderMedia>lstOrderMedia = order.getlstOrderMedia();
		if(!validateSupportedAddress(address)) {
			System.out.println("This address is not supported to rush order!");
			return 0;
		}
		if(lstOrderMedia == null) return 0;
		for( OrderMedia i : lstOrderMedia) {
			if(validateSupportedMedia(i)) {
			   System.out.println("This media is not support: "+ i.getMedia().getTitle());
			}else {
				total += changeFormualaShippingFees(i);
			}
		}
		return total;
	}
	 public boolean validateSupportedMedia(OrderMedia orderMedia ){
		// quantity <2 and price <10 dolar => not support
		if (orderMedia == null) return false;
		if(orderMedia.getQuantity() >=2 && orderMedia.getPrice() >= 10) {
			return true;
		}
		return false;
	 }
	 public boolean validateSupportedAddress(String address) {
		 address = address.toLowerCase();
		 if(address==null || address.isBlank()) return false;
	     else if(address.equals("null")) return false;
	     else if(address.contains("hanoi")||address.contains("ha noi")) {
	    		 return address.matches("^[.0-9a-zA-Z\\s,-]+$");
	    	}
		return false;
	 }
	 
}
