package com.ecommerce.ingestion

import com.ecommerce.utils.{SparkSessionUtil, StructSchemaUtil}

object OrderPaymentsRawIngestion {
  private val orig_path = "data_source/order_payments/olist_order_payments_dataset.csv"
  private val dstn_path = "data/raw/order_payments/"

  val df_order_payments = SparkSessionUtil.spark
    .read
    .option("header","true")
    .option("delimiter",",")
    .option("encoding","UTF-8")
    .schema(StructSchemaUtil.order_payments_schema)
    .csv(orig_path)

  def orderPaymentsRawIngestion(): Unit = {
    //df_order_payments.coalesce(1).write.mode("append").csv(dstn_path)
  }

}
