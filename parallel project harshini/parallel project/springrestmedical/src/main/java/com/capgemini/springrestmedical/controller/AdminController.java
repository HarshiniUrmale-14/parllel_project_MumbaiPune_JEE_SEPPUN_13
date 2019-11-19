package com.capgemini.springrestmedical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springrestmedical.beans.ProductBean;
import com.capgemini.springrestmedical.beans.RequestBean;
import com.capgemini.springrestmedical.beans.ResponseBean;
import com.capgemini.springrestmedical.beans.UserBean;
import com.capgemini.springrestmedical.service.ServiceDao;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
	@Autowired
	private ServiceDao service;
	@GetMapping(path = "/login", produces =  MediaType.APPLICATION_JSON_VALUE )

	public ResponseBean adminLoginAuthentication(String emailId, String password) {
		
		int id= service.adminLogin(emailId, password);
		ResponseBean response = new ResponseBean();

		if (id!=0) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("L0GIN SUCCESSFULL");

		

		} else {
			response.setStatusCode(401);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO FETCH DATA");
		}
		return response;
	}



	@GetMapping(path = "/getProduct", produces =  MediaType.APPLICATION_JSON_VALUE )

	public ResponseBean seeAllProduct() {
		List<ProductBean> productList = service.getProducts();
		ResponseBean response = new ResponseBean();

		if (productList != null && !productList.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("PRODUCT LIST NOT FOUND");

			response.setProductList(productList);

		} else {
			response.setStatusCode(401);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO FETCH DATA");
		}
		return response;
	}


	@PutMapping(path = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE
			, produces = MediaType.APPLICATION_JSON_VALUE)
	// @ResponseBody
	public ResponseBean addProduct(@RequestBody ProductBean productBean) {
		Boolean isAdded = service.addProduct(productBean);
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


	@DeleteMapping(path = "/deleteProduct", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })

	public ResponseBean deleteProduct(int pId) {
		boolean isDeleted = service.deleteProduct(pId);
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

	@PostMapping(path = "/updateProduct", consumes =  MediaType.APPLICATION_JSON_VALUE,
			 produces =  MediaType.APPLICATION_JSON_VALUE
		)

	public ResponseBean updateProduct(@RequestBody ProductBean productBean) {
		boolean isUpdated = service.updateProduct(productBean);

		ResponseBean response = new ResponseBean();

		if (isUpdated) {
			response.setStatusCode(201);

			response.setMessage("success");
			response.setDescription("PRODUCT UPDATED SUCCESSFULLY");

		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("UNABLE TO UPDATE PRODUCT");

		}
		return response;
	}

	@DeleteMapping(path = "/deleteUser", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })

	public ResponseBean deleteUser(int uId) {
		boolean isDeleted = service.deleteUser(uId);
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
	@GetMapping(path = "/getUser", produces =  MediaType.APPLICATION_JSON_VALUE )

	public ResponseBean getUser(String emailId, String password) {
		List<UserBean> list = service.getUser();
		ResponseBean response = new ResponseBean();

		if (list!=null) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("HERE IS YOUR USER LIST");
response.setUserList(list);
		

		} else {
			response.setStatusCode(401);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO FETCH USER INFO");
		}
		return response;
	}

	@GetMapping(path = "/getRequest", produces =  MediaType.APPLICATION_JSON_VALUE )

	public ResponseBean requestFromUser()  {
		List<RequestBean> requestList = service.seeRequest();
		ResponseBean response = new ResponseBean();

		if (requestList != null && !requestList.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("MESSAGES ARE HERE");

			response.setRequestList(requestList);
			

		} else {
			response.setStatusCode(401);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO FETCH DATA");
		}
		return response;
	}
	@PutMapping(path = "/sendReply", consumes = MediaType.APPLICATION_JSON_VALUE
			, produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseBean sendReplyToUser(int uId, String msgReply) {
		Boolean isSent = service.sendReply(uId, msgReply);
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
}

