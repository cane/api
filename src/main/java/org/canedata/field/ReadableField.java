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

/**
 * 
 * @author Yat-ton
 * @version 1.00.000 2011-5-3
 */
public interface ReadableField extends Field {
	public Object get();

	public char getChar();

	public int getInt();

	public boolean getBoolean();

	public double getDouble();

	public float getFloat();

	public byte getByte();

	public byte[] getBytes();

	public String getString();

	public long getLong();

	public short getShort();
	
	public Date getDate();

	public InputStream getInputStream();

	public Reader getReader();
	
	public ReadableByteChannel getChannel();
}
