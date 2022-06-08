package com.tmobile.edrdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.tmobile.edrdemo.domain.ColumnNames;
import com.tmobile.edrdemo.domain.Product;
import com.tmobile.edrdemo.service.ColumnNamesService;
import com.tmobile.edrdemo.service.ProductService;

@RestController
public class MainController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ColumnNamesService columnNamesService;
	
	@GetMapping("/columnNames/{tableName}")
	public List<ColumnNames> findByTableName(@PathVariable String tableName)	{
		return columnNamesService.findByTableName(tableName);
	}
	
	private String message = "Hello World";

	@GetMapping("/hello")
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("message", this.message);
		return model;
	}

	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return productService.findAll();
	}
	
	@GetMapping("/decoms")
	public String findData() {
		String url = "https://gw.qtm.t-mobile.com/exe/prod/query/GET_SITE_DECOMM_FORECAST_MSISDN_KPI_DAILY?params=EVENT_NAME:Decomm Forecast,LOAD_DATE:2022-06-01,SITE_LIST:'LA12AL014'&subscription-key=e1a52d0bc22b4612a490b1e025674ee1";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url,String.class);
		return result;
	}
	
	@GetMapping("/yellow")
	public String anotherWelcome(Model model) {
        model.addAttribute("message", "Hello! Thank me!");
        return "anotherwelcome";
	}
	
	//-Djavax.net.debug=all -Djavax.net.ssl.trustStore=trustStore        
	@GetMapping("/decomforecast")
	public ModelAndView getDecomForecast() {
		String url = "https://gw.qtm.t-mobile.com/exe/prod/query/GET_SITE_DECOMM_FORECAST_MSISDN_KPI_DAILY?params=EVENT_NAME:Decomm Forecast,LOAD_DATE:2022-06-01,SITE_LIST:'LA12AL014'&subscription-key=e1a52d0bc22b4612a490b1e025674ee1";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url,String.class);
	//	Object[] results = restTemplate.getForObject(url,Object[].class);
		ModelAndView model = new ModelAndView("decomsites");
		model.addObject("sitelist", result);
	//	model.addObject("sitelist", Arrays.asList(results));
        return model;
	}

}
