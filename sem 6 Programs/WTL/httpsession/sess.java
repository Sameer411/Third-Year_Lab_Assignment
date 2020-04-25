
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class SessionExample extends HttpServlet {
	private final static String names[] ={ "C", "C++", "Java", "Visual Basic " };
	private final static String isbn[] = {"c---", "c++---","j---", "v---" };
	public void doPost( HttpServletRequest request,HttpServletResponse response )throws ServletException, IOException
	{
		PrintWriter output;
		String language = request.getParameter( "lang" );
		HttpSession session = request.getSession( true );
		// add a value for user's choice to session
		session.putValue( language, getISBN( language ) );
		response.setContentType( "text/html" );
		output = response.getWriter();
		// send HTML page to client
		output.println( "<HTML><HEAD><TITLE>" );
		output.println( "Sessions" );
		output.println( "</TITLE></HEAD><BODY>" );
		output.println( "<P>Welcome to Sessions!<BR>" );
		output.println( "<P>" );
		output.println( language );
		output.println( " is a great language." );
		output.println( "</BODY></HTML>" );
		output.close(); // close stream
	}

	public void doGet( HttpServletRequest request,HttpServletResponse response )throws ServletException,IOException
	{
		PrintWriter output;
		HttpSession session = request.getSession( false );
		String valueNames[];
		if ( session != null )
			valueNames = session.getValueNames();
		else
			valueNames = null;
		response.setContentType( "text/html" );
		output = response.getWriter();
		output.println( "<HTML><HEAD><TITLE>" );
		output.println( "Sessions II" );
		output.println( "</TITLE></HEAD><BODY>" );
		if ( valueNames != null && valueNames.length != 0)
		{
			output.println( "<H>Recommendations</H>" );
			for ( int i =0 ; i < valueNames.length; i++ ) {
				String value =(String) session.getValue( valueNames[ i ]);
				output.println(valueNames[ i ] + " How to Program. " +"ISBN#: " + value + "<BR>" );
			}
		}
output.println( "</BODY></HTML>" );
output.close(); // close stream


}
private String getISBN( String lang )
{
	for ( int i = 0; i < names.length; ++i )
		if ( lang.equals( names[ i ] ) )
			return isbn[ i ];
	return ""; // no matching string found


}


}