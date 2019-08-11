package OJExercise.mutithread;

/*
 * Leetcode 1114
 * s三个不同的线程将会共用一个Foo实例，线程A调用one方法，B调用two方法，C调用Three方法
 * s设计修改程序以确保按顺序one->two->three执行
 */
public class PrintInOrder {
	// 思路: 创建线程屏障
	private boolean firstFinished;
	private boolean secondFinished;
	private Object lock = new Object();
	
	public PrintInOrder() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
        	// printFirst.run() outputs "first". Do not change or remove this line.
        	printFirst.run();
        	firstFinished = true;
        	lock.notifyAll();
		}
    }

    public void second(Runnable printSecond) throws InterruptedException {
    	synchronized (lock) {
            while (!firstFinished) {
            	// 释放锁并等待
            	lock.wait();
            }
         // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFinished = true;
            lock.notifyAll();	
		}
    }

    public void third(Runnable printThird) throws InterruptedException {
    	synchronized (lock) {
            while (!secondFinished) {
                 lock.wait();
             }
	        // printThird.run() outputs "third". Do not change or remove this line.
	        printThird.run();
    	}
    }
    
    public static void main(String[] args) {
		PrintInOrder resource = new PrintInOrder();
		new Thread(new TaskC(resource)).start();

		new Thread(new TaskB(resource)).start();

		new Thread(new TaskA(resource)).start();
	}
}


class TaskA implements Runnable {
	PrintInOrder resource;
	
	public TaskA(PrintInOrder resource) {
		// TODO Auto-generated constructor stub
		this.resource = resource;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			resource.first(new PrintFirst());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class TaskB implements Runnable {
	PrintInOrder resource;
	
	public TaskB(PrintInOrder resource) {
		// TODO Auto-generated constructor stub
		this.resource = resource;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			resource.second(new PrintSecond());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class TaskC implements Runnable {
	
	PrintInOrder resource;
	
	public TaskC(PrintInOrder resource) {
		// TODO Auto-generated constructor stub
		this.resource = resource;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			resource.third(new PrintThird());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class PrintFirst implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print("first");
	}
	
}

class PrintSecond implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print("second");
	}
	
}

class PrintThird implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print("third");
	}	
}