package practica3;

import java.util.Iterator;

import practica3.Stack.StackIterator;

public class TestStack {

	public static void main(String[] args) {
		Stack pila=new Stack();
		pila.push("Hola");
		pila.push("como");
		pila.push("estas?");
		pila.push("yo");
		pila.push("bien");
		StackIterator iterator=pila.getIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}

}
