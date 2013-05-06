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
package org.canedata.module;

import java.util.Map;

import org.canedata.bench.BenchProvider;
import org.canedata.cache.CacheProvider;

/**
 * Module provides extensions for Cane, including {@link CacheProvider}, {@link BenchProvider}.
 * @author Yat-ton
 * @version 1.00.000 2011-4-18 06:48:59
 */
public interface Module {
	/**
	 * Get the name of factory provider.
	 * 
	 * @return
	 */
	public String getName();
	
	/**
	 * Get the factory provider vendor.
	 * 
	 * @return
	 */
	public String getVendor();
	
	/**
	 * Get the provider version of vendor.
	 * 
	 * @return
	 */
	public int getVersion();
	
	/**
	 * Get more additional information.
	 * <h3>Such as:</h3>
	 * copyright, site of vendor
	 * 
	 * @return
	 */
	public Map<String, Object> getExtras();
	
	/**
	 * @see #getExtras()
	 * 
	 * @param key
	 * @return
	 */
	public Object getExtra(String key);
}
