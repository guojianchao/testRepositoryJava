package thread;

import ticketcount.Count;
/*
 *���̵߳�ʵ��
 */
public class TestThread implements Runnable {
	private int ticket = 10;

	public void run() {

//		for (int i = 0; i < 200; i++) {

			try {
				this.sell();

				Thread.sleep(10000);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

//		}

	}

	public void sell() {

		if (Count.getTicket() > 0) {
			for(int i=0;i<1000;i++){
				System.out.println(Thread.currentThread().getName() +i+ " ===> ��ʣ��"
						+ (Count.getTicket()-1) + "��Ʊ");
				if(i==(1000-1)){
					
					System.out.println(Thread.currentThread().getName()+"ִ�������===================================================");
					break;
				}
			}
			Count.setTicket(Count.getTicket()-1);
			
		}
	}
	
	
	
}
