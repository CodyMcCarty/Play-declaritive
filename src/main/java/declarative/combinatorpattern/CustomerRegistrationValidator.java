package declarative.combinatorpattern;

import static declarative.combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

import declarative.combinatorpattern.CustomerRegistrationValidator.ValidationResult; // may need
// to be a static import??
import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {

  static CustomerRegistrationValidator isEmailValid () {
    return customer -> customer.getEmail().contains("@") ? SUCCESS : EMAIL_INVALID;
  }

  static CustomerRegistrationValidator isPhoneNumValid () {
    return customer -> customer.getPhoneNum().startsWith("1") ? SUCCESS : PHONE_NUM_INVALID;
  }

  static CustomerRegistrationValidator isAdult () {
    return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 21 ?
        SUCCESS : IS_NOT_ADULT;
  }

  default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
    return customer -> {
      ValidationResult result = this.apply(customer);
      return result.equals(SUCCESS) ? other.apply(customer) : result;
    };
  }

  enum ValidationResult {
    SUCCESS,
    PHONE_NUM_INVALID,
    EMAIL_INVALID,
    IS_NOT_ADULT
  }

}
