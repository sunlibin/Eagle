/*
 *
 *  * Licensed to the Apache Software Foundation (ASF) under one or more
 *  * contributor license agreements.  See the NOTICE file distributed with
 *  * this work for additional information regarding copyright ownership.
 *  * The ASF licenses this file to You under the Apache License, Version 2.0
 *  * (the "License"); you may not use this file except in compliance with
 *  * the License.  You may obtain a copy of the License at
 *  *
 *  *    http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */
package eagle.datastream

trait AbstractStreamProducerGraph {
  def addEdge(from: StreamProducer, to: StreamProducer, streamConnector: StreamConnector)
  def addVertex(producer: StreamProducer)
  def iterator() : Iterator[StreamProducer]
  def isSource(v : StreamProducer) : Boolean
  def outgoingEdgesOf(v : StreamProducer) : scala.collection.mutable.Set[StreamConnector]
  def getNodeByName(name : String) : Option[StreamProducer]
  def incomingVertexOf(v: StreamProducer) : scala.collection.mutable.Set[StreamProducer]
}
