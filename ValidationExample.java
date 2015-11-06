import java.io.File;
import java.io.Reader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.thaiopensource.validate.SchemaReader;
import com.thaiopensource.validate.ValidationDriver;
import com.thaiopensource.validate.auto.AutoSchemaReader;


public class ValidationExample {

    public static void main(String[] args) throws SAXException, IOException {

	SchemaReader sr = new AutoSchemaReader();
	ValidationDriver driver = new ValidationDriver(sr);
	
	File schemaFile = new File("docbook.rng");
	InputStream schemaInputStream= new FileInputStream(schemaFile);
	Reader schemaReader = new InputStreamReader(schemaInputStream,"UTF-8");

	File xmlFile = new File("hello-world.xml");
	InputStream xmlInputStream= new FileInputStream(xmlFile);
	Reader xmlReader = new InputStreamReader(xmlInputStream,"UTF-8");

	InputSource schemaInput = new InputSource(schemaReader);
	InputSource sourceInput = new InputSource(xmlReader);
	
	//preparing the temp logfile
	File file = File.createTempFile("transpect-rng-", ".txt");
	FileWriter writer = new FileWriter(file);
	System.setProperty("LtxValidateTempFile", file.getAbsolutePath());
	    
	writer.write(""); 
	writer.flush();
	writer.close();
	
	//validation
	driver.loadSchema(schemaInput);
	driver.validate(sourceInput);
    }
}


