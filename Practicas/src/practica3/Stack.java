package practica3;

import java.util.ArrayList;
import java.util.Iterator;

public class Stack {
    private ArrayList<String> items;
    
    public Stack() {
    	items= new ArrayList<String>();
    }
    
    public void push (String item) {
    	items.add(0,item);
    }
    
    public String pop(){
    	String item=items.get(0);
    	items.remove(0);
    	return item;
    	
    }
    
    public boolean isEmpty() {
        return items.isEmpty();    	
    }
    
    public StackIterator getIterator() {
    	return new StackIterator();
    }
    public class StackIterator implements Iterator<String>{
        private int index=0;
		@Override
		public boolean hasNext() {
			return index<items.size();
		}

		@Override
		public String next() {
			return items.get(index++);
		}
    
    } 
    
}
