package jundong.cheng.learnbeanvalidation;

import java.util.Map;

public class Request {

	@ContainsKey(keys = { "rrpFlowId" })
	private Map<String, String> attributes;

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
}
