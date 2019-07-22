package codingchallenge.CodingChallenge1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRetrieving {

	public static void main(String[] args) throws NumberFormatException, IOException {
		MergeSort pb = new MergeSort();
		try {
			// Read the text file in local storage, inside the project folder
			BufferedReader br = new BufferedReader(new FileReader("sort.txt"));

			/*
			 * Here we need to chunk the text file in to small parts and need to sort , then
			 * need to merge it because of the 1 GB memory, so it is not good idea to get
			 * the all integers in to a ArrayList because of the memory, so need to chunk...
			 */

			// creating the ArrayList to store the integers from Text file
			List<Integer> lines = new ArrayList<Integer>();
			String line;
			// Read the lines one by one
			while ((line = br.readLine()) != null) {
				lines.add(Integer.parseInt(line));
			}
			br.close();
			Integer[] inputArray = lines.toArray(new Integer[lines.size()]);
			// Callig the sort method from other class
			pb.mergeSort(inputArray, 0, inputArray.length - 1);
			for (Integer i : inputArray) {
				// just to check in put put
				System.out.println(i);
				// create a new text file under the project storage
				File file1 = new File("Storage.txt");
				// If a file exists in a same name then create a anew one
				if (!file1.exists()) {
					file1.createNewFile();
				}
				// Using File writer to write the sorted integers in the newly created file
				FileWriter fw = new FileWriter(file1, true);
				BufferedWriter bw = new BufferedWriter(fw);

				for (int p = 0; p < inputArray.length; p++) {
					bw.write(inputArray[p].toString() + "\n");
					bw.newLine();
					bw.flush();
				}

				bw.close();
			}
		} catch (IOException ie) {
			System.out.print(ie.getMessage());
		}

	}
}