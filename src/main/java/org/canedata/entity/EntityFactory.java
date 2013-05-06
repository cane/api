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
package org.canedata.entity;

import org.canedata.CaneProvider;
import org.canedata.cache.CacheProvider;
import org.canedata.resource.Resource;

/**
 * <h3>Usage:</h3>
 * <blockquote>
 * <pre>
 * 		CaneProvider provider = ...
 * 		ResourceProvider rp = ...
 * 		EntityFactory factory = provider.getFactory("name", rp);
 * 
 * 		Entity e = factory.get("entity name");
 * 		...
 * </pre>
 * </blockquote>
 * 
 * @author Yat-ton
 * @version 1.00.000 Sep 2, 2010 5:46:45 PM
 */
public interface EntityFactory {
	public String getName();

	/**
	 * Get the entity from factory, by specifying the name of entity.
	 * 
	 * <p>
	 * The name can be name or name with schema. 
	 * </p>
	 * 
	 * <blockauote>
	 * <b>Directly use name: </b>
	 * 
	 * <pre>
	 * get("name");
	 * </pre>
	 * 
	 * <b>Name with schema: </b>
	 * 
	 * <pre>
	 * get("schema.name");
	 * </pre>
	 * </blockquote>
	 * 
	 * <p>
	 * Can use the following two ways to assign a short alias to entity, easy to
	 * join multiple entities.
	 * </p>
	 * 
	 * <blockquote>
	 * <b>Name+space+alias: </b>
	 * 
	 * <pre>
	 * get("tableName a1");
	 * </pre>
	 * 
	 * <b>Name+AS/as+alias: </b>
	 * 
	 * <pre>
	 * get("tableName as a1");
	 * </pre>
	 * 
	 * </blockquote>
	 * 
	 * @param name
	 *            Entity name.
	 * @return
	 */
	public Entity get(String name);

	/**
	 * @see #get(String)
	 * 
	 * @param schema
	 * @param name
	 * @return
	 */
	public Entity get(String schema, String name);

	/**
	 * @see #get(String)
	 * 
	 * @param res
	 * @param name
	 * @return
	 */
	public Entity get(Resource<?> res, String name);

	/**
	 * @see #get(String, String)
	 * 
	 * @param res
	 * @param schema
	 * @param name
	 * @return
	 */
	public Entity get(Resource<? extends Object> res, String schema, String name);

	public CacheProvider getCacheProvider();

	public CaneProvider getProvider();
}
