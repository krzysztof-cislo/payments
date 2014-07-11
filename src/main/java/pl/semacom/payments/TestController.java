package pl.semacom.payments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Krzysztof on 2014-07-08.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/{name}", method = GET)
    public @ResponseBody String getMovie(@PathVariable String name) {
        return name;
    }

}
