package fis.java.topic4.pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;

public class HikariWorkerThread extends Thread {
	private CountDownLatch latch;
    private String taskName;
  
    public HikariWorkerThread(CountDownLatch latch, String taskName) {
        this.latch = latch;
        this.taskName = taskName;
    }
  
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Starting. Task = " + taskName);
        execute();
        latch.countDown();
        System.out.println(Thread.currentThread().getName() + " Finished.");
    }
  
    private void execute() {
        try {
            String sqlSelect = "SELECT count(*) as total FROM banking.account;";
            try (Connection conn = HikariCPDataSource.getConnection();
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(sqlSelect);) {
                Thread.sleep(2000);
                rs.next();
                System.out.println("Task = " + taskName + ": Run SQL successfully " + rs.getInt("total"));
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
