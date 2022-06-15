package declarative.combinatorpattern;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Customer {

  private final String name;
  private final String email;
  private final String phoneNum;
  private final LocalDate dob;

}
