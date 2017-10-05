import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in); 
		System.out.print("Enter FizzBuzz upper boundry: ");
		boolean validInput = false;
		int boundry=0;
		while (!validInput) {
			try {
				boundry= Integer.parseInt(reader.nextLine());
				
				validInput=true;
				
			}
			catch(Exception e) {
				System.out.println("Please enter an Integer"); 
				System.out.print("Enter FizzBuzz upper boundry: ");
			}
		}
		reader.close();
		String version = System.getProperty("java.version");
		System.out.println("\n\nFizzBuzz Results");
		System.out.println("==============================");
		if (version.contains("1.8")) {
			List<Integer> range = IntStream.range(1, boundry+1).boxed().collect(Collectors.toList());
			String fizz = range.stream().filter(num -> num %3 ==0 &&  num %5 !=0).map( Object::toString ).collect(Collectors.joining( ", " )); 
			System.out.println ("Fizz: " + fizz);
			String buzz = range.stream().filter(num -> num %3 !=0 && num %5 ==0).map( Object::toString ).collect(Collectors.joining( ", " )); 
			System.out.println ("Buzz: " + buzz);
			String fizzbuzz = range.stream().filter(num -> num %5 ==0 && num%3==0).map( Object::toString ).collect(Collectors.joining( ", " )); 
			System.out.println ("FizzBuzz: " + fizzbuzz);
		}
		else {
			ArrayList<String> fizz = new ArrayList<String>();
			ArrayList<String> buzz = new ArrayList<String>();
			ArrayList<String> fizzbuzz = new ArrayList<String>();
			for (int i=1; i<=boundry; i++) {
				if(i%3==0 && i%5!=0)
					fizz.add(i+"");
				if(i%5==0 && i%3!=0)
					buzz.add(i+"");
				if(i%5==0 && i%3==0)
					buzz.add(i+"");
			}
			System.out.println("Fizz: " + String.join(", ", fizz));
			System.out.println("Buzz: " + String.join(", ", buzz));
			System.out.println("FizzBuzz: " + String.join(", ", fizzbuzz));
		}
	}

}
