/**
 * Copyright 2013 CaneData.org
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

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.canedata.Closeable;
import org.canedata.cache.Cacheable;
import org.canedata.exception.AnalyzeBehaviourException;
import org.canedata.expression.Expression;
import org.canedata.expression.ExpressionBuilder;
import org.canedata.field.Fields;
import org.canedata.field.WritableField;
import org.canedata.ta.Transaction;
import org.canedata.ta.TransactionHolder;

/**
 * 
 * 
 * @author Yat-ton
 * @version 1.00.000 Sep 2, 2010 6:14:30 PM
 */
public interface Entity extends Closeable, Cacheable {
	/**
	 * Get current schema of entity.
	 * 
	 * @return
	 */
	public String getSchema();

	/**
	 * Get Entity name.
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * Get current label of entity.
	 * 
	 * @return
	 */
	public String getLabel();

	/**
	 * {@link #getLabel()}
	 * 
	 * @return
	 */
	public String label();

	/**
	 * Set entity label.
	 * 
	 * @param label
	 * @return
	 */
	public Entity label(String label);

	/**
	 * {@link #label(String)} alias.
	 * 
	 * @see #label(String)
	 * 
	 * @param label
	 * @return
	 */
	public Entity alias(String label);

	// --------------------------------set field value to entity.
	/**
	 * put key/value to entity.
	 * 
	 * @param key
	 *            maybe a column.
	 * @param value
	 * @return Return self.
	 */
	public Entity put(String key, Object value);

	/**
	 * Set all of the mappings from the specified map to this Entity.
	 * 
	 * @param params
	 * @return
	 */
	public Entity putAll(Map<String, Object> params);

	/**
	 * Gets the {@link WritableField} by field for write.
	 * 
	 * @see #put(String, Object)
	 * 
	 * @param field
	 * @return
	 */
	public WritableField field(String field);

	// ----------------------------------------------create
	/**
	 * Can be keys or other arbitrary parameters, and the primary key in the
	 * same order.
	 * 
	 * <strong>Multi-primary key column is not recommended to use.</strong>
	 * 
	 * @param keys
	 * @return Returns the results may contain some useful properties. The
	 *         number of cases only contains the one or more ID field, such as
	 *         generated automatically ID.
	 * 
	 *         More field may be in the context of programming environment.
	 *         <strong>The return value will be overwritten by next create.
	 *         </strong>
	 */
	public Fields create(Serializable... keys);

	/**
	 * 
	 * @see #create(Serializable...)
	 * 
	 * @param keys
	 * @return
	 */
	public Fields create(Map<String, Object> keys);

	/**
	 * This is a convenience method for creating an item if it does not exist.
	 * The Keys is extracted from the data argument and a query-by-id is made on
	 * the database. If a Entity with the same id exists then all of the fields
	 * will be updated by {@link #put(String, Object)}. If the id is null (or 0
	 * or some other default value) or doesn't exist then the object will be
	 * created. This also means that your data item must have an id field
	 * defined.
	 * 
	 * @param keys
	 * @return
	 */
	public Fields createOrUpdate(Serializable... keys);

	/**
	 * @see #createOrUpdate(Serializable...)
	 * 
	 * @param keys
	 * @return
	 */
	public Fields createOrUpdate(Map<String, Object> keys);

	// ----------------------------------------------read and query
	/**
	 * <b>Usage:</b>
	 * 
	 * <pre>
	 * e.projection("t.name as name", "max(t.age) as age").filter(...).group("name").list();
	 * 
	 * e.projection("distinct name", "sum(distinct age) as age").filter(...).group("name").list();
	 * 
	 * e.filter(...).list();
	 * </pre>
	 * 
	 *
	 * @param projections
	 * @return Return itself.
	 */
	public Entity projection(String... projections);

	/**
	 * @see #projection(String...)
	 * 
	 * @param projection
	 * @return Return itself.
	 */
	public Entity select(String... projection);

	/**
	 * <p>
	 * Executable command.
	 * </p>
	 * 
	 * @param keys
	 * @return Return self.
	 */
	public Fields restore(Serializable... keys);

	/**
	 * You can also be used directly method to build by Provider.
	 * 
	 * @return Return Expression Builder.
	 */
	public ExpressionBuilder getExpressionBuilder();

