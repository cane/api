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
package org.canedata.resource;

import org.canedata.module.Provider;

/**
 * Provide a method to get resource, What are the resources and how to obtain, decided by the provider.
 * 
 * @author Yat-ton
 * @version 1.00.000 2011-4-21 5:56:45
 */
public interface ResourceProvider extends Provider {
	public Resource<?> getResource();
}
