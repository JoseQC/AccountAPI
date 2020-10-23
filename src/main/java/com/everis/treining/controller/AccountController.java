package com.everis.treining.controller;

import com.everis.treining.entity.Account;
import io.reactivex.Single;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/core")
public class AccountController {

  /**
   * Comment Method.
   * @throws InterruptedException 
   * 
   */
  @GetMapping("/accounts")
  public Single<Account> getAccount(@RequestParam(value = "cardNumber") String cardNumber) throws InterruptedException {

    if (cardNumber.isEmpty()) {
      return Single.just(new Account());
    }
    Account account = new Account();
    account.setAccountNumber(cardNumber + "XXX");

    char charterLast = cardNumber.charAt(cardNumber.length() - 1);
    switch (charterLast) {
      case '1':
        account.setAmount(1000.00);
        break;
      case '2':
        account.setAmount(1000.00);
        break;
      case '3':
        account.setAmount(1500.00);
        break;
      default:
        break;
    }
   // Thread.sleep(5000);
    return Single.just(account);

  }

}
