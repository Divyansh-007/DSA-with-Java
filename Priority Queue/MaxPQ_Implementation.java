import java.util.ArrayList;

class Element<T> {

	T value;
	int priority;
	
	public Element(T value, int priority) {
		this.value = value;
		this.priority = priority;
	}
}

class PriorityQueueException extends Exception {

}

public class MaxPriorityQueue<T> {
	private ArrayList<Element<T>> heap;

	public MaxPriorityQueue() {
		heap = new ArrayList<>();
	}

	public int size() {
		return heap.size();
	}

	public boolean isEmpty() {
		return heap.size() == 0;
	}

	public T getMaximum() throws PriorityQueueException  {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}

		return heap.get(0).value;
	}

	public void insert(T value, int priority) {
		Element<T> e = new Element<>(value, priority);
		heap.add(e);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while(childIndex > 0) {
			if(heap.get(childIndex).priority > heap.get(parentIndex).priority) {
				Element<T> temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			}else {
				return;
			}
		}
	}

	public T remove() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}

		T maxElem = heap.get(0).value;
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);

		int parentIndex = 0;
		int leftChildIndex = (2 * parentIndex) + 1;
		int rightChildIndex = (2 * parentIndex) + 2;

		while(leftChildIndex < heap.size()) {
			int maxIndex = parentIndex;

			if(heap.get(leftChildIndex).priority > heap.get(maxIndex).priority) {
				maxIndex = leftChildIndex;
			}

			if(rightChildIndex < heap.size() && (heap.get(rightChildIndex).priority > heap.get(maxIndex).priority)) {
				maxIndex = rightChildIndex;
			}
			
			if(maxIndex == parentIndex) {
				break;
			}

			Element<T> temp = heap.get(maxIndex);
			heap.set(maxIndex, heap.get(parentIndex));
			heap.set(parentIndex, temp);

			parentIndex = maxIndex;
			leftChildIndex = (2 * parentIndex) + 1;
			rightChildIndex = (2 * parentIndex) + 2;
		}
		
		return maxElem;
	}
}
