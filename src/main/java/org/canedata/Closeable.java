/**
 * Copyright 2013 CaneData.org
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
package org.canedata;

/**
 * Mark a resource can be closed.
 * 
 * @author Yat-ton
 * @version 1.00.000 2010-11-1
 */
public interface Closeable {
	/**
	 * Close connection, release resources, reset state.
	 */
	public void close();
	
	/**
	 * Determine if the resource has been closed.
	 * 
	 * @return Returns true if the resource has been closed.
	 */
	public boolean hasClosed();
}
