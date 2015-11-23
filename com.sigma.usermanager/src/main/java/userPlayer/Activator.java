/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package userPlayer;

import java.sql.SQLException;
import java.util.Scanner;

import main.Main;
import mySender.Sender;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import postgresql.DataBase;


public class Activator implements BundleActivator {

    DBServiceTracker dbServiceTracker;
    SenderServiceTracker senderServiceTracker;
    public void start(BundleContext context) throws Exception {
        System.out.println("get DataBase from dbServiceTracker");
        dbServiceTracker= new DBServiceTracker(context);
        dbServiceTracker.open();
		 DataBase db = (DataBase)dbServiceTracker.getService();
	      if(db.init()==0){
		        System.out.println("DataBase init!!");
		        //db.executeUpdate("CREATE TABLE player (ID_P SERIAL PRIMARY KEY, email varchar,pass varchar,nick varchar);");
		  }
		  else{
			  System.out.println("Cap! We have a problem with connection DB");
			  this.stop(context);
		  }
	      System.out.println("get Sender from senderServiceTracker");
	      senderServiceTracker= new SenderServiceTracker(context);
	      senderServiceTracker.open();
	      Sender snd = (Sender)senderServiceTracker.getService();
	      System.out.println( context);
	      if(senderServiceTracker.getTrackingCount()>0)
	      	System.out.println( snd.getSubject());
       Main main = new Main(db,snd);
    }
    public void stop(BundleContext context) throws Exception {
        System.out.println("Goodbye World!!");
        dbServiceTracker.close();
    }
}