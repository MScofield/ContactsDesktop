/**
 * Created by scofieldservices on 11/21/16.
 */
public class FizzBuzz {


    public static void main(String args[]) {

        //Iterate from 0 to 100
        for (int i = 0; i <= 100; i++) {
            //If the number can be divide by 3 and 5 evenly print out "FizzBuzz"
            if (i%3==0 && i%5 ==0) {
                System.out.println(i+":FizzBuzz");
                //If the nubmer can be divied by 3 evely print out "Fizz"
            }else if(i%3 == 0) {
                System.out.println(i+":Fizz");
                //If the number can be divide by 5 evenly print out "Buzz"
            }else if (i%5 == 0) {
                System.out.println(i+":Buzz");
            }
            i++;
        }


    }
}
