package prac.dec27

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.SparkContext._

object testing {
   def main(args : Array[String]):Unit = { 
     type ParameterMap = Map[String, Any]  
  val defaultParams: ParameterMap = Map(
    "readBufferSize"        -> 1024,
    "defaultFilePermission" -> "drwxrwx---"
  )
     /*
     println(defaultParams.get("readBufferSize").get.toString().toInt)
     println(defaultParams.get("defaultFilePermission").get.toString())
     */
     defaultParams.foreach(println)
  }
  
}

