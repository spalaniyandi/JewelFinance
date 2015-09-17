package com.finance.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.finance.service.ReceiptService;
import com.finance.service.exceptions.ReceiptNotFoundException;
import com.finance.web.domain.ReceiptModel;
import com.finance.web.domain.ReceiptQueryModel;

@Controller
public class FinanceController {
	
	Logger logger = LoggerFactory.getLogger(FinanceController.class);
	
	private static final String CREATE_RECEIPT = "New Receipt";
	private static final String VIEW_RECEIPT = "View Receipt";
	private static final String SEARCH_RECEIPT = "Search Receipt";
	
	@Autowired
	private ReceiptService receiptService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public String welcomePage(Model model) {
		String message = "Welcome to finance application";
		model.addAttribute("message", message);
		return "welcome";
	}
	
	@RequestMapping(value="/receipt", method=RequestMethod.GET)
	public String newReceipt(Model model) {
		logger.info("Inside get receipt");
		model.addAttribute("receipt", new ReceiptModel());
		model.addAttribute("receiptTitle", CREATE_RECEIPT);
		return "receipt";
	}
	
	@RequestMapping(value="/receipt/{receiptId}", method=RequestMethod.GET)
	public String getReceipt(@PathVariable("receiptId") long receiptId, Model model) {
		logger.info("Inside get receipt");
		ReceiptModel receiptModel = null;
		try {
			receiptModel = receiptService.getReceipt(receiptId);
		} catch(ReceiptNotFoundException rnfex) {
			model.addAttribute("errorMessage", rnfex.getMessage());
			rnfex.printStackTrace();
			logger.error(rnfex.getMessage());
		}
		catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
		}
		model.addAttribute("receipt", receiptModel);
		model.addAttribute("receiptTitle", VIEW_RECEIPT);
		return "receipt";
	}
	
	@RequestMapping(value="/receipt", method=RequestMethod.POST)
	public String createReceipt(
			@Valid @ModelAttribute("receipt") ReceiptModel receipt,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			logger.info("post receipt errors");
			return "receipt";
		}
		logger.info("Inside post receipt");
		logger.info(receipt.getLoanDate().toString());
		try {
			receiptService.createNewReceipt(receipt);			
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
		}
		model.addAttribute("receipt", receipt);
		return "success";
	}
	
	@RequestMapping(value="search/receipt", method=RequestMethod.GET)
	public String newSearchReceipt(Model model) {
		logger.info("Inside search view receipt");
		ReceiptQueryModel receiptQuery = new ReceiptQueryModel();
		model.addAttribute("receiptQuery", receiptQuery);
		model.addAttribute("receiptTitle", SEARCH_RECEIPT);
		return "searchReceipt";
	}
	
	@RequestMapping(value="/receipt/search", method=RequestMethod.GET)
	public String searchReceipt(
			@ModelAttribute("receiptQuery") ReceiptQueryModel receiptQuery,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			logger.info("receipt search errors");
			return "receiptSearch";
		}
		logger.info("Inside search receipt");
		List<ReceiptModel> receipts = null;
		try {
			receipts = receiptService.searchReceipts(receiptQuery);
		} catch(Exception ex) {
			ex.printStackTrace();
			logger.error("Error while searching receipts. Message: "+ex.getMessage());
		}
		model.addAttribute("receiptQuery", receiptQuery);
		model.addAttribute("receipts", receipts);
		return "searchReceipt";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
	
	/*@SuppressWarnings("unchecked")
	@ModelAttribute
	public Map getPhoneTypeList() {
		Map<String, String> phoneTypes = new LinkedHashMap<String, String>();
		phoneTypes.put("mobile", "mobile");
		phoneTypes.put("home", "home");
		phoneTypes.put("work", "work");
		Map phoneTypeList = new HashMap();
		phoneTypeList.put("phoneTypeList", phoneTypes);
		return phoneTypeList;
	}*/
}
