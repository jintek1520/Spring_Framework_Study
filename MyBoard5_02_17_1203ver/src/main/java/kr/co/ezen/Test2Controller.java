package kr.co.ezen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/t2")
public class Test2Controller {
	
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public void test4() {
		
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public void test3() {
		
	}
	
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public void test2() {
		
	}
	
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public void test1() {
		
	}
}
