package com.ecommerce.utils

import org.apache.spark.sql.{DataFrame}
import org.apache.spark.sql.types.StructType


object CsvReaderUtil {

  def loadTable(delimiter:String, schemaName:StructType, csvPath:String): DataFrame = {
    SparkSessionUtil.spark.read
      .option("header","true")
      .option("delimiter",delimiter)
      .option("encoding","UTF-8")
      .schema(schemaName)
      .csv(csvPath)
  }

}
