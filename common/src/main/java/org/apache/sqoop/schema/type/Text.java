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
package org.apache.sqoop.schema.type;

/**
 * String.
 *
 * JDBC Types: char, varchar, nchar, clob
 */
public class Text extends AbstractString {

  public Text() {
  }

  public Text(String name) {
    super(name);
  }

  public Text(String name, Long size) {
    super(name, size);
  }

  public Text(String name, Boolean nullable) {
    super(name, nullable);
  }

  public Text(String name, Boolean nullable, Long size) {
    super(name, nullable, size);
  }

  @Override
  public Type getType() {
    return Type.TEXT;
  }

  @Override
  public String toString() {
    return new StringBuilder("Text{")
      .append(super.toString())
      .append("}")
      .toString();
  }
}
