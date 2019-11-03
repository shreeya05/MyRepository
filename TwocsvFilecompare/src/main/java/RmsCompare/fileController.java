package RmsCompare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@EnableAutoConfiguration
public class fileController {

	@Autowired
	fileReader reader;

	@RequestMapping("/reader")
	@ResponseBody
	public String csvReader() {

		reader.rmsCompare();

		return "hello shreeya...";
	}

}
