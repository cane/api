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
package org.canedata;

import org.canedata.bench.Bench;
import org.canedata.bench.BenchProvider;
import org.canedata.cache.CacheProvider;
import org.canedata.entity.EntityFactory;
import org.canedata.module.Module;
import org.canedata.resource.ResourceProvider;


/**
 * <p>
 * Entrance to use the cane.
 * </p>
 * 
 * Provider provides the operational capability of the corresponding data source for Cane, 
 * such as: MongoProvider provide the ability to operate on MongoDB.
 * 
 * <blockquote>
 * <b>Usage:</b>
 * <pre>
 * 		CaneProvider provider = ...
 * 		ResourceProvider rp = ...
 * 		EntityFactory factory = provider.getFactory("name", rp);
 * 
 * 		...
 * </pre>
 * </blockquote>
 * 
 * <blockquote>
 * <b>Usage for cache:</b>
 * <blockquote>
 * <pre>
 * 		CaneProvider provider = ...
 * 		ResourceProvider rp = ...
 * 		CacheProvider cp = ...
 * 		EntityFactory factory = provider.getFactory("name", rp, cp);
 * 
 * 		...
 * </pre>
 * </blockquote>
 * 
 * <blockquote>
 * <b>Usage for bench:</b>
 * <pre>
 * 		CaneProvider provider = ...
 * 		ResourceProvider rp = ...
 * 		CacheProvider cp = ...
 * 		BenchProvider bp = ...
 * 		JPABench bench = provider.getFactory("name", rp, cp, bp);
 * 
 * 		...
 * </pre>
 * </blockquote>
 * 
 * @author Yat-ton
 * @version 1.00.000 Sep 2, 2010 11:14:03 PM
 */
public interface CaneProvider extends Module {
	
	public EntityFactory getFactory(String name, ResourceProvider resourceProvider);

	public EntityFactory getFactory(String name, ResourceProvider resourceProvider, CacheProvider cache);
	
	public <B extends Bench> B getFactory(String name, ResourceProvider resourceProvider, BenchProvider benchProvider);

	public <B extends Bench> B getFactory(String name, ResourceProvider resourceProvider, CacheProvider cache, BenchProvider benchProvider);
}
