package atg.src;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service1")
public class AtgService1Controller {
	@RequestMapping(value="/{text}", method=RequestMethod.GET, produces="application/json")
    public Message message(@PathVariable String text) {
        Message msg = new Message(text);
        return msg;
    }
}