	/**
	 * @see #getExpressionBuilder()
	 * @return Return Expression Builder.
	 */
	public ExpressionBuilder expr();

	/**
	 * @since 0.5
	 * @return
	 */
	public ExpressionBuilder filter();

	/**
	 * To filter data set.
	 * 
	 * @param expr
	 * @return Return self.
	 */
	public Entity filter(Expression expr);

	/**
	 * Sort criteria is ASC.
	 * 
	 * @param orderingTerm
	 * @return Return self.
	 */
	public Entity order(String... orderingTerm);

	/**
	 * Sort criteria is DESC.
	 * 
	 * @param orderingTerm
	 * @return Return self.
	 */
	public Entity orderDESC(String... orderingTerm);

	/**
	 * @see #limit(int, int)
	 * 
	 * @param count
	 * @return Return self.
	 */
	public Entity limit(int count);

	/**
	 * If don't use union, then it is same {@link #list(int, int)}, but if the
	 * {@link #list(int, int)} specifies a new value, were covered by
	 * {@link #list(int, int)}.
	 * 
	 * @param offset
	 * @param count
	 * @return Return self.
	 */
	public Entity limit(int offset, int count);

	/**
	 * Checks whether entity exists by the specified keys.
	 * 
	 * @param keys
	 * @return
	 */
	public boolean exists(Serializable... keys);

	/**
	 * <p>
	 * Executable command.
	 * </p>
	 * 
	 * Only returns the first record of the result set.
	 * 
	 * @see #filter()
	 * 
	 * @return
	 */
	public Fields first();

	/**
	 * <p>
	 * Executable command.
	 * </p>
	 * 
	 * Only returns the first record of the result set.
	 * 
	 * @see #filter()
	 * 
	 * @return
	 */
	public Fields last();

	/**
	 * <p>
	 * Executable command.
	 * </p>
	 * 
	 * @see #filter()
	 * 
	 * @return
	 */
	public List<Fields> list();

	/**
	 * <p>
	 * Executable command.
	 * </p>
	 * 
	 * @see #filter()
	 * 
	 * @param count
	 * @return
	 */
	public List<Fields> list(int count);

	/**
	 * <p>
	 * Executable command.
	 * </p>
	 * 
	 * @see #filter()
	 * 
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<Fields> list(int offset, int count);

	/**
	 * @see #find(Expression, int, int)
	 * 
	 * @param expr
	 * @return
	 */
	public List<Fields> find(Expression expr);

	/**
	 * Executable command.
	 * 
	 * @see #filter()
	 * 
	 * @param expr
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<Fields> find(Expression expr, int offset, int count);

	/**
	 * Such as {@link #first()}.
	 * 
	 * @param expr
	 * @return
	 */
	public Fields findOne(Expression expr);

	/**
	 * Finds the first element in the query and updates it. This method is used
	 * needs to tie in with the method of {@link #put(String, Object)}.
	 * 
	 * @param expr
	 * @return
	 */
	public Fields findOneAndUpdate(Expression expr);

	// -----------------
	/**
	 * 
	 * @param target
	 * @param type
	 * @param on
	 * @return
	 */
	public Entity joinOn(Entity target, Joint type, String on);

	/**
	 * 
	 * @param target
	 * @param type
	 * @param using
	 * @return
	 */
	public Entity joinUsing(Entity target, Joint type, String... using);

	/**
	 * 
	 * @param table
	 * @param type
	 * @param on
	 * @return
	 */
	public Entity joinOn(String table, Joint type, String on);

	/**
	 * 
	 * @param table
	 * @param type
	 * @param using
	 * @return
	 */
	public Entity joinUsing(String table, Joint type, String... using);

	public Entity group(String... by);

	public Entity having(String selection, Object... args);

	// -----------------
	/**
	 * <b>Usage:</b>
	 * 
	 * <pre>
	 * e.union(e.revive("other").projection("f1", "f2", ...));
	 * </pre>
	 * 
	 * @param target
	 * @return
	 */
	public Entity union(Entity target);

	/**
	 * Same union(...).alias(...);
	 * 
	 * @param target
	 * @param alias
	 *            Equivalent with:
	 *            <code>select * from (select ... union select ...) as alias</code>
	 * @return
	 */
	public Entity union(Entity target, String alias);

