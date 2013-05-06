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
package org.canedata.expression.shield;


/**
 * 
 * @author Yat-ton
 * @version 1.00.000 2011-4-27 23:15:39
 */
public interface ExpressionB {
	//--return: and,or  expr
	public ExpressionA equals(String field, Object value);
	public ExpressionA notEquals(String field, Object value);
	
	public ExpressionA lessThan(String field, Object value);
	public ExpressionA lessThanOrEqual(String field, Object value);
	
	public ExpressionA greaterThan(String field, Object value);
	public ExpressionA greaterThanOrEqual(String field, Object value);
	
	public ExpressionA between(String field, Object lo, Object hi);
	public ExpressionA notBetween(String field, Object lo, Object hi);
	
	public ExpressionA like(String field, Object value);
	public ExpressionA notLike(String field, Object value);
	
	public ExpressionA in(String field, Object... values);
	public ExpressionA notIn(String field, Object... values);
	
	public ExpressionA isEmpty(String field);
	public ExpressionA isNotEmpty(String field);
	
	public ExpressionA isNull(String field);
	public ExpressionA isNotNull(String field);
	
	public ExpressionA match(String field, String regex);
	public ExpressionA notMatch(String field, String regex);
}
