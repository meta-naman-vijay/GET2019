import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; 

/** 
 *  This class uses JSONParser for parsing data from JSON file.
 */
public class GetJSON {
	
    /** Method to read data from JSON file  
     */
     public List<Node> getJSON() {
         Node treeNode;
         List<Node> list = new ArrayList<Node>(); 	
         try {
             // Parsing Data.json
             Object obj = new JSONParser().parse(new FileReader("input.json"));
             JSONObject jsonObject = (JSONObject) obj;	
             // Fetching dictionary elements.
             JSONArray jsonArray = (JSONArray) jsonObject.get("dictionary");
			
            // Iterating JSON objects.
            Iterator<Map.Entry> iter;
            Iterator iter2 = jsonArray.iterator();
            // Iterating through each JSON object or key-value pairs and adding it to BST.
            while(iter2.hasNext()) {
                iter = ((Map)iter2.next()).entrySet().iterator();
                while(iter.hasNext()) {
                    Map.Entry pair = iter.next();	
                    treeNode = new Node();
                    treeNode.key = Integer.parseInt((String)pair.getKey());
                    treeNode.value = (String) pair.getValue();
                    list.add(treeNode);
                }
            }
         }catch(Exception e) {
              e.printStackTrace();			
         }
         return list;
     }
}