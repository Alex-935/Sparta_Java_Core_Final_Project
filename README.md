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

__________________________________________________________________________________________________________________________________________________
<br>

# Our Solution:

## App:

    - Instantiates welcome menu.

<img width="594" height="196" alt="image" src="https://github.com/user-attachments/assets/74e3683a-dd4c-4fc0-ad7f-9dc2034edffe" />

<br>
__________________________________________________________________________________________________________________________________________________
<br>

## WelcomeSelection:

    - Allows the user to choose to play snap or blackjack.
    - Allows the user to see the ruled for snap/blackjack without instantiating class.
    - Allows the user to sort the deck in the ways mentioned in the requirements.
    - Loops infinitely until the user opts to exit.
    - All choices validated and only appropriate inputs are accepted.

###  Welcome menu:

<img width="484" height="561" alt="image" src="https://github.com/user-attachments/assets/5de92382-6090-45ce-8b57-7f474416ad3b" />

### Sorting menu:

<img width="486" height="431" alt="image" src="https://github.com/user-attachments/assets/82d78d18-2c47-4893-93ea-1c6e811d6772" />

<br>
__________________________________________________________________________________________________________________________________________________
<br>

## Deck

    - Used by both game classes.
    - Instantiates ArrayList of 52 unique cards.
    - Has a method to get the next card.
    - Has a method to shuffle the deck.
    - Overrides toString to print out the entrie deck in order (Uses StringBuilder for memory efficiency).
    - Implements the required sorting functions.

### Constructor and non-sorting functions:

<img width="668" height="794" alt="image" src="https://github.com/user-attachments/assets/5ed897d9-b2d2-4bb6-86e6-2262009fb78a" />

### Sorting functions:

<img width="732" height="743" alt="image" src="https://github.com/user-attachments/assets/e76aecbf-0673-41cb-a458-ded9ee72e5b6" />

<br>
__________________________________________________________________________________________________________________________________________________
<br>

## Card:

    - Instantiates card that has private attributes of suit and face.
    - Has public getters and private setters.
    - Functions to convert suits/face from integers to their appropriate strings.
    - Overrides toString to return full card name.

### Converts card attributes to make them more readily usable in the games:

<img width="969" height="736" alt="image" src="https://github.com/user-attachments/assets/e9ce0315-7425-497d-93fa-8077ef59a335" />

<br>
__________________________________________________________________________________________________________________________________________________
<br>

## Snap:

    - Uses a stack to keep track of the middle pile and compare last card.
    - Adds a delay between each card being placed to make it easier to follow.
    - Allows user to type to place next card so you can go at your own pace.
    - Player types in 's' to snap, while the computer uses a timer to delay it's 'snap'.
    - Allows the user to choose different timer speeds to allow for different reaction times.
    - Ability to replay game without returning to the menu.
    - All user inputs validated.
    - Static rules method to allow the rules to be seen without instantiating the game class.

### Gameplay example:

<img width="672" height="835" alt="image" src="https://github.com/user-attachments/assets/e3c2a60d-6e13-4604-aa88-708f5536f8eb" />

## SnapDelayTimer:

    - Used to determine how long the user has to type 's' to snap before the computer says snap.

### Selection method:
<img width="912" height="333" alt="image" src="https://github.com/user-attachments/assets/139d8ca9-0dca-450d-aa3a-035c8a43fe4e" />


<br>
__________________________________________________________________________________________________________________________________________________
<br>

## BlackJack

    - Hides first computer card so you don't know exactly what the opponent has.
    - Allows you to twist until you are bust but not beyond that.
    - Automatically assigns Aces a value of 11 and reduces the value to 1 when hand total exceeds 21.
    - Computer will stop twisting at a randomised hand total between 15 (inclusive) and 19 (exclusive).
    - You always lose if you bust and ties are accounted for.
    - Ability to replay game without returning to the menu.
    - All user inputs validated.
    - Static rules method to allow the rules to be seen without instantiating the game class.

### Gameplay example:

<img width="968" height="1099" alt="image" src="https://github.com/user-attachments/assets/4d156ada-4a38-4837-bfed-3b1ef73c1706" />
