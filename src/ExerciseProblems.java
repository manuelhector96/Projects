import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExerciseProblems {

    /**
     * This class includes exercises to practice Java. Class will provide both exercises, solution, and driver code
     **/
        /**
         * (1). Richest Person: Given an (m,x,n) integer grid accounts where accounts[i][[j]
         * is the amount of money that the ith customer has in the jth bank account. Return
         * the wealth that the richest customer has.
         * <p>
         * The wealth that each customer has is the amount of money that they have in all their bank
         * accounts.
         **/

        public int maximumWealth(int[][] accounts) {
            // set a variable to keep track of added accounts
            int maxWealth = 0;
            // go through each account[i]
            for (int i = 0; i < accounts.length; i++) {
                // set a different variable that will help with comparing the our maxWealth
                int amount = 0;

                // for each account add the amounts for the ith customer
                for (int j = 0; j < accounts[i].length; j++) {
                    amount += accounts[i][j];
                }
                // lets keep track of which account has the "Max Wealth"
                System.out.println((i + 1) + ": " + amount);
                // keep track of the highest wealth
                if (amount > maxWealth) {
                    maxWealth = amount;
                }
            }
            System.out.println("Max wealth is:");
            // return the richest account
            return maxWealth;
        }

        /**
         * (2) Running sum: Given an array nums. We define a running sum of an array as
         * runningSum[i] = sum(num[0] ... sum[i])
         * <p>
         * Return the running sum of nums.
         **/

        public int[] runningSum(int[] nums) {
        /* lets go through array but since we know that the first index has to stay the same
        we initialize i to 1 */
            for (int i = 1; i < nums.length; i++) {
            /* now all we need to do is add backwards and update the index
            for the next addition */
                nums[i] = nums[i - 1] + nums[i];
            }
            return nums;
        }

        /**
         * (3) Most Candies: Given the array candies add the given integer extraCandies where candies[i] represents
         * the amount of candies that each ith kid has.
         * <p>
         * Distribute the candy for each of the kids such that, he or she will have the greatest amount of candies
         * it is important to note that multiple kids can be be the "greatest candy holder".
         **/
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int max = 0;
            boolean b;
            List<Boolean> l = new ArrayList();
            for (int candy : candies) {
                if (candy > max) {
                    max = candy;
                }
            }

            for (int candy : candies) {
                b = candy + extraCandies >= max;
                l.add(b);
            }
            return l;
        }

        /**
         * (4) Goal Parser: Given an array made up of 'G','()','(al)'. We want parse the array and return
         **/

        public String interpret(String command){
            // first lets create a string builder
            StringBuilder str = new StringBuilder();
            //loop through the char array
            for ( int i = 0; i < command.length(); i++){
                // once we find a 'G' we will append that 'G' to the str array
                // after that we will move to the next character by adding to i
                if( command.charAt(i) == 'G'){
                    str.append('G');
                /* For the '()' we have to check that open parentheses is followed by a closed parentheses
                 in order to be able to add an 'o'
                 like in the case above we want to add to i since here checking two characters
                we want to move to the character after ')'
                 */
                } else if ( i + 1 < command.length() && command.charAt(i + 1) == ')'){
                    str.append('o');
                    i++;
                } else {
                /*since we've checked the other cases we can now just add 'al'
                 here we are assuming we have hit '(' but it is not followed by ')'
                 meaning that there are three characters after '(' which are 'al)' so we want to add 3 to i to move to the
                 unchecked character.
                 */
                    str.append("al");
                    i = i+3;
                }
            }
            return str.toString();
        }

        /***************************************************************************************************************************
         *  (1) Given an interval [a, b) find the product of the numbers in that interval.
         *
         *  (2) Given a number, use the Collatz conjecture to return all outcomes
         *       with the Collatz conjecture if the n is even divide it by half and if n it odd multiple it by 3 and add 1.
         *       Print all values using this conjecture.
         *
         *  (3) Given an interval find the avg of the numbers that are divisible by 3
         *  for example on
         *
         *  (4) A user inputs a long positive number m. You need to find out what is the smallest int number n such that n! > m
         *
         *  (5) Given a nxm matrix can you rotate to 90 degrees to make it a mxn matrix
         ****************************************************************************************************************************/

        //(1)
        public static void product(int x, int y) {
            long swap = 1L;

            for (int i = x; i < y; i++) {
                swap *= i;
            }
            System.out.println("The product is:" + swap);
        }
        //(2)
        public static void collatz(int n) {

            int x = n;
            System.out.print("Collatz for: " + n + " ");
            while (x != 1){
                if (x % 2 == 0 ) {
                    x = x/2;
                }
                else {
                    x = (x * 3) + 1;
                }
                System.out.print(x + " ");
            }
            System.out.println();

        }
        //(3)
        public static void avg(int x, int y) {
            int count = 0;
            int n = 0;
            double avg;

            for (int i = x; i <= y; i++) {
                if (i % 3 == 0) {
                    count = count + i;
                    n++;
                }
            }
            avg = count / n;
            System.out.println("The average is: " + avg);
        }
        //(4)
        public static void smallestInt(long x){

            long comp = 1;
            int fact = 1;

            do{
                fact++;
                comp = fact * comp;
            } while(comp <= x);
            System.out.println("Smallest factorial: " + fact);
        }

        //5

        public static void rotated_Matrix(int a, int b, int[][] matrix){

            int[][] matrix_ = new int[a][b];
            int[][] matrix_rotated = new int[a][b];
            for(int i= 0; i < a; i++){
                for(int j = 0; j < b; j++){
                    matrix_[i][j] = matrix[i][j];
                }
            }

            for(int j = 0; j < b; j++) {
                for (int i = a - 1; i >= 0; i--) {
                    matrix_rotated[i][j] = matrix_[i][j];
                    System.out.print(matrix_rotated[i][j] + " ");
                }
                System.out.println();
            }
        }



        /***************************************************************************************************************************
         *
         ****************************************************************************************************************************/

        public static void main(String[] args) {
            /**
             *  (1)
             **/
            System.out.println("Answer to Exercise 1: ");
            ExerciseProblems exercise1 = new ExerciseProblems();
            int[][] accounts = {{1, 5}, {7, 3}, {3, 5}};
            System.out.println(exercise1.maximumWealth(accounts));

            /**
             *  (2)
             **/
            System.out.println("Answer to Exercise 2: ");
            ExerciseProblems exercise2 = new ExerciseProblems();
            int[] numbersArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            System.out.println(Arrays.toString(exercise2.runningSum(numbersArray)));

            /**
             *  (3)
             **/
            System.out.println("Answer to Exercise 3: ");
            ExerciseProblems exercise3 = new ExerciseProblems();
            int[] candyArray = {1, 7, 3, 4, 1};
            int extraCandy = 5;
            System.out.println(exercise3.kidsWithCandies(candyArray, extraCandy));

            /**
             *  (4)
             **/
            System.out.println("Answer to Exercise 4: ");
            ExerciseProblems exercise4 = new ExerciseProblems();
            String c = "G()(al)";
            System.out.println(exercise4.interpret(c));

            /**
             *  (5)
             **/
            System.out.println("Answer to Exercise 5: ");
            int[][] m ={{0, 1, 2, 3},
                        {10, 11, 12, 13},
                        {20, 21, 22, 23} };
            rotated_Matrix(3,4,m);



            /**************************************************************************
             *  Extra practice to exercises
             **************************************************************************/
            System.out.println("Answers to Extra practice problems:");
            avg(-5, 12);
            product(100, 105);
            collatz(17);
            smallestInt(6188989133L);
            /**************************************************************************
             *
             **************************************************************************/

        }
    }




