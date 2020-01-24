package hom;
/*
 * Hello universe. This game was created by Elizabeth Gonzalez on 9/30/2019.
 * She tried.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class HOM {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		//               S  M  I  P  T
		int [] points = {0, 0, 0, 0, 0};
		int [] daysSpent = new int[4];
		intro(kb);
		System.out.print("Enter your name: ");
		String name = kb.nextLine();
		day1(kb, points, daysSpent);
		day2(kb, points, daysSpent, name);
		day3(kb, points, daysSpent, name);
		day4(kb, points, daysSpent, name);
		day5(kb, points, daysSpent, name);
		day6(kb, points, daysSpent, name);
		kb.close();
	}
	public static void day1(Scanner kb, int[] points, int[] daysSpent) {
		int response = day1Intro(kb);
		kb.nextLine();
		if (response == 1) {
			response = day1HelpPath(kb);
			kb.nextLine();
			if(response == 1)
				day1SpinPath(kb, points, daysSpent);
			else
				day1MisPath(kb, points, daysSpent);
		}
		else if (response == 443)
			day1BlinkPath(kb);
		else
			day1MonsterPath(kb, points, daysSpent);
		printPoints(points);
		kb.nextLine();
	}
	public static void day2(Scanner kb, int[] points, int[] daysSpent, String name) {
		day2Intro(kb, points);
		int response = getResponse(kb, points, daysSpent);
		kb.nextLine();
		choosePath(response, kb, points, daysSpent, name);
		printPoints(points);
		kb.nextLine();
	}
	public static void day3(Scanner kb, int[] points, int[] daysSpent, String name) {
		day3Intro(kb, points);
		int response = getResponse(kb, points, daysSpent);
		kb.nextLine();
		choosePath(response, kb, points, daysSpent, name);
		printPoints(points);
		kb.nextLine();
	}
	public static void day4(Scanner kb, int[] points, int[] daysSpent, String name) {
		day4Intro(kb, points);
		int response = getResponse(kb, points, daysSpent);
		kb.nextLine();
		choosePath(response, kb, points, daysSpent, name);
		printPoints(points);
		kb.nextLine();
	}
	public static void day5(Scanner kb, int[] points, int[] daysSpent, String name) {
		day5Intro(kb, points);
		int response = getResponse(kb, points, daysSpent);
		kb.nextLine();
		choosePath(response, kb, points, daysSpent, name);
		printPoints(points);
		kb.nextLine();
	}
	public static void day6(Scanner kb, int[] points, int[] daysSpent, String name) {
		day6Intro(kb);
		if(points[0] == 1 && points[1] == 1 && points[2] == 1 && points[3] == 1)
			startBlinkPath(kb);
		else if (points[0] >= 3)
			endSpin(kb);
		else if (points[1] >= 4)
			endMisty(kb);
		else if (points[2] >= 3)
			endMer(kb);
		else if (points[3] >= 3)
			endPris(kb);
		else if (points[4] >= 4)
			endTer(kb, name);
		else
			endBad(kb);
	}
	public static int getResponse(Scanner kb, int[] points, int[] daysSpent) {
		System.out.println("1: Check on Spinner");
		System.out.println("2: Check on other monsters");
		if(daysSpent[1] == 1)
			System.out.println("3: Take Terrence up on his offer");
		else if(daysSpent[1] > 1)
			System.out.println("3: Find Misty");
		System.out.print("What will you do? ");
		return kb.nextInt();
	}
	public static void choosePath(int response, Scanner kb, int[] points, int[] daysSpent, String name) {
		if(response == 1) {
			if(daysSpent[0] == 0)
				day1SpinPath(kb, points, daysSpent);
			else if(daysSpent[0] == 1)
				day2SpinPath(kb, points, daysSpent);
			else if(daysSpent[0] == 2)
				day3SpinPath(kb, points, daysSpent);
			else if(daysSpent[0] == 3)
				day4SpinPath(kb, points, daysSpent);
			else
				day5SpinPath(kb, points);
		}
		else if(response == 2) {
			if(daysSpent[2] == 0)
				day1MonsterPath(kb, points, daysSpent);
			else if(daysSpent[2] == 1)
				day2MonsterPath(kb, points, daysSpent, name);
			else if(daysSpent[3] == 2)
				day4PrisPath(kb, points, daysSpent, name);
			else if(daysSpent[3] == 3)
				day5PrisPath(kb, points);
			else if(daysSpent[2] == 2)
				day3MonsterPath(kb, points, daysSpent);
			else if(daysSpent[2] == 3)
				day4MerPath(kb, points, daysSpent);
			else
				day5MerPath(kb, points);
		}
		else if(response == 3) {
			if(daysSpent[1] == 1)
				day2MisPath(kb, points, daysSpent, name);
			else if(daysSpent[1] == 2)
				day3MisPath(kb, points, daysSpent);
			else if(points[4] == 3)
				day5TerPath(kb, points);
			else if(daysSpent[1] == 3)
				day4MisPath(kb, points, daysSpent);
			else if(daysSpent[1] == 4)
				day5MisPath(kb, points);
		}
	}
	public static void intro(Scanner kb) {
		int response = 0;
		System.out.println("This game was made by Elizabeth Gonzalez and completed on 9/30/2019.");
		System.out.println("It was made in Java.");
		System.out.println("This Java IDE has no spell checker for English words.");
		System.out.println("I hope you enjoy it.");
		System.out.println("Press Enter to start.");
		kb.nextLine();
		do {
			System.out.println("1: Would you like to see the instructions?");
			System.out.println("2: Or just get straight to playing?");
			System.out.print("Type the number of your choice and press Enter. ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("House of Monsters is set in an underground facility that holds, you guessed it, monsters. As\n"
					+ "befits such an interesting setting, the main character is a...janitor. This, however, is not his story.\n"
					+ "It's yours. And your goal is to make friends with the monsters. How very reallistic and sweet. Press Enter.\n");
			kb.nextLine();
			System.out.println("Anyway, the society is divided into 8 classes based on psychic ability, because your ability to\n"
					+ "run the government obviously depends on whether or not you can lift a vase with your mind. You are a\n"
					+ "Class Five who's researching monster behavior. You can be a boy, girl, or whatever - it isn't specified.\n"
					+ "You talk to the monsters and sometimes make choices - good answers give you points. If you get enough\n"
					+ "good answers, you can score a character point at the end of the day. The goal is to get a certain number\n"
					+ "of these, usually 3, but more for the harder characters. Hint: Merina and Spinner are easy. Press Enter.\n");
			kb.nextLine();
			System.out.println("Make the choices you think are best and have fun. Now, enough hand holding. Press Enter to see more text!\n");
			kb.nextLine();
		}
	}
	public static int day1Intro(Scanner kb) {
		int response = 0;
		System.out.println("\nDay 1\n");
		kb.nextLine();
		System.out.println("Welcome to your new job. As the elevator carries you down, you cannot help but notice\n"
				+ "how quiet the atmosphere is. The air barely moves. What adventures will this job bring you?\n"
				+ "What will you do? Will you, perhaps, find true friendship?");
		kb.nextLine();
		System.out.println("You exit the elevator and look around. To put it plainly, this place needs some serious TLC.\n"
				+ "It looks like the very foundations of the building want to give up and die. But hey, at least you\n"
				+ "aren't in it alone. There's one other person in this room, a Class Eight janitor, by the looks\n"
				+ "of him. Maybe he can help you figure this place out.\n");
		kb.nextLine();
		do {
			System.out.println("1: Ask for help");
			System.out.println("2: Venture off on your own");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2 && response != 443);
		return response;
	}
	public static void day2Intro(Scanner kb, int[] points) {
		System.out.println("\nDay 2\n");
		kb.nextLine();
		System.out.println("The elevator groans as you make the descent once again to the proper floor. Another day has\n"
				+ "begun. As you breathe in the stale air, rich with the perfume of large animals and hay, you wonder\n"
				+ "where you're going.\n");
		kb.nextLine();
	}
	public static void day3Intro(Scanner kb, int[] points) {
		System.out.println("\nDay 3\n");
		kb.nextLine();
		System.out.println("Yet another sunny, cloudless, over 100 degree day has started. Your boss, a Class Three named\n"
				+ "Felicia, passes by you in the hall and nods curtly. You head off to start work, wondering what adventures\n"
				+ "this day will bring.\n");
		kb.nextLine();
	}
	public static void day4Intro(Scanner kb, int[] points) {
		System.out.println("\nDay 4\n");
		kb.nextLine();
		System.out.println("Here goes another day. Perhaps, despite the dreary work ahead of you, you can get some quality\n"
				+ "conversations in. True friendship awaits!\n");
		kb.nextLine();
	}
	public static void day5Intro(Scanner kb, int[] points) {
		System.out.println("\nDay 5\n");
		kb.nextLine();
		System.out.println("The monsters seem agitated today. Somehow, the way they pace around in their cages reminds you\n"
				+ "of the way that small animals act before a large storm. Something big may be coming. Best make friends\n"
				+ "while the weather is fair, and they may help you when the storm hits.\n");
		kb.nextLine();
	}
	public static void day6Intro(Scanner kb) {
		System.out.println("\nDay 6\n");
		kb.nextLine();
		System.out.println("The elevator stops. You wait for the doors to open. When they remain closed, you press the\n"
				+ "button again. The doors remain firmly shut.\n");
		kb.nextLine();
		System.out.println("They open. Quickly, you step off the elevator, eager to get away from its confines. The light\n"
				+ "above you flickers.\n");
		kb.nextLine();
		System.out.println("An aura of unease hangs around the air. It could just be a lingering fear from your earlier\n"
				+ "accident, but you cannot seem to shake it. The monsters know, but you do not.\n");
		kb.nextLine();
		System.out.println("It's late into your shift when the storm hits.\n");
		kb.nextLine();
		System.out.println("This is not a drill. If it was a drill, the halls around you would not be echoing with the sounds\n"
				+ "of inhuman screams. The cage in front of you would not be open, and the canine monstosity that was its former\n"
				+ "inhabitant would not be crouched menacingly outside of it.");
		kb.nextLine();
		System.out.println("There is nowhere for you to run. Psychically, you try to push it back, but it shrieks and your\n"
				+ "control is suddenly snapped. You try again and again, but each time, it mentally pushes you away. You\n"
				+ "realize that there is no way to fight back. You close your eyes...");
		kb.nextLine();
	}
	public static int day1HelpPath(Scanner kb) {
		int response = 0;
		System.out.println();
		System.out.println("You wave at the man and he notices you. He stops his work and comes over, and\n"
				+ "you notice that his name tag reads 'Terrence.' You explain to him that this is your first day\n"
				+ "and you're not really sure where you're supposed to go. He nods, understanding, and points you\n"
				+ "in the right direction.\n");
		kb.nextLine();
		System.out.println("You head off and find the monster you were assigned to take care of: Spinner. It looks like a\n"
				+ "giant spider, but instead of having eight arms, you count 12. Some of them end in claws and others\n"
				+ "in spikes, and one pair of them are odd little cones whose purpose you cannot begin to guess.\n"
				+ "He sees you (lol im spi-derp) and his purple eyes narrow. \"Hello there :P,\" he says.\n");
		kb.nextLine();
		do {
			System.out.println("1: Answer the monster");
			System.out.println("2: Ignore him and keep working");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		return response;
	}
	public static void day1SpinPath(Scanner kb, int[] points, int[] daysSpent) {
		daysSpent[0]++;
		System.out.println();
		System.out.println("You greet the giant spider. \"Hi :D,\" he hisses. You notice that he's watching you\n"
				+ "rather intently (with his lolSexy eyes).\n");
		kb.nextLine();
		System.out.println("Spinner's twelve legs fly about almost hypnotically (oOo). You should be wondering why you are\n"
				+ "talking to a gigantic spider, but here you are. Good job for playing this game. I think Spinner will be\n"
				+ "a good friend. Yay.\n");
		kb.nextLine();
		points[0]++;
	}
	public static void day2SpinPath(Scanner kb, int[] points, int[] daysSpent) {
		daysSpent[0]++;
		int spinPoints = 0;
		int response = 0;
		System.out.println("\nHere you are, talking to Spinner the giant spi-derp. You should think of something to say.\n");
		kb.nextLine();
		do {
			System.out.println("1: Talk about the weather.");
			System.out.println("2: Talk about bugs.");
			System.out.println("3: Talk about football.");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2 && response != 3);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("The 100 plus degree weather is, in fact, quite nice. It is too bad that Spinner is a giant\n"
					+ "spider and in a cage, or he would appreciate all the wonderful things you have to say about the sun.\n");
		}
		else if(response == 2) {
			System.out.println("Being that you are talking to a giant spider, you decide to talk about bugs. Spinner\n"
					+ "discusses his favorite bugs to eat for over an hour. You tell him about the one time you accidentally\n"
					+ "ate a mosquito.\n");
			spinPoints++;
		}
		else {
			System.out.println("This does not work. You have failed. You have seriously failed. I hope that you are\n"
					+ "regretting each and every one of the life choices that led up to you picking this option. Boo.\n");
			spinPoints--;
		}
		kb.nextLine();
		System.out.println("Spinner stretches his legs and yawns :O. \"Well, it certainly was interesting, speaking with you,\"\n"
				+ "he says. You nod, feeling the exact same way.\n");
		kb.nextLine();
		System.out.println("Spinner has one last thing to say, though. His LOLpurple eyes narrow and his spidery fangs glisten.\n"
				+ "\"So,\" he says, turning around slowly. Your heart begins to flutter in anticipation. \"What do u think,\"\n"
				+ "he hisses, \"of outdated memes?\"");
		kb.nextLine();
		System.out.println("His second body segment is entirely covered in outdated memes.");
		kb.nextLine();
		do {
			System.out.println("1: I seek true memeship. We are a match made in an underground facility.");
			System.out.println("2: No.");
			System.out.print("What will you say? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("Ask and you shall receive, my friend.\n");
			spinPoints++;
		}
		else {
			System.out.println("Nu!1!1! Yu have to ste focused! Mek friends wit da spi-derp, remember?!\n");
		}
		kb.nextLine();
		if (spinPoints >= 1)
			points[0]++;
	}
	public static void day3SpinPath(Scanner kb, int[] points, int[] daysSpent) {
		int response = 0;
		daysSpent[0]++;
		System.out.println("\nThese long, meaningful conversations, they are really going places! As the passionate\n"
				+ "friendship between you and Spinner continues, the great cosmic clock of loldom ticks\n"
				+ "down to the end of this magical time. You wonder, are you really ready to be friends with Spinner?\n");
		kb.nextLine();
		System.out.println("There may still be time left. If you back out now, you might still have a\n"
				+ "chance to get a good ending. Are you really ready to commit to this spider?\n");
		kb.nextLine();
		do {
			System.out.println("1: I would give him my mind, body, soul, and (most importantly) heart. I am ready for this.");
			System.out.println("2: Actually, no.");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("uwu! Let's see this friendship through!\n");
			kb.nextLine();
			points[0]++;
		}
		else {
			System.out.println("You run the heck out of there and find some other monsters to bother.\n");
			kb.nextLine();
			choosePath(2, kb, points, daysSpent, "Sweetie");
		}
	}
	public static void day4SpinPath(Scanner kb, int[] points, int[] daysSpent) {
		daysSpent[0]++;
		System.out.println("\nSpinner, Spinner, in a web.\n");
		kb.nextLine();
		System.out.println("Spinner is an awesome spi-derp.\n");
		kb.nextLine();
		System.out.println("I hope you have no regrets.\n");
		kb.nextLine();
		System.out.println("Because I certainly do after writing this.\n");
		kb.nextLine();
		points[0]++;
	}
	public static void day5SpinPath(Scanner kb, int[] points) {
		System.out.println("\nI warned you. There is no turning back.\n");
		kb.nextLine();
		System.out.println("But here you are.\n");
		kb.nextLine();
		System.out.println("You have nothing in common with a giant spider. Do you realize this?\n");
		kb.nextLine();
		System.out.println("But nooooooo. You had to ask for this.\n");
		kb.nextLine();
		System.out.println("OMG! Spinner is like, so cool! U hav so much in commom wit a giant spider! U r such friends!\n");
		kb.nextLine();
		System.out.println("It is a beautiful day.\n");
		kb.nextLine();
		points[0]++;
	}
	public static void endSpin(Scanner kb) {
		System.out.println("Spinner drops from the ceiling, landing between you and the monster. It is quick, brutal, and\n"
				+ "executed with an almost cartoony level of violence, but Spinner comes out without a single scratch.\n");
		kb.nextLine();
		System.out.println("Then Spinner turns to you. It's awesome. You love him so much (as a friend). You do not wonder\n"
				+ "why the writing quality is so bad. You do not wonder this because you are too busy admiring his anthro\n"
				+ "form. It is so awesome. You are now making out (in an absolutely platonic way).\n");
		kb.nextLine();
		System.out.println("If there was a picture here, you would totally be swooning. You have won the friendship sim. ;D\n");
		kb.nextLine();
		System.out.println("gg\n");
                new JavaSwingImage(256, 300, "SpinEnd");
	}
	public static void day1MisPath(Scanner kb, int[] points, int[] daysSpent) {
		int response = 0;
		System.out.println();
		System.out.println("The monster mumbles something about u suk at manners, but does not attempt to make conversation\n"
				+ "again. You study a pair of rodent-like monsters in peace and are heading out when you see Terrence.\n");
		kb.nextLine();
		do {
			System.out.println("1: Wave him over. You want to talk.");
			System.out.println("2: Just head home.");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if (response == 1) {
			System.out.println("You call him over. As you're walking, you make conversation about your day. When you tell him about\n"
					+ "your experience with Spinner, he seems to understand. \"He's really not that bad, though. Most of\n"
					+ "the monsters aren't.\"\n");
			kb.nextLine();
			System.out.println("You chatter on for a little while. Eventually, you find yourself at the bus stop, and you stop\n"
					+ "with Terrence to wait for it. Suddenly, he asks, \"You're here tomorrow, too, right? If you would like, I could\n"
					+ "introduce you to one of the nicer monsters.\"\n");
			kb.nextLine();
			System.out.println("You'll definitely think about it.\n");
			daysSpent[1]++;
		}
		else
			System.out.println("So home you go.\n");
		kb.nextLine();
	}
	public static void day2MisPath(Scanner kb, int[] points, int[] daysSpent, String name) {
		daysSpent[1]++;
		int response = 0;
		int terPoints = 0;
		int misPoints = 0;
		System.out.println("\nYou find Terrence almost immediately. \"Hi, I decided to take you up on that offer. What kind\n"
				+ "of monster are we up against today?\" you ask him.\n");
		kb.nextLine();
		System.out.println("He grins. \"Nothing too serious,\" he replies as the two of you head off down the cement\n"
				+ "halls. \"Misty is actually really nice. I think you'll like her.\" He turns the corner and you follow.\n");
		kb.nextLine();
		do {
			System.out.println("1: Walk in silence");
			System.out.println("2: Make conversation");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if (response == 2) {
			System.out.println("You ask him how long he's been working here, and it turns out that he has had\n"
					+ "this job for a little over a year. He speaks as quickly as he walks, and whenever it's your turn\n"
					+ "to say something, you realize that you're nearly panting!\n");
			kb.nextLine();
			terPoints++;
		}
		System.out.println("Eventually, you both stop. The monster in front of you presses her nose against the glass and chirps\n"
				+ "happily at Terrence. Her eyes are black and glassy, and there is a white butterfly resting on her head.\n"
				+ "She notices you and tilts her head to the side, apparently confused. \"Misty, this is " + name + ",\"\n"
				+ "Terrence introduces you.\n");
		kb.nextLine();
		do {
			System.out.println("1: Hi there.");
			System.out.println("2: I like your butterfly.");
			System.out.print("What will you say? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 2) {
			System.out.print("Apparently taking this as a compliment, Misty blushes pale pink. ");
			misPoints++;
		}
		System.out.println("She smiles at you and waves. The butterfly on her head\nflutters for a moment before settling"
				+ "down again.\n");
		kb.nextLine();
		System.out.println("Terrence has to go back to his job, and so do you, but at lunchtime, the three of you reconvene.\n"
				+ "You unwrap the food bar you brought, Terrence unwraps his, and Misty digs into whatever unidentifiable\n"
				+ "monster food she has to eat. She takes a bite and then looks at you. Catching your attention, she tosses\n"
				+ "it into the air and the butterfly snatches it out of the air. She giggles and performs the trick again.\n");
		kb.nextLine();
		System.out.println("After showing off for a little while, Misty puts her hands on her hips and chirps at Terrence. She\n"
				+ "makes a series of complicated gestures with her hands, but Terrence seems to understand them because he starts\n"
				+ "shaking his head. \"No, Misty. That isn't very professional.\" You're still waiting for a translation, and he\n"
				+ "starts blushing furiously. \"She, um, she really wants me to show you this stupid food tossing trick,\" he finally\n"
				+ "says, flashing Misty a dirty look which she innocently ignores. \"I don't usually do this at work. I-I mean, this\n"
				+ "is stupid.\" At about this time, he realizes that it's in his best interest to quit talking. He shakes his head. Misty\n"
				+ "points at him and nods.\n");
		kb.nextLine();
		do {
			System.out.println("1: Side with Terrence");
			System.out.println("2: Side with Misty");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("You've had your fun, and you decide to give the janitor a break. \"All right, we'll just have\n"
					+ "to see Terrence's award winning food toss some other day,\" you smile. Misty shrugs, and Terrence folds\n"
					+ "his arms, mumbling something about not being a trick monkey. Still, the look he gives you has a hint of\n"
					+ "gratefulness in it. It's not often that somebody sides with a Class Eight, even for something unimportant\n"
					+ "like this.\n");
			terPoints++;
		}
		else {
			System.out.println("\"Come on, Terrence, I have to see this!\" you say, joining Misty in her encouragement.\n"
					+ "Terrence rolls his eyes and breaks a piece off of his Food Bar. With a spectacular toss, he makes\n"
					+ "the catch with his mouth before declaring that the rest of the food has to go in his mouth the normal way\n"
					+ "or he'll be starved. Misty catches your attention and giggles.\n");
			misPoints++;
		}
		kb.nextLine();
		System.out.println("With that little adventure over, the bell rings, signalling the end of lunch. It's time for you\n"
				+ "to head back to work.\n");
		kb.nextLine();

		if(terPoints >= 2)
			points[4]++;
		else if(misPoints >= 1)
			points[1]++;
	}
	public static void day3MisPath(Scanner kb, int[] points, int[] daysSpent) {
		daysSpent[1]++;
		int terPoints = 0;
		int misPoints = 0;
		int response = 0;
		System.out.println("\nYou head over to Misty's pen, deciding it is the best place to find her and Terrence. The janitor\n"
				+ "isn't there, but Misty waves at you.");
		kb.nextLine();
		do {
			System.out.println("1: Chat with her.");
			System.out.println("2: Search for Terrence.");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("You can't really talk with Misty, but she does seem to enjoy hearing what you have to say.\n"
					+ "You ramble on about the weather and your job and whatever else happens to come to your mind.\n");
			misPoints++;
			kb.nextLine();
			System.out.println("When you run out of things to say, it's so quiet that you can hear the monsters breathing\n"
					+ "heavily in their prisons. A chirp breaks the silence. You turn and see Misty tapping on the glass.\n"
					+ "When she realizes she's got your attention, she starts charading the act of eating with a spoon.\n"
					+ "\"What are you doing? Are you needing to eat?\" you ask, remembering that it's your job to feed the\n"
					+ "monsters. She shakes her head and makes a series of gestures with her hands. You understand. She is\n"
					+ "trying to teach you what the word \"eat\" is in her language.\n");
			kb.nextLine();
			System.out.println("You learn a few more words: \"butterfly,\" \"light,\" \"see,\" before Terrence finally jogs\n"
					+ "up. \"Hi guys,\" he says, putting one hand on the wall. \"Sorry I'm late. One of the smaller monsters\n"
					+ "got out and tried to eat my mop.\"\n");
		}
		else {
			System.out.println("You head off to look for the Class Eight. He's bent over one of the smaller cages, pulling\n"
					+ "something away from the furry creature on the ground. It's a monster! Before you can run for help,\n"
					+ "Terrence pulls his mop out of the creature's grasp and calls out, \"This is a phase mole! They aren't\n"
					+ "dangerous, but they get out all the time.\"\n");
			kb.nextLine();
			System.out.println("It isn't exactly the most comforting speech, but it makes you take a second look at the creature.\n"
					+ "It's small and furry and it resembles a mole very closely. Using its tiny front paws, it takes hold of the\n"
					+ "mop once again and pulls.\n");
			terPoints++;
			kb.nextLine();
			System.out.println("It's actually kind of cute. Feeling a little bolder, you put on your gloves and pry it away\n"
					+ "from its wooden treasure. You plop it back into its cage and it wanders around. \"Thanks,\" says\n"
					+ "Terrence. You both head back to Misty.\n");
		}
		kb.nextLine();
		System.out.println("The three of you sit down to lunch. After a few lazy comments about the weather, Terrece starts\n"
				+ "complaining about his boss. According to him, she's incredibly strict and most of all, rude. You don't\n"
				+ "know Felicia too well, but she didn't strike you as particularly awful.\n");
		kb.nextLine();
		System.out.println("\"Yeah, well, she is. Creepy, too.\" He scoffs. \"Just look at the way she's always...\"\n");
		kb.nextLine();
		System.out.println("He stops suddenly. \"Never mind. She's not that bad, really.\" He doesn't\n"
				+ "seem to want to talk about it.\n");
		kb.nextLine();
		do {
			System.out.println("1: Press him about Felicia");
			System.out.println("2: Change the subject");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("He really doesn't seem to want to talk about it, but apparently, she's been singling him out\n"
					+ "for trouble for some really pointless things. \"It's nothing, really.\" He avoids your gaze and quickly\n"
					+ "returns to work when the bells signal the end of lunch. Maybe you shouldn't have pushed him so much.\n");
			terPoints--;
		}
		else {
			System.out.println("You instead start praising the remarkable triple butterfly toss that Misty just pulled off.\n"
					+ "All three of you are happy, and lunch ends far too soon.\n");
		}
		kb.nextLine();

		if (terPoints >= 1)
			points[4]++;
		else if (misPoints >= 1)
			points[1]++;
	}
	public static void day4MisPath(Scanner kb, int[] points, int[] daysSpent) {
		int response = 0;
		int misPoints = 0;
		daysSpent[1] ++;
		System.out.println();
		System.out.println("You find that Misty girl and give her a cheerful hello.\n");
		kb.nextLine();
		System.out.print("The two of you sit, you leaning against the glass and Misty sitting against it on the other side. ");
		if(points[1] >= 2)
			System.out.println("Misty chirps at you happily.");
		System.out.println();
		kb.nextLine();
		System.out.println("So, let's interview this monster!");
		kb.nextLine();
		if(points[4] == 2) {
			System.out.println("Actually, now that you think about it, you haven't seen Terrence all day. Would you like\n"
					+ "to find him?\n");
			kb.nextLine();
			do {
				System.out.println("1: Yes");
				System.out.println("2: No");
				System.out.print("What will you decide? ");
				response = kb.nextInt();
			} while(response != 1 && response != 2);
			kb.nextLine();
			System.out.println();
			if(response == 1) {
				day4TerPath(kb, points, daysSpent);
				return;
			}
		}
		System.out.println("Misty chirps happily at your questions. You're not quite sure if she understands all of them,\n"
				+ "and you know that you don't understand all of her answers, but it's still a good time. She pantomimes\n"
				+ "things out and the two of you play charades while her little white butterflies flutter.\n");
		kb.nextLine();
		System.out.println("After a little while, you notice that she's getting tired.\n");
		kb.nextLine();
		System.out.println("Suddenly, you have a new question for her.\n");
		kb.nextLine();
		System.out.println("\"Hey, Misty!\" you call. \"Can you do this?\" Breaking off a piece of your Food Bar, you toss\n"
				+ "it into the air and spectacularly fail at catching it. She bursts into giggles and attempts the trick with\n"
				+ "her own lunch. Of course, it always helps to have a few butterflies.\n");

		kb.nextLine();
		System.out.println("How loudly are you going to cheer?\n");
		do {
			System.out.println("1: Quiet");
			System.out.println("2: Loud");
			System.out.println("3: Ultra");
			System.out.print("What will you say? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2 && response != 3);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("Misty tosses it higher, not wanting to disappoint you. You barely clap, and the pale blush creeps\n"
					+ "into her cheeks.\n");
		}
		else if (response == 2) {
			System.out.println("You applaud. Beaming, she gives a little clap and makes the catch again and again.\n");
			misPoints++;
		}
		else {
			System.out.println("You attempt to break the sound barrier. Misty beams with pride, and her face suddenly reddens\n"
					+ "because just about every monster in the hallway starts shouting that you have no idea what peace and quiet\n"
					+ "is. Your face floods with blush.\n");
		}
		kb.nextLine();
		System.out.println("Misty's butterflies seem to be tiring out. She sits down and moves a little closer to the glass.\n");
		kb.nextLine();
		System.out.println("She squeaks.\n");
		kb.nextLine();
		System.out.println("Tell her a story?\n");
		do {
			System.out.println("1: Yes");
			System.out.println("2: No");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			misPoints ++;
			System.out.println("You lean back against the glass, thinking of a good tale to tell. After a bit of thinking,\n"
					+ "you settle on a fantasy one about a magical shaft of silver light. It isn't as good as you remember\n"
					+ "it to be, but it brings back memories of childhood and true friends and summers long ago but not forgotten.\n");
			kb.nextLine();
			System.out.println("Misty listens, her wide eyes drinking in every word. She curls up and sits so close that you\n"
					+ "barely remember that only a thick sheet of containment glass separetes you from the monster.\n");
			kb.nextLine();
			System.out.println("She hugs her knees to her chest and twitters.\n");
		}
		else {
			System.out.println("You sit together in silence. Eventually, you look over to find Misty fast asleep.\n");
		}
		kb.nextLine();
		System.out.println("That's when the sirens start.\n");
		kb.nextLine();
		System.out.println("Your first though is, \"Monster escape!\" But that isn't it. The people you see running aren't\n"
				+ "moving quickly enough for that.\n");
		kb.nextLine();
		System.out.println("The crowd is too thick. Most of the people are Class Sixes and Sevens who let you through once they\n"
				+ "realize your status. Still, a pair of medics, both Class Fives, shoo you back as they try to assess the\n"
				+ "situation for themselves.\n");
		kb.nextLine();
		System.out.println("There has been a murder. Your own boss, Felicia, has already admitted her guilt, although she\n"
				+ "claims that it was in self defence. She sits in the corner, still in shock as the Class Four doctor checks\n"
				+ "her for wounds. She is gasping.\n");
		kb.nextLine();
		System.out.println("Terrence, the Class Eight janitor, is dead.\n");
		kb.nextLine();
		System.out.println("You leave the scene, surprised and a little frightened, and head back to Misty. Terrence may have\n"
				+ "only been a Class Eight, but he was still her friend. Misty cries and cries.\n");
		if(misPoints >= 1)
			points[1]++;
		points[4] = 0;

		kb.nextLine();
	}
	public static void day5MisPath(Scanner kb, int[] points) {
		System.out.println();
		System.out.println("When Misty sees you, she chirrups sadly. Her eyes are filled with tears.\n");
		kb.nextLine();
		System.out.println("If you could reach through the glass, you would hold her. Instead, you sit in silence, listening\n"
				+ "to her soft, hiccupy breaths through the glass.\n");
		kb.nextLine();
		System.out.println("\"It's going to be okay,\" you assure her. She sniffles again, but looks into your eyes. \"It's\n"
				+ "going to be okay,\" you repeat.\n");
		kb.nextLine();
		System.out.println("What are you doing? You're supposed to be monster caretaker! If nothing else is clear to you,\n"
				+ "this monster needs some care right now!\n");
		kb.nextLine();
		System.out.println("You slip on your gloves and open the enclosure. Misty looks up at you, still weeping. You take\n"
				+ "her into your arms and let her tears wet the front of your uniform. Her little body shakes, and it feels\n"
				+ "so cold against yours. You hold her close.\n");
		kb.nextLine();
		System.out.println("She lets the tears run their course. As the two of you stand, sharing your sadness, the echoes of distant\n"
				+ "howls grow unimportant. Misty finally stops crying.\n");
		kb.nextLine();
		System.out.println("She stays in your arms for another moment before letting go. In the distance, a monster wildly\n"
				+ "screams. You think Misty is going to start crying again, but instead, she looks up with her wide, glassy\n"
				+ "eyes and makes a single sign.");
		kb.nextLine();
		System.out.println("'Friend.'");
		kb.nextLine();

		points[1]++;
	}
	public static void endMisty(Scanner kb) {
		System.out.println();
		System.out.println("All of a sudden, milky white butterflies surround the creature. At first, you take it as a welcome\n"
				+ "distraction. While they swarm the monster, you take your chance and run. Behind you, your would-be attacker growls.\n"
				+ "Suddenly, it lets out a scarp cry.\n");
		kb.nextLine();
		System.out.println("The butterflies have changed color. Instead of a chalky white, they now come in shades of blue, ranging from\n"
				+ "pale periwinkle to deep indigo. The monster howls in pain and blindly runs.\n");
		kb.nextLine();
		System.out.println("You hear Misty's familiar chirping. The butterflies flock to her, and once they are all accounted for,\n"
				+ "She slips into your arms for a moment before the two of you take off running.\n");
		kb.nextLine();
		System.out.println("When the portal opens up to take Misty home, she turns around and squeezes your hand. This is goodbye.\n"
				+ "Through the hazy surface, butterflies swirl, and a figure waves at Misty in the distance.\n");
		kb.nextLine();
		System.out.println("She is home.\n");
              new JavaSwingImage(256, 300, "MistyEnd");
	}
	public static void day4TerPath(Scanner kb, int[] points, int[] daysSpent) {
		int response = 0;
		System.out.println();
		System.out.println("You poke around for a bit, looking for Terrence. You pause for a moment, and one monster with cascading\n"
				+ "tentacles starts slamming its body against the side of its pen. You move on.\n");
		kb.nextLine();
		System.out.print("Ah, there's Terrence. He's mopping up a spill on the floor, and the boss, Felicia, is watching him.\n"
				+ "They seem to be busy. You hang back and listen.\n");
		kb.nextLine();
		System.out.println("\"You missed a spot,\" says Felicia. Terrence moves to clean it. Suddenly, the Class Three grabs\n"
				+ "for the mop and snatches it.\n");

		kb.nextLine();
		System.out.println("\"I got it,\" says Felicia, daintily brushing the head of the mop against the floor. She smiles,\n"
				+ "handing it back to the janitor.\n");
		kb.nextLine();
		System.out.println("She swipes it back. \"Missed another spot,\" she smiles, bringing the dripping mop lightly down on\n"
				+ "Terrence's head.\n"
				+ "\"Ha ha, Felicia,\" he rolls his eyes. He gives a smile, but it looks forced.\n");
		kb.nextLine();
		do {
			System.out.println("1: Intervene");
			System.out.println("2: Keep watching");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("\"Hi, am I interrupting something?\" you ask, stepping forward. Felicia wheels toward\n"
					+ "you in surprise, blushing as she tries to figure out just how much of her unprofessional behavior\n"
					+ "you just witnessed.\n");
			kb.nextLine();
			System.out.println("\"No, it's all good,\" she tells you, regaining her composure. She walks away quickly, and you catch\n"
					+ "Terrence staring at you with a strange expression before he returns to his cleaning.\n");
			points[4]++;
			kb.nextLine();
			return;
		}
		System.out.println("Felicia hands the mop back, and this time, Terrence gets to take it. He resumes his work, but\n"
				+ "Felicia stays where she is. She bites her lip.\n");
		kb.nextLine();
		System.out.println("\"I had this sudden memory of how a few years ago, there was a huge influx of cheesey romance\n"
				+ "novels. It was all anybody talked about. Did you ever get into one of those?\"\n");
		kb.nextLine();
		System.out.println("\"No ma'am, not really.\"\n");
		kb.nextLine();
		System.out.println("\"Of course you didn't.\" Her eyes narrow slightly. \"You're just a stupid Class Eight.\"\n");
		kb.nextLine();
		System.out.println("Terrence focuses a little harder on the floor.\n");
		kb.nextLine();
		System.out.println("\"Can you even read?\" Felicia asks, pushing herself off of the wall to circle around\n"
				+ "Terrence. \"Sometimes I wonder why Class Eights are even kept around. How do you function without\n"
				+ "psionics?\"\n");
		kb.nextLine();
		System.out.println("She pauses in front of Terrence. \"Maybe it would be better if we just got rid of people like\n"
				+ "you before they're even born.\"\n");
		kb.nextLine();
		do {
			System.out.println("1: Intervene");
			System.out.println("2: Keep watching");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("You step forward and Felicia notices you. Quickly, she resumes a proper posture and glares\n"
					+ "at you. \"Class Five, do you not have a job to complete?\" You stammer out an explanation, but Felicia\n"
					+ "is already storming away. \"Let this be your warning,\" she says, and leaves it at that.\n");
			kb.nextLine();
			System.out.println("You shiver despite the heat and glance at Terrence. He glances at you for a brief second\n"
					+ "before returning to his work, as if this has been the most ordinary day in the universe.\n");
			points[4]++;
			kb.nextLine();
			return;
		}
		System.out.println("\"Maybe it would be better that way.\"\n");
		kb.nextLine();
		System.out.println("\"Class Eight are you listening to me?\" Felicia suddenly yells. She wrenches the mop out of the\n"
				+ "surprised Terrence's hands and he takes a step backward to avoid being hit by the cleaning instrument.\n"
				+ "Felicia tosses it behind her and you cover your mouth, squeezing a little farther back into the shadows.\n");
		kb.nextLine();
		System.out.println("\"I wish you could understand one ounce of how difficult this is for me,\" Felicia grimaces,\n"
				+ "biting her lip and suddenly backing away. \"Don't you realize you're hurting me?\"\n");
		kb.nextLine();
		System.out.println("\"Ma'am, I-\"\n"
				+ "\"Get back to work!\" she screams.\n");
		kb.nextLine();
		System.out.println("A psychic bolt shoots out of Felicia's forehead and launches Terrence into the wall. There is\n"
				+ "a horrible crack, and for a moment, Terrence is wide-eyed with dizzyness and shock. The next, you're\n"
				+ "staring at a wall covered in internal fluids. Felicia screams and covers her mouth, and then the\n"
				+ "telekinetic blast reverses and she is holding him, clutching him, and weeping. She guides his hands\n"
				+ "to her face, holding him upright like a puppet with her mental powers. She gives him one final, chaste\n"
				+ "kiss, and then throws Terrence's lifeless body off of her and screams.\n");
		kb.nextLine();
		do {
			System.out.println("1: Tell someone");
			System.out.println("2: Keep watching");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("Shakily, you back away, hoping that Felicia doesn't notice you. She runs in the other direction,\n"
					+ "passing by you without a second glance.\n");
			kb.nextLine();
			System.out.println("When her story comes out, that she was attacked and had only been defending herself, there is\n"
					+ "something to counter it. With your insistence, matters aren't so quick to be closed, and after some\n"
					+ "poking around, the truth may be revealed.\n");
			kb.nextLine();
			System.out.println("The law will protect you from Felicia, but you still fear for your safety. If she's already\n"
					+ "getting in this much trouble, what's a little more?\n");
			kb.nextLine();
			System.out.println("If it's one small comfort, Misty listens to your every word about what happened. Her twitterings\n"
					+ "are low and mournful, and tears decorate her face constantly.\n");
			kb.nextLine();
			System.out.println("You may not have saved Terrence, but you brought justice to his death. In the wake of this\n"
					+ "tragic event, Misty looks to you for comfort.\n");
			kb.nextLine();
			points[4] = 0;
			points[1]++;
			return;
		}
		System.out.println("Felicia screams. Blasting the lifeless janitor back into the wall, she screams and bolts away.\n");
		kb.nextLine();
		System.out.println("When her superiors hear her side of the story, it's the only side they hear. Terrence was the\n"
				+ "attacker and Felicia was fighting back to defend herself. The psychic burst produced in her fear ended up\n"
				+ "being larger than it had been intended to be. Murmurs of \"dirty Class Eight\" flutter through the crowd.\n");
		kb.nextLine();
		System.out.println("Maybe the authorities realize that this wasn't what happened. But the case is closed with this\n"
				+ "as the decision. Felicia leaves unblemished.\n");
		kb.nextLine();
		System.out.println("As for Misty, she cries and cries.\n");
		kb.nextLine();
		points[4] = 0;
	}
	public static void day5TerPath(Scanner kb, int[] points) {
		int response = 0;
		int terPoints = 0;
		System.out.println();
		System.out.println("There's a tense silence over lunch today. Misty doesn't chirp happily and Terrence eats quickly,\n"
				+ "but you notice him glance over at you more than once.\n");
		kb.nextLine();
		System.out.println("Lunch ends. You go back to work. For the rest of the day, studying monsters occupies your full\n"
				+ "attention, but at the end of the day, you run into Terrence again. He pauses and seems like he wants to say\n"
				+ "something, but instead he puts his hands in his pockets and gives you a quiet goodbye before hurrying to the bus stop.\n");
		kb.nextLine();
		System.out.println("You don't take that bus, but today, curiosity overcomes you and you follow him. He's walking\n"
				+ "quickly, but something tells you he realizes you're following him.\n");
		kb.nextLine();
		System.out.println("He reaches his usual stop and turns around. \"Are you going to follow me all night?\" he asks.\n");
		kb.nextLine();
		do {
			System.out.println("1: Yes");
			System.out.println("2: No");
			System.out.print("What will you say? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("Wow. You have no subtlety whatsoever.\n");
		}
		else {
			terPoints ++;
			System.out.print("You blush, embarrased, and mutter that you were just about to leave. Quickly, you turn around.\n" + 
					"\"Wait.\"\n");
			kb.nextLine();
			System.out.println("Terrence is looking at you. He stands there, awkwardly, and remains paused. \"I’m sorry, okay?\n" + 
					"I didn’t mean to say it that way.\"\n");
		}
		kb.nextLine();
		System.out.println("He sighs and turns away again. \"Look, I think I get what you're looking for,\" he says. \"These\n"
				+ "things never work. You’re a Class Five and I’m, well, I’m a Class Eight. There’s just too much of a\n"
				+ "power difference here. Do you understand?\"\n");
		kb.nextLine();
		do {
			System.out.println("1: Yeah");
			System.out.println("2: Not really");
			System.out.print("What will you say? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("\"Thank you.\" He looks relieved.\n");
		}
		else {
			System.out.print("He folds his arms. \"Tell me one person you know who wouldn't think you're digging through the\n"
					+ "trash by hanging out with a Class Eight. The fact is, you could force me to do just about whatever\n" 
					+ "with your psychic control, and there’s really not much I can do to stop it. I like you, really, and\n"
					+ "you don’t seem the type to go around hurting people, but I’ve just seen too many bad situations\n"
					+ "to want to jump into a relationship right away.\"\n");
		}
		kb.nextLine();
		System.out.println("You leave to walk back to your bus stop, but something makes you turn back. \"Can we at least\n"
				+ "be friends?\" you wonder.\n");
		kb.nextLine();
		System.out.println("Terrence blinks at you. He looks small compared to the cityscape behind him, and he seems aware\n"
				+ "of it. The sun's light has almost faded from the sky. \"Um, sure,\" he replies, still a little surprised.\n");
		kb.nextLine();
		System.out.println("A bus drives by, its headlights illuminating the street with a split second of brightness.\n"
				+ "Terrence closes his eyes. \"First I get all chatty with a killer monster, and now here I am, making\n" 
				+ "friends with a Class Five. I must really have a death wish. You sure you still want to be friends with\n"
				+ "a guy like me?\"");
		kb.nextLine();
		System.out.println("Heck yes. This is the one moment that all of the straight girls have been waiting for. There\n"
				+ "is absolutely no option to say no to this friendship.\n");
		kb.nextLine();
		System.out.println("It's time to seduce the janitor.\n");
		kb.nextLine();
		System.out.println("\"Hey, um, if you aren't doing anything tonight, do you want to go to the bar together?\" He\n"
				+ "pauses. \"My treat,\" he adds.\n");
		kb.nextLine();
		System.out.println("Well, he's paying. \"Okay,\" you shrug, and step next to him. Work tomorrow is going to be\n"
				+ "EXTREMELY awkward.\n");
		kb.nextLine();
        System.out.println("The bus arrives, and you both get on. There's one other person sitting in it, a haggard Class\n"
				+ "Eight man who coughs to the side before going back to picking at his frayed sun jacket. Terrence glances\n"
				+ "at you. \"Let's sit here?\" he says, gesturing toward a seat closer to the front. You take it, and he\n"
				+ "fills the one next to you.\n");
		kb.nextLine();
		System.out.println("The scenery outside changes. In the darkness, you can see people and buildings whiz by. This\n"
				+ "looks like it's an older part of town.\n");
		kb.nextLine();
		System.out.println("Terrence remains quiet. Every once in a while, he'll glance behind him and then go back to\n"
				+ "watching the driver. After a little while, he reaches past you to pull the stop cord. \"This is it.\"\n");
		kb.nextLine();
		System.out.println("It's probably the smallest bar you've ever seen. The neon lights are way too bright, and the\n"
				+ "Class Five behind the counter looks like he might have had a few drinks himself. It's not crowded, at\n"
				+ "least, and you and Terrence find an empty booth easily enough. He gets up and stands next to the table\n"
				+ "like a sort of waiter. \"Can I take your order?\" he says in a mock proper accent.\n");
		kb.nextLine();
		do {
			System.out.println("1: Something cheap");
			System.out.println("2: Something expensive");
			System.out.println("3: Nothing");
			System.out.print("What will you say? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2 && response != 3);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			terPoints ++;
			System.out.println("He brings back your order, and you see that he got the same for himself. He sets yours in\n"
					+ "front of you and takes a small sip of his.\n");
		}
		else if(response == 2) {
			System.out.println("Everything on the menu is cheap, but you pick something on the higher end of the price\n"
					+ "scale. When Terrence comes back with your drink, you notice he didn't get anything for himself.\n");
		}
		else {
			terPoints ++;
			System.out.println("\"You sure?\" he asks. When you insist that you have changed your mind, Terrence sits back\n"
					+ "down. He doesn't get anything for himself.\n"
					+ "\"I don't usually drink, either,\" he admits.\n");
			kb.nextLine();
			System.out.println("Then he starts to blush. \"Well, except coffee.\"\n");
		}
		kb.nextLine();
		System.out.println("You sit together for a few minutes. Why not make some conversation?\n");
		do {
			kb.nextLine();
			System.out.println("Ask something.\n");
			System.out.println("1: Are you scared at your job?");
			System.out.println("2: What is your favorite food?");
			System.out.println("3: How is your family?");
			System.out.println("4: What fabulously mysterious things do you do when you're not at work?");
			System.out.println("0: Finished talking");
			System.out.print("What will you say? ");
			response = kb.nextInt();
			kb.nextLine();
			System.out.println();
			if(response == 1) {
				System.out.println("\"Not really.\" He shrugs. \"I mean, it could be worse. At least there's a containment\n"
						+ "cage between us and the monsters, right?\"\n");
			}
			else if(response == 2) {
				System.out.println("Terrence thinks for a moment. \"Berry muffin breakfast food bars,\" he decides. \"The\n"
						+ "extra caffinated ones. You should really try them.\"\n");
			}
			else if(response == 3){
				System.out.println("\"Um, I guess they're okay,\" he shrugs, and glances at the bartender. \"I mean, it's\n"
						+ "really just my aunt and me at this point. And my aunt's a Class Seven, so it's really just me.\"\n");
			}
			else if(response == 4){
				System.out.println("\"Fabulously mysterious?\" He laughs. \"Not much, honestly. I guess I like to walk in the\n"
						+ "afternoon, and the bar's a place to go once in a while.\" He shrugs. \"I like my job, though.\n"
						+ "It's quiet and nobody really bothers me, and working around monsters is really interesting.\"\n");
			}
		} while(response != 0);
		kb.nextLine();
		System.out.println("Eventually, you get tired of talking. You both head out, and you realize how late it is. Terrence,\n"
				+ "being psychically defenseless, produces a can of pepper spray and discretely holds it at the ready. He\n"
				+ "says goodbye and heads for the bus stop.\n");
		kb.nextLine();
		if(terPoints >= 1)
    		points[4]++;
		do {
			System.out.println("1: Go with him.");
			System.out.println("2: Head home. It's pretty late, after all.");
			System.out.print("What will you say? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 2) {
			System.out.println("You head home for the night. Above you, the brightest stars glitter.\n");
            kb.nextLine();
            return;
		}
		kb.nextLine();
		System.out.println("He looks a little surprised, but he slows down so you can catch up. \"Sorry, do you need\n"
				+ "something?\" he asks.\n");
		kb.nextLine();
		do {
			System.out.println("1: Nope, I just wanted to walk with you.");
			System.out.println("2: I'm stalking you.");
			System.out.print("What will you say? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 2) {
			System.out.println("He blinks and looks at you a little nervously. \"What?\"\n");
            kb.nextLine();
    		do {
    			System.out.println("1: Quickly apologize and attempt to ammend the situation.");
    			System.out.println("2: No, I've started this and I have to take it all the way.");
    			System.out.print("What will you do? ");
    			response = kb.nextInt();
    		} while(response != 1 && response != 2);
    		kb.nextLine();
    		System.out.println();
    		if(response == 1) {
    			System.out.println("\"Sorry, bad joke,\" you mumble.\n");
    			kb.nextLine();
    			System.out.println("\"Oh. You sure got me on that one.\" He gives a very nervous, very forced laugh and\n"
    					+ "says goodbye for the second time. You notice he's holding the pepper spray a little tighter.\n");
    			kb.nextLine();
                return;
    		}
    		else {
    			System.out.println("\"I hate Class Eights, especially you, and I am going to make you suffer now.\"\n");
    			kb.nextLine();
    			System.out.println("You see the color drain out of Terrence's face. And you get blasted with\n"
    					+ "approximately one can full of pepper spray.\n");
    			kb.nextLine();
    			System.out.println("If you were a Class Six or Seven, he'd have probably gotten away, but your psychic\n"
    					+ "powers have a pretty good reach.\n");
    			kb.nextLine();
    			System.out.println("You have now killed one janitor.\n");
    			kb.nextLine();
    			System.out.println("1: Loot the body!");
    			System.out.println("2: Get the heck away before someone sees you");
    			System.out.print("What will you do? ");
    			response = kb.nextInt();
    			kb.nextLine();
    			if(response == 1) {
        			System.out.println("In his pocket, you find one bottle of caffine pills and a couple of food bars.\n");
    			    kb.nextLine();
    			}
    			System.out.println("I'm pretty sure you just committed a hate crime against non psychics. Rather than\n"
    					+ "waste my time lecturing you on your awful sense of morality, I will just say that the point\n"
    					+ "of this game was to form friendships, and you have just done the exact opposite of that.\n");
    			kb.nextLine();
    			points[4] = 0;
    			return;
    		}
		}
		System.out.println("You both head down the empty street. Terrence seems a lot quieter now, but it's probably just\n"
				+ "because you're alone outside in the dead of night.\n");
		kb.nextLine();
		System.out.println("Eventually, you get to his apartment and he unlocks the door. \"It's pretty late. We should\n"
				+ "both get some sleep.\"\n");
		kb.nextLine();
		System.out.println("He starts to close the door, but then he pauses. \"Would you mind giving me a quick call when\n"
				+ "you get home, just so I know you made it all right?\" he asks.\n");
		kb.nextLine();
		System.out.println("You trade numbers and then head for home. The brightest stars are visible above you, and all\n"
				+ "seems right with the world.\n");
		points[4] = 4;
		kb.nextLine();
	}
	public static void endTer(Scanner kb, String name) {
		System.out.println();
		System.out.println("\"Hey! Get away from them!\" You and the monster both turn, surprised, and see Terrence. He's\n"
				+ "brandishing a broom and standing next to Misty, who is surrounded by fluttering white butterflies.\n");
		kb.nextLine();
		System.out.println("You have to admit, your rescue party is kind of underwhelming.\n");
		kb.nextLine();
		System.out.println("This opinion, of course, immediately changes once those butterflies swarm the attacking monster,\n"
				+ "latching onto it and freezing it until it howls. The good janitor stares awkwardly at that Misty girl,\n"
				+ "but he turns to you. \"Are you all right, " + name + "?\" he asks.\n");
		kb.nextLine();
		System.out.println("When your answer is affirmative, he grabs you with one hand and Misty with the other, and the three\n"
				+ "of you take off running. He knows his way around, luckily, and soon you are all free.\n");
		kb.nextLine();
		System.out.println("The escape is bittersweet, however. When the portal opens and Misty chirps her goodbye, you wonder\n"
				+ "if you will ever see her again. You wonder where in this vast world she might be.\n");
		kb.nextLine();
		System.out.println("Terrence seems to share your feelings. He turns to you and gives a little half smile, trying to\n"
				+ "lighten the sadness. You return it. Misty may be gone, but at least you still have Terrence.\n");
		kb.nextLine();
		System.out.println("And honestly, you wouldn't have it any other way.\n");
              new JavaSwingImage(256, 300, "TerEnd");
	}
	public static void day1MonsterPath(Scanner kb, int[] points, int[] daysSpent) {
		daysSpent[2]++;
		System.out.println();
		System.out.println("You wander down the halls, noting all the snouts and toothy grins that seem to jump\n"
				+ "out from every wall. The cages that line the hallway are filled with prowling, pacing, and growling\n"
				+ "beasts. Unsettled, you speed up without really knowing it. Suddenly, the ground is rushing towards you.\n");
		kb.nextLine();
		System.out.println("Some impression you're making. Having tripped and fallen flat on your face, you feel less\n"
				+ "embarrased and more scraped up. Scratch that. Somebody's laughing at you. Now you're embarrased.\n");
		kb.nextLine();
		System.out.println("You look up. There's a monster pointing at you. Two, to be precise. Both of them are in cages,\n"
				+ "but it's still unnerving. The one that looks more human sees you dust yourself off and doubles over,\n"
				+ "laughing. \"Prismec!\" the other monster complains, \"You have no manners whatsoever! The poor little\n"
				+ "sweetie could be seriously hurt!\"");
		kb.nextLine();
		System.out.println("This monster puts her hands together and smiles at you. \"I am so sorry about her!\" she\n"
				+ "exclaims. \"You're new here, aren't you? I'll have to introduce myself! I'm Merina, princess of the mer\n"
				+ "people!\" Her voice is bubbly and cheerful.\n");
		kb.nextLine();
		System.out.println("Prismec makes a remark that you're pretty sure is incredibly offensive to all of ocean life, but the fish\n"
				+ "princess prattles on. \"...and of course, Spinner didn't--you know Spinner, don't you? The spider monster?\n"
				+ "Well, Spinner didn't care...\" You're not entirely sure how the conversation got to this point. She finally\n"
				+ "notices how agape your mouth is and pauses for a second. \"Oh goodness! I must be prattling on! You have a\n"
				+ "job to get back to, don't you? Oh wait, your job is to talk to me?\" She giggles. \"I'll carry on, then!\"\n"
				+ "And this is exactly what she does.");
		kb.nextLine();
		points[2]++;
	}
	public static void day2MonsterPath(Scanner kb, int[] points, int[] daysSpent, String name) {
		daysSpent[2]++;
		int response = 0;
		System.out.println();
		System.out.println("The moment you show up, Merina starts chattering away. \"Hi there! How was your walk over here?\n"
				+ "I've been thinking about starfish. Did you know that there are over 400 types of starfish in the tide pools\n"
				+ "alone? That is just fintastic, I think. I once saw one with twenty four arms!\"");
		kb.nextLine();
		System.out.println("\"I love starfish! They have so many uses! You can stew them, wear them in your hair, pretty up\n"
				+ "your dresses...you can even have them as pets! They're really boring, though. One of my sisters once had\n"
				+ "a pet starfish that...\"\n");
		kb.nextLine();
		do {
			System.out.println("1: Keep listening");
			System.out.println("2: Interrupt");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("\"...she trained to shovel sand! She also had four pet sea urchins! My sister did, I mean.\n"
					+ "Not the starfish, of course!\n");
			kb.nextLine();
			System.out.println("\"I have two hundred sisters and one hundred ninety two brothers besides her, though! And one\n"
					+ "of them is here, of all places! Have you met Sirena yet? She looks a lot like me, but I think I have\n"
					+ "prettier hair. Don't tell her, though! She gets so jealous...\"\n");
			kb.nextLine();
			System.out.println("It's interesting to hear all about Merina's extended family. She even has some good stories\n"
					+ "in among the happy chattering. You enjoy the welcome break from your dreary work.\n");
			points[2]++;
		}
		else {
			System.out.println("You cough and try to get a word in. \"Er, that's a great story you're telling, but I really\n"
					+ "have to interview some monsters, Merina,\" you say.\n");
			kb.nextLine();
			System.out.println("\"Oh! Silly me! I completely forgot that you had a job to get back to!\" She giggles.\n"
					+ "\"I once had a job where I sorted sea shells! I know I'm a princess, but-\"\n");
			kb.nextLine();
			System.out.println("\"For the love of all that you can find crawling underneath a sandwich, can you please\n"
					+ "just shut up?!\"\n");
			kb.nextLine();
			System.out.println("It's the other monster who says this. She has her hands pressed over her ears and she looks\n"
					+ "about ready to kill someone. Probably Merina. \"Great Ixhara! I'd think a mer-ditz like you wouldn't have\n"
					+ "enough brainpower to think, let alone speak, but here I am, stuck with the chattiest cell neighbor in\n"
					+ "all the multiverse!\"\n");
			kb.nextLine();
			System.out.println("Merina looks about ready to cry. True, she is a chatterbox, but it's still kind of sad.\n");
			kb.nextLine();
			do {
				System.out.println("1: Comfort the mermaid");
				System.out.println("2: Well, she was pretty annoying");
				System.out.print("What will you do? ");
				response = kb.nextInt();
			} while(response != 1 && response != 2);
			kb.nextLine();
			System.out.println();
			if(response == 1) {
				System.out.println("You flash Prismec a cross look and turn to Merina. \"Just ignore her,\" you advise the mermaid.\n"
						+ "\"I liked your story.\"");
				kb.nextLine();
				System.out.println("\"You do?\" Merina asks, sniffling slightly. She perks up. \"Oh thank goodness! I was afraid I\n"
						+ "was chatting your ear slits off! I just love to talk! One time, I was talking with...\"\n");
				kb.nextLine();
				System.out.println("You cannot help but shrug. This probably counts as an interview, at least. By the time\n"
						+ "you go to lunch, Merina is still chatting away.\n");
				points[2]++;
			}
			else {
				daysSpent[3]++;
				System.out.println("\"Yeesh, at least someone has a brain around here,\" the other monster sneers. She\n"
						+ "turns to you. \"I'm Prismec. You have a name? " + name + ", huh? That's kinda cute. Don't go\n"
						+ "prancin' around thinkin' you're so great, though.\"\n");
				kb.nextLine();
				System.out.println("She tosses her head and in a smooth sweep, her hair turns neon pink. \"You're still here? Whatcha\n"
						+ "waiting for, a kiss?\" She smirks and folds her arms. \"I like you, kay? Now get outta here.\"\n");
				points[3]++;
			}
			kb.nextLine();
		}
	}
	public static void day3MonsterPath(Scanner kb, int[] points, int[] daysSpent) {
		daysSpent[2]++;
		int response = 0;
		int prisPoints = 0;
		int merPoints = 0;
		System.out.println();
		System.out.println("You find your two monstrous acquaintences. \"Heloooooooo!\" Merina squeals happily.\n");
		kb.nextLine();
		if(points[3] >= 1) {
			System.out.println("Prismec rolls her eyes, but the corners of her mouth turn up at you.\n");
			kb.nextLine();
		}
		System.out.println("\"...and I can't believe it, but Shelldon, he's my brother, asked me to be the codmother of his\n"
				+ "second child! Me, of all mer people!\"");
		kb.nextLine();
		System.out.println("...Of course, Merina's talking again.");
		kb.nextLine();
		do {
			System.out.println("1: Well, I want to hear this");
			System.out.println("2: Quietly comment to Prismec");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("\"...so he asked me to pick out an outfit for the baby! But I just couldn't decide between\n"
					+ "the red sea silk or the green!\"\n");
			kb.nextLine();
			System.out.println("She pauses suddenly and looks at you. \"Which one do you like better?\"\n");
			kb.nextLine();
			System.out.println("She's...she's actually waiting for you to speak.");
			kb.nextLine();
			do {
				System.out.println("1: Red");
				System.out.println("2: Green");
				System.out.print("What will you say? ");
				response = kb.nextInt();
			} while(response != 1 && response != 2);
			kb.nextLine();
			System.out.println();
			if(response == 1) {
				System.out.println("\"Oooooooh, lovely! I once saw a red sea anemome, you know? It had red swirls and red...\"");
			}
			else {
				System.out.println("\"I like that, too! It reminds me of kelp! Kelp has so many uses, like...\"\n");
			}
			kb.nextLine();
			System.out.println("Hours later:\n");
			kb.nextLine();
			System.out.println("\"...Well, anyway, I can't wait to see the baby!\" She smiles happily and folds her hands.\n"
					+ "\"Well, I'm all storied out for today.\" She plops down with a squelching sound.");
			kb.nextLine();
			System.out.println("You've almost forgotten the concept of silence. It's fairly alarming.\n");
			kb.nextLine();
			System.out.println("Maybe you should tell her a story.\n");
			kb.nextLine();
			System.out.println("What type of story is this?\n");
			do {
				System.out.println("1: Science fiction");
				System.out.println("2: Fantasy");
				System.out.println("3: A lecture");
				System.out.print("What will you say? ");
				response = kb.nextInt();
			} while(response != 1 && response != 2 && response != 3);
			kb.nextLine();
			System.out.println();
			if(response == 2) {
				merPoints ++;
			}
			System.out.println("What's the setting?\n");
			do {
				System.out.println("1: An undersea kingdom");
				System.out.println("2: A palace in the sky");
				System.out.println("3: Antarctica");
				System.out.print("What will you say? ");
				response = kb.nextInt();
			} while(response != 1 && response != 2 && response != 3);
			kb.nextLine();
			System.out.println();
			if(response == 1) {
				merPoints ++;
			}
			System.out.println("Who is the main character?\n");
			do {
				System.out.println("1: A plucky young sea turtle");
				System.out.println("2: A spirited finch");
				System.out.println("3: A farmer");
				System.out.print("What will you say? ");
				response = kb.nextInt();
			} while(response != 1 && response != 2 && response != 3);
			kb.nextLine();
			System.out.println();
			if(response == 1) {
				merPoints ++;
			}
			System.out.println("Merina is entranced by your story. The moment you finish, the only thing breaking the silence\n"
					+ "is the sound of wet, squelching applause.\n");
		}
		else {
			daysSpent[3]++;
			System.out.println("Very quietly, you whisper to the monster next to you. \"She really talks a lot,\" you admit.\n"
					+ "Prismec slams her fist into her face.\n");
			kb.nextLine();
			System.out.println("\"Hey Mer-ditz! The human over here wants you to shut your big fat fish mouth!\" she yells.\n");
			kb.nextLine();
			System.out.println("Merina looks at you with wide, glassy eyes and then bursts into tears.\n");
			kb.nextLine();
			System.out.println("\"Just shut it, won't you?!\" Prismec covers her ears for a moment and then remembers you.\n"
					+ "\"As you can see, I live in a mad house with the idiot queen. Interview me.\"\n");
			kb.nextLine();
			System.out.println("Well, it is your job.\n");

			kb.nextLine();
			System.out.println("Question 1\n");

			kb.nextLine();
			System.out.println("\"What kind of a monster are you, anyway?\" you ask.\n");
			kb.nextLine();
			System.out.println("Prismec flips her hair and it, along with the rest of her body, turns into bronze scales.\n"
					+ "\"A shapeshifter, can't you tell?\" she grins. \"Any other questions?\"\n");
			kb.nextLine();
			System.out.println("Actually, yes.\n");
			kb.nextLine();
			System.out.println("Question 2\n");
			do {
				System.out.println("1: What do you do for fun?");
				System.out.println("2: What is your favorite food?");
				System.out.println("3: What is the scientific name of your species?");
				System.out.print("What will you say? ");
				response = kb.nextInt();
			} while(response != 1 && response != 2 && response != 3);
			kb.nextLine();
			System.out.println();
			if(response == 1) {
				System.out.println("She kicks back against the wall. \"I mess with people.\"\n");
				prisPoints ++;
			}
			else {
				System.out.println("\"I dunno. Stuff.\" She rolls her eyes. \"Are all your questions this boring?\"\n");
			}
			kb.nextLine();
			System.out.println("Question 3\n");
			do {
				System.out.println("1: Do you ever go on the internet?");
				System.out.println("2: Are you friends with any of the monsters here?");
				System.out.println("3: What is 9 plus 10?");
				System.out.print("What will you say? ");
				response = kb.nextInt();
			} while(response != 1 && response != 2 && response != 3);
			kb.nextLine();
			System.out.println();
			if(response == 1) {
				System.out.println("\"Like heck, yes. If you ever come across anything written by LOLiHax, do me a favor and\n"
						+ "give it a like, will ya?\"\n");
				prisPoints++;
			}
			else if (response == 2) {
				System.out.println("\"Like Merina? No,\" she scoffs and folds her arms. \"Eh, I guess her sis, Sirena, isn't\n"
						+ "that bad, though. And I don't mind hanging with Spinner, even though his memes suck.\"\n");
				kb.nextLine();
				System.out.println("Huh, that's odd. Both of those monsters live at just about the other end of this complex.\n"
						+ "You can see how gossip gets around, but hanging out is a little different. Maybe it was just bad\n"
						+ "word choice on her part.\n");
				prisPoints++;
			}
			else {
				System.out.println("She blinks. \"Is this some kind of joke? Because that meme died before your grandmom was born.\"\n");
			}
			kb.nextLine();
			System.out.println("Question 4\n");
			do {
				System.out.println("1: Do you eat people?");
				System.out.println("2: You mentioned Great Ixhara. Who is that?");
				System.out.println("3: Will you kiss me (Y is this only a friendship sim)?");
				System.out.print("What will you say? ");
				response = kb.nextInt();
			} while(response != 1 && response != 2 && response != 3);
			kb.nextLine();
			System.out.println();
			if(response == 1) {
				System.out.println("\"Um, no. I prefer transforming into a pidgeon and defecating on their heads. I can\n"
						+ "always make an exception for you, though.\"\n");
				kb.nextLine();
				System.out.println("She smiles. You honestly can't tell if she's joking or being serious.\n");
				prisPoints ++;
			}
			else if(response == 2) {
				System.out.println("\"A giant ball of light that'll melt your face off if you look at it. Is there a better\n"
						+ "deity in the multiverse?\"\n");
				prisPoints ++;
			}
			else {
				System.out.println("\"You get right to the point, doncha?\" She laughs. \"You'll have to work a little\n"
						+ "harder for that one, kiddo. Try aiming for the friend zone.\"\n");
			}
			kb.nextLine();
			System.out.println("That seems like enough questioning for today.\n");
		}
		kb.nextLine();
		if(merPoints >= 2)
			points[2]++;
		else if(prisPoints >= 2)
			points[3]++;
	}
	public static void day4MerPath(Scanner kb, int[] points, int[] daysSpent) {
		daysSpent[2]++;
		System.out.println();
		System.out.println("\"I have a new gaaaaaaaaaame!\"\n");
		kb.nextLine();
		System.out.println("Here you find yourself, interviewing Merina again.\n");
		kb.nextLine();
		System.out.println("Honestly, at this point, you aren't even interviewing monsters anymore. You're just listening\n"
				+ "to her talk on and on and on and on.\n");
		kb.nextLine();
		System.out.println("This friendship thing is getting weird.\n");
		kb.nextLine();
		System.out.println("Merina grins on, oblivious to whatever you may or may not be thinking. \"Let's plaaaaay!\"\n");
		kb.nextLine();
		System.out.println();
		System.out.print("I need you to give me a noun: ");
		String noun = kb.nextLine();
		kb.nextLine();
		System.out.print("Now an adjective: ");
		String adj = kb.nextLine();
		kb.nextLine();
		System.out.print("And a verb: ");
		String verb = kb.nextLine();
		
		System.out.println();
		System.out.println("She giggles. \"Here's the story!\"\n");
		kb.nextLine()
		;System.out.println("\"Once upon a time, there was a " + adj + " trout who loved to swim. It decided that it was going\n"
				+ "to enter a swimming contest! It packed its favorite " + noun + " and went to the stadium. There were\n"
				+ "a lot of other fish there! But our hero could " + verb + " faster than all of them, and it won! Yay!\"\n");
		kb.nextLine();
		System.out.println("...\n");
		kb.nextLine();
		System.out.println("...\n");
		kb.nextLine();
		System.out.println("I rate this story 10 out of 10.\n");
		kb.nextLine();
		points[2]++;
	}
	public static void day5MerPath(Scanner kb, int[] points) {
		System.out.println();
		System.out.println("Merina is so great. You love hearing her talk and you wish you could hear her even more.\n");
		kb.nextLine();
		System.out.println("You dream about it every night.\n");
		kb.nextLine();
		System.out.println("You have even made a mixtape of her lecture on kelp.\n");
		kb.nextLine();
		System.out.println("Kelp is green. K-k-kelp is green.\n");
		kb.nextLine();
		System.out.println("I hope that you get more sleep than I do.\n");
		kb.nextLine();
		points[2] ++;
	}
	public static void endMer(Scanner kb) {
		int response = 0;
		System.out.println();
		System.out.println("\"Helooooooooooo-eeeek!\" Merina gasps, calling to you from the other end of the room.\n");
		kb.nextLine();
		System.out.println("The monster turns to her and growls. She shrieks, and you cover your ears against the sound.\n");
		kb.nextLine();
		System.out.println("And then the whole place is flooded with water.\n");
		kb.nextLine();
		System.out.println("\"Daddyyyyyyyyyyy!\"\n");
		kb.nextLine();
		System.out.println("And there he is, the sea king himself. This rescue party sure is something.\n");
		kb.nextLine();
		System.out.println("The sea king makes a squeaking sound like a dolphin. Merina and her several hundred siblings\n"
				+ "shoal around him.\n");
		kb.nextLine();
		System.out.println("\"Thou hath saveth my daughter!\" the sea king yells. You didn't actually save her, but okay.\n"
				+ "\"You may now choose to stay on the land or live under the sea!\"\n");
		kb.nextLine();
		do {
			System.out.println("1: I want to sea this");
			System.out.println("2: Land 4 life");
			System.out.print("What will you say? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("\"If you are to live among us, you must have a tail!\" the sea king bawls. You clap slowly.\n");
			kb.nextLine();
			System.out.println("He slaps you in the face with a magic piece of kelp. Light envelops your body. You look down and\n"
					+ "yes, you are now the owner of a large, bushy squirrel tail. All of your dreams have come true. All of them.\n");
			kb.nextLine();
			System.out.println("You enjoy your new life as a magical mer-squirrel. You make lots of friends and on Merina's\n"
					+ "birthday, you get her a wall. She loves it and talks to it every day.\n");
                         new JavaSwingImage(256, 300, "MerEnd");
		}
		else {
			System.out.println("\"Then goodbye!\" Merina blows you a quick, fishy kiss as she and her father disappear under the\n"
					+ "churning waves.\n");
			kb.nextLine();
			System.out.println("The sea king summons an angel whale to fly you back to the surface. It has anime eyes and its\n"
					+ "whole body is bright pink. You have decided that you want to name it Frederick, in honor of nothing.\n");
			kb.nextLine();
			System.out.println("The joy.\n");
		}
	}
	public static void day4PrisPath(Scanner kb, int[] points, int[] daysSpent, String name) {
		daysSpent[3]++;
		System.out.println();
		System.out.println("\"Hey. Hey, person. " + name + ", I'm talking to you. Come'ere.\" Prismec is calling you over.\n");
		kb.nextLine();
		System.out.println("\"I heard about this really old and awful game the other day,\" she says. \"I need someone\n"
				+ "to play it with me so I can see how stupid it is.\"\n");
		kb.nextLine();
		boolean guessed = false;
		int guess;
		int count = 0;
		try {
    		System.out.print("\"Pick an upper bound number or something.\"\nUpper bound: ");
	    	int upperBound = kb.nextInt();
	    	if(upperBound <= 100) {
    			System.out.println("\nNot so very quietly, Prismec whispers, \"Lightweight.\"\n");
    			kb.nextLine();
	    	}
			System.out.println("\"Great. I'm thinking of a number between 0 and " + upperBound + ".\"\n");
			kb.nextLine();
		    int target = (int)(Math.random()*upperBound);
    		System.out.print("Guess it: ");
	    	guess = kb.nextInt();
		
	    	while(!guessed) {
		    	count += 1;
			    if(Math.abs(guess - target) < 0.001) {
	    			guessed = true;
		    		break;
		    	}
	    		else if (guess > target)
	    			System.out.println("Too high.");
	    		else
		    		System.out.println("Too low.");
			    System.out.print("Guess it: ");
			    guess = kb.nextInt();
		    }
		    System.out.println("\"Yep! It only took you a full " + count + " guesses.\"\n");
		}
		catch (InputMismatchException e) {
			System.out.println("Numbers only.");
		}
		kb.nextLine();
		System.out.println("Prismec shrugs. \"Meh, I'd give it a 2 outta 10. Let's say we never play this again?\"\n");
		kb.nextLine();
		System.out.println("The two of you proceed to spend the next hour guessing numbers. It's ironic and hilarious.\n");
		kb.nextLine();
		points[3]++;
	}
	public static void day5PrisPath(Scanner kb, int[] points) {
		int response = 0;
		System.out.println();
		System.out.println("Ah, there's your shapeshifting friend. Merina's pen is open, and you recall hearing that she\n"
				+ "was going to get tested today. It looks like it's just you and Prismec today.\n");
		kb.nextLine();
		System.out.println("\"Why did the flower put on glasses?\"\n");
		kb.nextLine();
		System.out.println("You ask why.\n");
		kb.nextLine();
		System.out.println("\"It wanted to seed the world.\"\n");
		kb.nextLine();
		System.out.println("You and Prismec both decide that top quality jokes are unfortunately a rare breed these days.\n");
		kb.nextLine();
		System.out.println("She stretches for a moment, and suddenly, she looks unsure of herself.\n");
		kb.nextLine();
		System.out.println("\"Look, I know this is gonna sound stupid, but we're really trying to make this friendship\n"
				+ "thing work, right?\"\n");
		kb.nextLine();
		System.out.println("You nod. Friendship is the point of the game, right?\n");
		kb.nextLine();
		System.out.println("\"Good.\"\n");
		kb.nextLine();
		System.out.println("\"Tbh, I was getting kinda worked up about this.\" Her outline flickers, and suddenly she's a\n"
				+ "perfect copy of you. \"Tell me honestly, though, can I trust you?\"\n");
		kb.nextLine();
		do {
			System.out.println("1: Yes");
			System.out.println("2: No");
			System.out.print("What will you say? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 2) {
    		System.out.println("\"Wow. K then.\" That's all she says.\n");
    		kb.nextLine();
    		System.out.println("Brutal honesty might not be the greatest strategy the next time around.\n");
    		kb.nextLine();
    		return;
		}
		System.out.println("\"And I'm supposed to take your word for it,\" she snorts. \"Whatevs. I can kill you\n"
				+ "in about two secs if you tell on me.\"\n");
		kb.nextLine();
		System.out.println("You're pretty sure she isn't joking about this.\n");
		kb.nextLine();
		System.out.println("\"Okay. I need to tell you something.\"\n");
		kb.nextLine();
		System.out.println("She takes a deep breath.\n");
		kb.nextLine();
		System.out.println("\"Is it that you actually aren't as cool as you try to be, and this is all a facade that masks\n"
				+ "the deep feelings of insecurity that haunt the darkest parts of your mind and bring up memories of\n"
				+ "your tragic and unrevealed backstory?\"\n");
		kb.nextLine();
		System.out.println("Prismec blinks at you. \"Um, that was philosophical, but no,\" she says.\n");
		kb.nextLine();
		System.out.println("\"I was just gonna say that I can get out of my cage, and I was wondering if you'd like to\n"
				+ "hang out some time, irl.\"\n");
		kb.nextLine();
		System.out.println("Huh. There goes your theory.\n");
		kb.nextLine();
		System.out.println("Prismec shape shifts into a flea and squeezes through a tiny, almost invisible crack in the side\n"
				+ "of the wall. There's a small pop, and then a violet-haired girl is at your side. Her outfit has changed\n"
				+ "from jeans and a tank top to a T-shirt and skirt. \"I just wasn't feeling that look anymore,\" she shrugs.\n");
		kb.nextLine();
		System.out.println("She leans against the wall. \"So, I'm bored. What now?\"\n");
		kb.nextLine();
		do {
			System.out.println("1: Let us engage in an activity together. One that is hip for the kids, like pranking.");
			System.out.println("2: How the hay did you figure out how to get out and why have you not run away by now?");
			System.out.print("What will you say? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 2) {
			System.out.println("\"Um, this have you ever tried containing a shape shifter? I figured this out, like, two\n"
					+ "days after coming here.\" She picks at her nail. \"It's free rent, even if Merina sucks.\"\n");
			kb.nextLine();
			System.out.println("She shrugs. \"I'm bored. Let's go prank someone.\"\n");
		}
		else {
		    System.out.println("\"I like your style.\"\n");
		}
		kb.nextLine();
		System.out.println("Prismec creeps down the hall. She turns back to make sure you're following, and her clothes\n"
				+ "melt into those of a Class Six. She grins.\n");
		kb.nextLine();
		System.out.println("The hall branches just up ahead. Prismec produces a spool of thread and hands you one end of\n"
				+ "it. \"Tape it to the wall on your side,\" she instructs you, measuring about a foot above the ground.\n"
				+ "You construct the tripwire and hide off to the side with the monster girl.\n");
		kb.nextLine();
		System.out.println("Someone's coming.\n");
		kb.nextLine();
		System.out.println("Heart pounding in anticipation, you peek out to see who it is, and oh gosh, it's a Class Four\n"
				+ "researcher. Her arms are laden with a small cage, in which rests a fuzzy monster.\n");
		kb.nextLine();
		do {
			System.out.println("1: Divert her path so she doesn't trip");
			System.out.println("2: Watch the magic happen");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("\"Hi! Excuse me, but I think someone was looking for...\" You glare at Prismec and she\n"
					+ "rolls her eyes but disables the trap. The Class Four looks at you, a little confused, and waits\n"
					+ "for you to continue.\n");
			kb.nextLine();
			System.out.println("\"Never mind.\"\n");
			kb.nextLine();
			System.out.println("The Class Four gives you a funny look, but seems to realize you meant no harm. After a\n"
					+ "quick little shrug, she adjusts her burden and continues on her way.\n");
			kb.nextLine();
			System.out.println("To your surprise, Prismec doesn't tease you about this.\n");
		}
		else {
			System.out.println("The Class Four is completely oblivious to the trap. She walks right into it, and the crash\n"
					+ "is glorious.\n");
			kb.nextLine();
			System.out.println("The fuzzy monster squeaks furiously and scampers free. While you wonder if you've just\n"
					+ "become the start of a massive breakout, Prismec siezes your arm and pulls you out of there. You\n"
					+ "run until you're out of breath.\n");
			kb.nextLine();
			System.out.println("\"Look, no worries. It was just a phase mole. Harmless even to squishy lil humans,\"\n"
					+ "Prismec assures you.\n");
		}
		kb.nextLine();
		System.out.println("It's fairly quiet now.\n");
		kb.nextLine();
		System.out.println("Prismec plops down on the floor and pats the space next to her. You sit down.\n");
		kb.nextLine();
		System.out.println("She crosses her legs and stretches, and then uncrosses them. \"You tired?\" she asks.\n");
		kb.nextLine();
		do {
			System.out.println("1: Yeah");
			System.out.println("2: Nope");
			System.out.print("What will you say? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("\"Same here.\" She glances over at you and shakes her head, giving you a half smile. \"And\n"
					+ "still bored. Great life, isn't it?\"\n");
		}
		else {
			System.out.println("\"Lucky you, then.\" She yawns. \"Guess I'm the lightweight now.\"\n");
		}
		kb.nextLine();
		System.out.println("She scooches a little closer to you and folds her arms behind her back. \"Wanna talk about,\n"
				+ "I dunno, life and stuff?\"\n");
		kb.nextLine();
		System.out.println("That's a topic that never runs dry.\n");
		kb.nextLine();
		System.out.println("\"I guess you kinda already interviewed me, though. Must be a fun job, talking with folks all\n"
				+ "day. 'slong as the folks are interesting.\"\n");
		kb.nextLine();
		System.out.println("True.\n");
		kb.nextLine();
		System.out.println("\"I guess if I were to have a job, I'd rather have one that lets me go places. There's a big\n"
				+ "world out there. It's a cool place to see.\"\n");
		kb.nextLine();
		System.out.println("Honestly, you haven't given much thought to traveling the world. With all the monsters,\n"
				+ "it doesn't strike you as the safest thought.\n");
		kb.nextLine();
		System.out.println("\"Eh, it's actually way less romantic than it sounds. I mean, it looks all cool, and at first\n"
				+ "everything's different and new, but after a while, it gets kind of repetative. Traveling the world!\" she\n"
				+ "says in a dramatic voice. \"Seeing the sights! Getting sore feet!\" She starts to laugh.\n");
		kb.nextLine();
		System.out.println("Okay.\n");
		kb.nextLine();
		System.out.println("Prismec turns away. She's starting to look tired. \"I dunno, maybe the problem's with me,\"\n"
				+ "she shrugs.\n");
		kb.nextLine();
		System.out.println("\"Maybe I do have confidence issues.\"\n");
		kb.nextLine();
		do {
			System.out.println("1: Girl, you are 100 percent uncool. All your insecurities are real.");
			System.out.println("2: Well, for the record, I think you're cool.");
			System.out.print("What will you say? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("She laughs. \"You sure know how to make someone feel better. 10 out of 10 for social\n"
					+ "skills,\" she rolls her eyes.\n");
		}
		else {
			System.out.println("She mutters something about \"stupid sentimental humans.\" The look on her face doesn't\n"
					+ "match her words, though.\n");
			kb.nextLine();
			System.out.println("She takes your hand and squeezes it lightly. \"Thanks. Really.\"\n");
		}
		kb.nextLine();
		System.out.println("Prismec is looking really tired. She morphs into a cat and crawls onto your lap.\n");
		kb.nextLine();
		do {
			System.out.println("1: Pet her");
			System.out.println("2: Let the cat be");
			System.out.print("What will you do? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.println("You stroke her gently. She rolls over and purrs. \"Ah, that's the spot.\"");
		kb.nextLine();
		}
		System.out.println("Prismec looks up at you and gives you half a smile. \"Why did the chicken cross the road?\"\n");
		kb.nextLine();
		System.out.println("You ask why.\n");
		kb.nextLine();
		System.out.println("\"To get to the idiot's house.\" She shifts to get a little more comfortable. \"Knock knock.\"\n");
		kb.nextLine();
		System.out.println("You ask for the identity of who is there.\n");
		kb.nextLine();
		System.out.println("\"The chicken.\"\n");
		kb.nextLine();
		System.out.println("I'd rate that at least a 7 out of 10.\n");
		kb.nextLine();
		System.out.println("Eventually, you realize you've been sitting there for a while. It probably wouldn't be the\n"
				+ "easiest thing to explain if someone were to walk by and see you. You nudge Prismec, and she gets up\n"
				+ "reluctantly. \"We'll have to do this again sometime,\" she says. \"See who can come up with the worst\n"
				+ "joke.\"\n");
		kb.nextLine();
		System.out.println("You walk away with a little extra spring in your step.\n");
		kb.nextLine();
		points[3]++;
	}
	public static void endPris(Scanner kb) {
		System.out.println();
		System.out.println("\"Hey, dirtbag! That's MY human, you know?\"\n");
		kb.nextLine();
		System.out.println("At the other side of the room, a larger canine monster is growling. Your attacker's ears go down\n"
				+ "and it backs away. Now it's just you and the bigger beast.\n");
		kb.nextLine();
		System.out.println("You're out of the frying pan and into the fire, as the older folks say.\n");
		kb.nextLine();
		System.out.println("\"Oh, quit cowering and get up. What are you, an idiot?\"\n");
		kb.nextLine();
		System.out.println("The beast shudders and melts into the form of a girl with short, pink hair. It is Prismec, the\n"
				+ "one and only.\n");
		kb.nextLine();
		System.out.println("\"Remind me why I'm stopping to save you?\"\n");
		kb.nextLine();
		System.out.println("Remind yourself why you became friends with her.\n");
		kb.nextLine();
		System.out.println("Anyway, Prismec rolls her eyes and grins at you. \"Well, well. It looks like SOME damsel's\n"
				+ "in distress. You're lucky I happened to be in town, kiddo. Now come on, let's get outta this mess.\"\n");
		kb.nextLine();
		System.out.println("She turns into one heck of a mare and tosses her chesnut mane. \"Do you ride? No? First\n"
				+ "time for everything, then,\" she snorts.\n");
		kb.nextLine();
		System.out.println("You climb on, and Prismec more or less charges up a hundred flights of stairs. Daylight is streaming\n"
				+ "through some of the wider cracks in the ceiling, and you're beginning to wonder if Prismec has any idea what\n"
				+ "she's going to do when she gets to the surface. \"I'm winging this, kid,\" she says.\n");
		kb.nextLine();
		System.out.println("As you burst through the final floor, electric blue wings erupt from Prismec's equine back\n"
				+ "and she shoots into the sky. Cries, stares, and quite a few bullets follow you up for a few seconds,\n"
				+ "and then you are free.\n");
		kb.nextLine();
		System.out.println("You have to admit, this is quite a ride.\n");
                new JavaSwingImage(256, 300, "PrisEnd");
	}
	public static void startBlinkPath(Scanner kb) {
		int response = 0;
		int points = 0;
		System.out.println();
		System.out.println("A shadow falls across the ground, and the attacking monster suddenly seems a lot less threatening.\n"
				+ "It whimpers softly and slinks away. You, however, are not quite as fast.\n");
		kb.nextLine();
		System.out.println("An invisible hand siezes you around the middle and lifts you into the air. There's a gray disk\n"
				+ "floating in front of you. Not a disk, but a face. It has three small indentations that you take to be eyes\n"
				+ "and no distinct features besides them. It regards you with what seems to be boredom and then sets you down.\n"
				+ "\"No, I suppose I won't kill you just yet,\" it sighs.\n");
		kb.nextLine();
		System.out.println("That's reassuring.");
		kb.nextLine();
		System.out.println("\"I am going to get straight to business, so do not waste my time,\" it says. \"I am Blink, I can\n"
				+ "move and see through six dimensions simultaneously, and yes, I am the one responsible for setting all these\n"
				+ "monsters free. Now, can we get this interview started?\"\n");
		kb.nextLine();
		do {
			System.out.println("1: Yes");
			System.out.println("2: What is going on?");
			System.out.print("What will you say? ");
			response = kb.nextInt();
		} while(response != 1 && response != 2);
		kb.nextLine();
		System.out.println();
		if(response == 2) {
			System.out.println("It sighs. \"I am a researcher. I study the habits and behaviors of lower diimensional creatures\n"
					+ "such as yourself. It would please me very much if we could get this over with quickly so the both of us can\n"
					+ "return home.\"\n");
			kb.nextLine();
			do {
				System.out.println("1: Okay");
				System.out.println("2: No way");
				System.out.print("What will you say? ");
				response = kb.nextInt();
			} while(response != 1 && response != 2);
			kb.nextLine();
			System.out.println();
			if(response == 2) {
				System.out.println("Blink flickers and you feel a slight pressure on your neck. A moment later, it\n"
						+ "floats down the hall, leaving your lifeless body on the cold, empty floor.\n");
				kb.nextLine();
				return;
			}
		}
		System.out.println("Well, this is certainly strange.");
		kb.nextLine();
		System.out.println("\"Good. Now, I am attempting to assess the intelligence of humans. Unfortunately, due to the\n"
				+ "internet having all of the answers, this instead will be a quiz about what routes of the House Of Monsters\n"
				+ "game you have completed. Please complete all routes and then answer the following\n"
				+ "questions to the best of your ability. Question one: What color can Misty's butterflies turn?\"\n");
		kb.nextLine();
		System.out.println("1: Red");
		System.out.println("2: Blue");
		System.out.println("3: Green");
		System.out.println("4: Yellow");
		System.out.print("What will you say? ");
		response = kb.nextInt();
		kb.nextLine();
		System.out.println();
		if(response == 2) {
			System.out.print("Correct. ");
			points ++;
		}
		kb.nextLine();
		System.out.println("\"Question two: Who is the only character you can actually kiss?\n");
		kb.nextLine();
		System.out.println("1: Spinner");
		System.out.println("2: Misty");
		System.out.println("3: Prismec");
		System.out.println("4: Terrence");
		System.out.print("What will you say? ");
		response = kb.nextInt();
		kb.nextLine();
		System.out.println();
		if(response == 1) {
			System.out.print("Correct. ");
			points ++;
		}
		kb.nextLine();
		System.out.println("\"Question three: What is Terrence addicted to?\n");
		kb.nextLine();
		System.out.println("1: Alcohol");
		System.out.println("2: Coffee");
		System.out.println("3: Sugar");
		System.out.println("4: Sleeping pills");
		System.out.print("What will you say? ");
		response = kb.nextInt();
		kb.nextLine();
		System.out.println();
		if(response == 2) {
			System.out.print("Correct. ");
			points ++;
		}
		kb.nextLine();
		System.out.println("\"Question four: What is Prismec's online name?\n");
		kb.nextLine();
		System.out.println("1: SugarSweet722");
		System.out.println("2: Prismec123");
		System.out.println("3: Prosmec");
		System.out.println("4: LOLiHax");
		System.out.print("What will you say? ");
		response = kb.nextInt();
		kb.nextLine();
		System.out.println();
		if(response == 4) {
			System.out.print("Correct. ");
			points ++;
		}
		kb.nextLine();
		System.out.println("\"Question five: About how many siblings does Merina have?\n");
		kb.nextLine();
		System.out.println("1: 0");
		System.out.println("2: 3");
		System.out.println("3: about 400");
		System.out.println("4: about 1000");
		System.out.print("What will you say? ");
		response = kb.nextInt();
		kb.nextLine();
		System.out.println();
		if(response == 3) {
			System.out.print("Correct. ");
			points ++;
		}
		kb.nextLine();
		System.out.println("\"Now, this isn't an official question, but would you mind telling the creator of this\n"
				+ "game what you honestly think of it? She really appreciates you playing it, and you can rant about it\n"
				+ "either to her face, or in this convenient blank spot right here.\"");
		kb.nextLine();
		System.out.print("Blink mutters quietly to itself. \"Your score was " + points +" out of 5. ");
		kb.nextLine();
		if(points != 5) {
			System.out.println("Unfortunately, that is not satisfactory.\"\n");
			kb.nextLine();
			System.out.println("Psionically, it picks you up and tosses you around for a few minutes before thwacking you\n"
					+ "against the wall. Then it floats off in search of a more interesting target.\n");
			return;
		}
		System.out.println("You have scored remarkably well,\" it decides.\n");
		kb.nextLine();
		System.out.println("\"I must return to my studies. It is a shame that we do not have more time to discuss things.\"\n");
		kb.nextLine();
		System.out.println("It looks up. \"Perhaps I cannot speak with this iteration of you, but as a being of six\n"
				+ "dimensions, if a different version of you were to return on, let us say, day one and instead of selecting\n"
				+ "1 or 2 from the choices of monsters to visit, instead type 443, perhaps we can continue this.\"\n");
		kb.nextLine();
		System.out.println("\"I must say goodbye, but I am genuinely glad I met you.\"\n");
	}
	public static void day1BlinkPath(Scanner kb) {
		System.out.println();
		System.out.println("\"Blink.\"\n");
		kb.nextLine();
		System.out.println("You've never heard that name before, but it seems so familiar.\n");
		kb.nextLine();
		System.out.println("Perhaps in another life, in another timeline, weaving and stretching across probability space in infinite serenity.\n");
		kb.nextLine();
		System.out.println("Until its time has come to be cut and ended forever.\n");
		kb.nextLine();
		System.out.println("The shadows darken.\n");
		kb.nextLine();
		System.out.println("The air grows still.\n");
		kb.nextLine();
		System.out.println("The air grows colder.\n");
		kb.nextLine();
		System.out.println("Your heartbeat quickens.\n");
		kb.nextLine();
		System.out.println("\"Hello there, human.\"\n");
		kb.nextLine();
		System.out.println("Eeeeeeeh it's Blink.\n");
		kb.nextLine();
		System.out.println("Blink makes some coffee and a chair appear. It watches you drink.\n");
		kb.nextLine();
		System.out.println("This is awkward. This whole game is awkward.\n");
		kb.nextLine();
		System.out.println("It is so awkward that Blink erases the entire worldline from probablilty space, just to forget\n"
				+ "that it ever engaged in such an awkward activity. Then it heads off to an alternate timeline, where\n"
				+ "it is repeatedly insulted by the janitor.\n");
		kb.nextLine();
		System.out.println("\"Sorry.\"\n");
		kb.nextLine();
		System.exit(0);
	}
	public static void endBad(Scanner kb) {
		System.out.println("And you die.");
                new JavaSwingImage(256, 300, "Death");
	}
	public static void printPoints(int[] points) {
		System.out.println();
		System.out.println("End of the day");
		System.out.printf("%-12s" + points[0] + "\n", "Spinner: ");
		System.out.printf("%-12s" + points[1] + "\n", "Misty: ");
		System.out.printf("%-12s" + points[2] + "\n", "Merina: ");
		System.out.printf("%-12s" + points[3] + "\n", "Prismec: ");
		System.out.print("Press Enter to continue. ");
	}
}
