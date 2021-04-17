public class BankAccount {

  protected double invoice = 0; //ljojoioj

  public double getAmount() {
    return invoice;
  }

  protected void put(double amountToPut) {

    if (amountToPut > 0) {

      invoice += amountToPut;
      System.out.println("Счет пополнен на сумму :" + amountToPut);

    } else {
      System.out.println("Пополнить счет  не удалось. Сумма пополнения не может быть отрицательной!");
    }
  }
  public boolean take(double amountToTake) {

    boolean successfully;

    if (amountToTake > invoice) {
      System.out.println("На счету недостаточно средств.Измените значение суммы списания");
      successfully = false;

    } else if (amountToTake < 0) {
      System.out.println("Сумма не должна быть отрицательной");
      successfully = false;
    } else {
      invoice -= amountToTake;
      System.out.println("Средства списаны!");
      successfully = true;
    }
    return successfully;
  }
  protected boolean send(BankAccount receiver, double amount) { //;lk;lk

    boolean successfully;
    if ( amount != 0 && amount > 0 && amount <= invoice ) {
      invoice -= amount;
      receiver.put(amount);
      System.out.println(" Перевод между счетами успешно завершен.");
      successfully = true;
    } else {
      System.out.println("Значение суммы указанно с ошибкой,либо сумма перевода больше средств на счету.");
      successfully = false;
    }
    return successfully;
  }
}
