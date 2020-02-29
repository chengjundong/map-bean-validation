package jundong.cheng.learnbeanvalidation;

import java.util.Map;
import java.util.StringJoiner;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MapKeyValidator implements ConstraintValidator<ContainsKey, Map<String, String>> {
	
	private String[] keys;
	
	@Override
	public void initialize(ContainsKey constraintAnnotation) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>> init MapKeyValidator" + this.toString());
		keys = constraintAnnotation.keys();
	}
	
	@Override
	public boolean isValid(Map<String, String> value, ConstraintValidatorContext context) {
		
		context.disableDefaultConstraintViolation();
		
		if(value == null || value.size() == 0) {
			context.buildConstraintViolationWithTemplate("input map is empty!")
		        .addConstraintViolation();
			return false;
		}
		
		boolean isValid = true;
		StringJoiner sj = new StringJoiner(",");
		for(String key : keys) {
			if(!value.containsKey(key)) {
				isValid = false;
				sj.add(key);
			}
		}
		
		if(!isValid) {
			context.buildConstraintViolationWithTemplate(String.format("miss the required key: [%s]", sj.toString()))
				.addConstraintViolation();
		}
		
		return isValid;
	}

}
