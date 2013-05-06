/**
 * Copyright 2010 CaneData.org
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
package org.canedata.ta;

/**
 * 
 * @author Yat-ton
 * @version 1.00.000 2011-4-18 12:13:56
 */
public class TransactionException extends Exception {

	private static final long serialVersionUID = 5306797826834403537L;
	public int errorCode = -1;
	
	/**
	 * 
	 */
	public TransactionException(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @param arg0
	 */
	public TransactionException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public TransactionException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public TransactionException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public int getErrorCode(){
		return errorCode;
	}
	
	public TransactionException setErrorCode(int errorCode){
		this.errorCode = errorCode;
		return this;
	}
}
