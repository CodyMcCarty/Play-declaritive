package declarative;

import java.util.Optional;

public class _Optionals {

  public static void main(String[] args) {

    Object aNull = Optional.ofNullable(null)
        .orElseGet(() -> "default value");

    String t1 = "bill@email.com";
    Object t2 = null;
    Optional.ofNullable(t2)
        .ifPresentOrElse(email -> System.out.println("check " + email),
            () -> System.out.println("Invalid email"));
  }

}
