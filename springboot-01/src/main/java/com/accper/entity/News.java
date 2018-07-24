package com.accper.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class News {
	@Value("${com.accper.title}")
	private String title;
	@Value("${com.accper.content}")
	private String content;

	public News() {
		super();
	}

	public News(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "News [title=" + title + ", content=" + content + "]";
	}

}
