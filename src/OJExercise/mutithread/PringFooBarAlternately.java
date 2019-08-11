package OJExercise.mutithread;

/*
 * leetcode1115 
 * s两个线程，一个执行foo方法，一个执行bar方法，让foobar交替输出
 */
public class PringFooBarAlternately {
private int n;
	
	private boolean fooFinished;
	
	private boolean barFinished = true;
	
	private Object lock = new Object();

    public PringFooBarAlternately(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
				while(!barFinished) {
					lock.wait();
				}

	        	// printFoo.run() outputs "foo". Do not change or remove this line.
	        	printFoo.run();
	        	barFinished = false;
	        	fooFinished = true;
	        	lock.notifyAll();
			}
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
            	while(!fooFinished) {
					lock.wait();
				}
            	// printBar.run() outputs "bar". Do not change or remove this line.
            	printBar.run();
            	fooFinished = false;
            	barFinished = true;
            	lock.notifyAll();
			}
        }
    }
}