	/**
	 * @see #union(Entity)
	 * 
	 * @param target
	 * @return
	 */
	public Entity unionAll(Entity target);

	/**
	 * @see #union(Entity, String)
	 * @param target
	 * @param alias
	 * @return
	 */
	public Entity unionAll(Entity target, String alias);

	public Entity except(Entity target);

	public Entity except(Entity target, String alias);

	public Entity exceptAll(Entity target);

	public Entity exceptAll(Entity target, String alias);

	public Entity intersect(Entity target);

	public Entity intersect(Entity target, String alias);

	public Entity intersectAll(Entity target);

	public Entity intersectAll(Entity target, String alias);

	/**
	 * <p>
	 * Executable command.
	 * </p>
	 * 
	 * <p>
	 * Computing function, the assumption is that the operator has to know the
	 * return value represents. Such action can not be grouped, only to return
	 * specific values, such as int, long, double, float, etc. What type of
	 * concrete based on a database table field type.
	 * </p>
	 * 
	 * <p>
	 * <i><b>Note: </b></i> If the operation returns multiple results, the
	 * actual returns only the first result.
	 * </p>
	 * 
	 * <b>Usage:</b>
	 * 
	 * <pre>
	 * e.filter(...).max("age") -&gt; return int for age.
	 * 
	 * e.joinOn("class as c", Joint.LEFT, "e.id = c.school").filter(...).max("students")
	 * </pre>
	 * 
	 */
	public Number max(String projection);

	/**
	 * <p>
	 * Executable command.
	 * </p>
	 * 
	 * <p>
	 * <i><b>Note: </b></i> If the operation returns multiple results, the
	 * actual returns only the first result.
	 * </p>
	 * 
	 * @see #max(String)
	 * 
	 * @param projection
	 * @return
	 */
	public Number min(String projection);

	/**
	 * <p>
	 * Executable command.
	 * </p>
	 * 
	 * <p>
	 * <i><b>Note: </b></i> If the operation returns multiple results, the
	 * actual returns only the first result.
	 * </p>
	 * 
	 * <b>Usage:</b>
	 * 
	 * <pre>
	 * e.filter(...).sum("students")
	 * 
	 * e.filter(...).sum("distinct students")
	 * </pre>
	 * 
	 *
	 * @see #max(String)
	 * 
	 * @param projection
	 * @return
	 */
	public Number sum(String projection);

	/**
	 * <p>
	 * Executable command.
	 * </p>
	 * 
	 * <p>
	 * <i><b>Note: </b></i> If the operation returns multiple results, the
	 * actual returns only the first result.
	 * </p>
	 * 
	 * <b>Usage:</b>
     * <pre>
	 * e.filter(...).avg("age")
	 * 
	 * e.filter(...).avg("distinct age")
	 *</pre>
     *
	 * @see #max(String)
	 * 
	 * @param projection
	 * @return
	 */
	public Number avg(String projection);

	/**
	 * <p>
	 * Executable command.
	 * </p>
	 * 
	 * <p>
	 * <i><b>Note: </b></i> If the operation returns multiple results, the
	 * actual returns only the first result.
	 * </p>
	 * 
	 * <b>Usage:</b>
	 * 
	 * <pre>
	 * e.filter(...).concat(":", "name", "phone") -&gt; return Yat-ton:1233333
	 * </pre>
	 * 
	 *
	 * @param projections
	 * @return
	 */
	public String concat(String delimiter, String... projections);

	/**
	 * @see #count(String)
	 * @return
	 */
	public Number count();

	/**
	 * <p>
	 * Executable command.
	 * </p>
	 * 
	 * <p>
	 * <i><b>Note: </b></i> If the operation returns multiple results, the
	 * actual returns only the first result.
	 * </p>
	 * 
	 * <b>Usage:</b>
	 * 
	 * <pre>
	 * e.filter(...).count("*");
	 * e.filter(...).count("distinct name")
	 * e.filter(...).count("distinct name,age")
	 * </pre>
	 * 
	 *
	 * @param projection
	 * @return
	 */
	public Number count(String projection);

	/**
	 * @see #filter(Expression)
	 * 
	 * @param projection
	 * @return
	 */
	public List<Fields> distinct(String projection);

