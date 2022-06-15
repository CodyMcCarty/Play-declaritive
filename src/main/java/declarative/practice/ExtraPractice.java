package declarative.practice;

import java.util.function.BiPredicate;
import java.util.function.Function;

public class ExtraPractice {

  public static void main(String[] args) {
    /*
    funciton that doubles an int
    */
    Function<Integer, Integer> doubleUp = myInt -> myInt + myInt;
    int twenty = doubleUp.apply(10);

    /*
    We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is
    smiling. We are in trouble if they are both smiling or if neither of them is smiling. Return
    true if we are in trouble.

    monkeyTrouble(true, true) → true
    monkeyTrouble(false, false) → true
    monkeyTrouble(true, false) → false
    */
    BiPredicate<Boolean, Boolean> monkeyTrouble = (a, b) -> (a == b);
    boolean true1 = monkeyTrouble.test(true, true);

    /*
    Given an int n, return the absolute difference between n and 21, except return double the absolute difference if n is over 21.

    diff21(19) → 2
    diff21(10) → 11
    diff21(21) → 0
     */
    Function<Integer, Integer> diff21 = myInt ->
        (myInt > 21) ?
        Math.abs(21 - myInt) * 2 :
        Math.abs(21 - myInt);
    int diff2 = diff21.apply(19);
    int diff11 = diff21.apply(10);
    int diff0 = diff21.apply(21);
    int diff8 = diff21.apply(25);
  }












}
