import javax.xml.parsers.*;   // JAXP classes for parsing
import org.w3c.dom.*;         // W3C DOM classes for traversing the document
import org.xml.sax.*;         // SAX classes used for error handling by JAXP
import java.io.*;             // For reading the input file

public class xmlParser
{

	public static void main (String[] args)
	{
	    xmlParser xml = new xmlParser();
        try {
            xml.process( args );
        } catch( Exception e ) { e.printStackTrace(); }
	}
    
    /**
     * Find the "message" node.  It should end with "Request"
     */
    private void process( String[] args ) throws Exception
    {

        org.w3c.dom.Document doc = null;
        javax.xml.parsers.DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(false);
        javax.xml.parsers.DocumentBuilder parser = dbf.newDocumentBuilder();
        
        File f = new File( "sba.xml" );
        if ( !f.exists() )
        {
            System.out.println( f.getPath() + " does not exist" );
            return;
        }
        
        doc = parser.parse( f );
        NodeList nl = doc.getChildNodes();
        Node nodeDef = doc.getFirstChild();
        if ( !nodeDef.getNodeName().equals( "definitions" ) )
            throw new Exception( f.getPath() + " is not a valid WSDL file" );
        
        
        
    }
}


