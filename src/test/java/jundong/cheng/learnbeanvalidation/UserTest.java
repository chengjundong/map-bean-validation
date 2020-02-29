package jundong.cheng.learnbeanvalidation;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Test;

public class UserTest {

	@Test
	public void test() throws Exception {
		User user = new User();
		user.setWorking(true);
		user.setAboutMe("Its all about me!");
		user.setAge(50);
		user.setName("jared");
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("hello", "hello");
		user.setAttributes(map);
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		
		for (ConstraintViolation<User> constraintViolation : validator.validate(user)) {
			System.out.println(constraintViolation);
		}
		
		Request request = new Request();
		Map<String,String> map2 = new HashMap<String, String>();
		map2.put("hello", "hello");
		request.setAttributes(map2);
		for (ConstraintViolation<Request> constraintViolation : validator.validate(request)) {
			System.out.println(constraintViolation);
		}
	}
}
