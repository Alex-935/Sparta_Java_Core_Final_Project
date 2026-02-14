# Sparta Java Core Final Project

# Requirements:

## Expectations
- A working application
- A GitHub repository, along wiht a suitable branching strategy
- Documentation of the task allocations and task completions amongst group members - e.g. a Trello Board
- Unit testing

## Tasks:
- Allow the user to choose between snap and blackjack

### Deck of Cards:
- Keep track of a deck of 52 cards (13 per suit)
- Shuffle it into a random order
- Retrieve a card from the top
- Sort the deck in four ways:
    - By card value, the suit order: Ace -> 2 -> 3 -> .... -> Jack -> Queen -> King,     Clubs -> Diamonds -> Hearts -> Spades.
    - Reverse order of the above: King -> Queen -> Jack -> .... -> 3 -> 2 -> 1,     Spades -> Hearts -> Diamonds -> Clubs.
    - By suit order, then suit order: Clubs -> Diamonds -> Hearts -> Spades,     Ace -> 2 -> 3 -> .... -> Jack -> Queen -> King.
    - Reverse order of the above: Spades -> Hearts -> Diamonds -> Clubs,     King -> Queen -> Jack -> .... -> 3 -> 2 -> 1.

### Card Game:
- Player vs Computer
- Handle the interaction of the player to both select and play the game.
- Ensure that the player does not 'break' the game by invalid input.

### Presentation:
- Overview / Introduction
- Outline any decisions you have made about 
  
<br>

# Our Solution:

## App:

    - Instantiates welcome menu.

<img width="594" height="196" alt="image" src="https://github.com/user-attachments/assets/74e3683a-dd4c-4fc0-ad7f-9dc2034edffe" />

## WelcomeSelection:

    - Allows the user to choose to play snap or blackjack.
    - Allows the user to see the ruled for snap/blackjack without instantiating class.
    - Allows the user to sort the deck in the ways mentioned in the requirements.
    - Loops infinitely until the user opts to exit.
    - All choices validated and only appropriate inputs are accepted.

### Example of running program:

<img width="484" height="561" alt="image" src="https://github.com/user-attachments/assets/5de92382-6090-45ce-8b57-7f474416ad3b" />

### Sorting menu:

<img width="486" height="431" alt="image" src="https://github.com/user-attachments/assets/82d78d18-2c47-4893-93ea-1c6e811d6772" />
