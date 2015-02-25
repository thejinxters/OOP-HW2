import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;

interface Terrain
{
	void draw(Graphics graphics, int x, int y);
}
class Tree implements Terrain
{
	private int x;
	private int y;
	private Image image;
	public Tree(String type)
	{
		System.out.println("Creating a new instance of a tree of type " + type);
		String filename = "tree" + type + ".png";
		try
		{
			image = ImageIO.read(new File(filename));
		} catch(Exception exc) { }
	}
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	public int getX() { return x; }
	public int getY() { return y; }
	@Override
	public void draw(Graphics graphics, int x, int y)
	{
		graphics.drawImage(image, x, y, null);
	}
    public static Tree getInstance(){
        return null;
    }
}
class AppleTree extends Tree
{
    private static Tree tree;

    private AppleTree(){
        super("Apple");
    }

    public static Tree getInstance(){
        if (tree == null){
            tree = new AppleTree();
        }
        return tree;
    }
}
class LemonTree extends Tree
{
    private static Tree tree;

    private LemonTree(){
        super("Lemon");
    }

    public static Tree getInstance(){
        if (tree == null){
            tree = new LemonTree();
        }
        return tree;
    }
}
class BlobTree extends Tree
{
    private static Tree tree;

    private BlobTree(){
        super("Blob");
    }

    public static Tree getInstance(){
        if (tree == null){
            tree = new BlobTree();
        }
        return tree;
    }
}
class ElmTree extends Tree
{
    private static Tree tree;

    private ElmTree(){
        super("Elm");
    }

    public static Tree getInstance(){
        if (tree == null){
            tree = new ElmTree();
        }
        return tree;
    }
}
class MapleTree extends Tree
{
    private static Tree tree;

    private MapleTree(){
        super("Maple");
    }

    public static Tree getInstance(){
        if (tree == null){
            tree = new MapleTree();
        }
        return tree;
    }
}
class TreeFactory
{
	private static final ArrayList<Tree> mylist = new ArrayList<Tree>();
	public static Terrain getTree(String type)
	{
//		Original Code:
//      Tree tree = new Tree(type);
//		mylist.add(tree);
//		return tree;

        //Implement Factory Design Pattern
        System.out.println("Enter Factory Class 'getTree()' method");
        Tree tree = null;
        if (type.equals("Apple")) {
            tree = AppleTree.getInstance();
        }
        else if (type.equals("Lemon")) {
            tree = LemonTree.getInstance();
        }
        else if (type.equals("Blob")) {
            tree = BlobTree.getInstance();
        }
        else if (type.equals("Elm")) {
            tree = ElmTree.getInstance();
        }
        else if (type.equals("Maple")) {
            tree = MapleTree.getInstance();
        }
        // Ability to add more tree types here!
        else {
            System.out.println("Type is not an available tree type");
        }
        return tree;
   }
}
/**
 * Don’t change anything in TreeDemo
 */
class TreeDemo extends JPanel
{
	private static final int width = 800;
	private static final int height = 700;
	private static final int numTrees = 5000;
	private static final String type[] = { "Apple", "Lemon", "Blob", "Elm", "Maple" };

	public void paint(Graphics graphics)
	{
		for(int i=0; i < numTrees; i++) 
		{
			Tree tree = (Tree)TreeFactory.getTree(getRandomType());
			tree.draw(graphics, getRandomX(width), getRandomY(height));
		}
	}
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame();
		frame.add(new TreeDemo());
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	private static String getRandomType() 
	{
		return type[(int)(Math.random()*type.length)];
	}
	private static int getRandomX(int max) 
	{
		return (int)(Math.random()*max );
	}
	private static int getRandomY(int max) 
	{
		return (int)(Math.random()*max);
	}
}

