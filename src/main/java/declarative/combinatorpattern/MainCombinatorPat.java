package declarative.combinatorpattern;

import static declarative.combinatorpattern.CustomerRegistrationValidator.*;

import java.time.LocalDate;

public class MainCombinatorPat {

  public static void main(String[] args) {
    Customer john = new Customer("John", "john@email.com", "1.918.352.1587", LocalDate.of(1989,
        07, 13));
    Customer sally = new Customer("Sally", "sallyemail", "918.356.1548",
        LocalDate.of(2001, 03, 27));

    CustomerValidatorService cusValidServ = new CustomerValidatorService();
    boolean validCustomer = cusValidServ.isValidCustomer(john);
    boolean invalidCustomer = cusValidServ.isValidCustomer(sally);

    ValidationResult validComPatCustomer = validateCustomer(john);
    ValidationResult inValidComPatCustomer = validateCustomer(sally);

    ValidationResult validComPatCustomer2 = validateCustomer2().apply(john);
    ValidationResult inValidComPatCustomer2 = validateCustomer2().apply(sally);
  }

  private static ValidationResult validateCustomer(Customer customer) throws IllegalStateException {
    ValidationResult result = isEmailValid()
        .and(isPhoneNumValid())
        .and(isAdult())
        .apply(customer);
//    if (result != SUCCESS) throw new IllegalStateException(result.name());
    return result;
  }


  private static CustomerRegistrationValidator validateCustomer2() {
    return isEmailValid()
        .and(isPhoneNumValid())
        .and(isAdult());
  }


}
