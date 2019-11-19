package com.capgemini.springrestmedical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springrestmedical.beans.CartBean;
import com.capgemini.springrestmedical.beans.ReplyBean;
import com.capgemini.springrestmedical.beans.ResponseBean;
import com.capgemini.springrestmedical.beans.UserBean;
import com.capgemini.springrestmedical.service.ServiceDao;

@RestController
public class UserController {
	@Autowired
	private ServiceDao service;
	int id;


	@PutMapping(path = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseBean registration(@RequestBody UserBean bean) {
		Boolean isAdded = service.addUser(bean);
		ResponseBean response = new ResponseBean();

		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("PRODUCT ADDED SUCCESSFULLY");

		} else {
			response.setStatusCode(401);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO ADD PRODUCT");
		}
		return response;
	}
	@GetMapping(path = "/loginUser", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseBean userLoginAuthentication(String emailId, String password) {
		id = service.userLogin(emailId, password);
		ResponseBean response = new ResponseBean();

		if (id != 0) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("LOGIN SUCCESSFULL");

		} else {
			response.setStatusCode(401);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO " + id + "FETCH DATA");
		}
		return response;
	}

	@PutMapping(path = "/addToCart", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseBean addToCart(  String pName, int quantity) {
		Boolean isAdded = service.addToCart(id, pName, quantity);
		ResponseBean response = new ResponseBean();

		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("PRODUCT ADDED SUCCESSFULLY");

		} else {
			response.setStatusCode(401);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO ADD PRODUCT");
		}
		return response;
	}

	@PostMapping(path = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseBean updateUser(@RequestBody UserBean bean) {
		boolean isUpdated = service.updateUser(id,bean);

		ResponseBean response = new ResponseBean();

		if (isUpdated) {
			response.setStatusCode(201);

			response.setMessage("success");
			response.setDescription("USER UPDATED SUCCESSFULLY");

		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("UNABLE TO UPDATE PRODUCT");

		}
		return response;
	}

	@DeleteMapping(path = "/deleteFromCart", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })

	public ResponseBean deleteFromCart(int cId, String pName) {
		boolean isDeleted = service.deleteFromCart(cId, pName);
		ResponseBean response = new ResponseBean();

		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("PRODUCT DELETED SUCCESSFULLY");

		} else {
			response.setStatusCode(401);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO DELETE PRODUCT");

		}
		return response;
	}

	@GetMapping(path = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseBean payment() {
		double price = service.payment(id);
		ResponseBean response = new ResponseBean();

		if (price != 0) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("YOUR TOTAL PRICE IS"+price);
		

		} else {
			response.setStatusCode(401);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO " + id + "FETCH DATA");
		}
		return response;
	}
	@GetMapping(path = "/getCart", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseBean getCart() {
	List<CartBean> list = service.getCart(id);
		ResponseBean response = new ResponseBean();

		if ( list!=null) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("HERE IS YOUR CART");
			response.setCartList(list);

		} else {
			response.setStatusCode(401);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO THE CART");
		}
		return response;
	}
	@PutMapping(path = "/sendRequest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseBean userSendRequest( String msgReq) {
		Boolean isSent = service.sendRequest(id, msgReq);
		ResponseBean response = new ResponseBean();

		if (isSent) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("MESSAGE SENT SUCCESSFULLY");

		} else {
			response.setStatusCode(401);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO SEND MESSAGE");
		}
		return response;
	}

	@GetMapping(path = "/seeReply", produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseBean seeReplyFromAdmin() {
		List<ReplyBean> list = service.seeReply(id);
		ResponseBean response = new ResponseBean();

		if (list != null) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("YOUR MESSAGE IS");
			response.setReplyList(list);
			response.getReplyList();
			

		} else {
			response.setStatusCode(401);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO FETCH THE MESSAGES");
		}
		return response;
	}
}
