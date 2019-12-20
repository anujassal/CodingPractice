package com.coding.practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class MyCustomList<E> extends LinkedList<E>{
	
	private Comparator<E> comparator;
	
	public MyCustomList(Comparator<E> comp) {
		this.comparator = comp;
	}

	@Override
	public boolean add(E e) {
		boolean result = super.add(e);
		Collections.sort(this,this.comparator);
		return result;
	}
	
    @Override
    public Iterator<E> iterator()
    {
        Collections.sort(this, this.comparator);
        return super.iterator();
    }
    
	


	
	
	


	

}
