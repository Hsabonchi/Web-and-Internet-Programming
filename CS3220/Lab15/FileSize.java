package cs3220.tag;

import java.io.IOException;
import java.lang.Math;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class FileSize extends SimpleTagSupport {
	
	
	int value;
	

	public void setValue(int value) {
		this.value = value;
	}

	  @Override
	 public void doTag() throws JspException, IOException
	    {
		 JspWriter out = getJspContext().getOut();
		
		
		if(value< Math.pow(2,10)) {
			out.println(value+"B");
			
		}
		
	
		
		else if(value >= Math.pow(2,10) &&value< Math.pow(2,20)) {
			out.println((int) Math.round(value/1024)+"KB");
			
		}
		
		else if(value>= Math.pow(2,20) ) {
			
			//Math.round((Math.ceil(value/1024)/1024),2);
			out.println((int)Math.round(value/Math.pow(1024, 2))+"MB");
			
		}
		
	}


	

	

}
