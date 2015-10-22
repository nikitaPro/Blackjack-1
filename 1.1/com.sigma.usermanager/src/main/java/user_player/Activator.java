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
package user_player;

import java.sql.SQLException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import postgresql.DataBase;


public class Activator implements BundleActivator {

    HelloServiceTracker helloServiceTracker;
    public void start(BundleContext context) throws Exception {
        System.out.println("Hello World!!");
        helloServiceTracker= new HelloServiceTracker(context);
        helloServiceTracker.open();
        DataBase db = (DataBase)helloServiceTracker.getService();

      if(db.init()==0){
	        System.out.println("DataBase init!!");
	        //db.executeUpdate("CREATE TABLE player (ID_P SERIAL PRIMARY KEY, email varchar,pass varchar,nick varchar);");
	  }
	  else{
		  System.out.println("Cap! We have a problem with connection DB");
		  this.stop(context);
	  }
      System.out.println("enter e-mail: ");
      Scanner in = new Scanner(System.in);
      String email = in.nextLine();
      System.out.println("enter pass: ");
      String pass = in.nextLine();
      System.out.println("enter nick: ");
      String nick = in.nextLine();
      Player player = new Player(db);
      player.registr(email, pass, nick);
      
      System.out.println("enter e-mail: ");
      email = in.nextLine();
      System.out.println("enter pass: ");
      pass = in.nextLine();
  
      if(player.login(email, pass)==0){
    	  System.out.println("Hello "+player.getNick()); 
      }
    }
    public void stop(BundleContext context) throws Exception {
        System.out.println("Goodbye World!!");
        helloServiceTracker.close();
    }
}