/**
 * Copyright 2011 CaneData.org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.canedata.exception;

/**
 * 
 * @author Yat-ton
 * @version 1.00.000 2011-5-1
 */
public class KeyExistsException extends RuntimeException {
	private String entityName;
	private String key;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1296985323202231425L;

	/**
	 * 
	 */
	public KeyExistsException(String entityName, String key) {
		super("Primary key [" + entityName + "#" + key + "] already exists.");
		
		this.entityName = entityName;
		this.key = key;
		
		
	}

	/**
	 * @param arg0
	 */
	public KeyExistsException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public KeyExistsException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public KeyExistsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	public String getTarget(){
		return entityName + "#" + key;
	}
}
