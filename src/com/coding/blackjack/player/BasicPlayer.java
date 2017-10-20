package com.coding.blackjack.player;

import java.util.Collections;

import com.coding.blackjack.Card;
import com.coding.blackjack.Deck;

public class BasicPlayer extends Player {

	public BasicPlayer(String name) {
		super(name);
	}

	@Override
	public void play(Deck deck) {
		if (Collections.max(getPoints()) > 18) {
			System.out.println(getName() + " stands");
		}
		while (Collections.min(getPoints()) < 17) {
			Card newCard = draw(deck);
			System.out.println(getName() + " draws " + newCard.toString() + " for " + getPoints());
		}
		if (Collections.min(getPoints()) > 21) {
			System.out.println(getName() + " busts");
		} else {
			System.out.println(getName() + " stands");			
		}
	}

}
