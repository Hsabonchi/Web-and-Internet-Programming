

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CurrencyConverter
 */
@WebServlet("/CurrencyConverter")
public class CurrencyConverter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CurrencyConverter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		super.init( config );
		
		  Map<String, Double> data = new HashMap<String, Double>();

	        try
	        {
	            // read file
	            Scanner in;
	            in = new Scanner( new File(getServletContext().getRealPath( "/WEB-INF/rates.txt" ) ) );
	            while( in.hasNextLine() )
	            {
	                String line = in.nextLine();
	                String tokens[] = line.split( " " );
	                data.put( tokens[0], Double.valueOf( tokens[1] ) );
	            }
	            in.close();
	        }
	        catch( FileNotFoundException e )
	        {
	            throw new ServletException( e );
	        }

	        getServletContext().setAttribute( "data", data );		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.getRequestDispatcher("/WEB-INF/Currency.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Double> data = (Map<String, Double>) getServletContext().getAttribute( "data" );
		
		String c1 = request.getParameter( "c1" );
        String c2 = request.getParameter( "c2" );
       
       double amount = Double.parseDouble( request.getParameter( "amount" ) );
       double result = amount * data.get( c2 ) / data.get( c1 );
       
       
       getServletContext().setAttribute( "c1", c1 );
       getServletContext().setAttribute( "c2", c2 );
       
       
       
  
      getServletContext().setAttribute( "amount", amount );
      getServletContext().setAttribute( "result", result );
       request.getRequestDispatcher("/WEB-INF/Currenct.Result.jsp").forward(request, response);
		
		
		
	}

}
