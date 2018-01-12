/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takudu;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author gouthamvel
 */
public class Goutham {
  HashMap<String, LinkedList<Long>> dbMap;
  public static final int HOUR = 3600;
    public Goutham() {
        this.dbMap = new HashMap<>();
    }

  boolean failedLoginAttempt(String user) {
      Long currentTimestamp = System.currentTimeMillis()/1000;
      boolean report = false;
      LinkedList<Long> userCache;

      if (dbMap.containsKey(user)) {
          userCache = dbMap.get(user);
      }else{
          userCache = new LinkedList();
      }

      if (userCache.size() > 2) {
        long firstTimestamp = userCache.pop();
        // check if the oldest timestamp is within past hour
        if (firstTimestamp > (currentTimestamp - HOUR)) {
            report = true;
        }
      }
      
      // push the current time to end of queue
      userCache.push(currentTimestamp);
      dbMap.put(user, userCache);
      
      return report;
  }
}
