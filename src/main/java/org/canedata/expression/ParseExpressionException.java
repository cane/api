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

import org.canedata.exception.AnalyzeBehaviourException;

/**
 * 
 * @author Yat-ton
 * @version 1.00.000 2011-6-4
 */
public class ParseExpressionException extends AnalyzeBehaviourException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6595207556442171481L;

	/**
	 * 
	 */
	public ParseExpressionException() {
		super();
	}

	/**
	 * @param arg0
	 */
	public ParseExpressionException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public ParseExpressionException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ParseExpressionException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
