import java.util.HashMap;
import java.util.Map;

/**
 * Component class to create Binary Search tree for implementing Dictionary.
 * some methods to add and sort entries.
 */
public class BinarySearchTree implements Dictionary {

	public BinarySearchTree(Node newNode) {
		this.add(newNode);
	}

	Node root;

	Map<Integer, String> sortedMap = new HashMap<Integer, String>();
	Map<Integer, String> sortedRangeMap = new HashMap<Integer, String>();

	/**
	 * Method to add node in BST
	 */
	public void add(Node newNode) {
		if (root == null)
			root = newNode;
		else {
			Node current = root;
			Node prev = root;
			while (current != null) {
				prev = current;
				if (newNode.key > current.key)
					current = current.right;
				else
					current = current.left;
			}
			if (prev.key > newNode.key)
				prev.left = newNode;
			else
				prev.right = newNode;
		}
	}

	/**
	 * Method to get Value corresponding to key
	 */
	public String getValue(Node root, int key) {
		if (root.key > key)
			return getValue(root.left, key);
		if (root.key < key)
			return getValue(root.right, key);
		else
			return root.value;
	}

	/**
	 * Method to delete node From BST
	 */
	public Node delete(Node root, int key) {
		if (root == null)
			return null;
		else if (key < root.key) {
			root.left = delete(root.left, key);
		} else if (key > root.key) {
			root.right = delete(root.right, key);
		} else {
			// When deleted node is leaf node.
			if (root.left == null && root.right == null)
				return null;
			// When left child of deleted node doesn't exist.
			else if (root.left == null)
				root = root.right;
			// When left child of deleted node doesn't exist.
			else if (root.right == null)
				root = root.left;
			// When both child of deleted node exist.
			else {
				Node successorOfRoot = findSuccessor(root.right, root);
				root.key = successorOfRoot.key;
				root.value = successorOfRoot.value;
				root.right = delete(root.right, successorOfRoot.key);
			}
		}
		return root;
	}

	/**
	 * Method to sort 
	 * It traverse in order
	 */
	public Map<Integer, String> sort(Node root) {
		if (root.left != null)
			sort(root.left);

		// Adding key value to map.
		sortedMap.put(root.key, root.value);
		if (root.right != null)
			sort(root.right);
		return sortedMap;
	}

	/**
	 * * Method to sort between given key range
	 * It traverse in order
	 */
	public Map<Integer, String> sortInRange(Node root, int key1, int key2) {
		if (root.left != null)
			sortInRange(root.left, key1, key2);

		// Adding key value pair to map.
		if (root.key >= key1 && root.key <= key2)
			sortedRangeMap.put(root.key, root.value);

		// If the keys get out of range.
		if (root.key > key2)
			return sortedRangeMap;
		if (root.right != null)
			sortInRange(root.right, key1, key2);
		return sortedRangeMap;
	}

	/**
	 * Method to find Successor of a node
	 */
	private Node findSuccessor(Node root, Node prevRoot) {
		if (root.left != null)
			root = findSuccessor(root.left, root);

		return root;
	}
}