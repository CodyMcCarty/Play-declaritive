package declarative.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

  private boolean isEmailValid(String email) {
    return email.contains("@");
  }

  private boolean isPhoneNumValid(String phoneNum) {
    return phoneNum.startsWith("1");
  }

  private boolean isAdult(LocalDate dob) {
    return Period.between(dob, LocalDate.now()).getYears() > 21;
  }

  public boolean isValidCustomer(Customer customer) {
    return isEmailValid(customer.getEmail()) &&
        isPhoneNumValid(customer.getPhoneNum()) &&
        isAdult(customer.getDob());
  }
}
