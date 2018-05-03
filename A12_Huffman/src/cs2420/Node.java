package cs2420;

import static cs2420.Utility.printable_symbol;

/**
 * Represents a single node of a Huffman Tree.
 * 
 * @author Tony Diep, Alex Cervantes, last updated 4-25-17
 */
public class Node implements Comparable<Node> 
{
	// The symbol for this Node
	private String symbol;
	// Left child
	private Node left;
	// Right child
	private Node right;
	// Frequency count for this node's symbol
	private int frequency;
	// References to other nodes
	private Node parent;

	/**
	 * Constructs a leaf node.
	 * 
	 * @param sym
	 *            - the symbol
	 * @param frequency
	 *            - how often the symbol occurs
	 */
	public Node(String sym, int frequency) 
	{
		this.symbol = sym;
		this.frequency = frequency;
	}

	/**
	 * Constructs an internal node. Note that a non-leaf/internal node has a
	 * weight (sum of the weights of its children) but no character.
	 * 
	 * @param left
	 *            - left child of the new node
	 * @param right
	 *            - right child of the new node
	 */
	public Node(String sym, Node left, Node right) 
	{
		this(sym, 0);
		this.left = left;
		this.right = right;
	}

	/**
	 * @return the symbol associated with the node
	 */
	public String get_symbol() 
	{
		return symbol;
	}

	/**
	 * concisely print the Node
	 */
	public String toString() 
	{
		return "<" + symbol + ", " + frequency + ">";
	}

	/**
	 * @return true if a leaf (valid symbol) node
	 */
	boolean leaf() 
	{
		return this.left == null && this.right == null;
	}

	/**
	 * Setter for parent node
	 * 
	 * @param parent
	 */
	public void set_parent(Node parent) 
	{
		this.parent = parent;
		this.parent.frequency += this.frequency;
	}

	/**
	 * @return the parent of this node
	 */
	public Node get_parent() 
	{
		return parent;
	}

	/**
	 * @return the left child of the parent of this node
	 */
	public Node parents_left() 
	{
		return this.parent.left;
	}

	public Node parents_right() 
	{
		return this.parent.right;
	}

	/**
	 * @return the weight (frequency of appearance) associated with this node
	 */
	public int get_frequency() 
	{
		return frequency;
	}

	/**
	 * add one to the frequency field
	 */
	public void increment_frequency() 
	{
		frequency++;
	}

	/**
	 * WARNING: only call this method on the "root" of the tree
	 * 
	 * Returns the symbol encoded by a bit string, by traversing the path from
	 * the root of the tree to the leaf node containing the character. A '0' in
	 * the bit string causes the path to follow a left child, and a '1' in the
	 * bit string causes the path to follow a right child.
	 * 
	 * @param code
	 *            - bit string to be decoded, such as "01010001"
	 * @return return null if the bit string does not lead to a symbol,
	 *         otherwise return the symbol string
	 */
	String get_symbol(String code) 
	{
		Node currNode = this;

		for (int index = 0; index < code.length(); index++) 
		{
			if (code.charAt(index) == '0') {
				currNode = currNode.left;
			} else {
				currNode = currNode.right;
			}

			if (currNode.leaf()) {
				return currNode.symbol;
			}

		}
		return null;
	}

	/**
	 * @return the left most child of this node
	 */
	private Node left_most_child() 
	{
		Node currNode = this;

		while (currNode.left != null) 
		{
			currNode = currNode.left;
		}

		return currNode;
	}

	/**
	 * Compare two Huffman nodes, using frequencies.
	 * 
	 * @param rhs
	 *            - right-hand side node
	 * @return a value > 0 if this node is larger than rhs, a value < 0 if this
	 *         node is smaller than rhs, 0 if the nodes are equal
	 * 
	 *         larger means node occurs more often (has a higher frequency).
	 *         when tied, compare the symbol of this node's left most child vs
	 *         the symbol of rhs.left_most_child
	 */
	public int compareTo(Node rhs) 
	{
		int result = this.frequency - rhs.frequency;

		if (result == 0) 
		{
			//Compare left most children
			Node thisLeftMost = this.left_most_child();
			Node othersLeftMost = rhs.left_most_child();
			
			//Both nodes have leftmost children
			if (thisLeftMost != null && othersLeftMost != null) 
			{
				result = thisLeftMost.get_symbol().compareTo((othersLeftMost.get_symbol()));
			} 
			//This node has a leftmost child but not the other node
			else if (thisLeftMost != null && othersLeftMost == null) 
			{
				result = thisLeftMost.get_symbol().compareTo(rhs.get_symbol());
			} 
			//This node doesn't have a leftmost child but the other node does
			else if (thisLeftMost == null && othersLeftMost != null) 
			{	
				result = this.get_symbol().compareTo(othersLeftMost.get_symbol());
			} 
			//Both nodes don't have a leftmost child
			else 
			{
				result = this.get_symbol().compareTo(rhs.get_symbol());
			}
		}

		return result;
	}

	// ------------------ DOT description methods and data
	// -------------------------------

	static int null_count = 0;

	/**
	 * write the edges in the graph in the form used by the DOT language
	 * 
	 * @param print_line
	 *            - the file to print to
	 * @param null_count
	 *            - to keep track of nice "null" edges, we need this as each one
	 *            has to have a new name
	 */
	public String createDot() 
	{
		String result = "";

		null_count = 0;

		result += "digraph huffman_tree{\n";

		result += "\thuffman_root -> " + this.symbol + ";\n";
		result += "\thuffman_root [shape=\"none\"];\n";

		// recursively build the dot file
		result += write_dot_helper();

		// create all the null values so they look good
		for (int i = 0; i < null_count; i++) {
			result += "null" + i + " [shape=point];\n";
		}

		result += "}";

		return result;
	}

	/**
	 * create the DOT syntax for a graph
	 * 
	 * @param print_line
	 */
	public String write_dot_helper() 
	{
		String result = "";

		String label = printable_symbol(this.symbol);

		if (leaf()) {
			result += "\t" + label + " [label=\"" + label + "\\n" + this.frequency + "\"]\n";

			return result;
		}

		result += "\t" + label + " [label=\"" + label + "\\n" + this.frequency + "\"]\n";

		if (this.left == null || this.right == null) {
			System.out.println("ERROR");
			throw new RuntimeException(" nodes must eith have 0 or 2 children");
		}

		String left_label = printable_symbol(left.symbol);
		String right_label = printable_symbol(right.symbol);

		result += "\t" + label + "-> " + left_label + "[ label=0 ]\n";
		result += "\t" + label + "-> " + right_label + "[ label=1 ]\n";
		result += this.left.write_dot_helper();
		result += this.right.write_dot_helper();

		return result;
	}
}
