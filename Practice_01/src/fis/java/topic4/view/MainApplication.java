package fis.java.topic4.view;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import fis.java.topic4.dao.AccountDao;
import fis.java.topic4.model.Account;
import fis.java.topic4.pool.HikariWorkerThread;;

public class MainApplication {
	 private static final int NUMBER_OF_USERS = 8;
	 
	    public static void main(String[] args) throws SQLException, InterruptedException {
	        final CountDownLatch latch = new CountDownLatch(NUMBER_OF_USERS);
	        for (int i = 1; i <= NUMBER_OF_USERS; i++) {
	            Thread worker = new HikariWorkerThread(latch, "" + i);
	            worker.start();
	        }
	        latch.await();
	        System.out.println("DONE All Tasks");
	    }
}
