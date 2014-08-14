package com.persistence.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.persistence.beans.Transaction;
/**
 */
public class TransactionDao {
    private Integer id = 1;

    //<email, List<Transaction>>
    private Map<String, ArrayList<Transaction>> userTransactions = new HashMap<String, ArrayList<Transaction>>();

    public List<Transaction> getUserTransaction(String emailId){
        if(!userTransactions.containsKey(emailId)){
            System.out.println("No transaction has been done by this user. " + emailId);
            userTransactions.put(emailId, new ArrayList<Transaction>());
        }
        return userTransactions.get(emailId);
    }

    public Transaction addUserTransaction(String emailId, Transaction transaction){

        if(!userTransactions.containsKey(emailId)){
            System.out.println("No transaction has been done by this user. " + emailId);
            userTransactions.put(emailId, new ArrayList<Transaction>());
        }

        ArrayList<Transaction> transactions = userTransactions.get(emailId);
        transactions.add(transaction);
        return  transaction;
    }
}
