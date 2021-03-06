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

/**
 * 
 * @author Yat-ton
 * @version 1.00.000 Sep 2, 2010 3:59:48 PM
 */
public interface Cache {
	/**
	 * 
	 * @param target
	 */
	public void cache(Cacheable target);
	
	/**
	 * Restore object from the cache by key.
	 * 
	 * @param key
	 * @return
	 */
	public <T> T restore(Object key);
	
	/**
	 *  Removes an Object from the Cache.
	 * @param key
	 */
	public void remove(Object key);

	/**
	 * If key of cacheable is effective in the cache.
	 * 
	 * @param key
	 * @return
	 */
	public boolean isAlive(Object key);
}
