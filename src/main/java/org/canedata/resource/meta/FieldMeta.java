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
package org.canedata.resource.meta;

/**
 * 
 * @author Yat-ton
 * @version 1.00.000 2010-12-22
 */
public interface FieldMeta extends Meta {
	public EntityMeta getEntity();
	public int getType();
	public String getTypeName();
	public int getSize();
	public int getDecimalDigits();
	
	public boolean isNullable();
	public boolean isAutoincrement();
	public String getDefault();
	public String getRemarks();
}
