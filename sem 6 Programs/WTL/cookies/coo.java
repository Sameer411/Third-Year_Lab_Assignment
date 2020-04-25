import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class CookieExample extends HttpServlet {
	private String names[] = { "C", "C++", "Java","Visual Basic " };
	private String isbn[] = {"c---", "c++---","j---", "v---" };
	public void doPost( HttpServletRequest request,HttpServletResponse response )throws ServletException, IOException
	{
		PrintWriter output;
		String language = request.getParameter( "lang" );
		Cookie c = new Cookie( language, getISBN( language) );
		c.setMaxAge( 1200 ); // seconds until cookie removed
		response.addCookie( c ); // must precede getWriter
		response.setContentType( "text/html" );
		output = response.getWriter();
		output.println( "<HTML><HEAD><TITLE>" );
		output.println( "Cookies" );
		output.println( "</TITLE></HEAD><BODY>" );
		output.println( "<P>Welcome to Cookies!<BR>" );
		output.println( "<P>" );
		output.println( language );
		output.println( " is a great language." );
		output.println( "</BODY></HTML>" );
		output.close(); // close stream


	}
	public void doGet( HttpServletRequest request,HttpServletResponse response )throws ServletException,IOException
	{
		PrintWriter output;
		Cookie cookies[];
		cookies = request.getCookies(); // get client'scookies
		response.setContentType( "text/html" );
		output = response.getWriter();
		output.println( "<HTML><HEAD><TITLE>" );
		output.println( "Cookies II" );
		output.println( "</TITLE></HEAD><BODY>" );
		if ( cookies != null ) 
		{
			output.println( "<H>Recommendations</H>" );
			for ( int i = 0; i < cookies.length; i++ )
			output.println(cookies[ i ].getName() + " How to Program." +"ISBN#: " + cookies[ i ].getValue() +"<BR>" );
		}
		else {
			output.println( "<H>No Recommendations</H>" );
			output.println( "You did not select a languageor" );
			output.println( "the cookies have expired." );


		}
output.println( "</BODY></HTML>" );
output.close(); // close stream


}
private String getISBN( String lang )
{
	for ( int i =0 ; i < names.length; ++i )
		if ( lang.equals( names[ i ] ) )
		return isbn[ i ];
	
	return ""; // no matching string found


}


}

