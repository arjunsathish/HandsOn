package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int number = increment(1);
        System.out.println(number);
        //Function takes one argument and produce result
        int number2 = incrementByOneFunction.apply(1);
        System.out.println(number2);
        int multiply = multiplyByTenFunction.apply(number2);
        System.out.println(multiply);
        Function<Integer,Integer> addByOneAndMultiplyByTen = incrementByOneFunction.andThen(multiplyByTenFunction);
        int number4 = addByOneAndMultiplyByTen.apply(1);
        //BiFunction takes two argument and produce result
        System.out.println(incremenyByOneAndMultiply(4,100));
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4,100));




    }

    static Function<Integer,Integer> incrementByOneFunction =  number -> number + 1;
    static Function<Integer,Integer> multiplyByTenFunction =  number -> number * 10;

    static BiFunction<Integer,Integer,Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) ->  ( numberToIncrementByOne + 1 ) * numberToMultiplyBy;

    static int increment(int number){
        return number + 1;
    }

    static int incremenyByOneAndMultiply(int number,int numToMultiply) {

        return (number + 1) * numToMultiply;
    }
}
