package actions.forms;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

import postgreSQLDatabase.forms.Query;

/**
 * Servlet implementation class createpdf
 */
public class createpdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createpdf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//PrintWriter writer=response.getWriter();
	
		
		 
		int  totalFields = Integer.parseInt(request.getParameter("no"));
		
		     String[] fieldsValue=new String[totalFields+1]; 
		
		     
		     
		for(int i=1;i<=totalFields;i++){
			fieldsValue[i]=request.getParameter(Integer.toString(i));
			
		}
		
		String formname=request.getParameter("formname");

		String format=Query.getFormat(formname);
		
		 for(int j=1;j<=totalFields;j++){
			 
			  format=format.replace("a"+Integer.toString(j)+"z", fieldsValue[j]);
			 
		 }
		
	
			//writer.write(format);
		 
		 //File file=new File("Test.pdf");response.getOutputStream()
		 
		// OutputStream file = new FileOutputStream(new File("Test.pdf")
//		 PrintWriter writer=response.getWriter();
//		 writer.write("hello");
			
			response.setContentType("application/pdf");
			
			Document document =new Document();
			
			
			try{
				PdfWriter.getInstance(document,response.getOutputStream());
				
				document.open();
				
				  HTMLWorker htmlWorker = new HTMLWorker(document);
				    htmlWorker.parse(new StringReader(format));
			
				document.close();
				
			}catch(DocumentException e){
				e.printStackTrace();
			}
	
		
		
		
		
		
		
		
		
	}

}
