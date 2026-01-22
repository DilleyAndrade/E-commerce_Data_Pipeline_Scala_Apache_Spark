package com.ecommerce.ingestion

import com.ecommerce.utils.{SparkSessionUtil, StructSchemaUtil}
import java.time.LocalDate

object CustomersRawIngestion {

  val actual_data = LocalDate.now()
  private val orig_path = "data_source/customers/olist_customers_dataset.csv"
  private val dstn_path = s"data/raw/customers/customers-${actual_data}"

  val df_customers = SparkSessionUtil.spark
    .read
    .option("header","true")
    .option("delimiter",",")
    .option("encoding","UTF-8")
    .schema(StructSchemaUtil.customers_schema)
    .csv(orig_path)

  def customersRawIngestion(): Unit = {
    df_customers
      .coalesce(1)
      .write
      .mode("append")
      .option("compression", "snappy")
      .parquet(dstn_path)

  }
}
