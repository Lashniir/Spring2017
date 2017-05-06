public class CM307ArrayList<E> implements CM307List<E>
{
	private static final int INITIAL_CAPACITY =5;
	private E[] theData;
	private int size=0;
	private int capacity=0;

	public CM307ArrayList(){
		capacity=INITIAL_CAPACITY;
		theData=(E[])new Object[capacity];
	}

	public void add(E e) 
	{
		if(size==capacity){reallocate();}
                theData[size]=e;
		size++;
	}

	public boolean insert(int n, E e)
	{
		if(n<0||n>size)return false;
		if(size>=theData.length)reallocate();
		for(int i=size;i>n;i--)
		{
			theData[i]=theData[i-1];
		}
		theData[n]=e;
		size++;
		return true;
	}

	public E get(int n)
	{
		if(n<0||n>=size)return null;
		return theData[n];
	}

	public E remove(int n)
	{
		if(n<0||n>=size)return null;
		E returnValue = theData[n];
		for(int i=n+1;i<size;i++)
		{
			theData[i-1]=theData[i];
		}
		size--;
		return returnValue;
	}

	public boolean isEmpty()
	{
		if(size<=0)return true;
		return false;
	}

	public int size()
	{
		return size;
	}
	
	public void reallocate()
	{
		capacity=2*capacity;
		E[] newData=(E[])new Object[capacity];
		System.arraycopy(theData,0,newData,0,size);
		theData=newData;
	}
        
        public String toString()
        {
                String str = "List has "+size+" elements:\n[";
                for(int i=0;i<size;i++)
                {
                    str=str+theData[i];
                    if(i!=size-1)
                    {
                        str=str+",";
                    }
                }
                str=str+"]";
                return str;
        }
}