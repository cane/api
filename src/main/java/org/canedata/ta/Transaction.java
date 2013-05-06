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
package org.canedata.ta;


/**
 * The Transaction interface definition, reference to {@link javax.transaction.Transaction}.
 * 
 * @see javax.transaction.Transaction
 * 
 * @author Yat-ton
 * @version 1.00.000 2011-4-17 12:43:18
 * 
 */
public interface Transaction {
	/**
	 * Complete the transaction represented by this Transaction object.
	 * 
	 * @throws TransactionException
	 * @throws SecurityException
	 * @throws IllegalStateException
	 */
	public void commit() throws TransactionException,SecurityException, IllegalStateException;

	/**
	 * Rollback the transaction represented by this Transaction object.
	 * 
	 * @throws TransactionException
	 */
	public void rollback() throws TransactionException;

	/**
	 * Obtain the status of the transaction associated with the target
	 * Transaction object.
	 * 
	 * @return The transaction status. If no transaction is associated with the
	 *         target object, this method returns the Status.NoTransaction
	 *         value.
	 */
	public int getStatus() throws TransactionException;;

	/**
	 * Modify the transaction associated with the target object such that the
	 * only possible outcome of the transaction is to roll back the transaction.
	 * 
	 */
	public void setRollbackOnly() throws TransactionException;;

}
