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
package org.canedata.cache;

import org.canedata.Wrapper;

import java.io.Serializable;

/**
 * Mark an object can be cached.
 * 
 * @author Yat-ton
 * @version 1.00.000 Sep 2, 2010 4:04:24 PM
 */
public interface Cacheable extends Serializable {
	/**
	 * @return
	 */
	public Object getKey();
	
	/**
	 * If restored from cache.
	 * 
	 * @return
	 */
	public boolean isRestored();
	
	/**
	 * Method can be overloaded, calls this method when the object to be placed in the cache.
	 * @return
	 */
	public Cacheable onCaching();
	
	/**
	 * Call this method when a cached object is wake-up.
	 * 
	 * @return
	 */
	public Cacheable onRestored();
	
	/**
	 * The time when the object cached.
	 * 
	 * @return
	 */
	public long getCacheTime();
	
	abstract public class Adapter implements Cacheable{
		protected boolean isRestored = false;
		protected long cacheTime = System.currentTimeMillis();
		
		public boolean isRestored() {
			return isRestored;
		}

		
		public long getCacheTime() {
			return cacheTime;
		}
		
		public Cacheable onCaching() {
			isRestored = false;
			cacheTime = System.currentTimeMillis();
			
			return this;
		}

		public Cacheable onRestored() {
			isRestored = true;
			
			return this;
		}

	}
}
