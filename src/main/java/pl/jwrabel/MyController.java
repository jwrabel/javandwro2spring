package pl.jwrabel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jakubwrabel on 25.03.2017.
 */
@Controller
public class MyController {

	@Autowired
	private MyService myService;

	// prosty GET
	// http://localhost:9000
	@RequestMapping // domyślnie GET, domyślnie /
	@ResponseBody
	public String hello() {
		return "Hello stranger!";
	}

	// GET with request param
	//	http://localhost:9000/helloRP?name=Kuba
	@RequestMapping("/helloRP")
	@ResponseBody
	public String helloRP(@RequestParam String name) {
		return "Hello stranger " + name;
	}

	//	http://localhost:9000/helloRP2?firstName=Kuba
	@RequestMapping("/helloRP2")
	@ResponseBody
	public String helloRP2(@RequestParam("firstName") String name) {
		return "Hello stranger " + name;
	}

	// kilka request parametrów
	@RequestMapping("/helloRPMulti")
	@ResponseBody
	public String helloRPMulti(@RequestParam String name, @RequestParam String surname) {
		return "Hello stranger " + name + " " + surname;
	}

	// opcjonalny parametr parametrów
	@RequestMapping("/helloRPOpt")
	@ResponseBody
	public String helloRPOpt(@RequestParam(required = false, defaultValue = "Gall") String name,
							 @RequestParam(required = false, defaultValue = "Anonim") String surname) {
		return "Hello stranger " + name + " " + surname;
	}

	// Path param/path variable
	@RequestMapping("/helloPP/{name}")
	@ResponseBody
	public String helloPP(@PathVariable String name) {
		return "Hello stranger " + name;
	}


	@RequestMapping("/point")
	@ResponseBody
	public Point point() {
		Point point = new Point();
		point.setX(100);
		point.setY(200);
		return point;
	}


}
