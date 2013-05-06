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
package org.canedata.expression;

/**
 * 
 * @author Yat-ton
 * @version 1.00.000 2011-5-4
 */
public interface Operator {
	public static final int EQUALS = 1;

	public static final int NOT_EQUALS = 2;

	public static final int LESSTHAN = 3;

	public static final int LESSTHAN_OR_EQUAL = 4;

	public static final int GREATERTHAN = 5;

	public static final int GREATERTHAN_OR_EQUAL = 6;

	public static final int BETWEEN = 7;

	public static final int NOT_BETWEEN = 8;

	public static final int LIKE = 9;

	public static final int NOT_LIKE = 10;

	public static final int IN = 11;

	public static final int NOT_IN = 12;

	public static final int EMPTY = 13;

	public static final int NOT_EMPTY = 14;

	public static final int NULL = 15;

	public static final int NOT_NULL = 16;

	public static final int MATCH = 17;
	
	public static final int NOT_MATCH = 18;

	public static final int AND = 19;
	
	public static final int AND_EPR = 20;
	
	public static final int OR = 21;
	
	public static final int OR_EPR = 22;
}
