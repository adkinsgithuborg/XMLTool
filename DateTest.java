import java.util.*;
import java.text.*;
import java.io.*;

public class DateTest
{

	public static void main (String[] args)
	{
	    DateTest dt = new DateTest();
        
        try {
            dt.doIt();
        } catch( Exception e ) { e.printStackTrace(); }
    }
    
    private void doIt() throws Exception
    {
        StringBuffer sb = new StringBuffer( 256 );
        while( System.in.available() > 0 )
        {
            int avail = System.in.available();
            byte[] b = new byte[avail];
            
            int len = System.in.read( b, 0, avail );
            
            char[] c = new char[avail];
            for( int i = 0; i < avail; i++ )
                c[i] = (char)b[i];
            
            for( int j = 0; j < avail; j++ )
                sb.append( c[j] );
        }

        BufferedReader br = new BufferedReader( new StringReader( sb.toString() ) );
        while( true )
        {
            String line = br.readLine();
            if ( line == null )
                break;

            Date myDate = new Date( Long.parseLong( line.trim() ) );
            SimpleDateFormat formatter = new SimpleDateFormat( "dd/MMM/yyyy:HH:mm:ss" );  
            System.out.println( "The formatted date is " + formatter.format( myDate ) );   
        }

	}

}


