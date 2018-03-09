package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Persistence {
	private static final String FILENAME = "savefile.ser";
	private File saveFile;

	public File getSaveFile() {
		return saveFile;
	}
	public void persist() throws IOException {
		Accounting ac = Accounting.getInstance();
		saveFile = new File(FILENAME);
		//FileOutputStream fos = new FileOutputStream(new File(FILENAME));
		FileOutputStream fos = new FileOutputStream(saveFile);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(ac);
		oos.close();
	}

	public void load() throws IOException, ClassNotFoundException {
		// read file
		FileInputStream fis = new FileInputStream(FILENAME);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object o = ois.readObject();
		ois.close();
		if (o != null) {
			Accounting acIn = (Accounting) o;

			// trickery to move Account object from persisted objects into the container
			ArrayList<Account> accounts = acIn.getAll();
			Accounting acc = Accounting.getInstance();
			for (int i = 0; i < accounts.size(); i++) {
				acc.addAccount(accounts.get(i));
			}
		}
	}
}
