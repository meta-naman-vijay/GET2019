import java.util.Map;

public interface Dictionary {

    /** Method to add new entry to dictionary. The new entry will be added as a Node object
     * @param newNode object.
     */
     void add(Node newNode);
	
    /** Method to delete an existing entry from the dictionary.
     * @param root of BST
     * @param key to be deleted.
     * @return deleted node.
     */
     Node delete(Node root,int key);
	
    /**Method to sort the entries based on key values of BST.
     * @param root
     * @return Sorted HashMap of key-value pairs.
     */
     Map<Integer, String> sort(Node root);
	
    /** Method to sort the entries based on key ranging between given keys k1 & k2 both inclusive.
     * @param root of BST.
     * @param key1 
     * @param key2 
     * @return Sorted HashMap key-value pair.
     */
     Map<Integer, String> sortInRange(Node root, int key1, int key2);
}