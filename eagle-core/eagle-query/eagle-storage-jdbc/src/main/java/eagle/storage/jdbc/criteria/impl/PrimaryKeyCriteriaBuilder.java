/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eagle.storage.jdbc.criteria.impl;

import eagle.storage.jdbc.JdbcConstants;
import eagle.storage.jdbc.criteria.CriteriaBuilder;
import org.apache.torque.ColumnImpl;
import org.apache.torque.criteria.Criteria;
import org.apache.torque.criteria.Criterion;
import org.apache.torque.criteria.SqlEnum;

import java.util.List;

/**
 * @since 3/30/15
 */
public class PrimaryKeyCriteriaBuilder implements CriteriaBuilder {
    private final List<String> keys;
    private final String tableName;

    public PrimaryKeyCriteriaBuilder(List<String> keys,String tableName){
        this.keys = keys;
        this.tableName = tableName;
    }

    @Override
    public Criteria build() {
        Criteria root = new Criteria();
        for(String key:keys){
            root = root.or(new Criterion(new ColumnImpl(this.tableName, JdbcConstants.ROW_KEY_COLUMN_NAME),key, SqlEnum.EQUAL));
        }
        return root;
    }
}