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
package org.canedata.logging;

/**
 * Adaptive logger wrapped.
 * 
 * @author Yat-ton
 * @version 1.00.000 Sep 2, 2010 5:06:27 PM
 */
public interface Logger {
	public void debug(String msg);

	/**
	 * 
	 * @param format
	 *            "debug {0},{1}"
	 * 
	 * @param args
	 */
	public void debug(String format, Object... args);

	public void debug(Throwable t, String format, Object... args);


	public void info(String msg);

	public void info(String format, Object... args);

	public void info(Throwable t, String format, Object... args);

	
	public void warn(String msg);

	public void warn(String format, Object... args);

	public void warn(Throwable t, String format, Object... args);

	
	public void error(String msg);

	public void error(String format, Object... args);

	public void error(Throwable t, String format, Object... args);

	
	public void trace(String msg);

	public void trace(String format, Object... args);

	public void trace(Throwable t, String format, Object... args);

	public boolean isDebug();
	public boolean isTrace();

}
