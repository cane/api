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
public class NoSuchFieldException extends RuntimeException {
	private String entityName;
	private String field;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1296985323202231425L;

	/**
	 * 
	 */
	public NoSuchFieldException(String entityName, String field) {
		super("There are no such field " + field + " in the Result of " + entityName + ".");
		
		this.entityName = entityName;
		this.field = field;
		
		
	}

	/**
	 * @param arg0
	 */
	public NoSuchFieldException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public NoSuchFieldException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public NoSuchFieldException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	public String getTarget(){
		return entityName + "#" + field;
	}
}
