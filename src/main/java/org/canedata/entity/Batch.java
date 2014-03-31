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

import java.util.Map;

import org.canedata.expression.Expression;
import org.canedata.field.Field;

/**
 * <blockquote>
 * <b>Batch insert:</b>
 * <pre>
 * e.batch()
 * .put("f", v)
 * .add()
 * .put("f", v2)
 * .add()
 * .create();
 *
 * </pre>
 * </blockquote>
 * <p/>
 * <blockquote>
 * <b>Batch update:</b>
 * <pre>
 * e.batch()
 * .put("f", v).put("f2", v2)
 * .add()
 * .put("f", v).put("f2", v2)
 * .add(e.expr().equals("name", name))
 * .put("f", v)
 * .add(e.expr().equals("name", name1)
 * .update();
 * </pre>
 * </blockquote>
 *
 * <p/>
 *
 * <blockquote>
 * <b>Batch delete:</b>
 * <pre>
 * e.batch()
 * .add(e.expr().equals("name", name))
 * .add(e.expr().equals("age", 19))
 * .delete();
 * </pre>
 *
 * <pre>
 * e.batch().add().delete();//WARNING:  throw java.lang.IllegalAccessException.
 * </pre>
 * </blockquote>
 *
 * <p/>
 *
 * <blockquote>
 * <pre>
 * int changedRows = fields.getInt("_affected");
 * </pre>
 * </blockquote>
 *
 * @author Sun Yat-ton
 * @version 1.00.000 2010-12-2 03:45:34
 */
public interface Batch {
    /**
     * @param field
     * @param value
     * @return Return self.
     */
    public Batch put(String field, Object value);

    /**
     * @param values
     * @return Return self.
     */
    public Batch putAll(Map<String, Object> values);

    /**
     * @return Return new instance of BatchAction.
     */
    public BatchAction add();

    /**
     * Applies to the update, and delete operations,
     * the Parameter will be ignored when creating.
     *
     * @param expr
     * @return
     */
    public BatchAction add(Expression expr);

    /**
     * Clear all of the added item.
     *
     * @return Return self.
     */
    public Batch clear();


    public interface BatchAction<T extends Entity> extends Batch{
        /**
         * If use the method of {@link #add(org.canedata.expression.Expression)},  Expression will be ignored.
         * @return
         */
        public Field create();

        /**
         *
         * @return
         */
        public Field update();

        /**
         *
         * @return
         */
        public Field delete();
    }

}
