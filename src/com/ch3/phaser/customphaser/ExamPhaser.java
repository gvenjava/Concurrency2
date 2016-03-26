package com.ch3.phaser.customphaser;

import java.util.concurrent.Phaser;

public class ExamPhaser extends Phaser {

	@Override
	protected boolean onAdvance(int phase, int registeredParties) {
		switch (phase) {
		case 0:
			return examStarts();
		case 1:
			return firstPhase();
		case 2:
			return secondPhase();
		case 3:
			return finalPhase();
		default:
			return true;
		}
//		return super.onAdvance(phase, registeredParties);
	}

	private boolean finalPhase() {
		System.out.printf("Phaser %d: %d of %d Students finished final phase!%n",getPhase(),getArrivedParties(),getRegisteredParties());
		return true;
	}

	private boolean secondPhase() {
		System.out.printf("Phaser %d: %d of %d Students finished second phase!%n",getPhase(),getArrivedParties(),getRegisteredParties());
		return false;
	}

	private boolean firstPhase() {
		System.out.printf("Phaser %d: %d of %d Students finished first phase!%n",getPhase(),getArrivedParties(),getRegisteredParties());
		return false;
	}

	private boolean examStarts() {
		System.out.printf("Phaser %d: %d of %d Students arrived!%n",getPhase(),getArrivedParties(),getRegisteredParties());
		return false;
	}

}
