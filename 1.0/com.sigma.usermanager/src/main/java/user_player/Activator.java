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
        System.out.println("create table!!!");
      try{
    	  db.executeUpdate("CREATE TABLE player (ID_P SERIAL PRIMARY KEY , name varchar, pass varchar, nick varchar);");
      }
      catch(SQLException e){
    	  e.printStackTrace();
      }

    }
    public void stop(BundleContext context) throws Exception {
        System.out.println("Goodbye World!!");
        helloServiceTracker.close();
    }
}