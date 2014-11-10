package Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Read Object and Write Object
 */
class Employee implements Serializable {
	public String name;
	public String address;
	public transient int SSN; // Shouldn't be serialized
	public int number;
	public void mailCheck() {
		System.out.print(name);
	}
}

public class SerializeEg {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.name = "A";
		e.address = "Addr1";
		e.SSN = 1;
		e.number = 123;

		Employee e2 = new Employee();
		e2.name = "A";
		e2.address = "Addr1";
		e2.SSN = 1;
		e2.number = 123;

		List<Employee> eTemp = new ArrayList<Employee>();
		eTemp.add(e);
		eTemp.add(e2);

		FileOutputStream fout = null;
		ObjectOutputStream out = null;
		try {
			fout = new FileOutputStream("class.txt");
			out = new ObjectOutputStream(fout);
			out.writeObject(eTemp);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if (out != null)
				try {
					out.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if (fout != null)
				try {
					fout.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}

		// Deserializing
		FileInputStream fin = null;
		ObjectInputStream oin = null;
		try {
			fin = new FileInputStream("class.txt");
			oin = new ObjectInputStream(fin);
			try {
				List<Employee> eTempRes = (List<Employee>) oin.readObject();
				for (Employee et : eTempRes)
					System.out.println(et.name + "\t" + et.SSN);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if (fin != null)
				try {
					fin.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if (oin != null)
				try {
					oin.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}

	}
}
