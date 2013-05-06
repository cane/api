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

import java.io.OutputStream;
import java.io.Writer;
import java.nio.channels.WritableByteChannel;

import org.canedata.entity.Entity;

/**
 * 
 * @author Yat-ton
 * @version 1.00.000 2011-5-3
 */
public interface WritableField extends Field {
	public Entity set(Object val);

	public Entity set(char val);

	public Entity set(String val);

	public Entity set(int val);

	public Entity set(double val);

	public Entity set(float val);

	public Entity set(boolean val);

	public Entity set(byte val);

	public Entity set(byte[] vals);

	public Entity set(long val);

	public Entity set(short val);

	public OutputStream getOutputStream();

	public Writer getWriter();
	
	public WritableByteChannel getChannel();
}
