public class ListaEncadeada {
	// Representação
	private ListNode head;
	private ListNode tail;
	private int size;

	private class ListNode {
		private Object element;
		private ListNode next;

		private ListNode(Object e, ListNode n) {
			element = e;
			next = n;
		}
	}

	// Construtores
	public ListaEncadeada() {
		size = 0;
		head = tail = null;
	}

	// Métodos
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public boolean add(Object elem) {
		ListNode newElement = new ListNode(elem, null);
		if (head == null) // insere em uma lista vazia
			head = tail = newElement;
		else
			tail.next = newElement;
		tail = newElement;
		size++;
		return true;
	}

	public void clear() {
		head = tail = null;
		size = 0;
	}

	public void print() {
		if (size == 0)
			System.out.println("<----Lista Vazia---->");

		else {
			System.out.println("<----Início---->");
			ListNode itr = head;
			while (itr != null) {
				System.out.println(itr.element);
				itr = itr.next;
			}
			System.out.println("<----Fim---->");
		}

	}

	public Object get(int index) {
		if (index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException("Index=" + index + " e Size=" + size);
		else {
			if (index == 0) // caso particular (previous = null)
				return head.element;
			ListNode previous = findPrevious(index);
			return previous.next.element;
		}
	}

	private ListNode findPrevious(int index) {
		ListNode itr = head;
		ListNode previous = null;
		for (int i = 0; i < size; i++) {
			if (i == index)
				return previous;
			previous = itr;
			itr = itr.next;
		}
		return previous;
	}

	public int indexOf(Object elem) {
		ListNode itr = head;
		for (int i = 0; i < size; i++) {
			if (itr.element.equals(elem)) {
				return i;
			} else {
				itr = itr.next;
			}
		}
		return -1;
	}

	public void add(int index, Object elem) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index=" + index + " e Size=" + size);
		else {
			if (index == 0) { // insere o elemento na posicao head
				if (head == null) { // insere em uma lista vazia
					ListNode newElement = new ListNode(elem, null);
					head = tail = newElement;
				} else { // insere em uma lista com um ou mais elementos
					ListNode newElement = new ListNode(elem, head);
					head = newElement;
				}
			} else {
				ListNode previous = findPrevious(index);
				ListNode newElement = new ListNode(elem, previous.next);
				previous.next = newElement;
				if (newElement.next == null) // o novo elemento e o novo tail
					tail = newElement;
			}
		}
		size++;
	}

	public Object remove(int index) {
		Object removedElement = null;
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index = " + index + " e Size = " + size);

		else {
			if (index == 0) { // o elemento a ser removido for o head
				if (size == 1) { // caso tenha apenas um elemento na lista
					clear();
				} else { // caso tenha mais elementos
					removedElement = head.element; // armazena o elemento removido
					head = head.next; // atualiza o head para o próximo nó
					size--;
				}
			}

			else { // o elemento a ser removido não é o head
				ListNode previous = findPrevious(index);
				removedElement = previous.next.element;
				previous.next = previous.next.next;

				if (previous.next == null) // se for o ULTIMO elem
					tail = previous;

				size--;
			}
			return removedElement;
		}
	}

	public boolean remove(Object elem) {
		if (head == null)
			return false;

		if (head.element.equals(elem)) {
			head = head.next;
			if (head == null)
				tail = null;
			size--;
			return true;
		}

		ListNode previous = head;
		ListNode current = head.next;

		while (current != null) {
			if (current.element.equals(elem)) {
				previous.next = current.next;
				if (current.next == null)
					tail = previous;
				size--;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false; // ent elemento não encontrado
	}

	public Object set(int index, Object elem) {
		ListNode setElement = new ListNode(elem, null);
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index = " + index + " e Size = " + size);

		else {
			if (index == 0) { // elemento a ser atualizado é o head
				setElement.next = head.next;
				head = setElement;
			}

			else {
				ListNode previous = findPrevious(index);
				if (previous.next.next == null)
					tail = setElement;

				else
					setElement.next = previous.next.next; // associa o next do elemento desatualizado para o novo
															// elemento

				previous.next = setElement; // atualiza o next do previous para o novo elemento
			}
		}
		return setElement;
	}

}
