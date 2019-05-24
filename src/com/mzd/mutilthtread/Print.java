package com.mzd.mutilthtread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一个面试题，三个线程连续打印ABCABCABC....一共十次
 */
public class Print {

	Condition newCondition;
	static Lock a = new ReentrantLock();
	static Condition aCondition = a.newCondition();
	static Condition bCondition = a.newCondition();
	static Condition cCondition = a.newCondition();
	static Letter letter = Letter.A;

	public static void main(String[] args) {

		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				loopA();
			}
		}, "A").start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				loopB();
			}
		}, "B").start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				loopC();
			}
		}, "C").start();
	}

	private static void loopA() {
		a.lock();
		try {
			if (letter == Letter.A) {
				System.out.println("A");
				letter = Letter.B;
				bCondition.signal();
			}
			aCondition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			a.unlock();
		}
	}

	private static void loopB() {
		a.lock();
		try {
			if (letter == Letter.B) {
				System.out.println("B");
				letter = Letter.C;
				cCondition.signal();
			}
			bCondition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			a.unlock();
		}
	}

	private static void loopC() {
		a.lock();
		try {
			if (letter == Letter.C) {
				System.out.println("C");
				letter = Letter.A;
				aCondition.signal();
			}
			cCondition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			a.unlock();
		}
	}

	private enum Letter {
		A, B, C;
	}
}
