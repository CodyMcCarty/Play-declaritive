package declarative;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;

public class CallBacks {

  public static void main(String[] args) {
    /*
    js version:
    const hello = (fName, lName, callback) => {
      console.log(fName);
      if (lName) {
        console.log(lName)
      } else {
        callback();
      }
    }
    hello("Cody", null, function() {console.log("no last name")});
     */
    hello("Cody", "Mac", null);
    hello("Cody", null, value -> System.out.println("Need a last name"));
    hello("Cody", null, value -> System.out.println("You need a last name, " + value));
    System.out.println("\n");
    hello2("John", null, () -> System.out.println("Just a runnable"));

    // just curious is there's a bytecode difference between lambdas and method references.
    Function<String, String> uppCaseName = name -> name.toUpperCase();
    Function<String, String> uppCaseName2 = String::toUpperCase;
    String withLambda = uppCaseName.apply("cody");
    String withMethodRef = uppCaseName2.apply("bob");


  }
  static void hello(String fName, String lName, Consumer<String> callback) {
    System.out.println(fName);
    if (lName != null) {
      System.out.println(lName);
    } else {
      callback.accept(fName);
    }
  }

  static void hello2(String fName, String lName, Runnable callback) {
    System.out.println(fName);
    if (lName != null) {
      System.out.println(lName);
    } else {
      callback.run();
    }
  }

}
