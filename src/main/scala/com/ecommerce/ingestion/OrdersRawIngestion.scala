package com.ecommerce.ingestion

import com.ecommerce.utils.SparkSessionUtil

object OrdersRawIngestion {
  private val orig_path = "data_source/orders/olist_orders_dataset.csv"
  private val dstn_path = "/orders/olist_orders_dataset.csv"

  val df_orders = SparkSessionUtil.spark
    .read
    .option("header","true")
    .option("delimiter",",")
    .option("encoding","UTF-8")
    .option("inferSchema","true")
    .csv(orig_path)
}
