package com.coding.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private List<Player> players = new ArrayList<>();
	private Deck deck = new Deck();
	private int numPlayers;
	
	public static void main(String[] args) {
		Game game = new Game(5);
		game.start();
		game.showGameState();
	}
	
	public Game(int numPlayers) {
		super();
		this.numPlayers = numPlayers;
	}

	private void showGameState() {
		for (Player player : players) {
			System.out.println(player.getState());
		}
	}
	
	private void start() {
		createPlayers();
		dealCards();
	}
	
	private void createPlayers() {		
		for (int i = 1; i <= numPlayers; i++) {
			players.add(new Player("Player " + i));
		}
	}
	
	private void dealCards() {
		for (int i = 0; i < 2; i++) {
			for (Player player : players) {
				player.draw(deck);
			}
		}		
	}
}
