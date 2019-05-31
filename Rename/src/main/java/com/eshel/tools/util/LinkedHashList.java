/*
package com.eshel.tools.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;

*/
/**
 * createBy Eshel
 * createTime: 2019/5/8 16:31
 * desc: TODO
 *//*

public class LinkedHashList<E> implements List<E> {

	private LinkedHashSet<E> mSet;

	public LinkedHashList() {
		mSet = new LinkedHashSet<>();
	}

	public LinkedHashList(int capacity){
		mSet = new LinkedHashSet<>(capacity);
	}

	@Override
	public int size() {
		return mSet.size();
	}

	@Override
	public boolean isEmpty() {
		return mSet.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return mSet.iterator();
	}

	@Override
	public Object[] toArray() {
		return mSet.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return mSet.toArray(a);
	}

	@Override
	public boolean add(E e) {
		return mSet.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return mSet.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return mSet.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return mSet.addAll(c);
	}

	*/
/**
	 * 内部使用 HashSet 实现, 该方法执行结果可能会有问题, 不推荐使用
	 *//*

	@Override
	@Deprecated
	public boolean addAll(int index, Collection<? extends E> c) {
		return mSet.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return mSet.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return mSet.retainAll(c);
	}

	@Override
	public void clear() {
		mSet.clear();
	}

	@Override
	public boolean equals(Object o) {
		return mSet.equals(o);
	}

	@Override
	public int hashCode() {
		return mSet.hashCode();
	}

	@Override
	public E get(int index) {
		Iterator<E> it = mSet.iterator();

		int i = 0;
		while (it.hasNext()){
			E next = it.next();
			if(i == index)
				return next;
			i++;
		}

		return null;
	}

	@Override
	public E set(int index, E element) {
//		LinkedHashMap<E, Object> map = null;
//		map.
		mSet.add()
*/
/*		mSet.add()
		Iterator<E> it = mSet.iterator();

		int i = 0;
		while (it.hasNext()){
			E next = it.next();
			if(i == index)
				return next;
			i++;
		}
		return null;*//*

	}

	@Override
	public void add(int index, E element) {

	}

	@Override
	public E remove(int index) {
		Iterator<E> it = mSet.iterator();

		int i = 0;
		while (it.hasNext()){
			E next = it.next();
			if(i == index){
				it.remove();
				return next;
			}
			i++;
		}
		return null;
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}
}
*/
