package com.ecommerce.ingestion

import com.ecommerce.utils.{SparkSessionUtil, StructSchemaUtil}

object OrdersRawIngestion {
  private val orig_path = "data_source/orders/olist_orders_dataset.csv"
  private val dstn_path = "/orders/"

  val df_orders = SparkSessionUtil.spark
    .read
    .option("header","true")
    .option("delimiter",",")
    .option("encoding","UTF-8")
    .option("inferSchema","true")
    .schema(StructSchemaUtil.orders_schema)
    .csv(orig_path)

  def ordersRawIngestion(): Unit = {
    //df_orders.coalesce(1).write.mode("append").csv(dstn_path)
  }

}
