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
package org.canedata.entity;

/**
 * 
 * @author Yat-ton
 * @version 1.00.000 2011-7-29
 */
public enum Joint {
	INNER("INNER"), 
	CROSS("CROSS"), 
	LEFT("LEFT"), 
	LEFT_OUTER("LEFT OUTER"), 
	NATURAL_LEFT("NATURAL LEFT"), 
	NATURAL_LEFT_OUTER("NATURAL LEFT OUTER"), 
	RIGHT("RIGHT"), 
	RIGHT_OUTER("RIGHT OUTER"), 
	NATURAL_RIGHT("NATURAL RIGHT"), 
	NATURAL_RIGHT_OUTER("NATURAL RIGHT OUTER"),
	UNION("UNION");

	private Joint(String s) {
		type = s;
	}

	public String getType() {
		return type;
	}

	private String type;
}
