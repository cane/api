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
package org.canedata.field;

import java.io.InputStream;
import java.io.Reader;
import java.nio.channels.ReadableByteChannel;
import java.util.Date;

import org.canedata.cache.Cacheable;

/**
 * 
 * @author Yat-ton
 * @version 1.00.000 2011-4-27 21:50:30
 */
public interface Fields extends Cacheable {
	public <T> T get(String field);
	
	public boolean contains(String field);
	
	/**
	 * contains the field and value is't null.
	 * @param field
	 * @return
	 */
	public boolean exist(String field);
	
	public char getChar(String field);

	public int getInt(String field);

	public boolean getBoolean(String field);

	public double getDouble(String field);

	public float getFloat(String field);

	public byte getByte(String field);

	public byte[] getBytes(String field);

	public String getString(String field);

	public long getLong(String field);

	public short getShort(String field);
	
	public Date getDate(String field);

	public InputStream getInputStream(String field);

	public Reader getReader(String field);
	
	public ReadableByteChannel getChannel(String field);

	public String[] getFieldNames();

	public ReadableField getField(String name);

	public void reset();
	
}
