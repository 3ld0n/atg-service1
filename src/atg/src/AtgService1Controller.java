package atg.src;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service1")
public class AtgService1Controller {
	private RestCall<Message2> service2 = new RestCall<Message2>("http://localhost:8888/service2/one", Message2.class);
	private RestCall<Message3> service3 = new RestCall<Message3>("http://localhost:8888/service3", Message3.class);
	@RequestMapping(value="/one/{text}", method=RequestMethod.GET, produces="application/json")
    public Message1 singleMessage(@PathVariable String text) {
        Message1 msg = new Message1(text);
        return msg;
    }
	@RequestMapping(value="/all/{text}", method=RequestMethod.GET, produces="application/json")
    public Message allMessage(@PathVariable String text) {
        Message1 msg1 = null;
        Message2 msg2 = null;
        Message3 msg3 = null;
        try {msg1 = new Message1(text);} catch(Exception e) {}
        try {msg2 = service2.get(text);} catch(Exception e) {}
        try {msg3 = service3.get(text);} catch(Exception e) {}
        return new Message(msg1, msg2, msg3);
    }
}
