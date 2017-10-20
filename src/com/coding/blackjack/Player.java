package com.coding.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private List<Card> hand = new ArrayList<>();
	
	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Card> getHand() {
		return hand;
	}	
	
	public List<Integer> getPoints() {
		List<Integer> pointCombos = new ArrayList<>();
		int points = 0;
		for (Card card : hand) {
			points += card.getValue().points;
		}
		pointCombos.add(points);
		for (int i = 0; i < countAces(); i++) {
			points += 10;
			pointCombos.add(points);
		}
		return pointCombos;
	}
	
	public void draw(Deck deck) {
		hand.add(deck.take());
	}
	
	private int countAces() {
		return (int) hand.stream().filter(c -> c.getValue() == Card.Value.ACE).count();
	}
	
	public String getState() {
		return name + " has hand " + hand + " for total " + getPoints();
	}
	
}
