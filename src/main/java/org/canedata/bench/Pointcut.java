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

/**
 * 
 * @author Yat-ton
 * @version 1.00.000 2011-4-22 04:59:10
 */
public interface Pointcut {
	public enum Phase{
		FACTORY, ENTITY, FIELD, EXPRESSION, TRANSACTION, META
	}
	
	public String getName();

	/**
	 * Wrapped the {@link EntityFactory} or {@link Entity} to {@link Bench}.
	 * 
	 * @param target
	 *            Instance of EntityFactory or Entity, etc..
	 * @return an object that implements the interface. May be a proxy for the
	 *         actual implementing object.
	 */
	public <T extends Bench> T wrapped(Object target);
	
	public Phase getPhase();
	public Phase phase();
	
	public BenchProvider getProvider();
}
