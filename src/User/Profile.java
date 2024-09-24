package User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;

public class Profile {
	private String username;
	private int userid;
	private static int lastUserId = 0;
	private ArrayList<Review> reviews;
	private int reviewCount;
	
	private static final String userFilePath = System.getProperty("user.home") + "/Documents/TuneIn/Users";
	private static final String fileFormat = ".dat"; // file format var for ease of changing in case it's needed later
	
	// default constructor, currently not needed
//	public Profile() {
//		this.username = "empty";
//		this.userid = -1;
//		this.reviewCount = -1;
//		this.reviews = null;
//	}
	
	public Profile(String username) {
		this.username = username;
		lastUserId++;
		this.userid = lastUserId;
		this.reviewCount = 0;
		this.reviews = new ArrayList<Review>();
	}
	
	public Profile(String username, int id, int revCount) {
		this.username = username;
		this.userid = id;
		this.reviewCount = revCount;
		this.reviews = new ArrayList<Review>(); // TODO: handle creation of reviews list from loaded profiles
	}
	
	public void saveUserToFile() {
		File userDir = new File(userFilePath);
		if(userDir.exists() || userDir.mkdirs()) { // if the directory exists, do nothing and keep going. if it doesn't fully exist, create it and keep going.
			try {
				PrintWriter out = new PrintWriter(userFilePath + "/" + this.username + fileFormat); // saves user information to <username>.dat file
				out.print(this.username + "\n" + this.userid + "\n" + this.reviewCount);
				// TODO: implement how reviews are saved to this file (or perhaps a new file?)
				out.close();
				out = new PrintWriter(new FileOutputStream(
						new File(userFilePath + "/userlist.txt"),
						true)); // adds user to list of all users on device
				out.print(this.username + "\n");
				out.close();
			} catch(FileNotFoundException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}
	
	/**
	 * Generates a Profile object by loading it from the specified username's file
	 * @param userToLoad the name of the user to be loaded
	 * @return a Profile generated from file
	 */
	public static Profile loadUserFromFile(String userToLoad) {
		if(!userExists(userToLoad)) {
			return null; // double check that the user exists, should also handle this in LoadProfileMenu
		}
		try {
			FileReader reader = new FileReader(userFilePath + "/" + userToLoad + fileFormat);
			Scanner in = new Scanner(reader);
			String username = in.nextLine();
			int id = Integer.parseInt(in.nextLine()); // still want to get next line, just convert it to an int when needed
			int reviewCount = Integer.parseInt(in.nextLine());
			return new Profile(username, id, reviewCount);
		} catch(FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
			return null; // return null since we weren't able to build one
		}
	}
	
	/**
	 * Method to check if a given string username exists as a user already. Usernames must be unique. (may switch this to ID numbers later)
	 * @param user string representing username to be checked.
	 * @return if user already exists, returns true. Otherwise returns false
	 */
	public static boolean userExists(String user) {
		File userlistDir = new File(userFilePath + "/userlist.txt");
		if(!userlistDir.exists()) {
			try {
				userlistDir.createNewFile();
			} catch(IOException e) {
				System.out.println(e.getLocalizedMessage());
				return true; // if this fails, stop execution of this function and return true to avoid creating more users or causing more errors
			}
		}
		try {
			FileReader reader = new FileReader(userFilePath + "/userlist.txt");
			Scanner in = new Scanner(reader);
			while(in.hasNextLine()) {
				String username = in.nextLine();
				if(username.equals(user)) {
					return true; // return true as soon as we find a match: the user already exists
				}
			}
			return false; // if we couldn't find that specific username, must be a new username
		} catch(FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
			return true; // return true here just in case something goes wrong, don't want to compound issue by creating more users
		}
	}
	
	public void addReview(Review newReview) {
		this.reviewCount++;
		this.reviews.add(newReview);
	}
}
