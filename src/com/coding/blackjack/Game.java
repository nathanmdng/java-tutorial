package com.coding.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.coding.blackjack.player.BasicPlayer;
import com.coding.blackjack.player.Player;

public class Game {

	private List<Player> players = new ArrayList<>();
	private Deck deck = new Deck();
	private int numPlayers;
	
	public static void main(String[] args) {
		Game game = new Game(5);
		System.out.println("=== Dealing cards ===");
		game.deal();
		System.out.println("=== Begin game state ===");
		game.showGameState();
		System.out.println("=== Players draw cards ===");
		game.playRound();
		System.out.println("=== End game state ===");
		game.showGameState();
		System.out.println("=== Winners ===");
		List<Player> winners = game.calculateWinners();
		for (Player winner : winners) {
			System.out.println(winner.getName() + " wins with " + winner.getFinalPoints());
		}
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
	
	private void playRound() {
		for (Player player : players) {
			player.play(deck);
		}
	}
	
	private void deal() {
		createPlayers();
		dealCards();
	}
	
	private List<Player> calculateWinners() {
		// filter out any player who has busted
		List<Player> playersInGame = players.stream().filter(p -> !p.busts()).collect(Collectors.toList());
		// the best hand is the highest score of players who haven't busted
		int bestHand = Collections.max(playersInGame.stream().map(p -> p.getFinalPoints()).collect(Collectors.toList()));
		// anyone who has this score wins the game
		return players.stream().filter(p -> p.getFinalPoints() == bestHand).collect(Collectors.toList());
	}
	
	private void createPlayers() {		
		for (int i = 1; i <= numPlayers; i++) {
			players.add(new BasicPlayer("Player " + i));
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
