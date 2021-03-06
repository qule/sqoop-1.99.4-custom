/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sqoop.connector.matcher;

import org.apache.sqoop.common.SqoopException;
import org.apache.sqoop.schema.Schema;

public abstract class Matcher {

  private final Schema fromSchema;
  private final Schema toSchema;

  public Matcher(Schema fromSchema, Schema toSchema) {
    if (fromSchema.isEmpty() && toSchema.isEmpty()) {
      throw new SqoopException(MatcherError.MATCHER_0000, "Neither a FROM or TO schemas been provided.");
    } else if (toSchema.isEmpty()) {
      this.fromSchema = fromSchema;
      this.toSchema = fromSchema;
    } else if (fromSchema.isEmpty()) {
      this.fromSchema = toSchema;
      this.toSchema = toSchema;
    } else {
      this.fromSchema = fromSchema;
      this.toSchema = toSchema;
    }
  }

  /**
   *
   * @param fields
   * @return Return the data in "fields" converted from matching the fromSchema to matching the toSchema.
   * Right not "converted" means re-ordering if needed and handling nulls.
   */
  abstract public Object[] getMatchingData(Object[] fields);

  public Schema getFromSchema() {
    return fromSchema;
  }

  public Schema getToSchema() {
    return toSchema;
  }

  protected boolean isNull(Object value) {
    if (value == null || value.equals("NULL")
        || value.equals("null") || value.equals("'null'")
        || value.equals("")) {
      return true;
    }
    return false;
  }


}
