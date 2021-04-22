package hom;
/*
 * Hello universe. This game was created by Elizabeth Gonzalez.
 * She tried.
 */

import java.util.InputMismatchException;

public class Text {
	private static boolean waiting = true;
	public static void stopWaiting() {
		waiting = false;
	}
	public static void waitForInput() throws InterruptedException {
		while (waiting) {
			try {
				Thread.sleep(500);
			}
			catch (InterruptedException e) {}
		}
		waiting = true;
	}
	public static void main(String[] args) {
		try {
			Visuals g = new Visuals();

			//               S  M  I  P  T
			int [] points = {0, 0, 0, 0, 0};
			int [] daysSpent = new int[4];

			intro(g);
			g.getGP().addText("\n\nEnter your name: ");
			waitForInput();
			String name = g.getGP().getResponse();
			g.getGP().addText(name);
			day1(g, points, daysSpent);
			day2(g, points, daysSpent, name);
			day3(g, points, daysSpent, name);
			day4(g, points, daysSpent, name);
			day5(g, points, daysSpent, name);
			day6(g, points, daysSpent, name);
			g.getGP().addText("\n\nThe end.\n\nExit to close the game.");
			waitForInput();
		}
		catch(InterruptedException e) {}
	}
	public static void day1(Visuals g, int[] points, int[] daysSpent) {
		String response = day1Intro(g);
		if (response.equals("1")) {
			response = day1HelpPath(g);

			if(response.equals("1"))
				day1SpinPath(g, points, daysSpent);
			else
				day1MisPath(g, points, daysSpent);
		}
		else if (response.equals("443"))
			day1BlinkPath(g);
		else
			day1MonsterPath(g, points, daysSpent);
		printPoints(g, points);
	}
	public static void day2(Visuals g, int[] points, int[] daysSpent, String name) {
		day2Intro(g, points);
		String response = getResponse(g, points, daysSpent);
		choosePath(response, g, points, daysSpent, name);
		printPoints(g, points);
	}
	public static void day3(Visuals g, int[] points, int[] daysSpent, String name) {
		day3Intro(g, points);
		String response = getResponse(g, points, daysSpent);
		choosePath(response, g, points, daysSpent, name);
		printPoints(g, points);
	}
	public static void day4(Visuals g, int[] points, int[] daysSpent, String name) {
		day4Intro(g, points);
		String response = getResponse(g, points, daysSpent);
		choosePath(response, g, points, daysSpent, name);
		printPoints(g, points);
	}
	public static void day5(Visuals g, int[] points, int[] daysSpent, String name) {
		day5Intro(g, points);
		String response = getResponse(g, points, daysSpent);
		choosePath(response, g, points, daysSpent, name);
		printPoints(g, points);
	}
	public static void day6(Visuals g, int[] points, int[] daysSpent, String name) {
		day6Intro(g);
		if(points[0] == 1 && points[1] == 1 && points[2] == 1 && points[3] == 1)
			startBlinkPath(g);
		else if (points[0] >= 3)
			endSpin(g);
		else if (points[1] >= 4)
			endMisty(g);
		else if (points[2] >= 3)
			endMer(g);
		else if (points[3] >= 3)
			endPris(g);
		else if (points[4] >= 4)
			endTer(g, name);
		else
			endBad(g);
	}
	public static String getResponse(Visuals g, int[] points, int[] daysSpent) {
		g.getGP().addText("\n\n1: Check on Spinner");
		g.getGP().addText("\n2: Check on other monsters");
		if(daysSpent[1] == 1)
			g.getGP().addText("\n3: Take Terrence up on his offer");
		else if(daysSpent[1] > 1)
			g.getGP().addText("\n3: Find Misty");
		g.getGP().addText("\n\nWhat will you do? ");
		try {
			waitForInput();
			g.getGP().addText(g.getGP().getResponse());
		} catch (InterruptedException e) {}
		return g.getGP().getResponse();
	}
	public static void choosePath(String response, Visuals g, int[] points, int[] daysSpent, String name) {
		if(response.equals("1")) {
			if(daysSpent[0] == 0)
				day1SpinPath(g, points, daysSpent);
			else if(daysSpent[0] == 1)
				day2SpinPath(g, points, daysSpent);
			else if(daysSpent[0] == 2)
				day3SpinPath(g, points, daysSpent);
			else if(daysSpent[0] == 3)
				day4SpinPath(g, points, daysSpent);
			else
				day5SpinPath(g, points);
		}
		else if(response.equals("2")) {
			if(daysSpent[2] == 0)
				day1MonsterPath(g, points, daysSpent);
			else if(daysSpent[2] == 1)
				day2MonsterPath(g, points, daysSpent, name);
			else if(daysSpent[3] == 2)
				day4PrisPath(g, points, daysSpent, name);
			else if(daysSpent[3] == 3)
				day5PrisPath(g, points);
			else if(daysSpent[2] == 2)
				day3MonsterPath(g, points, daysSpent);
			else if(daysSpent[2] == 3)
				day4MerPath(g, points, daysSpent);
			else
				day5MerPath(g, points);
		}
		else if(response.equals("3")) {
			if(daysSpent[1] == 1)
				day2MisPath(g, points, daysSpent, name);
			else if(daysSpent[1] == 2)
				day3MisPath(g, points, daysSpent);
			else if(points[4] == 3)
				day5TerPath(g, points);
			else if(daysSpent[1] == 3)
				day4MisPath(g, points, daysSpent);
			else if(daysSpent[1] == 4)
				day5MisPath(g, points);
		}
	}
	public static void intro(Visuals g) {
		try{
			String response = "0";

			g.getGP().addText("This game was made by Elizabeth Gonzalez in Java.");
			waitForInput();
			g.getGP().addText("\nI hope you enjoy it.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Would you like to see the instructions?");
				g.getGP().addText("\n2: Or just get straight to playing?");
				g.getGP().addText("\nType the number of your choice and press the Next button: ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\nHouse of Monsters is set in an underground facility that holds, you guessed it, monsters. As"
						+ " befits such an interesting setting, the main character is...you!"
						+ " And your goal is to make friends with the monsters! How very reallistic and sweet. Press the Next button.");
				waitForInput();
				g.getGP().addText("\n\nAnyway, the society is divided into 5 classes based on psychic ability, with 1s being"
						+ " godlike rulers and nonpsychic 5s hardly getting by. 10 out of 10 society, I say. You are a Class Three who's"
						+ " researching monster behavior. You can be a boy, girl, or whatever - your character's gender isn't specified."
						+ " You talk to the monsters and sometimes make choices - good answers give you points. If you get enough"
						+ " good answers, you can score a character point at the end of the day. The goal is to get a certain number"
						+ " of these, usually 3, but more for the harder characters. Hint: Merina and Spinner are easy.");
				waitForInput();
				g.getGP().addText("\n\nMake the choices you think are best and have fun. Now, enough hand holding. Press Next!");
				waitForInput();
			}
		}
		catch(InterruptedException e) {}
	}
	public static String day1Intro(Visuals g) {
		String response = "0";
		try {
			g.getGP().addText("\n\nDay 1");

			g.getGP().addText("\n\nWelcome to your new job. As the elevator carries you down, you cannot help but notice"
					+ " how quiet the atmosphere is. The air barely moves. What adventures will this job bring you?"
					+ " What will you do? Will you, perhaps, find true friendship?");
			waitForInput();
			g.getGP().addText("\n\nYou exit the elevator and look around. To put it plainly, this place needs some serious TLC."
					+ " It looks like the very foundations of the building want to give up and die. But hey, at least you"
					+ " aren't in it alone. There's one other person in this room, a Class Five janitor, by the looks"
					+ " of him. Maybe he can help you figure this place out.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Ask for help");
				g.getGP().addText("\n2: Venture off on your own");
				g.getGP().addText("\nWhat will you do? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2") && !response.equals("443"));
			g.getGP().addText(response);
		}
		catch(InterruptedException e) {}
		return response;
	}
	public static void day2Intro(Visuals g, int[] points) {
		g.getGP().addText("\n\nDay 2");
		g.getGP().addText("\n\nThe elevator groans as you make the descent once again to the proper floor. Another day has"
				+ " begun. As you breathe in the stale air, rich with the perfume of large animals and hay, you wonder"
				+ " where you're going.");
	}
	public static void day3Intro(Visuals g, int[] points) {
		g.getGP().addText("\n\nDay 3");
		g.getGP().addText("\n\nYet another sunny, cloudless, over 100 degree day has started. Your boss, a Class Two named"
				+ " Felicia, passes by you in the hall and nods curtly. You head off to start work, wondering what adventures"
				+ " this day will bring.");
	}
	public static void day4Intro(Visuals g, int[] points) {
		g.getGP().addText("\n\nDay 4");
		g.getGP().addText("\n\nHere goes another day. Perhaps, despite the dreary work ahead of you, you can get some quality"
				+ " conversations in. True friendship awaits!");
	}
	public static void day5Intro(Visuals g, int[] points) {
		g.getGP().addText("\n\nDay 5");
		g.getGP().addText("\n\nThe monsters seem agitated today. Somehow, the way they pace around in their cages reminds you"
				+ " of the way that small animals act before a large storm. Something big may be coming. Best make friends"
				+ " while the weather is fair, and they may help you when the storm hits.");
	}
	public static void day6Intro(Visuals g) {
		g.getGP().addText("\n\nDay 6");
		try {
		g.getGP().addText("\n\nThe elevator stops. You wait for the doors to open. When they remain closed, you press the"
				+ " button again. The doors remain firmly shut.");
		waitForInput();
		g.getGP().addText("\n\nThey open. Quickly, you step off the elevator, eager to get away from its confines. The light"
				+ " above you flickers.");
		waitForInput();
		g.getGP().addText("\n\nAn aura of unease hangs around the air. It could just be a lingering fear from your earlier"
				+ " accident, but you cannot seem to shake it. The monsters know, but you do not.");
		waitForInput();
		g.getGP().addText("\n\nIt's late into your shift when the storm hits.");
		waitForInput();
		g.getGP().addText("\n\nThis is not a drill. If it was a drill, the halls around you would not be echoing with the sounds"
				+ " of inhuman screams. The cage in front of you would not be open, and the canine monstosity that was its former"
				+ " inhabitant would not be crouched menacingly outside of it.");
		waitForInput();
		g.getGP().addText("\n\nThere is nowhere for you to run. Psychically, you try to push it back, but it shrieks and your"
				+ " control is suddenly snapped. You try again and again, but each time, it mentally pushes you away. You"
				+ " realize that there is no way to fight back. You close your eyes...");
		waitForInput();
		} catch (InterruptedException e) {}
	}
	public static String day1HelpPath(Visuals g) {
		String response = "0";
		try {
			g.getGP().addText("\n\nYou wave at the man and he notices you. He stops his work and comes over, and"
					+ " you notice that his name tag reads 'Terrence.' You explain to him that this is your first day"
					+ " and you're not really sure where you're supposed to go. He nods, understanding, and points you"
					+ " in the right direction.");
			waitForInput();
			g.getGP().addText("\n\nYou head off and find the monster you were assigned to take care of: Spinner. It looks like a"
					+ " giant spider, but instead of having eight arms, you count 12. Some of them end in claws and others"
					+ " in spikes, and one pair of them are odd little cones whose purpose you cannot begin to guess."
					+ " He sees you (lol im spi-derp) and his purple eyes narrow. \"Hello there :P,\" he says.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Answer the monster");
				g.getGP().addText("\n2: Ignore him and run back to Terrence");
				g.getGP().addText("\nWhat will you do? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
		} catch (InterruptedException e) {}
		return response;
	}
	public static void day1SpinPath(Visuals g, int[] points, int[] daysSpent) {
		daysSpent[0]++;
		try {
			g.getGP().addText("\n\nYou greet the giant spider. \"Hi :D,\" he hisses. You notice that he's watching you"
					+ " rather intently (with his lolSexy eyes).");
			waitForInput();
			g.getGP().addText("\n\nSpinner's twelve legs fly about almost hypnotically (oOo). You should be wondering why you are"
					+ " talking to a gigantic spider, but here you are. Good job for playing this game. I think Spinner will be"
					+ " a good friend. Yay.");
			waitForInput();
			points[0]++;
		} catch (InterruptedException e) {}
	}
	public static void day2SpinPath(Visuals g, int[] points, int[] daysSpent) {
		daysSpent[0]++;
		int spinPoints = 0;
		String response = "0";
		try {
			g.getGP().addText("\n\nHere you are, talking to Spinner the giant spi-derp. You should think of something to say.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Talk about the weather.");
				g.getGP().addText("\n2: Talk about bugs.");
				g.getGP().addText("\n3: Talk about football.");
				g.getGP().addText("\nWhat will you do? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2") && !response.equals("3"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\nThe 100 plus degree weather is, in fact, quite nice. It is too bad that Spinner is a giant"
						+ " spider and in a cage, or he would certainly appreciate all the wonderful things you have to say about the sun.");
			}
			else if(response.equals("2")) {
				g.getGP().addText("\n\nBeing that you are talking to a giant spider, you decide to talk about bugs. Spinner"
						+ " discusses his favorite bugs to eat for over an hour. You tell him about the one time you accidentally"
						+ " ate a mosquito.");
				spinPoints++;
			}
			else {
				g.getGP().addText("\n\nThis does not work. You have failed. You have seriously failed. I hope that you are"
						+ " regretting each and every one of the life choices that led up to you picking this option. Boo.");
				spinPoints--;
			}
			waitForInput();
			g.getGP().addText("\n\nSpinner stretches his legs and yawns :O. \"Well, it certainly was interesting, speaking with you,\""
					+ " he says. You nod, feeling the exact same way.");
			waitForInput();
			g.getGP().addText("\n\nSpinner has one last thing to say, though. His LOLpurple eyes narrow and his spidery fangs glisten."
					+ " \"So,\" he says, turning around slowly. Your heart begins to flutter in anticipation. \"What do u think,\""
					+ " he hisses, \"of outdated memes?\"");
			waitForInput();
			g.getGP().addText("\n\nHis second body segment is entirely covered in outdated memes.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: I seek true memeship. We are a match made in an underground facility.");
				g.getGP().addText("\n2: No.");
				g.getGP().addText("\nWhat will you say? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\nAsk and you shall receive, my friend.");
				spinPoints++;
			}
			else {
				g.getGP().addText("\n\nNu!1!1! Yu have to ste focused! Mek friends wit da spi-derp, remember?!");
			}
			waitForInput();
		} catch (InterruptedException e) {}
		if (spinPoints >= 1)
			points[0]++;
	}
	public static void day3SpinPath(Visuals g, int[] points, int[] daysSpent) {
		String response = "0";
		try {
			daysSpent[0]++;
			g.getGP().addText("\n\nThese long, meaningful conversations, they are really going places! As the passionate"
					+ " friendship between you and Spinner continues, the great cosmic clock of loldom ticks"
					+ " down to the end of this magical time. You wonder, are you really ready to be friends with Spinner?");
			waitForInput();
			g.getGP().addText("\n\nThere may still be time left. If you back out now, you might still have a"
					+ " chance to get a different ending. Are you really ready to commit to this spider?");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: I would give him my mind, body, soul, and (most importantly) heart. I am ready for this.");
				g.getGP().addText("\n2: Actually, no.");
				g.getGP().addText("\nWhat will you do? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\nuwu! Let's see this friendship through!");
				waitForInput();
				points[0]++;
			}
			else {
				g.getGP().addText("\n\nYou run the heck out of there and find some other monsters to bother.");
				waitForInput();
				choosePath("2", g, points, daysSpent, "Sweetie");
			}
		} catch (InterruptedException e) {}
	}
	public static void day4SpinPath(Visuals g, int[] points, int[] daysSpent) {
		daysSpent[0]++;
		try {
			g.getGP().addText("\n\nSpinner, Spinner, in a web.");
			waitForInput();
			g.getGP().addText("\n\nSpinner is an awesome spi-derp.");
			waitForInput();
			g.getGP().addText("\n\nI hope you have no regrets.");
			waitForInput();
			g.getGP().addText("\n\nBecause I certainly do after writing this.");
			waitForInput();
		} catch (InterruptedException e) {}
		points[0]++;
	}
	public static void day5SpinPath(Visuals g, int[] points) {
		try {
			g.getGP().addText("\n\nI warned you. There is no turning back.");
			waitForInput();
			g.getGP().addText("\n\nBut here you are.");
			waitForInput();
			g.getGP().addText("\n\nYou have nothing in common with a giant spider. Do you realize this?");
			waitForInput();
			g.getGP().addText("\n\nBut nooooooo. You had to ask for this.");
			waitForInput();
			g.getGP().addText("\n\nOMG! Spinner is like, so cool! U hav so much in commom wit a giant spider! U r such friends!");
			waitForInput();
			g.getGP().addText("\n\nIt is a beautiful day.");
			waitForInput();
		} catch (InterruptedException e) {}
		points[0]++;
	}
	public static void endSpin(Visuals g) {
		try {
			g.getGP().addText("\n\nSpinner drops from the ceiling, landing between you and the monster. It is quick, brutal, and"
					+ " executed with an almost cartoonish level of violence, but Spinner comes out without a single scratch.");
			waitForInput();
			g.getGP().addText("\n\nThen Spinner turns to you. It's awesome. You love him so much (as a friend). You do not wonder"
					+ " why the writing quality of this branch is so bad. You do not wonder this because you are too busy admiring his anthro"
					+ " form. It is so awesome. You are now making out (in an absolutely platonic way).");
			waitForInput();
			g.getGP().addText("\n\nIf there was a picture here, you would totally be swooning. You have won the friendship sim. ;D");
			waitForInput();
			g.getGP().addText("\n\ngg");
			waitForInput();
		} catch (InterruptedException e) {}
	}
	public static void day1MisPath(Visuals g, int[] points, int[] daysSpent) {
		String response = "0";
		try {
			g.getGP().addText("\n\nThe monster mumbles something about u suk at manners, but does not attempt to make conversation"
					+ " again. You cannot find Terrence, so you study a pair of rodent monsters in peace. When you head out, you see the janitor.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Wave him over. You want to talk.");
				g.getGP().addText("\n2: Just head home.");
				g.getGP().addText("\nWhat will you do? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if (response.equals("1")) {
				g.getGP().addText("\n\nYou call him over. As you're walking, you make conversation about your day. When you tell him about"
						+ " your experience with Spinner, he seems to understand. \"He's really not that bad, though. Most of"
						+ " the monsters aren't.\"");
				waitForInput();
				g.getGP().addText("\n\nYou chatter on for a little while. Eventually, you find yourself at the bus stop, and you stop"
						+ " with Terrence to wait for it. Suddenly, he asks, \"You're here tomorrow, too, right? If you would like, I could"
						+ " introduce you to one of the nicer monsters.\"");
				waitForInput();
				g.getGP().addText("\n\nYou'll definitely think about it.");
				daysSpent[1]++;
			}
			else
				g.getGP().addText("\n\nSo home you go.");
			waitForInput();
		} catch (InterruptedException e) {}
	}
	public static void day2MisPath(Visuals g, int[] points, int[] daysSpent, String name) {
		daysSpent[1]++;
		String response = "0";
		int terPoints = 0;
		int misPoints = 0;
		try {
			g.getGP().addText("\n\nYou find Terrence almost immediately. \"Hi, I decided to take you up on that offer. What kind"
					+ " of monster are we up against today?\" you ask him.");
			waitForInput();
			g.getGP().addText("\n\nHe grins. \"Nothing too serious,\" he replies as the two of you head off down the cement"
					+ " halls. \"Misty is actually really nice. I think you'll like her.\" He turns the corner and you follow.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Walk in silence");
				g.getGP().addText("\n2: Make conversation");
				g.getGP().addText("\nWhat will you do? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if (response.equals("2")) {
				g.getGP().addText("\n\nYou ask him how long he's been working here, and it turns out that he has had"
						+ " this job for a little over a year. He speaks as quickly as he walks, and whenever it's your turn"
						+ " to say something, you realize that you're nearly panting!");
				waitForInput();
				terPoints++;
			}
			g.getGP().addText("\n\nEventually, you both stop. The monster in front of you presses her nose against the glass and chirps"
					+ " happily at Terrence. Her eyes are black and glassy, and there is a white butterfly resting on her head."
					+ " She notices you and tilts her head to the side, apparently confused. \"Misty, this is " + name + ",\""
					+ " Terrence introduces you.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Hi there.");
				g.getGP().addText("\n2: I like your butterfly.");
				g.getGP().addText("\nWhat will you say? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("2")) {
				g.getGP().addText("\n\nApparently taking this as a compliment, Misty blushes pale pink.");
				misPoints++;
			}
			g.getGP().addText("\n\nShe smiles at you and waves. The butterfly on her head flutters for a moment before settling"
					+ " down again.");
			waitForInput();
			g.getGP().addText("\n\nTerrence has to go back to his job, and so do you, but at lunchtime, the three of you reconvene."
					+ " You unwrap the food bar you brought, Terrence unwraps his, and Misty digs into whatever unidentifiable"
					+ " monster food she has to eat. She takes a bite and then looks at you. Catching your attention, she tosses"
					+ " it into the air and the butterfly snatches it out of the air. She giggles and performs the trick again.");
			waitForInput();
			g.getGP().addText("\n\nAfter showing off for a little while, Misty puts her hands on her hips and chirps at Terrence. She"
					+ " makes a series of complicated gestures with her hands, but Terrence seems to understand them because he starts"
					+ " shaking his head. \"No, Misty. That isn't very professional.\" You're still waiting for a translation, and he"
					+ " starts blushing furiously. \"She, um, she really wants me to show you this stupid food tossing trick,\" he finally"
					+ " says, flashing Misty a dirty look which she innocently ignores. \"I don't usually do this at work. I-I mean, this"
					+ " is stupid.\" At about this time, he realizes that it's in his best interest to quit talking. He shakes his head. Misty"
					+ " points at him and nods.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Side with Terrence");
				g.getGP().addText("\n2: Side with Misty");
				g.getGP().addText("\nWhat will you do? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\nYou've had your fun, and you decide to give the janitor a break. \"All right, we'll just have"
						+ " to see Terrence's award winning food toss some other day,\" you smile. Misty shrugs, and Terrence folds"
						+ " his arms, mumbling something about not being a trick monkey. Still, the look he gives you is one of"
						+ " gratefulness. It's not often that somebody sides with a Class Five, even for something unimportant like this.");
				terPoints++;
			}
			else {
				g.getGP().addText("\n\n\"Come on, Terrence, I have to see this!\" you say, joining Misty in her encouragement."
						+ " Terrence rolls his eyes and breaks a piece off of his Food Bar. With a spectacular toss, he makes"
						+ " the catch with his mouth before declaring that the rest of the food has to go in his mouth the normal way"
						+ " or he'll be starved. Misty catches your attention and giggles.");
				misPoints++;
			}
			waitForInput();
			g.getGP().addText("\n\nWith that little adventure over, the bell rings, signalling the end of lunch. It's time for you"
					+ " to head back to work.");
			waitForInput();
		} catch (InterruptedException e) {}
		if(terPoints >= 2)
			points[4]++;
		else if(misPoints >= 1)
			points[1]++;
	}
	public static void day3MisPath(Visuals g, int[] points, int[] daysSpent) {
		daysSpent[1]++;
		int terPoints = 0;
		int misPoints = 0;
		String response = "0";
		try {
			g.getGP().addText("\n\nYou head over to Misty's pen, deciding it is the best place to find her and Terrence. The janitor"
					+ " isn't there, but Misty waves at you.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Chat with her.");
				g.getGP().addText("\n2: Search for Terrence.");
				g.getGP().addText("\nWhat will you do? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\nYou can't really talk with Misty, but she does seem to enjoy hearing what you have to say."
						+ " You ramble on about the weather and your job and whatever else happens to come to your mind.");
				misPoints++;
				waitForInput();
				g.getGP().addText("\n\nWhen you run out of things to say, it's so quiet that you can hear the monsters breathing"
						+ " heavily in their prisons. A chirp breaks the silence. You turn and see Misty tapping on the glass."
						+ " When she realizes she's got your attention, she starts charading the act of eating with a spoon."
						+ " \"What are you doing? Are you needing to eat?\" you ask She shakes her head and makes a series of gestures"
						+ " with her hands. You understand. She is trying to teach you what the word \"eat\" is in her language.");
				waitForInput();
				g.getGP().addText("\n\nYou learn a few more words: \"butterfly,\" \"light,\" \"see,\" before Terrence finally jogs"
						+ " up. \"Hi guys,\" he says, putting one hand on the wall. \"Sorry I'm late. One of the smaller monsters"
						+ " got out and tried to eat my mop.\"");
			}
			else {
				g.getGP().addText("\n\nYou head off to look for the Class Five. He's bent over one of the smaller cages, pulling"
						+ " something away from the furry creature on the ground. It's a monster! Before you can run for help,"
						+ " Terrence pulls his mop out of the creature's grasp and calls out, \"It's okay! This is a phase mole! They aren't"
						+ " dangerous, but they get out all the time.\"");
				waitForInput();
				g.getGP().addText("\n\nIt isn't exactly the most comforting speech, but it makes you take a second look at the creature."
						+ " It's small and furry and it resembles a mole very closely. Using its tiny front paws, it takes hold of the"
						+ " mop once again and pulls.");
				terPoints++;
				waitForInput();
				g.getGP().addText("\n\nIt's actually kind of cute. Feeling a little bolder, you reach out with your mind and and pry it away"
						+ " from its wooden treasure. You plop it back into its cage and it wanders around. \"Thanks,\" says"
						+ " Terrence. You both head back to Misty.");
			}
			waitForInput();
			g.getGP().addText("\n\nThe three of you sit down to lunch. After a few lazy comments about the weather, Terrence starts"
					+ " complaining about his boss. According to him, she's incredibly strict and most of all, rude. You don't"
					+ " know Felicia too well, but she didn't strike you as particularly awful.");
			waitForInput();
			g.getGP().addText("\n\n\"Yeah, well, she is. Creepy, too.\" He scoffs. \"Just look at the way she's always...\"");
			waitForInput();
			g.getGP().addText("\n\nHe stops suddenly. \"Never mind. She's not that bad, really.\" He doesn't"
					+ " seem to want to talk about it.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Press him about Felicia");
				g.getGP().addText("\n2: Change the subject");
				g.getGP().addText("\nWhat will you do? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\nHe really doesn't seem to want to talk about it, but apparently, she's been singling him out"
						+ " for trouble for some really pointless things. \"It's nothing, really.\" He avoids your gaze and quickly"
						+ " returns to work when the bells signal the end of lunch. Maybe you shouldn't have pushed him so much.");
				terPoints--;
			}
			else {
				g.getGP().addText("\n\nYou instead start praising the remarkable triple butterfly toss that Misty just pulled off."
						+ " All three of you are happy, and lunch ends far too soon.");
			}
			waitForInput();
		} catch (InterruptedException e) {}
		if (terPoints >= 1)
			points[4]++;
		else if (misPoints >= 1)
			points[1]++;
	}
	public static void day4MisPath(Visuals g, int[] points, int[] daysSpent) {
		String response = "0";
		int misPoints = 0;
		daysSpent[1] ++;
		try {
			g.getGP().addText("\n\nYou find that Misty girl and give her a cheerful hello.");
			waitForInput();
			g.getGP().addText("\n\nThe two of you sit, you leaning against the glass and Misty sitting against it on the other side. ");
			if(points[1] >= 2)
				g.getGP().addText(" Misty chirps at you happily.");
			waitForInput();
			g.getGP().addText("\n\nSo, let's interview this monster!");
			waitForInput();
			if(points[4] == 2) {
				g.getGP().addText("\n\nActually, now that you think about it, you haven't seen Terrence all day. Would you like"
						+ " to find him?");
				waitForInput();
				do {
					g.getGP().addText("\n\n1: Yes");
					g.getGP().addText("\n2: No");
					g.getGP().addText("\nWhat will you decide? ");
					waitForInput();
					response = g.getGP().getResponse();
				} while(!response.equals("1") && !response.equals("2"));
				g.getGP().addText(response);
				if(response.equals("1")) {
					day4TerPath(g, points, daysSpent);
					return;
				}
			}
			g.getGP().addText("\n\nMisty chirps happily at your questions. You're not quite sure if she understands all of them,"
					+ " and you know that you don't understand all of her answers, but it's still a good time. She pantomimes"
					+ " things out and the two of you play charades while her little white butterflies flutter.");
			waitForInput();
			g.getGP().addText("\n\nAfter a little while, you notice that she's getting tired.");
			waitForInput();
			g.getGP().addText("\n\nSuddenly, you have a new question for her.");
			waitForInput();
			g.getGP().addText("\n\n\"Hey, Misty!\" you call. \"Can you do this?\" Breaking off a piece of your Food Bar, you toss"
					+ " it into the air and spectacularly fail at catching it. She bursts into giggles and attempts the trick with"
					+ " her own lunch. Of course, it always helps to have a few butterflies.");

			waitForInput();
			g.getGP().addText("\n\nHow loudly are you going to cheer?");
			do {
				g.getGP().addText("\n\n1: Quiet");
				g.getGP().addText("\n2: Loud");
				g.getGP().addText("\n3: Ultra");
				g.getGP().addText("\nWhat will you say? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2") && !response.equals("3"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\nMisty tosses it higher, not wanting to disappoint you. You barely clap, and the pale blush creeps"
						+ " into her cheeks.");
			}
			else if (response.equals("2")) {
				g.getGP().addText("\n\nYou applaud. Beaming, she gives a little clap and makes the catch again and again.");
				misPoints++;
			}
			else {
				g.getGP().addText("\n\nYou attempt to break the sound barrier. Misty beams with pride, and her face suddenly reddens"
						+ " because just about every monster in the hallway starts shouting that you have no idea what peace and quiet"
						+ " is. Your face floods with blush.");
				misPoints++;
			}
			waitForInput();
			g.getGP().addText("\n\nMisty's butterflies seem to be tiring out. She sits down and moves a little closer to the glass.");
			waitForInput();
			g.getGP().addText("\n\nShe squeaks.");
			waitForInput();
			g.getGP().addText("\n\nTell her a story?");
			do {
				g.getGP().addText("\n\n1: Yes");
				g.getGP().addText("\n2: No");
				g.getGP().addText("\nWhat will you do? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				misPoints ++;
				g.getGP().addText("\n\nYou lean back against the glass, thinking of a good tale to tell. After a bit of thinking,"
						+ " you settle on a fantasy one about a magical shaft of silver light. It isn't as good as you remember"
						+ " it to be, but it brings back memories of childhood and true friends and summers long ago but not forgotten.");
				waitForInput();
				g.getGP().addText("\n\nMisty listens, her wide eyes drinking in every word. She curls up and sits so close that you"
						+ " barely remember that only a thick sheet of containment glass separetes you from the monster.");
				waitForInput();
				g.getGP().addText("\n\nShe hugs her knees to her chest and twitters.");
			}
			else {
				g.getGP().addText("\n\nYou sit together in silence. Eventually, you look over to find Misty fast asleep.");
			}
			waitForInput();
			g.getGP().addText("\n\nThat's when the sirens start.");
			waitForInput();
			g.getGP().addText("\n\nYour first though is, \"Breach!\" But that isn't it. The people you see running aren't"
					+ " moving quickly enough for that.");
			waitForInput();
			g.getGP().addText("\n\nThe crowd is too thick. Most of the people are Class Fours who let you through once they"
					+ " realize your status. Still, a pair of medics, both Class Threes, shoo you back as they try to assess the"
					+ " situation for themselves.");
			waitForInput();
			g.getGP().addText("\n\nThere has been an attack. Your own boss, Felicia, sits in the corner, in shock as a Class Three doctor"
					+ " bandages her wounds. She is gasping.");
			waitForInput();
			g.getGP().addText("\n\nTerrence, the Class Five janitor, is dead.");
			waitForInput();
			g.getGP().addText("\n\nYou leave the scene, surprised and a little frightened, and head back to Misty. Terrence may have"
					+ " only been a Class Five, but he was still her friend. Misty is devastated.");
			if(misPoints >= 1)
				points[1]++;
			points[4] = 0;

			waitForInput();
		} catch (InterruptedException e) {}
	}
	public static void day5MisPath(Visuals g, int[] points) {
		try {
			g.getGP().addText("\n\nWhen Misty sees you, she chirrups sadly. Her eyes are filled with tears.");
			waitForInput();
			g.getGP().addText("\n\nIf you could reach through the glass, you would hold her. Instead, you sit in silence, listening"
					+ " to her soft, hiccupy breaths through the glass.");
			waitForInput();
			g.getGP().addText("\n\n\"It's going to be okay,\" you assure her. She sniffles again, but looks into your eyes. \"It's"
					+ " going to be okay,\" you repeat.");
			waitForInput();
			g.getGP().addText("\n\nWhat are you doing? You're supposed to be monster caretaker! If nothing else is clear to you,"
					+ " this monster needs some care right now!");
			waitForInput();
			g.getGP().addText("\n\nYou slip on your gloves and open the enclosure. Misty looks up at you, still weeping. You take"
					+ " her into your arms and let her tears wet the front of your uniform. Her little body shakes, and it feels"
					+ " so cold against yours. You hold her close.");
			waitForInput();
			g.getGP().addText("\n\nShe lets the tears run their course. As the two of you stand, sharing your sadness, the echoes of distant"
					+ " howls grow unimportant. Misty finally stops crying.");
			waitForInput();
			g.getGP().addText("\n\nShe stays in your arms for another moment before letting go. In the distance, a monster wildly"
					+ " screams. You think Misty is going to start crying again, but instead, she looks up with her wide, glassy"
					+ " eyes and makes a single sign.");
			waitForInput();
			g.getGP().addText("\n\n'Friend.'");
			waitForInput();
		} catch (InterruptedException e) {}
		points[1]++;
	}
	public static void endMisty(Visuals g) {
		try {
			g.getGP().addText("\n\nAll of a sudden, pale white butterflies surround the creature. At first, you take it as a welcome"
					+ " distraction. While they swarm the monster, you take your chance and run. Behind you, your would-be attacker growls."
					+ " Suddenly, it lets out a scarp cry.");
			waitForInput();
			g.getGP().addText("\n\nThe butterflies swarm the monster, turning crimson as they drain its blood. The monster howls in pain and blindly runs.");
			waitForInput();
			g.getGP().addText("\n\nYou hear Misty's familiar chirping. The butterflies flock to her, and once they are all accounted for,"
					+ " She slips into your arms for a moment before the two of you take off running.");
			waitForInput();
			g.getGP().addText("\n\nWhen you get to the surface, she turns around and squeezes your hand. You made it. Both of you."
					+ " Through the morning light, butterflies swirl, and the sun rises in the distance.");
			waitForInput();
			g.getGP().addText("\n\nYou are home.");
			waitForInput();
		} catch (InterruptedException e) {}
	}
	public static void day4TerPath(Visuals g, int[] points, int[] daysSpent) {
		String response = "0";
		try {
			g.getGP().addText("\n\nYou poke around for a bit, looking for Terrence. You pause for a moment, and one monster with cascading"
					+ " tentacles starts slamming its body against the side of its pen. You move on.");
			waitForInput();
			g.getGP().addText("\n\nAh, there's Terrence. He's mopping up a spill on the floor, and the boss, Felicia, is watching him."
					+ " They seem to be busy. You hang back and listen.");
			waitForInput();
			g.getGP().addText("\n\n\"You missed a spot,\" says Felicia. Terrence moves to clean it. Suddenly, the Class Two grabs"
					+ " for the mop and snatches it.");
			waitForInput();
			g.getGP().addText("\n\n\"I got it,\" says Felicia, daintily brushing the head of the mop against the floor. She smiles,"
					+ " handing it back to the janitor.");
			waitForInput();
			g.getGP().addText("\n\nShe swipes it back. \"Missed another spot,\" she smiles, bringing the dripping mop lightly down on"
					+ " Terrence's head."
					+ " \"Ha ha, Felicia,\" he rolls his eyes. He gives a smile, but it looks forced.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Intervene");
				g.getGP().addText("\n2: Keep watching");
				g.getGP().addText("\nWhat will you do? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\n\"Hi, am I interrupting something?\" you ask, stepping forward. Felicia wheels toward"
						+ " you in surprise, blushing as she tries to figure out just how much of her unprofessional behavior"
						+ " you just witnessed.");
				waitForInput();
				g.getGP().addText("\n\n\"No, it's all good,\" she tells you, regaining her composure. She walks away quickly, and you catch"
						+ " Terrence staring at you with a strange expression before he returns to his cleaning.");
				points[4]++;
				waitForInput();
				return;
			}
			g.getGP().addText("\n\nFelicia hands the mop back, and this time, Terrence gets to take it. He resumes his work, but"
					+ " Felicia stays where she is. She folds her arms.");
			waitForInput();
			g.getGP().addText("\n\n\"I was thinking about how to improve the hiring process, and I'm deciding to add a literacy test"
					+ " to the application. Do you think that would affect your canidacy for this job?\"");
			waitForInput();
			g.getGP().addText("\n\nHe barely looks up. \"No, I don't think it would.\"");
			waitForInput();
			g.getGP().addText("\n\n\"A shame.\" Her eyes narrow slightly. \"You're just a stupid Class Five.\"");
			waitForInput();
			g.getGP().addText("\n\nTerrence focuses a little harder on the floor.");
			waitForInput();
			g.getGP().addText("\n\n\"Why would anyone even bother to teach you to read?\" Felicia asks, pushing herself off of the wall to circle around"
					+ " Terrence. \"Sometimes I wonder why Class Fives are even kept around. How do you function without"
					+ " psionics?\"");
			waitForInput();
			g.getGP().addText("\n\nShe pauses in front of Terrence. \"Maybe it would be better if we just got rid of people like"
					+ " you before they're even born.\"");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Intervene");
				g.getGP().addText("\n2: Keep watching");
				g.getGP().addText("\nWhat will you do? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\nYou step forward and Felicia notices you. Quickly, she resumes a proper posture and glares"
						+ " at you. \"Class Three, do you not have a job to complete?\" You stammer out an explanation, but Felicia"
						+ " is already storming away. \"Let this be your warning,\" she says, and leaves it at that.");
				waitForInput();
				g.getGP().addText("\n\nYou shiver despite the heat and glance at Terrence. He glances at you for a brief second"
						+ " before returning to his work, as if this has been the most ordinary day in the universe.");
				points[4]++;
				waitForInput();
				return;
			}
			g.getGP().addText("\n\nIn the corner, a monster growls and pounds against its cage."
			        + " \"Class Five are you listening to me?\" Felicia suddenly yells. She wrenches the mop out of the"
					+ " surprised Terrence's hands and he takes a step backward to avoid being hit by the cleaning instrument."
					+ " The monster growls and pounds harder against the cage. The door gives way.");
			waitForInput();
			g.getGP().addText("\n\nIt's over in a monment. Felicia steps out of the way and watches. She could stop the monster,"
			        + " but she chooses not to. You could stop it, but you're frozen with fear. Terrence can't stop it. There is"
					+ " a horrible crunch, and for a moment, Terrence is wide-eyed with terror and shock. The next, he"
					+ " is missing a few vital organs. It's not a pretty sight.");
			waitForInput();
			g.getGP().addText("\n\nFelicia screams. Blasting the monster into the wall, she screams and bolts away.");
			waitForInput();
			g.getGP().addText("\n\nWhen people gather to asses the damage, they're glad that a Class Five was the only loss."
					+ " It could have been a whole lot worse. The monster could have killed someone actually useful.");
			waitForInput();
			g.getGP().addText("\n\nMisty, however, is devastated.");
			waitForInput();
		} catch (InterruptedException e) {}
		points[4] = 0;
	}
	public static void day5TerPath(Visuals g, int[] points) {
		String response = "0";
		try {
			int terPoints = 0;
			g.getGP().addText("\n\nThere's a tense silence over lunch today. Misty doesn't chirp happily and Terrence eats quickly,"
					+ " but you notice him glance over at you more than once.");
			waitForInput();
			g.getGP().addText("\n\nLunch ends. You go back to work. For the rest of the day, studying monsters occupies your full"
					+ " attention, but at the end of the day, you run into Terrence again. He pauses and seems like he wants to say"
					+ " something, but instead he puts his hands in his pockets and gives you a quiet goodbye before hurrying to the bus stop.");
			waitForInput();
			g.getGP().addText("\n\nYou don't take that bus, but today, curiosity overcomes you and you follow him. He's walking"
					+ " quickly, but something tells you he realizes you're following him.");
			waitForInput();
			g.getGP().addText("\n\nHe reaches his usual stop and turns around. \"Are you going to follow me all night?\" he asks.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Yes");
				g.getGP().addText("\n2: No");
				g.getGP().addText("\nWhat will you say? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\nWow. You have no subtlety whatsoever.");
			}
			else {
				terPoints ++;
				g.getGP().addText("\nYou blush, embarrased, and mutter that you were just about to leave. Quickly, you turn around."
						+ " \"Wait.\"");
				waitForInput();
				g.getGP().addText("\n\nTerrence is looking at you. He stands there, awkwardly, and remains paused. \"I’m sorry, okay?"
						+ " I didn’t mean to say it that way.\"");
			}
			waitForInput();
			g.getGP().addText("\n\nHe sighs and turns away again. \"Look, I think I get what you're looking for,\" he says. \"These"
					+ " things never work. You’re a Class Three and I’m, well, I’m a Class Five. There’s just too much of a"
					+ " power difference here. Do you understand?\"");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Yeah");
				g.getGP().addText("\n2: Not really");
				g.getGP().addText("\nWhat will you say? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\n\"Thank you.\" He looks relieved.");
			}
			else {
				System.out.print("He folds his arms. \"Tell me one person you know who wouldn't think you're pretty trashy"
						+ " for hanging out with a Class Five. The fact is, you'll always outrank me in every way. You make"
						+ " more money, you can get any job you like, you can walk down the street and feel safe...you name it."
						+ " And me? I'll only ever get a job out of 'equal opportunity' pity. Not to mention that you could force" 
						+ " me to do just about whatever with your psychic control, and there’s really not much I can do to stop it."
						+ " I like you, really, but I’ve just seen too many bad situations to want to jump into a relationship right away.\"");
			}
			waitForInput();
			g.getGP().addText("\n\nYou leave to walk back to your bus stop, but something makes you turn back. \"Can we at least"
					+ " be friends?\" you wonder.");
			waitForInput();
			g.getGP().addText("\n\nTerrence blinks at you. He looks small compared to the cityscape behind him, and he seems aware"
					+ " of it. The sun's light has almost faded from the sky. \"Um, sure,\" he replies, still a little surprised.");
			waitForInput();
			g.getGP().addText("\n\nA bus drives by, its headlights illuminating the street with a split second of brightness."
					+ " Terrence closes his eyes. \"First I get all chatty with a killer monster, and now here I am, making" 
					+ " friends with a Class Three. I must really have a death wish. You sure you still want to be friends with"
					+ " a guy like me?\"");
			waitForInput();
			g.getGP().addText("\n\nHeck yes. This is the one moment you've certainly been waiting for. There"
					+ " is absolutely no option to say no to this friendship.");
			waitForInput();
			g.getGP().addText("\n\nIt's time to befriend the janitor.");
			waitForInput();
			g.getGP().addText("\n\n\"Hey, um, if you aren't doing anything tonight, do you want to go to the bar together?\" He"
					+ " pauses. \"My treat,\" he adds.");
			waitForInput();
			g.getGP().addText("\n\nWell, he's paying. \"Okay,\" you shrug, and step next to him. Work tomorrow is going to be"
					+ " EXTREMELY awkward.");
			waitForInput();
			g.getGP().addText("\n\nThe bus arrives, and you both get on. There's one other person sitting in it, a haggard Class"
					+ " Five man who coughs to the side before going back to picking at his frayed sun jacket. Terrence glances"
					+ " at you. \"Let's sit here?\" he says, gesturing toward a seat closer to the front. You take it, and he"
					+ " fills the one next to you.");
			waitForInput();
			g.getGP().addText("\n\nThe scenery outside changes. In the darkness, you can see people and buildings whiz by. This"
					+ " looks like it's an older part of town.");
			waitForInput();
			g.getGP().addText("\n\nTerrence remains quiet. Every once in a while, he'll glance behind him and then go back to"
					+ " watching the driver. After a little while, he reaches past you to pull the stop cord. \"This is it.\"");
			waitForInput();
			g.getGP().addText("\n\nIt's probably the ugliest bar you've ever seen. The neon lights are way too bright, and the"
					+ " Class Four behind the counter looks like he might have had a few drinks himself. It's not crowded, at"
					+ " least, and you and Terrence find an empty booth easily enough. He gets up and stands next to the table"
					+ " like a sort of waiter. \"Can I take your order?\" he says in a mock proper accent.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Something cheap");
				g.getGP().addText("\n2: Something expensive");
				g.getGP().addText("\n3: Nothing");
				g.getGP().addText("\nWhat will you pick? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2") && !response.equals("3"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				terPoints ++;
				g.getGP().addText("\n\nHe brings back your order, and you see that he got the same for himself. He sets yours in"
						+ " front of you and takes a small sip of his.");
			}
			else if(response.equals("2")) {
				g.getGP().addText("\n\nEverything on the menu is cheap, but you pick something on the higher end of the price"
						+ " scale. When Terrence comes back with your drink, you notice he didn't get anything for himself.");
			}
			else {
				terPoints ++;
				g.getGP().addText("\n\n\"You sure?\" he asks. When you insist that you have changed your mind, Terrence sits back"
						+ " down. He doesn't get anything for himself."
						+ " \"I don't usually drink, either,\" he admits.");
				waitForInput();
				g.getGP().addText("\n\nThen he starts to blush. \"Well, except coffee.\"");
			}
			waitForInput();
			g.getGP().addText("\n\nYou sit together for a few minutes. Why not make some conversation?");
			do {
				waitForInput();
				g.getGP().addText("\n\nAsk something.");
				g.getGP().addText("\n1: Are you scared of monsters?");
				g.getGP().addText("\n2: What is your favorite food?");
				g.getGP().addText("\n3: How is your family?");
				g.getGP().addText("\n4: What fabulously mysterious things do you do when you're not at work?");
				g.getGP().addText("\n0: Finished talking");
				g.getGP().addText("\nWhat will you say? ");
				waitForInput();
				response = g.getGP().getResponse();
				if(response.equals("1")) {
					g.getGP().addText("\n\n\"It's odd, but, not really.\" He shrugs. \"I mean, it could be worse. At least there's a containment"
							+ " cage between us and the monsters, right? And it's not like they treat me any differently from other folks."
							+ " They'll eat all of us just the same.\" He bites his lip.");
				}
				else if(response.equals("2")) {
					g.getGP().addText("\n\nTerrence thinks for a moment. \"Berry muffin breakfast food bars,\" he decides. \"The"
							+ " extra caffinated ones. You should really try them.\"");
				}
				else if(response.equals("3")){
					g.getGP().addText("\n\n\"Um, I guess they're okay,\" he shrugs, and glances at the bartender. \"I mean, it's"
							+ " really just my aunt and me at this point. And my aunt's a Class Four, so it's really just me.\"");
				}
				else if(response.equals("4")){
					g.getGP().addText("\n\n\"Fabulously mysterious?\" He laughs. \"Not much, honestly. I guess I like to walk in the"
							+ " afternoon, and the bar's a place to go once in a while.\" He shrugs. \"I like my job, though."
							+ " It's quiet and nobody really bothers me, and working around monsters is really interesting.\"");
				}
			} while(!response.equals("0"));
			waitForInput();
			g.getGP().addText("\n\nEventually, you get tired of talking. You both head out, and you realize how late it is. Terrence,"
					+ " being psychically defenseless, produces a can of pepper spray and discretely holds it at the ready. He"
					+ " says goodbye and heads for the bus stop.");
			waitForInput();
			if(terPoints >= 1)
				points[4]++;
			do {
				g.getGP().addText("\n\n1: Follow him.");
				g.getGP().addText("\n2: Head home. It's pretty late, after all.");
				g.getGP().addText("\nWhat will you say? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("2")) {
				g.getGP().addText("\n\nYou head home for the night. Above you, the brightest stars glitter.");
				waitForInput();
				return;
			}
			waitForInput();
			g.getGP().addText("\n\nHe looks a little surprised, but he slows down so you can catch up. \"Sorry, do you need"
					+ " something?\" he asks.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Nope, I just wanted to walk with you.");
				g.getGP().addText("\n2: I'm stalking you creepily.");
				g.getGP().addText("\nWhat will you say? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("2")) {
				g.getGP().addText("\n\nHe blinks and looks at you a little nervously. \"What?\"");
				waitForInput();
				do {
					g.getGP().addText("\n\n1: Quickly apologize and attempt to ammend the situation.");
					g.getGP().addText("\n2: No, I came here to commit class genocide and I have to take it all the way.");
					g.getGP().addText("\nWhat will you do? ");
					waitForInput();
					response = g.getGP().getResponse();
				} while(!response.equals("1") && !response.equals("2"));
				g.getGP().addText(response);
				if(response.equals("1")) {
					g.getGP().addText("\n\n\"Sorry, bad joke,\" you mumble.");
					waitForInput();
					g.getGP().addText("\n\n\"Oh. You sure got me on that one.\" He gives a very nervous, very forced laugh and"
							+ " says goodbye for the second time. You notice he's holding the pepper spray a little tighter.");
					waitForInput();
					return;
				}
				else {
					g.getGP().addText("\n\n\"I hate Class Fives, especially you, and I am going to make you suffer now.\"");
					waitForInput();
					g.getGP().addText("\n\nYou see the color drain out of Terrence's face. And you get blasted with"
							+ " approximately one can full of pepper spray.");
					waitForInput();
					g.getGP().addText("\n\nIf you were a Class Four, he'd have probably gotten away, but your psychic"
							+ " powers have a pretty good reach.");
					waitForInput();
					g.getGP().addText("\n\nYou have now killed one janitor.");
					waitForInput();
					g.getGP().addText("\n\n1: Loot the body!");
					g.getGP().addText("\n2: Get the heck away before someone sees you");
					g.getGP().addText("\nWhat will you do? ");
					waitForInput();
					response = g.getGP().getResponse();
					if(response.equals("1")) {
						g.getGP().addText("\n\nIn his pocket, you find one bottle of caffine pills and a couple of food bars.");
						waitForInput();
					}
					g.getGP().addText("\n\nI'm pretty sure you just committed a hate crime against non psychics. Rather than"
							+ " waste my time lecturing you on your awful sense of morality, I will just say that the point"
							+ " of this game was to form friendships, and you have just done the exact opposite of that.");
					waitForInput();
					points[4] = 0;
					return;
				}
			}
			g.getGP().addText("\n\nYou both head down the empty street. Terrence seems a lot quieter now, but it's probably just"
					+ " because you're alone outside in the dead of night.");
			waitForInput();
			g.getGP().addText("\n\nEventually, you get to his apartment and he unlocks the door. \"It's pretty late. We should"
					+ " both get some sleep.\"");
			waitForInput();
			g.getGP().addText("\n\nHe starts to close the door, but then he pauses. \"Would you mind giving me a quick call when"
					+ " you get home, just so I know you made it all right?\" he asks. \"I-I mean, obviously no one would dare"
					+ " attack you, but, er, just in case?\"");
			waitForInput();
			g.getGP().addText("\n\nYou trade numbers and then head for home. The brightest stars are visible above you, and all"
					+ " seems right with the world.");
			points[4] = 4;
			waitForInput();
		} catch (InterruptedException e) {}
	}
	public static void endTer(Visuals g, String name) {
		try {
			g.getGP().addText("\n\n\"Hey! Get away from them!\" You and the monster both turn, surprised, and see Terrence. He's"
					+ " brandishing a broom and standing next to Misty, who is surrounded by fluttering white butterflies.");
			waitForInput();
			g.getGP().addText("\n\nYou have to admit, your rescue party is kind of underwhelming.");
			waitForInput();
			g.getGP().addText("\n\nThis opinion, of course, immediately changes once those butterflies swarm the attacking monster,"
					+ " latching onto it and biting it until it howls. The good janitor stares awkwardly at that Misty girl,"
					+ " but he turns to you. \"Are you all right, " + name + "?\" he asks.");
			waitForInput();
			g.getGP().addText("\n\nWhen your answer is affirmative, he grabs you with one hand and Misty with the other, and the three"
					+ " of you take off running. He knows his way around, luckily, and soon you are all free.");
			waitForInput();
			g.getGP().addText("\n\nThe escape is bittersweet, however. When you reach the surface and Misty chirps her goodbye, you wonder"
					+ " if you will ever see her again. You wonder where in this vast world she might be going.");
			waitForInput();
			g.getGP().addText("\n\nTerrence seems to share your feelings. He turns to you and gives a little half smile, trying to"
					+ " lighten the sadness. You return it. Misty may be gone, but at least you still have Terrence.");
			waitForInput();
			g.getGP().addText("\n\nAnd honestly, you wouldn't have it any other way.");
		} catch (InterruptedException e) {}
	}
	public static void day1MonsterPath(Visuals g, int[] points, int[] daysSpent) {
		daysSpent[2]++;
		try {
			g.getGP().addText("\n\nYou wander down the halls, noting all the snouts and toothy grins that seem to jump"
					+ " out from every wall. The cages that line the hallway are filled with prowling, pacing, and growling"
					+ " beasts. Unsettled, you speed up without really knowing it. Suddenly, the ground is rushing towards you.");
			waitForInput();
			g.getGP().addText("\n\nSome impression you're making. Having tripped and fallen flat on your face, you feel less"
					+ " embarrased and more scraped up. Scratch that. Somebody's laughing at you. Now you're embarrased.");
			waitForInput();
			g.getGP().addText("\n\nYou look up. There's a monster pointing at you. Two, to be precise. Both of them are in cages,"
					+ " but it's still unnerving. The one that looks more human sees you dust yourself off and doubles over,"
					+ " laughing. \"Prismec!\" the other monster complains, \"You have no manners whatsoever! The poor little"
					+ " sweetie could be seriously hurt!\"");
			waitForInput();
			g.getGP().addText("\n\nThis monster puts her hands together and smiles at you. \"I am so sorry about her!\" she"
					+ " exclaims. \"You're new here, aren't you? I'll have to introduce myself! I'm Merina, princess of the mer"
					+ " people!\" Her voice is bubbly and cheerful.");
			waitForInput();
			g.getGP().addText("\n\nPrismec makes a remark that you're pretty sure is incredibly offensive to all of ocean life, but the fish"
					+ " princess prattles on. \"...and of course, Spinner didn't--you know Spinner, don't you? The spider monster?"
					+ " Well, Spinner didn't care...\" You're not entirely sure how the conversation got to this point. She finally"
					+ " notices how agape your mouth is and pauses for a second. \"Oh goodness! I must be prattling on! You have a"
					+ " job to get back to, don't you? Oh wait, your job is to talk to me?\" She giggles. \"I'll carry on, then!\""
					+ " And this is exactly what she does.");
			waitForInput();
		} catch (InterruptedException e) {}
		points[2]++;
	}
	public static void day2MonsterPath(Visuals g, int[] points, int[] daysSpent, String name) {
		daysSpent[2]++;
		String response = "0";
		try {
			g.getGP().addText("\n\nThe moment you show up, Merina starts chattering away. \"Hi there! How was your walk over here?"
					+ " I've been thinking about starfish. Did you know that there are over 400 types of starfish in the tide pools"
					+ " alone? That is just fintastic, I think. I once saw one with twenty four arms!\"");
			waitForInput();
			g.getGP().addText("\n\n\"I love starfish! They have so many uses! You can stew them, wear them in your hair, decorate"
					+ " your dresses...you can even have them as pets! They're really boring, though. One of my sisters once had"
					+ " a pet starfish that...\"");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Keep listening");
				g.getGP().addText("\n2: Interrupt");
				g.getGP().addText("\nWhat will you do? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\n\"...she trained to shovel sand! She also had four pet sea urchins! My sister did, I mean."
						+ " Not the starfish, of course!");
				waitForInput();
				g.getGP().addText("\n\n\"I have two hundred sisters and one hundred ninety two brothers besides her, though! And one"
						+ " of them is here, of all places! Have you met Sirena yet? She looks a lot like me, but I think I have"
						+ " prettier hair. Don't tell her, though! She gets so jealous...\"");
				waitForInput();
				g.getGP().addText("\n\nIt's interesting to hear all about Merina's highly extended family. She even has some good stories"
						+ " in among the happy chattering. You really enjoy your work.");
				points[2]++;
			}
			else {
				g.getGP().addText("\n\nYou cough and try to get a word in. \"Er, that's a great story you're telling, but I really"
						+ " have to interview some monsters, Merina,\" you say.");
				waitForInput();
				g.getGP().addText("\n\n\"Oh! Silly me! I completely forgot that you had a job to get back to!\" She giggles."
						+ " \"I once had a job where I sorted sea shells! I know I'm a princess, but-\"");
				waitForInput();
				g.getGP().addText("\n\n\"For the love of all that you can find crawling underneath a sandwich, can you please"
						+ " just shut up?!\"");
				waitForInput();
				g.getGP().addText("\n\nIt's the other monster who says this. She has her hands pressed over her ears and she looks"
						+ " about ready to kill someone. Probably Merina. \"Great Ixhara! I'd think a mer-ditz like you wouldn't have"
						+ " enough brainpower to think, let alone speak, but here I am, stuck with the chattiest cell neighbor in"
						+ " all the multiverse!\"");
				waitForInput();
				g.getGP().addText("\n\nMerina looks about ready to cry. True, she is a chatterbox, but it's still kind of sad.");
				waitForInput();
				do {
					g.getGP().addText("\n\n1: Comfort the mermaid");
					g.getGP().addText("\n2: Well, she was pretty annoying");
					g.getGP().addText("\nWhat will you do? ");
					waitForInput();
					response = g.getGP().getResponse();
				} while(!response.equals("1") && !response.equals("2"));
				g.getGP().addText(response);
				if(response.equals("1")) {
					g.getGP().addText("\n\nYou flash Prismec a cross look and turn to Merina. \"Just ignore her,\" you advise the mermaid."
							+ " \"I liked your story.\"");
					waitForInput();
					g.getGP().addText("\n\n\"You do?\" Merina asks, sniffling slightly. She perks up. \"Oh thank goodness! I was afraid I"
							+ " was chatting your ear slits off! I just love to talk! One time, I was talking with...\"");
					waitForInput();
					g.getGP().addText("\n\nYou cannot help but shrug. This probably counts as an interview, at least. By the time"
							+ " you go to lunch, Merina is still chatting away.");
					points[2]++;
				}
				else {
					daysSpent[3]++;
					g.getGP().addText("\n\n\"Yeesh, at least someone has a brain around here,\" the other monster sneers. She"
							+ " turns to you. \"I'm Prismec. You have a name? " + name + ", huh? That's kinda cute. Don't go"
							+ " prancin' around thinkin' you're so great, though.\"");
					waitForInput();
					g.getGP().addText("\n\nShe tosses her head and in a smooth sweep, her hair turns neon pink. \"You're still here? Whatcha"
							+ " waiting for, a kiss?\" She smirks and folds her arms. \"I like you, kay? Now get outta here.\"");
					points[3]++;
				}
				waitForInput();
			}
		} catch (InterruptedException e) {}
	}
	public static void day3MonsterPath(Visuals g, int[] points, int[] daysSpent) {
		daysSpent[2]++;
		String response = "0";
		int prisPoints = 0;
		int merPoints = 0;
		try {
			g.getGP().addText("\n\nYou find your two monstrous acquaintences. \"Heloooooooo!\" Merina squeals happily.");

			waitForInput();


			if(points[3] >= 1) {
				g.getGP().addText("\n\nPrismec rolls her eyes, but the corners of her mouth turn up at you.");
				waitForInput();
			}
			g.getGP().addText("\n\n\"...and I can't believe it, but Shelldon, he's my brother, asked me to be the codmother of his"
					+ " second child! Me, of all mer people!\"");
			waitForInput();
			g.getGP().addText("\n\n...Of course, Merina's talking again.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Well, I want to hear this");
				g.getGP().addText("\n2: Quietly comment to Prismec");
				g.getGP().addText("\nWhat will you do? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\n\"...so he asked me to pick out an outfit for the baby! But I just couldn't decide between"
						+ " the red sea silk or the green!\"");
				waitForInput();
				g.getGP().addText("\n\nShe pauses suddenly and looks at you. \"Which one do you like better?\"");
				waitForInput();
				g.getGP().addText("\n\nShe's...she's actually waiting for you to speak.");
				waitForInput();
				do {
					g.getGP().addText("\n\n1: Red");
					g.getGP().addText("\n2: Green");
					g.getGP().addText("\nWhat will you say? ");
					waitForInput();
					response = g.getGP().getResponse();
				} while(!response.equals("1") && !response.equals("2"));
				g.getGP().addText(response);
				if(response.equals("1")) {
					g.getGP().addText("\n\n\"Oooooooh, lovely! I once saw a red sea anemome, you know? It had red swirls and red...\"");
				}
				else {
					g.getGP().addText("\n\n\"I like that, too! It reminds me of kelp! Kelp has so many uses, like...\"");
				}
				waitForInput();
				g.getGP().addText("\n\nHours later:");
				waitForInput();
				g.getGP().addText("\n\n\"...Well, anyway, I can't wait to see the baby!\" She smiles happily and folds her hands."
						+ " \"Well, I'm all storied out for today.\" She plops down with a squelching sound.");
				waitForInput();
				g.getGP().addText("\n\nYou've almost forgotten the concept of silence. It's fairly alarming.");
				waitForInput();
				g.getGP().addText("\n\nMaybe you should tell her a story.");
				waitForInput();
				g.getGP().addText("\n\nWhat type of story is this?");
				do {
					g.getGP().addText("\n\n1: Science fiction");
					g.getGP().addText("\n2: Fantasy");
					g.getGP().addText("\n3: A lecture");
					g.getGP().addText("\nWhat will you say? ");
					waitForInput();
					response = g.getGP().getResponse();
				} while(!response.equals("1") && !response.equals("2") && !response.equals("3"));
				g.getGP().addText(response);
				if(response.equals("2")) {
					merPoints ++;
				}
				g.getGP().addText("\n\nWhat's the setting?");
				do {
					g.getGP().addText("\n\n1: An undersea kingdom");
					g.getGP().addText("\n2: A palace in the sky");
					g.getGP().addText("\n3: Antarctica");
					g.getGP().addText("\nWhat will you say? ");
					waitForInput();
					response = g.getGP().getResponse();
				} while(!response.equals("1") && !response.equals("2") && !response.equals("3"));
				g.getGP().addText(response);
				if(response.equals("1")) {
					merPoints ++;
				}
				g.getGP().addText("\n\nWho is the main character?");
				do {
					g.getGP().addText("\n\n1: A plucky young sea turtle");
					g.getGP().addText("\n2: A spirited finch");
					g.getGP().addText("\n3: A farmer");
					g.getGP().addText("\nWhat will you say? ");
					waitForInput();
					response = g.getGP().getResponse();
				} while(!response.equals("1") && !response.equals("2") && !response.equals("3"));
				g.getGP().addText(response);
				if(response.equals("1")) {
					merPoints ++;
				}
				g.getGP().addText("\n\nMerina is entranced by your story. The moment you finish, the only thing breaking the silence"
						+ " is the sound of wet, squelching applause.");
			}
			else {
				daysSpent[3]++;
				g.getGP().addText("\n\nVery quietly, you whisper to the monster next to you. \"She really talks a lot,\" you admit."
						+ " Prismec slams her fist into her face.");
				waitForInput();
				g.getGP().addText("\n\n\"Hey Mer-ditz! The human over here wants you to shut your big fat fish mouth!\" she yells.");
				waitForInput();
				g.getGP().addText("\n\nMerina looks at you with wide, glassy eyes and then bursts into tears.");
				waitForInput();
				g.getGP().addText("\n\n\"Just shut it, won't you?!\" Prismec covers her ears for a moment and then remembers you."
						+ " \"As you can see, I live in a mad house with the idiot queen. Interview me.\"");
				waitForInput();
				g.getGP().addText("\n\nWell, it is your job.");

				waitForInput();
				g.getGP().addText("\n\nQuestion 1");

				waitForInput();
				g.getGP().addText("\n\n\"What kind of a monster are you, anyway?\" you ask.");
				waitForInput();
				g.getGP().addText("\n\nPrismec flips her hair and it, along with the rest of her body, turns into bronze scales."
						+ " \"A shapeshifter, can't you tell?\" she grins. \"Any other questions?\"");
				waitForInput();
				g.getGP().addText("\n\nActually, yes.");
				waitForInput();
				g.getGP().addText("\n\nQuestion 2");
				do {
					g.getGP().addText("\n\n1: What do you do for fun?");
					g.getGP().addText("\n2: What is your favorite food?");
					g.getGP().addText("\n3: What is the scientific name of your species?");
					g.getGP().addText("\nWhat will you say? ");
					waitForInput();
					response = g.getGP().getResponse();
				} while(!response.equals("1") && !response.equals("2") && !response.equals("3"));
				g.getGP().addText(response);
				if(response.equals("1")) {
					g.getGP().addText("\n\nShe kicks back against the wall. \"I mess with people.\"");
					prisPoints ++;
				}
				else {
					g.getGP().addText("\n\n\"I dunno. Stuff.\" She rolls her eyes. \"Are all your questions this boring?\"");
				}
				waitForInput();
				g.getGP().addText("\n\nQuestion 3");
				do {
					g.getGP().addText("\n\n1: Do you ever go on the internet?");
					g.getGP().addText("\n2: Are you friends with any of the monsters here?");
					g.getGP().addText("\n3: What is the meaning of life?");
					g.getGP().addText("\nWhat will you say? ");
					waitForInput();
					response = g.getGP().getResponse();
				} while(!response.equals("1") && !response.equals("2") && !response.equals("3"));
				g.getGP().addText(response);
				if(response.equals("1")) {
					g.getGP().addText("\n\n\"Like heck, yes. If you ever come across anything written by LOLiHax, do me a favor and"
							+ " give it a like, will ya?\"");
					prisPoints++;
				}
				else if (response.equals("2")) {
					g.getGP().addText("\n\n\"Like Merina? No,\" she scoffs and folds her arms. \"Eh, I guess her sis, Sirena, isn't"
							+ " that bad, though. And I don't mind hanging with Spinner, even though his memes suck.\"");
					waitForInput();
					g.getGP().addText("\n\nHuh, that's odd. Both of those monsters live at just about the other end of this complex."
							+ " You can see how gossip gets around, but hanging out is a little different. Maybe it was just bad"
							+ " word choice on her part.");
					prisPoints++;
				}
				else {
					g.getGP().addText("\n\nShe blinks. \"Is this some kind of joke?\"");
				}
				waitForInput();
				g.getGP().addText("\n\nQuestion 4");
				do {
					g.getGP().addText("\n\n1: Do you eat people?");
					g.getGP().addText("\n2: You mentioned Great Ixhara. Who is that?");
					g.getGP().addText("\n3: Will you be my BEST FRIEND FOREVER AND EVER AND EVER?");
					g.getGP().addText("\nWhat will you say? ");
					waitForInput();
					response = g.getGP().getResponse();
				} while(!response.equals("1") && !response.equals("2") && !response.equals("3"));
				g.getGP().addText(response);
				if(response.equals("1")) {
					g.getGP().addText("\n\n\"Um, no. I prefer transforming into a pidgeon and defecating on their heads. I can"
							+ " always make an exception for you, though.\"");
					waitForInput();
					g.getGP().addText("\n\nShe smiles. You honestly can't tell if she's joking or being serious.");
					prisPoints ++;
				}
				else if(response.equals("2")) {
					g.getGP().addText("\n\n\"A giant ball of light that'll melt your face off if you look at it. Is there a better"
							+ " deity in the multiverse?\"");
					prisPoints ++;
				}
				else {
					g.getGP().addText("\n\n\"Looks like someone learned their social skills,\" she smirks. \"You'll have to work a little"
							+ " harder for that one, kiddo. Try chatting with someone more on your level, like Merina here.\"");
				}
				waitForInput();
				g.getGP().addText("\n\nThat seems like enough questioning for today.");
			}
			waitForInput();
			if(merPoints >= 2)
				points[2]++;
			else if(prisPoints >= 2)
				points[3]++;
		} catch (InterruptedException e) {}
	}
	public static void day4MerPath(Visuals g, int[] points, int[] daysSpent) {
		daysSpent[2]++;
		try {
			g.getGP().addText("\n\n\"I have a new gaaaaaaaaaame!\"");
			waitForInput();
			g.getGP().addText("\n\nHere you find yourself, interviewing Merina again.");
			waitForInput();
			g.getGP().addText("\n\nHonestly, at this point, you aren't even interviewing monsters anymore. You're just listening"
					+ " to her talk on and on and on and on.");
			waitForInput();
			g.getGP().addText("\n\nThis friendship thing is getting weird.");
			waitForInput();
			g.getGP().addText("\n\nMerina grins on, oblivious to whatever you may or may not be thinking. \"Let's plaaaaay!\"");
			waitForInput();
			g.getGP().addText("\nI need you to give me a noun: ");
			waitForInput();
			String noun = g.getGP().getResponse();
			g.getGP().addText("\nNow an adjective: ");
			waitForInput();
			String adj = g.getGP().getResponse();
			g.getGP().addText("\nAnd a verb: ");
			waitForInput();
			String verb = g.getGP().getResponse();
			g.getGP().addText("\n\nShe giggles. \"I have a story for you!\"");
			waitForInput();
			g.getGP().addText("\n\n\"Once upon a time, there was a " + adj + "  trout who loved to swim. It decided that it was going"
					+ " to enter a swimming contest! It packed its favorite " + noun + "  and went to the stadium. There were"
					+ " a lot of other fish there! But our hero could " + verb + "  faster than all of them, and it won! Yay!\"");
			waitForInput();
			g.getGP().addText("\n\n...");
			waitForInput();
			g.getGP().addText("\n\n...");
			waitForInput();
			g.getGP().addText("\n\nI rate this story 10 out of 10.");
			waitForInput();
			points[2]++;
		} catch (InterruptedException e) {}
	}
	public static void day5MerPath(Visuals g, int[] points) {
		try {
			g.getGP().addText("\n\nMerina is so great. You love hearing her talk and you wish you could hear her even more.");
			waitForInput();
			g.getGP().addText("\n\nYou dream about it every night.");
			waitForInput();
			g.getGP().addText("\n\nYou have even made a mixtape of her lecture on kelp.");
			waitForInput();
			g.getGP().addText("\n\nKelp is green. K-k-kelp is green.");
			waitForInput();
			g.getGP().addText("\n\nI hope that you get more sleep than I do.");
			waitForInput();
			points[2] ++;
		} catch (InterruptedException e) {}
	}
	public static void endMer(Visuals g) {
		String response = "0";
		try {
			g.getGP().addText("\n\n\"Helooooooooooo-eeeek!\" Merina gasps, calling to you from the other end of the room.");
			waitForInput();
			g.getGP().addText("\n\nThe monster turns to her and growls. She shrieks, and you cover your ears against the sound.");
			waitForInput();
			g.getGP().addText("\n\nAnd then the whole place is flooded with water.");
			waitForInput();
			g.getGP().addText("\n\n\"Daddyyyyyyyyyyy!\"");
			waitForInput();
			g.getGP().addText("\n\nAnd there he is, the sea king himself. This rescue party sure is something.");
			waitForInput();
			g.getGP().addText("\n\nThe sea king makes a squeaking sound like a dolphin. Merina and her several hundred siblings"
					+ " shoal around him.");
			waitForInput();
			g.getGP().addText("\n\n\"Thou hath saveth my daughter!\" the sea king yells. You didn't actually save her, but okay."
					+ " \"You may now choose to stay on the land or live under the sea!\"");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: I want to sea this");
				g.getGP().addText("\n2: Land 4 life");
				g.getGP().addText("\nWhat will you say? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\n\"If you are to live among us, you must have a tail!\" the sea king bawls. You clap slowly.");
				waitForInput();
				g.getGP().addText("\n\nHe slaps you in the face with a magic piece of kelp. Light envelops your body. You look down and"
						+ " yes, you are now the owner of a large, bushy squirrel tail. All of your dreams have come true. All of them.");
				waitForInput();
				g.getGP().addText("\n\nYou enjoy your new life as a magical mer-squirrel. You make lots of friends and on Merina's"
						+ " birthday, you get her a wall. She loves it and talks to it every day.");
			}
			else {
				g.getGP().addText("\n\n\"Then goodbye!\" Merina blows you a quick, fishy kiss as she and her father disappear under the"
						+ " churning waves.");
				waitForInput();
				g.getGP().addText("\n\nThe sea king summons an angel whale to fly you back to the surface. It has anime eyes and its"
						+ " whole body is bright pink. You have decided that you want to name it Frederick, in honor of nothing.");
				waitForInput();
				g.getGP().addText("\n\nThe joy.");
			}
		} catch (InterruptedException e) {}
	}
	public static void day4PrisPath(Visuals g, int[] points, int[] daysSpent, String name) {
		daysSpent[3]++;
		try {
			g.getGP().addText("\n\n\"Hey. Hey, person. " + name + " , I'm talking to you. Come'ere.\" Prismec is calling you over.");
			waitForInput();
			g.getGP().addText("\n\n\"I heard about this really old and awful game the other day,\" she says. \"I need someone"
					+ " to play it with me so I can see how stupid it is.\"");
			waitForInput();
			boolean guessed = false;
			int guess;
			int count = 0;

			g.getGP().addText("\nPick an upper bound number or something.\"Upper bound: ");
			int upperBound = Integer.parseInt(g.getGP().getResponse());
			if(upperBound <= 100) {
				g.getGP().addText("\n\nNot so very quietly, Prismec whispers, \"Lightweight.\"");
				waitForInput();
			}
			g.getGP().addText("\n\n\"Great. I'm thinking of a number between 0 and " + upperBound + " .\"");
			waitForInput();
			int target = (int)(Math.random()*upperBound);
			g.getGP().addText("\nGuess it: ");
			guess = Integer.parseInt(g.getGP().getResponse());

			while(!guessed) {
				count += 1;
				if(Math.abs(guess - target) < 0.001) {
					guessed = true;
					break;
				}
				else if (guess > target)
					g.getGP().addText("\n\nNope, too high.");
				else
					g.getGP().addText("\n\nNah, too low.");
				g.getGP().addText("\nGuess it: ");
				waitForInput();
				guess = Integer.parseInt(g.getGP().getResponse());
				g.getGP().addText(""+guess);
			}
			g.getGP().addText("\n\n\"Yep! It only took you a full " + count + "  guesses.\"");

			waitForInput();
			g.getGP().addText("\n\nPrismec shrugs. \"Meh, I'd give it a 2 outta 10. Let's say we never play this again?\"");
			waitForInput();
			g.getGP().addText("\n\nThe two of you proceed to spend the next hour guessing numbers. It's ironic and hilarious.");
			waitForInput();
		}catch (InputMismatchException e) {
			g.getGP().addText("\n\nNumbers only.");
		}
		catch (InterruptedException e) {}
		points[3]++;
	}
	public static void day5PrisPath(Visuals g, int[] points) {
		String response = "0";
		try {
			g.getGP().addText("\n\nAh, there's your shapeshifting friend. Merina's pen is open, and you recall hearing that she"
					+ " was going to get tested today. It looks like it's just you and Prismec today.");
			waitForInput();
			g.getGP().addText("\n\n\"Why did the flower put on glasses?\"");
			waitForInput();
			g.getGP().addText("\n\nYou ask why.");
			waitForInput();
			g.getGP().addText("\n\n\"It wanted to seed the world.\"");
			waitForInput();
			g.getGP().addText("\n\nYou and Prismec both decide that top quality jokes are unfortunately a rare breed these days.");
			waitForInput();
			g.getGP().addText("\n\nShe stretches for a moment, and suddenly, she looks unsure of herself.");
			waitForInput();
			g.getGP().addText("\n\n\"Look, I know this is gonna sound stupid, but we're really trying to make this friendship"
					+ " thing work, right?\"");
			waitForInput();
			g.getGP().addText("\n\nYou nod. Friendship is the point of the game, right?");
			waitForInput();
			g.getGP().addText("\n\n\"Good.\"");
			waitForInput();
			g.getGP().addText("\n\n\"Tbh, I was getting kinda worked up about this.\" Her outline flickers, and suddenly she's a"
					+ " perfect copy of you. \"Tell me honestly, though, can I trust you?\"");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Yes");
				g.getGP().addText("\n2: No");
				g.getGP().addText("\nWhat will you say? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("2")) {
				g.getGP().addText("\n\n\"Wow. K then.\" That's all she says.");
				waitForInput();
				g.getGP().addText("\n\nBrutal honesty might not be the greatest strategy the next time around.");
				waitForInput();
				return;
			}
			g.getGP().addText("\n\n\"And I'm supposed to take your word for it,\" she snorts. \"Whatevs. I can kill you"
					+ " in about two secs if you tell on me.\"");
			waitForInput();
			g.getGP().addText("\n\nYou're pretty sure she isn't joking about this.");
			waitForInput();
			g.getGP().addText("\n\n\"Okay. I need to tell you something.\"");
			waitForInput();
			g.getGP().addText("\n\nShe takes a deep breath.");
			waitForInput();
			g.getGP().addText("\n\n\"Is it that you actually aren't as cool as you try to be, and this is all a facade that masks"
					+ " the deep feelings of insecurity that haunt the darkest parts of your mind and bring up memories of"
					+ " your tragic and unrevealed backstory?\"");
			waitForInput();
			g.getGP().addText("\n\nPrismec blinks at you. \"Um, that was philosophical, but no,\" she says.");
			waitForInput();
			g.getGP().addText("\n\n\"I was just gonna say that I can get out of my cage, and I was wondering if you'd like to"
					+ " hang out some time, irl.\"");
			waitForInput();
			g.getGP().addText("\n\nHuh. There goes your theory.");
			waitForInput();
			g.getGP().addText("\n\nPrismec shape shifts into a flea and squeezes through a tiny, almost invisible crack in the side"
					+ " of the wall. There's a small pop, and then a violet-haired girl is at your side. Her outfit has changed"
					+ " from jeans and a tank top to a T-shirt and skirt. \"I just wasn't feeling that look anymore,\" she shrugs.");
			waitForInput();
			g.getGP().addText("\n\nShe leans against the wall. \"So, I'm bored. What now?\"");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Let us engage in an activity together. One that is hip for the kids, like pranking.");
				g.getGP().addText("\n2: How the hay did you figure out how to get out and why have you not run away by now?");
				g.getGP().addText("\nWhat will you say? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("2")) {
				g.getGP().addText("\n\n\"Um, this have you ever tried containing a shape shifter? I figured this out, like, two"
						+ " days after coming here.\" She picks at her nail. \"It's free rent, even if Merina sucks.\"");
				waitForInput();
				g.getGP().addText("\n\nShe shrugs. \"I'm bored. Let's go prank someone.\"");
			}
			else {
				g.getGP().addText("\n\n\"I like your style.\"");
			}
			waitForInput();
			g.getGP().addText("\n\nPrismec creeps down the hall. She turns back to make sure you're following, and her clothes"
					+ " melt into those of a Class Four. She grins.");
			waitForInput();
			g.getGP().addText("\n\nThe hall branches just up ahead. Prismec produces a spool of thread and hands you one end of"
					+ " it. \"Tape it to the wall on your side,\" she instructs you, measuring about a foot above the ground."
					+ " You construct the tripwire and hide off to the side with the monster girl.");
			waitForInput();
			g.getGP().addText("\n\nSomeone's coming.");
			waitForInput();
			g.getGP().addText("\n\nHeart pounding in anticipation, you peek out to see who it is, and oh gosh, it's a Class Three"
					+ " researcher. Her arms are laden with a small cage, in which rests a fuzzy monster.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Divert her path so she doesn't trip");
				g.getGP().addText("\n2: Watch the magic happen");
				g.getGP().addText("\nWhat will you do? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\n\"Hi! Excuse me, but I think someone was looking for...\" You glare at Prismec and she"
						+ " rolls her eyes but disables the trap. The Class Three looks at you, a little confused, and waits"
						+ " for you to continue.");
				waitForInput();
				g.getGP().addText("\n\n\"Never mind.\"");
				waitForInput();
				g.getGP().addText("\n\nThe Class Four gives you a funny look, but seems to realize you meant no harm. After a"
						+ " quick little shrug, she adjusts her burden and continues on her way.");
				waitForInput();
				g.getGP().addText("\n\nTo your surprise, Prismec doesn't tease you about this.");
			}
			else {
				g.getGP().addText("\n\nThe Class Four is completely oblivious to the trap. She walks right into it, and the crash"
						+ " is glorious.");
				waitForInput();
				g.getGP().addText("\n\nThe fuzzy monster squeaks furiously and scampers free. While you wonder if you've just"
						+ " become the start of a massive breakout, Prismec siezes your arm and pulls you out of there. You"
						+ " run until you're out of breath.");
				waitForInput();
				g.getGP().addText("\n\n\"Look, no worries. It was just a phase mole. Harmless even to squishy lil humans,\""
						+ " Prismec assures you.");
			}
			waitForInput();
			g.getGP().addText("\n\nIt's fairly quiet now.");
			waitForInput();
			g.getGP().addText("\n\nPrismec plops down on the floor and pats the space next to her. You sit down.");
			waitForInput();
			g.getGP().addText("\n\nShe crosses her legs and stretches, and then uncrosses them. \"You tired?\" she asks.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Yeah");
				g.getGP().addText("\n2: Nope");
				g.getGP().addText("\nWhat will you say? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\n\"Same here.\" She glances over at you and shakes her head, giving you a half smile. \"And"
						+ " still bored. Great life, isn't it?\"");
			}
			else {
				g.getGP().addText("\n\n\"Lucky you, then.\" She yawns. \"Guess I'm the lightweight now.\"");
			}
			waitForInput();
			g.getGP().addText("\n\nShe scooches a little closer to you and folds her arms behind her back. \"Wanna talk about,"
					+ " I dunno, life and stuff?\"");
			waitForInput();
			g.getGP().addText("\n\nThat's a topic that never runs dry.");
			waitForInput();
			g.getGP().addText("\n\n\"I guess you kinda already interviewed me, though. Must be a fun job, talking with folks all"
					+ " day. 'slong as the folks are interesting.\"");
			waitForInput();
			g.getGP().addText("\n\nTrue.");
			waitForInput();
			g.getGP().addText("\n\n\"I guess if I were to have a job, I'd rather have one that lets me go places. There's a big"
					+ " world out there. It's a cool place to see.\"");
			waitForInput();
			g.getGP().addText("\n\nHonestly, you haven't given much thought to traveling the world. With all the monsters,"
					+ " it doesn't strike you as the safest thought.");
			waitForInput();
			g.getGP().addText("\n\n\"Eh, it's actually way less romantic than it sounds. I mean, it looks all cool, and at first"
					+ " everything's different and new, but after a while, it gets kind of repetative. Traveling the world!\" she"
					+ " says in a dramatic voice. \"Seeing the sights! Getting sore feet!\" She starts to laugh.");
			waitForInput();
			g.getGP().addText("\n\nOkay.");
			waitForInput();
			g.getGP().addText("\n\nPrismec turns away. She's starting to look tired. \"I dunno, maybe the problem's with me,\""
					+ " she shrugs.");
			waitForInput();
			g.getGP().addText("\n\n\"Maybe I do have confidence issues.\"");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Girl, you are 100 percent uncool. All your insecurities are real.");
				g.getGP().addText("\n2: Well, for the record, I think you're cool.");
				g.getGP().addText("\nWhat will you say? ");
				waitForInput();;
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\nShe laughs. \"You sure know how to make someone feel better. 10 out of 10 for social"
						+ " skills,\" she rolls her eyes.");
			}
			else {
				g.getGP().addText("\n\nShe mutters something about \"stupid sentimental humans.\" The look on her face doesn't"
						+ " match her words, though.");
				waitForInput();
				g.getGP().addText("\n\nShe takes your hand and squeezes it lightly. \"Thanks. Really.\"");
			}
			waitForInput();
			g.getGP().addText("\n\nPrismec is looking really tired. She morphs into a cat and crawls onto your lap.");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Pet her");
				g.getGP().addText("\n2: Leave the cat be");
				g.getGP().addText("\nWhat will you do? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("1")) {
				g.getGP().addText("\n\nYou stroke her gently. She rolls over and purrs. \"Ah, that's the spot.\"");
				waitForInput();
			}
			g.getGP().addText("\n\nPrismec looks up at you and gives you half a smile. \"Why did the chicken cross the road?\"");
			waitForInput();
			g.getGP().addText("\n\nYou ask why.");
			waitForInput();
			g.getGP().addText("\n\n\"To get to the idiot's house.\" She shifts to get a little more comfortable. \"Knock knock.\"");
			waitForInput();
			g.getGP().addText("\n\nYou ask for the identity of who is there.");
			waitForInput();
			g.getGP().addText("\n\n\"The chicken.\"");
			waitForInput();
			g.getGP().addText("\n\nI'd rate that at least a 7 out of 10.");
			waitForInput();
			g.getGP().addText("\n\nEventually, you realize you've been sitting there for a while. It probably wouldn't be the"
					+ " easiest thing to explain if someone were to walk by and see you. You nudge Prismec, and she gets up"
					+ " reluctantly. \"We'll have to do this again sometime,\" she says. \"See who can come up with the worst"
					+ " joke.\"");
			waitForInput();
			g.getGP().addText("\n\nYou walk away with a little extra spring in your step.");
			waitForInput();
		}catch(InterruptedException e) {}
		points[3]++;
	}
	public static void endPris(Visuals g) {
		g.getGP().addText("\n\n\"Hey, dirtbag! That's MY human, you know?\"");
		try {
			waitForInput();
			g.getGP().addText("\n\nAt the other side of the room, a larger canine monster is growling. Your attacker's ears go down"
					+ " and it backs away. Now it's just you and the bigger beast.");
			waitForInput();
			g.getGP().addText("\n\nYou're out of the frying pan and into the fire, as the older folks say.");
			waitForInput();
			g.getGP().addText("\n\n\"Oh, quit cowering and get up. What are you, an idiot?\"");
			waitForInput();
			g.getGP().addText("\n\nThe beast shudders and melts into the form of a girl with short, pink hair. It is Prismec, the"
					+ " one and only.");
			waitForInput();
			g.getGP().addText("\n\n\"Remind me why I'm stopping to save you?\"");
			waitForInput();
			g.getGP().addText("\n\nRemind yourself why you became friends with her.");
			waitForInput();
			g.getGP().addText("\n\nAnyway, Prismec rolls her eyes and grins at you. \"Well, well. It looks like SOME damsel's"
					+ " in distress. You're lucky I happened to be in town, kiddo. Now come on, let's get outta this mess.\"");
			waitForInput();
			g.getGP().addText("\n\nShe turns into one heck of a mare and tosses her rainbow mane. \"Do you ride? No? First"
					+ " time for everything, then,\" she snorts.");
			waitForInput();
			g.getGP().addText("\n\nYou climb on, and Prismec more or less charges up a hundred flights of stairs. Daylight is streaming"
					+ " through some of the wider cracks in the ceiling, and you're beginning to wonder if Prismec has any idea what"
					+ " she's going to do when she gets to the surface. \"I'm winging this, kid,\" she says.");
			waitForInput();
			g.getGP().addText("\n\nAs you burst through the final floor, electric blue wings erupt from Prismec's equine back"
					+ " and she shoots into the sky. Cries, stares, and quite a few bullets follow you up for a few seconds,"
					+ " and then you are free.");
			waitForInput();
			g.getGP().addText("\n\nYou have to admit, this is quite a ride.");
		}catch (InterruptedException e) {}
	}
	public static void startBlinkPath(Visuals g) {
		String response = "0";
		int points = 0;
		try {
			g.getGP().addText("\n\nA shadow falls across the ground, and the attacking monster suddenly seems a lot less threatening."
					+ " It whimpers softly and slinks away. You, however, are not quite as fast.");
			waitForInput();
			g.getGP().addText("\n\nAn invisible hand siezes you around the middle and lifts you into the air. There's a gray disk"
					+ " floating in front of you. Not a disk, but a face. It has three small indentations that you take to be eyes"
					+ " and no distinct features besides them. It regards you with what seems to be boredom and then sets you down."
					+ " \"No, I suppose I won't kill you just yet,\" it sighs.");
			waitForInput();
			g.getGP().addText("\n\nThat's reassuring.");
			waitForInput();
			g.getGP().addText("\n\n\"I am going to get straight to business, so do not waste my time,\" it says. \"I am Blink, I can"
					+ " move and see through six dimensions simultaneously, and yes, I am the one responsible for setting all these"
					+ " monsters free. Now, can we get this interview started?\"");
			waitForInput();
			do {
				g.getGP().addText("\n\n1: Yes");
				g.getGP().addText("\n2: What is going on?");
				g.getGP().addText("\nWhat will you say? ");
				waitForInput();
				response = g.getGP().getResponse();
			} while(!response.equals("1") && !response.equals("2"));
			g.getGP().addText(response);
			if(response.equals("2")) {
				g.getGP().addText("\n\nIt sighs. \"I am a researcher. I study the habits and behaviors of lower diimensional creatures"
						+ " such as yourself. It would please me very much if we could get this over with quickly so the both of us can"
						+ " return home.\"");
				waitForInput();
				do {
					g.getGP().addText("\n\n1: Okay");
					g.getGP().addText("\n2: No way");
					g.getGP().addText("\nWhat will you say? ");
					waitForInput();
					response = g.getGP().getResponse();
				} while(!response.equals("1") && !response.equals("2"));
				g.getGP().addText(response);
				if(response.equals("2")) {
					g.getGP().addText("\n\nBlink flickers and you feel a slight pressure on your neck. A moment later, it"
							+ " floats down the hall, leaving your lifeless body on the cold, empty floor.");
					waitForInput();
					return;
				}
			}
			g.getGP().addText("\n\nWell, this is certainly strange.");
			waitForInput();
			g.getGP().addText("\n\n\"Good. Now, I am attempting to assess the intelligence of humans. Unfortunately, due to the"
					+ " internet having all of the answers, this instead will be a quiz about what routes of the House Of Monsters"
					+ " game you have completed. Please complete all routes and then answer the following"
					+ " questions to the best of your ability. Question one: What color can Misty's butterflies turn?\"");
			waitForInput();
			g.getGP().addText("\n1: Red");
			g.getGP().addText("\n2: White");
			g.getGP().addText("\n3: Green");
			g.getGP().addText("\n4: Yellow");
			g.getGP().addText("\nWhat will you say? ");
			waitForInput();
			response = g.getGP().getResponse();
			if(response.equals("1")) {
				g.getGP().addText("\nCorrect. ");
				points ++;
			}
			waitForInput();
			g.getGP().addText("\n\n\"Question two: Who is the only character you can actually kiss?");
			waitForInput();
			g.getGP().addText("\n\n1: Spinner");
			g.getGP().addText("\n2: Misty");
			g.getGP().addText("\n3: Prismec");
			g.getGP().addText("\n4: Terrence");
			g.getGP().addText("\nWhat will you say? ");
			waitForInput();
			response = g.getGP().getResponse();
			if(response.equals("1")) {
				g.getGP().addText("\nCorrect. ");
				points ++;
			}
			waitForInput();
			g.getGP().addText("\n\n\"Question three: What is Terrence addicted to?");
			waitForInput();
			g.getGP().addText("\n\n1: Alcohol");
			g.getGP().addText("\n2: Coffee");
			g.getGP().addText("\n3: Sugar");
			g.getGP().addText("\n4: Sleeping pills");
			g.getGP().addText("\nWhat will you say? ");
			waitForInput();
			response = g.getGP().getResponse();
			if(response.equals("2")) {
				g.getGP().addText("\nCorrect. ");
				points ++;
			}
			waitForInput();
			g.getGP().addText("\n\n\"Question four: What is Prismec's online name?");
			waitForInput();
			g.getGP().addText("\n\n1: SugarSweet722");
			g.getGP().addText("\n2: Prismec123");
			g.getGP().addText("\n3: Prosmec");
			g.getGP().addText("\n4: LOLiHax");
			g.getGP().addText("\nWhat will you say? ");
			waitForInput();
			response = g.getGP().getResponse();
			if(response.equals("4")) {
				g.getGP().addText("\nCorrect. ");
				points ++;
			}
			waitForInput();
			g.getGP().addText("\n\n\"Question five: About how many siblings does Merina have?");
			waitForInput();
			g.getGP().addText("\n\n1: 0");
			g.getGP().addText("\n2: 3");
			g.getGP().addText("\n3: about 400");
			g.getGP().addText("\n4: about 1000");
			g.getGP().addText("\nWhat will you say? ");
			waitForInput();
			response = g.getGP().getResponse();
			if(response.equals("3")) {
				g.getGP().addText("\nCorrect. ");
				points ++;
			}
			waitForInput();
			g.getGP().addText("\n\n\"Now, this isn't an official question, but would you mind telling the creator of this"
					+ " game what you honestly think of it? She really appreciates you playing it, and you can rant about it"
					+ " either to her face, or in this convenient blank spot right here.\"");
			waitForInput();
			g.getGP().addText("\nBlink mutters quietly to itself. \"Your score was " + points +" out of 5. ");
			waitForInput();
			if(points != 5) {
				g.getGP().addText("\n\nUnfortunately, that is not satisfactory.\"");
				waitForInput();
				g.getGP().addText("\n\nPsionically, it picks you up and tosses you around for a few minutes before thwacking you"
						+ " against the wall. Then it floats off in search of a more interesting target.");
				return;
			}
			g.getGP().addText("\n\nYou have scored remarkably well,\" it decides.");
			waitForInput();
			g.getGP().addText("\n\n\"I must return to my studies. It is a shame that we do not have more time to discuss things.\"");
			waitForInput();
			g.getGP().addText("\n\nIt looks up. \"Perhaps I cannot speak with this iteration of you, but as a being of six"
					+ " dimensions, if a different version of you were to return on, let us say, day one and instead of selecting"
					+ " 1 or 2 from the choices of monsters to visit, instead type 443, perhaps we can continue this.\"");
			waitForInput();
			g.getGP().addText("\n\n\"I must say goodbye, but I am genuinely glad I met you.\"");
			waitForInput();
		} catch (InterruptedException e) {}
	}
	public static void day1BlinkPath(Visuals g) {
		try {
			g.getGP().addText("\n\n\"Blink.\"");
			waitForInput();
			g.getGP().addText("\n\nYou've never heard that name before, but it seems so familiar.");
			waitForInput();
			g.getGP().addText("\n\nPerhaps in another life, in another timeline, weaving and stretching across probability space in infinite serenity.");
			waitForInput();
			g.getGP().addText("\n\nUntil its time has come to be cut and ended forever.");
			waitForInput();
			g.getGP().addText("\n\nThe shadows darken.");
			waitForInput();
			g.getGP().addText("\n\nThe air grows still.");
			waitForInput();
			g.getGP().addText("\n\nThe air grows colder.");
			waitForInput();
			g.getGP().addText("\n\nYour heartbeat quickens.");
			waitForInput();
			g.getGP().addText("\n\n\"Hello there, human.\"");
			waitForInput();
			g.getGP().addText("\n\nEeeeeeeh it's Blink.");
			waitForInput();
			g.getGP().addText("\n\nBlink makes some coffee and a chair appear. It watches you drink.");
			waitForInput();
			g.getGP().addText("\n\nThis is awkward. This whole game is awkward.");
			waitForInput();
			g.getGP().addText("\n\nIt is so awkward that Blink erases the entire worldline from probablilty space, just to forget"
					+ " that it ever engaged in such an awkward activity. Then it heads off to an alternate timeline, where"
					+ " it is repeatedly insulted by a janitor.");
			waitForInput();
			g.getGP().addText("\n\n\"Sorry.\"");
		} catch (InterruptedException e) {}
		System.exit(0);
	}
	public static void endBad(Visuals g) {
		g.getGP().addText("\n\nAnd you die.");
	}
	public static void printPoints(Visuals g, int[] points) {
		try {
			g.getGP().addText("\n\nEnd of the day");
			g.getGP().addText("\nSpinner: " + points[0]);
			g.getGP().addText("\nMisty: " + points[1]);
			g.getGP().addText("\nMerina: " + points[2]);
			g.getGP().addText("\nPrismec: " + points[3]);
			g.getGP().addText("\nPress Next to continue.");
			waitForInput();
		} catch (InterruptedException e) {}
	}
}
