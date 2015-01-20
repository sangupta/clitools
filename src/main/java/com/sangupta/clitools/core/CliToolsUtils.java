/**
 *
 * clitools - Simple command line tools
 * Copyright (c) 2014-2015, Sandeep Gupta
 * 
 * http://sangupta.com/projects/clitools
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.sangupta.clitools.core;

import java.io.File;
import java.util.Collection;
import java.util.List;

import com.sangupta.jerry.store.PropertiesUserLocalStore;
import com.sangupta.jerry.store.UserLocalStore;
import com.sangupta.jerry.util.FileUtils;

/**
 * Simple utility classes for CliTools
 * 
 * @author sangupta
 *
 */
public class CliToolsUtils {
	
	public static UserLocalStore localStore;
	
	public static UserLocalStore getUserLocalStore() {
		if(localStore == null) {
			synchronized (CliToolsUtils.class) {
				if(localStore == null) {
					localStore = new PropertiesUserLocalStore(null, ".clitools");
				}
			}
		}
		
		return localStore;
	}
	
	/**
	 * Check if a given argument has wild-cards present in it or not.
	 * 
	 * @param arg
	 * @return
	 */
	public static boolean hasWildcards(String arg) {
		if(arg == null) {
			return false;
		}
		
		char[] name = arg.toCharArray();
		int index = 0;
		char c;
		for( ; index < name.length; index++) {
			c = name[index];
			if(c == '*' || c == '?') {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Resolve the supplied file argument which may contain wildcards
	 * to a list of all valid files.
	 * 
	 * @param arg
	 * @return
	 */
	public static List<File> resolveFiles(final File currentDir, String arg) {
		return FileUtils.listFiles(currentDir, arg, true);
	}
}