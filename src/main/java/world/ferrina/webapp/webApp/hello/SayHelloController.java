package world.ferrina.webapp.webApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("/hi")
//	@ResponseBody
	public String hii()
	{
		return "Hi World and Abhay";
	}
	
	@RequestMapping("/hi-html")
	@ResponseBody
	public StringBuffer hiiHtml()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("""
				<!Doctype html>
				<html lang="en">
					<body>
					<h1>Hello Abhay From Html
					</h1>
					</body>
				</html>
				""");
		return sb;
	}
	

	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	
}
