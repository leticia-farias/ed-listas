
public class ListacomArray {
    // Representação
    private Object[] elements;	// array de objetos
    private int size;			// número de elementos na lista
    private int capacity;		// capacidade inicial da lista
   // Construtores
    public ListacomArray() {
    	capacity=5;
    	elements=new Object[capacity];
    	size=0;                  
    }  
    public ListacomArray(int capacity) {
    	this.capacity=capacity;
    	elements=new Object[capacity];
    	size=0;                  
    }  
    public int size() {
    	return size;
    }
    public boolean isEmpty() {
    	return (size==0);        
    }
    public void print() {
    	if (size==0) 
    		System.out.println("<----Lista Vazia---->");			
		else {
			System.out.println("<----Início---->");
			for (int i=0;i<size;i++) 
				System.out.println(elements[i]); 
			System.out.println("<----Fim---->");				
		}
	}   
	public int indexOf (Object elem ) {
	     for (int i=0;i<size;i++)
	       if (elements[i].equals(elem)) 
	         return i;
	     return -1;
	}
	public boolean add (Object elem) {
		aumenteCapacidadeSeNecessario();
		elements[size]=elem;
		size++;
		return true; // considera que a lista sempre permite elementos repetidos. 
	}
	private void aumenteCapacidadeSeNecessario() {
		if  (size==capacity) {
			Object[] newElements=new Object[capacity*2];
	     	for (int i=0;i<size;i++) 
	        	newElements[i]=elements[i];
	     	elements=newElements;
	     	capacity*=2;
	    }
	}
	public Object get (int index) {
	   	if (index<0 || index>size-1)
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException:"+"Index="+index+" e Size="+size);
	 	else 
	     		return elements[index];
	}	
	public void clear() {
		for (int i=0;i<size; i++)
			elements[i]=null;
		size=0;
	}
	public void add (int index,Object elem) {
	if (index<0 || index>size)
	   throw new IndexOutOfBoundsException("Index="+index+" e Size="+size );
 	
       aumenteCapacidadeSeNecessario();
       for (int i=size;i>index;i--) 
         	elements[i]=elements[i-1];
       elements[index]=elem;
     	size++;
	}

	public Object remove (int index) {
		Object toBeDeleted;
		if (index<0 || index>size)
			throw new IndexOutOfBoundsException("Index="+index+" e Size="+size);
		else {
			toBeDeleted=elements[index];
		    size--;
		    for (int i=index;i<size;i++) 
		    	elements[i]=elements[i+1];
		}
		return toBeDeleted;
	}
	public boolean remove (Object elem) {
	     int index=indexOf(elem);
	     if (index<0) return false; 
	     remove(index);
	     return true;
	}
	public Object set (int index,Object elem) {
	     Object toBeOverridden;
	     if (index<0 || index>size-1)
		   throw new IndexOutOfBoundsException("Index="+index+" e Size="+size );
	     else {
		 toBeOverridden =elements[index];
	 	 elements[index]=elem;
	     }
	     return toBeOverridden;
	}
	public void trimToSize () {
		if (size==0)
			return;
	       capacity=size;
		Object[] newElements=new Object[capacity];
		for (int i=0;i<size;i++) 
			newElements[i]=elements[i];
	       elements=newElements;
	       return;
	}


}