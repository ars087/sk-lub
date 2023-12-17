import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BankTest {

    private Bank bank;

    @BeforeEach
    public void createClass() {
        List<String> list = new ArrayList<>();
        list.add("Семен Тарасов");
        list.add("Герасим Ноев");

        bank = new Bank(list);

    }


    @Test
    public void getArrayAccount() {

        String[] arrayAccount = bank.getArrayAccount();
        String actual = arrayAccount[0];
        String expected = "0000000001";


        assertEquals(expected, actual);

    }


    @Test
    void getSumAllAccounts() {


        Set<Map.Entry<String, Account>> key = bank.getBankAccountsClient().entrySet();

        Iterator<Map.Entry<String, Account>> iterator = key.iterator();

        long actualAllBalancAccount = 0;


        while (iterator.hasNext()) {

            String key1 = iterator.next().getKey();

            actualAllBalancAccount += bank.getBankAccountsClient().get(key1).getMyBalance();

        }

        long expected = bank.getSumAllAccounts();

        assertEquals(expected, actualAllBalancAccount);


    }

    @Test
    void transfer() {

        String[] arrayAccoun = bank.getArrayAccount();
        long fromAccount = bank.getBalanceAccount(arrayAccoun[0]);
        long toAccount = bank.getBalanceAccount(arrayAccoun[1]);
        long amount = 1;

        try {

            bank.transfer(arrayAccoun[0], arrayAccoun[1], amount);

            long expectedPlus = toAccount + amount;
            long actualPlus = bank.getBalanceAccount(arrayAccoun[1]);
            assertEquals(expectedPlus, actualPlus);

            long expectedMinus = fromAccount - amount;
            long actualMinus = bank.getBalanceAccount(arrayAccoun[0]);
            assertEquals(expectedMinus, actualMinus);

        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }


    }
}