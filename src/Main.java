import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException  {
		

		
        // The name of the file to open.



        try {

  	      File file = new File("list.txt");

  	      if (file.createNewFile()){
  	        System.out.println("File is created!");
  	      }else{
  	        System.out.println("File already exists.");
  	      }

      	} catch (IOException e) {
  	      e.printStackTrace();
      	}
  	      
  	     

  	  Boolean loop = true;
  	      
  
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		
		while(loop == true) {
		
		System.out.println("What would you like to do?:");
		String task = reader.nextLine(); // Scans the next token of the input as an int.
		if(task.equals("read")) {
			
	  	      List<String> lines = new ArrayList<String>();
	  	      BufferedReader txtreader = null;
	  	      try {
	  	          txtreader = new BufferedReader(new FileReader("list.txt"));
	  	          String line = null;
	  	          while ((line = txtreader.readLine()) != null) {
	  	              lines.add(line);
	  	          }
	  	      } finally {
	  	          
	  	      }
	  
			
			for(int x=0; x < lines.size(); x++)
			System.out.println(lines.get(x));
			
			txtreader.close();
		}
		else {
			if(task.equals("write")) {
				
				BufferedWriter bw = null;
				FileWriter fw = null;

				try {
					System.out.println("what would you like to add?");
					
					String content = reader.nextLine();

					fw = new FileWriter("list.txt", true);
					bw = new BufferedWriter(fw);
					bw.write(content);

					System.out.println("Done");

				} catch (IOException e) {

					e.printStackTrace();

				} finally {

					try {

						if (bw != null)
							bw.close();

						if (fw != null)
							fw.close();

					} catch (IOException ex) {

						ex.printStackTrace();

					}
				}
			}
			else { 
				System.out.println("(O.O)?");
			}
		}
		System.out.println("would you like to do more? y/n");
		String again = reader.nextLine();
		if(again.equals("n")) {
			loop = false;
			System.out.println("Termanating progam");
		}else{
			if(again.equals("y")) {
				System.out.println("Re-runing");
			}else{
				System.out.println("What?");
				loop = false;
			}
		}
	}
		
		reader.close();
	}
}

