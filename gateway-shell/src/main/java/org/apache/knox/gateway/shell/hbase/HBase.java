/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.knox.gateway.shell.hbase;

import org.apache.knox.gateway.shell.KnoxSession;
import org.apache.knox.gateway.shell.hbase.table.Table;

public class HBase {

  public static final String SERVICE_PATH = "/hbase";

  private KnoxSession session;

  public HBase( KnoxSession session ) {
    this.session = session;
  }

  public static HBase session( KnoxSession session ) {
    HBase hbase = new HBase( session );
    return hbase;
  }

  public SystemVersion.Request systemVersion() {
    return new SystemVersion.Request( session );
  }

  public ClusterVersion.Request clusterVersion() {
    return new ClusterVersion.Request( session );
  }

  public Status.Request status() {
    return new Status.Request( session );
  }

  public Table table( String name ) {
    return new Table( name ).session( session );
  }

  public Table table() {
    return new Table( null ).session( session );
  }
}
