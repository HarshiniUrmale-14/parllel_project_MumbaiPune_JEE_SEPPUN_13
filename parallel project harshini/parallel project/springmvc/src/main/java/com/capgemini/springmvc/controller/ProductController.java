package com.capgemini.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.springmvc.beans.AdminBean;
import com.capgemini.springmvc.beans.CartBean;
import com.capgemini.springmvc.beans.OrderBean;
import com.capgemini.springmvc.beans.ProductBean;
import com.capgemini.springmvc.beans.ReplyBean;
import com.capgemini.springmvc.beans.RequestBean;
import com.capgemini.springmvc.beans.UserBean;
import com.capgemini.springmvc.services.ServiceDao;

@Controller
public class ProductController {

	@Autowired
	private ServiceDao service;

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView displayHomePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("homePage");
		return modelAndView;
	}

	@RequestMapping(path = "/aboutUs", method = RequestMethod.GET)
	public ModelAndView displayAboutUs() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("about");
		return modelAndView;

	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView loginForm() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("login");
		return modelAndView;

	}

	@RequestMapping(path = "/registration", method = RequestMethod.GET)
	public ModelAndView registrationForm() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("registration");
		return modelAndView;

	}

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap modelMap) {
		session.invalidate();
		modelMap.addAttribute("msg", "LOGGED OUT SUCCESSFULLY");
		return "homePage";

	}

	@RequestMapping(path = "/admin", method = RequestMethod.GET)
	public ModelAndView adminForm() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("admin");
		return modelAndView;

	}

	@RequestMapping(path = "/user", method = RequestMethod.GET)
	public ModelAndView userForm() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("user");
		return modelAndView;

	}

	@GetMapping("/seeAllProduct")
	public String getAllProducts(HttpSession session, ModelMap modelMap) {

		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First");
			return "login";

		} else {

			List<ProductBean> productsList = service.getProducts();
			modelMap.addAttribute("productList", productsList);

			return "getProduct";
		}
	}

	@GetMapping("/seeAllProductAdmin")
	public String getAllProductsAdmin(HttpSession session, ModelMap modelMap) {

		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First");
			return "login";

		} else {

			List<ProductBean> productsList = service.getProducts();
			modelMap.addAttribute("productList", productsList);

			return "seeProductAdmin";
		}
	}

	int userId = 0;

	@PostMapping("/login2")
	public String Login(String emailId, String password, String alogin, ModelMap modelMap, HttpServletRequest req) {

		if (alogin.equals("administrator")) {
			AdminBean bean = service.adminLogin(emailId, password);
			if (bean != null) {
				HttpSession session = req.getSession(true);
				session.setAttribute("bean", bean);

				return "admin";

			} else {
				modelMap.addAttribute("msg", "INVALID CREDENTIALS");
				return "login";
			}
		} else {

			userId = service.userLogin(emailId, password);

			if (userId != 0) {
				HttpSession session = req.getSession(true);
				session.setAttribute("bean", userId);

				return "user";

			} else {
				modelMap.addAttribute("msg", "INVALID CREDENTIALS");
				return "login";
			}

		}
	}

	@PostMapping("/addUser")
	public String addUser(UserBean bean, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "DO REGISTRATION FIRST");
			return "registration";
		} else {
			if (service.registration(bean)) {
				modelMap.addAttribute("msg", "USER ADDED SUCCESSFULLY");

			} else {
				modelMap.addAttribute("msg", "UNABLE TO ADD user");
			}
			return "homePage";
		}
	}

	@GetMapping("/deleteProduct")
	public ModelAndView displayDeleteProductForm(HttpSession session, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("deleteProduct");
		return modelAndView;

	}// End o

	@PostMapping("/delete")
	public String deleteProducts(int pid, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "PLEASE LOGIN FIRST");
			return "login";

		} else {
			if (service.deleteProduct(pid)) {
				modelMap.addAttribute("msg", "PRODUCT DELETED SUCCESSFULLY!");
			} else {
				modelMap.addAttribute("msg", "Employee ID " + pid + " Not Found!");
			}

			return "deleteProduct";
		}
	}// End of searchEmployee()

	@GetMapping("/addProduct")
	public ModelAndView displayAddProduct(HttpSession session, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("addProduct");
		return modelAndView;

	}

	@PostMapping("/add")
	public String addProduct(ProductBean bean, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "PLEASE LOGIN FIRST");
			return "login";
		} else {
			if (service.addProduct(bean)) {
				modelMap.addAttribute("msg", "PRODUCT ADDED SUCCESSFULLY");

			} else {
				modelMap.addAttribute("msg", "UNABLE TO ADD EMPLOYEE");
			}
			return "addProduct";
		}
	}

	@GetMapping("/updateProduct")
	public ModelAndView displayUpdateProduct(HttpSession session, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("updateProduct");
		return modelAndView;
	}

	@PostMapping("/update")
	public String updateProduct(ProductBean bean, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "PLEASE LOGIN FIRST");
			return "login";
		} else {
			if (service.updateProduct(bean)) {
				modelMap.addAttribute("msg", "PRODUCT UPDATED SUCCESSFULLY");
			} else {
				modelMap.addAttribute("msg", "UNABLE  TO UPDATE EMPLOYEE");
			}
			return "updateProduct";
		}
	}

	@RequestMapping("/updateProfile")
	public ModelAndView displayUpdateUser(HttpSession session, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("userProfileUpdate");
		return modelAndView;

	}

	@PostMapping("/updateUser")
	public String updateUser(UserBean bean, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "PLEASE LOGIN FIRST");
			return "login";
		} else {
			if (service.updateUser(userId, bean)) {
				modelMap.addAttribute("msg", "USER UPDATED SUCCESSFULLY");
			} else {
				modelMap.addAttribute("msg", "UNABLE  TO UPDATE USER");
			}
			return "userProfileUpdate";
		}
	}

	@GetMapping("/seeAllUsers")
	public String getAllUsers(HttpSession session, ModelMap modelMap) {

		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "PLEASE LOGIN FIRST");
			return "login";

		} else {
			
			List<UserBean> usersList = service.getUser();
			modelMap.addAttribute("userList", usersList);

			return "seeUser";
		}
	}

	@GetMapping("/deleteUsers")
	public ModelAndView deleteUserForm(HttpSession session, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("deleteUser");
		return modelAndView;

	}

	@PostMapping("/deleteUser")
	public String deleteUser(int uid, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {

			session.invalidate();
			modelMap.addAttribute("msg", "PLEASE LOGIN FIRST");
			return "login";

		} else {

			if (service.deleteUser(uid)) {
				modelMap.addAttribute("msg", "USER DELETED SUCCESSFULLY!");
			} else {
				modelMap.addAttribute("msg", "USER ID " + uid + " NOT FOUND!");
			}

			return "deleteUser";
		}
	}// End of searchEmployee()

	@RequestMapping(path = "/addToCart", method = RequestMethod.GET)
	public ModelAndView displayAddToCart() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addToCart");
		return modelAndView;
	}

	@PostMapping("/addtocart")
	public String addProductToCart(CartBean bean, String pname, int quantity, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "PLEASE LOGIN FIRST");
			return "login";
		} else {
			if (service.addToCart(userId, bean, pname, quantity)) {
				modelMap.addAttribute("msg", "PRODUCT ADDED SUCCESSFULLY");

			} else {
				modelMap.addAttribute("msg", "UNABLE TO ADD PRRODUCT TO THE CART");
			}
			return "addToCart";
		}
	}

	@GetMapping("/seeCartProduct")
	public String makePayment(HttpSession session, ModelMap modelMap) {

		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "PLEASE LOGIN FIRST");
			return "login";

		} else {

			List<CartBean> list = service.getCart(userId);
			modelMap.addAttribute("cartList", list);

			return "payment";
		}
	}

	@GetMapping("/viewPayment")
	public String makePayementForm(HttpSession session, ModelMap modelMap) {

		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "PLEASE LOGIN FIRST");
			return "login";

		} else {
			// Valid Session
			boolean isPlaced = service.placeOrder(userId);
			double bill = service.payment(userId);
			modelMap.addAttribute("order", isPlaced);
			modelMap.addAttribute("bill", bill);

			return "viewPayment";
		}
	}

	@RequestMapping(path = "/deleteFromCart", method = RequestMethod.GET)
	public ModelAndView deleteFromCartForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("deleteFromCart");
		return modelAndView;
	}

	@PostMapping("/deleteCart")
	public String deleteFromCartOfUser(int cid, String pname, HttpSession session, ModelMap modelMap) {

		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "PLEASE LOGIN FIRST");
			return "login";

		} else {
			if (service.deleteFromCart(cid, pname)) {
				modelMap.addAttribute("msg", "PRODUCT DELETED SUCCESSFULLY");

			} else {
				modelMap.addAttribute("msg", "UNABLE TO DELETE PRODUCT FROM THE CART");
			}
			return "deleteFromCart";
		}
	}

	@RequestMapping(path = "/sendMsg", method = RequestMethod.GET)
	public ModelAndView userMsgSendForm() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("userMsgRequest");
		return modelAndView;

	}

	@PostMapping("/sendMsg")
	public String userMsgSend(String msgreq, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "PLEASE LOGIN FIRST");
			return "login";
		} else {
			if (service.sendRequest(userId, msgreq)) {
				modelMap.addAttribute("msg", "MESSAGE SENT SUCCESSFULLY");

			} else {
				modelMap.addAttribute("msg", "UNABLE TO SEND MESSAGE");
			}
			return "userMsgRequest";
		}
	}

	@GetMapping("/userViewMsg")
	public String userViewForm(HttpSession session, ModelMap modelMap) {

		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "PLEASE LOGIN FIRST");
			return "login";

		} else {

			List<ReplyBean> list = service.seeReply(userId);
			modelMap.addAttribute("list", list);

			return "userViewMsg";
		}
	}

	@GetMapping("/adminViewMsg")
	public String adminViewForm(RequestBean bean, HttpSession session, ModelMap modelMap) {

		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "PLEASE LOGIN FIRST");
			return "login";

		} else {

			List<RequestBean> list = service.seeRequest();
			modelMap.addAttribute("list", list);

			return "adminViewMsg";
		}
	}

	@RequestMapping(path = "/adminMsgReply", method = RequestMethod.GET)
	public ModelAndView adminMsgReplyForm() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("adminMsgReply");
		return modelAndView;

	}

	@PostMapping("/sendreply")
	public String adminMsgReplyForm(int uid, String msgreply, HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "PLEASE LOGIN FIRST");
			return "login";
		} else {
			if (service.sendReply(uid, msgreply)) {
				modelMap.addAttribute("msg", "PRODUCT ADDED SUCCESSFULLY");

			} else {
				modelMap.addAttribute("msg", "UNABLE TO ADD PRRODUCT TO THE CART");
			}
			return "adminMsgReply";
		}

	}

	@GetMapping("/seeReport")
	public String getReport(HttpSession session, ModelMap modelMap) {

		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "Please Login First");
			return "login";

		} else {

			List<OrderBean> orderList = service.generateReport();
			modelMap.addAttribute("orderList", orderList);

			return "report";
		}
	}
}
