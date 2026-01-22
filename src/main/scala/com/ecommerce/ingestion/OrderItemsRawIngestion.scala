package com.ecommerce.ingestion

import com.ecommerce.utils.{SparkSessionUtil, StructSchemaUtil}
import java.time.LocalDate

object OrderItemsRawIngestion {

  val actual_data = LocalDate.now()
  private val orig_path = "data_source/order_items/olist_order_items_dataset.csv"
  private val dstn_path = s"data/raw/order_items/order_items-${actual_data}"

  val df_order_items = SparkSessionUtil.spark
    .read
    .option("header","true")
    .option("delimiter",",")
    .option("encoding","UTF-8")
    .schema(StructSchemaUtil.order_items_schema)
    .csv(orig_path)

  def orderItemsRawIngestion(): Unit = {
    df_order_items
      .coalesce(1)
      .write
      .mode("append")
      .option("compression", "snappy")
      .parquet(dstn_path)
  }

}