	public List<Fields> distinct(String projection, Expression exp);

	// ----------------------------------------------update
	/**
	 * <p>
	 * Executable command.
	 * </p>
	 * 
	 * @see #put(String, Object)
	 */
	public long update(Serializable... keys);

	/**
	 * <p>
	 * Executable command.
	 * </p>
	 * 
	 * @see #filter(Expression)
	 * 
	 * @param expr
	 * @return
	 */
	public long updateRange(Expression expr);

	// ----------------------------------------------delete
	/**
	 * <p>
	 * Executable command.
	 * </p>
	 */
	public long delete(Serializable... keys);

	/**
	 * <p>
	 * Executable command.
	 * </p>
	 * 
	 * @param expr
	 * @return
	 */
	public long deleteRange(Expression expr);

	// ----------------------------------------------batch
	/**
	 * Marked as batch operations.
	 * 
	 * <b>Automatically generated SQL pattern, based on puted
	 * fields. Such as:</b>
	 * 
	 * <pre>
	 * b.put(&quot;name&quot;, &quot;Yatton&quot;).put(&quot;gender&quot;, &quot;man&quot;).add().put(&quot;name&quot;, &quot;Mr. Sun&quot;)
	 * 		.put(&quot;gender&quot;, &quot;man&quot;).add().put(&quot;name&quot;, &quot;Cane&quot;).put(&quot;gender&quot;, &quot;man&quot;)
	 * 		.insert();
	 * </pre>
	 * 
	 * <b>Generated SQL: </b>
	 * 
	 * <pre>
	 * insert into b(name, gender, desc) values(?, ?, ?)
	 * </pre>
	 * 
	 *
	 * @return
	 */
	public Batch batch();

	// ----------------------------------------------transaction
	/**
	 * Open transaction on entity. 
	 *
	 * The transaction is a related
	 * thread in the same {@link EntityFactory}, then the same thread is always
	 * on the same transaction object. 
	 *
	 * @return
	 */
	public Transaction openTransaction();

	/**
	 * @see #openTransaction()
	 * 
	 * @return
	 */
	public Entity transaction();

	/**
	 * @see #openTransaction()
	 * 
	 * @param holder
	 *            holder of transaction.
	 * @return
	 */
	public Entity transaction(TransactionHolder holder);

	/**
	 * see javax.transaction.Transaction#rollback()
	 * 
	 * @return
	 */
	public Entity rollback();

	/**
	 * see javax.transaction.Transaction#commit()
	 * 
	 * @return
	 */
	public Entity commit();

	/**
	 * <p>
	 * End transaction if the transaction opened. If the transaction is not
	 * open, throw an exception(
	 * javax.transaction.TransactionRequiredException).
	 * </p>
	 * <h3>Such as:</h3>
	 * 
	 * <pre>
	 * <code>
	 * e.transaction()...put(...).end(value == 1);
	 * </code>
	 * </pre>
	 * 
	 * @param expr
	 *            commit transaction if true, or rollback transaction if false.
	 * @return Return current entity.
	 */
	public Entity end(boolean expr);

	// ----------------------------------------------procedure
	/**
	 * @see Command
	 * 
	 * @param cmd
	 * @param args
	 * @return
	 */
	public <D> D execute(Command cmd, Object... args);

	public <D> D call(Command cmd, Object... args);

	/**
	 * On the function of some operations to provide additional options.
	 * 
	 * @param key
	 *            key of option.
	 * @param values
	 *            values of option.
	 * @return return itself of Entity.
	 */
	public Entity opt(String key, Object... values);

	/**
	 * @see #relate(String, String)
	 * 
	 * @param name
	 * @return Return a new Entity by name.
	 */
	public Entity relate(String name);

	/**
	 * Tied a new entity with the current entity. This means that two entities
	 * share the same <code>Connection</code> and
	 * {@link org.canedata.ta.Transaction}.
	 * 
	 * @param schema
	 * @param name
	 * @return Return a new Entity by name.
	 */
	public Entity relate(String schema, String name);

	/**
	 * Re-activate the entity, to regain the ability to operate the database.
	 * 
	 * @return Return self.
	 */
	public Entity revive();

}
