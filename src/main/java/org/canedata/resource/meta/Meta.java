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
package org.canedata.resource.meta;

import java.util.Map;


/**
 * 
 * @author Yat-ton
 * @version 1.00.000 2010-12-22 22:32:21
 */
public interface Meta {
	public String getName();
	
	public String getLabel();
	
	public Object getAttribute(String name);
	public Map<String, Object> getAttributes();
	public int sequence();
	public String describe();
}
