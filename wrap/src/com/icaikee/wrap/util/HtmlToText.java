package com.icaikee.wrap.util;

import java.io.IOException;
import java.io.Reader;

import javax.swing.text.html.HTMLEditorKit.ParserCallback;
import javax.swing.text.html.parser.ParserDelegator;

public class HtmlToText extends ParserCallback {

	StringBuffer s;

	public HtmlToText() {
	}

	public void parse(Reader in) throws IOException {
		s = new StringBuffer();
		ParserDelegator delegator = new ParserDelegator();
		// the third parameter is TRUE to ignore charset directive
		delegator.parse(in, this, Boolean.TRUE);
	}

	public void handleText(char[] text, int pos) {
		s.append(text);
	}

	public String getText() {
		return s.toString();
	}

	public String get150Text() {
		if (s.toString().length() > 150)
			return s.toString().substring(0, 150) + "...";
		else
			return s.toString();
	}

}
