/* *********************************************************************************************************************
 *
 * javaAVMTR064 - open source Java TR-064 API
 *===========================================
 *
 * Copyright 2015 Marin Pollmann <pollmann.m@gmail.com>
 *
 *
 ***********************************************************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 ***********************************************************************************************************************/
package de.bausdorf.avm.tr064.examples;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import de.bausdorf.avm.tr064.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.bausdorf.avm.tr064.FritzConnection;
import de.bausdorf.avm.tr064.ParseException;


public class DisplayInfo {
	private static final Logger LOG = LoggerFactory.getLogger(DisplayInfo.class);
	
	static String ip = null;
	static String user = null;
	static String password = null;
	
	private DisplayInfo() {
		super();
	}

	public static void main(String[] args) throws IOException, ParseException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, UnauthorizedException {
		if( args.length < 2 ) {
			LOG.error("args: <fb-ip> <password> [user]");
			System.exit(1);
		} else {
			ip = args[0];
			password = args[1];
			if( args.length > 2 )
			{
				user = args[2];
			}
		}
//		FritzConnection fcWithoutUser = new FritzConnection(ip);
//		fcWithoutUser.init(null);
//		fcWithoutUser.printInfo();
//		System.out.println("##################################################################");
		FritzConnection fcWithUser = new FritzConnection(ip,user,password);
		fcWithUser.init(null);
		fcWithUser.printInfo();
	}
}
