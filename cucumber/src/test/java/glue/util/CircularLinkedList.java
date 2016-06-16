package glue.util;

import java.util.LinkedList;

/*
 * This class is a list that removes the first element when the list has reached its max size and a new element is added
 */
public class CircularLinkedList extends LinkedList<Object> {

	private static int MAX_SIZE = 5;

	public CircularLinkedList(int size) {
		MAX_SIZE = size;
	}

	@Override
	public boolean add(Object object) {
		boolean add = super.add(object);
		if (size() > MAX_SIZE) {
			removeFirst();
		}
		return add;
	}

}
