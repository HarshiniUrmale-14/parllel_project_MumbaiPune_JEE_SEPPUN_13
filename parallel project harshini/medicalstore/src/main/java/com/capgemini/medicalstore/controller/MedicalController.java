package com.capgemini.medicalstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.medicalstore.beans.AdminUserBean;
import com.capgemini.medicalstore.beans.CartBean;
import com.capgemini.medicalstore.beans.OrderBean;
import com.capgemini.medicalstore.beans.ProductBean;
import com.capgemini.medicalstore.beans.ReplyBean;
import com.capgemini.medicalstore.beans.RequestBean;
import com.capgemini.medicalstore.beans.ResponseBean;
import com.capgemini.medicalstore.services.ServiceDao;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicalController {
	@Autowired
	private ServiceDao service;
	int userId;

	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean Login(@RequestBody AdminUserBean bean) {

		ResponseBean response = new ResponseBean();
		String email = bean.getEmailId();
		String password = bean.getPassword();

		AdminUserBean adminUserBean = service.login(email, password);

		if (adminUserBean != null) {
			userId = adminUserBean.getId();

			response.setStatusCode(200);
			response.setMessage("SUCCESS");
			response.setDescription("L0GGED SUCCESSFULL");
			response.setRole(adminUserBean.getRole());
			response.setLoginBean(adminUserBean);

		} else {
			response.setStatusCode(400);
			response.setMessage("FALIURE");
			response.setDescription("EMAIL ID  AND PASSWORD NOT FOUND");
		}
		return response;

	}

	@PostMapping(path = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean registration(@RequestBody AdminUserBean bean) {

		String emailId = bean.getEmailId();
		if (!service.customEmailValidation(emailId)) {
			boolean isAdded = service.registration(bean);
			ResponseBean response = new ResponseBean();
			if (isAdded) {
				response.setStatusCode(200);
				response.setMessage("SUCCESS");
				response.setDescription("USER REGISTERED SUCCESSFULLY");
			} else {
				response.setStatusCode(400);
				response.setMessage("FALIURE");
				response.setDescription("UNABLE TO REGISTER");
			}
			return response;
		} else {
			ResponseBean response = new ResponseBean();
			response.setStatusCode(401);
			response.setMessage("FALIURE");
			response.setDescription(" SORRY ENTERED EMAIL ID ALREAD EXIST");
			return response;

		}

	}

	@GetMapping(path = "/getProduct", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean seeAllProduct() {

		List<ProductBean> productList = service.getProducts();
		ResponseBean response = new ResponseBean();

		if (productList != null && !productList.isEmpty()) {
			response.setStatusCode(200);
			response.setMessage("SUCCESS");
			response.setDescription("PRODUCT LIST  FOUND");

			response.setProductList(productList);

		} else {
			response.setStatusCode(400);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO FETCH DATA");
		}
		return response;
	}

	@PutMapping(path = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean addProduct(@RequestBody ProductBean productBean) {
		String productName =productBean.getProductName();
		if (!service.customProductNameValidation(productName)) {
			boolean isAdded = service.addProduct(productBean);
			ResponseBean response = new ResponseBean();
			if (isAdded) {
				response.setStatusCode(200);
				response.setMessage("SUCCESS");
				response.setDescription("YOUR PRODUCT IS ADDED SUCCESSFULLY");
			} else {
				response.setStatusCode(400);
				response.setMessage("FALIURE");
				response.setDescription("UNABLE TO ADD PRODUCT");
			}
			return response;
		} else {
			ResponseBean response = new ResponseBean();
			response.setStatusCode(401);
			response.setMessage("FALIURE");
			response.setDescription(" SORRY ENTERED PRODUCT ALREAD EXIST");
			return response;

		}

		
	}

	@DeleteMapping(path = "/deleteProduct/{productId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean deleteProduct(@PathVariable int productId) {

		boolean isDeleted = service.deleteProduct(productId);
		ResponseBean response = new ResponseBean();

		if (isDeleted) {
			response.setStatusCode(200);
			response.setMessage("SUCCESS");
			response.setDescription("PRODUCT DELETED SUCCESSFULLY");

		} else {
			response.setStatusCode(400);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO DELETE PRODUCT");

		}
		return response;
	}

	@PostMapping(path = "/updateProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean updateProduct(@RequestBody ProductBean productBean) {

		boolean isUpdated = service.updateProduct(productBean);

		ResponseBean response = new ResponseBean();

		if (isUpdated) {
			response.setStatusCode(200);

			response.setMessage("success");
			response.setDescription("PRODUCT UPDATED SUCCESSFULLY");

		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("UNABLE TO UPDATE PRODUCT");

		}
		return response;
	}

	@DeleteMapping(path = "/deleteUser/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean deleteUser(@PathVariable int id) {

		boolean isDeleted = service.deleteUser(id);
		ResponseBean response = new ResponseBean();

		if (isDeleted) {
			response.setStatusCode(200);
			response.setMessage("SUCCESS");
			response.setDescription("PRODUCT DELETED SUCCESSFULLY");

		} else {
			response.setStatusCode(400);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO DELETE PRODUCT");

		}
		return response;
	}

	@GetMapping(path = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getUser() {

		List<AdminUserBean> list = service.getUser();
		ResponseBean response = new ResponseBean();

		if (list != null) {
			response.setStatusCode(200);
			response.setMessage("SUCCESS");
			response.setDescription("HERE IS YOUR USER LIST");
			response.setLoginList(list);

		} else {
			response.setStatusCode(400);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO FETCH USER INFO");
		}
		return response;
	}

	@GetMapping(path = "/seeRequest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean requestFromUser() {

		List<RequestBean> requestList = service.seeRequest();
		ResponseBean response = new ResponseBean();

		if (requestList != null && !requestList.isEmpty()) {
			response.setStatusCode(200);
			response.setMessage("SUCCESS");
			response.setDescription("MESSAGES ARE HERE");

			response.setRequestList(requestList);

		} else {
			response.setStatusCode(400);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO FETCH DATA");
		}
		return response;
	}

	@PutMapping(path = "/sendReplyToUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean sendReplyToUser(@RequestBody ReplyBean replyBean) {
		int userId = replyBean.getUserId();
		String msgReply = replyBean.getMessage();

		Boolean isSent = service.sendReply(userId, msgReply);
		ResponseBean response = new ResponseBean();

		if (isSent) {
			response.setStatusCode(200);
			response.setMessage("SUCCESS");
			response.setDescription("MESSAGE SENT SUCCESSFULLY");

		} else {
			response.setStatusCode(400);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO SEND MESSAGE");
		}
		return response;
	}

	@PutMapping(path = "/addToCart", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean addToCart(@RequestBody CartBean cartBean) {
		String productName = cartBean.getProductName();
		int quantity = cartBean.getQuantity();
		if (!service.customProductNameInCartValidation( userId,productName)) {
			boolean isAdded = service.addToCart(userId, productName, quantity);
			ResponseBean response = new ResponseBean();
			if (isAdded) {
				response.setStatusCode(200);
				response.setMessage("SUCCESS");
				response.setDescription("YOUR PRODUCT IS ADDED SUCCESSFULLY");
			} else {
				response.setStatusCode(400);
				response.setMessage("FALIURE");
				response.setDescription("UNABLE TO ADD PRODUCT");
			}
			return response;
		} else {
			ResponseBean response = new ResponseBean();
			response.setStatusCode(401);
			response.setMessage("FALIURE");
			response.setDescription(" SORRY ENTERED PRODUCT ALREAD EXIST IN CART");
			return response;

		}

	}

	@PutMapping(path = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean updateUser(@RequestBody AdminUserBean bean) {

		boolean isUpdated = service.updateUser(userId, bean);

		ResponseBean response = new ResponseBean();

		if (isUpdated) {
			response.setStatusCode(200);

			response.setMessage("success");
			response.setDescription("USER UPDATED SUCCESSFULLY");

		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("UNABLE TO UPDATE USER");

		}
		return response;
	}

	@DeleteMapping(path = "/deleteFromCart/{cartId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean deleteFromCart(@PathVariable int cartId) {

		boolean isDeleted = service.deleteFromCart(cartId);
		ResponseBean response = new ResponseBean();

		if (isDeleted) {
			response.setStatusCode(200);
			response.setMessage("SUCCESS");
			response.setDescription("PRODUCT DELETED SUCCESSFULLY");

		} else {
			response.setStatusCode(400);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO DELETE PRODUCT");

		}
		return response;
	}

	@GetMapping(path = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean payment() {
		boolean isPlaced = service.placeOrder(userId);
		double price = service.payment(userId);
		ResponseBean response = new ResponseBean();
		if (price > 0) {
			response.setStatusCode(200);
			response.setMessage("SUCCESS");
			response.setDescription("YOUR TOTAL PRICE IS" + price);
			response.setBill(price);

		} else {
			response.setStatusCode(400);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO FETCH DATA");

		}
		return response;
	}

	@GetMapping(path = "/getCart", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getCart() {

		List<CartBean> list = service.getCart(userId);
		ResponseBean response = new ResponseBean();

		if (list != null) {
			response.setStatusCode(200);
			response.setMessage("SUCCESS");
			response.setDescription("HERE IS YOUR CART");
			response.setCartList(list);

		} else {
			response.setStatusCode(400);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO THE CART");
		}
		return response;
	}

	@PutMapping(path = "/sendRequest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean userSendRequest(@RequestBody RequestBean requestBean) {

		String msgReq = requestBean.getMessage();
		Boolean isSent = service.sendRequest(userId, msgReq);
		ResponseBean response = new ResponseBean();

		if (isSent) {
			response.setStatusCode(200);
			response.setMessage("SUCCESS");
			response.setDescription("MESSAGE SENT SUCCESSFULLY");

		} else {
			response.setStatusCode(400);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO SEND MESSAGE");
		}
		return response;
	}

	@GetMapping(path = "/seeReply", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean seeReplyFromAdmin() {

		List<ReplyBean> list = service.seeReply(userId);
		ResponseBean response = new ResponseBean();

		if (list != null) {
			response.setStatusCode(200);
			response.setMessage("SUCCESS");
			response.setDescription("YOUR MESSAGE IS");
			response.setReplyList(list);

		} else {
			response.setStatusCode(400);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO FETCH THE MESSAGES");
		}
		return response;
	}

	@GetMapping(path = "/orderHistory", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean productOrderHistory() {

		List<OrderBean> orderList = service.history();
		ResponseBean response = new ResponseBean();

		if (orderList != null && !orderList.isEmpty()) {
			response.setStatusCode(200);
			response.setMessage("SUCCESS");
			response.setDescription("PRODUCT LIST  FOUND");

			response.setOrderList(orderList);

		} else {
			response.setStatusCode(400);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO FETCH DATA");
		}
		return response;
	}

	@GetMapping(path = "/getUserProfile", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getUserProfile() {

		AdminUserBean adminUserBean = service.getUserprofile(userId);
		ResponseBean response = new ResponseBean();

		if (adminUserBean != null) {
			response.setStatusCode(200);
			response.setMessage("SUCCESS");
			response.setDescription("USER FOUND");
			response.setLoginBean(adminUserBean);

		} else {
			response.setStatusCode(400);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO FETCH DATA");
		}
		return response;
	}
	@GetMapping(path = "/userHistory", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getUseHistory() {

	     List<OrderBean> orderList = service.userOrderHistory(userId);
	     ResponseBean response = new ResponseBean();

		if (orderList != null) {
			response.setStatusCode(200);
			response.setMessage("SUCCESS");
			response.setDescription("USER FOUND");
			response.setOrderList(orderList);

		} else {
			response.setStatusCode(400);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO FETCH DATA");
		}
		return response;
	}
}