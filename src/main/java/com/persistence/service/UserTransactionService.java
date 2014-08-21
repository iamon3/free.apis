package com.persistence.service;

import com.persistence.dao.TransactionDao;

import java.util.List;
import com.persistence.beans.Transaction;

/**
 */
public class UserTransactionService {
    private TransactionDao transactionDao = new TransactionDao();

    public List<Transaction> getUserTransaction(String emailId){
        return getTransactionDao().getUserTransaction(emailId);
    }

    public Transaction addUserTransaction(String emailId, Transaction transaction){
        return getTransactionDao().addUserTransaction(emailId, transaction);
    }

    private TransactionDao getTransactionDao(){
        return transactionDao;
    }
}
