package com.ecommerce.ingestion

import com.ecommerce.utils.{SparkSessionUtil, StructSchemaUtil}
import java.time.LocalDate

object OrdersRawIngestion {

  val actual_data = LocalDate.now()
  private val orig_path = "data_source/orders/olist_orders_dataset.csv"
  private val dstn_path = s"data/raw/orders/orders-${actual_data}"

  val df_orders = SparkSessionUtil.spark
    .read
    .option("header","true")
    .option("delimiter",",")
    .option("encoding","UTF-8")
    .schema(StructSchemaUtil.orders_schema)
    .csv(orig_path)

  def ordersRawIngestion(): Unit = {
    df_orders
      .coalesce(1)
      .write
      .mode("append")
      .option("compression", "snappy")
      .parquet(dstn_path)

  }
}
