package prac.dec27

/** Licensed to the Apache Software Foundation (ASF) under one or more
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

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.SparkContext._

object ConfigCheck {
  /** Usage: HdfsTest [file] */
  def main(args: Array[String]) {
   println(args.length)
    
    if (args.length < 2) {
      System.err.println("Usage: ConfigCheck  <key> <value>")
      // This is non zero value which is the cause of fatal error
      System.exit(1)
    }
    val sparkConf = new SparkConf().setAppName("ConfigCheck")
    
    val Array(key, value) = args 
    
    val rV = sparkConf.get(key)
    
    if (rV == value) {
      val sc = new SparkContext(sparkConf)
      val rdd = sc.parallelize(List(1, 2, 3))
      // scalastyle:off println
      rdd.collect.foreach(println)
      // scalastyle:on println
      sc.stop()
    } else {
      System.err.println(s"Key: $key value: $rV expected $value")
      System.exit(1)
    }
  
  }
}
