package BMI;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BMICalculator
 */
@WebServlet("/BMICalculator")
public class BMICalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public BMICalculator() {
        super();
       
    }
    
     public double BodymassCalculator(double weight,double height) {
    	 final double KILOGRAMS_PER_POUND = 0.4536; // Constant
    	 
    	  double METERS_PER_fett = 0.3048; // Constant
    	 
    	  double weightInKilograms = weight * KILOGRAMS_PER_POUND;
    	 
    	 
    	  double heightInMeters = height * METERS_PER_fett;
    	  
    	  double bmi = (weightInKilograms /(heightInMeters * heightInMeters));
    	
    	 System.out.println("weightInKilograms"+weightInKilograms);
    	 System.out.println("METERS_PER_fett"+METERS_PER_fett);
    	  
		return bmi;
       
       
    }
    
    

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		   PrintWriter out = response.getWriter();
		    response.setContentType( "text/html" );
		    out.println("<html>");
		    
		    out.println("<head><title>BMI CalCulator</title>");
		    out.println("</head>");
		    out.println("<body>");
		    
		    out.println("<h2>BMI CalCulatot:</h2> <br>");
		    
		    out.println("<form  method='post'>  "
		    + ""+"Please enter your height:"+ "<input type='text' name='H_f'>"+"feet and " + "<input type='text' name='H_in'>"+"inches"
		    +"<br>"+ "Please enter your weight: "+"<input type='text' name='w'>"+"Ponds"
		    
		             +"<br>"+"<br>"
		    		+ "<input type='submit' value='CalculateBMI' name='submit'>"
		    		+ "</form>");
		    out.println("</body></html>");
		
		
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String H=request.getParameter("H_f");
		 String H_Inch=request.getParameter("H_in");
		 String W=request.getParameter("w");
		
		  double Height_feet=Double.parseDouble(H);
		  double H_Ich=Double.parseDouble(H_Inch);
		  double Weight=Double.parseDouble(W);
		  //prin
		  
		  System.out.println("Height_feet"+Height_feet);
		  System.out.println("H_Ich" +H_Ich);
		  System.out.println("Weight"+Weight);
		  
		  
		  //convert to Inches
		  Height_feet+=(H_Ich/12);
		  
		  //Height_feet*=12;
		 
		  
		  
		  double BMI =BodymassCalculator(Weight,Height_feet);
		  BMI=Math.round(BMI * 10) / 10.0;
		  //System.out.print(BMI);
		  
		  
		  
		  String status;
		  if (BMI < 18.5)
			  status= "Underweight";
		   else if (BMI >=18.5 && BMI  < 25.0)
			   status= "Normal";
			else if (BMI <= 30 && BMI>=25 )
				  status="Overweight";
				  
			  else
				  status="Obese";;
		  
		  
         
		PrintWriter out = response.getWriter();
	    response.setContentType( "text/html" );
	    out.println("<html>");
	    
	    out.println("<head><title>BMI CalCulator</title>");
	    out.println("</head>");
	    out.println("<body>");
	    
	    out.println("<h2>Your BMI is :"+BMI  +"	</h2>"+"   "+" You Are  " +status+"<br>");
	    
	    out.println("<p><a href='./BMICalculator'>Back to BMI Calculator\n" + 
	    		"\n" + 
	    		"</a></p>");
	    out.println("</body></html>");
	
		
		
		
		
		
	}

}
