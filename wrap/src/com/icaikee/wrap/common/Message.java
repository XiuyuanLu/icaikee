package com.icaikee.wrap.common;

public class Message {

	private Object message;

	public Message(Object message) {
		this.message = message;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public static Message createSuccessMessage(Object message) {
		return new Message(message);
	}

}
