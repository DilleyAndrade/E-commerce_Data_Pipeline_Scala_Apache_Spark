package com.ecommerce.ingestion

import com.ecommerce.utils.{SparkSessionUtil, StructSchemaUtil}

object CustomerRawIngestion {
  private val orig_path = "data_source/customers/olist_customers_dataset.csv"
  private val dstn_path = "/customers/"

  val df_customers = SparkSessionUtil.spark
    .read
    .option("header","true")
    .option("delimiter",",")
    .option("encoding","UTF-8")
    .option("inferSchema","true")
    .schema(StructSchemaUtil.customers_schema)
    .csv(orig_path)

  def customersRawIngestion(): Unit = {
    //df_customers.coalesce(1).write.mode("append").csv(dstn_path)
  }

}
