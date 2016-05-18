package main.hav.tags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

@SuppressWarnings("serial")
public class CopyrightTagHandler extends TagSupport{
	String name;
	String year;
	
	@Override
	public int doStartTag(){
		JspWriter out = pageContext.getOut();
		
		try {
			out.print("<hr><center> Copyright by (c) " + name + ", " + year + "</center>" );
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
}
