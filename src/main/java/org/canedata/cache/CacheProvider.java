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

import java.util.Map;

import org.canedata.module.Provider;

/**
 * Supported cache manager implemented.
 * 
 * @author Yat-ton
 * @version 1.00.000 Sep 2, 2010 4:10:30 PM
 */
public interface CacheProvider extends Provider {
	/**
	 * 
	 * @param schema Used to cache partitions or implement different strategies.
	 * @return
	 */
	public Cache getCache(String schema);
	
	/**
	 * 
	 * @param schema Used to cache partitions or implement different strategies.
	 * @param strategies For different cache implementation is optional.
	 * @return
	 */
	public Cache getCache(String schema, Map<String, Object> strategies);
}
