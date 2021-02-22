package helper;

import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class Helper {	
	
	  public static void mapsToJson() throws IOException {
	      ObjectMapper mapper = new ObjectMapper();
	      String jsonString = "";
	      Map<String, Object> map = new HashMap<String, Object>();
	      map.put("Prasad", "Test Lead");
	      map.put("Rupesh", "Automation Tester");
	      map.put("Glenn", "Project Manager");
	      map.put("Vamsi", "Web Technology");
	      jsonString = mapper.writeValueAsString(map); // converts Map to JSON
	      System.out.println(map);
	      System.out.println(jsonString);
	   }
	  
	  
	  public static void csvToJson(String absolutePathOfcsvFile )
	  {
		  try (InputStream in = new FileInputStream(absolutePathOfcsvFile);) {
			    CSV csv = new CSV(true, ',', in );
			    List < String > fieldNames = null;
			    if (csv.hasNext()) fieldNames = new ArrayList < > (csv.next());
			    List < Map < String, String >> list = new ArrayList < > ();
			    while (csv.hasNext()) {
			        List < String > x = csv.next();
			        Map < String, String > obj = new LinkedHashMap < > ();
			        for (int i = 0; i < fieldNames.size(); i++) {
			            obj.put(fieldNames.get(i), x.get(i));
			        }
			        list.add(obj);
			    }
			    
			    ObjectMapper mapper = new ObjectMapper();
			    mapper.enable(SerializationFeature.INDENT_OUTPUT);
			    mapper.writeValue(System.out, list);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	  
//	  public static void main(String[] args) {
//		  
//		  System.out.println("-------------------- CSV to Json 01-----------------------------");
//		  helper.Helper.csvToJson(".\\testdata\\sampleCsvTestData.txt");
//		  
//		  
//		  System.out.println("-------------------- CSV to Json 02-----------------------------");
//		  try {			
//			  helper.Helper.mapsToJson();
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}	  
//		  
//	}
	  
	
	  
	  
	  
}


