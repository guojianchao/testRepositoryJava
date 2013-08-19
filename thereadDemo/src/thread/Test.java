package thread;

/**
 * 线程同步 的竞争资源问题
 * */
public class Test {
	public static void main(String[] args) {
		User u = new User("张三", 100);
		MyThread t1 = new MyThread("线程A", u, 20);
		MyThread t2 = new MyThread("线程B", u, -60);
		MyThread t3 = new MyThread("线程C", u, -80);
		MyThread t4 = new MyThread("线程D", u, -30);
		MyThread t5 = new MyThread("线程E", u, 32);
		MyThread t6 = new MyThread("线程F", u, 21);
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		
		t2.start();
		
		t3.setPriority(Thread.MAX_PRIORITY);
		t3.start();
		
		t4.start();
		
		t5.setPriority(10);
		t5.start();
		
		t6.setPriority(10);
		t6.start();
		
		
//		int a[]=new int[3]; 
//		a[0]=3;
//		a[1]=6;
//		a[2]=1;
//		
//		int b[]=new int[3]; 
//		b[0]=5;
//		b[1]=4;
//		b[2]=9;
//		
//		Test t=new Test();
//		System.out.println(t.sumArrays(a, b));
	}
	public int sumArrays(int[] a1, int[] a2) {
		int value = 0;
		int size = a1.length;
		if (size == a2.length) {
			synchronized (a1) {
				synchronized (a2) {
					for (int i = 0; i < size; i++)
						value += a1[i] + a2[i];
				}
			}
		}
		return value;
	}
}

class MyThread extends Thread {
	private User u;
	private int y = 0;

	MyThread(String name, User u, int y) {
		super(name);
		this.u = u;
		this.y = y;
	}

	public void run() {
		System.out.println("run-->>" + y);
		u.oper(y);
	}
}

class User {
	private String code;
	private int cash;

	User(String code, int cash) {
		this.code = code;
		this.cash = cash;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 业务方法
	 * 
	 * @param x
	 *            添加x万元
	 */
	public synchronized void oper(int x) {// 去掉synchronized 会使线程并发的调用oper方法 导致
		try { 								// 值错误。 加上后oper方法进入被锁状态，只有执行完当前的线程，才能把锁交与下一线程继续执行
			wait();
			Thread.sleep(10L);
			this.cash += x;
			System.out.println(Thread.currentThread().getName() + "运行结束，增加“"
					+ x + "”，当前用户账户余额为：" + cash);
			Thread.sleep(10L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



	@Override
	public String toString() {
		return "User{" + "code='" + code + '\'' + ",cash=" + cash + '}';
	}
}
