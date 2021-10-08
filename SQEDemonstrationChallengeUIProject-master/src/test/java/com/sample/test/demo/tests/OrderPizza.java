package com.sample.test.demo.tests;

import org.testng.annotations.Test;

import com.sample.test.demo.TestBase;

public class OrderPizza extends TestBase {
	//Variables
		String qty_id = "pizza1Qty";
		String quantity = "1";
		String pizza_id = "pizza1Pizza";
		String pizza_type = "Medium 8 Slices - 2 toppings $9.75";
		String pizzaToppings1_xpath = "//div[@id='pizza1']//select[@class='toppings1']";
		String pizzaToppings1_value = "Diced Mango";
		String pizzaToppings2_xpath = "//div[@id='pizza1']//select[@class='toppings2']";
		String pizzaToppings2_value = "Olives";
		String name_id = "name";
		String name_value="Tom";
		String phone_id = "phone";
		String phone_value = "9123456789";
		String paymentType_id = "ccpayment";
		String placeOrder_id = "placeOrder";
		String text_id = "dialog";
		String Expectedvalue_HappyValue = "Thank you for your order! TOTAL: 9.75 Medium 8 Slices - 2 toppings";
		String ExpectedValue_error = "Missing phone number";
	
	@Test
    public void OrderPizza() throws InterruptedException {
		//select pizza type from dropdown
				dropdownSelect_id(pizza_id, pizza_type);
				
				//select Toppings1 from dropdown
				dropdownSelect_xpath(pizzaToppings1_xpath, pizzaToppings1_value);
				
				//select Toppings2 from dropdown
				dropdownSelect_xpath(pizzaToppings2_xpath, pizzaToppings2_value);
				
				//Enter qty
				enterText_id(qty_id,quantity);
				//System.out.println(qty_id);
				//System.out.println(quantity);
				
				//Enter name
				enterText_id(name_id,name_value);
				
				//Enter Phone Number
				enterText_id(phone_id,phone_value);
				
				//select payment info
				click_id(paymentType_id);
				
				//click on place order button
				click_id(placeOrder_id);
				
				//Validate Text
				verifyText_id(text_id,Expectedvalue_HappyValue);
				//Thread.sleep(50000);
				
        
    }
}
