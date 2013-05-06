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

import org.canedata.CaneProvider;
import org.canedata.bench.BenchProvider;
import org.canedata.cache.CacheProvider;

/**
 * Provider is implemented functions that can be replaced,  including {@link ResourceProvider}, {@link CaneProvider}, {@link CacheProvider}, {@link BenchProvider}.
 * 
 * @author Yat-ton
 * @version 1.00.000 2011-4-22 05:26:07
 */
public interface Provider extends Module {

}
