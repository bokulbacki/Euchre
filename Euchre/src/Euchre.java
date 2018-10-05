import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Euchre
	{
		static ArrayList <Card> deck = new ArrayList<Card>();
		static ArrayList <Card> userHand = new ArrayList<Card>();
		static ArrayList <Card> userTeamate = new ArrayList<Card>();
		static ArrayList <Card> co1 = new ArrayList<Card>();
		static ArrayList <Card> co2 = new ArrayList<Card>();
		static ArrayList <Card> cardsOnTable = new ArrayList<Card>();
		static int winCard;
		static int myNumberOfCards = 5;
		static int yourTeam=0;
		static int coTeam=0;
		static boolean play=true;
		
		static String trumpSuit;
		static String oppTrump;
		static boolean userTurn;
		
		static Scanner userInput = new Scanner(System.in);
		static Scanner i1 = new Scanner(System.in);
		
		public static void makeCards()
			{
				deck.clear();
				deck.add (new Card ("Ace", 14 , "Diamonds", " "));
				deck.add (new Card ("Ace", 14 , "Hearts", " "));
				deck.add (new Card ("Ace", 14 , "Spades", " "));
				deck.add (new Card ("Ace", 14 , "Clubs", " "));
				deck.add (new Card ("Nine", 9 , "Diamonds", " "));
				deck.add (new Card ("Nine", 9 , "Hearts", " "));
				deck.add (new Card ("Nine", 9 , "Spades", " "));
				deck.add (new Card ("Nine", 9, "Clubs", " "));
				deck.add (new Card ("Ten", 10 , "Diamonds", " "));
				deck.add (new Card ("Ten", 10 , "Hearts", " "));
				deck.add (new Card ("Ten", 10 , "Spades", " "));
				deck.add (new Card ("Ten", 10 , "Clubs", " "));
				deck.add (new Card ("Jack", 11 , "Diamonds", " "));
				deck.add (new Card ("Jack", 11 , "Hearts", " "));
				deck.add (new Card ("Jack", 11 , "Spades", " "));
				deck.add (new Card ("Jack", 11 , "Clubs", " "));
				deck.add (new Card ("Queen", 12 , "Diamonds", " "));
				deck.add (new Card ("Queen", 12 , "Hearts", " "));
				deck.add (new Card ("Queen", 12 , "Spades", " "));
				deck.add (new Card ("Queen", 12 , "Clubs", " "));
				deck.add (new Card ("King", 13 , "Diamonds", " "));
				deck.add (new Card ("King", 13 , "Hearts", " "));
				deck.add (new Card ("King", 13 , "Spades", " "));
				deck.add (new Card ("King", 13 , "Clubs", " "));
				Collections.shuffle(deck);
			}
		
		public static void greetUser()
		{
			System.out.println("Welcome to Euchre. Please input your name.");
			String name = userInput.nextLine();
			System.out.println("Hi " + name + "! Would you like to see the cards? y or n");
			String cardView = userInput.nextLine();
			if (cardView.equals("y"))
				{
					for (int i = 0; i < deck.size(); i++)
						{
							System.out.printf("%-20s%-20s%-20s%-20s" , i+1+ " " + deck.get(i).getName() ,
									deck.get(i).getValue() , deck.get(i).getSuit() ,
									deck.get(i).getOwner());
							System.out.println();
						}
				}
		}
		
		public static void shuffleAndDeal()
		{
			System.out.println("This is your hand.");
			for (int a=0; a<5; a++)
				{
					userHand.add( deck.get(0));
					userHand.get(a).setOwner("You");
					deck.remove(0);
					System.out.println(a+1 + "  " +userHand.get(a).getName() +" of "+ userHand.get(a).getSuit());
				}
			System.out.println();
//			System.out.println("This is teamate hand.");
			for (int a=0; a<5; a++)
				{
					userTeamate.add( deck.get(0));
					userTeamate.get(a).setOwner("User Teammate");
					deck.remove(0);
//					System.out.println(userTeamate.get(a).getName() +" of "+ userTeamate.get(a).getSuit());
					
				}
//			System.out.println("This is co1 hand.");
			for (int a=0; a<5; a++)
				{
					co1.add( deck.get(0));
					co1.get(a).setOwner("Computer 1");
					deck.remove(0);
//					System.out.println(co1.get(a).getName() +" of "+ co1.get(a).getSuit());
				}
//			System.out.println("This is co2 hand.");
			for (int a=0; a<5; a++)
				{
					co2.add( deck.get(0));
					co2.get(a).setOwner("Computer 2");
					deck.remove(0);
//					System.out.println(co2.get(a).getName() +" of "+ co2.get(a).getSuit());
				}
			
		}
		
		public static void playEuchre()
		{
		while (play)
		{
			trumpSuit = deck.get(0).getSuit();
			System.out.println("This is the Trump Card: " + deck.get(0).getName() + " of " +deck.get(0).getSuit());
			System.out.println("Would you like to pickup the Trump card? pick or pass");
			String trumpPick = userInput.nextLine();
			trumpPick.toLowerCase();
			if (trumpPick.equals("pick"))
				{
					System.out.println("Choose the card you wish to drop then.");
					for (int a=0; a<5; a++)
						{
							System.out.println(a+1 + "  " + userHand.get(a).getName() +" of "+ userHand.get(a).getSuit());
						}
					int dropCard = i1.nextInt();
					userHand.remove(dropCard-1);
					userHand.add(deck.get(0));
					System.out.println("This is your new hand");
					for (int a=0; a<5; a++)
						{
							System.out.println(a+1 + "  " + userHand.get(a).getName() +" of "+ userHand.get(a).getSuit());
						}
				}
			
			else 
				{
					System.out.println("You refused the card so computer 1 picked up the Trump Card.");
					co1.remove(0);
					co1.add(deck.get(0));
//					for (int a=0; a<5; a++)
//						{
//							System.out.println(co1.get(a).getName() +" of "+ co1.get(a).getSuit());
//						}
				}
			
				userGo();
				co1Go();
				teammateGo();
				co2Go();
				evaluateGuess();
				cardsOnTable.clear();
				winCard=0;
							
				co1Go();
				teammateGo();
				co2Go();
				userGo();
				evaluateGuess();
				cardsOnTable.clear();
				winCard=0;
							
				teammateGo();
				co2Go();
				userGo();
				co1Go();
				evaluateGuess();
				cardsOnTable.clear();
				winCard=0;
				
				co2Go();
				userGo();
				co1Go();
				teammateGo();
				evaluateGuess();
				cardsOnTable.clear();
				winCard=0;
				
				userGo();
				co1Go();
				teammateGo();
				co2Go();
				evaluateGuess();
				cardsOnTable.clear();
				winCard=0;
		}			
		}
		
		public static void evaluateGuess()
		{
			//creates left bower
			if (trumpSuit.equals("Clubs"))
				{
					oppTrump = "Spades";
				}
			else if (trumpSuit.equals("Spades"))
				{
					oppTrump = "Clubs";
				}
			else if (trumpSuit.equals("Hearts"))
				{
					oppTrump = "Diamonds";
				}
			else if (trumpSuit.equals("Diamonds"))
				{
					oppTrump = "Hearts";
				}
		
			for(int i =0; i<cardsOnTable.size(); i++)
				{
					if (cardsOnTable.get(i).getSuit().equals(trumpSuit) && cardsOnTable.get(i).getName().equals("Jack"))
						{
							cardsOnTable.get(i).setValue(cardsOnTable.get(i).getValue()+200);
						}
					
					else if (cardsOnTable.get(i).getSuit().equals(oppTrump) && cardsOnTable.get(i).getName().equals("Jack"))
						{
							cardsOnTable.get(i).setValue(cardsOnTable.get(i).getValue()+150);
						}
					
					else if (cardsOnTable.get(i).getSuit().equals(trumpSuit))
						{
							cardsOnTable.get(i).setValue(cardsOnTable.get(i).getValue()+100);
						}
					
				}
		
		
		
			winCard = cardsOnTable.get(0).getValue();
			for (int i =1; i<cardsOnTable.size(); i++)
				{
					if (cardsOnTable.get(i).getValue()>winCard)
						{
							winCard = cardsOnTable.get(i).getValue();
						}
						
				}
			for (int i =0; i<cardsOnTable.size(); i++)
				{
					if (cardsOnTable.get(i).getValue()==winCard)
						{
							delay();
							System.out.println("The winner of this round is " + cardsOnTable.get(i).getOwner() + " with the card " + cardsOnTable.get(i).getName() + " of " + cardsOnTable.get(i).getSuit() );
							System.out.println();
							if (cardsOnTable.get(i).getOwner().equals("You") ||	cardsOnTable.get(i).getOwner().equals("User Teammate") )
								{
									yourTeam++;
									System.out.println("Your team has won a point.");
								}
							else if (cardsOnTable.get(i).getOwner().equals("Computer 1") ||	cardsOnTable.get(i).getOwner().equals("Computer 2"))
								{
									coTeam++;
									System.out.println("Computer team has won a point.");
								}
						}
				}
			if (yourTeam==5) //fix scoring to win!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!///////////////////////////////////////////////////////
				{
					play=false;
					System.out.println("CONGRATS YOU HAVE WON!!!!!!!!!!!!!!!!!!");
				}
			else if (coTeam==5)
				{
					play=false;
					System.out.println("COMPUTER WINS lol");
				}
			
		}
		
		public static void userGo()
			{
				System.out.println("It is your turn to play your card");
				System.out.println();
				delay();
				System.out.println("The trump suit is " + trumpSuit.toUpperCase());
				System.out.println();
				if (cardsOnTable.size() > 0)
					{
						System.out.println("These are the cards on the table.");
					for (int i =0; i<cardsOnTable.size(); i++)
						{
							System.out.println(i+1 + "  " + cardsOnTable.get(i).getName() + " of "+ cardsOnTable.get(i).getSuit());
							System.out.println("This card was played by " + cardsOnTable.get(i).getOwner());
							delay();
						}
					}
				System.out.println("Please choose a card.");
				for (int a=0; a<myNumberOfCards; a++)
					{
						System.out.println(a+1 + "  " + userHand.get(a).getName() +" of "+ userHand.get(a).getSuit());
					}
				int cardChoice = i1.nextInt();
				cardsOnTable.add(userHand.get(cardChoice-1));
				userHand.remove(cardChoice-1);
				myNumberOfCards--;
				cardChoice=0;
				
			}
		
		public static void co1Go()
			{
				cardsOnTable.add(co1.get(0));
				co1.remove(0);
			}
		
		public static void teammateGo()
			{
				cardsOnTable.add(userTeamate.get(0));
				userTeamate.remove(0);
			}
		
		public static void co2Go()
			{
				cardsOnTable.add(co2.get(0));
				co2.remove(0);
			}
		
		public static void delay()
			{
			try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			
			}
		
		

	}
