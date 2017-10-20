package com.coding.blackjack;

import java.util.Collections;
import java.util.Stack;

import com.coding.blackjack.Card.Suit;
import com.coding.blackjack.Card.Value;

public class Deck {

	private Stack<Card> cards = new Stack<>();
	
	public Deck() {
		Suit[] suits = Card.Suit.values();
		Value[] values = Card.Value.values();
		for (Suit suit : suits) {
			for (Value value : values) {
				cards.push(new Card(suit, value));
			}
		}
		Collections.shuffle(cards);
	}

	public Card take() {
		return cards.pop();
	}
	
	public Stack<Card> getCards() {
		return cards;
	}
	
}
