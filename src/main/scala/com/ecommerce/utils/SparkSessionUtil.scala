package com.ecommerce.utils

import org.apache.spark.sql.SparkSession

object SparkSessionUtil {
  val spark = SparkSession
    .builder()
    .appName("Ecommerce pipeline")
    .master("local[*]")
    .getOrCreate()
}
