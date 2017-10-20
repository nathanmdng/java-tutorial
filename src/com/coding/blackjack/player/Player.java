package com.coding.blackjack.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.coding.blackjack.Card;
import com.coding.blackjack.Deck;

public abstract class Player {

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
	
	public Card draw(Deck deck) {
		Card newCard = deck.take();
		hand.add(newCard);
		return newCard;
	}

	public boolean busts() {
		return Collections.min(getPoints()) > 21;
	}
	
	public int getFinalPoints() {
		if (!busts()) {
			List<Integer> possiblePoints = getPoints().stream().filter(p -> p <= 21).collect(Collectors.toList());
			return Collections.max(possiblePoints);
		}
		return Collections.min(getPoints());
	}
	
	private int countAces() {
		return (int) hand.stream().filter(c -> c.getValue() == Card.Value.ACE).count();
	}
	
	public String getState() {
		return name + " has hand " + hand + " for total " + getPoints();
	}
	
	public abstract void play(Deck deck);
}
