package codes;

import java.io.IOException;

public class LinkedGrid {
	private Node root;
	public boolean success;
	public Node rowMarker;
	public Node temp;
	public Node position;
	public int value = 0;

	public LinkedGrid(int dimension) {
		Node temp = new Node();
		root = temp;
		Node marker = root;//marker is also temp
		
		for (int x=0; x < dimension-1; x++)//creates a first row of linked nodes
		{
			temp = new Node();
			marker.setRight(temp);

			temp.setLeft(marker);
			marker = temp;
		}//link the first row
		marker = root;
		Node rowMarker = marker;
		
		for(int z=1; z < dimension; z++)//creates rows of nodes
		{
			temp = new Node();
			marker.setDown(temp);
			//temp = marker.getDown();
			temp.setUp(marker);
			marker = temp;//moves the marker down
			rowMarker = marker;
			
			temp.setLeft(marker);
			marker.setRight(temp);
			temp.setUp(marker.getUp().getRight());
			marker.getUp().getRight().setDown(temp);
			marker = temp;//marker needs to go back to beginning of next row
			marker=rowMarker;
		}
	}//all pointers initially null
	//top row is built first and different from others
	public void set()
	{
		while(temp!=null)
		{
			temp = root;
			while(temp!=null)//sets all spaces to be open
			{
				temp.setData(0);
				temp = temp.getRight();
			}
			temp = rowMarker.getDown();//moves to next row
			if(rowMarker.getDown() !=null)
			{
				rowMarker = temp;
			}
		}
		position = root;	//sets starting position
		position.setData(0);
	}
	public boolean move()throws IOException
	{

		try
		{	
			if(position.getUp().getUp().getRight().getData() == 0)
			{
				position = position.getUp().getUp().getRight();
				position.setData(value++);
				if (check()==true)
				{
					return true;
				}
				display();
				move();
				position.setData(0);
				position = position.getLeft().getDown().getDown();
			}

		}
		catch(Exception e)
		{
			
		}
		try
		{	if(position.getRight().getRight().getUp().getData()== 0)
			{
				position = position.getRight().getRight().getUp();
				position.setData(value++);
				if (check()==true)
				{
					return true;
				}
				display();
				move();
				position.setData(0);
				position = position.getDown().getLeft().getLeft();
			}			
		}
		catch (Exception e)
		{
			
		}
		try
		{	if(position.getRight().getRight().getDown().getData() ==0)
			{
				position = position.getRight().getRight().getDown();
				position.setData(value++);
				if (check()==true)
				{
					return true;
				}
				display();
				move();
				position.setData(0);
				position = position.getLeft().getLeft().getUp();
			}
		}
		catch(Exception e)
		{
			
		}
		try
		{	if(position.getDown().getDown().getRight().getData() ==0)
			{
				position = position.getDown().getDown().getRight();
				position.setData(value++);
				if (check()==true)
				{
					return true;
				}
				display();
				move();
				position.setData(0);
				position = position.getLeft().getUp().getUp();
			}
		}
		catch(Exception e)
		{
			
		}
		try
		{	if(position.getDown().getDown().getLeft().getData() ==0)
			{
				position = position.getDown().getDown().getLeft();
				position.setData(value++);
				if (check()==true)
				{
					return true;
				}
				display();
				move();
				position.setData(0);
				position = position.getRight().getUp().getUp();
			}
		}
		catch(Exception e)
		{
			
		}
		try
		{	if(position.getLeft().getLeft().getDown().getData()==0)
			{
				position = position.getLeft().getLeft().getDown();
				position.setData(value++);
				if (check()==true)
				{
					return true;
				}
				display();
				move();
				position.setData(0);
				position = position.getUp().getRight().getRight();
			}
		}
		catch(Exception e)
		{
			
		}
		try
		{	if(position.getLeft().getLeft().getUp().getData()==0)
			{
				position = position.getLeft().getLeft().getUp();
				position.setData(value++);
				if (check()==true)
				{
					return true;
				}
				display();
				move();
				position.setData(0);
				position = position.getRight().getDown().getDown();
			}
		}
		catch(Exception e)
		{
			
		}
		try
		{	if(position.getUp().getUp().getLeft().getData()==0)
			{
				position = position.getUp().getUp().getLeft();
				position.setData(value++);
				if (check()==true)
				{
					return true;
				}
				display();
				move();
				position.setData(0);
				position = position.getRight().getDown().getDown();
			}
		}
		catch(Exception e)
		{
			
		}
		return false;
	}
	public boolean check()
	{ int breaknum=0;
		boolean success=true;
		while(temp!=null&& breaknum ==0)//check at beginning of new row
		{
			temp = root;
			while(temp!=null)//check at end of row
			{
				if(temp.getData()==0)
				{
					breaknum=1;
					success=false;
					break;
				}
				temp = temp.getRight();
			}
			temp = rowMarker.getDown();
			if(rowMarker.getDown() !=null)//
			{
				rowMarker = temp;
			}
		}//checks the whole grid for completion
		return success;
	}
	public void display()
	{	Node temp = root;
		Node rowMarker = root;
		while(temp!=null)//check at beginning of new row
		{
			temp = root;
			while(temp!=null)//check at end of row
			{
				System.out.print(temp.getData()+" ");
				temp = temp.getRight();
			}
			temp = rowMarker.getDown();
			if(rowMarker.getDown() !=null)//
			{
				rowMarker = temp;
			}
			System.out.println();
		}	
		System.out.println();
	}

}
