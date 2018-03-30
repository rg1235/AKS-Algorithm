import java.util.*;
import java.math.*;
import java.io.*;
public class deg {
 static int n;
 static int z;
 static int count=0;
 static int subgraph[];
 static int mark[];
 //main function
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
      int graph[][]=new int[][]{{0,1,0,0,0,1},{1,0,1,0,0,1},{0,1,0,1,1,1},{0,0,1,0,1,0},{0,0,1,1,0,1},{1,1,1,0,1,0}};
		//int graph[][]=new int[][]{{0,1,1,1,1,1},{1,0,1,1,1,1},{1,1,0,1,1,1},{1,1,1,0,1,1},{1,1,1,1,0,1},{1,1,1,1,1,0}};
        
		int d=1;
       n=6;
       int deg[]=degree(graph);
       mark=new int[n];
       for(int k=0;k<n;k++)
   	{
   		mark[k]=0;
   	}
       int w=weight(deg,d);
       subgraph=new int [w];
       z=w;
       System.out.println("Weight"+w);
       work(w,graph,d);
       for(int j=0;j<w;j++)
  		{
  			System.out.print(subgraph[j]+",");
  		}
      // int y=max(deg);
       //System.out.println("Max degree"+y);
      /*int newg[][]=new int[n][n]; 
       for(int i=0;i<n;i++)
      	{
      		for(int j=0;j<n;j++)
      		{
      			newg[i][j]=0;
      		}
      	}
       System.out.println("New Graph");
       newg=remove(graph,y);*/
     /*  for(int i=0;i<n;i++)
   	{
   		for(int j=0;j<n;j++)
   		{
   			System.out.print(newg[i][j]+",");
   		}
   		System.out.print("\n");
   		
   	}*/
       
	}
	//Degree Calculation of Graph
	public static int[] degree(int g[][])
	{ int c[]=new int[n];
	for(int k=0;k<n;k++)
	{
		c[k]=0;
	}
	int len=n;
	for(int i=0;i<len;i++)
	{
		for(int j=0;j<len;j++)
		{
			if(g[i][j]==1)
			{
				c[i]=c[i]+1;
			}
		}
	}
		return c;
	}
	//Weight calculation
    public static int weight(int deg[],int d)
    { double weight=0.0;
    	int len=deg.length;
    	 /*for(int k=0;k<len;k++)
    	   	{
    	   		System.out.println(deg[k]);
    	   	}*/
    	for(int i=0;i<len;i++)
    	{
    		//System.out.println("deg["+i+"]="+deg[i]+"and d="+d);
    		if(deg[i]<d)
    		{
    			
    			weight=weight+1;
    			
    			
    		}
    		else
    		{ 
    			double p=deg[i]+1;
    			double x=d/p;
    			//System.out.println(x);
    			weight=weight+x;
    			//System.out.println("deg["+i+"]="+deg[i]+"and d="+d);
    		}
    		
    	}
    	//System.out.println(weight);
    	int x=(int) Math.ceil(weight);
    	return x;
        }
    //Finding The maximum degree Vertex
    public static int max(int deg[])
    {
    	int len=deg.length;
   	 /*for(int k=0;k<len;k++)
   	   	{
   	   		System.out.println(deg[k]);
   	   	}*/
    int	max=0;
    int vertex=0;	
   	for(int i=0;i<len;i++)
   	{	
   		if(deg[i]>max)
   		{
   			max=deg[i];
   			vertex=i;
   		}
   	}
   	return vertex;
    }
    //remove
    public static int[][] remove(int g[][],int k)
    {
    int len=n;
    for(int i=0;i<len;i++)
	{
		for(int j=0;j<len;j++)
		{
			if(i==k||j==k)
			{
				g[i][j]=0;
			}
		}
	}
    return g;
    }
    //End of Functions
    //working function
    public static void work(int a,int g[][],int d)
    {
    	int g2[][]=new int[n][n];
		int v[]=degree(g);
		int len=v.length;
    	if(count!=z && iszero(v)==1 )
    	{
    		
    		int flag=0;
    		int j=0;
    		int k=0;
    		//System.out.println("value of a="+a);
    		for(int i=0;i<len;i++)
    		{
    			if(v[i]<d && v[i]!=0)
    			{
    				flag=1;
    				j=i;
    				//System.out.println(j);
    				break;
    			}
    		}
    		if(flag==1)
    		{
    		g2=remove(g,j);
    		subgraph[count]=j;
    		//System.out.println("Adding"+j);
    		mark[j]=1;
    		count++;
    		a--;
    		}
    		if(flag==0)
    		{
    		k=max(v);
    		//System.out.println("Removing"+k);
    		mark[k]=1;
    		//System.out.println(k);
    		g2=remove(g,k);
    		}
    		work(a,g2,d);
    	}
    	if(iszero(v)==0 && count!=z )
    	{
    		for(int i=0;i<n;i++)
    		{
    			if(mark[i]==0)
    			{
    				subgraph[count]=i;
    				count++;
    			}
    		}
    	}
    }
    public static int iszero(int arr[])
    {   int flag=0;
    	int len=arr.length;
    	for(int i=0;i<len;i++)
    	{
    		if(arr[i]>0)
    		{
    			flag=1;
    		}
    	}
    	return flag;
    }
}
