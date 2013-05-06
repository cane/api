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
 * Analysis of the behavior code, regardless of any errors will be thrown this exception.
 * 
 * @author Yat-ton
 * @version 1.00.000 2011-4-27 01:30:29
 */
public class AnalyzeBehaviourException extends Exception {
	private static final long serialVersionUID = 2388990228492775956L;

	public AnalyzeBehaviourException(){
		
	}
	
	/**
	 * @param message
	 */
	public AnalyzeBehaviourException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AnalyzeBehaviourException(Throwable cause) {
		super(cause);
	}
	

	/**
	 * @param message
	 * @param cause
	 */
	public AnalyzeBehaviourException(String message, Throwable cause) {
		super(message, cause);
	}
}
