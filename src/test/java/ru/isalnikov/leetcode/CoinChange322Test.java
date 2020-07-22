package ru.isalnikov.leetcode;

import org.junit.Test;
import static org.junit.Assert.*;

public class CoinChange322Test {

    @Test
    public void testCoinChange3() {

        int coins[] = {1, 2, 5}; // [470,18,66,301,403,112,360]

        int amount = 11; // 8235

        int result = CoinChange322.coinChange(coins, amount);
        assertEquals(3, result);

    }

    @Test
    public void testCoinChange4() {

        int coins[] = {470, 18, 66, 301, 403, 112, 360};

        int amount = 8235;

        int result = CoinChange322.coinChange(coins, amount);
        assertEquals(20, result);

    }
    
    @Test
    public void testCoinChange5() {

        int coins[] = {470, 18, 66, 301, 403, 112, 360};

        int amount = 8235;

        int result = CoinChange322.coinChange2(coins, amount);
        assertEquals(20, result);

    }
    @Test
    public void testCoinChange6() {

        int coins[] = {470, 18, 66, 301, 403, 112, 360};

        int amount = 8235;

        int result = CoinChange322.coinChangeDp(coins, amount);
        assertEquals(20, result);

    }

}
