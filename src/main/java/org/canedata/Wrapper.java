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
 * 
 * @author Yat-ton
 * @version 1.00.000 2011-3-8 03:01:21 PM
 */
public interface Wrapper {
	public boolean isWrappedFor(Class<?> iface);

	/**
	 * Returns an object that implements the given interface to allow access to
	 * non-standard methods, or standard methods not exposed by the proxy.
	 * 
	 * @param <T>
	 * @param iface
	 * @return
	 */
	public <T> T unwrap(java.lang.Class<T> iface);
}
