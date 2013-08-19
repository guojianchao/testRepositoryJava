package test;
import java.util.*;

public class Stack {

	public static void main(String[] args) {

		final Stack stack = new Stack();

		new Thread("push") {

			@Override
			public void run() {

				for (int i = 0; i < 100; i++)

				{

					try {
System.out.println("-_-");
						Thread.sleep(10);
System.out.println("o_o");
					} catch (Exception e) {
					}

					stack.push("object " + i);

				}

			}

		}.start();

		new Thread("pop") {

			@Override
			public void run() {

				for (int i = 0; i < 100; i++)

				{

					try {

						System.out.println(stack.pop());

					} catch (Exception e) {
					}

				}

			}

		}.start();

	}

	LinkedList<Object> list = new LinkedList<Object>();

	public synchronized void push(Object x) {

		System.out.println("begin to push " + x);

		synchronized (list) {

			list.addLast(x);

			notify();

		}

		System.out.println("end to push " + x);

	}

	public synchronized Object pop() throws Exception {

		System.out.println("begin to pop");

		synchronized (list) {

			if (list.size() <= 0) {

				wait();

			}

			return list.removeLast();

		}

	}

}
