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
package org.canedata.bench;

import org.canedata.entity.EntityFactory;
import org.canedata.module.Module;

/**
 * Allows the end user to redefine the operation process, methods, and the API definition. 
 * Can also be extended Cane based on Bench function, 
 * such as providing JPA support, AOP, Fine-grained data access control, 
 * API classification, flatten, etc.
 * 
 * @author Yat-ton
 * @version 1.00.000 2011-4-22 05:29:10
 */
public interface BenchProvider extends Module {
	/**
	 * Pointcut of {@link EntityFactory} is required.
	 * 
	 * @param phase
	 * @return
	 */
	public Pointcut getPointcut(Pointcut.Phase phase);
}
