package com.lifegoals.app.service.helper;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CacheArrayList<T> extends ArrayList<T> {

	/* the name of the file that we are going to write in order to cache */
	private String name;

	public CacheArrayList(String name) {
		super();
		initialize(name);
	}

	public CacheArrayList(Collection<? extends T> arg0, String name) {
		super(arg0);
		initialize(name);
	}

	public CacheArrayList(int arg0, String name) {
		super(arg0);
		initialize(name);
	}

	/* this method will load the objects from the file if it exists */
	private void initialize(String name) {
		this.name = name;
		Collection<? extends T> list = StoringHelper.readObjectFromFile(name);
		if (list != null) {
			addAll(list);
			System.out.println("Yay, loaded from file");
		} else {
			System.out.println("Not loaded from file");
		}
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub
		super.add(index, element);
		flush();
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		boolean b = super.add(e);
		flush();
		return b;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		boolean b = super.remove(o);
		flush();
		return b;
	}

	@Override
	public T remove(int index) {
		T t = super.remove(index);
		flush();
		return t;
	}

	@Override
	public T set(int index, T element) {
		T t = super.set(index, element);
		flush();
		return t;
	}

	private void flush() {
		StoringHelper.writeFile(name, this);

	}

}
