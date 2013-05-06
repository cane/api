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
package org.canedata.resource;

import java.util.List;

import org.canedata.Wrapper;
import org.canedata.resource.meta.RepositoryMeta;


/**
 * Wrapper
 * @author Yat-ton
 * @version 1.00.000 2010-12-25 06:45:09
 */
public interface Resource<T> extends Wrapper {
	public String getName();
	
	public String getVersion();
	
	public List<RepositoryMeta> getRepositories();
	
	/**
	 * Get a resource, such as {@link java.sql.Connection}, etc.
	 * @return
	 */
	public T take();
	
	/**
	 * If used connection pool, this method may not be supported.
	 * 
	 * @param args
	 * @return
	 */
	public T take(Object ...args); 
	
	/**
	 * If necessary, this method is an optional implementation.
	 * 
	 * @param exclusive
	 * @return
	 */
	public T take(boolean exclusive);
	
	/**
	 * If used connection pool, this method may not be supported.
	 * @param exclusive
	 * @param args parameters for create resource connection.
	 * @return
	 */
	public T take(boolean exclusive, Object...args);
	
	/**
	 * Take a resource exclusively, equivalent to <code>take(true);</code>.
	 * @see #take(boolean)
	 */
	public T checkout();
	
	public T checkout(Object...args);
	
	/**
	 * Release a resource this method is not necessary.
	 * <b>This method will be called, when the entity closed.</b>
	 * @return return self.
	 */
	public Resource<T> release(Object target);
	
}
