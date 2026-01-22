package com.ecommerce.ingestion

import com.ecommerce.utils.{SparkSessionUtil, StructSchemaUtil}

object CustomersRawIngestion {
  private val orig_path = "data_source/customers/olist_customers_dataset.csv"
  private val dstn_path = "data/raw/customers/"

  val df_customers = SparkSessionUtil.spark
    .read
    .option("header","true")
    .option("delimiter",",")
    .option("encoding","UTF-8")
    .schema(StructSchemaUtil.customers_schema)
    .csv(orig_path)

  def customersRawIngestion(): Unit = {
    //df_customers.coalesce(1).write.mode("append").csv(dstn_path)
  }

}
