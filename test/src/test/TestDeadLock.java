package test;

public class TestDeadLock {
	public static void main(String[] args) {
		A a = new A();
		B b = new B(a);
		a.set(b);
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		t1.start();
		t2.start();
	}
}

class A implements Runnable {
	public B b;

	public void run() {
		while (true) {
			synchronized (this) {
				b.write();
			}
		}
	}

	public void write() {
		synchronized (this) {
			System.out.println("a write");
		}
	}

	public void set(B b) {
		this.b = b;
	}
}

class B implements Runnable {
	public A a;

	public B(A a) {
		this.a = a;
	}

	public void write() {
		synchronized (this) {
			System.out.println("b write");
		}
	}

	public void run() {
		while (true) {
			synchronized (this) {

				a.write();
			}
		}
	}
}